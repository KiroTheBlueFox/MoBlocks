package kirothebluefox.moblocks.content.specialblocks;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.content.customproperties.PillarSize;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class PillarBlock extends Block implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final BooleanProperty CONNECTED_UP = CustomBlockStateProperties.CONNECTED_UP;
	public static final BooleanProperty CONNECTED_DOWN = CustomBlockStateProperties.CONNECTED_DOWN;
	public static final EnumProperty<PillarSize> SIZE = CustomBlockStateProperties.PILLAR_SIZE;
	public static final DirectionProperty SIDE = BlockStateProperties.HORIZONTAL_FACING;
	
	/* Small Pillar Bottom */
	protected static final double[][] SPB = {{0, 0, 1, 16, 8, 15},
	                                          {1, 0, 15, 15, 8, 16},
	                                          {1, 0, 0, 15, 8, 1},
	                                          {2, 8, 6, 14, 16, 10},
	                                          {3, 8, 4, 13, 16, 6},
	                                          {3, 8, 10, 13, 16, 12},
	                                          {4, 8, 12, 12, 16, 13},
	                                          {4, 8, 3, 12, 16, 4},
	                                          {6, 8, 2, 10, 16, 3},
	                                          {6, 8, 13, 10, 16, 14}};
	protected static final VoxelShape SPBPart1 = Block.makeCuboidShape(SPB[0][0], SPB[0][1], SPB[0][2], SPB[0][3], SPB[0][4], SPB[0][5]);
	protected static final VoxelShape SPBPart2 = Block.makeCuboidShape(SPB[1][0], SPB[1][1], SPB[1][2], SPB[1][3], SPB[1][4], SPB[1][5]);
	protected static final VoxelShape SPBPart3 = Block.makeCuboidShape(SPB[2][0], SPB[2][1], SPB[2][2], SPB[2][3], SPB[2][4], SPB[2][5]);
	protected static final VoxelShape SPBPart4 = Block.makeCuboidShape(SPB[3][0], SPB[3][1], SPB[3][2], SPB[3][3], SPB[3][4], SPB[3][5]);
	protected static final VoxelShape SPBPart5 = Block.makeCuboidShape(SPB[4][0], SPB[4][1], SPB[4][2], SPB[4][3], SPB[4][4], SPB[4][5]);
	protected static final VoxelShape SPBPart6 = Block.makeCuboidShape(SPB[5][0], SPB[5][1], SPB[5][2], SPB[5][3], SPB[5][4], SPB[5][5]);
	protected static final VoxelShape SPBPart7 = Block.makeCuboidShape(SPB[6][0], SPB[6][1], SPB[6][2], SPB[6][3], SPB[6][4], SPB[6][5]);
	protected static final VoxelShape SPBPart8 = Block.makeCuboidShape(SPB[7][0], SPB[7][1], SPB[7][2], SPB[7][3], SPB[7][4], SPB[7][5]);
	protected static final VoxelShape SPBPart9 = Block.makeCuboidShape(SPB[8][0], SPB[8][1], SPB[8][2], SPB[8][3], SPB[8][4], SPB[8][5]);
	protected static final VoxelShape SPBPart10 = Block.makeCuboidShape(SPB[9][0], SPB[9][1], SPB[9][2], SPB[9][3], SPB[9][4], SPB[9][5]);
	private static final VoxelShape FULL_SPB_SHAPE = VoxelShapes.or(SPBPart1, SPBPart2, SPBPart3, SPBPart4, SPBPart5, SPBPart6, SPBPart7, SPBPart8, SPBPart9, SPBPart10);

	/* SPM */
	protected static final double[][] SPM = {{2, 0, 6, 14, 16, 10},
	                                          {3, 0, 4, 13, 16, 6},
	                                          {3, 0, 10, 13, 16, 12},
	                                          {4, 0, 12, 12, 16, 13},
	                                          {4, 0, 3, 12, 16, 4},
	                                          {6, 0, 2, 10, 16, 3},
	                                          {6, 0, 13, 10, 16, 14}};
	protected static final VoxelShape SPMPart1 = Block.makeCuboidShape(SPM[0][0], SPM[0][1], SPM[0][2], SPM[0][3], SPM[0][4], SPM[0][5]);
	protected static final VoxelShape SPMPart2 = Block.makeCuboidShape(SPM[1][0], SPM[1][1], SPM[1][2], SPM[1][3], SPM[1][4], SPM[1][5]);
	protected static final VoxelShape SPMPart3 = Block.makeCuboidShape(SPM[2][0], SPM[2][1], SPM[2][2], SPM[2][3], SPM[2][4], SPM[2][5]);
	protected static final VoxelShape SPMPart4 = Block.makeCuboidShape(SPM[3][0], SPM[3][1], SPM[3][2], SPM[3][3], SPM[3][4], SPM[3][5]);
	protected static final VoxelShape SPMPart5 = Block.makeCuboidShape(SPM[4][0], SPM[4][1], SPM[4][2], SPM[4][3], SPM[4][4], SPM[4][5]);
	protected static final VoxelShape SPMPart6 = Block.makeCuboidShape(SPM[5][0], SPM[5][1], SPM[5][2], SPM[5][3], SPM[5][4], SPM[5][5]);
	protected static final VoxelShape SPMPart7 = Block.makeCuboidShape(SPM[6][0], SPM[6][1], SPM[6][2], SPM[6][3], SPM[6][4], SPM[6][5]);
	private static final VoxelShape FULL_SPM_SHAPE = VoxelShapes.or(SPMPart1, SPMPart2, SPMPart3, SPMPart4, SPMPart5, SPMPart6, SPMPart7);

	/* Small Pillar Top */
	protected static final double[][] SPT = {{0, 8, 1, 16, 16, 15},
	                                          {1, 8, 15, 15, 16, 16},
	                                          {1, 8, 0, 15, 16, 1},
	                                          {2, 0, 6, 14, 8, 10},
	                                          {3, 0, 4, 13, 8, 6},
	                                          {3, 0, 10, 13, 8, 12},
	                                          {4, 0, 12, 12, 8, 13},
	                                          {4, 0, 3, 12, 8, 4},
	                                          {6, 0, 2, 10, 8, 3},
	                                          {6, 0, 13, 10, 8, 14}};
	protected static final VoxelShape SPTPart1 = Block.makeCuboidShape(SPT[0][0], SPT[0][1], SPT[0][2], SPT[0][3], SPT[0][4], SPT[0][5]);
	protected static final VoxelShape SPTPart2 = Block.makeCuboidShape(SPT[1][0], SPT[1][1], SPT[1][2], SPT[1][3], SPT[1][4], SPT[1][5]);
	protected static final VoxelShape SPTPart3 = Block.makeCuboidShape(SPT[2][0], SPT[2][1], SPT[2][2], SPT[2][3], SPT[2][4], SPT[2][5]);
	protected static final VoxelShape SPTPart4 = Block.makeCuboidShape(SPT[3][0], SPT[3][1], SPT[3][2], SPT[3][3], SPT[3][4], SPT[3][5]);
	protected static final VoxelShape SPTPart5 = Block.makeCuboidShape(SPT[4][0], SPT[4][1], SPT[4][2], SPT[4][3], SPT[4][4], SPT[4][5]);
	protected static final VoxelShape SPTPart6 = Block.makeCuboidShape(SPT[5][0], SPT[5][1], SPT[5][2], SPT[5][3], SPT[5][4], SPT[5][5]);
	protected static final VoxelShape SPTPart7 = Block.makeCuboidShape(SPT[6][0], SPT[6][1], SPT[6][2], SPT[6][3], SPT[6][4], SPT[6][5]);
	protected static final VoxelShape SPTPart8 = Block.makeCuboidShape(SPT[7][0], SPT[7][1], SPT[7][2], SPT[7][3], SPT[7][4], SPT[7][5]);
	protected static final VoxelShape SPTPart9 = Block.makeCuboidShape(SPT[8][0], SPT[8][1], SPT[8][2], SPT[8][3], SPT[8][4], SPT[8][5]);
	protected static final VoxelShape SPTPart10 = Block.makeCuboidShape(SPT[9][0], SPT[9][1], SPT[9][2], SPT[9][3], SPT[9][4], SPT[9][5]);
	private static final VoxelShape FULL_SPT_SHAPE = VoxelShapes.or(SPTPart1, SPTPart2, SPTPart3, SPTPart4, SPTPart5, SPTPart6, SPTPart7, SPTPart8, SPTPart9, SPTPart10);
	
	/* South East Big Pillar Top */
	protected static final double[][] BPTS = {{4, 8, 0, 16, 16, 16},
								              {2, 8, 1, 4, 16, 16},
								              {0, 8, 4, 1, 16, 16},
								              {1, 8, 2, 2, 16, 16},
								              {13, 0, 4, 16, 8, 16},
								              {10, 0, 5, 13, 8, 16},
								              {9, 0, 6, 10, 8, 16},
								              {8, 0, 7, 9, 8, 16},
								              {7, 0, 8, 8, 8, 16},
								              {6, 0, 9, 7, 8, 16},
								              {5, 0, 10, 6, 8, 16},
								              {4, 0, 13, 5, 8, 16}};
	protected static final VoxelShape BPTSPart1 = Block.makeCuboidShape(BPTS[0][0], BPTS[0][1], BPTS[0][2], BPTS[0][3], BPTS[0][4], BPTS[0][5]);
	protected static final VoxelShape BPTSPart2 = Block.makeCuboidShape(BPTS[1][0], BPTS[1][1], BPTS[1][2], BPTS[1][3], BPTS[1][4], BPTS[1][5]);
	protected static final VoxelShape BPTSPart3 = Block.makeCuboidShape(BPTS[2][0], BPTS[2][1], BPTS[2][2], BPTS[2][3], BPTS[2][4], BPTS[2][5]);
	protected static final VoxelShape BPTSPart4 = Block.makeCuboidShape(BPTS[3][0], BPTS[3][1], BPTS[3][2], BPTS[3][3], BPTS[3][4], BPTS[3][5]);
	protected static final VoxelShape BPTSPart5 = Block.makeCuboidShape(BPTS[4][0], BPTS[4][1], BPTS[4][2], BPTS[4][3], BPTS[4][4], BPTS[4][5]);
	protected static final VoxelShape BPTSPart6 = Block.makeCuboidShape(BPTS[5][0], BPTS[5][1], BPTS[5][2], BPTS[5][3], BPTS[5][4], BPTS[5][5]);
	protected static final VoxelShape BPTSPart7 = Block.makeCuboidShape(BPTS[6][0], BPTS[6][1], BPTS[6][2], BPTS[6][3], BPTS[6][4], BPTS[6][5]);
	protected static final VoxelShape BPTSPart8 = Block.makeCuboidShape(BPTS[7][0], BPTS[7][1], BPTS[7][2], BPTS[7][3], BPTS[7][4], BPTS[7][5]);
	protected static final VoxelShape BPTSPart9 = Block.makeCuboidShape(BPTS[8][0], BPTS[8][1], BPTS[8][2], BPTS[8][3], BPTS[8][4], BPTS[8][5]);
	protected static final VoxelShape BPTSPart10 = Block.makeCuboidShape(BPTS[9][0], BPTS[9][1], BPTS[9][2], BPTS[9][3], BPTS[9][4], BPTS[9][5]);
	protected static final VoxelShape BPTSPart11 = Block.makeCuboidShape(BPTS[10][0], BPTS[10][1], BPTS[10][2], BPTS[10][3], BPTS[10][4], BPTS[10][5]);
	protected static final VoxelShape BPTSPart12 = Block.makeCuboidShape(BPTS[11][0], BPTS[11][1], BPTS[11][2], BPTS[11][3], BPTS[11][4], BPTS[11][5]);
	private static final VoxelShape FULL_BPTS_SHAPE = VoxelShapes.or(BPTSPart1, BPTSPart2, BPTSPart3, BPTSPart4, BPTSPart5, BPTSPart6, BPTSPart7, BPTSPart8, BPTSPart9, BPTSPart10, BPTSPart11, BPTSPart12);

	/* North East Big Pillar Top */
	protected static final double[][] BPTE = {{4, 8, 0, 16, 16, 16},
	                                          {2, 8, 0, 4, 16, 15},
	                                          {0, 8, 0, 1, 16, 12},
	                                          {1, 8, 0, 2, 16, 14},
	                                          {13, 0, 0, 16, 8, 12},
	                                          {10, 0, 0, 13, 8, 11},
	                                          {9, 0, 0, 10, 8, 10},
	                                          {8, 0, 0, 9, 8, 9},
	                                          {7, 0, 0, 8, 8, 8},
	                                          {6, 0, 0, 7, 8, 7},
	                                          {5, 0, 0, 6, 8, 6},
	                                          {4, 0, 0, 5, 8, 3}};
	protected static final VoxelShape BPTEPart1 = Block.makeCuboidShape(BPTE[0][0], BPTE[0][1], BPTE[0][2], BPTE[0][3], BPTE[0][4], BPTE[0][5]);
	protected static final VoxelShape BPTEPart2 = Block.makeCuboidShape(BPTE[1][0], BPTE[1][1], BPTE[1][2], BPTE[1][3], BPTE[1][4], BPTE[1][5]);
	protected static final VoxelShape BPTEPart3 = Block.makeCuboidShape(BPTE[2][0], BPTE[2][1], BPTE[2][2], BPTE[2][3], BPTE[2][4], BPTE[2][5]);
	protected static final VoxelShape BPTEPart4 = Block.makeCuboidShape(BPTE[3][0], BPTE[3][1], BPTE[3][2], BPTE[3][3], BPTE[3][4], BPTE[3][5]);
	protected static final VoxelShape BPTEPart5 = Block.makeCuboidShape(BPTE[4][0], BPTE[4][1], BPTE[4][2], BPTE[4][3], BPTE[4][4], BPTE[4][5]);
	protected static final VoxelShape BPTEPart6 = Block.makeCuboidShape(BPTE[5][0], BPTE[5][1], BPTE[5][2], BPTE[5][3], BPTE[5][4], BPTE[5][5]);
	protected static final VoxelShape BPTEPart7 = Block.makeCuboidShape(BPTE[6][0], BPTE[6][1], BPTE[6][2], BPTE[6][3], BPTE[6][4], BPTE[6][5]);
	protected static final VoxelShape BPTEPart8 = Block.makeCuboidShape(BPTE[7][0], BPTE[7][1], BPTE[7][2], BPTE[7][3], BPTE[7][4], BPTE[7][5]);
	protected static final VoxelShape BPTEPart9 = Block.makeCuboidShape(BPTE[8][0], BPTE[8][1], BPTE[8][2], BPTE[8][3], BPTE[8][4], BPTE[8][5]);
	protected static final VoxelShape BPTEPart10 = Block.makeCuboidShape(BPTE[9][0], BPTE[9][1], BPTE[9][2], BPTE[9][3], BPTE[9][4], BPTE[9][5]);
	protected static final VoxelShape BPTEPart11 = Block.makeCuboidShape(BPTE[10][0], BPTE[10][1], BPTE[10][2], BPTE[10][3], BPTE[10][4], BPTE[10][5]);
	protected static final VoxelShape BPTEPart12 = Block.makeCuboidShape(BPTE[11][0], BPTE[11][1], BPTE[11][2], BPTE[11][3], BPTE[11][4], BPTE[11][5]);
	private static final VoxelShape FULL_BPTE_SHAPE = VoxelShapes.or(BPTEPart1, BPTEPart2, BPTEPart3, BPTEPart4, BPTEPart5, BPTEPart6, BPTEPart7, BPTEPart8, BPTEPart9, BPTEPart10, BPTEPart11, BPTEPart12);

	/* North West Big Pillar Top */
	protected static final double[][] BPTN = {{0, 8, 0, 12, 16, 16},
	                                          {12, 8, 0, 14, 16, 15},
	                                          {15, 8, 0, 16, 16, 12},
	                                          {14, 8, 0, 15, 16, 14},
	                                          {0, 0, 0, 3, 8, 12},
	                                          {3, 0, 0, 6, 8, 11},
	                                          {6, 0, 0, 7, 8, 10},
	                                          {7, 0, 0, 8, 8, 9},
	                                          {8, 0, 0, 9, 8, 8},
	                                          {9, 0, 0, 10, 8, 7},
	                                          {10, 0, 0, 11, 8, 6},
	                                          {11, 0, 0, 12, 8, 3}};
	protected static final VoxelShape BPTNPart1 = Block.makeCuboidShape(BPTN[0][0], BPTN[0][1], BPTN[0][2], BPTN[0][3], BPTN[0][4], BPTN[0][5]);
	protected static final VoxelShape BPTNPart2 = Block.makeCuboidShape(BPTN[1][0], BPTN[1][1], BPTN[1][2], BPTN[1][3], BPTN[1][4], BPTN[1][5]);
	protected static final VoxelShape BPTNPart3 = Block.makeCuboidShape(BPTN[2][0], BPTN[2][1], BPTN[2][2], BPTN[2][3], BPTN[2][4], BPTN[2][5]);
	protected static final VoxelShape BPTNPart4 = Block.makeCuboidShape(BPTN[3][0], BPTN[3][1], BPTN[3][2], BPTN[3][3], BPTN[3][4], BPTN[3][5]);
	protected static final VoxelShape BPTNPart5 = Block.makeCuboidShape(BPTN[4][0], BPTN[4][1], BPTN[4][2], BPTN[4][3], BPTN[4][4], BPTN[4][5]);
	protected static final VoxelShape BPTNPart6 = Block.makeCuboidShape(BPTN[5][0], BPTN[5][1], BPTN[5][2], BPTN[5][3], BPTN[5][4], BPTN[5][5]);
	protected static final VoxelShape BPTNPart7 = Block.makeCuboidShape(BPTN[6][0], BPTN[6][1], BPTN[6][2], BPTN[6][3], BPTN[6][4], BPTN[6][5]);
	protected static final VoxelShape BPTNPart8 = Block.makeCuboidShape(BPTN[7][0], BPTN[7][1], BPTN[7][2], BPTN[7][3], BPTN[7][4], BPTN[7][5]);
	protected static final VoxelShape BPTNPart9 = Block.makeCuboidShape(BPTN[8][0], BPTN[8][1], BPTN[8][2], BPTN[8][3], BPTN[8][4], BPTN[8][5]);
	protected static final VoxelShape BPTNPart10 = Block.makeCuboidShape(BPTN[9][0], BPTN[9][1], BPTN[9][2], BPTN[9][3], BPTN[9][4], BPTN[9][5]);
	protected static final VoxelShape BPTNPart11 = Block.makeCuboidShape(BPTN[10][0], BPTN[10][1], BPTN[10][2], BPTN[10][3], BPTN[10][4], BPTN[10][5]);
	protected static final VoxelShape BPTNPart12 = Block.makeCuboidShape(BPTN[11][0], BPTN[11][1], BPTN[11][2], BPTN[11][3], BPTN[11][4], BPTN[11][5]);
	private static final VoxelShape FULL_BPTN_SHAPE = VoxelShapes.or(BPTNPart1, BPTNPart2, BPTNPart3, BPTNPart4, BPTNPart5, BPTNPart6, BPTNPart7, BPTNPart8, BPTNPart9, BPTNPart10, BPTNPart11, BPTNPart12);

	/* South West Big Pillar Top */
	protected static final double[][] BPTW = {{0, 8, 0, 12, 16, 16},
	                                          {12, 8, 1, 14, 16, 16},
	                                          {15, 8, 4, 16, 16, 16},
	                                          {14, 8, 2, 15, 16, 16},
	                                          {0, 0, 4, 3, 8, 16},
	                                          {3, 0, 5, 6, 8, 16},
	                                          {6, 0, 6, 7, 8, 16},
	                                          {7, 0, 7, 8, 8, 16},
	                                          {8, 0, 8, 9, 8, 16},
	                                          {9, 0, 9, 10, 8, 16},
	                                          {10, 0, 10, 11, 8, 16},
	                                          {11, 0, 13, 12, 8, 16}};
	protected static final VoxelShape BPTWPart1 = Block.makeCuboidShape(BPTW[0][0], BPTW[0][1], BPTW[0][2], BPTW[0][3], BPTW[0][4], BPTW[0][5]);
	protected static final VoxelShape BPTWPart2 = Block.makeCuboidShape(BPTW[1][0], BPTW[1][1], BPTW[1][2], BPTW[1][3], BPTW[1][4], BPTW[1][5]);
	protected static final VoxelShape BPTWPart3 = Block.makeCuboidShape(BPTW[2][0], BPTW[2][1], BPTW[2][2], BPTW[2][3], BPTW[2][4], BPTW[2][5]);
	protected static final VoxelShape BPTWPart4 = Block.makeCuboidShape(BPTW[3][0], BPTW[3][1], BPTW[3][2], BPTW[3][3], BPTW[3][4], BPTW[3][5]);
	protected static final VoxelShape BPTWPart5 = Block.makeCuboidShape(BPTW[4][0], BPTW[4][1], BPTW[4][2], BPTW[4][3], BPTW[4][4], BPTW[4][5]);
	protected static final VoxelShape BPTWPart6 = Block.makeCuboidShape(BPTW[5][0], BPTW[5][1], BPTW[5][2], BPTW[5][3], BPTW[5][4], BPTW[5][5]);
	protected static final VoxelShape BPTWPart7 = Block.makeCuboidShape(BPTW[6][0], BPTW[6][1], BPTW[6][2], BPTW[6][3], BPTW[6][4], BPTW[6][5]);
	protected static final VoxelShape BPTWPart8 = Block.makeCuboidShape(BPTW[7][0], BPTW[7][1], BPTW[7][2], BPTW[7][3], BPTW[7][4], BPTW[7][5]);
	protected static final VoxelShape BPTWPart9 = Block.makeCuboidShape(BPTW[8][0], BPTW[8][1], BPTW[8][2], BPTW[8][3], BPTW[8][4], BPTW[8][5]);
	protected static final VoxelShape BPTWPart10 = Block.makeCuboidShape(BPTW[9][0], BPTW[9][1], BPTW[9][2], BPTW[9][3], BPTW[9][4], BPTW[9][5]);
	protected static final VoxelShape BPTWPart11 = Block.makeCuboidShape(BPTW[10][0], BPTW[10][1], BPTW[10][2], BPTW[10][3], BPTW[10][4], BPTW[10][5]);
	protected static final VoxelShape BPTWPart12 = Block.makeCuboidShape(BPTW[11][0], BPTW[11][1], BPTW[11][2], BPTW[11][3], BPTW[11][4], BPTW[11][5]);
	private static final VoxelShape FULL_BPTW_SHAPE = VoxelShapes.or(BPTWPart1, BPTWPart2, BPTWPart3, BPTWPart4, BPTWPart5, BPTWPart6, BPTWPart7, BPTWPart8, BPTWPart9, BPTWPart10, BPTWPart11, BPTWPart12);

	/* South East Big Pillar Middle */
	protected static final double[][] BPMS = {{13, 0, 4, 16, 16, 16},
	                                          {10, 0, 5, 13, 16, 16},
	                                          {9, 0, 6, 10, 16, 16},
	                                          {8, 0, 7, 9, 16, 16},
	                                          {7, 0, 8, 8, 16, 16},
	                                          {6, 0, 9, 7, 16, 16},
	                                          {5, 0, 10, 6, 16, 16},
	                                          {4, 0, 13, 5, 16, 16}};
	protected static final VoxelShape BPMSPart1 = Block.makeCuboidShape(BPMS[0][0], BPMS[0][1], BPMS[0][2], BPMS[0][3], BPMS[0][4], BPMS[0][5]);
	protected static final VoxelShape BPMSPart2 = Block.makeCuboidShape(BPMS[1][0], BPMS[1][1], BPMS[1][2], BPMS[1][3], BPMS[1][4], BPMS[1][5]);
	protected static final VoxelShape BPMSPart3 = Block.makeCuboidShape(BPMS[2][0], BPMS[2][1], BPMS[2][2], BPMS[2][3], BPMS[2][4], BPMS[2][5]);
	protected static final VoxelShape BPMSPart4 = Block.makeCuboidShape(BPMS[3][0], BPMS[3][1], BPMS[3][2], BPMS[3][3], BPMS[3][4], BPMS[3][5]);
	protected static final VoxelShape BPMSPart5 = Block.makeCuboidShape(BPMS[4][0], BPMS[4][1], BPMS[4][2], BPMS[4][3], BPMS[4][4], BPMS[4][5]);
	protected static final VoxelShape BPMSPart6 = Block.makeCuboidShape(BPMS[5][0], BPMS[5][1], BPMS[5][2], BPMS[5][3], BPMS[5][4], BPMS[5][5]);
	protected static final VoxelShape BPMSPart7 = Block.makeCuboidShape(BPMS[6][0], BPMS[6][1], BPMS[6][2], BPMS[6][3], BPMS[6][4], BPMS[6][5]);
	protected static final VoxelShape BPMSPart8 = Block.makeCuboidShape(BPMS[7][0], BPMS[7][1], BPMS[7][2], BPMS[7][3], BPMS[7][4], BPMS[7][5]);
	private static final VoxelShape FULL_BPMS_SHAPE = VoxelShapes.or(BPMSPart1, BPMSPart2, BPMSPart3, BPMSPart4, BPMSPart5, BPMSPart6, BPMSPart7, BPMSPart8);
	
	/* North East Big Pillar Middle */
	protected static final double[][] BPME = {{13, 0, 0, 16, 16, 12},
	                                          {10, 0, 0, 13, 16, 11},
	                                          {9, 0, 0, 10, 16, 10},
	                                          {8, 0, 0, 9, 16, 9},
	                                          {7, 0, 0, 8, 16, 8},
	                                          {6, 0, 0, 7, 16, 7},
	                                          {5, 0, 0, 6, 16, 6},
	                                          {4, 0, 0, 5, 16, 3}};
	protected static final VoxelShape BPMEPart1 = Block.makeCuboidShape(BPME[0][0], BPME[0][1], BPME[0][2], BPME[0][3], BPME[0][4], BPME[0][5]);
	protected static final VoxelShape BPMEPart2 = Block.makeCuboidShape(BPME[1][0], BPME[1][1], BPME[1][2], BPME[1][3], BPME[1][4], BPME[1][5]);
	protected static final VoxelShape BPMEPart3 = Block.makeCuboidShape(BPME[2][0], BPME[2][1], BPME[2][2], BPME[2][3], BPME[2][4], BPME[2][5]);
	protected static final VoxelShape BPMEPart4 = Block.makeCuboidShape(BPME[3][0], BPME[3][1], BPME[3][2], BPME[3][3], BPME[3][4], BPME[3][5]);
	protected static final VoxelShape BPMEPart5 = Block.makeCuboidShape(BPME[4][0], BPME[4][1], BPME[4][2], BPME[4][3], BPME[4][4], BPME[4][5]);
	protected static final VoxelShape BPMEPart6 = Block.makeCuboidShape(BPME[5][0], BPME[5][1], BPME[5][2], BPME[5][3], BPME[5][4], BPME[5][5]);
	protected static final VoxelShape BPMEPart7 = Block.makeCuboidShape(BPME[6][0], BPME[6][1], BPME[6][2], BPME[6][3], BPME[6][4], BPME[6][5]);
	protected static final VoxelShape BPMEPart8 = Block.makeCuboidShape(BPME[7][0], BPME[7][1], BPME[7][2], BPME[7][3], BPME[7][4], BPME[7][5]);
	private static final VoxelShape FULL_BPME_SHAPE = VoxelShapes.or(BPMEPart1, BPMEPart2, BPMEPart3, BPMEPart4, BPMEPart5, BPMEPart6, BPMEPart7, BPMEPart8);

	/* North West Big Pillar Middle */
	protected static final double[][] BPMN = {{0, 0, 0, 3, 16, 12},
	                                          {3, 0, 0, 6, 16, 11},
	                                          {6, 0, 0, 7, 16, 10},
	                                          {7, 0, 0, 8, 16, 9},
	                                          {8, 0, 0, 9, 16, 8},
	                                          {9, 0, 0, 10, 16, 7},
	                                          {10, 0, 0, 11, 16, 6},
	                                          {11, 0, 0, 12, 16, 3}};
	protected static final VoxelShape BPMNPart1 = Block.makeCuboidShape(BPMN[0][0], BPMN[0][1], BPMN[0][2], BPMN[0][3], BPMN[0][4], BPMN[0][5]);
	protected static final VoxelShape BPMNPart2 = Block.makeCuboidShape(BPMN[1][0], BPMN[1][1], BPMN[1][2], BPMN[1][3], BPMN[1][4], BPMN[1][5]);
	protected static final VoxelShape BPMNPart3 = Block.makeCuboidShape(BPMN[2][0], BPMN[2][1], BPMN[2][2], BPMN[2][3], BPMN[2][4], BPMN[2][5]);
	protected static final VoxelShape BPMNPart4 = Block.makeCuboidShape(BPMN[3][0], BPMN[3][1], BPMN[3][2], BPMN[3][3], BPMN[3][4], BPMN[3][5]);
	protected static final VoxelShape BPMNPart5 = Block.makeCuboidShape(BPMN[4][0], BPMN[4][1], BPMN[4][2], BPMN[4][3], BPMN[4][4], BPMN[4][5]);
	protected static final VoxelShape BPMNPart6 = Block.makeCuboidShape(BPMN[5][0], BPMN[5][1], BPMN[5][2], BPMN[5][3], BPMN[5][4], BPMN[5][5]);
	protected static final VoxelShape BPMNPart7 = Block.makeCuboidShape(BPMN[6][0], BPMN[6][1], BPMN[6][2], BPMN[6][3], BPMN[6][4], BPMN[6][5]);
	protected static final VoxelShape BPMNPart8 = Block.makeCuboidShape(BPMN[7][0], BPMN[7][1], BPMN[7][2], BPMN[7][3], BPMN[7][4], BPMN[7][5]);
	private static final VoxelShape FULL_BPMN_SHAPE = VoxelShapes.or(BPMNPart1, BPMNPart2, BPMNPart3, BPMNPart4, BPMNPart5, BPMNPart6, BPMNPart7, BPMNPart8);

	/* South West Big Pillar Middle */
	protected static final double[][] BPMW = {{0, 0, 4, 3, 16, 16},
	                                          {3, 0, 5, 6, 16, 16},
	                                          {6, 0, 6, 7, 16, 16},
	                                          {7, 0, 7, 8, 16, 16},
	                                          {8, 0, 8, 9, 16, 16},
	                                          {9, 0, 9, 10, 16, 16},
	                                          {10, 0, 10, 11, 16, 16},
	                                          {11, 0, 13, 12, 16, 16}};
	protected static final VoxelShape BPMWPart1 = Block.makeCuboidShape(BPMW[0][0], BPMW[0][1], BPMW[0][2], BPMW[0][3], BPMW[0][4], BPMW[0][5]);
	protected static final VoxelShape BPMWPart2 = Block.makeCuboidShape(BPMW[1][0], BPMW[1][1], BPMW[1][2], BPMW[1][3], BPMW[1][4], BPMW[1][5]);
	protected static final VoxelShape BPMWPart3 = Block.makeCuboidShape(BPMW[2][0], BPMW[2][1], BPMW[2][2], BPMW[2][3], BPMW[2][4], BPMW[2][5]);
	protected static final VoxelShape BPMWPart4 = Block.makeCuboidShape(BPMW[3][0], BPMW[3][1], BPMW[3][2], BPMW[3][3], BPMW[3][4], BPMW[3][5]);
	protected static final VoxelShape BPMWPart5 = Block.makeCuboidShape(BPMW[4][0], BPMW[4][1], BPMW[4][2], BPMW[4][3], BPMW[4][4], BPMW[4][5]);
	protected static final VoxelShape BPMWPart6 = Block.makeCuboidShape(BPMW[5][0], BPMW[5][1], BPMW[5][2], BPMW[5][3], BPMW[5][4], BPMW[5][5]);
	protected static final VoxelShape BPMWPart7 = Block.makeCuboidShape(BPMW[6][0], BPMW[6][1], BPMW[6][2], BPMW[6][3], BPMW[6][4], BPMW[6][5]);
	protected static final VoxelShape BPMWPart8 = Block.makeCuboidShape(BPMW[7][0], BPMW[7][1], BPMW[7][2], BPMW[7][3], BPMW[7][4], BPMW[7][5]);
	private static final VoxelShape FULL_BPMW_SHAPE = VoxelShapes.or(BPMWPart1, BPMWPart2, BPMWPart3, BPMWPart4, BPMWPart5, BPMWPart6, BPMWPart7, BPMWPart8);

	/* South East Big Pillar Bottom */
	protected static final double[][] BPBS = {{4, 0, 0, 16, 8, 16},
	                                          {2, 0, 1, 4, 8, 16},
	                                          {0, 0, 4, 1, 8, 16},
	                                          {1, 0, 2, 2, 8, 16},
	                                          {13, 8, 4, 16, 16, 16},
	                                          {10, 8, 5, 13, 16, 16},
	                                          {9, 8, 6, 10, 16, 16},
	                                          {8, 8, 7, 9, 16, 16},
	                                          {7, 8, 8, 8, 16, 16},
	                                          {6, 8, 9, 7, 16, 16},
	                                          {5, 8, 10, 6, 16, 16},
	                                          {4, 8, 13, 5, 16, 16}};
	protected static final VoxelShape BPBSPart1 = Block.makeCuboidShape(BPBS[0][0], BPBS[0][1], BPBS[0][2], BPBS[0][3], BPBS[0][4], BPBS[0][5]);
	protected static final VoxelShape BPBSPart2 = Block.makeCuboidShape(BPBS[1][0], BPBS[1][1], BPBS[1][2], BPBS[1][3], BPBS[1][4], BPBS[1][5]);
	protected static final VoxelShape BPBSPart3 = Block.makeCuboidShape(BPBS[2][0], BPBS[2][1], BPBS[2][2], BPBS[2][3], BPBS[2][4], BPBS[2][5]);
	protected static final VoxelShape BPBSPart4 = Block.makeCuboidShape(BPBS[3][0], BPBS[3][1], BPBS[3][2], BPBS[3][3], BPBS[3][4], BPBS[3][5]);
	protected static final VoxelShape BPBSPart5 = Block.makeCuboidShape(BPBS[4][0], BPBS[4][1], BPBS[4][2], BPBS[4][3], BPBS[4][4], BPBS[4][5]);
	protected static final VoxelShape BPBSPart6 = Block.makeCuboidShape(BPBS[5][0], BPBS[5][1], BPBS[5][2], BPBS[5][3], BPBS[5][4], BPBS[5][5]);
	protected static final VoxelShape BPBSPart7 = Block.makeCuboidShape(BPBS[6][0], BPBS[6][1], BPBS[6][2], BPBS[6][3], BPBS[6][4], BPBS[6][5]);
	protected static final VoxelShape BPBSPart8 = Block.makeCuboidShape(BPBS[7][0], BPBS[7][1], BPBS[7][2], BPBS[7][3], BPBS[7][4], BPBS[7][5]);
	protected static final VoxelShape BPBSPart9 = Block.makeCuboidShape(BPBS[8][0], BPBS[8][1], BPBS[8][2], BPBS[8][3], BPBS[8][4], BPBS[8][5]);
	protected static final VoxelShape BPBSPart10 = Block.makeCuboidShape(BPBS[9][0], BPBS[9][1], BPBS[9][2], BPBS[9][3], BPBS[9][4], BPBS[9][5]);
	protected static final VoxelShape BPBSPart11 = Block.makeCuboidShape(BPBS[10][0], BPBS[10][1], BPBS[10][2], BPBS[10][3], BPBS[10][4], BPBS[10][5]);
	protected static final VoxelShape BPBSPart12 = Block.makeCuboidShape(BPBS[11][0], BPBS[11][1], BPBS[11][2], BPBS[11][3], BPBS[11][4], BPBS[11][5]);
	private static final VoxelShape FULL_BPBS_SHAPE = VoxelShapes.or(BPBSPart1, BPBSPart2, BPBSPart3, BPBSPart4, BPBSPart5, BPBSPart6, BPBSPart7, BPBSPart8, BPBSPart9, BPBSPart10, BPBSPart11, BPBSPart12);

	/* North East Big Pillar Bottom */
	protected static final double[][] BPBE = {{4, 0, 0, 16, 8, 16},
	                                          {2, 0, 0, 4, 8, 15},
	                                          {0, 0, 0, 1, 8, 12},
	                                          {1, 0, 0, 2, 8, 14},
	                                          {13, 8, 0, 16, 16, 12},
	                                          {10, 8, 0, 13, 16, 11},
	                                          {9, 8, 0, 10, 16, 10},
	                                          {8, 8, 0, 9, 16, 9},
	                                          {7, 8, 0, 8, 16, 8},
	                                          {6, 8, 0, 7, 16, 7},
	                                          {5, 8, 0, 6, 16, 6},
	                                          {4, 8, 0, 5, 16, 3}};
	protected static final VoxelShape BPBEPart1 = Block.makeCuboidShape(BPBE[0][0], BPBE[0][1], BPBE[0][2], BPBE[0][3], BPBE[0][4], BPBE[0][5]);
	protected static final VoxelShape BPBEPart2 = Block.makeCuboidShape(BPBE[1][0], BPBE[1][1], BPBE[1][2], BPBE[1][3], BPBE[1][4], BPBE[1][5]);
	protected static final VoxelShape BPBEPart3 = Block.makeCuboidShape(BPBE[2][0], BPBE[2][1], BPBE[2][2], BPBE[2][3], BPBE[2][4], BPBE[2][5]);
	protected static final VoxelShape BPBEPart4 = Block.makeCuboidShape(BPBE[3][0], BPBE[3][1], BPBE[3][2], BPBE[3][3], BPBE[3][4], BPBE[3][5]);
	protected static final VoxelShape BPBEPart5 = Block.makeCuboidShape(BPBE[4][0], BPBE[4][1], BPBE[4][2], BPBE[4][3], BPBE[4][4], BPBE[4][5]);
	protected static final VoxelShape BPBEPart6 = Block.makeCuboidShape(BPBE[5][0], BPBE[5][1], BPBE[5][2], BPBE[5][3], BPBE[5][4], BPBE[5][5]);
	protected static final VoxelShape BPBEPart7 = Block.makeCuboidShape(BPBE[6][0], BPBE[6][1], BPBE[6][2], BPBE[6][3], BPBE[6][4], BPBE[6][5]);
	protected static final VoxelShape BPBEPart8 = Block.makeCuboidShape(BPBE[7][0], BPBE[7][1], BPBE[7][2], BPBE[7][3], BPBE[7][4], BPBE[7][5]);
	protected static final VoxelShape BPBEPart9 = Block.makeCuboidShape(BPBE[8][0], BPBE[8][1], BPBE[8][2], BPBE[8][3], BPBE[8][4], BPBE[8][5]);
	protected static final VoxelShape BPBEPart10 = Block.makeCuboidShape(BPBE[9][0], BPBE[9][1], BPBE[9][2], BPBE[9][3], BPBE[9][4], BPBE[9][5]);
	protected static final VoxelShape BPBEPart11 = Block.makeCuboidShape(BPBE[10][0], BPBE[10][1], BPBE[10][2], BPBE[10][3], BPBE[10][4], BPBE[10][5]);
	protected static final VoxelShape BPBEPart12 = Block.makeCuboidShape(BPBE[11][0], BPBE[11][1], BPBE[11][2], BPBE[11][3], BPBE[11][4], BPBE[11][5]);
	private static final VoxelShape FULL_BPBE_SHAPE = VoxelShapes.or(BPBEPart1, BPBEPart2, BPBEPart3, BPBEPart4, BPBEPart5, BPBEPart6, BPBEPart7, BPBEPart8, BPBEPart9, BPBEPart10, BPBEPart11, BPBEPart12);

	/* North West Big Pillar Bottom */
	protected static final double[][] BPBN = {{0, 0, 0, 12, 8, 16},
	                                          {12, 0, 0, 14, 8, 15},
	                                          {15, 0, 0, 16, 8, 12},
	                                          {14, 0, 0, 15, 8, 14},
	                                          {0, 8, 0, 3, 16, 12},
	                                          {3, 8, 0, 6, 16, 11},
	                                          {6, 8, 0, 7, 16, 10},
	                                          {7, 8, 0, 8, 16, 9},
	                                          {8, 8, 0, 9, 16, 8},
	                                          {9, 8, 0, 10, 16, 7},
	                                          {10, 8, 0, 11, 16, 6},
	                                          {11, 8, 0, 12, 16, 3}};
	protected static final VoxelShape BPBNPart1 = Block.makeCuboidShape(BPBN[0][0], BPBN[0][1], BPBN[0][2], BPBN[0][3], BPBN[0][4], BPBN[0][5]);
	protected static final VoxelShape BPBNPart2 = Block.makeCuboidShape(BPBN[1][0], BPBN[1][1], BPBN[1][2], BPBN[1][3], BPBN[1][4], BPBN[1][5]);
	protected static final VoxelShape BPBNPart3 = Block.makeCuboidShape(BPBN[2][0], BPBN[2][1], BPBN[2][2], BPBN[2][3], BPBN[2][4], BPBN[2][5]);
	protected static final VoxelShape BPBNPart4 = Block.makeCuboidShape(BPBN[3][0], BPBN[3][1], BPBN[3][2], BPBN[3][3], BPBN[3][4], BPBN[3][5]);
	protected static final VoxelShape BPBNPart5 = Block.makeCuboidShape(BPBN[4][0], BPBN[4][1], BPBN[4][2], BPBN[4][3], BPBN[4][4], BPBN[4][5]);
	protected static final VoxelShape BPBNPart6 = Block.makeCuboidShape(BPBN[5][0], BPBN[5][1], BPBN[5][2], BPBN[5][3], BPBN[5][4], BPBN[5][5]);
	protected static final VoxelShape BPBNPart7 = Block.makeCuboidShape(BPBN[6][0], BPBN[6][1], BPBN[6][2], BPBN[6][3], BPBN[6][4], BPBN[6][5]);
	protected static final VoxelShape BPBNPart8 = Block.makeCuboidShape(BPBN[7][0], BPBN[7][1], BPBN[7][2], BPBN[7][3], BPBN[7][4], BPBN[7][5]);
	protected static final VoxelShape BPBNPart9 = Block.makeCuboidShape(BPBN[8][0], BPBN[8][1], BPBN[8][2], BPBN[8][3], BPBN[8][4], BPBN[8][5]);
	protected static final VoxelShape BPBNPart10 = Block.makeCuboidShape(BPBN[9][0], BPBN[9][1], BPBN[9][2], BPBN[9][3], BPBN[9][4], BPBN[9][5]);
	protected static final VoxelShape BPBNPart11 = Block.makeCuboidShape(BPBN[10][0], BPBN[10][1], BPBN[10][2], BPBN[10][3], BPBN[10][4], BPBN[10][5]);
	protected static final VoxelShape BPBNPart12 = Block.makeCuboidShape(BPBN[11][0], BPBN[11][1], BPBN[11][2], BPBN[11][3], BPBN[11][4], BPBN[11][5]);
	private static final VoxelShape FULL_BPBN_SHAPE = VoxelShapes.or(BPBNPart1, BPBNPart2, BPBNPart3, BPBNPart4, BPBNPart5, BPBNPart6, BPBNPart7, BPBNPart8, BPBNPart9, BPBNPart10, BPBNPart11, BPBNPart12);

	/* South West Big Pillar Bottom */
	protected static final double[][] BPBW = {{0, 0, 0, 12, 8, 16},
	                                          {12, 0, 1, 14, 8, 16},
	                                          {15, 0, 4, 16, 8, 16},
	                                          {14, 0, 2, 15, 8, 16},
	                                          {0, 8, 4, 3, 16, 16},
	                                          {3, 8, 5, 6, 16, 16},
	                                          {6, 8, 6, 7, 16, 16},
	                                          {7, 8, 7, 8, 16, 16},
	                                          {8, 8, 8, 9, 16, 16},
	                                          {9, 8, 9, 10, 16, 16},
	                                          {10, 8, 10, 11, 16, 16},
	                                          {11, 8, 13, 12, 16, 16}};
	protected static final VoxelShape BPBWPart1 = Block.makeCuboidShape(BPBW[0][0], BPBW[0][1], BPBW[0][2], BPBW[0][3], BPBW[0][4], BPBW[0][5]);
	protected static final VoxelShape BPBWPart2 = Block.makeCuboidShape(BPBW[1][0], BPBW[1][1], BPBW[1][2], BPBW[1][3], BPBW[1][4], BPBW[1][5]);
	protected static final VoxelShape BPBWPart3 = Block.makeCuboidShape(BPBW[2][0], BPBW[2][1], BPBW[2][2], BPBW[2][3], BPBW[2][4], BPBW[2][5]);
	protected static final VoxelShape BPBWPart4 = Block.makeCuboidShape(BPBW[3][0], BPBW[3][1], BPBW[3][2], BPBW[3][3], BPBW[3][4], BPBW[3][5]);
	protected static final VoxelShape BPBWPart5 = Block.makeCuboidShape(BPBW[4][0], BPBW[4][1], BPBW[4][2], BPBW[4][3], BPBW[4][4], BPBW[4][5]);
	protected static final VoxelShape BPBWPart6 = Block.makeCuboidShape(BPBW[5][0], BPBW[5][1], BPBW[5][2], BPBW[5][3], BPBW[5][4], BPBW[5][5]);
	protected static final VoxelShape BPBWPart7 = Block.makeCuboidShape(BPBW[6][0], BPBW[6][1], BPBW[6][2], BPBW[6][3], BPBW[6][4], BPBW[6][5]);
	protected static final VoxelShape BPBWPart8 = Block.makeCuboidShape(BPBW[7][0], BPBW[7][1], BPBW[7][2], BPBW[7][3], BPBW[7][4], BPBW[7][5]);
	protected static final VoxelShape BPBWPart9 = Block.makeCuboidShape(BPBW[8][0], BPBW[8][1], BPBW[8][2], BPBW[8][3], BPBW[8][4], BPBW[8][5]);
	protected static final VoxelShape BPBWPart10 = Block.makeCuboidShape(BPBW[9][0], BPBW[9][1], BPBW[9][2], BPBW[9][3], BPBW[9][4], BPBW[9][5]);
	protected static final VoxelShape BPBWPart11 = Block.makeCuboidShape(BPBW[10][0], BPBW[10][1], BPBW[10][2], BPBW[10][3], BPBW[10][4], BPBW[10][5]);
	protected static final VoxelShape BPBWPart12 = Block.makeCuboidShape(BPBW[11][0], BPBW[11][1], BPBW[11][2], BPBW[11][3], BPBW[11][4], BPBW[11][5]);
	private static final VoxelShape FULL_BPBW_SHAPE = VoxelShapes.or(BPBWPart1, BPBWPart2, BPBWPart3, BPBWPart4, BPBWPart5, BPBWPart6, BPBWPart7, BPBWPart8, BPBWPart9, BPBWPart10, BPBWPart11, BPBWPart12);

	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(SIZE) == PillarSize.SMALL) {
			if (state.get(CONNECTED_UP) == true) {
				if (state.get(CONNECTED_DOWN) == true) {
				    return FULL_SPM_SHAPE;
				} else {
				    return FULL_SPB_SHAPE;
				}
			} else if (state.get(CONNECTED_DOWN) == true) {
				if (state.get(CONNECTED_UP) == true) {
				    return FULL_SPM_SHAPE;
				} else {
					return FULL_SPT_SHAPE;
				}
			} else {
				return FULL_SPM_SHAPE;
			}
		} else {
			if (state.get(SIDE) == Direction.EAST) {
				if (state.get(CONNECTED_UP) == true) {
					if (state.get(CONNECTED_DOWN) == true) {
					    return FULL_BPME_SHAPE;
					} else {
					    return FULL_BPBE_SHAPE;
					}
				} else if (state.get(CONNECTED_DOWN) == true) {
					if (state.get(CONNECTED_UP) == true) {
					    return FULL_BPME_SHAPE;
					} else {
						return FULL_BPTE_SHAPE;
					}
				} else {
					return FULL_BPME_SHAPE;
				}
			} else if (state.get(SIDE) == Direction.SOUTH) {
				if (state.get(CONNECTED_UP) == true) {
					if (state.get(CONNECTED_DOWN) == true) {
					    return FULL_BPMS_SHAPE;
					} else {
					    return FULL_BPBS_SHAPE;
					}
				} else if (state.get(CONNECTED_DOWN) == true) {
					if (state.get(CONNECTED_UP) == true) {
					    return FULL_BPMS_SHAPE;
					} else {
						return FULL_BPTS_SHAPE;
					}
				} else {
					return FULL_BPMS_SHAPE;
				}
			} else if (state.get(SIDE) == Direction.WEST) {
				if (state.get(CONNECTED_UP) == true) {
					if (state.get(CONNECTED_DOWN) == true) {
					    return FULL_BPMW_SHAPE;
					} else {
					    return FULL_BPBW_SHAPE;
					}
				} else if (state.get(CONNECTED_DOWN) == true) {
					if (state.get(CONNECTED_UP) == true) {
					    return FULL_BPMW_SHAPE;
					} else {
						return FULL_BPTW_SHAPE;
					}
				} else {
					return FULL_BPMW_SHAPE;
				}
			} else if (state.get(SIDE) == Direction.NORTH) {
				if (state.get(CONNECTED_UP) == true) {
					if (state.get(CONNECTED_DOWN) == true) {
					    return FULL_BPMN_SHAPE;
					} else {
					    return FULL_BPBN_SHAPE;
					}
				} else if (state.get(CONNECTED_DOWN) == true) {
					if (state.get(CONNECTED_UP) == true) {
					    return FULL_BPMN_SHAPE;
					} else {
						return FULL_BPTN_SHAPE;
					}
				} else {
					return FULL_BPMN_SHAPE;
				}
			} else {
				return VoxelShapes.fullCube();
			}
		}
	}
	
	public PillarBlock(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
		this.setDefaultState(this.stateContainer.getBaseState().with(CONNECTED_UP, false).with(CONNECTED_DOWN, false).with(SIZE, PillarSize.SMALL).with(SIDE, Direction.NORTH).with(WATERLOGGED, Boolean.valueOf(false)));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(CONNECTED_UP, CONNECTED_DOWN, SIZE, SIDE, WATERLOGGED);
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		BlockState blockstate = this.getDefaultState().with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
		return getState(blockstate, context.getWorld(), blockpos);
	}
	
	@SuppressWarnings("deprecation")
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}

	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return IWaterLoggable.super.receiveFluid(worldIn, pos, state, fluidStateIn);
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
	   return IWaterLoggable.super.canContainFluid(worldIn, pos, state, fluidIn);
	}
	
	private BlockState getState(BlockState blockstate, IWorld worldIn, BlockPos blockpos) {
	    BlockPos blockposnorth = blockpos.north();
	    Block blocknorth = worldIn.getBlockState(blockposnorth).getBlock();
	    Boolean northbool = blocknorth.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatenorth = worldIn.getBlockState(blockposnorth);
	    
	    BlockPos blockposeast = blockpos.east();
	    Block blockeast = worldIn.getBlockState(blockposeast).getBlock();
	    Boolean eastbool = blockeast.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstateeast = worldIn.getBlockState(blockposeast);
	    
	    BlockPos blockpossouth = blockpos.south();
	    Block blocksouth = worldIn.getBlockState(blockpossouth).getBlock();
	    Boolean southbool = blocksouth.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatesouth = worldIn.getBlockState(blockpossouth);
	    
	    BlockPos blockposwest = blockpos.west();
	    Block blockwest = worldIn.getBlockState(blockposwest).getBlock();
	    Boolean westbool = blockwest.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatewest = worldIn.getBlockState(blockposwest);
	    
	    BlockPos blockposdown = blockpos.down();
	    Block blockdown = worldIn.getBlockState(blockposdown).getBlock();
	    Boolean downbool = blockdown.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatedown = worldIn.getBlockState(blockposdown);
	    
	    BlockPos blockposup = blockpos.up();
	    Block blockup = worldIn.getBlockState(blockposup).getBlock();
	    Boolean upbool = blockup.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstateup = worldIn.getBlockState(blockposup);
	    
	    BlockPos blockposnorthwest = blockpos.north().west();
	    Block blocknorthwest = worldIn.getBlockState(blockposnorthwest).getBlock();
	    Boolean northwestbool = blocknorthwest.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatenorthwest = worldIn.getBlockState(blockposnorthwest);
	    
	    BlockPos blockposnortheast = blockpos.north().east();
	    Block blocknortheast = worldIn.getBlockState(blockposnortheast).getBlock();
	    Boolean northeastbool = blocknortheast.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatenortheast = worldIn.getBlockState(blockposnortheast);
	    
	    BlockPos blockpossoutheast = blockpos.south().east();
	    Block blocksoutheast = worldIn.getBlockState(blockpossoutheast).getBlock();
	    Boolean southeastbool = blocksoutheast.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatesoutheast = worldIn.getBlockState(blockpossoutheast);
	    
	    BlockPos blockpossouthwest = blockpos.south().west();
	    Block blocksouthwest = worldIn.getBlockState(blockpossouthwest).getBlock();
	    Boolean southwestbool = blocksouthwest.getTags().contains(new ResourceLocation(MoBlocks.MODID, "pillars"));
	    BlockState blockstatesouthwest = worldIn.getBlockState(blockpossouthwest);
	    
	    if (upbool && downbool) {
	        if (blockstate.get(SIDE) == blockstateup.get(SIDE) &&
	        		blockstate.get(SIZE) == blockstateup.get(SIZE)) {
	            blockstate = blockstate.with(CONNECTED_UP, true);
	        } else {
	            blockstate = blockstate.with(CONNECTED_UP, false);
	        }
	        if (blockstate.get(SIDE) == blockstatedown.get(SIDE) &&
	        		blockstate.get(SIZE) == blockstatedown.get(SIZE)) {
	            blockstate = blockstate.with(CONNECTED_DOWN, true);
	        } else {
	            blockstate = blockstate.with(CONNECTED_DOWN, false);
	        }
	    } else if (upbool && !downbool) {
	        if (blockstate.get(SIDE) == blockstateup.get(SIDE) &&
	        		blockstate.get(SIZE) == blockstateup.get(SIZE)) {
	            blockstate = blockstate.with(CONNECTED_UP, true);
	            blockstate = blockstate.with(CONNECTED_DOWN, false);
	        } else {
	            blockstate = blockstate.with(CONNECTED_UP, false);
	            blockstate = blockstate.with(CONNECTED_DOWN, false);
	        }
	    } else if (!upbool && downbool) {
	        if (blockstate.get(SIDE) == blockstatedown.get(SIDE) &&
	        		blockstate.get(SIZE) == blockstatedown.get(SIZE)) {
	            blockstate = blockstate.with(CONNECTED_UP, false);
	            blockstate = blockstate.with(CONNECTED_DOWN, true);
	        } else {
	            blockstate = blockstate.with(CONNECTED_UP, false);
	            blockstate = blockstate.with(CONNECTED_DOWN, false);
	        }
	    } else {
            blockstate = blockstate.with(CONNECTED_UP, false);
            blockstate = blockstate.with(CONNECTED_DOWN, false);
	    }
	    
	    if (southwestbool) {
	        if (southbool && westbool) {
	        	if ((blockstatesouth.get(SIZE) == PillarSize.SMALL &&
	    				blockstatewest.get(SIZE) == PillarSize.SMALL &&
	    				blockstatesouthwest.get(SIZE) == PillarSize.SMALL) ||
		    				((blockstatesouth.get(SIZE) == PillarSize.BIG && blockstatesouth.get(SIDE) == Direction.NORTH) ||
		        			(blockstatewest.get(SIZE) == PillarSize.BIG && blockstatewest.get(SIDE) == Direction.SOUTH) ||
		        			(blockstatesouthwest.get(SIZE) == PillarSize.BIG && blockstatesouthwest.get(SIDE) == Direction.EAST))) {
		            blockstate = blockstate.with(SIDE, Direction.WEST);
		            blockstate = blockstate.with(SIZE, PillarSize.BIG);
             	}
	        } else {
	            blockstate = blockstate.with(SIZE, PillarSize.SMALL);
	        }
	    } else if (southeastbool) {
	        if (southbool && eastbool) {
	        	if ((blockstatesouth.get(SIZE) == PillarSize.SMALL &&
	    				blockstateeast.get(SIZE) == PillarSize.SMALL &&
	    				blockstatesoutheast.get(SIZE) == PillarSize.SMALL) ||
    	    				((blockstatesouth.get(SIZE) == PillarSize.BIG && blockstatesouth.get(SIDE) == Direction.EAST) ||
    	        			(blockstateeast.get(SIZE) == PillarSize.BIG && blockstateeast.get(SIDE) == Direction.WEST) ||
    	        			(blockstatesoutheast.get(SIZE) == PillarSize.BIG && blockstatesoutheast.get(SIDE) == Direction.NORTH))) {
		            blockstate = blockstate.with(SIDE, Direction.SOUTH);
		            blockstate = blockstate.with(SIZE, PillarSize.BIG);
	        	}
	        } else {
	            blockstate = blockstate.with(SIZE, PillarSize.SMALL);
	        }
	    } else if (northwestbool) {
	        if (northbool && westbool) {
	        	if ((blockstatenorth.get(SIZE) == PillarSize.SMALL &&
	    				blockstatewest.get(SIZE) == PillarSize.SMALL &&
	    				blockstatenorthwest.get(SIZE) == PillarSize.SMALL) ||
    	    				((blockstatenorth.get(SIZE) == PillarSize.BIG && blockstatenorth.get(SIDE) == Direction.WEST) ||
    	        			(blockstatewest.get(SIZE) == PillarSize.BIG && blockstatewest.get(SIDE) == Direction.EAST) ||
    	        			(blockstatenorthwest.get(SIZE) == PillarSize.BIG && blockstatenorthwest.get(SIDE) == Direction.SOUTH))) {
		            blockstate = blockstate.with(SIDE, Direction.NORTH);
		            blockstate = blockstate.with(SIZE, PillarSize.BIG);
	        	}
	        } else {
	            blockstate = blockstate.with(SIZE, PillarSize.SMALL);
	        }
	    } else if (northeastbool) {
	        if (northbool && eastbool) {
	        	if ((blockstatenorth.get(SIZE) == PillarSize.SMALL &&
	    				blockstateeast.get(SIZE) == PillarSize.SMALL &&
	    				blockstatenortheast.get(SIZE) == PillarSize.SMALL) ||
		    				((blockstatenorth.get(SIZE) == PillarSize.BIG && blockstatenorth.get(SIDE) == Direction.SOUTH) ||
		        			(blockstateeast.get(SIZE) == PillarSize.BIG && blockstateeast.get(SIDE) == Direction.SOUTH) ||
		        			(blockstatenortheast.get(SIZE) == PillarSize.BIG && blockstatenortheast.get(SIDE) == Direction.WEST))) {
		            blockstate = blockstate.with(SIDE, Direction.EAST);
		            blockstate = blockstate.with(SIZE, PillarSize.BIG);
	        	}
	        } else {
	            blockstate = blockstate.with(SIZE, PillarSize.SMALL);
	        }
	    } else {
	        blockstate = blockstate.with(SIZE, PillarSize.SMALL);
	    }
	    return blockstate;
	}

	
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		
		return getState(stateIn, worldIn, currentPos);
	}

	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		switch(type) {
		case LAND:
			return false;
		case WATER:
			return worldIn.getFluidState(pos).isTagged(FluidTags.WATER);
		case AIR:
			return false;
		default:
			return false;
		}
	}
}
