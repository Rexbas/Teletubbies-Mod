package teletubbies.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTubbyToastMachine extends ModelBase
{
	  //fields
	    ModelRenderer box1;
	    ModelRenderer box2;
	    ModelRenderer box3;
	    ModelRenderer box4;
	  
	  public ModelTubbyToastMachine()
	  {
	    textureWidth = 128;
	    textureHeight = 64;
	    
	      box1 = new ModelRenderer(this, 0, 0);
	      box1.addBox(0F, 0F, 0F, 16, 22, 16);
	      box1.setRotationPoint(-8F, -6F, -8F);
	      box1.setTextureSize(128, 64);
	      box1.mirror = true;
	      setRotation(box1, 0F, 0F, 0F);
	      box2 = new ModelRenderer(this, 7, 39);
	      box2.addBox(0F, 0F, 0F, 10, 2, 4);
	      box2.setRotationPoint(-5F, -8F, -2F);
	      box2.setTextureSize(128, 64);
	      box2.mirror = true;
	      setRotation(box2, 0F, 0F, 0F);
	      box3 = new ModelRenderer(this, 0, 39);
	      box3.addBox(0F, 0F, 0F, 1, 1, 2);
	      box3.setRotationPoint(-6F, -7F, -1F);
	      box3.setTextureSize(128, 64);
	      box3.mirror = true;
	      setRotation(box3, 0F, 0F, 0F);
	      box4 = new ModelRenderer(this, 36, 39);
	      box4.addBox(0F, 0F, 0F, 1, 1, 2);
	      box4.setRotationPoint(5F, -7F, -1F);
	      box4.setTextureSize(128, 64);
	      box4.mirror = true;
	      setRotation(box4, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    box1.render(f5);
	    box2.render(f5);
	    box3.render(f5);
	    box4.render(f5);
	  }
	  
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	  {
	    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	  }

	}
