package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.passive.TinkyWinkyEntity;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyModel extends TeletubbyModel<TinkyWinkyEntity> {
	public ModelRenderer stick;

	public TinkyWinkyModel() {
		stick = new ModelRenderer(this);
		stick.setPos(0.0F, 24.0F, 0.0F);
		stick.addBox(null, -1.0F, -34.0F, -1.0F, 2, 2, 2, 0.0F, 27, 20);
		stick.addBox(null, -2.0F, -35.0F, -1.0F, 4, 1, 2, 0.0F, 27, 24);
		stick.addBox(null, 1.0F, -36.0F, -1.0F, 2, 1, 2, 0.0F, 27, 27);
		stick.addBox(null, -3.0F, -36.0F, -1.0F, 2, 1, 2, 0.0F, 35, 20);
		stick.addBox(null, -3.0F, -37.0F, -1.0F, 1, 1, 2, 0.0F, 37, 23);
		stick.addBox(null, 2.0F, -37.0F, -1.0F, 1, 1, 2, 0.0F, 37, 26);
		stick.addBox(null, -3.0F, -38.0F, -1.0F, 6, 1, 2, 0.0F, 27, 27);
		
		head.addChild(stick);
	}
}
