package teletubbies.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;
import teletubbies.item.ItemList;

public class TeletubbyEntity extends CreatureEntity {

	protected TeletubbyEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 0.45F));
		this.goalSelector.addGoal(1, new PanicGoal(this, 0.55F));
		this.goalSelector.addGoal(2, new TemptGoal(this, 0.45F, false, Ingredient.fromItems(ItemList.TOAST, ItemList.CUSTARD)));
		this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.45F));
		this.goalSelector.addGoal(4, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 0.9F));
		this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
		// TODO avoid all zombies
	}
	
	@Override
	protected void registerAttributes() {
		super.registerAttributes();
	}

}
