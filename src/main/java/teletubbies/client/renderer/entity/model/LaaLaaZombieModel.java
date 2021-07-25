package teletubbies.client.renderer.entity.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.monster.LaaLaaZombieEntity;

@OnlyIn(Dist.CLIENT)
public class LaaLaaZombieModel extends TeletubbyZombieModel<LaaLaaZombieEntity> {
	public ModelPart stick;

	public LaaLaaZombieModel() {
		stick = new ModelPart(this);
		stick.setPos(0.0F, 24.0F, 0.0F);
		stick.addBox(null, -1.0F, -35.0F, -1.0F, 2, 3, 2, 0.0F, 27, 20);
		stick.addBox(null, 0.0F, -38.0F, 0.0F, 2, 4, 2, 0.0F, 27, 25);
		
		head.addChild(stick);
	}
}
