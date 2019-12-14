package teletubbies.client.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entities.TinkyWinky;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyModel extends BipedModel<TinkyWinky> {
	private final RendererModel stick;

	public TinkyWinkyModel() {
		super();
		stick = new RendererModel(this);
		stick.setRotationPoint(0.0F, 24.0F, 0.0F);
		stick.cubeList.add(new ModelBox(stick, 27, 20, -1.0F, -34.0F, -1.0F, 2, 2, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 24, -2.0F, -35.0F, -1.0F, 4, 1, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 27, 1.0F, -36.0F, -1.0F, 2, 1, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 35, 20, -3.0F, -36.0F, -1.0F, 2, 1, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 37, 23, -3.0F, -37.0F, -1.0F, 1, 1, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 37, 26, 2.0F, -37.0F, -1.0F, 1, 1, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 27, -3.0F, -38.0F, -1.0F, 6, 1, 2, 0.0F, false));
	}
	
	@Override
	public void render(TinkyWinky entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		stick.render(scale);
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
}
