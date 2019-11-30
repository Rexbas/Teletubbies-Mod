package teletubbies.entity.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFactory implements IRenderFactory {

	private int ID;
	
	public RenderFactory(int id) {
		this.ID = id;
	}

	public Render createRenderFor(RenderManager manager) {
		switch(ID) {
		case 0:
			return new RenderTinkyWinky(manager, false, 0.0625F, 0.4F);
		case 1:
			return new RenderDipsy(manager, false, 0.0595F, 0.4F);
		case 2:
			return new RenderLaaLaa(manager, false, 0.0565F, 0.4F);
		case 3:
			return new RenderPo(manager, false, 0.0535F, 0.4F);
		case 4:
			return new RenderNooNoo(manager, 0.5F);
		case 5:
			return new RenderZombieTinkyWinky(manager, true, 0.0625F, 0.4F);
		case 6:
			return new RenderZombieDipsy(manager, true, 0.0595F, 0.4F);
		case 7:
			return new RenderZombieLaaLaa(manager, true, 0.0565F, 0.4F);
		case 8:
			return new RenderZombiePo(manager, true, 0.0535F, 0.4F);
		}
		return null;
	}
}
