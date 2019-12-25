package teletubbies.entity.baby;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.client.audio.SoundList;
import teletubbies.item.ItemList;

public class TiddlytubbyEntity extends CreatureEntity {
	
	public TiddlytubbyEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new WaterAvoidingRandomWalkingGoal(this, 0.45F));
	    this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(2, new PanicGoal(this, 0.55F));
		this.goalSelector.addGoal(3, new TemptGoal(this, 0.45F, false, Ingredient.fromItems(ItemList.TOAST, ItemList.CUSTARD)));
		this.goalSelector.addGoal(4, new RandomWalkingGoal(this, 0.3F));
		this.goalSelector.addGoal(5, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 0.9F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttributes().getAttributeInstance(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getAttributes().getAttributeInstance(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
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
		return this.rand.nextInt(2) == 0 ? SoundList.daadaa : SoundList.mimi;
    }
}
