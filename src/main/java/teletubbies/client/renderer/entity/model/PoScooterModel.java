package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.item.PoScooterEntity;

@OnlyIn(Dist.CLIENT)
public class PoScooterModel extends EntityModel<PoScooterEntity> {
	public RendererModel scooter;
	
	public PoScooterModel() {
		textureWidth = 64;
		textureHeight = 64;
		
		scooter = new RendererModel(this);
		scooter.setRotationPoint(0.0F, 24.0F, 0.0F);
		scooter.cubeList.add(new ModelBox(scooter, 16, 0, -2.0F, -23.0F, -14.0F, 3, 5, 5, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 0, 10, -1.0F, -42.0F, -10.0F, 1, 18, 1, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 0, 0, -4.0F, -43.0F, -10.0F, 7, 1, 1, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 0, 2, -1.0F, -24.0F, -10.0F, 1, 1, 4, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 0, 7, -1.0F, -23.0F, -7.0F, 1, 2, 1, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 0, 30, -3.0F, -22.0F, -6.0F, 5, 1, 15, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 16, 10, -5.0F, -23.0F, 6.0F, 3, 5, 5, 0.0F, false));
		scooter.cubeList.add(new ModelBox(scooter, 16, 20, 1.0F, -23.0F, 6.0F, 3, 5, 5, 0.0F, false));
	}
	
	@Override
	public void render(PoScooterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	this.scooter.render(scale);
	}
}
