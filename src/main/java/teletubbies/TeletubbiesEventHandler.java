package teletubbies;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.mojang.serialization.Codec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import teletubbies.capabilities.IJumpCapability;
import teletubbies.capabilities.JumpProvider;
import teletubbies.client.audio.PoScooterTickableSound;
import teletubbies.client.renderer.environment.BabyFaceRenderer;
import teletubbies.config.Config;
import teletubbies.entity.ai.goal.EatFullGrassGoal;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TeletubbyEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;
import teletubbies.entity.vehicle.PoScooterEntity;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesConfiguredFeatures;
import teletubbies.init.TeletubbiesConfiguredStructures;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesStructures;
import teletubbies.item.LaaLaaBallItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
public class TeletubbiesEventHandler {
	
	@SubscribeEvent
	public static void registerCapabilities(final RegisterCapabilitiesEvent event) {
		event.register(IJumpCapability.class);
	}
	
	// Temporary until ToolActions.HOE_TILL works
	@SubscribeEvent
	public static void hoeEvent(UseHoeEvent event) {
		Level level = event.getContext().getLevel();
		BlockPos pos = event.getContext().getClickedPos();
		
		if (level.getBlockState(pos).is(TeletubbiesBlocks.FULL_GRASS.get()) ) {
			level.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), 0);
			event.setResult(Result.ALLOW);
		}
	}

	@SubscribeEvent
	public static void attachtCapabilityEntity(AttachCapabilitiesEvent<Entity> event) {		
		if(event.getObject() instanceof Player) {
			event.addCapability(new ResourceLocation(Teletubbies.MODID, "capability.jump"), new JumpProvider());
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void setSkyRenderer(EntityJoinWorldEvent event) {
		if (event.getEntity().equals(Minecraft.getInstance().player) && event.getWorld().isClientSide() && event.getWorld().dimension().equals(Level.OVERWORLD) && Config.CLIENT.REPLACE_SUN.get()) {
			DimensionSpecialEffects de = DimensionSpecialEffects.forType(event.getWorld().dimensionType());
			ISkyRenderHandler renderer = new BabyFaceRenderer();
			de.setSkyRenderHandler(renderer);
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void joinClientWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundManager().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity()));
		}
	}
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof Player) {
			Player player = (Player) event.getEntityLiving();
						
			LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getDirection());
			cap.ifPresent(c -> {
				float fallDistance = c.fallDistance();
				
				int ticks = c.ticksOnGround();
				
				if(player.isOnGround() && ticks < 50) {
					c.setTicksOnGround(ticks + 1);
				}
				if(!player.isOnGround() && ticks != 0) {
					c.setTicksOnGround(0);
				}
				if(player.fallDistance > fallDistance) {
					c.setFallDistance(player.fallDistance);
				}
				
				if (player.getMainHandItem() != null && player.getMainHandItem().getItem() instanceof LaaLaaBallItem
						|| player.getOffhandItem() != null && player.getOffhandItem().getItem() instanceof LaaLaaBallItem) {
					if (c.canJump(player) && fallDistance >= 10) {
						LaaLaaBallItem.jump(player, true);
					}
				}

				if(player.isOnGround()) {
					c.setFallDistance(0);
				}
				if(player.isInWater() || player.isInLava()) {
					c.setFallDistance(0);
				}
			});
		}
	}
	
	@SubscribeEvent
	public static void fallEvent(LivingFallEvent event) {
		if(event.getEntityLiving() instanceof Player) {
			Player player = (Player) event.getEntityLiving();
			if(player.getMainHandItem() != null) {
				if(player.getMainHandItem().getItem() instanceof LaaLaaBallItem) {
					event.setCanceled(true);
				}
			}
			if(player.getOffhandItem() != null) {
				if(player.getOffhandItem().getItem() instanceof LaaLaaBallItem) {
					event.setCanceled(true);
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void updateRidden(PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.player instanceof LocalPlayer) {
			LocalPlayer player = (LocalPlayer) event.player;
			if (player.getVehicle() instanceof PoScooterEntity) {
				PoScooterEntity scooter = (PoScooterEntity) player.getVehicle();
				scooter.updateInputs(player.input.left, player.input.right, player.input.up, player.input.down);
			}
		}
	}
	
	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}
		
		if (event.getEntity() instanceof Sheep) {
			Sheep sheep = (Sheep) event.getEntity();
			sheep.goalSelector.addGoal(5, new EatFullGrassGoal(sheep));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onLivingDeathEvent(LivingDeathEvent event) {
		DamageSource damageSource = (DamageSource) event.getSource();
		Level world = event.getEntityLiving().level;

		if (!world.isClientSide) {
			if (damageSource.getDirectEntity() instanceof Zombie) {
				if (event.getEntity() instanceof TeletubbyEntity && world.random.nextInt(100) < Config.COMMON.TRANSFORMATION_PROBABILITY.get()) {
					TeletubbyEntity teletubby = (TeletubbyEntity) event.getEntityLiving();
					teletubby.transferToZombie();
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void biomeLoading(final BiomeLoadingEvent event) {
		if (event.getCategory() == BiomeCategory.PLAINS) {
			if (Config.COMMON.VOICE_TRUMPET_CHANCE.get() != 0)
				event.getGeneration().addFeature(Decoration.LOCAL_MODIFICATIONS, TeletubbiesConfiguredFeatures.VOICE_TRUMPET_PLACED_FEATURE);
		}
	}
	
	// https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.18.x-Forge-Jigsaw/src/main/java/com/telepathicgrunt/structuretutorial/StructureTutorialMain.java
    private static Method GETCODEC_METHOD;
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void addDimensionalSpacing(final WorldEvent.Load event) {
		if (event.getWorld() instanceof ServerLevel serverLevel) {

            ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();
            if (chunkGenerator instanceof FlatLevelSource && serverLevel.dimension().equals(Level.OVERWORLD)) {
                return;
            }
            StructureSettings worldStructureConfig = chunkGenerator.getSettings();

            //////////// BIOME BASED STRUCTURE SPAWNING ////////////
            /*
             * NOTE: BiomeLoadingEvent from Forge API does not work with structures anymore.
             * Instead, we will use the below to add our structure to overworld biomes.
             * Remember, this is temporary until Forge API finds a better solution for adding structures to biomes.
             */

            // Create a mutable map we will use for easier adding to biomes
            HashMap<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap = new HashMap<>();

            // Add the resourcekey of all biomes that this Configured Structure can spawn in.
            for(Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet()) {
                // Skip all ocean, end, nether, and none category biomes.
                // You can do checks for other traits that the biome has.
                Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                if(biomeCategory != Biome.BiomeCategory.OCEAN && biomeCategory != Biome.BiomeCategory.THEEND && biomeCategory != Biome.BiomeCategory.NETHER && biomeCategory != Biome.BiomeCategory.NONE) {
                    associateBiomeToConfiguredStructure(STStructureToMultiMap, TeletubbiesConfiguredStructures.DOME_CONFIGURED_STRUCTURE, biomeEntry.getKey());
                }
            }

            // Alternative way to add our structures to a fixed set of biomes by creating a set of biome resource keys.
            // To create a custom resource key that points to your own biome, do this:
            // ResourceKey.of(Registry.BIOME_REGISTRY, new ResourceLocation("modid", "custom_biome"))
//            ImmutableSet<ResourceKey<Biome>> overworldBiomes = ImmutableSet.<ResourceKey<Biome>>builder()
//                    .add(Biomes.FOREST)
//                    .add(Biomes.MEADOW)
//                    .add(Biomes.PLAINS)
//                    .add(Biomes.SAVANNA)
//                    .add(Biomes.SNOWY_PLAINS)
//                    .add(Biomes.SWAMP)
//                    .add(Biomes.SUNFLOWER_PLAINS)
//                    .add(Biomes.TAIGA)
//                    .build();
//            overworldBiomes.forEach(biomeKey -> associateBiomeToConfiguredStructure(STStructureToMultiMap, STConfiguredStructures.CONFIGURED_RUN_DOWN_HOUSE, biomeKey));

            // Grab the map that holds what ConfigureStructures a structure has and what biomes it can spawn in.
            // Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
            ImmutableMap.Builder<StructureFeature<?>, ImmutableMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> tempStructureToMultiMap = ImmutableMap.builder();
            worldStructureConfig.configuredStructures.entrySet().stream().filter(entry -> !STStructureToMultiMap.containsKey(entry.getKey())).forEach(tempStructureToMultiMap::put);

            // Add our structures to the structure map/multimap and set the world to use this combined map/multimap.
            STStructureToMultiMap.forEach((key, value) -> tempStructureToMultiMap.put(key, ImmutableMultimap.copyOf(value)));

            // Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
            worldStructureConfig.configuredStructures = tempStructureToMultiMap.build();


            //////////// DIMENSION BASED STRUCTURE SPAWNING (OPTIONAL) ////////////
            /*
             * Skip Terraforged's chunk generator as they are a special case of a mod locking down their chunkgenerator.
             * They will handle your structure spacing for your if you add to BuiltinRegistries.NOISE_GENERATOR_SETTINGS in your structure's registration.
             * This here is done with reflection as this tutorial is not about setting up and using Mixins.
             * If you are using mixins, you can call the codec method with an invoker mixin instead of using reflection.
             */
            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "codec");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(chunkGenerator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch (Exception e) {}

            /*
             * putIfAbsent so people can override the spacing with dimension datapacks themselves if they wish to customize spacing more precisely per dimension.
             * Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
             *
             * NOTE: if you add per-dimension spacing configs, you can't use putIfAbsent as BuiltinRegistries.NOISE_GENERATOR_SETTINGS in FMLCommonSetupEvent
             * already added your default structure spacing to some dimensions. You would need to override the spacing with .put(...)
             * And if you want to do dimension blacklisting, you need to remove the spacing entry entirely from the map below to prevent generation safely.
             */
            Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(worldStructureConfig.structureConfig());
            tempMap.putIfAbsent(TeletubbiesStructures.DOME_STRUCTURE_FEATURE.get(), StructureSettings.DEFAULTS.get(TeletubbiesStructures.DOME_STRUCTURE_FEATURE.get()));
            worldStructureConfig.structureConfig = tempMap;
			
            

		}
	}
	
	/**
     * Helper method that handles setting up the map to multimap relationship to help prevent issues.
     */
    private static void associateBiomeToConfiguredStructure(Map<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap, ConfiguredStructureFeature<?, ?> configuredStructureFeature, ResourceKey<Biome> biomeRegistryKey) {
        STStructureToMultiMap.putIfAbsent(configuredStructureFeature.feature, HashMultimap.create());
        HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>> configuredStructureToBiomeMultiMap = STStructureToMultiMap.get(configuredStructureFeature.feature);
        if(!configuredStructureToBiomeMultiMap.containsValue(biomeRegistryKey)) {
        	configuredStructureToBiomeMultiMap.put(configuredStructureFeature, biomeRegistryKey);
        }
    }
	
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TeletubbiesBus {
		@OnlyIn(Dist.CLIENT)
	    @SubscribeEvent
	    public static void BlockColorHandler(final ColorHandlerEvent.Block event) {
			if (TeletubbiesBlocks.FULL_GRASS.get() != null) {
	        event.getBlockColors().register((state, reader, pos, tint) -> reader != null
	                && pos != null ? BiomeColors.getAverageGrassColor(reader, pos)
	                : GrassColor.get(0.5D, 1.0D), TeletubbiesBlocks.FULL_GRASS.get());
			}
	    }
	    
	    @OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void ItemColorHandler(final ColorHandlerEvent.Item event) {
	    	if (TeletubbiesItems.FULL_GRASS.get() != null) {
				final ItemColor colorHandler = (stack, tint) -> {
					final BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
					return event.getBlockColors().getColor(state, null, null, tint);
				};
				event.getItemColors().register(colorHandler, TeletubbiesItems.FULL_GRASS.get());
	    	}
		}
	}
}
