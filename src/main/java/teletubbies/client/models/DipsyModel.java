package teletubbies.client.models;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entities.Dipsy;

@OnlyIn(Dist.CLIENT)
public class DipsyModel extends BipedModel<Dipsy> {

	public DipsyModel() {
		super(0.0F, 0.0F, 64, 32);
	}
}
