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
import teletubbies.client.audio.SoundList;

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
		return NooNooEntity.func_233666_p_()
				.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.5D)
				.createMutableAttribute(Attributes.MAX_HEALTH, 25.0D);
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return this.rand.nextInt(2) == 0 ? SoundList.ENTITY_NOONOO_AMBIENT1 : SoundList.ENTITY_NOONOO_AMBIENT2;
    }
	
	@Override
	public SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundList.ENTITY_NOONOO_HURT;
	}

	@Override
	public SoundEvent getDeathSound() {
		return SoundList.ENTITY_NOONOO_DEATH;
	}
}
