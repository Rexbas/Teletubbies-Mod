package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.monster.DipsyZombieEntity;

@OnlyIn(Dist.CLIENT)
public class DipsyZombieModel extends TeletubbyZombieModel<DipsyZombieEntity> {
	public RendererModel stick;

	public DipsyZombieModel() {
		stick = new RendererModel(this);
		stick.setRotationPoint(0.0F, 24.0F, 0.0F);
		stick.cubeList.add(new ModelBox(stick, 27, 20, -1.0F, -38.0F, -1.0F, 2, 6, 2, 0.0F, false));
		
		this.bipedHead.addChild(stick);
	}
}
