package teletubbies.entity.baby;

import java.util.Random;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap.MutableAttribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;

public class TiddlytubbyEntity extends CreatureEntity {
	
	public TiddlytubbyEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	public static boolean canSpawn(EntityType<? extends TiddlytubbyEntity> entityType, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
	    this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(1, new PanicGoal(this, 0.55F));
		this.goalSelector.addGoal(2, new TemptGoal(this, 0.45F, false, Ingredient.of(TeletubbiesItems.TOAST.get(), TeletubbiesItems.CUSTARD.get())));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 0.3F));
		this.goalSelector.addGoal(4, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 0.9F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
	}
	
	public static MutableAttribute setCustomAttributes() {
		return TiddlytubbyEntity.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.5D)
				.add(Attributes.MAX_HEALTH, 10.0D);
	}
	
	@Override
	public int getMaxSpawnClusterSize() {
		return 1;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return this.random.nextInt(2) == 0 ? TeletubbiesSounds.ENTITY_DAADAA_VOICE.get() : TeletubbiesSounds.ENTITY_MIMI_VOICE.get();
    }
}
