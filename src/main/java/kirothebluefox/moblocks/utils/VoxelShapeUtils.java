package kirothebluefox.moblocks.utils;

import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.List;

public class VoxelShapeUtils {
	public static List<double[]> toListOfCoordinates(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = new ArrayList<double[]>();
		List<AABB> bbList = voxelShape.toAabbs();
		for (int i = 0; i < bbList.size(); i++) {
			AABB bb = bbList.get(i);
			voxelShapeCoordinates.add(new double[] {bb.min(Axis.X)*16, bb.min(Axis.Y)*16, bb.min(Axis.Z)*16, bb.max(Axis.X)*16, bb.max(Axis.Y)*16, bb.max(Axis.Z)*16});
		};
		return voxelShapeCoordinates;
	}

	public static List<double[]> mirror(List<double[]> voxelShapeCoordinates, Axis axis) {
		int i;
		switch (axis) {
		default:
			i = 0;
			break;
		case X:
			i = 0;
			break;
		case Y:
			i = 1;
			break;
		case Z:
			i = 2;
			break;
		}
		for (int j = 0; j < voxelShapeCoordinates.size(); j++) {
			double[] coordinates = voxelShapeCoordinates.get(j);
			double value = coordinates[i];
			double value2 = coordinates[i+3];
			double distance = value - 8;
			double distance2 = value2 - 8;
			value -= 2*distance;
			value2 -= 2*distance2;
			double temp = Double.valueOf(value);
			value = Double.valueOf(value2);
			value2 = Double.valueOf(temp);
			coordinates[i] = value;
			coordinates[i+3] = value2;
			voxelShapeCoordinates.set(j, coordinates);
		}
		return voxelShapeCoordinates;
	}

	public static VoxelShape fromListToVoxelShape(List<double[]> voxelShapeCoordinates) {
		VoxelShape fullShape = Shapes.empty();
		for (int i = 0; i < voxelShapeCoordinates.size(); i++) {
			double[] coordinates = voxelShapeCoordinates.get(i);
			fullShape = Shapes.or(fullShape, Block.box(coordinates[0], coordinates[1], coordinates[2], coordinates[3], coordinates[4], coordinates[5]));
		}
		return fullShape;
	}

	public static VoxelShape mirrorX(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = mirror(voxelShapeCoordinates, Axis.X);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public static VoxelShape mirrorY(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = mirror(voxelShapeCoordinates, Axis.Y);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public static VoxelShape mirrorZ(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = mirror(voxelShapeCoordinates, Axis.Z);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public static VoxelShape switchXY(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = switchAxis(voxelShapeCoordinates, Axis.X, Axis.Y);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public static VoxelShape switchYZ(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = switchAxis(voxelShapeCoordinates, Axis.Y, Axis.Z);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public static VoxelShape switchXZ(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = switchAxis(voxelShapeCoordinates, Axis.X, Axis.Z);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public static List<double[]> switchAxis(List<double[]> voxelShapeCoordinates, Axis A, Axis B) {
		int i, j;
		switch (A) {
		default:
			i = 0;
			break;
		case X:
			i = 0;
			break;
		case Y:
			i = 1;
			break;
		case Z:
			i = 2;
			break;
		}
		switch (B) {
		default:
			j = 0;
			break;
		case X:
			j = 0;
			break;
		case Y:
			j = 1;
			break;
		case Z:
			j = 2;
			break;
		}
		for (int k = 0; k < voxelShapeCoordinates.size(); k++) {
			double[] coordinates = voxelShapeCoordinates.get(k);
			double temp = Double.valueOf(coordinates[i]);
			coordinates[i] = Double.valueOf(coordinates[j]);
			coordinates[j] = Double.valueOf(temp);
			double temp2 = Double.valueOf(coordinates[i+3]);
			coordinates[i+3] = Double.valueOf(coordinates[j+3]);
			coordinates[j+3] = Double.valueOf(temp2);
			voxelShapeCoordinates.set(k, coordinates);
		}
		return voxelShapeCoordinates;
	}

	public static VoxelShape rotateY(VoxelShape voxelShape) {
		List<double[]> voxelShapeCoordinates = toListOfCoordinates(voxelShape);
		voxelShapeCoordinates = switchAxis(voxelShapeCoordinates, Axis.X, Axis.Z);
		voxelShapeCoordinates = mirror(voxelShapeCoordinates, Axis.X);
		return fromListToVoxelShape(voxelShapeCoordinates);
	}

	public enum Angle {
		Angle0, Angle90, Angle180, Angle270;

		public int numberOfIterations() {
			switch (this) {
			default:
				return 0;
			case Angle0:
				return 0;
			case Angle90:
				return 1;
			case Angle180:
				return 2;
			case Angle270:
				return 3;
			}
		}
	}

	public static VoxelShape rotateYAngle(VoxelShape voxelShape, VoxelShapeUtils.Angle angle) {
		VoxelShape fullShape = Shapes.or(voxelShape);
		for (int i = 0; i < angle.numberOfIterations(); i++) {
			 fullShape = rotateY(fullShape);
		}
		return fullShape;
	}
}
