package com.rexbas.teletubbies.client.renderer.model;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.PathfinderMob;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DipsyModel<T extends PathfinderMob> extends TeletubbyModel<T> {

	public DipsyModel(ModelPart part, boolean isZombie) {
		super(part, isZombie);
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = TeletubbyModel.createMesh();
		PartDefinition def = mesh.getRoot();

		def.getChild("head").addOrReplaceChild("stick", CubeListBuilder.create()
						.addBox(null, -1.0F, -38.0F, -1.0F, 2, 6, 2, 27, 20),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(mesh, 64, 32);
	}
}