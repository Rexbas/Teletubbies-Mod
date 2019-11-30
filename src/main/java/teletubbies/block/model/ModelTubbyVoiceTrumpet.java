package teletubbies.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTubbyVoiceTrumpet extends ModelBase
{
	  //fields
	    ModelRenderer stick1;
	    ModelRenderer head1;
	    ModelRenderer head2;
	    ModelRenderer head3;
	    ModelRenderer head4;
	    ModelRenderer head5;
	    ModelRenderer head6;
	    ModelRenderer head7;
	  
	  public ModelTubbyVoiceTrumpet()
	  {
	    textureWidth = 64;
	    textureHeight = 32;
	    
	      stick1 = new ModelRenderer(this, 0, 0);
	      stick1.addBox(0F, 0F, 0F, 2, 18, 2);
	      stick1.setRotationPoint(-1F, -2F, -1F);
	      stick1.setTextureSize(64, 32);
	      stick1.mirror = true;
	      setRotation(stick1, 0F, 0F, 0F);
	      head1 = new ModelRenderer(this, 9, 0);
	      head1.addBox(0F, 0F, 0F, 6, 4, 3);
	      head1.setRotationPoint(-3F, -7F, -2F);
	      head1.setTextureSize(64, 32);
	      head1.mirror = true;
	      setRotation(head1, 0F, 0F, 0F);
	      head2 = new ModelRenderer(this, 28, 0);
	      head2.addBox(0F, -8F, 0F, 4, 6, 3);
	      head2.setRotationPoint(-2F, 0F, -2F);
	      head2.setTextureSize(64, 32);
	      head2.mirror = true;
	      setRotation(head2, 0F, 0F, 0F);
	      head3 = new ModelRenderer(this, 0, 24);
	      head3.addBox(0F, 0F, 0F, 1, 4, 1);
	      head3.setRotationPoint(2F, -7F, -3F);
	      head3.setTextureSize(64, 32);
	      head3.mirror = true;
	      setRotation(head3, 0F, 0F, 0F);
	      head4 = new ModelRenderer(this, 0, 21);
	      head4.addBox(0F, 0F, 0F, 4, 1, 1);
	      head4.setRotationPoint(-2F, -8F, -3F);
	      head4.setTextureSize(64, 32);
	      head4.mirror = true;
	      setRotation(head4, 0F, 0F, 0F);
	      head5 = new ModelRenderer(this, 5, 24);
	      head5.addBox(0F, 0F, 0F, 1, 4, 1);
	      head5.setRotationPoint(-3F, -7F, -3F);
	      head5.setTextureSize(64, 32);
	      head5.mirror = true;
	      setRotation(head5, 0F, 0F, 0F);
	      head6 = new ModelRenderer(this, 0, 30);
	      head6.addBox(0F, 0F, 0F, 4, 1, 1);
	      head6.setRotationPoint(-2F, -3F, -3F);
	      head6.setTextureSize(64, 32);
	      head6.mirror = true;
	      setRotation(head6, 0F, 0F, 0F);
	      head7 = new ModelRenderer(this, 11, 21);
	      head7.addBox(0F, 0F, 0F, 4, 4, 1);
	      head7.setRotationPoint(-2F, -7F, 1F);
	      head7.setTextureSize(64, 32);
	      head7.mirror = true;
	      setRotation(head7, 0F, 0F, 0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    super.render(entity, f, f1, f2, f3, f4, f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	    stick1.render(f5);
	    head1.render(f5);
	    head2.render(f5);
	    head3.render(f5);
	    head4.render(f5);
	    head5.render(f5);
	    head6.render(f5);
	    head7.render(f5);
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