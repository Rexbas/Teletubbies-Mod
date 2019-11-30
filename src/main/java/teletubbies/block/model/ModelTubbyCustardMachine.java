package teletubbies.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTubbyCustardMachine extends ModelBase
{
	  //fields
	    ModelRenderer middlebox;
	    ModelRenderer leftbox;
	    ModelRenderer rightbox;
	    ModelRenderer righttower1;
	    ModelRenderer righttower2;
	    ModelRenderer righttower3;
	    ModelRenderer righttower4;
	    ModelRenderer righttower5;
	    ModelRenderer lefttower1;
	    ModelRenderer lefttower2;
	    ModelRenderer lefttower3;
	    ModelRenderer lefttower4;
	    ModelRenderer lefttower5;
	    ModelRenderer stick;
	  
	  public ModelTubbyCustardMachine()
	  {
	    textureWidth = 256;
	    textureHeight = 128;
	    
	      middlebox = new ModelRenderer(this, 65, 0);
	      middlebox.addBox(0F, 0F, 0F, 16, 16, 16);
	      middlebox.setRotationPoint(-8F, 0F, -8F);
	      middlebox.setTextureSize(256, 128);
	      middlebox.mirror = true;
	      setRotation(middlebox, 0F, 0F, 0F);
	      leftbox = new ModelRenderer(this, 130, 0);
	      leftbox.addBox(0F, 0F, 0F, 16, 16, 16);
	      leftbox.setRotationPoint(8F, 0F, -8F);
	      leftbox.setTextureSize(256, 128);
	      leftbox.mirror = true;
	      setRotation(leftbox, 0F, 0F, 0F);
	      rightbox = new ModelRenderer(this, 0, 0);
	      rightbox.addBox(0F, 0F, 0F, 16, 16, 16);
	      rightbox.setRotationPoint(-24F, 0F, -8F);
	      rightbox.setTextureSize(256, 128);
	      rightbox.mirror = true;
	      setRotation(rightbox, 0F, 0F, 0F);
	      righttower1 = new ModelRenderer(this, 0, 67);
	      righttower1.addBox(0F, 0F, 0F, 6, 3, 6);
	      righttower1.setRotationPoint(-21F, -3F, -3F);
	      righttower1.setTextureSize(256, 128);
	      righttower1.mirror = true;
	      setRotation(righttower1, 0F, 0F, 0F);
	      righttower2 = new ModelRenderer(this, 0, 52);
	      righttower2.addBox(0F, 0F, 0F, 4, 9, 4);
	      righttower2.setRotationPoint(-20F, -12F, -2F);
	      righttower2.setTextureSize(256, 128);
	      righttower2.mirror = true;
	      setRotation(righttower2, 0F, 0F, 0F);
	      righttower3 = new ModelRenderer(this, 0, 44);
	      righttower3.addBox(0F, 0F, 0F, 6, 1, 6);
	      righttower3.setRotationPoint(-21F, -13F, -3F);
	      righttower3.setTextureSize(256, 128);
	      righttower3.mirror = true;
	      setRotation(righttower3, 0F, 0F, 0F);
	      righttower4 = new ModelRenderer(this, 0, 37);
	      righttower4.addBox(0F, 0F, 0F, 4, 2, 4);
	      righttower4.setRotationPoint(-20F, -15F, -2F);
	      righttower4.setTextureSize(256, 128);
	      righttower4.mirror = true;
	      setRotation(righttower4, 0F, 0F, 0F);
	      righttower5 = new ModelRenderer(this, 0, 33);
	      righttower5.addBox(0F, 0F, 0F, 2, 1, 2);
	      righttower5.setRotationPoint(-19F, -16F, -1F);
	      righttower5.setTextureSize(256, 128);
	      righttower5.mirror = true;
	      setRotation(righttower5, 0F, 0F, 0F);
	      lefttower1 = new ModelRenderer(this, 25, 67);
	      lefttower1.addBox(0F, 0F, 0F, 6, 3, 6);
	      lefttower1.setRotationPoint(15F, -3F, -3F);
	      lefttower1.setTextureSize(256, 128);
	      lefttower1.mirror = true;
	      setRotation(lefttower1, 0F, 0F, 0F);
	      lefttower2 = new ModelRenderer(this, 25, 52);
	      lefttower2.addBox(0F, 0F, 0F, 4, 8, 4);
	      lefttower2.setRotationPoint(16F, -11F, -2F);
	      lefttower2.setTextureSize(256, 128);
	      lefttower2.mirror = true;
	      setRotation(lefttower2, 0F, 0F, 0F);
	      lefttower3 = new ModelRenderer(this, 25, 44);
	      lefttower3.addBox(0F, 0F, 0F, 6, 1, 6);
	      lefttower3.setRotationPoint(15F, -12F, -3F);
	      lefttower3.setTextureSize(256, 128);
	      lefttower3.mirror = true;
	      setRotation(lefttower3, 0F, 0F, 0F);
	      lefttower4 = new ModelRenderer(this, 25, 37);
	      lefttower4.addBox(0F, 0F, 0F, 4, 2, 4);
	      lefttower4.setRotationPoint(16F, -14F, -2F);
	      lefttower4.setTextureSize(256, 128);
	      lefttower4.mirror = true;
	      setRotation(lefttower4, 0F, 0F, 0F);
	      lefttower5 = new ModelRenderer(this, 25, 33);
	      lefttower5.addBox(0F, 0F, 0F, 2, 1, 2);
	      lefttower5.setRotationPoint(17F, -15F, -1F);
	      lefttower5.setTextureSize(256, 128);
	      lefttower5.mirror = true;
	      setRotation(lefttower5, 0F, 0F, 0F);
	      stick = new ModelRenderer(this, 0, 77);
	      stick.addBox(0F, 0F, 0F, 10, 1, 1);
	      stick.setRotationPoint(-16F, -3F, 2F);
	      stick.setTextureSize(256, 128);
	      stick.mirror = true;
	      setRotation(stick, 0F, 0.2974289F, -0.4833219F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    middlebox.render(f5);
	    leftbox.render(f5);
	    rightbox.render(f5);
	    righttower1.render(f5);
	    righttower2.render(f5);
	    righttower3.render(f5);
	    righttower4.render(f5);
	    righttower5.render(f5);
	    lefttower1.render(f5);
	    lefttower2.render(f5);
	    lefttower3.render(f5);
	    lefttower4.render(f5);
	    lefttower5.render(f5);
	    stick.render(f5);
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