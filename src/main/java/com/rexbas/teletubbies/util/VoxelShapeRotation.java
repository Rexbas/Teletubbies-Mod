package com.rexbas.teletubbies.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class VoxelShapeRotation {
	
   /**
    * Rotates a VoxelShape around the center of the block around the y-axis.
    * formula: (rotmat dot (vector - [8, 0, 8])) + [8, 0, 8] 
    */
	public static VoxelShape rotateY(final VoxelShape shape, double a) {
		List<AxisAlignedBB> bbList = shape.toAabbs();
		List<VoxelShape> shapeList = new ArrayList<>();
		
		for (AxisAlignedBB aabb : bbList) {
			double minX = Math.cos(a) * (aabb.minX - .5) + Math.sin(a) * (aabb.minZ - .5) + .5;
			double minZ = -Math.sin(a) * (aabb.minX - .5) + Math.cos(a) * (aabb.minZ - .5) + .5;
			double maxX = Math.cos(a) * (aabb.maxX - .5) + Math.sin(a) * (aabb.maxZ - .5) + .5;
			double maxZ = -Math.sin(a) * (aabb.maxX - .5) + Math.cos(a) * (aabb.maxZ - .5) + .5;
			shapeList.add(VoxelShapes.box(minX, aabb.minY , minZ, maxX, aabb.maxY , maxZ));
		}
		
		VoxelShape newShape = shapeList.get(0);
		for (int i = 1; i < shapeList.size(); i++) {
			newShape = VoxelShapes.joinUnoptimized(newShape, shapeList.get(i), IBooleanFunction.OR);
		}
		newShape.optimize();
		
		return newShape;
	}
}
