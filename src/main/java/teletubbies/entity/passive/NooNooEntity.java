package teletubbies.entity.passive;

import java.util.Random;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap.MutableAttribute;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesSounds;

public class NooNooEntity extends CreatureEntity {

	public NooNooEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	public static boolean canSpawn(EntityType<NooNooEntity> entityType, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 0.3F));
		this.goalSelector.addGoal(1, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 0.9F));
		this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
	}
	
	public static MutableAttribute setCustomAttributes() {
		return NooNooEntity.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.5D)
				.add(Attributes.MAX_HEALTH, 25.0D);
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
		return this.random.nextInt(2) == 0 ? TeletubbiesSounds.ENTITY_NOONOO_AMBIENT1.get() : TeletubbiesSounds.ENTITY_NOONOO_AMBIENT2.get();
    }
	
	@Override
	public SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return TeletubbiesSounds.ENTITY_NOONOO_HURT.get();
	}

	@Override
	public SoundEvent getDeathSound() {
		return TeletubbiesSounds.ENTITY_NOONOO_DEATH.get();
	}
}
