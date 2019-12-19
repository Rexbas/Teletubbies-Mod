package teletubbies.client.models.entity;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entities.LaaLaa;

@OnlyIn(Dist.CLIENT)
public class LaaLaaModel extends TeletubbyModel<LaaLaa> {
	public RendererModel stick;

	public LaaLaaModel() {
		stick = new RendererModel(this);
		stick.setRotationPoint(0.0F, 24.0F, 0.0F);
		stick.cubeList.add(new ModelBox(stick, 27, 20, -1.0F, -35.0F, -1.0F, 2, 3, 2, 0.0F, false));
		stick.cubeList.add(new ModelBox(stick, 27, 25, 0.0F, -38.0F, 0.0F, 2, 4, 2, 0.0F, false));
		
		this.bipedHead.addChild(stick);
	}
}
