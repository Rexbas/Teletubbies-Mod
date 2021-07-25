package teletubbies.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VoxelShapeRotation {
	
   /**
    * Rotates a VoxelShape around the center of the block around the y-axis.
    * formula: (rotmat dot (vector - [8, 0, 8])) + [8, 0, 8] 
    */
	public static VoxelShape rotateY(final VoxelShape shape, double a) {
		List<AABB> bbList = shape.toAabbs();
		List<VoxelShape> shapeList = new ArrayList<>();
		
		for (AABB aabb : bbList) {
			double x1 = Math.cos(a) * (aabb.minX - .5) + Math.sin(a) * (aabb.minZ - .5) + .5;
			double z1 = -Math.sin(a) * (aabb.minX - .5) + Math.cos(a) * (aabb.minZ - .5) + .5;
			double x2 = Math.cos(a) * (aabb.maxX - .5) + Math.sin(a) * (aabb.maxZ - .5) + .5;
			double z2 = -Math.sin(a) * (aabb.maxX - .5) + Math.cos(a) * (aabb.maxZ - .5) + .5;

			shapeList.add(Shapes.box(Math.min(x1, x2), aabb.minY , Math.min(z1, z2), Math.max(x1, x2), aabb.maxY , Math.max(z1, z2)));
		}
		
		VoxelShape newShape = shapeList.get(0);
		for (int i = 1; i < shapeList.size(); i++) {
			newShape = Shapes.joinUnoptimized(newShape, shapeList.get(i), BooleanOp.OR);
		}
		newShape.optimize();
		
		return newShape;
	}
}