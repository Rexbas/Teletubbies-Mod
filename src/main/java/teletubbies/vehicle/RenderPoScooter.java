package teletubbies.vehicle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPoScooter extends RenderLiving<EntityPoScooter> {
	protected static ModelBase model = new ModelPoScooter();

	public RenderPoScooter(RenderManager renderManagerIn) {
		super(renderManagerIn, model, 0.3f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPoScooter entity) {
		return new ResourceLocation("teletubbies:textures/vehicle/poscooter.png");
	}
}