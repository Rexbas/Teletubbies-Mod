package teletubbies.vehicle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.configuration.ConfigurationHandler;

@SideOnly(Side.CLIENT)
public class RenderPoScooter extends RenderLiving<EntityPoScooter> {
	protected static ModelBase model = new ModelPoScooter();

	public RenderPoScooter(RenderManager renderManagerIn) {
		super(renderManagerIn, model, 0.3f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPoScooter entity) {
		if (ConfigurationHandler.use2015) {
			return new ResourceLocation("teletubbies:textures/vehicle/poscooter2015.png");
		}
		else
			return new ResourceLocation("teletubbies:textures/vehicle/poscooter.png");
	}
}