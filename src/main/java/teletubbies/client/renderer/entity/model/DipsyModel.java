package teletubbies.client.renderer.entity.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.passive.DipsyEntity;

@OnlyIn(Dist.CLIENT)
public class DipsyModel extends TeletubbyModel<DipsyEntity> {
	public ModelPart stick;

	public DipsyModel() {
		stick = new ModelPart(this);
		stick.setPos(0.0F, 24.0F, 0.0F);
		stick.addBox(null, -1.0F, -38.0F, -1.0F, 2, 6, 2, 0.0F, 27, 20);
		
		head.addChild(stick);
	}
}
