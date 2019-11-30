package teletubbies.registry;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teletubbies.Teletubbies;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityNooNoo;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;
import teletubbies.gui.config.ConfigurationHandler;

public class MobRegistry {

	public static void registerMobs(){
		int entityID;
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityTinkyWinky.class, "TinkyWinky", entityID);
		EntityRegistry.registerModEntity(EntityTinkyWinky.class, "TinkyWinky", entityID, Teletubbies.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (153 << 16) + (0 << 8) + 255, (204 << 16) + (153 << 8) + 255)); //(153,0,255) (204,153,255)
		EntityRegistry.addSpawn(EntityTinkyWinky.class, 20, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.plains);
		
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityDipsy.class, "Dipsy", entityID);
		EntityRegistry.registerModEntity(EntityDipsy.class, "Dipsy", entityID, Teletubbies.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (0 << 16) + (255 << 8) + 0, (204 << 16) + (255 << 8) + 204)); //(0,255,0) (204,255,204)
		EntityRegistry.addSpawn(EntityDipsy.class, 20, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.plains);
		
    	entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityLaaLaa.class, "LaaLaa", entityID);
		EntityRegistry.registerModEntity(EntityLaaLaa.class, "LaaLaa", entityID, Teletubbies.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (255 << 16) + (255 << 8) + 0, (255 << 16) + (255 << 8) + 204)); //(255,255,0) (255,255,204)
		EntityRegistry.addSpawn(EntityLaaLaa.class, 20, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.plains);
		
    	entityID = EntityRegistry.findGlobalUniqueEntityId();
    	EntityRegistry.registerGlobalEntityID(EntityPo.class, "Po", entityID);
    	EntityRegistry.registerModEntity(EntityPo.class, "Po", entityID, Teletubbies.instance, 64, 1, true);
    	EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (255 << 16) + (0 << 8) + 0, (255 << 16) + (204 << 8) + 204)); //(255,0,0) (255,204,204)
    	EntityRegistry.addSpawn(EntityPo.class, 20, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.plains);

		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityNooNoo.class, "NooNoo", entityID);
		EntityRegistry.registerModEntity(EntityNooNoo.class, "NooNoo", entityID, Teletubbies.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (0 << 16) + (153 << 8) + 255, (255 << 16) + (102 << 8) + 204)); //(0,153,255) (255,102,204)
		EntityRegistry.addSpawn(EntityNooNoo.class, 20, 1, 1, EnumCreatureType.CREATURE, BiomeGenBase.plains);
		
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityZombieTinkyWinky.class, "ZombieTinkyWinky", entityID);
		EntityRegistry.registerModEntity(EntityZombieTinkyWinky.class, "ZombieTinkyWinky", entityID, Teletubbies.instance, 64, 1, true);
		if (ConfigurationHandler.enableZombies == true){
			EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (153 << 16) + (0 << 8) + 255, (102 << 16) + (0 << 8) + 0)); //(153,0,255) (102,0,0)
			EntityRegistry.addSpawn(EntityZombieTinkyWinky.class, 25, 1, 1, EnumCreatureType.MONSTER, BiomeGenBase.plains);
		}
		
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityZombieDipsy.class, "ZombieDipsy", entityID);
		EntityRegistry.registerModEntity(EntityZombieDipsy.class, "ZombieDipsy", entityID, Teletubbies.instance, 64, 1, true);
		if (ConfigurationHandler.enableZombies == true){
			EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (0 << 16) + (255 << 8) + 0, (102 << 16) + (0 << 8) + 0)); //(0,255,0) (102,0,0)
			EntityRegistry.addSpawn(EntityZombieDipsy.class, 25, 1, 1, EnumCreatureType.MONSTER, BiomeGenBase.plains);
		}
		
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityZombieLaaLaa.class, "ZombieLaaLaa", entityID);
		EntityRegistry.registerModEntity(EntityZombieLaaLaa.class, "ZombieLaaLaa", entityID, Teletubbies.instance, 64, 1, true);
		if (ConfigurationHandler.enableZombies == true){
			EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (255 << 16) + (255 << 8) + 0, (102 << 16) + (0 << 8) + 0)); //(255,255,0) (102,0,0)
			EntityRegistry.addSpawn(EntityZombieLaaLaa.class, 25, 1, 1, EnumCreatureType.MONSTER, BiomeGenBase.plains);
		}
		
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(EntityZombiePo.class, "ZombiePo", entityID);
		EntityRegistry.registerModEntity(EntityZombiePo.class, "ZombiePo", entityID, Teletubbies.instance, 64, 1, true);
		if (ConfigurationHandler.enableZombies == true){
			EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, (255 << 16) + (0 << 8) + 0, (102 << 16) + (0 << 8) + 0)); //(255,0,0) (102,0,0)
			EntityRegistry.addSpawn(EntityZombiePo.class, 25, 1, 1, EnumCreatureType.MONSTER, BiomeGenBase.plains);
		}
	}
}
