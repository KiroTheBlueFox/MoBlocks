package kirothebluefox.moblocks.content.specialblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class InvertedArchBlock extends StairsBlock {
	/** Straight block
	* SCBN = Straight block collision boxes, right side up, facing North
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCBN = {{0, 0, 0, 16, 4, 1},
	                                          {0, 0, 1, 16, 7, 2},
	                                          {0, 0, 2, 16, 9, 3},
	                                          {0, 0, 3, 16, 10, 4},
	                                          {0, 0, 4, 16, 11, 5},
	                                          {0, 0, 5, 16, 12, 6},
	                                          {0, 0, 6, 16, 13, 7},
	                                          {0, 0, 7, 16, 14, 9},
	                                          {0, 0, 9, 16, 15, 12},
	                                          {0, 0, 12, 16, 16, 16}};
	protected static final VoxelShape SCBNPart1 = Block.makeCuboidShape(SCBN[0][0], SCBN[0][1], SCBN[0][2], SCBN[0][3], SCBN[0][4], SCBN[0][5]);
	protected static final VoxelShape SCBNPart2 = Block.makeCuboidShape(SCBN[1][0], SCBN[1][1], SCBN[1][2], SCBN[1][3], SCBN[1][4], SCBN[1][5]);
	protected static final VoxelShape SCBNPart3 = Block.makeCuboidShape(SCBN[2][0], SCBN[2][1], SCBN[2][2], SCBN[2][3], SCBN[2][4], SCBN[2][5]);
	protected static final VoxelShape SCBNPart4 = Block.makeCuboidShape(SCBN[3][0], SCBN[3][1], SCBN[3][2], SCBN[3][3], SCBN[3][4], SCBN[3][5]);
	protected static final VoxelShape SCBNPart5 = Block.makeCuboidShape(SCBN[4][0], SCBN[4][1], SCBN[4][2], SCBN[4][3], SCBN[4][4], SCBN[4][5]);
	protected static final VoxelShape SCBNPart6 = Block.makeCuboidShape(SCBN[5][0], SCBN[5][1], SCBN[5][2], SCBN[5][3], SCBN[5][4], SCBN[5][5]);
	protected static final VoxelShape SCBNPart7 = Block.makeCuboidShape(SCBN[6][0], SCBN[6][1], SCBN[6][2], SCBN[6][3], SCBN[6][4], SCBN[6][5]);
	protected static final VoxelShape SCBNPart8 = Block.makeCuboidShape(SCBN[7][0], SCBN[7][1], SCBN[7][2], SCBN[7][3], SCBN[7][4], SCBN[7][5]);
	protected static final VoxelShape SCBNPart9 = Block.makeCuboidShape(SCBN[8][0], SCBN[8][1], SCBN[8][2], SCBN[8][3], SCBN[8][4], SCBN[8][5]);
	protected static final VoxelShape SCBNPart10 = Block.makeCuboidShape(SCBN[9][0], SCBN[9][1], SCBN[9][2], SCBN[9][3], SCBN[9][4], SCBN[9][5]);
	private static final VoxelShape FULL_SCBN_SHAPE = VoxelShapes.or(SCBNPart1, SCBNPart2, SCBNPart3, SCBNPart4, SCBNPart5, SCBNPart6, SCBNPart7, SCBNPart8, SCBNPart9, SCBNPart10);

	/** Straight block
	* SCBS = Straight block collision boxes, right side up, facing South
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCBS = {{0, 0, 15, 16, 4, 16},
	                                          {0, 0, 14, 16, 7, 15},
	                                          {0, 0, 13, 16, 9, 14},
	                                          {0, 0, 12, 16, 10, 13},
	                                          {0, 0, 11, 16, 11, 12},
	                                          {0, 0, 10, 16, 12, 11},
	                                          {0, 0, 9, 16, 13, 10},
	                                          {0, 0, 7, 16, 14, 9},
	                                          {0, 0, 4, 16, 15, 7},
	                                          {0, 0, 0, 16, 16, 4}};
	protected static final VoxelShape SCBSPart1 = Block.makeCuboidShape(SCBS[0][0], SCBS[0][1], SCBS[0][2], SCBS[0][3], SCBS[0][4], SCBS[0][5]);
	protected static final VoxelShape SCBSPart2 = Block.makeCuboidShape(SCBS[1][0], SCBS[1][1], SCBS[1][2], SCBS[1][3], SCBS[1][4], SCBS[1][5]);
	protected static final VoxelShape SCBSPart3 = Block.makeCuboidShape(SCBS[2][0], SCBS[2][1], SCBS[2][2], SCBS[2][3], SCBS[2][4], SCBS[2][5]);
	protected static final VoxelShape SCBSPart4 = Block.makeCuboidShape(SCBS[3][0], SCBS[3][1], SCBS[3][2], SCBS[3][3], SCBS[3][4], SCBS[3][5]);
	protected static final VoxelShape SCBSPart5 = Block.makeCuboidShape(SCBS[4][0], SCBS[4][1], SCBS[4][2], SCBS[4][3], SCBS[4][4], SCBS[4][5]);
	protected static final VoxelShape SCBSPart6 = Block.makeCuboidShape(SCBS[5][0], SCBS[5][1], SCBS[5][2], SCBS[5][3], SCBS[5][4], SCBS[5][5]);
	protected static final VoxelShape SCBSPart7 = Block.makeCuboidShape(SCBS[6][0], SCBS[6][1], SCBS[6][2], SCBS[6][3], SCBS[6][4], SCBS[6][5]);
	protected static final VoxelShape SCBSPart8 = Block.makeCuboidShape(SCBS[7][0], SCBS[7][1], SCBS[7][2], SCBS[7][3], SCBS[7][4], SCBS[7][5]);
	protected static final VoxelShape SCBSPart9 = Block.makeCuboidShape(SCBS[8][0], SCBS[8][1], SCBS[8][2], SCBS[8][3], SCBS[8][4], SCBS[8][5]);
	protected static final VoxelShape SCBSPart10 = Block.makeCuboidShape(SCBS[9][0], SCBS[9][1], SCBS[9][2], SCBS[9][3], SCBS[9][4], SCBS[9][5]);
	private static final VoxelShape FULL_SCBS_SHAPE = VoxelShapes.or(SCBSPart1, SCBSPart2, SCBSPart3, SCBSPart4, SCBSPart5, SCBSPart6, SCBSPart7, SCBSPart8, SCBSPart9, SCBSPart10);

	/** Straight block
	* SCTS = Straight block collision boxes, upside down, facing South
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCTS = {{0, 12, 15, 16, 16, 16},
	                                          {0, 9, 14, 16, 16, 15},
	                                          {0, 7, 13, 16, 16, 14},
	                                          {0, 6, 12, 16, 16, 13},
	                                          {0, 5, 11, 16, 16, 12},
	                                          {0, 4, 10, 16, 16, 11},
	                                          {0, 3, 9, 16, 16, 10},
	                                          {0, 2, 7, 16, 16, 9},
	                                          {0, 1, 4, 16, 16, 7},
	                                          {0, 0, 0, 16, 16, 4}};
	protected static final VoxelShape SCTSPart1 = Block.makeCuboidShape(SCTS[0][0], SCTS[0][1], SCTS[0][2], SCTS[0][3], SCTS[0][4], SCTS[0][5]);
	protected static final VoxelShape SCTSPart2 = Block.makeCuboidShape(SCTS[1][0], SCTS[1][1], SCTS[1][2], SCTS[1][3], SCTS[1][4], SCTS[1][5]);
	protected static final VoxelShape SCTSPart3 = Block.makeCuboidShape(SCTS[2][0], SCTS[2][1], SCTS[2][2], SCTS[2][3], SCTS[2][4], SCTS[2][5]);
	protected static final VoxelShape SCTSPart4 = Block.makeCuboidShape(SCTS[3][0], SCTS[3][1], SCTS[3][2], SCTS[3][3], SCTS[3][4], SCTS[3][5]);
	protected static final VoxelShape SCTSPart5 = Block.makeCuboidShape(SCTS[4][0], SCTS[4][1], SCTS[4][2], SCTS[4][3], SCTS[4][4], SCTS[4][5]);
	protected static final VoxelShape SCTSPart6 = Block.makeCuboidShape(SCTS[5][0], SCTS[5][1], SCTS[5][2], SCTS[5][3], SCTS[5][4], SCTS[5][5]);
	protected static final VoxelShape SCTSPart7 = Block.makeCuboidShape(SCTS[6][0], SCTS[6][1], SCTS[6][2], SCTS[6][3], SCTS[6][4], SCTS[6][5]);
	protected static final VoxelShape SCTSPart8 = Block.makeCuboidShape(SCTS[7][0], SCTS[7][1], SCTS[7][2], SCTS[7][3], SCTS[7][4], SCTS[7][5]);
	protected static final VoxelShape SCTSPart9 = Block.makeCuboidShape(SCTS[8][0], SCTS[8][1], SCTS[8][2], SCTS[8][3], SCTS[8][4], SCTS[8][5]);
	protected static final VoxelShape SCTSPart10 = Block.makeCuboidShape(SCTS[9][0], SCTS[9][1], SCTS[9][2], SCTS[9][3], SCTS[9][4], SCTS[9][5]);
	private static final VoxelShape FULL_SCTS_SHAPE = VoxelShapes.or(SCTSPart1, SCTSPart2, SCTSPart3, SCTSPart4, SCTSPart5, SCTSPart6, SCTSPart7, SCTSPart8, SCTSPart9, SCTSPart10);

	/** Straight block
	* SCTN = Straight block collision boxes, upside down, facing North
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCTN = {{0, 12, 0, 16, 16, 1},
	                                          {0, 9, 1, 16, 16, 2},
	                                          {0, 7, 2, 16, 16, 3},
	                                          {0, 6, 3, 16, 16, 4},
	                                          {0, 5, 4, 16, 16, 5},
	                                          {0, 4, 5, 16, 16, 6},
	                                          {0, 3, 6, 16, 16, 7},
	                                          {0, 2, 7, 16, 16, 9},
	                                          {0, 1, 9, 16, 16, 12},
	                                          {0, 0, 12, 16, 16, 16}};
	protected static final VoxelShape SCTNPart1 = Block.makeCuboidShape(SCTN[0][0], SCTN[0][1], SCTN[0][2], SCTN[0][3], SCTN[0][4], SCTN[0][5]);
	protected static final VoxelShape SCTNPart2 = Block.makeCuboidShape(SCTN[1][0], SCTN[1][1], SCTN[1][2], SCTN[1][3], SCTN[1][4], SCTN[1][5]);
	protected static final VoxelShape SCTNPart3 = Block.makeCuboidShape(SCTN[2][0], SCTN[2][1], SCTN[2][2], SCTN[2][3], SCTN[2][4], SCTN[2][5]);
	protected static final VoxelShape SCTNPart4 = Block.makeCuboidShape(SCTN[3][0], SCTN[3][1], SCTN[3][2], SCTN[3][3], SCTN[3][4], SCTN[3][5]);
	protected static final VoxelShape SCTNPart5 = Block.makeCuboidShape(SCTN[4][0], SCTN[4][1], SCTN[4][2], SCTN[4][3], SCTN[4][4], SCTN[4][5]);
	protected static final VoxelShape SCTNPart6 = Block.makeCuboidShape(SCTN[5][0], SCTN[5][1], SCTN[5][2], SCTN[5][3], SCTN[5][4], SCTN[5][5]);
	protected static final VoxelShape SCTNPart7 = Block.makeCuboidShape(SCTN[6][0], SCTN[6][1], SCTN[6][2], SCTN[6][3], SCTN[6][4], SCTN[6][5]);
	protected static final VoxelShape SCTNPart8 = Block.makeCuboidShape(SCTN[7][0], SCTN[7][1], SCTN[7][2], SCTN[7][3], SCTN[7][4], SCTN[7][5]);
	protected static final VoxelShape SCTNPart9 = Block.makeCuboidShape(SCTN[8][0], SCTN[8][1], SCTN[8][2], SCTN[8][3], SCTN[8][4], SCTN[8][5]);
	protected static final VoxelShape SCTNPart10 = Block.makeCuboidShape(SCTN[9][0], SCTN[9][1], SCTN[9][2], SCTN[9][3], SCTN[9][4], SCTN[9][5]);
	private static final VoxelShape FULL_SCTN_SHAPE = VoxelShapes.or(SCTNPart1, SCTNPart2, SCTNPart3, SCTNPart4, SCTNPart5, SCTNPart6, SCTNPart7, SCTNPart8, SCTNPart9, SCTNPart10);

	/** Straight block
	* SCBW = Straight block collision boxes, right side up, facing West
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCBW = {{0, 0, 0, 1, 4, 16},
	                                          {1, 0, 0, 2, 7, 16},
	                                          {2, 0, 0, 3, 9, 16},
	                                          {3, 0, 0, 4, 10, 16},
	                                          {4, 0, 0, 5, 11, 16},
	                                          {5, 0, 0, 6, 12, 16},
	                                          {6, 0, 0, 7, 13, 16},
	                                          {7, 0, 0, 9, 14, 16},
	                                          {9, 0, 0, 12, 15, 16},
	                                          {12, 0, 0, 16, 16, 16}};
	protected static final VoxelShape SCBWPart1 = Block.makeCuboidShape(SCBW[0][0], SCBW[0][1], SCBW[0][2], SCBW[0][3], SCBW[0][4], SCBW[0][5]);
	protected static final VoxelShape SCBWPart2 = Block.makeCuboidShape(SCBW[1][0], SCBW[1][1], SCBW[1][2], SCBW[1][3], SCBW[1][4], SCBW[1][5]);
	protected static final VoxelShape SCBWPart3 = Block.makeCuboidShape(SCBW[2][0], SCBW[2][1], SCBW[2][2], SCBW[2][3], SCBW[2][4], SCBW[2][5]);
	protected static final VoxelShape SCBWPart4 = Block.makeCuboidShape(SCBW[3][0], SCBW[3][1], SCBW[3][2], SCBW[3][3], SCBW[3][4], SCBW[3][5]);
	protected static final VoxelShape SCBWPart5 = Block.makeCuboidShape(SCBW[4][0], SCBW[4][1], SCBW[4][2], SCBW[4][3], SCBW[4][4], SCBW[4][5]);
	protected static final VoxelShape SCBWPart6 = Block.makeCuboidShape(SCBW[5][0], SCBW[5][1], SCBW[5][2], SCBW[5][3], SCBW[5][4], SCBW[5][5]);
	protected static final VoxelShape SCBWPart7 = Block.makeCuboidShape(SCBW[6][0], SCBW[6][1], SCBW[6][2], SCBW[6][3], SCBW[6][4], SCBW[6][5]);
	protected static final VoxelShape SCBWPart8 = Block.makeCuboidShape(SCBW[7][0], SCBW[7][1], SCBW[7][2], SCBW[7][3], SCBW[7][4], SCBW[7][5]);
	protected static final VoxelShape SCBWPart9 = Block.makeCuboidShape(SCBW[8][0], SCBW[8][1], SCBW[8][2], SCBW[8][3], SCBW[8][4], SCBW[8][5]);
	protected static final VoxelShape SCBWPart10 = Block.makeCuboidShape(SCBW[9][0], SCBW[9][1], SCBW[9][2], SCBW[9][3], SCBW[9][4], SCBW[9][5]);
	private static final VoxelShape FULL_SCBW_SHAPE = VoxelShapes.or(SCBWPart1, SCBWPart2, SCBWPart3, SCBWPart4, SCBWPart5, SCBWPart6, SCBWPart7, SCBWPart8, SCBWPart9, SCBWPart10);

	/** Straight block
	* SCTW = Straight block collision boxes, upside down, facing West
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCTW = {{0, 12, 0, 1, 16, 16},
	                                          {1, 9, 0, 2, 16, 16},
	                                          {2, 7, 0, 3, 16, 16},
	                                          {3, 6, 0, 4, 16, 16},
	                                          {4, 5, 0, 5, 16, 16},
	                                          {5, 4, 0, 6, 16, 16},
	                                          {6, 3, 0, 7, 16, 16},
	                                          {7, 2, 0, 9, 16, 16},
	                                          {9, 1, 0, 12, 16, 16},
	                                          {12, 0, 0, 16, 16, 16}};
	protected static final VoxelShape SCTWPart1 = Block.makeCuboidShape(SCTW[0][0], SCTW[0][1], SCTW[0][2], SCTW[0][3], SCTW[0][4], SCTW[0][5]);
	protected static final VoxelShape SCTWPart2 = Block.makeCuboidShape(SCTW[1][0], SCTW[1][1], SCTW[1][2], SCTW[1][3], SCTW[1][4], SCTW[1][5]);
	protected static final VoxelShape SCTWPart3 = Block.makeCuboidShape(SCTW[2][0], SCTW[2][1], SCTW[2][2], SCTW[2][3], SCTW[2][4], SCTW[2][5]);
	protected static final VoxelShape SCTWPart4 = Block.makeCuboidShape(SCTW[3][0], SCTW[3][1], SCTW[3][2], SCTW[3][3], SCTW[3][4], SCTW[3][5]);
	protected static final VoxelShape SCTWPart5 = Block.makeCuboidShape(SCTW[4][0], SCTW[4][1], SCTW[4][2], SCTW[4][3], SCTW[4][4], SCTW[4][5]);
	protected static final VoxelShape SCTWPart6 = Block.makeCuboidShape(SCTW[5][0], SCTW[5][1], SCTW[5][2], SCTW[5][3], SCTW[5][4], SCTW[5][5]);
	protected static final VoxelShape SCTWPart7 = Block.makeCuboidShape(SCTW[6][0], SCTW[6][1], SCTW[6][2], SCTW[6][3], SCTW[6][4], SCTW[6][5]);
	protected static final VoxelShape SCTWPart8 = Block.makeCuboidShape(SCTW[7][0], SCTW[7][1], SCTW[7][2], SCTW[7][3], SCTW[7][4], SCTW[7][5]);
	protected static final VoxelShape SCTWPart9 = Block.makeCuboidShape(SCTW[8][0], SCTW[8][1], SCTW[8][2], SCTW[8][3], SCTW[8][4], SCTW[8][5]);
	protected static final VoxelShape SCTWPart10 = Block.makeCuboidShape(SCTW[9][0], SCTW[9][1], SCTW[9][2], SCTW[9][3], SCTW[9][4], SCTW[9][5]);
	private static final VoxelShape FULL_SCTW_SHAPE = VoxelShapes.or(SCTWPart1, SCTWPart2, SCTWPart3, SCTWPart4, SCTWPart5, SCTWPart6, SCTWPart7, SCTWPart8, SCTWPart9, SCTWPart10);

	/** Straight block
	* SCTE = Straight block collision boxes, upside down, facing East
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCTE = {{15, 12, 0, 16, 16, 16},
	                                          {14, 9, 0, 15, 16, 16},
	                                          {13, 7, 0, 14, 16, 16},
	                                          {12, 6, 0, 13, 16, 16},
	                                          {11, 5, 0, 12, 16, 16},
	                                          {10, 4, 0, 11, 16, 16},
	                                          {9, 3, 0, 10, 16, 16},
	                                          {7, 2, 0, 9, 16, 16},
	                                          {4, 1, 0, 7, 16, 16},
	                                          {0, 0, 0, 4, 16, 16}};
	protected static final VoxelShape SCTEPart1 = Block.makeCuboidShape(SCTE[0][0], SCTE[0][1], SCTE[0][2], SCTE[0][3], SCTE[0][4], SCTE[0][5]);
	protected static final VoxelShape SCTEPart2 = Block.makeCuboidShape(SCTE[1][0], SCTE[1][1], SCTE[1][2], SCTE[1][3], SCTE[1][4], SCTE[1][5]);
	protected static final VoxelShape SCTEPart3 = Block.makeCuboidShape(SCTE[2][0], SCTE[2][1], SCTE[2][2], SCTE[2][3], SCTE[2][4], SCTE[2][5]);
	protected static final VoxelShape SCTEPart4 = Block.makeCuboidShape(SCTE[3][0], SCTE[3][1], SCTE[3][2], SCTE[3][3], SCTE[3][4], SCTE[3][5]);
	protected static final VoxelShape SCTEPart5 = Block.makeCuboidShape(SCTE[4][0], SCTE[4][1], SCTE[4][2], SCTE[4][3], SCTE[4][4], SCTE[4][5]);
	protected static final VoxelShape SCTEPart6 = Block.makeCuboidShape(SCTE[5][0], SCTE[5][1], SCTE[5][2], SCTE[5][3], SCTE[5][4], SCTE[5][5]);
	protected static final VoxelShape SCTEPart7 = Block.makeCuboidShape(SCTE[6][0], SCTE[6][1], SCTE[6][2], SCTE[6][3], SCTE[6][4], SCTE[6][5]);
	protected static final VoxelShape SCTEPart8 = Block.makeCuboidShape(SCTE[7][0], SCTE[7][1], SCTE[7][2], SCTE[7][3], SCTE[7][4], SCTE[7][5]);
	protected static final VoxelShape SCTEPart9 = Block.makeCuboidShape(SCTE[8][0], SCTE[8][1], SCTE[8][2], SCTE[8][3], SCTE[8][4], SCTE[8][5]);
	protected static final VoxelShape SCTEPart10 = Block.makeCuboidShape(SCTE[9][0], SCTE[9][1], SCTE[9][2], SCTE[9][3], SCTE[9][4], SCTE[9][5]);
	private static final VoxelShape FULL_SCTE_SHAPE = VoxelShapes.or(SCTEPart1, SCTEPart2, SCTEPart3, SCTEPart4, SCTEPart5, SCTEPart6, SCTEPart7, SCTEPart8, SCTEPart9, SCTEPart10);

	/** Straight block
	* SCBE = Straight block collision boxes, right side up, facing East
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] SCBE = {{15, 0, 0, 16, 4, 16},
	                                          {14, 0, 0, 15, 7, 16},
	                                          {13, 0, 0, 14, 9, 16},
	                                          {12, 0, 0, 13, 10, 16},
	                                          {11, 0, 0, 12, 11, 16},
	                                          {10, 0, 0, 11, 12, 16},
	                                          {9, 0, 0, 10, 13, 16},
	                                          {7, 0, 0, 9, 14, 16},
	                                          {4, 0, 0, 7, 15, 16},
	                                          {0, 0, 0, 4, 16, 16}};
	protected static final VoxelShape SCBEPart1 = Block.makeCuboidShape(SCBE[0][0], SCBE[0][1], SCBE[0][2], SCBE[0][3], SCBE[0][4], SCBE[0][5]);
	protected static final VoxelShape SCBEPart2 = Block.makeCuboidShape(SCBE[1][0], SCBE[1][1], SCBE[1][2], SCBE[1][3], SCBE[1][4], SCBE[1][5]);
	protected static final VoxelShape SCBEPart3 = Block.makeCuboidShape(SCBE[2][0], SCBE[2][1], SCBE[2][2], SCBE[2][3], SCBE[2][4], SCBE[2][5]);
	protected static final VoxelShape SCBEPart4 = Block.makeCuboidShape(SCBE[3][0], SCBE[3][1], SCBE[3][2], SCBE[3][3], SCBE[3][4], SCBE[3][5]);
	protected static final VoxelShape SCBEPart5 = Block.makeCuboidShape(SCBE[4][0], SCBE[4][1], SCBE[4][2], SCBE[4][3], SCBE[4][4], SCBE[4][5]);
	protected static final VoxelShape SCBEPart6 = Block.makeCuboidShape(SCBE[5][0], SCBE[5][1], SCBE[5][2], SCBE[5][3], SCBE[5][4], SCBE[5][5]);
	protected static final VoxelShape SCBEPart7 = Block.makeCuboidShape(SCBE[6][0], SCBE[6][1], SCBE[6][2], SCBE[6][3], SCBE[6][4], SCBE[6][5]);
	protected static final VoxelShape SCBEPart8 = Block.makeCuboidShape(SCBE[7][0], SCBE[7][1], SCBE[7][2], SCBE[7][3], SCBE[7][4], SCBE[7][5]);
	protected static final VoxelShape SCBEPart9 = Block.makeCuboidShape(SCBE[8][0], SCBE[8][1], SCBE[8][2], SCBE[8][3], SCBE[8][4], SCBE[8][5]);
	protected static final VoxelShape SCBEPart10 = Block.makeCuboidShape(SCBE[9][0], SCBE[9][1], SCBE[9][2], SCBE[9][3], SCBE[9][4], SCBE[9][5]);
	private static final VoxelShape FULL_SCBE_SHAPE = VoxelShapes.or(SCBEPart1, SCBEPart2, SCBEPart3, SCBEPart4, SCBEPart5, SCBEPart6, SCBEPart7, SCBEPart8, SCBEPart9, SCBEPart10);

	/** Inner corner block
	* ICBN = Inner corner block collision boxes, right side up, facing North
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICBN = {{0, 0, 0, 1, 4, 1},
	                                          {0, 0, 1, 2, 7, 2},
	                                          {12, 0, 0, 16, 16, 12},
	                                          {9, 0, 0, 12, 15, 9},
	                                          {7, 0, 0, 9, 14, 7},
	                                          {6, 0, 0, 7, 13, 6},
	                                          {5, 0, 0, 6, 12, 5},
	                                          {4, 0, 0, 5, 11, 4},
	                                          {3, 0, 0, 4, 10, 3},
	                                          {2, 0, 0, 3, 9, 2},
	                                          {1, 0, 0, 2, 7, 1},
	                                          {0, 0, 2, 3, 9, 3},
	                                          {0, 0, 3, 4, 10, 4},
	                                          {0, 0, 4, 5, 11, 5},
	                                          {0, 0, 5, 6, 12, 6},
	                                          {0, 0, 6, 7, 13, 7},
	                                          {0, 0, 7, 9, 14, 9},
	                                          {0, 0, 9, 12, 15, 12},
	                                          {0, 0, 12, 16, 16, 16}};
	protected static final VoxelShape ICBNPart1 = Block.makeCuboidShape(ICBN[0][0], ICBN[0][1], ICBN[0][2], ICBN[0][3], ICBN[0][4], ICBN[0][5]);
	protected static final VoxelShape ICBNPart2 = Block.makeCuboidShape(ICBN[1][0], ICBN[1][1], ICBN[1][2], ICBN[1][3], ICBN[1][4], ICBN[1][5]);
	protected static final VoxelShape ICBNPart3 = Block.makeCuboidShape(ICBN[2][0], ICBN[2][1], ICBN[2][2], ICBN[2][3], ICBN[2][4], ICBN[2][5]);
	protected static final VoxelShape ICBNPart4 = Block.makeCuboidShape(ICBN[3][0], ICBN[3][1], ICBN[3][2], ICBN[3][3], ICBN[3][4], ICBN[3][5]);
	protected static final VoxelShape ICBNPart5 = Block.makeCuboidShape(ICBN[4][0], ICBN[4][1], ICBN[4][2], ICBN[4][3], ICBN[4][4], ICBN[4][5]);
	protected static final VoxelShape ICBNPart6 = Block.makeCuboidShape(ICBN[5][0], ICBN[5][1], ICBN[5][2], ICBN[5][3], ICBN[5][4], ICBN[5][5]);
	protected static final VoxelShape ICBNPart7 = Block.makeCuboidShape(ICBN[6][0], ICBN[6][1], ICBN[6][2], ICBN[6][3], ICBN[6][4], ICBN[6][5]);
	protected static final VoxelShape ICBNPart8 = Block.makeCuboidShape(ICBN[7][0], ICBN[7][1], ICBN[7][2], ICBN[7][3], ICBN[7][4], ICBN[7][5]);
	protected static final VoxelShape ICBNPart9 = Block.makeCuboidShape(ICBN[8][0], ICBN[8][1], ICBN[8][2], ICBN[8][3], ICBN[8][4], ICBN[8][5]);
	protected static final VoxelShape ICBNPart10 = Block.makeCuboidShape(ICBN[9][0], ICBN[9][1], ICBN[9][2], ICBN[9][3], ICBN[9][4], ICBN[9][5]);
	protected static final VoxelShape ICBNPart11 = Block.makeCuboidShape(ICBN[10][0], ICBN[10][1], ICBN[10][2], ICBN[10][3], ICBN[10][4], ICBN[10][5]);
	protected static final VoxelShape ICBNPart12 = Block.makeCuboidShape(ICBN[11][0], ICBN[11][1], ICBN[11][2], ICBN[11][3], ICBN[11][4], ICBN[11][5]);
	protected static final VoxelShape ICBNPart13 = Block.makeCuboidShape(ICBN[12][0], ICBN[12][1], ICBN[12][2], ICBN[12][3], ICBN[12][4], ICBN[12][5]);
	protected static final VoxelShape ICBNPart14 = Block.makeCuboidShape(ICBN[13][0], ICBN[13][1], ICBN[13][2], ICBN[13][3], ICBN[13][4], ICBN[13][5]);
	protected static final VoxelShape ICBNPart15 = Block.makeCuboidShape(ICBN[14][0], ICBN[14][1], ICBN[14][2], ICBN[14][3], ICBN[14][4], ICBN[14][5]);
	protected static final VoxelShape ICBNPart16 = Block.makeCuboidShape(ICBN[15][0], ICBN[15][1], ICBN[15][2], ICBN[15][3], ICBN[15][4], ICBN[15][5]);
	protected static final VoxelShape ICBNPart17 = Block.makeCuboidShape(ICBN[16][0], ICBN[16][1], ICBN[16][2], ICBN[16][3], ICBN[16][4], ICBN[16][5]);
	protected static final VoxelShape ICBNPart18 = Block.makeCuboidShape(ICBN[17][0], ICBN[17][1], ICBN[17][2], ICBN[17][3], ICBN[17][4], ICBN[17][5]);
	protected static final VoxelShape ICBNPart19 = Block.makeCuboidShape(ICBN[18][0], ICBN[18][1], ICBN[18][2], ICBN[18][3], ICBN[18][4], ICBN[18][5]);
	private static final VoxelShape FULL_ICBN_SHAPE = VoxelShapes.or(ICBNPart1, ICBNPart2, ICBNPart3, ICBNPart4, ICBNPart5, ICBNPart6, ICBNPart7, ICBNPart8, ICBNPart9, ICBNPart10, ICBNPart11, ICBNPart12, ICBNPart13, ICBNPart14, ICBNPart15, ICBNPart16, ICBNPart17, ICBNPart18, ICBNPart19);

	/** Inner corner block
	* ICTN = Inner corner block collision boxes, upside down, facing North
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICTN = {{0, 12, 0, 1, 16, 1},
	                                          {0, 9, 1, 2, 16, 2},
	                                          {12, 0, 0, 16, 16, 12},
	                                          {9, 1, 0, 12, 16, 9},
	                                          {7, 2, 0, 9, 16, 7},
	                                          {6, 3, 0, 7, 16, 6},
	                                          {5, 4, 0, 6, 16, 5},
	                                          {4, 5, 0, 5, 16, 4},
	                                          {3, 6, 0, 4, 16, 3},
	                                          {2, 7, 0, 3, 16, 2},
	                                          {1, 9, 0, 2, 16, 1},
	                                          {0, 7, 2, 3, 16, 3},
	                                          {0, 6, 3, 4, 16, 4},
	                                          {0, 5, 4, 5, 16, 5},
	                                          {0, 4, 5, 6, 16, 6},
	                                          {0, 3, 6, 7, 16, 7},
	                                          {0, 2, 7, 9, 16, 9},
	                                          {0, 1, 9, 12, 16, 12},
	                                          {0, 0, 12, 16, 16, 16}};
	protected static final VoxelShape ICTNPart1 = Block.makeCuboidShape(ICTN[0][0], ICTN[0][1], ICTN[0][2], ICTN[0][3], ICTN[0][4], ICTN[0][5]);
	protected static final VoxelShape ICTNPart2 = Block.makeCuboidShape(ICTN[1][0], ICTN[1][1], ICTN[1][2], ICTN[1][3], ICTN[1][4], ICTN[1][5]);
	protected static final VoxelShape ICTNPart3 = Block.makeCuboidShape(ICTN[2][0], ICTN[2][1], ICTN[2][2], ICTN[2][3], ICTN[2][4], ICTN[2][5]);
	protected static final VoxelShape ICTNPart4 = Block.makeCuboidShape(ICTN[3][0], ICTN[3][1], ICTN[3][2], ICTN[3][3], ICTN[3][4], ICTN[3][5]);
	protected static final VoxelShape ICTNPart5 = Block.makeCuboidShape(ICTN[4][0], ICTN[4][1], ICTN[4][2], ICTN[4][3], ICTN[4][4], ICTN[4][5]);
	protected static final VoxelShape ICTNPart6 = Block.makeCuboidShape(ICTN[5][0], ICTN[5][1], ICTN[5][2], ICTN[5][3], ICTN[5][4], ICTN[5][5]);
	protected static final VoxelShape ICTNPart7 = Block.makeCuboidShape(ICTN[6][0], ICTN[6][1], ICTN[6][2], ICTN[6][3], ICTN[6][4], ICTN[6][5]);
	protected static final VoxelShape ICTNPart8 = Block.makeCuboidShape(ICTN[7][0], ICTN[7][1], ICTN[7][2], ICTN[7][3], ICTN[7][4], ICTN[7][5]);
	protected static final VoxelShape ICTNPart9 = Block.makeCuboidShape(ICTN[8][0], ICTN[8][1], ICTN[8][2], ICTN[8][3], ICTN[8][4], ICTN[8][5]);
	protected static final VoxelShape ICTNPart10 = Block.makeCuboidShape(ICTN[9][0], ICTN[9][1], ICTN[9][2], ICTN[9][3], ICTN[9][4], ICTN[9][5]);
	protected static final VoxelShape ICTNPart11 = Block.makeCuboidShape(ICTN[10][0], ICTN[10][1], ICTN[10][2], ICTN[10][3], ICTN[10][4], ICTN[10][5]);
	protected static final VoxelShape ICTNPart12 = Block.makeCuboidShape(ICTN[11][0], ICTN[11][1], ICTN[11][2], ICTN[11][3], ICTN[11][4], ICTN[11][5]);
	protected static final VoxelShape ICTNPart13 = Block.makeCuboidShape(ICTN[12][0], ICTN[12][1], ICTN[12][2], ICTN[12][3], ICTN[12][4], ICTN[12][5]);
	protected static final VoxelShape ICTNPart14 = Block.makeCuboidShape(ICTN[13][0], ICTN[13][1], ICTN[13][2], ICTN[13][3], ICTN[13][4], ICTN[13][5]);
	protected static final VoxelShape ICTNPart15 = Block.makeCuboidShape(ICTN[14][0], ICTN[14][1], ICTN[14][2], ICTN[14][3], ICTN[14][4], ICTN[14][5]);
	protected static final VoxelShape ICTNPart16 = Block.makeCuboidShape(ICTN[15][0], ICTN[15][1], ICTN[15][2], ICTN[15][3], ICTN[15][4], ICTN[15][5]);
	protected static final VoxelShape ICTNPart17 = Block.makeCuboidShape(ICTN[16][0], ICTN[16][1], ICTN[16][2], ICTN[16][3], ICTN[16][4], ICTN[16][5]);
	protected static final VoxelShape ICTNPart18 = Block.makeCuboidShape(ICTN[17][0], ICTN[17][1], ICTN[17][2], ICTN[17][3], ICTN[17][4], ICTN[17][5]);
	protected static final VoxelShape ICTNPart19 = Block.makeCuboidShape(ICTN[18][0], ICTN[18][1], ICTN[18][2], ICTN[18][3], ICTN[18][4], ICTN[18][5]);
	private static final VoxelShape FULL_ICTN_SHAPE = VoxelShapes.or(ICTNPart1, ICTNPart2, ICTNPart3, ICTNPart4, ICTNPart5, ICTNPart6, ICTNPart7, ICTNPart8, ICTNPart9, ICTNPart10, ICTNPart11, ICTNPart12, ICTNPart13, ICTNPart14, ICTNPart15, ICTNPart16, ICTNPart17, ICTNPart18, ICTNPart19);

	/** Inner corner block
	* ICBW = Inner corner block collision boxes, right side up, facing West
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICBW = {{0, 0, 15, 1, 4, 16},
	                                          {0, 0, 14, 2, 7, 15},
	                                          {12, 0, 4, 16, 16, 16},
	                                          {9, 0, 7, 12, 15, 16},
	                                          {7, 0, 9, 9, 14, 16},
	                                          {6, 0, 10, 7, 13, 16},
	                                          {5, 0, 11, 6, 12, 16},
	                                          {4, 0, 12, 5, 11, 16},
	                                          {3, 0, 13, 4, 10, 16},
	                                          {2, 0, 14, 3, 9, 16},
	                                          {1, 0, 15, 2, 7, 16},
	                                          {0, 0, 13, 3, 9, 14},
	                                          {0, 0, 12, 4, 10, 13},
	                                          {0, 0, 11, 5, 11, 12},
	                                          {0, 0, 10, 6, 12, 11},
	                                          {0, 0, 9, 7, 13, 10},
	                                          {0, 0, 7, 9, 14, 9},
	                                          {0, 0, 4, 12, 15, 7},
	                                          {0, 0, 0, 16, 16, 4}};
	protected static final VoxelShape ICBWPart1 = Block.makeCuboidShape(ICBW[0][0], ICBW[0][1], ICBW[0][2], ICBW[0][3], ICBW[0][4], ICBW[0][5]);
	protected static final VoxelShape ICBWPart2 = Block.makeCuboidShape(ICBW[1][0], ICBW[1][1], ICBW[1][2], ICBW[1][3], ICBW[1][4], ICBW[1][5]);
	protected static final VoxelShape ICBWPart3 = Block.makeCuboidShape(ICBW[2][0], ICBW[2][1], ICBW[2][2], ICBW[2][3], ICBW[2][4], ICBW[2][5]);
	protected static final VoxelShape ICBWPart4 = Block.makeCuboidShape(ICBW[3][0], ICBW[3][1], ICBW[3][2], ICBW[3][3], ICBW[3][4], ICBW[3][5]);
	protected static final VoxelShape ICBWPart5 = Block.makeCuboidShape(ICBW[4][0], ICBW[4][1], ICBW[4][2], ICBW[4][3], ICBW[4][4], ICBW[4][5]);
	protected static final VoxelShape ICBWPart6 = Block.makeCuboidShape(ICBW[5][0], ICBW[5][1], ICBW[5][2], ICBW[5][3], ICBW[5][4], ICBW[5][5]);
	protected static final VoxelShape ICBWPart7 = Block.makeCuboidShape(ICBW[6][0], ICBW[6][1], ICBW[6][2], ICBW[6][3], ICBW[6][4], ICBW[6][5]);
	protected static final VoxelShape ICBWPart8 = Block.makeCuboidShape(ICBW[7][0], ICBW[7][1], ICBW[7][2], ICBW[7][3], ICBW[7][4], ICBW[7][5]);
	protected static final VoxelShape ICBWPart9 = Block.makeCuboidShape(ICBW[8][0], ICBW[8][1], ICBW[8][2], ICBW[8][3], ICBW[8][4], ICBW[8][5]);
	protected static final VoxelShape ICBWPart10 = Block.makeCuboidShape(ICBW[9][0], ICBW[9][1], ICBW[9][2], ICBW[9][3], ICBW[9][4], ICBW[9][5]);
	protected static final VoxelShape ICBWPart11 = Block.makeCuboidShape(ICBW[10][0], ICBW[10][1], ICBW[10][2], ICBW[10][3], ICBW[10][4], ICBW[10][5]);
	protected static final VoxelShape ICBWPart12 = Block.makeCuboidShape(ICBW[11][0], ICBW[11][1], ICBW[11][2], ICBW[11][3], ICBW[11][4], ICBW[11][5]);
	protected static final VoxelShape ICBWPart13 = Block.makeCuboidShape(ICBW[12][0], ICBW[12][1], ICBW[12][2], ICBW[12][3], ICBW[12][4], ICBW[12][5]);
	protected static final VoxelShape ICBWPart14 = Block.makeCuboidShape(ICBW[13][0], ICBW[13][1], ICBW[13][2], ICBW[13][3], ICBW[13][4], ICBW[13][5]);
	protected static final VoxelShape ICBWPart15 = Block.makeCuboidShape(ICBW[14][0], ICBW[14][1], ICBW[14][2], ICBW[14][3], ICBW[14][4], ICBW[14][5]);
	protected static final VoxelShape ICBWPart16 = Block.makeCuboidShape(ICBW[15][0], ICBW[15][1], ICBW[15][2], ICBW[15][3], ICBW[15][4], ICBW[15][5]);
	protected static final VoxelShape ICBWPart17 = Block.makeCuboidShape(ICBW[16][0], ICBW[16][1], ICBW[16][2], ICBW[16][3], ICBW[16][4], ICBW[16][5]);
	protected static final VoxelShape ICBWPart18 = Block.makeCuboidShape(ICBW[17][0], ICBW[17][1], ICBW[17][2], ICBW[17][3], ICBW[17][4], ICBW[17][5]);
	protected static final VoxelShape ICBWPart19 = Block.makeCuboidShape(ICBW[18][0], ICBW[18][1], ICBW[18][2], ICBW[18][3], ICBW[18][4], ICBW[18][5]);
	private static final VoxelShape FULL_ICBW_SHAPE = VoxelShapes.or(ICBWPart1, ICBWPart2, ICBWPart3, ICBWPart4, ICBWPart5, ICBWPart6, ICBWPart7, ICBWPart8, ICBWPart9, ICBWPart10, ICBWPart11, ICBWPart12, ICBWPart13, ICBWPart14, ICBWPart15, ICBWPart16, ICBWPart17, ICBWPart18, ICBWPart19);

	/** Inner corner block
	* ICTW = Inner corner block collision boxes, upside down, facing West
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICTW = {{0, 12, 15, 1, 16, 16},
	                                          {0, 9, 14, 2, 16, 15},
	                                          {12, 0, 4, 16, 16, 16},
	                                          {9, 1, 7, 12, 16, 16},
	                                          {7, 2, 9, 9, 16, 16},
	                                          {6, 3, 10, 7, 16, 16},
	                                          {5, 4, 11, 6, 16, 16},
	                                          {4, 5, 12, 5, 16, 16},
	                                          {3, 6, 13, 4, 16, 16},
	                                          {2, 7, 14, 3, 16, 16},
	                                          {1, 9, 15, 2, 16, 16},
	                                          {0, 7, 13, 3, 16, 14},
	                                          {0, 6, 12, 4, 16, 13},
	                                          {0, 5, 11, 5, 16, 12},
	                                          {0, 4, 10, 6, 16, 11},
	                                          {0, 3, 9, 7, 16, 10},
	                                          {0, 2, 7, 9, 16, 9},
	                                          {0, 1, 4, 12, 16, 7},
	                                          {0, 0, 0, 16, 16, 4}};
	protected static final VoxelShape ICTWPart1 = Block.makeCuboidShape(ICTW[0][0], ICTW[0][1], ICTW[0][2], ICTW[0][3], ICTW[0][4], ICTW[0][5]);
	protected static final VoxelShape ICTWPart2 = Block.makeCuboidShape(ICTW[1][0], ICTW[1][1], ICTW[1][2], ICTW[1][3], ICTW[1][4], ICTW[1][5]);
	protected static final VoxelShape ICTWPart3 = Block.makeCuboidShape(ICTW[2][0], ICTW[2][1], ICTW[2][2], ICTW[2][3], ICTW[2][4], ICTW[2][5]);
	protected static final VoxelShape ICTWPart4 = Block.makeCuboidShape(ICTW[3][0], ICTW[3][1], ICTW[3][2], ICTW[3][3], ICTW[3][4], ICTW[3][5]);
	protected static final VoxelShape ICTWPart5 = Block.makeCuboidShape(ICTW[4][0], ICTW[4][1], ICTW[4][2], ICTW[4][3], ICTW[4][4], ICTW[4][5]);
	protected static final VoxelShape ICTWPart6 = Block.makeCuboidShape(ICTW[5][0], ICTW[5][1], ICTW[5][2], ICTW[5][3], ICTW[5][4], ICTW[5][5]);
	protected static final VoxelShape ICTWPart7 = Block.makeCuboidShape(ICTW[6][0], ICTW[6][1], ICTW[6][2], ICTW[6][3], ICTW[6][4], ICTW[6][5]);
	protected static final VoxelShape ICTWPart8 = Block.makeCuboidShape(ICTW[7][0], ICTW[7][1], ICTW[7][2], ICTW[7][3], ICTW[7][4], ICTW[7][5]);
	protected static final VoxelShape ICTWPart9 = Block.makeCuboidShape(ICTW[8][0], ICTW[8][1], ICTW[8][2], ICTW[8][3], ICTW[8][4], ICTW[8][5]);
	protected static final VoxelShape ICTWPart10 = Block.makeCuboidShape(ICTW[9][0], ICTW[9][1], ICTW[9][2], ICTW[9][3], ICTW[9][4], ICTW[9][5]);
	protected static final VoxelShape ICTWPart11 = Block.makeCuboidShape(ICTW[10][0], ICTW[10][1], ICTW[10][2], ICTW[10][3], ICTW[10][4], ICTW[10][5]);
	protected static final VoxelShape ICTWPart12 = Block.makeCuboidShape(ICTW[11][0], ICTW[11][1], ICTW[11][2], ICTW[11][3], ICTW[11][4], ICTW[11][5]);
	protected static final VoxelShape ICTWPart13 = Block.makeCuboidShape(ICTW[12][0], ICTW[12][1], ICTW[12][2], ICTW[12][3], ICTW[12][4], ICTW[12][5]);
	protected static final VoxelShape ICTWPart14 = Block.makeCuboidShape(ICTW[13][0], ICTW[13][1], ICTW[13][2], ICTW[13][3], ICTW[13][4], ICTW[13][5]);
	protected static final VoxelShape ICTWPart15 = Block.makeCuboidShape(ICTW[14][0], ICTW[14][1], ICTW[14][2], ICTW[14][3], ICTW[14][4], ICTW[14][5]);
	protected static final VoxelShape ICTWPart16 = Block.makeCuboidShape(ICTW[15][0], ICTW[15][1], ICTW[15][2], ICTW[15][3], ICTW[15][4], ICTW[15][5]);
	protected static final VoxelShape ICTWPart17 = Block.makeCuboidShape(ICTW[16][0], ICTW[16][1], ICTW[16][2], ICTW[16][3], ICTW[16][4], ICTW[16][5]);
	protected static final VoxelShape ICTWPart18 = Block.makeCuboidShape(ICTW[17][0], ICTW[17][1], ICTW[17][2], ICTW[17][3], ICTW[17][4], ICTW[17][5]);
	protected static final VoxelShape ICTWPart19 = Block.makeCuboidShape(ICTW[18][0], ICTW[18][1], ICTW[18][2], ICTW[18][3], ICTW[18][4], ICTW[18][5]);
	private static final VoxelShape FULL_ICTW_SHAPE = VoxelShapes.or(ICTWPart1, ICTWPart2, ICTWPart3, ICTWPart4, ICTWPart5, ICTWPart6, ICTWPart7, ICTWPart8, ICTWPart9, ICTWPart10, ICTWPart11, ICTWPart12, ICTWPart13, ICTWPart14, ICTWPart15, ICTWPart16, ICTWPart17, ICTWPart18, ICTWPart19);

	/** Inner corner block
	* ICBS = Inner corner block collision boxes, right side up, facing South
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICBS = {{15, 0, 15, 16, 4, 16},
	                                          {14, 0, 14, 16, 7, 15},
	                                          {0, 0, 4, 4, 16, 16},
	                                          {4, 0, 7, 7, 15, 16},
	                                          {7, 0, 9, 9, 14, 16},
	                                          {9, 0, 10, 10, 13, 16},
	                                          {10, 0, 11, 11, 12, 16},
	                                          {11, 0, 12, 12, 11, 16},
	                                          {12, 0, 13, 13, 10, 16},
	                                          {13, 0, 14, 14, 9, 16},
	                                          {14, 0, 15, 15, 7, 16},
	                                          {13, 0, 13, 16, 9, 14},
	                                          {12, 0, 12, 16, 10, 13},
	                                          {11, 0, 11, 16, 11, 12},
	                                          {10, 0, 10, 16, 12, 11},
	                                          {9, 0, 9, 16, 13, 10},
	                                          {7, 0, 7, 16, 14, 9},
	                                          {4, 0, 4, 16, 15, 7},
	                                          {0, 0, 0, 16, 16, 4}};
	protected static final VoxelShape ICBSPart1 = Block.makeCuboidShape(ICBS[0][0], ICBS[0][1], ICBS[0][2], ICBS[0][3], ICBS[0][4], ICBS[0][5]);
	protected static final VoxelShape ICBSPart2 = Block.makeCuboidShape(ICBS[1][0], ICBS[1][1], ICBS[1][2], ICBS[1][3], ICBS[1][4], ICBS[1][5]);
	protected static final VoxelShape ICBSPart3 = Block.makeCuboidShape(ICBS[2][0], ICBS[2][1], ICBS[2][2], ICBS[2][3], ICBS[2][4], ICBS[2][5]);
	protected static final VoxelShape ICBSPart4 = Block.makeCuboidShape(ICBS[3][0], ICBS[3][1], ICBS[3][2], ICBS[3][3], ICBS[3][4], ICBS[3][5]);
	protected static final VoxelShape ICBSPart5 = Block.makeCuboidShape(ICBS[4][0], ICBS[4][1], ICBS[4][2], ICBS[4][3], ICBS[4][4], ICBS[4][5]);
	protected static final VoxelShape ICBSPart6 = Block.makeCuboidShape(ICBS[5][0], ICBS[5][1], ICBS[5][2], ICBS[5][3], ICBS[5][4], ICBS[5][5]);
	protected static final VoxelShape ICBSPart7 = Block.makeCuboidShape(ICBS[6][0], ICBS[6][1], ICBS[6][2], ICBS[6][3], ICBS[6][4], ICBS[6][5]);
	protected static final VoxelShape ICBSPart8 = Block.makeCuboidShape(ICBS[7][0], ICBS[7][1], ICBS[7][2], ICBS[7][3], ICBS[7][4], ICBS[7][5]);
	protected static final VoxelShape ICBSPart9 = Block.makeCuboidShape(ICBS[8][0], ICBS[8][1], ICBS[8][2], ICBS[8][3], ICBS[8][4], ICBS[8][5]);
	protected static final VoxelShape ICBSPart10 = Block.makeCuboidShape(ICBS[9][0], ICBS[9][1], ICBS[9][2], ICBS[9][3], ICBS[9][4], ICBS[9][5]);
	protected static final VoxelShape ICBSPart11 = Block.makeCuboidShape(ICBS[10][0], ICBS[10][1], ICBS[10][2], ICBS[10][3], ICBS[10][4], ICBS[10][5]);
	protected static final VoxelShape ICBSPart12 = Block.makeCuboidShape(ICBS[11][0], ICBS[11][1], ICBS[11][2], ICBS[11][3], ICBS[11][4], ICBS[11][5]);
	protected static final VoxelShape ICBSPart13 = Block.makeCuboidShape(ICBS[12][0], ICBS[12][1], ICBS[12][2], ICBS[12][3], ICBS[12][4], ICBS[12][5]);
	protected static final VoxelShape ICBSPart14 = Block.makeCuboidShape(ICBS[13][0], ICBS[13][1], ICBS[13][2], ICBS[13][3], ICBS[13][4], ICBS[13][5]);
	protected static final VoxelShape ICBSPart15 = Block.makeCuboidShape(ICBS[14][0], ICBS[14][1], ICBS[14][2], ICBS[14][3], ICBS[14][4], ICBS[14][5]);
	protected static final VoxelShape ICBSPart16 = Block.makeCuboidShape(ICBS[15][0], ICBS[15][1], ICBS[15][2], ICBS[15][3], ICBS[15][4], ICBS[15][5]);
	protected static final VoxelShape ICBSPart17 = Block.makeCuboidShape(ICBS[16][0], ICBS[16][1], ICBS[16][2], ICBS[16][3], ICBS[16][4], ICBS[16][5]);
	protected static final VoxelShape ICBSPart18 = Block.makeCuboidShape(ICBS[17][0], ICBS[17][1], ICBS[17][2], ICBS[17][3], ICBS[17][4], ICBS[17][5]);
	protected static final VoxelShape ICBSPart19 = Block.makeCuboidShape(ICBS[18][0], ICBS[18][1], ICBS[18][2], ICBS[18][3], ICBS[18][4], ICBS[18][5]);
	private static final VoxelShape FULL_ICBS_SHAPE = VoxelShapes.or(ICBSPart1, ICBSPart2, ICBSPart3, ICBSPart4, ICBSPart5, ICBSPart6, ICBSPart7, ICBSPart8, ICBSPart9, ICBSPart10, ICBSPart11, ICBSPart12, ICBSPart13, ICBSPart14, ICBSPart15, ICBSPart16, ICBSPart17, ICBSPart18, ICBSPart19);

	/** Inner corner block
	* ICTS = Inner corner block collision boxes, upside down, facing South
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICTS = {{15, 12, 15, 16, 16, 16},
	                                          {14, 9, 14, 16, 16, 15},
	                                          {0, 0, 4, 4, 16, 16},
	                                          {4, 1, 7, 7, 16, 16},
	                                          {7, 2, 9, 9, 16, 16},
	                                          {9, 3, 10, 10, 16, 16},
	                                          {10, 4, 11, 11, 16, 16},
	                                          {11, 5, 12, 12, 16, 16},
	                                          {12, 6, 13, 13, 16, 16},
	                                          {13, 7, 14, 14, 16, 16},
	                                          {14, 9, 15, 15, 16, 16},
	                                          {13, 7, 13, 16, 16, 14},
	                                          {12, 6, 12, 16, 16, 13},
	                                          {11, 5, 11, 16, 16, 12},
	                                          {10, 4, 10, 16, 16, 11},
	                                          {9, 3, 9, 16, 16, 10},
	                                          {7, 2, 7, 16, 16, 9},
	                                          {4, 1, 4, 16, 16, 7},
	                                          {0, 0, 0, 16, 16, 4}};
	protected static final VoxelShape ICTSPart1 = Block.makeCuboidShape(ICTS[0][0], ICTS[0][1], ICTS[0][2], ICTS[0][3], ICTS[0][4], ICTS[0][5]);
	protected static final VoxelShape ICTSPart2 = Block.makeCuboidShape(ICTS[1][0], ICTS[1][1], ICTS[1][2], ICTS[1][3], ICTS[1][4], ICTS[1][5]);
	protected static final VoxelShape ICTSPart3 = Block.makeCuboidShape(ICTS[2][0], ICTS[2][1], ICTS[2][2], ICTS[2][3], ICTS[2][4], ICTS[2][5]);
	protected static final VoxelShape ICTSPart4 = Block.makeCuboidShape(ICTS[3][0], ICTS[3][1], ICTS[3][2], ICTS[3][3], ICTS[3][4], ICTS[3][5]);
	protected static final VoxelShape ICTSPart5 = Block.makeCuboidShape(ICTS[4][0], ICTS[4][1], ICTS[4][2], ICTS[4][3], ICTS[4][4], ICTS[4][5]);
	protected static final VoxelShape ICTSPart6 = Block.makeCuboidShape(ICTS[5][0], ICTS[5][1], ICTS[5][2], ICTS[5][3], ICTS[5][4], ICTS[5][5]);
	protected static final VoxelShape ICTSPart7 = Block.makeCuboidShape(ICTS[6][0], ICTS[6][1], ICTS[6][2], ICTS[6][3], ICTS[6][4], ICTS[6][5]);
	protected static final VoxelShape ICTSPart8 = Block.makeCuboidShape(ICTS[7][0], ICTS[7][1], ICTS[7][2], ICTS[7][3], ICTS[7][4], ICTS[7][5]);
	protected static final VoxelShape ICTSPart9 = Block.makeCuboidShape(ICTS[8][0], ICTS[8][1], ICTS[8][2], ICTS[8][3], ICTS[8][4], ICTS[8][5]);
	protected static final VoxelShape ICTSPart10 = Block.makeCuboidShape(ICTS[9][0], ICTS[9][1], ICTS[9][2], ICTS[9][3], ICTS[9][4], ICTS[9][5]);
	protected static final VoxelShape ICTSPart11 = Block.makeCuboidShape(ICTS[10][0], ICTS[10][1], ICTS[10][2], ICTS[10][3], ICTS[10][4], ICTS[10][5]);
	protected static final VoxelShape ICTSPart12 = Block.makeCuboidShape(ICTS[11][0], ICTS[11][1], ICTS[11][2], ICTS[11][3], ICTS[11][4], ICTS[11][5]);
	protected static final VoxelShape ICTSPart13 = Block.makeCuboidShape(ICTS[12][0], ICTS[12][1], ICTS[12][2], ICTS[12][3], ICTS[12][4], ICTS[12][5]);
	protected static final VoxelShape ICTSPart14 = Block.makeCuboidShape(ICTS[13][0], ICTS[13][1], ICTS[13][2], ICTS[13][3], ICTS[13][4], ICTS[13][5]);
	protected static final VoxelShape ICTSPart15 = Block.makeCuboidShape(ICTS[14][0], ICTS[14][1], ICTS[14][2], ICTS[14][3], ICTS[14][4], ICTS[14][5]);
	protected static final VoxelShape ICTSPart16 = Block.makeCuboidShape(ICTS[15][0], ICTS[15][1], ICTS[15][2], ICTS[15][3], ICTS[15][4], ICTS[15][5]);
	protected static final VoxelShape ICTSPart17 = Block.makeCuboidShape(ICTS[16][0], ICTS[16][1], ICTS[16][2], ICTS[16][3], ICTS[16][4], ICTS[16][5]);
	protected static final VoxelShape ICTSPart18 = Block.makeCuboidShape(ICTS[17][0], ICTS[17][1], ICTS[17][2], ICTS[17][3], ICTS[17][4], ICTS[17][5]);
	protected static final VoxelShape ICTSPart19 = Block.makeCuboidShape(ICTS[18][0], ICTS[18][1], ICTS[18][2], ICTS[18][3], ICTS[18][4], ICTS[18][5]);
	private static final VoxelShape FULL_ICTS_SHAPE = VoxelShapes.or(ICTSPart1, ICTSPart2, ICTSPart3, ICTSPart4, ICTSPart5, ICTSPart6, ICTSPart7, ICTSPart8, ICTSPart9, ICTSPart10, ICTSPart11, ICTSPart12, ICTSPart13, ICTSPart14, ICTSPart15, ICTSPart16, ICTSPart17, ICTSPart18, ICTSPart19);

	/** Inner corner block
	* ICBE = Inner corner block collision boxes, right side up, facing East
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICBE = {{15, 0, 0, 16, 4, 1},
	                                          {14, 0, 1, 16, 7, 2},
	                                          {0, 0, 0, 4, 16, 12},
	                                          {4, 0, 0, 7, 15, 9},
	                                          {7, 0, 0, 9, 14, 7},
	                                          {9, 0, 0, 10, 13, 6},
	                                          {10, 0, 0, 11, 12, 5},
	                                          {11, 0, 0, 12, 11, 4},
	                                          {12, 0, 0, 13, 10, 3},
	                                          {13, 0, 0, 14, 9, 2},
	                                          {14, 0, 0, 15, 7, 1},
	                                          {13, 0, 2, 16, 9, 3},
	                                          {12, 0, 3, 16, 10, 4},
	                                          {11, 0, 4, 16, 11, 5},
	                                          {10, 0, 5, 16, 12, 6},
	                                          {9, 0, 6, 16, 13, 7},
	                                          {7, 0, 7, 16, 14, 9},
	                                          {4, 0, 9, 16, 15, 12},
	                                          {0, 0, 12, 16, 16, 16}};
	protected static final VoxelShape ICBEPart1 = Block.makeCuboidShape(ICBE[0][0], ICBE[0][1], ICBE[0][2], ICBE[0][3], ICBE[0][4], ICBE[0][5]);
	protected static final VoxelShape ICBEPart2 = Block.makeCuboidShape(ICBE[1][0], ICBE[1][1], ICBE[1][2], ICBE[1][3], ICBE[1][4], ICBE[1][5]);
	protected static final VoxelShape ICBEPart3 = Block.makeCuboidShape(ICBE[2][0], ICBE[2][1], ICBE[2][2], ICBE[2][3], ICBE[2][4], ICBE[2][5]);
	protected static final VoxelShape ICBEPart4 = Block.makeCuboidShape(ICBE[3][0], ICBE[3][1], ICBE[3][2], ICBE[3][3], ICBE[3][4], ICBE[3][5]);
	protected static final VoxelShape ICBEPart5 = Block.makeCuboidShape(ICBE[4][0], ICBE[4][1], ICBE[4][2], ICBE[4][3], ICBE[4][4], ICBE[4][5]);
	protected static final VoxelShape ICBEPart6 = Block.makeCuboidShape(ICBE[5][0], ICBE[5][1], ICBE[5][2], ICBE[5][3], ICBE[5][4], ICBE[5][5]);
	protected static final VoxelShape ICBEPart7 = Block.makeCuboidShape(ICBE[6][0], ICBE[6][1], ICBE[6][2], ICBE[6][3], ICBE[6][4], ICBE[6][5]);
	protected static final VoxelShape ICBEPart8 = Block.makeCuboidShape(ICBE[7][0], ICBE[7][1], ICBE[7][2], ICBE[7][3], ICBE[7][4], ICBE[7][5]);
	protected static final VoxelShape ICBEPart9 = Block.makeCuboidShape(ICBE[8][0], ICBE[8][1], ICBE[8][2], ICBE[8][3], ICBE[8][4], ICBE[8][5]);
	protected static final VoxelShape ICBEPart10 = Block.makeCuboidShape(ICBE[9][0], ICBE[9][1], ICBE[9][2], ICBE[9][3], ICBE[9][4], ICBE[9][5]);
	protected static final VoxelShape ICBEPart11 = Block.makeCuboidShape(ICBE[10][0], ICBE[10][1], ICBE[10][2], ICBE[10][3], ICBE[10][4], ICBE[10][5]);
	protected static final VoxelShape ICBEPart12 = Block.makeCuboidShape(ICBE[11][0], ICBE[11][1], ICBE[11][2], ICBE[11][3], ICBE[11][4], ICBE[11][5]);
	protected static final VoxelShape ICBEPart13 = Block.makeCuboidShape(ICBE[12][0], ICBE[12][1], ICBE[12][2], ICBE[12][3], ICBE[12][4], ICBE[12][5]);
	protected static final VoxelShape ICBEPart14 = Block.makeCuboidShape(ICBE[13][0], ICBE[13][1], ICBE[13][2], ICBE[13][3], ICBE[13][4], ICBE[13][5]);
	protected static final VoxelShape ICBEPart15 = Block.makeCuboidShape(ICBE[14][0], ICBE[14][1], ICBE[14][2], ICBE[14][3], ICBE[14][4], ICBE[14][5]);
	protected static final VoxelShape ICBEPart16 = Block.makeCuboidShape(ICBE[15][0], ICBE[15][1], ICBE[15][2], ICBE[15][3], ICBE[15][4], ICBE[15][5]);
	protected static final VoxelShape ICBEPart17 = Block.makeCuboidShape(ICBE[16][0], ICBE[16][1], ICBE[16][2], ICBE[16][3], ICBE[16][4], ICBE[16][5]);
	protected static final VoxelShape ICBEPart18 = Block.makeCuboidShape(ICBE[17][0], ICBE[17][1], ICBE[17][2], ICBE[17][3], ICBE[17][4], ICBE[17][5]);
	protected static final VoxelShape ICBEPart19 = Block.makeCuboidShape(ICBE[18][0], ICBE[18][1], ICBE[18][2], ICBE[18][3], ICBE[18][4], ICBE[18][5]);
	private static final VoxelShape FULL_ICBE_SHAPE = VoxelShapes.or(ICBEPart1, ICBEPart2, ICBEPart3, ICBEPart4, ICBEPart5, ICBEPart6, ICBEPart7, ICBEPart8, ICBEPart9, ICBEPart10, ICBEPart11, ICBEPart12, ICBEPart13, ICBEPart14, ICBEPart15, ICBEPart16, ICBEPart17, ICBEPart18, ICBEPart19);

	/** Inner corner block
	* ICTE = Inner corner block collision boxes, upside down, facing East
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] ICTE = {{15, 12, 0, 16, 16, 1},
	                                          {14, 9, 1, 16, 16, 2},
	                                          {0, 0, 0, 4, 16, 12},
	                                          {4, 1, 0, 7, 16, 9},
	                                          {7, 2, 0, 9, 16, 7},
	                                          {9, 3, 0, 10, 16, 6},
	                                          {10, 4, 0, 11, 16, 5},
	                                          {11, 5, 0, 12, 16, 4},
	                                          {12, 6, 0, 13, 16, 3},
	                                          {13, 7, 0, 14, 16, 2},
	                                          {14, 9, 0, 15, 16, 1},
	                                          {13, 7, 2, 16, 16, 3},
	                                          {12, 6, 3, 16, 16, 4},
	                                          {11, 5, 4, 16, 16, 5},
	                                          {10, 4, 5, 16, 16, 6},
	                                          {9, 3, 6, 16, 16, 7},
	                                          {7, 2, 7, 16, 16, 9},
	                                          {4, 1, 9, 16, 16, 12},
	                                          {0, 0, 12, 16, 16, 16}};
	protected static final VoxelShape ICTEPart1 = Block.makeCuboidShape(ICTE[0][0], ICTE[0][1], ICTE[0][2], ICTE[0][3], ICTE[0][4], ICTE[0][5]);
	protected static final VoxelShape ICTEPart2 = Block.makeCuboidShape(ICTE[1][0], ICTE[1][1], ICTE[1][2], ICTE[1][3], ICTE[1][4], ICTE[1][5]);
	protected static final VoxelShape ICTEPart3 = Block.makeCuboidShape(ICTE[2][0], ICTE[2][1], ICTE[2][2], ICTE[2][3], ICTE[2][4], ICTE[2][5]);
	protected static final VoxelShape ICTEPart4 = Block.makeCuboidShape(ICTE[3][0], ICTE[3][1], ICTE[3][2], ICTE[3][3], ICTE[3][4], ICTE[3][5]);
	protected static final VoxelShape ICTEPart5 = Block.makeCuboidShape(ICTE[4][0], ICTE[4][1], ICTE[4][2], ICTE[4][3], ICTE[4][4], ICTE[4][5]);
	protected static final VoxelShape ICTEPart6 = Block.makeCuboidShape(ICTE[5][0], ICTE[5][1], ICTE[5][2], ICTE[5][3], ICTE[5][4], ICTE[5][5]);
	protected static final VoxelShape ICTEPart7 = Block.makeCuboidShape(ICTE[6][0], ICTE[6][1], ICTE[6][2], ICTE[6][3], ICTE[6][4], ICTE[6][5]);
	protected static final VoxelShape ICTEPart8 = Block.makeCuboidShape(ICTE[7][0], ICTE[7][1], ICTE[7][2], ICTE[7][3], ICTE[7][4], ICTE[7][5]);
	protected static final VoxelShape ICTEPart9 = Block.makeCuboidShape(ICTE[8][0], ICTE[8][1], ICTE[8][2], ICTE[8][3], ICTE[8][4], ICTE[8][5]);
	protected static final VoxelShape ICTEPart10 = Block.makeCuboidShape(ICTE[9][0], ICTE[9][1], ICTE[9][2], ICTE[9][3], ICTE[9][4], ICTE[9][5]);
	protected static final VoxelShape ICTEPart11 = Block.makeCuboidShape(ICTE[10][0], ICTE[10][1], ICTE[10][2], ICTE[10][3], ICTE[10][4], ICTE[10][5]);
	protected static final VoxelShape ICTEPart12 = Block.makeCuboidShape(ICTE[11][0], ICTE[11][1], ICTE[11][2], ICTE[11][3], ICTE[11][4], ICTE[11][5]);
	protected static final VoxelShape ICTEPart13 = Block.makeCuboidShape(ICTE[12][0], ICTE[12][1], ICTE[12][2], ICTE[12][3], ICTE[12][4], ICTE[12][5]);
	protected static final VoxelShape ICTEPart14 = Block.makeCuboidShape(ICTE[13][0], ICTE[13][1], ICTE[13][2], ICTE[13][3], ICTE[13][4], ICTE[13][5]);
	protected static final VoxelShape ICTEPart15 = Block.makeCuboidShape(ICTE[14][0], ICTE[14][1], ICTE[14][2], ICTE[14][3], ICTE[14][4], ICTE[14][5]);
	protected static final VoxelShape ICTEPart16 = Block.makeCuboidShape(ICTE[15][0], ICTE[15][1], ICTE[15][2], ICTE[15][3], ICTE[15][4], ICTE[15][5]);
	protected static final VoxelShape ICTEPart17 = Block.makeCuboidShape(ICTE[16][0], ICTE[16][1], ICTE[16][2], ICTE[16][3], ICTE[16][4], ICTE[16][5]);
	protected static final VoxelShape ICTEPart18 = Block.makeCuboidShape(ICTE[17][0], ICTE[17][1], ICTE[17][2], ICTE[17][3], ICTE[17][4], ICTE[17][5]);
	protected static final VoxelShape ICTEPart19 = Block.makeCuboidShape(ICTE[18][0], ICTE[18][1], ICTE[18][2], ICTE[18][3], ICTE[18][4], ICTE[18][5]);
	private static final VoxelShape FULL_ICTE_SHAPE = VoxelShapes.or(ICTEPart1, ICTEPart2, ICTEPart3, ICTEPart4, ICTEPart5, ICTEPart6, ICTEPart7, ICTEPart8, ICTEPart9, ICTEPart10, ICTEPart11, ICTEPart12, ICTEPart13, ICTEPart14, ICTEPart15, ICTEPart16, ICTEPart17, ICTEPart18, ICTEPart19);

	/** Outer corner block
	* OCBN = Outer corner block collision boxes, right side up, facing North
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCBN = {{0, 0, 0, 16, 4, 16},
	                                          {1, 4, 1, 16, 7, 16},
	                                          {2, 7, 2, 16, 9, 16},
	                                          {3, 9, 3, 16, 10, 16},
	                                          {7, 13, 7, 16, 14, 16},
	                                          {9, 14, 9, 16, 15, 16},
	                                          {12, 15, 12, 16, 16, 16},
	                                          {5, 11, 5, 16, 12, 16},
	                                          {6, 12, 6, 16, 13, 16},
	                                          {4, 10, 4, 16, 11, 16}};
	protected static final VoxelShape OCBNPart1 = Block.makeCuboidShape(OCBN[0][0], OCBN[0][1], OCBN[0][2], OCBN[0][3], OCBN[0][4], OCBN[0][5]);
	protected static final VoxelShape OCBNPart2 = Block.makeCuboidShape(OCBN[1][0], OCBN[1][1], OCBN[1][2], OCBN[1][3], OCBN[1][4], OCBN[1][5]);
	protected static final VoxelShape OCBNPart3 = Block.makeCuboidShape(OCBN[2][0], OCBN[2][1], OCBN[2][2], OCBN[2][3], OCBN[2][4], OCBN[2][5]);
	protected static final VoxelShape OCBNPart4 = Block.makeCuboidShape(OCBN[3][0], OCBN[3][1], OCBN[3][2], OCBN[3][3], OCBN[3][4], OCBN[3][5]);
	protected static final VoxelShape OCBNPart5 = Block.makeCuboidShape(OCBN[4][0], OCBN[4][1], OCBN[4][2], OCBN[4][3], OCBN[4][4], OCBN[4][5]);
	protected static final VoxelShape OCBNPart6 = Block.makeCuboidShape(OCBN[5][0], OCBN[5][1], OCBN[5][2], OCBN[5][3], OCBN[5][4], OCBN[5][5]);
	protected static final VoxelShape OCBNPart7 = Block.makeCuboidShape(OCBN[6][0], OCBN[6][1], OCBN[6][2], OCBN[6][3], OCBN[6][4], OCBN[6][5]);
	protected static final VoxelShape OCBNPart8 = Block.makeCuboidShape(OCBN[7][0], OCBN[7][1], OCBN[7][2], OCBN[7][3], OCBN[7][4], OCBN[7][5]);
	protected static final VoxelShape OCBNPart9 = Block.makeCuboidShape(OCBN[8][0], OCBN[8][1], OCBN[8][2], OCBN[8][3], OCBN[8][4], OCBN[8][5]);
	protected static final VoxelShape OCBNPart10 = Block.makeCuboidShape(OCBN[9][0], OCBN[9][1], OCBN[9][2], OCBN[9][3], OCBN[9][4], OCBN[9][5]);
	private static final VoxelShape FULL_OCBN_SHAPE = VoxelShapes.or(OCBNPart1, OCBNPart2, OCBNPart3, OCBNPart4, OCBNPart5, OCBNPart6, OCBNPart7, OCBNPart8, OCBNPart9, OCBNPart10);

	/** Outer corner block
	* OCTN = Outer corner block collision boxes, upside down, facing North
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCTN = {{0, 12, 0, 16, 16, 16},
	                                          {1, 9, 1, 16, 12, 16},
	                                          {2, 7, 2, 16, 9, 16},
	                                          {3, 6, 3, 16, 7, 16},
	                                          {7, 2, 7, 16, 3, 16},
	                                          {9, 1, 9, 16, 2, 16},
	                                          {12, 0, 12, 16, 1, 16},
	                                          {5, 4, 5, 16, 5, 16},
	                                          {6, 3, 6, 16, 4, 16},
	                                          {4, 5, 4, 16, 6, 16}};
	protected static final VoxelShape OCTNPart1 = Block.makeCuboidShape(OCTN[0][0], OCTN[0][1], OCTN[0][2], OCTN[0][3], OCTN[0][4], OCTN[0][5]);
	protected static final VoxelShape OCTNPart2 = Block.makeCuboidShape(OCTN[1][0], OCTN[1][1], OCTN[1][2], OCTN[1][3], OCTN[1][4], OCTN[1][5]);
	protected static final VoxelShape OCTNPart3 = Block.makeCuboidShape(OCTN[2][0], OCTN[2][1], OCTN[2][2], OCTN[2][3], OCTN[2][4], OCTN[2][5]);
	protected static final VoxelShape OCTNPart4 = Block.makeCuboidShape(OCTN[3][0], OCTN[3][1], OCTN[3][2], OCTN[3][3], OCTN[3][4], OCTN[3][5]);
	protected static final VoxelShape OCTNPart5 = Block.makeCuboidShape(OCTN[4][0], OCTN[4][1], OCTN[4][2], OCTN[4][3], OCTN[4][4], OCTN[4][5]);
	protected static final VoxelShape OCTNPart6 = Block.makeCuboidShape(OCTN[5][0], OCTN[5][1], OCTN[5][2], OCTN[5][3], OCTN[5][4], OCTN[5][5]);
	protected static final VoxelShape OCTNPart7 = Block.makeCuboidShape(OCTN[6][0], OCTN[6][1], OCTN[6][2], OCTN[6][3], OCTN[6][4], OCTN[6][5]);
	protected static final VoxelShape OCTNPart8 = Block.makeCuboidShape(OCTN[7][0], OCTN[7][1], OCTN[7][2], OCTN[7][3], OCTN[7][4], OCTN[7][5]);
	protected static final VoxelShape OCTNPart9 = Block.makeCuboidShape(OCTN[8][0], OCTN[8][1], OCTN[8][2], OCTN[8][3], OCTN[8][4], OCTN[8][5]);
	protected static final VoxelShape OCTNPart10 = Block.makeCuboidShape(OCTN[9][0], OCTN[9][1], OCTN[9][2], OCTN[9][3], OCTN[9][4], OCTN[9][5]);
	private static final VoxelShape FULL_OCTN_SHAPE = VoxelShapes.or(OCTNPart1, OCTNPart2, OCTNPart3, OCTNPart4, OCTNPart5, OCTNPart6, OCTNPart7, OCTNPart8, OCTNPart9, OCTNPart10);

	/** Outer corner block
	* OCBW = Outer corner block collision boxes, right side up, facing West
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCBW = {{0, 0, 0, 16, 4, 16},
	                                          {1, 4, 0, 16, 7, 15},
	                                          {2, 7, 0, 16, 9, 14},
	                                          {3, 9, 0, 16, 10, 13},
	                                          {7, 13, 0, 16, 14, 9},
	                                          {9, 14, 0, 16, 15, 7},
	                                          {12, 15, 0, 16, 16, 4},
	                                          {5, 11, 0, 16, 12, 11},
	                                          {6, 12, 0, 16, 13, 10},
	                                          {4, 10, 0, 16, 11, 12}};
	protected static final VoxelShape OCBWPart1 = Block.makeCuboidShape(OCBW[0][0], OCBW[0][1], OCBW[0][2], OCBW[0][3], OCBW[0][4], OCBW[0][5]);
	protected static final VoxelShape OCBWPart2 = Block.makeCuboidShape(OCBW[1][0], OCBW[1][1], OCBW[1][2], OCBW[1][3], OCBW[1][4], OCBW[1][5]);
	protected static final VoxelShape OCBWPart3 = Block.makeCuboidShape(OCBW[2][0], OCBW[2][1], OCBW[2][2], OCBW[2][3], OCBW[2][4], OCBW[2][5]);
	protected static final VoxelShape OCBWPart4 = Block.makeCuboidShape(OCBW[3][0], OCBW[3][1], OCBW[3][2], OCBW[3][3], OCBW[3][4], OCBW[3][5]);
	protected static final VoxelShape OCBWPart5 = Block.makeCuboidShape(OCBW[4][0], OCBW[4][1], OCBW[4][2], OCBW[4][3], OCBW[4][4], OCBW[4][5]);
	protected static final VoxelShape OCBWPart6 = Block.makeCuboidShape(OCBW[5][0], OCBW[5][1], OCBW[5][2], OCBW[5][3], OCBW[5][4], OCBW[5][5]);
	protected static final VoxelShape OCBWPart7 = Block.makeCuboidShape(OCBW[6][0], OCBW[6][1], OCBW[6][2], OCBW[6][3], OCBW[6][4], OCBW[6][5]);
	protected static final VoxelShape OCBWPart8 = Block.makeCuboidShape(OCBW[7][0], OCBW[7][1], OCBW[7][2], OCBW[7][3], OCBW[7][4], OCBW[7][5]);
	protected static final VoxelShape OCBWPart9 = Block.makeCuboidShape(OCBW[8][0], OCBW[8][1], OCBW[8][2], OCBW[8][3], OCBW[8][4], OCBW[8][5]);
	protected static final VoxelShape OCBWPart10 = Block.makeCuboidShape(OCBW[9][0], OCBW[9][1], OCBW[9][2], OCBW[9][3], OCBW[9][4], OCBW[9][5]);
	private static final VoxelShape FULL_OCBW_SHAPE = VoxelShapes.or(OCBWPart1, OCBWPart2, OCBWPart3, OCBWPart4, OCBWPart5, OCBWPart6, OCBWPart7, OCBWPart8, OCBWPart9, OCBWPart10);

	/** Outer corner block
	* OCTW = Outer corner block collision boxes, upside down, facing West
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCTW = {{0, 12, 0, 16, 16, 16},
	                                          {1, 9, 0, 16, 12, 15},
	                                          {2, 7, 0, 16, 9, 14},
	                                          {3, 6, 0, 16, 7, 13},
	                                          {7, 2, 0, 16, 3, 9},
	                                          {9, 1, 0, 16, 2, 7},
	                                          {12, 0, 0, 16, 1, 4},
	                                          {5, 4, 0, 16, 5, 11},
	                                          {6, 3, 0, 16, 4, 10},
	                                          {4, 5, 0, 16, 6, 12}};
	protected static final VoxelShape OCTWPart1 = Block.makeCuboidShape(OCTW[0][0], OCTW[0][1], OCTW[0][2], OCTW[0][3], OCTW[0][4], OCTW[0][5]);
	protected static final VoxelShape OCTWPart2 = Block.makeCuboidShape(OCTW[1][0], OCTW[1][1], OCTW[1][2], OCTW[1][3], OCTW[1][4], OCTW[1][5]);
	protected static final VoxelShape OCTWPart3 = Block.makeCuboidShape(OCTW[2][0], OCTW[2][1], OCTW[2][2], OCTW[2][3], OCTW[2][4], OCTW[2][5]);
	protected static final VoxelShape OCTWPart4 = Block.makeCuboidShape(OCTW[3][0], OCTW[3][1], OCTW[3][2], OCTW[3][3], OCTW[3][4], OCTW[3][5]);
	protected static final VoxelShape OCTWPart5 = Block.makeCuboidShape(OCTW[4][0], OCTW[4][1], OCTW[4][2], OCTW[4][3], OCTW[4][4], OCTW[4][5]);
	protected static final VoxelShape OCTWPart6 = Block.makeCuboidShape(OCTW[5][0], OCTW[5][1], OCTW[5][2], OCTW[5][3], OCTW[5][4], OCTW[5][5]);
	protected static final VoxelShape OCTWPart7 = Block.makeCuboidShape(OCTW[6][0], OCTW[6][1], OCTW[6][2], OCTW[6][3], OCTW[6][4], OCTW[6][5]);
	protected static final VoxelShape OCTWPart8 = Block.makeCuboidShape(OCTW[7][0], OCTW[7][1], OCTW[7][2], OCTW[7][3], OCTW[7][4], OCTW[7][5]);
	protected static final VoxelShape OCTWPart9 = Block.makeCuboidShape(OCTW[8][0], OCTW[8][1], OCTW[8][2], OCTW[8][3], OCTW[8][4], OCTW[8][5]);
	protected static final VoxelShape OCTWPart10 = Block.makeCuboidShape(OCTW[9][0], OCTW[9][1], OCTW[9][2], OCTW[9][3], OCTW[9][4], OCTW[9][5]);
	private static final VoxelShape FULL_OCTW_SHAPE = VoxelShapes.or(OCTWPart1, OCTWPart2, OCTWPart3, OCTWPart4, OCTWPart5, OCTWPart6, OCTWPart7, OCTWPart8, OCTWPart9, OCTWPart10);

	/** Outer corner block
	* OCBS = Outer corner block collision boxes, right side up, facing South
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCBS = {{0, 0, 0, 16, 4, 16},
	                                          {0, 4, 0, 15, 7, 15},
	                                          {0, 7, 0, 14, 9, 14},
	                                          {0, 9, 0, 13, 10, 13},
	                                          {0, 13, 0, 9, 14, 9},
	                                          {0, 14, 0, 7, 15, 7},
	                                          {0, 15, 0, 4, 16, 4},
	                                          {0, 11, 0, 11, 12, 11},
	                                          {0, 12, 0, 10, 13, 10},
	                                          {0, 10, 0, 12, 11, 12}};
	protected static final VoxelShape OCBSPart1 = Block.makeCuboidShape(OCBS[0][0], OCBS[0][1], OCBS[0][2], OCBS[0][3], OCBS[0][4], OCBS[0][5]);
	protected static final VoxelShape OCBSPart2 = Block.makeCuboidShape(OCBS[1][0], OCBS[1][1], OCBS[1][2], OCBS[1][3], OCBS[1][4], OCBS[1][5]);
	protected static final VoxelShape OCBSPart3 = Block.makeCuboidShape(OCBS[2][0], OCBS[2][1], OCBS[2][2], OCBS[2][3], OCBS[2][4], OCBS[2][5]);
	protected static final VoxelShape OCBSPart4 = Block.makeCuboidShape(OCBS[3][0], OCBS[3][1], OCBS[3][2], OCBS[3][3], OCBS[3][4], OCBS[3][5]);
	protected static final VoxelShape OCBSPart5 = Block.makeCuboidShape(OCBS[4][0], OCBS[4][1], OCBS[4][2], OCBS[4][3], OCBS[4][4], OCBS[4][5]);
	protected static final VoxelShape OCBSPart6 = Block.makeCuboidShape(OCBS[5][0], OCBS[5][1], OCBS[5][2], OCBS[5][3], OCBS[5][4], OCBS[5][5]);
	protected static final VoxelShape OCBSPart7 = Block.makeCuboidShape(OCBS[6][0], OCBS[6][1], OCBS[6][2], OCBS[6][3], OCBS[6][4], OCBS[6][5]);
	protected static final VoxelShape OCBSPart8 = Block.makeCuboidShape(OCBS[7][0], OCBS[7][1], OCBS[7][2], OCBS[7][3], OCBS[7][4], OCBS[7][5]);
	protected static final VoxelShape OCBSPart9 = Block.makeCuboidShape(OCBS[8][0], OCBS[8][1], OCBS[8][2], OCBS[8][3], OCBS[8][4], OCBS[8][5]);
	protected static final VoxelShape OCBSPart10 = Block.makeCuboidShape(OCBS[9][0], OCBS[9][1], OCBS[9][2], OCBS[9][3], OCBS[9][4], OCBS[9][5]);
	private static final VoxelShape FULL_OCBS_SHAPE = VoxelShapes.or(OCBSPart1, OCBSPart2, OCBSPart3, OCBSPart4, OCBSPart5, OCBSPart6, OCBSPart7, OCBSPart8, OCBSPart9, OCBSPart10);

	/** Outer corner block
	* OCTS = Outer corner block collision boxes, upside down, facing South
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCTS = {{0, 12, 0, 16, 16, 16},
	                                          {0, 9, 0, 15, 12, 15},
	                                          {0, 7, 0, 14, 9, 14},
	                                          {0, 6, 0, 13, 7, 13},
	                                          {0, 2, 0, 9, 3, 9},
	                                          {0, 1, 0, 7, 2, 7},
	                                          {0, 0, 0, 4, 1, 4},
	                                          {0, 4, 0, 11, 5, 11},
	                                          {0, 3, 0, 10, 4, 10},
	                                          {0, 5, 0, 12, 6, 12}};
	protected static final VoxelShape OCTSPart1 = Block.makeCuboidShape(OCTS[0][0], OCTS[0][1], OCTS[0][2], OCTS[0][3], OCTS[0][4], OCTS[0][5]);
	protected static final VoxelShape OCTSPart2 = Block.makeCuboidShape(OCTS[1][0], OCTS[1][1], OCTS[1][2], OCTS[1][3], OCTS[1][4], OCTS[1][5]);
	protected static final VoxelShape OCTSPart3 = Block.makeCuboidShape(OCTS[2][0], OCTS[2][1], OCTS[2][2], OCTS[2][3], OCTS[2][4], OCTS[2][5]);
	protected static final VoxelShape OCTSPart4 = Block.makeCuboidShape(OCTS[3][0], OCTS[3][1], OCTS[3][2], OCTS[3][3], OCTS[3][4], OCTS[3][5]);
	protected static final VoxelShape OCTSPart5 = Block.makeCuboidShape(OCTS[4][0], OCTS[4][1], OCTS[4][2], OCTS[4][3], OCTS[4][4], OCTS[4][5]);
	protected static final VoxelShape OCTSPart6 = Block.makeCuboidShape(OCTS[5][0], OCTS[5][1], OCTS[5][2], OCTS[5][3], OCTS[5][4], OCTS[5][5]);
	protected static final VoxelShape OCTSPart7 = Block.makeCuboidShape(OCTS[6][0], OCTS[6][1], OCTS[6][2], OCTS[6][3], OCTS[6][4], OCTS[6][5]);
	protected static final VoxelShape OCTSPart8 = Block.makeCuboidShape(OCTS[7][0], OCTS[7][1], OCTS[7][2], OCTS[7][3], OCTS[7][4], OCTS[7][5]);
	protected static final VoxelShape OCTSPart9 = Block.makeCuboidShape(OCTS[8][0], OCTS[8][1], OCTS[8][2], OCTS[8][3], OCTS[8][4], OCTS[8][5]);
	protected static final VoxelShape OCTSPart10 = Block.makeCuboidShape(OCTS[9][0], OCTS[9][1], OCTS[9][2], OCTS[9][3], OCTS[9][4], OCTS[9][5]);
	private static final VoxelShape FULL_OCTS_SHAPE = VoxelShapes.or(OCTSPart1, OCTSPart2, OCTSPart3, OCTSPart4, OCTSPart5, OCTSPart6, OCTSPart7, OCTSPart8, OCTSPart9, OCTSPart10);

	/** Outer corner block
	* OCBE = Outer corner block collision boxes, right side up, facing East
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCBE = {{0, 0, 0, 16, 4, 16},
	                                          {0, 4, 1, 15, 7, 16},
	                                          {0, 7, 2, 14, 9, 16},
	                                          {0, 9, 3, 13, 10, 16},
	                                          {0, 13, 7, 9, 14, 16},
	                                          {0, 14, 9, 7, 15, 16},
	                                          {0, 15, 12, 4, 16, 16},
	                                          {0, 11, 5, 11, 12, 16},
	                                          {0, 12, 6, 10, 13, 16},
	                                          {0, 10, 4, 12, 11, 16}};
	protected static final VoxelShape OCBEPart1 = Block.makeCuboidShape(OCBE[0][0], OCBE[0][1], OCBE[0][2], OCBE[0][3], OCBE[0][4], OCBE[0][5]);
	protected static final VoxelShape OCBEPart2 = Block.makeCuboidShape(OCBE[1][0], OCBE[1][1], OCBE[1][2], OCBE[1][3], OCBE[1][4], OCBE[1][5]);
	protected static final VoxelShape OCBEPart3 = Block.makeCuboidShape(OCBE[2][0], OCBE[2][1], OCBE[2][2], OCBE[2][3], OCBE[2][4], OCBE[2][5]);
	protected static final VoxelShape OCBEPart4 = Block.makeCuboidShape(OCBE[3][0], OCBE[3][1], OCBE[3][2], OCBE[3][3], OCBE[3][4], OCBE[3][5]);
	protected static final VoxelShape OCBEPart5 = Block.makeCuboidShape(OCBE[4][0], OCBE[4][1], OCBE[4][2], OCBE[4][3], OCBE[4][4], OCBE[4][5]);
	protected static final VoxelShape OCBEPart6 = Block.makeCuboidShape(OCBE[5][0], OCBE[5][1], OCBE[5][2], OCBE[5][3], OCBE[5][4], OCBE[5][5]);
	protected static final VoxelShape OCBEPart7 = Block.makeCuboidShape(OCBE[6][0], OCBE[6][1], OCBE[6][2], OCBE[6][3], OCBE[6][4], OCBE[6][5]);
	protected static final VoxelShape OCBEPart8 = Block.makeCuboidShape(OCBE[7][0], OCBE[7][1], OCBE[7][2], OCBE[7][3], OCBE[7][4], OCBE[7][5]);
	protected static final VoxelShape OCBEPart9 = Block.makeCuboidShape(OCBE[8][0], OCBE[8][1], OCBE[8][2], OCBE[8][3], OCBE[8][4], OCBE[8][5]);
	protected static final VoxelShape OCBEPart10 = Block.makeCuboidShape(OCBE[9][0], OCBE[9][1], OCBE[9][2], OCBE[9][3], OCBE[9][4], OCBE[9][5]);
	private static final VoxelShape FULL_OCBE_SHAPE = VoxelShapes.or(OCBEPart1, OCBEPart2, OCBEPart3, OCBEPart4, OCBEPart5, OCBEPart6, OCBEPart7, OCBEPart8, OCBEPart9, OCBEPart10);

	/** Outer corner block
	* OCTE = Outer corner block collision boxes, upside down, facing East
	* x1 y1 z1 x2 y2 z2 */
	protected static final double[][] OCTE = {{0, 12, 0, 16, 16, 16},
	                                          {0, 9, 1, 15, 12, 16},
	                                          {0, 7, 2, 14, 9, 16},
	                                          {0, 6, 3, 13, 7, 16},
	                                          {0, 2, 7, 9, 3, 16},
	                                          {0, 1, 9, 7, 2, 16},
	                                          {0, 0, 12, 4, 1, 16},
	                                          {0, 4, 5, 11, 5, 16},
	                                          {0, 3, 6, 10, 4, 16},
	                                          {0, 5, 4, 12, 6, 16}};
	protected static final VoxelShape OCTEPart1 = Block.makeCuboidShape(OCTE[0][0], OCTE[0][1], OCTE[0][2], OCTE[0][3], OCTE[0][4], OCTE[0][5]);
	protected static final VoxelShape OCTEPart2 = Block.makeCuboidShape(OCTE[1][0], OCTE[1][1], OCTE[1][2], OCTE[1][3], OCTE[1][4], OCTE[1][5]);
	protected static final VoxelShape OCTEPart3 = Block.makeCuboidShape(OCTE[2][0], OCTE[2][1], OCTE[2][2], OCTE[2][3], OCTE[2][4], OCTE[2][5]);
	protected static final VoxelShape OCTEPart4 = Block.makeCuboidShape(OCTE[3][0], OCTE[3][1], OCTE[3][2], OCTE[3][3], OCTE[3][4], OCTE[3][5]);
	protected static final VoxelShape OCTEPart5 = Block.makeCuboidShape(OCTE[4][0], OCTE[4][1], OCTE[4][2], OCTE[4][3], OCTE[4][4], OCTE[4][5]);
	protected static final VoxelShape OCTEPart6 = Block.makeCuboidShape(OCTE[5][0], OCTE[5][1], OCTE[5][2], OCTE[5][3], OCTE[5][4], OCTE[5][5]);
	protected static final VoxelShape OCTEPart7 = Block.makeCuboidShape(OCTE[6][0], OCTE[6][1], OCTE[6][2], OCTE[6][3], OCTE[6][4], OCTE[6][5]);
	protected static final VoxelShape OCTEPart8 = Block.makeCuboidShape(OCTE[7][0], OCTE[7][1], OCTE[7][2], OCTE[7][3], OCTE[7][4], OCTE[7][5]);
	protected static final VoxelShape OCTEPart9 = Block.makeCuboidShape(OCTE[8][0], OCTE[8][1], OCTE[8][2], OCTE[8][3], OCTE[8][4], OCTE[8][5]);
	protected static final VoxelShape OCTEPart10 = Block.makeCuboidShape(OCTE[9][0], OCTE[9][1], OCTE[9][2], OCTE[9][3], OCTE[9][4], OCTE[9][5]);
	private static final VoxelShape FULL_OCTE_SHAPE = VoxelShapes.or(OCTEPart1, OCTEPart2, OCTEPart3, OCTEPart4, OCTEPart5, OCTEPart6, OCTEPart7, OCTEPart8, OCTEPart9, OCTEPart10);

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(SHAPE) == StairsShape.STRAIGHT) {
			if (state.get(HALF) == Half.TOP) {
				if (state.get(FACING) == Direction.SOUTH) {
					return FULL_SCTN_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_SCTE_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_SCTS_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_SCTW_SHAPE;
				}
			} else if (state.get(HALF) == Half.BOTTOM) {
				if (state.get(FACING) == Direction.SOUTH) {
					return FULL_SCBN_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_SCBE_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_SCBS_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_SCBW_SHAPE;
				}
			}
		} else if (state.get(SHAPE) == StairsShape.INNER_LEFT) {
			if (state.get(HALF) == Half.TOP) {
				if (state.get(FACING) == Direction.SOUTH) {
					return FULL_ICTN_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_ICTE_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_ICTS_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_ICTW_SHAPE;
				}
			} else if (state.get(HALF) == Half.BOTTOM) {
				if (state.get(FACING) == Direction.SOUTH) {
					return FULL_ICBN_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_ICBE_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_ICBS_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_ICBW_SHAPE;
				}
			}
		} else if (state.get(SHAPE) == StairsShape.INNER_RIGHT) {
			if (state.get(HALF) == Half.TOP) {
				if (state.get(FACING) == Direction.EAST) {
					return FULL_ICTN_SHAPE;
				} else if (state.get(FACING) == Direction.SOUTH) {
					return FULL_ICTE_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_ICTS_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_ICTW_SHAPE;
				}
			} else if (state.get(HALF) == Half.BOTTOM) {
				if (state.get(FACING) == Direction.EAST) {
					return FULL_ICBN_SHAPE;
				} else if (state.get(FACING) == Direction.SOUTH) {
					return FULL_ICBE_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_ICBS_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_ICBW_SHAPE;
				}
			}
		} else if (state.get(SHAPE) == StairsShape.OUTER_LEFT) {
			if (state.get(HALF) == Half.TOP) {
				if (state.get(FACING) == Direction.NORTH) {
					return FULL_OCTS_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_OCTE_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_OCTW_SHAPE;
				} else if (state.get(FACING) == Direction.SOUTH) {
					return FULL_OCTN_SHAPE;
				}
			} else if (state.get(HALF) == Half.BOTTOM) {
				if (state.get(FACING) == Direction.NORTH) {
					return FULL_OCBS_SHAPE;
				} else if (state.get(FACING) == Direction.WEST) {
					return FULL_OCBE_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_OCBW_SHAPE;
				} else if (state.get(FACING) == Direction.SOUTH) {
					return FULL_OCBN_SHAPE;
				}
			}
		} else if (state.get(SHAPE) == StairsShape.OUTER_RIGHT) {
			if (state.get(HALF) == Half.TOP) {
				if (state.get(FACING) == Direction.WEST) {
					return FULL_OCTS_SHAPE;
				} else if (state.get(FACING) == Direction.SOUTH) {
					return FULL_OCTE_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_OCTW_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_OCTN_SHAPE;
				}
			} else if (state.get(HALF) == Half.BOTTOM) {
				if (state.get(FACING) == Direction.WEST) {
					return FULL_OCBS_SHAPE;
				} else if (state.get(FACING) == Direction.SOUTH) {
					return FULL_OCBE_SHAPE;
				} else if (state.get(FACING) == Direction.NORTH) {
					return FULL_OCBW_SHAPE;
				} else if (state.get(FACING) == Direction.EAST) {
					return FULL_OCBN_SHAPE;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("deprecation")
	public InvertedArchBlock(Block baseBlock) {
		super(baseBlock.getDefaultState(), Block.Properties.from(baseBlock));
	}
}
