package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.passive.PoEntity;

@OnlyIn(Dist.CLIENT)
public class PoModel extends TeletubbyModel<PoEntity> {
	public RendererModel stick;

	public PoModel() {
		stick = new RendererModel(this);
		stick.setRotationPoint(0.0F, 24.0F, 0.0F);
		stick.cubeList.add(new ModelBox(stick, 27, 20, -1.0F, -34.0F, -1.0F, 2, 2, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 24, -2.0F, -35.0F, -1.0F, 4, 1, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 27, 1.0F, -37.0F, -1.0F, 1, 2, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 35, 20, -2.0F, -37.0F, -1.0F, 1, 2, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 26, -2.0F, -38.0F, -1.0F, 4, 1, 2, 0.0F, false));
		
		this.bipedHead.addChild(stick);
	}
}
