package kirothebluefox.moblocks.content.furnitures;

import java.util.List;

import kirothebluefox.moblocks.content.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.utils.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class Sofa extends Block implements IWaterLoggable {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<StairsShape> SHAPE = BlockStateProperties.STAIRS_SHAPE;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty CONNECTED_LEFT = CustomBlockStateProperties.CONNECTED_LEFT;
	public static final BooleanProperty CONNECTED_RIGHT = CustomBlockStateProperties.CONNECTED_RIGHT;
	public static final BooleanProperty ARMREST = CustomBlockStateProperties.ARMREST;
	
	/* inner_corner */
	protected static final double[][] inner_corner = {{0, 0, 0, 16, 7, 16},
	                                                  {0, 7, 1, 16, 8, 16},
	                                                  {0, 7, 0, 15, 8, 1},
	                                                  {0, 8, 10, 16, 15, 16},
	                                                  {0, 8, 0, 6, 15, 10},
	                                                  {1, 15, 11, 16, 16, 15},
	                                                  {1, 15, 0, 5, 16, 11}};
	protected static final VoxelShape inner_cornerPart1 = Block.makeCuboidShape(inner_corner[0][0], inner_corner[0][1], inner_corner[0][2], inner_corner[0][3], inner_corner[0][4], inner_corner[0][5]);
	protected static final VoxelShape inner_cornerPart2 = Block.makeCuboidShape(inner_corner[1][0], inner_corner[1][1], inner_corner[1][2], inner_corner[1][3], inner_corner[1][4], inner_corner[1][5]);
	protected static final VoxelShape inner_cornerPart3 = Block.makeCuboidShape(inner_corner[2][0], inner_corner[2][1], inner_corner[2][2], inner_corner[2][3], inner_corner[2][4], inner_corner[2][5]);
	protected static final VoxelShape inner_cornerPart4 = Block.makeCuboidShape(inner_corner[3][0], inner_corner[3][1], inner_corner[3][2], inner_corner[3][3], inner_corner[3][4], inner_corner[3][5]);
	protected static final VoxelShape inner_cornerPart5 = Block.makeCuboidShape(inner_corner[4][0], inner_corner[4][1], inner_corner[4][2], inner_corner[4][3], inner_corner[4][4], inner_corner[4][5]);
	protected static final VoxelShape inner_cornerPart6 = Block.makeCuboidShape(inner_corner[5][0], inner_corner[5][1], inner_corner[5][2], inner_corner[5][3], inner_corner[5][4], inner_corner[5][5]);
	protected static final VoxelShape inner_cornerPart7 = Block.makeCuboidShape(inner_corner[6][0], inner_corner[6][1], inner_corner[6][2], inner_corner[6][3], inner_corner[6][4], inner_corner[6][5]);
	private static final VoxelShape FULL_inner_corner_SHAPE = VoxelShapes.or(inner_cornerPart1, inner_cornerPart2, inner_cornerPart3, inner_cornerPart4, inner_cornerPart5, inner_cornerPart6, inner_cornerPart7);
	
	/* outer_corner */
	protected static final double[][] outer_corner = {{0, 0, 0, 16, 7, 16},
	                                                  {1, 7, 1, 16, 8, 16},
	                                                  {10, 8, 10, 16, 15, 16},
	                                                  {11, 15, 11, 16, 16, 15},
	                                                  {11, 15, 15, 15, 16, 16}};
	protected static final VoxelShape outer_cornerPart1 = Block.makeCuboidShape(outer_corner[0][0], outer_corner[0][1], outer_corner[0][2], outer_corner[0][3], outer_corner[0][4], outer_corner[0][5]);
	protected static final VoxelShape outer_cornerPart2 = Block.makeCuboidShape(outer_corner[1][0], outer_corner[1][1], outer_corner[1][2], outer_corner[1][3], outer_corner[1][4], outer_corner[1][5]);
	protected static final VoxelShape outer_cornerPart3 = Block.makeCuboidShape(outer_corner[2][0], outer_corner[2][1], outer_corner[2][2], outer_corner[2][3], outer_corner[2][4], outer_corner[2][5]);
	protected static final VoxelShape outer_cornerPart4 = Block.makeCuboidShape(outer_corner[3][0], outer_corner[3][1], outer_corner[3][2], outer_corner[3][3], outer_corner[3][4], outer_corner[3][5]);
	protected static final VoxelShape outer_cornerPart5 = Block.makeCuboidShape(outer_corner[4][0], outer_corner[4][1], outer_corner[4][2], outer_corner[4][3], outer_corner[4][4], outer_corner[4][5]);
	private static final VoxelShape FULL_outer_corner_SHAPE = VoxelShapes.or(outer_cornerPart1, outer_cornerPart2, outer_cornerPart3, outer_cornerPart4, outer_cornerPart5);
	
	/* straight_both */
	protected static final double[][] straight_both = {{0, 0, 0, 16, 7, 16},
	                                                   {0, 7, 1, 16, 8, 16},
	                                                   {0, 8, 10, 16, 15, 16},
	                                                   {0, 15, 11, 16, 16, 15}};
	protected static final VoxelShape straight_bothPart1 = Block.makeCuboidShape(straight_both[0][0], straight_both[0][1], straight_both[0][2], straight_both[0][3], straight_both[0][4], straight_both[0][5]);
	protected static final VoxelShape straight_bothPart2 = Block.makeCuboidShape(straight_both[1][0], straight_both[1][1], straight_both[1][2], straight_both[1][3], straight_both[1][4], straight_both[1][5]);
	protected static final VoxelShape straight_bothPart3 = Block.makeCuboidShape(straight_both[2][0], straight_both[2][1], straight_both[2][2], straight_both[2][3], straight_both[2][4], straight_both[2][5]);
	protected static final VoxelShape straight_bothPart4 = Block.makeCuboidShape(straight_both[3][0], straight_both[3][1], straight_both[3][2], straight_both[3][3], straight_both[3][4], straight_both[3][5]);
	private static final VoxelShape FULL_straight_both_SHAPE = VoxelShapes.or(straight_bothPart1, straight_bothPart2, straight_bothPart3, straight_bothPart4);
	
	/* straight_left */
	protected static final double[][] straight_left = {{1, 0, 0, 16, 7, 16},
	                                                   {0, 0, 1, 1, 7, 15},
	                                                   {1, 7, 1, 16, 8, 16},
	                                                   {1, 8, 10, 16, 15, 16},
	                                                   {0, 7, 11, 1, 15, 15},
	                                                   {1, 15, 11, 16, 16, 15}};
	protected static final VoxelShape straight_leftPart1 = Block.makeCuboidShape(straight_left[0][0], straight_left[0][1], straight_left[0][2], straight_left[0][3], straight_left[0][4], straight_left[0][5]);
	protected static final VoxelShape straight_leftPart2 = Block.makeCuboidShape(straight_left[1][0], straight_left[1][1], straight_left[1][2], straight_left[1][3], straight_left[1][4], straight_left[1][5]);
	protected static final VoxelShape straight_leftPart3 = Block.makeCuboidShape(straight_left[2][0], straight_left[2][1], straight_left[2][2], straight_left[2][3], straight_left[2][4], straight_left[2][5]);
	protected static final VoxelShape straight_leftPart4 = Block.makeCuboidShape(straight_left[3][0], straight_left[3][1], straight_left[3][2], straight_left[3][3], straight_left[3][4], straight_left[3][5]);
	protected static final VoxelShape straight_leftPart5 = Block.makeCuboidShape(straight_left[4][0], straight_left[4][1], straight_left[4][2], straight_left[4][3], straight_left[4][4], straight_left[4][5]);
	protected static final VoxelShape straight_leftPart6 = Block.makeCuboidShape(straight_left[5][0], straight_left[5][1], straight_left[5][2], straight_left[5][3], straight_left[5][4], straight_left[5][5]);
	private static final VoxelShape FULL_straight_left_SHAPE = VoxelShapes.or(straight_leftPart1, straight_leftPart2, straight_leftPart3, straight_leftPart4, straight_leftPart5, straight_leftPart6);
	
	/* straight_left_armrest */
	protected static final double[][] straight_left_armrest = {{1, 0, 0, 16, 7, 16},
	                                                           {0, 0, 1, 1, 8, 15},
	                                                           {1, 7, 1, 16, 8, 16},
	                                                           {1, 11, 1, 3, 12, 10},
	                                                           {0, 8, 1, 4, 11, 11},
	                                                           {1, 7, 0, 3, 11, 1},
	                                                           {1, 8, 10, 16, 15, 16},
	                                                           {0, 8, 11, 1, 15, 15},
	                                                           {1, 15, 11, 16, 16, 15}};
	protected static final VoxelShape straight_left_armrestPart1 = Block.makeCuboidShape(straight_left_armrest[0][0], straight_left_armrest[0][1], straight_left_armrest[0][2], straight_left_armrest[0][3], straight_left_armrest[0][4], straight_left_armrest[0][5]);
	protected static final VoxelShape straight_left_armrestPart2 = Block.makeCuboidShape(straight_left_armrest[1][0], straight_left_armrest[1][1], straight_left_armrest[1][2], straight_left_armrest[1][3], straight_left_armrest[1][4], straight_left_armrest[1][5]);
	protected static final VoxelShape straight_left_armrestPart3 = Block.makeCuboidShape(straight_left_armrest[2][0], straight_left_armrest[2][1], straight_left_armrest[2][2], straight_left_armrest[2][3], straight_left_armrest[2][4], straight_left_armrest[2][5]);
	protected static final VoxelShape straight_left_armrestPart4 = Block.makeCuboidShape(straight_left_armrest[3][0], straight_left_armrest[3][1], straight_left_armrest[3][2], straight_left_armrest[3][3], straight_left_armrest[3][4], straight_left_armrest[3][5]);
	protected static final VoxelShape straight_left_armrestPart5 = Block.makeCuboidShape(straight_left_armrest[4][0], straight_left_armrest[4][1], straight_left_armrest[4][2], straight_left_armrest[4][3], straight_left_armrest[4][4], straight_left_armrest[4][5]);
	protected static final VoxelShape straight_left_armrestPart6 = Block.makeCuboidShape(straight_left_armrest[5][0], straight_left_armrest[5][1], straight_left_armrest[5][2], straight_left_armrest[5][3], straight_left_armrest[5][4], straight_left_armrest[5][5]);
	protected static final VoxelShape straight_left_armrestPart7 = Block.makeCuboidShape(straight_left_armrest[6][0], straight_left_armrest[6][1], straight_left_armrest[6][2], straight_left_armrest[6][3], straight_left_armrest[6][4], straight_left_armrest[6][5]);
	protected static final VoxelShape straight_left_armrestPart8 = Block.makeCuboidShape(straight_left_armrest[7][0], straight_left_armrest[7][1], straight_left_armrest[7][2], straight_left_armrest[7][3], straight_left_armrest[7][4], straight_left_armrest[7][5]);
	protected static final VoxelShape straight_left_armrestPart9 = Block.makeCuboidShape(straight_left_armrest[8][0], straight_left_armrest[8][1], straight_left_armrest[8][2], straight_left_armrest[8][3], straight_left_armrest[8][4], straight_left_armrest[8][5]);
	private static final VoxelShape FULL_straight_left_armrest_SHAPE = VoxelShapes.or(straight_left_armrestPart1, straight_left_armrestPart2, straight_left_armrestPart3, straight_left_armrestPart4, straight_left_armrestPart5, straight_left_armrestPart6, straight_left_armrestPart7, straight_left_armrestPart8, straight_left_armrestPart9);
	
	/* straight_no_connections */
	protected static final double[][] straight_no_connections = {{1, 0, 0, 15, 7, 16},
	                                                             {0, 0, 1, 1, 7, 15},
	                                                             {15, 0, 1, 16, 7, 15},
	                                                             {1, 7, 1, 15, 8, 16},
	                                                             {1, 8, 10, 15, 15, 16},
	                                                             {0, 7, 11, 1, 15, 15},
	                                                             {15, 7, 11, 16, 15, 15},
	                                                             {1, 15, 11, 15, 16, 15}};
	protected static final VoxelShape straight_no_connectionsPart1 = Block.makeCuboidShape(straight_no_connections[0][0], straight_no_connections[0][1], straight_no_connections[0][2], straight_no_connections[0][3], straight_no_connections[0][4], straight_no_connections[0][5]);
	protected static final VoxelShape straight_no_connectionsPart2 = Block.makeCuboidShape(straight_no_connections[1][0], straight_no_connections[1][1], straight_no_connections[1][2], straight_no_connections[1][3], straight_no_connections[1][4], straight_no_connections[1][5]);
	protected static final VoxelShape straight_no_connectionsPart3 = Block.makeCuboidShape(straight_no_connections[2][0], straight_no_connections[2][1], straight_no_connections[2][2], straight_no_connections[2][3], straight_no_connections[2][4], straight_no_connections[2][5]);
	protected static final VoxelShape straight_no_connectionsPart4 = Block.makeCuboidShape(straight_no_connections[3][0], straight_no_connections[3][1], straight_no_connections[3][2], straight_no_connections[3][3], straight_no_connections[3][4], straight_no_connections[3][5]);
	protected static final VoxelShape straight_no_connectionsPart5 = Block.makeCuboidShape(straight_no_connections[4][0], straight_no_connections[4][1], straight_no_connections[4][2], straight_no_connections[4][3], straight_no_connections[4][4], straight_no_connections[4][5]);
	protected static final VoxelShape straight_no_connectionsPart6 = Block.makeCuboidShape(straight_no_connections[5][0], straight_no_connections[5][1], straight_no_connections[5][2], straight_no_connections[5][3], straight_no_connections[5][4], straight_no_connections[5][5]);
	protected static final VoxelShape straight_no_connectionsPart7 = Block.makeCuboidShape(straight_no_connections[6][0], straight_no_connections[6][1], straight_no_connections[6][2], straight_no_connections[6][3], straight_no_connections[6][4], straight_no_connections[6][5]);
	protected static final VoxelShape straight_no_connectionsPart8 = Block.makeCuboidShape(straight_no_connections[7][0], straight_no_connections[7][1], straight_no_connections[7][2], straight_no_connections[7][3], straight_no_connections[7][4], straight_no_connections[7][5]);
	private static final VoxelShape FULL_straight_no_connections_SHAPE = VoxelShapes.or(straight_no_connectionsPart1, straight_no_connectionsPart2, straight_no_connectionsPart3, straight_no_connectionsPart4, straight_no_connectionsPart5, straight_no_connectionsPart6, straight_no_connectionsPart7, straight_no_connectionsPart8);
	
	/* straight_right */
	protected static final double[][] straight_right = {{0, 0, 0, 15, 7, 16},
	                                                    {15, 0, 1, 16, 7, 15},
	                                                    {0, 7, 1, 15, 8, 16},
	                                                    {0, 8, 10, 15, 15, 16},
	                                                    {15, 7, 11, 16, 15, 15},
	                                                    {0, 15, 11, 15, 16, 15}};
	protected static final VoxelShape straight_rightPart1 = Block.makeCuboidShape(straight_right[0][0], straight_right[0][1], straight_right[0][2], straight_right[0][3], straight_right[0][4], straight_right[0][5]);
	protected static final VoxelShape straight_rightPart2 = Block.makeCuboidShape(straight_right[1][0], straight_right[1][1], straight_right[1][2], straight_right[1][3], straight_right[1][4], straight_right[1][5]);
	protected static final VoxelShape straight_rightPart3 = Block.makeCuboidShape(straight_right[2][0], straight_right[2][1], straight_right[2][2], straight_right[2][3], straight_right[2][4], straight_right[2][5]);
	protected static final VoxelShape straight_rightPart4 = Block.makeCuboidShape(straight_right[3][0], straight_right[3][1], straight_right[3][2], straight_right[3][3], straight_right[3][4], straight_right[3][5]);
	protected static final VoxelShape straight_rightPart5 = Block.makeCuboidShape(straight_right[4][0], straight_right[4][1], straight_right[4][2], straight_right[4][3], straight_right[4][4], straight_right[4][5]);
	protected static final VoxelShape straight_rightPart6 = Block.makeCuboidShape(straight_right[5][0], straight_right[5][1], straight_right[5][2], straight_right[5][3], straight_right[5][4], straight_right[5][5]);
	private static final VoxelShape FULL_straight_right_SHAPE = VoxelShapes.or(straight_rightPart1, straight_rightPart2, straight_rightPart3, straight_rightPart4, straight_rightPart5, straight_rightPart6);
	
	/* straight_right_armrest */
	protected static final double[][] straight_right_armrest = {{0, 0, 0, 15, 7, 16},
	                                                            {15, 0, 1, 16, 8, 15},
	                                                            {0, 7, 1, 15, 8, 16},
	                                                            {12, 8, 1, 16, 11, 11},
	                                                            {13, 7, 0, 15, 11, 1},
	                                                            {13, 11, 1, 15, 12, 10},
	                                                            {0, 8, 10, 15, 15, 16},
	                                                            {15, 8, 11, 16, 15, 15},
	                                                            {0, 15, 11, 15, 16, 15}};
	protected static final VoxelShape straight_right_armrestPart1 = Block.makeCuboidShape(straight_right_armrest[0][0], straight_right_armrest[0][1], straight_right_armrest[0][2], straight_right_armrest[0][3], straight_right_armrest[0][4], straight_right_armrest[0][5]);
	protected static final VoxelShape straight_right_armrestPart2 = Block.makeCuboidShape(straight_right_armrest[1][0], straight_right_armrest[1][1], straight_right_armrest[1][2], straight_right_armrest[1][3], straight_right_armrest[1][4], straight_right_armrest[1][5]);
	protected static final VoxelShape straight_right_armrestPart3 = Block.makeCuboidShape(straight_right_armrest[2][0], straight_right_armrest[2][1], straight_right_armrest[2][2], straight_right_armrest[2][3], straight_right_armrest[2][4], straight_right_armrest[2][5]);
	protected static final VoxelShape straight_right_armrestPart4 = Block.makeCuboidShape(straight_right_armrest[3][0], straight_right_armrest[3][1], straight_right_armrest[3][2], straight_right_armrest[3][3], straight_right_armrest[3][4], straight_right_armrest[3][5]);
	protected static final VoxelShape straight_right_armrestPart5 = Block.makeCuboidShape(straight_right_armrest[4][0], straight_right_armrest[4][1], straight_right_armrest[4][2], straight_right_armrest[4][3], straight_right_armrest[4][4], straight_right_armrest[4][5]);
	protected static final VoxelShape straight_right_armrestPart6 = Block.makeCuboidShape(straight_right_armrest[5][0], straight_right_armrest[5][1], straight_right_armrest[5][2], straight_right_armrest[5][3], straight_right_armrest[5][4], straight_right_armrest[5][5]);
	protected static final VoxelShape straight_right_armrestPart7 = Block.makeCuboidShape(straight_right_armrest[6][0], straight_right_armrest[6][1], straight_right_armrest[6][2], straight_right_armrest[6][3], straight_right_armrest[6][4], straight_right_armrest[6][5]);
	protected static final VoxelShape straight_right_armrestPart8 = Block.makeCuboidShape(straight_right_armrest[7][0], straight_right_armrest[7][1], straight_right_armrest[7][2], straight_right_armrest[7][3], straight_right_armrest[7][4], straight_right_armrest[7][5]);
	protected static final VoxelShape straight_right_armrestPart9 = Block.makeCuboidShape(straight_right_armrest[8][0], straight_right_armrest[8][1], straight_right_armrest[8][2], straight_right_armrest[8][3], straight_right_armrest[8][4], straight_right_armrest[8][5]);
	private static final VoxelShape FULL_straight_right_armrest_SHAPE = VoxelShapes.or(straight_right_armrestPart1, straight_right_armrestPart2, straight_right_armrestPart3, straight_right_armrestPart4, straight_right_armrestPart5, straight_right_armrestPart6, straight_right_armrestPart7, straight_right_armrestPart8, straight_right_armrestPart9);

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		default:
			return VoxelShapes.fullCube();
		case NORTH:
			switch (state.get(SHAPE)) {
			default:
				return VoxelShapes.fullCube();
			case STRAIGHT:
				if (state.get(CONNECTED_RIGHT)) {
					if (state.get(CONNECTED_LEFT)) {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_both_SHAPE, VoxelShapeUtils.Angle.Angle180);
					} else {
						if (state.get(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_armrest_SHAPE, VoxelShapeUtils.Angle.Angle180);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_SHAPE, VoxelShapeUtils.Angle.Angle180);
						}
					}
				} else {
					if (state.get(CONNECTED_LEFT)) {
						if (state.get(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_left_armrest_SHAPE, VoxelShapeUtils.Angle.Angle180);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_left_SHAPE, VoxelShapeUtils.Angle.Angle180);
						}
					} else {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_no_connections_SHAPE, VoxelShapeUtils.Angle.Angle180);
					}
				}
			case INNER_LEFT:
				return VoxelShapeUtils.rotateY(FULL_inner_corner_SHAPE);
			case INNER_RIGHT:
				return VoxelShapeUtils.rotateYAngle(FULL_inner_corner_SHAPE, VoxelShapeUtils.Angle.Angle180);
			case OUTER_LEFT:
				return VoxelShapeUtils.rotateYAngle(FULL_outer_corner_SHAPE, VoxelShapeUtils.Angle.Angle180);
			case OUTER_RIGHT:
				return VoxelShapeUtils.rotateYAngle(FULL_outer_corner_SHAPE, VoxelShapeUtils.Angle.Angle270);
			}
		case SOUTH:
			switch (state.get(SHAPE)) {
			default:
				return VoxelShapes.fullCube();
			case STRAIGHT:
				if (state.get(CONNECTED_RIGHT)) {
					if (state.get(CONNECTED_LEFT)) {
						return FULL_straight_both_SHAPE;
					} else {
						if (state.get(ARMREST)) {
							return FULL_straight_right_armrest_SHAPE;
						} else {
							return FULL_straight_right_SHAPE;
						}
					}
				} else {
					if (state.get(CONNECTED_LEFT)) {
						if (state.get(ARMREST)) {
							return FULL_straight_left_armrest_SHAPE;
						} else {
							return FULL_straight_left_SHAPE;
						}
					} else {
						return FULL_straight_no_connections_SHAPE;
					}
				}
			case INNER_LEFT:
				return VoxelShapeUtils.rotateYAngle(FULL_inner_corner_SHAPE, VoxelShapeUtils.Angle.Angle270);
			case INNER_RIGHT:
				return FULL_inner_corner_SHAPE;
			case OUTER_LEFT:
				return FULL_outer_corner_SHAPE;
			case OUTER_RIGHT:
				return VoxelShapeUtils.rotateY(FULL_outer_corner_SHAPE);
			}
		case EAST:
			switch (state.get(SHAPE)) {
			default:
				return VoxelShapes.fullCube();
			case STRAIGHT:
				if (state.get(CONNECTED_RIGHT)) {
					if (state.get(CONNECTED_LEFT)) {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_both_SHAPE, VoxelShapeUtils.Angle.Angle270);
					} else {
						if (state.get(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_armrest_SHAPE, VoxelShapeUtils.Angle.Angle270);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_SHAPE, VoxelShapeUtils.Angle.Angle270);
						}
					}
				} else {
					if (state.get(CONNECTED_LEFT)) {
						if (state.get(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_left_armrest_SHAPE, VoxelShapeUtils.Angle.Angle270);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_left_SHAPE, VoxelShapeUtils.Angle.Angle270);
						}
					} else {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_no_connections_SHAPE, VoxelShapeUtils.Angle.Angle270);
					}
				}
			case INNER_LEFT:
				return VoxelShapeUtils.rotateYAngle(FULL_inner_corner_SHAPE, VoxelShapeUtils.Angle.Angle180);
			case INNER_RIGHT:
				return VoxelShapeUtils.rotateYAngle(FULL_inner_corner_SHAPE, VoxelShapeUtils.Angle.Angle270);
			case OUTER_LEFT:
				return VoxelShapeUtils.rotateYAngle(FULL_outer_corner_SHAPE, VoxelShapeUtils.Angle.Angle270);
			case OUTER_RIGHT:
				return FULL_outer_corner_SHAPE;
			}
		case WEST:
			switch (state.get(SHAPE)) {
			default:
				return VoxelShapes.fullCube();
			case STRAIGHT:
				if (state.get(CONNECTED_RIGHT)) {
					if (state.get(CONNECTED_LEFT)) {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_both_SHAPE, VoxelShapeUtils.Angle.Angle90);
					} else {
						if (state.get(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_armrest_SHAPE, VoxelShapeUtils.Angle.Angle90);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_SHAPE, VoxelShapeUtils.Angle.Angle90);
						}
					}
				} else {
					if (state.get(CONNECTED_LEFT)) {
						if (state.get(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_left_armrest_SHAPE, VoxelShapeUtils.Angle.Angle90);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_left_SHAPE, VoxelShapeUtils.Angle.Angle90);
						}
					} else {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_no_connections_SHAPE, VoxelShapeUtils.Angle.Angle90);
					}
				}
			case INNER_LEFT:
				return FULL_inner_corner_SHAPE;
			case INNER_RIGHT:
				return VoxelShapeUtils.rotateY(FULL_inner_corner_SHAPE);
			case OUTER_LEFT:
				return VoxelShapeUtils.rotateY(FULL_outer_corner_SHAPE);
			case OUTER_RIGHT:
				return VoxelShapeUtils.rotateYAngle(FULL_outer_corner_SHAPE, VoxelShapeUtils.Angle.Angle180);
			}
		}
	}
	
	public Sofa(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
	    this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(SHAPE, StairsShape.STRAIGHT).with(WATERLOGGED, Boolean.valueOf(false)).with(CONNECTED_LEFT, Boolean.valueOf(false)).with(CONNECTED_RIGHT, Boolean.valueOf(false)).with(ARMREST, Boolean.valueOf(false)));
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState ifluidstate = context.getWorld().getFluidState(blockpos);
		IWorld worldIn = context.getWorld();
		BlockState blockstate = this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(WATERLOGGED, Boolean.valueOf(ifluidstate.getFluid() == Fluids.WATER));
		
		return blockstate.with(CONNECTED_RIGHT, getRightConnection(blockstate, worldIn, blockpos)).with(CONNECTED_LEFT, getLeftConnection(blockstate, worldIn, blockpos)).with(SHAPE, getShapeProperty(blockstate, context.getWorld(), blockpos));
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		
		return facing.getAxis().isHorizontal() ? stateIn.with(CONNECTED_RIGHT, getRightConnection(stateIn, worldIn, currentPos)).with(CONNECTED_LEFT, getLeftConnection(stateIn, worldIn, currentPos)).with(SHAPE, getShapeProperty(stateIn, worldIn, currentPos)) : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
	
	@Override
	public void addInformation(ItemStack stack, IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.sit_on").setStyle(Style.EMPTY.setFormatting(TextFormatting.GRAY)));
		tooltip.add(new TranslationTextComponent("tooltips.moblocks.sofa.toggle_armrests").setStyle(Style.EMPTY.setFormatting(TextFormatting.BLUE)));
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote()) {
			if (player.isSneaking()) {
				worldIn.setBlockState(pos, state.with(ARMREST, !state.get(ARMREST)));
			} else {
				if (player.getRidingEntity() != null) {
					return ActionResultType.SUCCESS;
				}
				
				Vector3d vec = new Vector3d(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
				double maxDist = 2.0d;
				if ((vec.x - player.getPosX()) * (vec.x - player.getPosX()) +
						(vec.y - player.getPosY()) * (vec.y - player.getPosY()) +
						(vec.z - player.getPosZ()) * (vec.z - player.getPosZ()) > maxDist * maxDist) {
					player.sendStatusMessage(new TranslationTextComponent("status_messages.moblocks.seats.too_far", new TranslationTextComponent("status_messages.moblocks.seats.sofa")), true);
					return ActionResultType.SUCCESS;
				}
				
				SeatSofa seat = new SeatSofa(worldIn, pos);
				worldIn.addEntity(seat);
				player.startRiding(seat);
			}
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.SUCCESS;
	}

	private static Boolean getRightConnection(BlockState state, IWorld worldIn, BlockPos pos) {
		Direction direction = state.get(FACING);
		BlockPos blockpos = pos.offset(direction.rotateY());
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() instanceof Sofa) {
			if (blockstate.get(FACING) == direction.getOpposite()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}
	
	private static Boolean getLeftConnection(BlockState state, IWorld worldIn, BlockPos pos) {
		Direction direction = state.get(FACING);
		BlockPos blockpos = pos.offset(direction.rotateYCCW());
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() instanceof Sofa) {
			if (blockstate.get(FACING) == direction.getOpposite()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private static StairsShape getShapeProperty(BlockState state, IWorld worldIn, BlockPos pos) {
		Direction direction = state.get(FACING);
		BlockState blockstate = worldIn.getBlockState(pos.offset(direction));
		if (isBlockSofa(blockstate)) {
			Direction direction1 = blockstate.get(FACING);
			if (direction1.getAxis() != state.get(FACING).getAxis() && isDifferentSofa(state, worldIn, pos, direction1.getOpposite())) {
				if (direction1 == direction.rotateYCCW()) {
					return StairsShape.OUTER_LEFT;
				}
	
			return StairsShape.OUTER_RIGHT;
			}
		}
	
		BlockState blockstate1 = worldIn.getBlockState(pos.offset(direction.getOpposite()));
		if (isBlockSofa(blockstate1)) {
			Direction direction2 = blockstate1.get(FACING);
			if (direction2.getAxis() != state.get(FACING).getAxis() && isDifferentSofa(state, worldIn, pos, direction2)) {
				if (direction2 == direction.rotateYCCW()) {
					return StairsShape.INNER_LEFT;
				}

				return StairsShape.INNER_RIGHT;
			}
		}
		
		return StairsShape.STRAIGHT;
	}

	private static boolean isDifferentSofa(BlockState state, IBlockReader worldIn, BlockPos pos, Direction face) {
		BlockState blockstate = worldIn.getBlockState(pos.offset(face));
		return !isBlockSofa(blockstate) || blockstate.get(FACING) != state.get(FACING);
	}

	public static boolean isBlockSofa(BlockState state) {
		if (state.getBlock() instanceof Sofa) {
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings({ "deprecation", "incomplete-switch" })
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		Direction direction = state.get(FACING);
		StairsShape stairsshape = state.get(SHAPE);
		switch(mirrorIn) {
			case LEFT_RIGHT:
			if (direction.getAxis() == Direction.Axis.Z) {
				switch(stairsshape) {
					case INNER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_RIGHT);
					case INNER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_LEFT);
					case OUTER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_RIGHT);
					case OUTER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_LEFT);
					default:
					return state.rotate(Rotation.CLOCKWISE_180);
				}
			}
			break;
			case FRONT_BACK:
			if (direction.getAxis() == Direction.Axis.X) {
				switch(stairsshape) {
					case INNER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_LEFT);
					case INNER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.INNER_RIGHT);
					case OUTER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_RIGHT);
					case OUTER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).with(SHAPE, StairsShape.OUTER_LEFT);
					case STRAIGHT:
					return state.rotate(Rotation.CLOCKWISE_180);
				}
			}
		}
	
		return super.mirror(state, mirrorIn);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, SHAPE, WATERLOGGED, CONNECTED_LEFT, CONNECTED_RIGHT, ARMREST);
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		return false;
	}
}
