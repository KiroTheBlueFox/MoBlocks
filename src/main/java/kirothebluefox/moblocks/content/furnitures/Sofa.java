package kirothebluefox.moblocks.content.furnitures;

import kirothebluefox.moblocks.content.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.utils.VoxelShapeUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class Sofa extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
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
	protected static final VoxelShape inner_cornerPart1 = Block.box(inner_corner[0][0], inner_corner[0][1], inner_corner[0][2], inner_corner[0][3], inner_corner[0][4], inner_corner[0][5]);
	protected static final VoxelShape inner_cornerPart2 = Block.box(inner_corner[1][0], inner_corner[1][1], inner_corner[1][2], inner_corner[1][3], inner_corner[1][4], inner_corner[1][5]);
	protected static final VoxelShape inner_cornerPart3 = Block.box(inner_corner[2][0], inner_corner[2][1], inner_corner[2][2], inner_corner[2][3], inner_corner[2][4], inner_corner[2][5]);
	protected static final VoxelShape inner_cornerPart4 = Block.box(inner_corner[3][0], inner_corner[3][1], inner_corner[3][2], inner_corner[3][3], inner_corner[3][4], inner_corner[3][5]);
	protected static final VoxelShape inner_cornerPart5 = Block.box(inner_corner[4][0], inner_corner[4][1], inner_corner[4][2], inner_corner[4][3], inner_corner[4][4], inner_corner[4][5]);
	protected static final VoxelShape inner_cornerPart6 = Block.box(inner_corner[5][0], inner_corner[5][1], inner_corner[5][2], inner_corner[5][3], inner_corner[5][4], inner_corner[5][5]);
	protected static final VoxelShape inner_cornerPart7 = Block.box(inner_corner[6][0], inner_corner[6][1], inner_corner[6][2], inner_corner[6][3], inner_corner[6][4], inner_corner[6][5]);
	private static final VoxelShape FULL_inner_corner_SHAPE = Shapes.or(inner_cornerPart1, inner_cornerPart2, inner_cornerPart3, inner_cornerPart4, inner_cornerPart5, inner_cornerPart6, inner_cornerPart7);

	/* outer_corner */
	protected static final double[][] outer_corner = {{0, 0, 0, 16, 7, 16},
	                                                  {1, 7, 1, 16, 8, 16},
	                                                  {10, 8, 10, 16, 15, 16},
	                                                  {11, 15, 11, 16, 16, 15},
	                                                  {11, 15, 15, 15, 16, 16}};
	protected static final VoxelShape outer_cornerPart1 = Block.box(outer_corner[0][0], outer_corner[0][1], outer_corner[0][2], outer_corner[0][3], outer_corner[0][4], outer_corner[0][5]);
	protected static final VoxelShape outer_cornerPart2 = Block.box(outer_corner[1][0], outer_corner[1][1], outer_corner[1][2], outer_corner[1][3], outer_corner[1][4], outer_corner[1][5]);
	protected static final VoxelShape outer_cornerPart3 = Block.box(outer_corner[2][0], outer_corner[2][1], outer_corner[2][2], outer_corner[2][3], outer_corner[2][4], outer_corner[2][5]);
	protected static final VoxelShape outer_cornerPart4 = Block.box(outer_corner[3][0], outer_corner[3][1], outer_corner[3][2], outer_corner[3][3], outer_corner[3][4], outer_corner[3][5]);
	protected static final VoxelShape outer_cornerPart5 = Block.box(outer_corner[4][0], outer_corner[4][1], outer_corner[4][2], outer_corner[4][3], outer_corner[4][4], outer_corner[4][5]);
	private static final VoxelShape FULL_outer_corner_SHAPE = Shapes.or(outer_cornerPart1, outer_cornerPart2, outer_cornerPart3, outer_cornerPart4, outer_cornerPart5);

	/* straight_both */
	protected static final double[][] straight_both = {{0, 0, 0, 16, 7, 16},
	                                                   {0, 7, 1, 16, 8, 16},
	                                                   {0, 8, 10, 16, 15, 16},
	                                                   {0, 15, 11, 16, 16, 15}};
	protected static final VoxelShape straight_bothPart1 = Block.box(straight_both[0][0], straight_both[0][1], straight_both[0][2], straight_both[0][3], straight_both[0][4], straight_both[0][5]);
	protected static final VoxelShape straight_bothPart2 = Block.box(straight_both[1][0], straight_both[1][1], straight_both[1][2], straight_both[1][3], straight_both[1][4], straight_both[1][5]);
	protected static final VoxelShape straight_bothPart3 = Block.box(straight_both[2][0], straight_both[2][1], straight_both[2][2], straight_both[2][3], straight_both[2][4], straight_both[2][5]);
	protected static final VoxelShape straight_bothPart4 = Block.box(straight_both[3][0], straight_both[3][1], straight_both[3][2], straight_both[3][3], straight_both[3][4], straight_both[3][5]);
	private static final VoxelShape FULL_straight_both_SHAPE = Shapes.or(straight_bothPart1, straight_bothPart2, straight_bothPart3, straight_bothPart4);

	/* straight_left */
	protected static final double[][] straight_left = {{1, 0, 0, 16, 7, 16},
	                                                   {0, 0, 1, 1, 7, 15},
	                                                   {1, 7, 1, 16, 8, 16},
	                                                   {1, 8, 10, 16, 15, 16},
	                                                   {0, 7, 11, 1, 15, 15},
	                                                   {1, 15, 11, 16, 16, 15}};
	protected static final VoxelShape straight_leftPart1 = Block.box(straight_left[0][0], straight_left[0][1], straight_left[0][2], straight_left[0][3], straight_left[0][4], straight_left[0][5]);
	protected static final VoxelShape straight_leftPart2 = Block.box(straight_left[1][0], straight_left[1][1], straight_left[1][2], straight_left[1][3], straight_left[1][4], straight_left[1][5]);
	protected static final VoxelShape straight_leftPart3 = Block.box(straight_left[2][0], straight_left[2][1], straight_left[2][2], straight_left[2][3], straight_left[2][4], straight_left[2][5]);
	protected static final VoxelShape straight_leftPart4 = Block.box(straight_left[3][0], straight_left[3][1], straight_left[3][2], straight_left[3][3], straight_left[3][4], straight_left[3][5]);
	protected static final VoxelShape straight_leftPart5 = Block.box(straight_left[4][0], straight_left[4][1], straight_left[4][2], straight_left[4][3], straight_left[4][4], straight_left[4][5]);
	protected static final VoxelShape straight_leftPart6 = Block.box(straight_left[5][0], straight_left[5][1], straight_left[5][2], straight_left[5][3], straight_left[5][4], straight_left[5][5]);
	private static final VoxelShape FULL_straight_left_SHAPE = Shapes.or(straight_leftPart1, straight_leftPart2, straight_leftPart3, straight_leftPart4, straight_leftPart5, straight_leftPart6);

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
	protected static final VoxelShape straight_left_armrestPart1 = Block.box(straight_left_armrest[0][0], straight_left_armrest[0][1], straight_left_armrest[0][2], straight_left_armrest[0][3], straight_left_armrest[0][4], straight_left_armrest[0][5]);
	protected static final VoxelShape straight_left_armrestPart2 = Block.box(straight_left_armrest[1][0], straight_left_armrest[1][1], straight_left_armrest[1][2], straight_left_armrest[1][3], straight_left_armrest[1][4], straight_left_armrest[1][5]);
	protected static final VoxelShape straight_left_armrestPart3 = Block.box(straight_left_armrest[2][0], straight_left_armrest[2][1], straight_left_armrest[2][2], straight_left_armrest[2][3], straight_left_armrest[2][4], straight_left_armrest[2][5]);
	protected static final VoxelShape straight_left_armrestPart4 = Block.box(straight_left_armrest[3][0], straight_left_armrest[3][1], straight_left_armrest[3][2], straight_left_armrest[3][3], straight_left_armrest[3][4], straight_left_armrest[3][5]);
	protected static final VoxelShape straight_left_armrestPart5 = Block.box(straight_left_armrest[4][0], straight_left_armrest[4][1], straight_left_armrest[4][2], straight_left_armrest[4][3], straight_left_armrest[4][4], straight_left_armrest[4][5]);
	protected static final VoxelShape straight_left_armrestPart6 = Block.box(straight_left_armrest[5][0], straight_left_armrest[5][1], straight_left_armrest[5][2], straight_left_armrest[5][3], straight_left_armrest[5][4], straight_left_armrest[5][5]);
	protected static final VoxelShape straight_left_armrestPart7 = Block.box(straight_left_armrest[6][0], straight_left_armrest[6][1], straight_left_armrest[6][2], straight_left_armrest[6][3], straight_left_armrest[6][4], straight_left_armrest[6][5]);
	protected static final VoxelShape straight_left_armrestPart8 = Block.box(straight_left_armrest[7][0], straight_left_armrest[7][1], straight_left_armrest[7][2], straight_left_armrest[7][3], straight_left_armrest[7][4], straight_left_armrest[7][5]);
	protected static final VoxelShape straight_left_armrestPart9 = Block.box(straight_left_armrest[8][0], straight_left_armrest[8][1], straight_left_armrest[8][2], straight_left_armrest[8][3], straight_left_armrest[8][4], straight_left_armrest[8][5]);
	private static final VoxelShape FULL_straight_left_armrest_SHAPE = Shapes.or(straight_left_armrestPart1, straight_left_armrestPart2, straight_left_armrestPart3, straight_left_armrestPart4, straight_left_armrestPart5, straight_left_armrestPart6, straight_left_armrestPart7, straight_left_armrestPart8, straight_left_armrestPart9);

	/* straight_no_connections */
	protected static final double[][] straight_no_connections = {{1, 0, 0, 15, 7, 16},
	                                                             {0, 0, 1, 1, 7, 15},
	                                                             {15, 0, 1, 16, 7, 15},
	                                                             {1, 7, 1, 15, 8, 16},
	                                                             {1, 8, 10, 15, 15, 16},
	                                                             {0, 7, 11, 1, 15, 15},
	                                                             {15, 7, 11, 16, 15, 15},
	                                                             {1, 15, 11, 15, 16, 15}};
	protected static final VoxelShape straight_no_connectionsPart1 = Block.box(straight_no_connections[0][0], straight_no_connections[0][1], straight_no_connections[0][2], straight_no_connections[0][3], straight_no_connections[0][4], straight_no_connections[0][5]);
	protected static final VoxelShape straight_no_connectionsPart2 = Block.box(straight_no_connections[1][0], straight_no_connections[1][1], straight_no_connections[1][2], straight_no_connections[1][3], straight_no_connections[1][4], straight_no_connections[1][5]);
	protected static final VoxelShape straight_no_connectionsPart3 = Block.box(straight_no_connections[2][0], straight_no_connections[2][1], straight_no_connections[2][2], straight_no_connections[2][3], straight_no_connections[2][4], straight_no_connections[2][5]);
	protected static final VoxelShape straight_no_connectionsPart4 = Block.box(straight_no_connections[3][0], straight_no_connections[3][1], straight_no_connections[3][2], straight_no_connections[3][3], straight_no_connections[3][4], straight_no_connections[3][5]);
	protected static final VoxelShape straight_no_connectionsPart5 = Block.box(straight_no_connections[4][0], straight_no_connections[4][1], straight_no_connections[4][2], straight_no_connections[4][3], straight_no_connections[4][4], straight_no_connections[4][5]);
	protected static final VoxelShape straight_no_connectionsPart6 = Block.box(straight_no_connections[5][0], straight_no_connections[5][1], straight_no_connections[5][2], straight_no_connections[5][3], straight_no_connections[5][4], straight_no_connections[5][5]);
	protected static final VoxelShape straight_no_connectionsPart7 = Block.box(straight_no_connections[6][0], straight_no_connections[6][1], straight_no_connections[6][2], straight_no_connections[6][3], straight_no_connections[6][4], straight_no_connections[6][5]);
	protected static final VoxelShape straight_no_connectionsPart8 = Block.box(straight_no_connections[7][0], straight_no_connections[7][1], straight_no_connections[7][2], straight_no_connections[7][3], straight_no_connections[7][4], straight_no_connections[7][5]);
	private static final VoxelShape FULL_straight_no_connections_SHAPE = Shapes.or(straight_no_connectionsPart1, straight_no_connectionsPart2, straight_no_connectionsPart3, straight_no_connectionsPart4, straight_no_connectionsPart5, straight_no_connectionsPart6, straight_no_connectionsPart7, straight_no_connectionsPart8);

	/* straight_right */
	protected static final double[][] straight_right = {{0, 0, 0, 15, 7, 16},
	                                                    {15, 0, 1, 16, 7, 15},
	                                                    {0, 7, 1, 15, 8, 16},
	                                                    {0, 8, 10, 15, 15, 16},
	                                                    {15, 7, 11, 16, 15, 15},
	                                                    {0, 15, 11, 15, 16, 15}};
	protected static final VoxelShape straight_rightPart1 = Block.box(straight_right[0][0], straight_right[0][1], straight_right[0][2], straight_right[0][3], straight_right[0][4], straight_right[0][5]);
	protected static final VoxelShape straight_rightPart2 = Block.box(straight_right[1][0], straight_right[1][1], straight_right[1][2], straight_right[1][3], straight_right[1][4], straight_right[1][5]);
	protected static final VoxelShape straight_rightPart3 = Block.box(straight_right[2][0], straight_right[2][1], straight_right[2][2], straight_right[2][3], straight_right[2][4], straight_right[2][5]);
	protected static final VoxelShape straight_rightPart4 = Block.box(straight_right[3][0], straight_right[3][1], straight_right[3][2], straight_right[3][3], straight_right[3][4], straight_right[3][5]);
	protected static final VoxelShape straight_rightPart5 = Block.box(straight_right[4][0], straight_right[4][1], straight_right[4][2], straight_right[4][3], straight_right[4][4], straight_right[4][5]);
	protected static final VoxelShape straight_rightPart6 = Block.box(straight_right[5][0], straight_right[5][1], straight_right[5][2], straight_right[5][3], straight_right[5][4], straight_right[5][5]);
	private static final VoxelShape FULL_straight_right_SHAPE = Shapes.or(straight_rightPart1, straight_rightPart2, straight_rightPart3, straight_rightPart4, straight_rightPart5, straight_rightPart6);

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
	protected static final VoxelShape straight_right_armrestPart1 = Block.box(straight_right_armrest[0][0], straight_right_armrest[0][1], straight_right_armrest[0][2], straight_right_armrest[0][3], straight_right_armrest[0][4], straight_right_armrest[0][5]);
	protected static final VoxelShape straight_right_armrestPart2 = Block.box(straight_right_armrest[1][0], straight_right_armrest[1][1], straight_right_armrest[1][2], straight_right_armrest[1][3], straight_right_armrest[1][4], straight_right_armrest[1][5]);
	protected static final VoxelShape straight_right_armrestPart3 = Block.box(straight_right_armrest[2][0], straight_right_armrest[2][1], straight_right_armrest[2][2], straight_right_armrest[2][3], straight_right_armrest[2][4], straight_right_armrest[2][5]);
	protected static final VoxelShape straight_right_armrestPart4 = Block.box(straight_right_armrest[3][0], straight_right_armrest[3][1], straight_right_armrest[3][2], straight_right_armrest[3][3], straight_right_armrest[3][4], straight_right_armrest[3][5]);
	protected static final VoxelShape straight_right_armrestPart5 = Block.box(straight_right_armrest[4][0], straight_right_armrest[4][1], straight_right_armrest[4][2], straight_right_armrest[4][3], straight_right_armrest[4][4], straight_right_armrest[4][5]);
	protected static final VoxelShape straight_right_armrestPart6 = Block.box(straight_right_armrest[5][0], straight_right_armrest[5][1], straight_right_armrest[5][2], straight_right_armrest[5][3], straight_right_armrest[5][4], straight_right_armrest[5][5]);
	protected static final VoxelShape straight_right_armrestPart7 = Block.box(straight_right_armrest[6][0], straight_right_armrest[6][1], straight_right_armrest[6][2], straight_right_armrest[6][3], straight_right_armrest[6][4], straight_right_armrest[6][5]);
	protected static final VoxelShape straight_right_armrestPart8 = Block.box(straight_right_armrest[7][0], straight_right_armrest[7][1], straight_right_armrest[7][2], straight_right_armrest[7][3], straight_right_armrest[7][4], straight_right_armrest[7][5]);
	protected static final VoxelShape straight_right_armrestPart9 = Block.box(straight_right_armrest[8][0], straight_right_armrest[8][1], straight_right_armrest[8][2], straight_right_armrest[8][3], straight_right_armrest[8][4], straight_right_armrest[8][5]);
	private static final VoxelShape FULL_straight_right_armrest_SHAPE = Shapes.or(straight_right_armrestPart1, straight_right_armrestPart2, straight_right_armrestPart3, straight_right_armrestPart4, straight_right_armrestPart5, straight_right_armrestPart6, straight_right_armrestPart7, straight_right_armrestPart8, straight_right_armrestPart9);

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
		switch (state.getValue(FACING)) {
		default:
			return Shapes.block();
		case NORTH:
			switch (state.getValue(SHAPE)) {
			default:
				return Shapes.block();
			case STRAIGHT:
				if (state.getValue(CONNECTED_RIGHT)) {
					if (state.getValue(CONNECTED_LEFT)) {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_both_SHAPE, VoxelShapeUtils.Angle.Angle180);
					} else {
						if (state.getValue(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_armrest_SHAPE, VoxelShapeUtils.Angle.Angle180);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_SHAPE, VoxelShapeUtils.Angle.Angle180);
						}
					}
				} else {
					if (state.getValue(CONNECTED_LEFT)) {
						if (state.getValue(ARMREST)) {
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
			switch (state.getValue(SHAPE)) {
			default:
				return Shapes.block();
			case STRAIGHT:
				if (state.getValue(CONNECTED_RIGHT)) {
					if (state.getValue(CONNECTED_LEFT)) {
						return FULL_straight_both_SHAPE;
					} else {
						if (state.getValue(ARMREST)) {
							return FULL_straight_right_armrest_SHAPE;
						} else {
							return FULL_straight_right_SHAPE;
						}
					}
				} else {
					if (state.getValue(CONNECTED_LEFT)) {
						if (state.getValue(ARMREST)) {
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
			switch (state.getValue(SHAPE)) {
			default:
				return Shapes.block();
			case STRAIGHT:
				if (state.getValue(CONNECTED_RIGHT)) {
					if (state.getValue(CONNECTED_LEFT)) {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_both_SHAPE, VoxelShapeUtils.Angle.Angle270);
					} else {
						if (state.getValue(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_armrest_SHAPE, VoxelShapeUtils.Angle.Angle270);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_SHAPE, VoxelShapeUtils.Angle.Angle270);
						}
					}
				} else {
					if (state.getValue(CONNECTED_LEFT)) {
						if (state.getValue(ARMREST)) {
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
			switch (state.getValue(SHAPE)) {
			default:
				return Shapes.block();
			case STRAIGHT:
				if (state.getValue(CONNECTED_RIGHT)) {
					if (state.getValue(CONNECTED_LEFT)) {
						return VoxelShapeUtils.rotateYAngle(FULL_straight_both_SHAPE, VoxelShapeUtils.Angle.Angle90);
					} else {
						if (state.getValue(ARMREST)) {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_armrest_SHAPE, VoxelShapeUtils.Angle.Angle90);
						} else {
							return VoxelShapeUtils.rotateYAngle(FULL_straight_right_SHAPE, VoxelShapeUtils.Angle.Angle90);
						}
					}
				} else {
					if (state.getValue(CONNECTED_LEFT)) {
						if (state.getValue(ARMREST)) {
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
		super(Block.Properties.copy(baseBlock));
	    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SHAPE, StairsShape.STRAIGHT).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(CONNECTED_LEFT, Boolean.valueOf(false)).setValue(CONNECTED_RIGHT, Boolean.valueOf(false)).setValue(ARMREST, Boolean.valueOf(false)));
	}

	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos blockpos = context.getClickedPos();
		FluidState ifluidstate = context.getLevel().getFluidState(blockpos);
		LevelAccessor worldIn = context.getLevel();
		BlockState blockstate = this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(WATERLOGGED, Boolean.valueOf(ifluidstate.getType() == Fluids.WATER));

		return blockstate.setValue(CONNECTED_RIGHT, getRightConnection(blockstate, worldIn, blockpos)).setValue(CONNECTED_LEFT, getLeftConnection(blockstate, worldIn, blockpos)).setValue(SHAPE, getShapeProperty(blockstate, context.getLevel(), blockpos));
	}

	@SuppressWarnings("deprecation")
	public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.getValue(WATERLOGGED)) {
			worldIn.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(worldIn));
		}

		return facing.getAxis().isHorizontal() ? stateIn.setValue(CONNECTED_RIGHT, getRightConnection(stateIn, worldIn, currentPos)).setValue(CONNECTED_LEFT, getLeftConnection(stateIn, worldIn, currentPos)).setValue(SHAPE, getShapeProperty(stateIn, worldIn, currentPos)) : super.updateShape(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	@Override
	public void appendHoverText(ItemStack stack, BlockGetter worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(new TranslatableComponent("tooltips.moblocks.sit_on").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY)));
		tooltip.add(new TranslatableComponent("tooltips.moblocks.sofa.toggle_armrests").setStyle(Style.EMPTY.withColor(ChatFormatting.BLUE)));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
		if (!worldIn.isClientSide()) {
			if (player.isShiftKeyDown()) {
				worldIn.setBlockAndUpdate(pos, state.setValue(ARMREST, !state.getValue(ARMREST)));
			} else {
				if (player.getVehicle() != null) {
					return InteractionResult.SUCCESS;
				}

				Vec3 vec = new Vec3(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
				double maxDist = 2.0d;
				if ((vec.x - player.getX()) * (vec.x - player.getX()) +
						(vec.y - player.getY()) * (vec.y - player.getY()) +
						(vec.z - player.getZ()) * (vec.z - player.getZ()) > maxDist * maxDist) {
					player.displayClientMessage(new TranslatableComponent("status_messages.moblocks.seats.too_far", new TranslatableComponent("status_messages.moblocks.seats.sofa")), true);
					return InteractionResult.SUCCESS;
				}

				SeatSofa seat = new SeatSofa(worldIn, pos);
				worldIn.addFreshEntity(seat);
				player.startRiding(seat);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.SUCCESS;
	}

	private static Boolean getRightConnection(BlockState state, LevelAccessor worldIn, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockPos blockpos = pos.relative(direction.getClockWise());
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() instanceof Sofa) {
			if (blockstate.getValue(FACING) == direction.getOpposite()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private static Boolean getLeftConnection(BlockState state, LevelAccessor worldIn, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockPos blockpos = pos.relative(direction.getCounterClockWise());
		BlockState blockstate = worldIn.getBlockState(blockpos);
		if (blockstate.getBlock() instanceof Sofa) {
			if (blockstate.getValue(FACING) == direction.getOpposite()) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private static StairsShape getShapeProperty(BlockState state, LevelAccessor worldIn, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockState blockstate = worldIn.getBlockState(pos.relative(direction));
		if (isBlockSofa(blockstate)) {
			Direction direction1 = blockstate.getValue(FACING);
			if (direction1.getAxis() != state.getValue(FACING).getAxis() && isDifferentSofa(state, worldIn, pos, direction1.getOpposite())) {
				if (direction1 == direction.getCounterClockWise()) {
					return StairsShape.OUTER_LEFT;
				}

			return StairsShape.OUTER_RIGHT;
			}
		}

		BlockState blockstate1 = worldIn.getBlockState(pos.relative(direction.getOpposite()));
		if (isBlockSofa(blockstate1)) {
			Direction direction2 = blockstate1.getValue(FACING);
			if (direction2.getAxis() != state.getValue(FACING).getAxis() && isDifferentSofa(state, worldIn, pos, direction2)) {
				if (direction2 == direction.getCounterClockWise()) {
					return StairsShape.INNER_LEFT;
				}

				return StairsShape.INNER_RIGHT;
			}
		}

		return StairsShape.STRAIGHT;
	}

	private static boolean isDifferentSofa(BlockState state, BlockGetter worldIn, BlockPos pos, Direction face) {
		BlockState blockstate = worldIn.getBlockState(pos.relative(face));
		return !isBlockSofa(blockstate) || blockstate.getValue(FACING) != state.getValue(FACING);
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
		Direction direction = state.getValue(FACING);
		StairsShape stairsshape = state.getValue(SHAPE);
		switch(mirrorIn) {
			case LEFT_RIGHT:
			if (direction.getAxis() == Direction.Axis.Z) {
				switch(stairsshape) {
					case INNER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
					case INNER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
					case OUTER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
					case OUTER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
					default:
					return state.rotate(Rotation.CLOCKWISE_180);
				}
			}
			break;
			case FRONT_BACK:
			if (direction.getAxis() == Direction.Axis.X) {
				switch(stairsshape) {
					case INNER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_LEFT);
					case INNER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.INNER_RIGHT);
					case OUTER_LEFT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_RIGHT);
					case OUTER_RIGHT:
					return state.rotate(Rotation.CLOCKWISE_180).setValue(SHAPE, StairsShape.OUTER_LEFT);
					case STRAIGHT:
					return state.rotate(Rotation.CLOCKWISE_180);
				}
			}
		}

		return super.mirror(state, mirrorIn);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, SHAPE, WATERLOGGED, CONNECTED_LEFT, CONNECTED_RIGHT, ARMREST);
	}

	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
		return false;
	}
}
