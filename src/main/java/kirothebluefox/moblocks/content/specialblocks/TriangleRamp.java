package kirothebluefox.moblocks.content.specialblocks;

import javax.annotation.Nullable;

import kirothebluefox.moblocks.content.customproperties.CustomBlockStateProperties;
import kirothebluefox.moblocks.content.customproperties.MultipleEast;
import kirothebluefox.moblocks.content.customproperties.MultipleNorth;
import kirothebluefox.moblocks.content.customproperties.MultipleSouth;
import kirothebluefox.moblocks.content.customproperties.MultipleWest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

public class TriangleRamp extends Block implements IWaterLoggable {
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
	public static final EnumProperty<MultipleNorth> NORTH = CustomBlockStateProperties.MULTIPLE_NORTH;
	public static final EnumProperty<MultipleEast> EAST = CustomBlockStateProperties.MULTIPLE_EAST;
	public static final EnumProperty<MultipleSouth> SOUTH = CustomBlockStateProperties.MULTIPLE_SOUTH;
	public static final EnumProperty<MultipleWest> WEST = CustomBlockStateProperties.MULTIPLE_WEST;
	
	/* DOT BOTTOM */
	protected static final double[][] DOTBOTTOM = {{0, 0, 0, 16, 1, 16},
	                                         {4, 4, 4, 12, 5, 12},
	                                         {1, 1, 1, 15, 2, 15},
	                                         {5, 5, 5, 11, 6, 11},
	                                         {2, 2, 2, 14, 3, 14},
	                                         {6, 6, 6, 10, 7, 10},
	                                         {3, 3, 3, 13, 4, 13},
	                                         {7, 7, 7, 9, 8, 9}};
	protected static final VoxelShape DOTBOTTOMPart1 = Block.makeCuboidShape(DOTBOTTOM[0][0], DOTBOTTOM[0][1], DOTBOTTOM[0][2], DOTBOTTOM[0][3], DOTBOTTOM[0][4], DOTBOTTOM[0][5]);
	protected static final VoxelShape DOTBOTTOMPart2 = Block.makeCuboidShape(DOTBOTTOM[1][0], DOTBOTTOM[1][1], DOTBOTTOM[1][2], DOTBOTTOM[1][3], DOTBOTTOM[1][4], DOTBOTTOM[1][5]);
	protected static final VoxelShape DOTBOTTOMPart3 = Block.makeCuboidShape(DOTBOTTOM[2][0], DOTBOTTOM[2][1], DOTBOTTOM[2][2], DOTBOTTOM[2][3], DOTBOTTOM[2][4], DOTBOTTOM[2][5]);
	protected static final VoxelShape DOTBOTTOMPart4 = Block.makeCuboidShape(DOTBOTTOM[3][0], DOTBOTTOM[3][1], DOTBOTTOM[3][2], DOTBOTTOM[3][3], DOTBOTTOM[3][4], DOTBOTTOM[3][5]);
	protected static final VoxelShape DOTBOTTOMPart5 = Block.makeCuboidShape(DOTBOTTOM[4][0], DOTBOTTOM[4][1], DOTBOTTOM[4][2], DOTBOTTOM[4][3], DOTBOTTOM[4][4], DOTBOTTOM[4][5]);
	protected static final VoxelShape DOTBOTTOMPart6 = Block.makeCuboidShape(DOTBOTTOM[5][0], DOTBOTTOM[5][1], DOTBOTTOM[5][2], DOTBOTTOM[5][3], DOTBOTTOM[5][4], DOTBOTTOM[5][5]);
	protected static final VoxelShape DOTBOTTOMPart7 = Block.makeCuboidShape(DOTBOTTOM[6][0], DOTBOTTOM[6][1], DOTBOTTOM[6][2], DOTBOTTOM[6][3], DOTBOTTOM[6][4], DOTBOTTOM[6][5]);
	protected static final VoxelShape DOTBOTTOMPart8 = Block.makeCuboidShape(DOTBOTTOM[7][0], DOTBOTTOM[7][1], DOTBOTTOM[7][2], DOTBOTTOM[7][3], DOTBOTTOM[7][4], DOTBOTTOM[7][5]);
	private static final VoxelShape FULL_DOTBOTTOM_SHAPE = VoxelShapes.or(DOTBOTTOMPart1, DOTBOTTOMPart2, DOTBOTTOMPart3, DOTBOTTOMPart4, DOTBOTTOMPart5, DOTBOTTOMPart6, DOTBOTTOMPart7, DOTBOTTOMPart8);
	
	/* DOT TOP */
	protected static final double[][] DOTTOP = {{0, 15, 0, 16, 16, 16},
	                                            {4, 11, 4, 12, 12, 12},
	                                            {1, 14, 1, 15, 15, 15},
	                                            {5, 10, 5, 11, 11, 11},
	                                            {2, 13, 2, 14, 14, 14},
	                                            {6, 9, 6, 10, 10, 10},
	                                            {3, 12, 3, 13, 13, 13},
	                                            {7, 8, 7, 9, 9, 9}};
	protected static final VoxelShape DOTTOPPart1 = Block.makeCuboidShape(DOTTOP[0][0], DOTTOP[0][1], DOTTOP[0][2], DOTTOP[0][3], DOTTOP[0][4], DOTTOP[0][5]);
	protected static final VoxelShape DOTTOPPart2 = Block.makeCuboidShape(DOTTOP[1][0], DOTTOP[1][1], DOTTOP[1][2], DOTTOP[1][3], DOTTOP[1][4], DOTTOP[1][5]);
	protected static final VoxelShape DOTTOPPart3 = Block.makeCuboidShape(DOTTOP[2][0], DOTTOP[2][1], DOTTOP[2][2], DOTTOP[2][3], DOTTOP[2][4], DOTTOP[2][5]);
	protected static final VoxelShape DOTTOPPart4 = Block.makeCuboidShape(DOTTOP[3][0], DOTTOP[3][1], DOTTOP[3][2], DOTTOP[3][3], DOTTOP[3][4], DOTTOP[3][5]);
	protected static final VoxelShape DOTTOPPart5 = Block.makeCuboidShape(DOTTOP[4][0], DOTTOP[4][1], DOTTOP[4][2], DOTTOP[4][3], DOTTOP[4][4], DOTTOP[4][5]);
	protected static final VoxelShape DOTTOPPart6 = Block.makeCuboidShape(DOTTOP[5][0], DOTTOP[5][1], DOTTOP[5][2], DOTTOP[5][3], DOTTOP[5][4], DOTTOP[5][5]);
	protected static final VoxelShape DOTTOPPart7 = Block.makeCuboidShape(DOTTOP[6][0], DOTTOP[6][1], DOTTOP[6][2], DOTTOP[6][3], DOTTOP[6][4], DOTTOP[6][5]);
	protected static final VoxelShape DOTTOPPart8 = Block.makeCuboidShape(DOTTOP[7][0], DOTTOP[7][1], DOTTOP[7][2], DOTTOP[7][3], DOTTOP[7][4], DOTTOP[7][5]);
	private static final VoxelShape FULL_DOTTOP_SHAPE = VoxelShapes.or(DOTTOPPart1, DOTTOPPart2, DOTTOPPart3, DOTTOPPart4, DOTTOPPart5, DOTTOPPart6, DOTTOPPart7, DOTTOPPart8);

	/* END NORTH */
	protected static final double[][] ENDNORTH = {{7, 7, 0, 9, 8, 7},
	                                              {3, 3, 0, 13, 4, 3},
	                                              {6, 6, 0, 10, 7, 6},
	                                              {2, 2, 0, 14, 3, 2},
	                                              {5, 5, 0, 11, 6, 5},
	                                              {1, 1, 0, 15, 2, 1},
	                                              {4, 4, 0, 12, 5, 4}};
	protected static final VoxelShape ENDNORTHPart1 = Block.makeCuboidShape(ENDNORTH[0][0], ENDNORTH[0][1], ENDNORTH[0][2], ENDNORTH[0][3], ENDNORTH[0][4], ENDNORTH[0][5]);
	protected static final VoxelShape ENDNORTHPart2 = Block.makeCuboidShape(ENDNORTH[1][0], ENDNORTH[1][1], ENDNORTH[1][2], ENDNORTH[1][3], ENDNORTH[1][4], ENDNORTH[1][5]);
	protected static final VoxelShape ENDNORTHPart3 = Block.makeCuboidShape(ENDNORTH[2][0], ENDNORTH[2][1], ENDNORTH[2][2], ENDNORTH[2][3], ENDNORTH[2][4], ENDNORTH[2][5]);
	protected static final VoxelShape ENDNORTHPart4 = Block.makeCuboidShape(ENDNORTH[3][0], ENDNORTH[3][1], ENDNORTH[3][2], ENDNORTH[3][3], ENDNORTH[3][4], ENDNORTH[3][5]);
	protected static final VoxelShape ENDNORTHPart5 = Block.makeCuboidShape(ENDNORTH[4][0], ENDNORTH[4][1], ENDNORTH[4][2], ENDNORTH[4][3], ENDNORTH[4][4], ENDNORTH[4][5]);
	protected static final VoxelShape ENDNORTHPart6 = Block.makeCuboidShape(ENDNORTH[5][0], ENDNORTH[5][1], ENDNORTH[5][2], ENDNORTH[5][3], ENDNORTH[5][4], ENDNORTH[5][5]);
	protected static final VoxelShape ENDNORTHPart7 = Block.makeCuboidShape(ENDNORTH[6][0], ENDNORTH[6][1], ENDNORTH[6][2], ENDNORTH[6][3], ENDNORTH[6][4], ENDNORTH[6][5]);
	private static final VoxelShape FULL_ENDNORTH_SHAPE = VoxelShapes.or(ENDNORTHPart1, ENDNORTHPart2, ENDNORTHPart3, ENDNORTHPart4, ENDNORTHPart5, ENDNORTHPart6, ENDNORTHPart7);

	/* END SOUTH */
	protected static final double[][] ENDSOUTH = {{7, 7, 9, 9, 8, 16},
	                                              {3, 3, 13, 13, 4, 16},
	                                              {6, 6, 10, 10, 7, 16},
	                                              {2, 2, 14, 14, 3, 16},
	                                              {5, 5, 11, 11, 6, 16},
	                                              {1, 1, 15, 15, 2, 16},
	                                              {4, 4, 12, 12, 5, 16}};
	protected static final VoxelShape ENDSOUTHPart1 = Block.makeCuboidShape(ENDSOUTH[0][0], ENDSOUTH[0][1], ENDSOUTH[0][2], ENDSOUTH[0][3], ENDSOUTH[0][4], ENDSOUTH[0][5]);
	protected static final VoxelShape ENDSOUTHPart2 = Block.makeCuboidShape(ENDSOUTH[1][0], ENDSOUTH[1][1], ENDSOUTH[1][2], ENDSOUTH[1][3], ENDSOUTH[1][4], ENDSOUTH[1][5]);
	protected static final VoxelShape ENDSOUTHPart3 = Block.makeCuboidShape(ENDSOUTH[2][0], ENDSOUTH[2][1], ENDSOUTH[2][2], ENDSOUTH[2][3], ENDSOUTH[2][4], ENDSOUTH[2][5]);
	protected static final VoxelShape ENDSOUTHPart4 = Block.makeCuboidShape(ENDSOUTH[3][0], ENDSOUTH[3][1], ENDSOUTH[3][2], ENDSOUTH[3][3], ENDSOUTH[3][4], ENDSOUTH[3][5]);
	protected static final VoxelShape ENDSOUTHPart5 = Block.makeCuboidShape(ENDSOUTH[4][0], ENDSOUTH[4][1], ENDSOUTH[4][2], ENDSOUTH[4][3], ENDSOUTH[4][4], ENDSOUTH[4][5]);
	protected static final VoxelShape ENDSOUTHPart6 = Block.makeCuboidShape(ENDSOUTH[5][0], ENDSOUTH[5][1], ENDSOUTH[5][2], ENDSOUTH[5][3], ENDSOUTH[5][4], ENDSOUTH[5][5]);
	protected static final VoxelShape ENDSOUTHPart7 = Block.makeCuboidShape(ENDSOUTH[6][0], ENDSOUTH[6][1], ENDSOUTH[6][2], ENDSOUTH[6][3], ENDSOUTH[6][4], ENDSOUTH[6][5]);
	private static final VoxelShape FULL_ENDSOUTH_SHAPE = VoxelShapes.or(ENDSOUTHPart1, ENDSOUTHPart2, ENDSOUTHPart3, ENDSOUTHPart4, ENDSOUTHPart5, ENDSOUTHPart6, ENDSOUTHPart7);

	/* END EAST */
	protected static final double[][] ENDEAST = {{9, 7, 7, 16, 8, 9},
	                                             {13, 3, 3, 16, 4, 13},
	                                             {10, 6, 6, 16, 7, 10},
	                                             {14, 2, 2, 16, 3, 14},
	                                             {11, 5, 5, 16, 6, 11},
	                                             {15, 1, 1, 16, 2, 15},
	                                             {12, 4, 4, 16, 5, 12}};
	protected static final VoxelShape ENDEASTPart1 = Block.makeCuboidShape(ENDEAST[0][0], ENDEAST[0][1], ENDEAST[0][2], ENDEAST[0][3], ENDEAST[0][4], ENDEAST[0][5]);
	protected static final VoxelShape ENDEASTPart2 = Block.makeCuboidShape(ENDEAST[1][0], ENDEAST[1][1], ENDEAST[1][2], ENDEAST[1][3], ENDEAST[1][4], ENDEAST[1][5]);
	protected static final VoxelShape ENDEASTPart3 = Block.makeCuboidShape(ENDEAST[2][0], ENDEAST[2][1], ENDEAST[2][2], ENDEAST[2][3], ENDEAST[2][4], ENDEAST[2][5]);
	protected static final VoxelShape ENDEASTPart4 = Block.makeCuboidShape(ENDEAST[3][0], ENDEAST[3][1], ENDEAST[3][2], ENDEAST[3][3], ENDEAST[3][4], ENDEAST[3][5]);
	protected static final VoxelShape ENDEASTPart5 = Block.makeCuboidShape(ENDEAST[4][0], ENDEAST[4][1], ENDEAST[4][2], ENDEAST[4][3], ENDEAST[4][4], ENDEAST[4][5]);
	protected static final VoxelShape ENDEASTPart6 = Block.makeCuboidShape(ENDEAST[5][0], ENDEAST[5][1], ENDEAST[5][2], ENDEAST[5][3], ENDEAST[5][4], ENDEAST[5][5]);
	protected static final VoxelShape ENDEASTPart7 = Block.makeCuboidShape(ENDEAST[6][0], ENDEAST[6][1], ENDEAST[6][2], ENDEAST[6][3], ENDEAST[6][4], ENDEAST[6][5]);
	private static final VoxelShape FULL_ENDEAST_SHAPE = VoxelShapes.or(ENDEASTPart1, ENDEASTPart2, ENDEASTPart3, ENDEASTPart4, ENDEASTPart5, ENDEASTPart6, ENDEASTPart7);

	/* END WEST */
	protected static final double[][] ENDWEST = {{0, 7, 7, 7, 8, 9},
	                                             {0, 3, 3, 3, 4, 13},
	                                             {0, 6, 6, 6, 7, 10},
	                                             {0, 2, 2, 2, 3, 14},
	                                             {0, 5, 5, 5, 6, 11},
	                                             {0, 1, 1, 1, 2, 15},
	                                             {0, 4, 4, 4, 5, 12}};
	protected static final VoxelShape ENDWESTPart1 = Block.makeCuboidShape(ENDWEST[0][0], ENDWEST[0][1], ENDWEST[0][2], ENDWEST[0][3], ENDWEST[0][4], ENDWEST[0][5]);
	protected static final VoxelShape ENDWESTPart2 = Block.makeCuboidShape(ENDWEST[1][0], ENDWEST[1][1], ENDWEST[1][2], ENDWEST[1][3], ENDWEST[1][4], ENDWEST[1][5]);
	protected static final VoxelShape ENDWESTPart3 = Block.makeCuboidShape(ENDWEST[2][0], ENDWEST[2][1], ENDWEST[2][2], ENDWEST[2][3], ENDWEST[2][4], ENDWEST[2][5]);
	protected static final VoxelShape ENDWESTPart4 = Block.makeCuboidShape(ENDWEST[3][0], ENDWEST[3][1], ENDWEST[3][2], ENDWEST[3][3], ENDWEST[3][4], ENDWEST[3][5]);
	protected static final VoxelShape ENDWESTPart5 = Block.makeCuboidShape(ENDWEST[4][0], ENDWEST[4][1], ENDWEST[4][2], ENDWEST[4][3], ENDWEST[4][4], ENDWEST[4][5]);
	protected static final VoxelShape ENDWESTPart6 = Block.makeCuboidShape(ENDWEST[5][0], ENDWEST[5][1], ENDWEST[5][2], ENDWEST[5][3], ENDWEST[5][4], ENDWEST[5][5]);
	protected static final VoxelShape ENDWESTPart7 = Block.makeCuboidShape(ENDWEST[6][0], ENDWEST[6][1], ENDWEST[6][2], ENDWEST[6][3], ENDWEST[6][4], ENDWEST[6][5]);
	private static final VoxelShape FULL_ENDWEST_SHAPE = VoxelShapes.or(ENDWESTPart1, ENDWESTPart2, ENDWESTPart3, ENDWESTPart4, ENDWESTPart5, ENDWESTPart6, ENDWESTPart7);

	/* END TOP NORTH */
	protected static final double[][] ENDTOPNORTH = {{7, 8, 0, 9, 9, 7},
	                                                 {3, 12, 0, 13, 13, 3},
	                                                 {6, 9, 0, 10, 10, 6},
	                                                 {2, 13, 0, 14, 14, 2},
	                                                 {5, 10, 0, 11, 11, 5},
	                                                 {1, 14, 0, 15, 15, 1},
	                                                 {4, 11, 0, 12, 12, 4}};
	protected static final VoxelShape ENDTOPNORTHPart1 = Block.makeCuboidShape(ENDTOPNORTH[0][0], ENDTOPNORTH[0][1], ENDTOPNORTH[0][2], ENDTOPNORTH[0][3], ENDTOPNORTH[0][4], ENDTOPNORTH[0][5]);
	protected static final VoxelShape ENDTOPNORTHPart2 = Block.makeCuboidShape(ENDTOPNORTH[1][0], ENDTOPNORTH[1][1], ENDTOPNORTH[1][2], ENDTOPNORTH[1][3], ENDTOPNORTH[1][4], ENDTOPNORTH[1][5]);
	protected static final VoxelShape ENDTOPNORTHPart3 = Block.makeCuboidShape(ENDTOPNORTH[2][0], ENDTOPNORTH[2][1], ENDTOPNORTH[2][2], ENDTOPNORTH[2][3], ENDTOPNORTH[2][4], ENDTOPNORTH[2][5]);
	protected static final VoxelShape ENDTOPNORTHPart4 = Block.makeCuboidShape(ENDTOPNORTH[3][0], ENDTOPNORTH[3][1], ENDTOPNORTH[3][2], ENDTOPNORTH[3][3], ENDTOPNORTH[3][4], ENDTOPNORTH[3][5]);
	protected static final VoxelShape ENDTOPNORTHPart5 = Block.makeCuboidShape(ENDTOPNORTH[4][0], ENDTOPNORTH[4][1], ENDTOPNORTH[4][2], ENDTOPNORTH[4][3], ENDTOPNORTH[4][4], ENDTOPNORTH[4][5]);
	protected static final VoxelShape ENDTOPNORTHPart6 = Block.makeCuboidShape(ENDTOPNORTH[5][0], ENDTOPNORTH[5][1], ENDTOPNORTH[5][2], ENDTOPNORTH[5][3], ENDTOPNORTH[5][4], ENDTOPNORTH[5][5]);
	protected static final VoxelShape ENDTOPNORTHPart7 = Block.makeCuboidShape(ENDTOPNORTH[6][0], ENDTOPNORTH[6][1], ENDTOPNORTH[6][2], ENDTOPNORTH[6][3], ENDTOPNORTH[6][4], ENDTOPNORTH[6][5]);
	private static final VoxelShape FULL_ENDTOPNORTH_SHAPE = VoxelShapes.or(ENDTOPNORTHPart1, ENDTOPNORTHPart2, ENDTOPNORTHPart3, ENDTOPNORTHPart4, ENDTOPNORTHPart5, ENDTOPNORTHPart6, ENDTOPNORTHPart7);

	/* END TOP SOUTH */
	protected static final double[][] ENDTOPSOUTH = {{7, 8, 9, 9, 9, 16},
	                                                 {3, 12, 13, 13, 13, 16},
	                                                 {6, 9, 10, 10, 10, 16},
	                                                 {2, 13, 14, 14, 14, 16},
	                                                 {5, 10, 11, 11, 11, 16},
	                                                 {1, 14, 15, 15, 15, 16},
	                                                 {4, 11, 12, 12, 12, 16}};
	protected static final VoxelShape ENDTOPSOUTHPart1 = Block.makeCuboidShape(ENDTOPSOUTH[0][0], ENDTOPSOUTH[0][1], ENDTOPSOUTH[0][2], ENDTOPSOUTH[0][3], ENDTOPSOUTH[0][4], ENDTOPSOUTH[0][5]);
	protected static final VoxelShape ENDTOPSOUTHPart2 = Block.makeCuboidShape(ENDTOPSOUTH[1][0], ENDTOPSOUTH[1][1], ENDTOPSOUTH[1][2], ENDTOPSOUTH[1][3], ENDTOPSOUTH[1][4], ENDTOPSOUTH[1][5]);
	protected static final VoxelShape ENDTOPSOUTHPart3 = Block.makeCuboidShape(ENDTOPSOUTH[2][0], ENDTOPSOUTH[2][1], ENDTOPSOUTH[2][2], ENDTOPSOUTH[2][3], ENDTOPSOUTH[2][4], ENDTOPSOUTH[2][5]);
	protected static final VoxelShape ENDTOPSOUTHPart4 = Block.makeCuboidShape(ENDTOPSOUTH[3][0], ENDTOPSOUTH[3][1], ENDTOPSOUTH[3][2], ENDTOPSOUTH[3][3], ENDTOPSOUTH[3][4], ENDTOPSOUTH[3][5]);
	protected static final VoxelShape ENDTOPSOUTHPart5 = Block.makeCuboidShape(ENDTOPSOUTH[4][0], ENDTOPSOUTH[4][1], ENDTOPSOUTH[4][2], ENDTOPSOUTH[4][3], ENDTOPSOUTH[4][4], ENDTOPSOUTH[4][5]);
	protected static final VoxelShape ENDTOPSOUTHPart6 = Block.makeCuboidShape(ENDTOPSOUTH[5][0], ENDTOPSOUTH[5][1], ENDTOPSOUTH[5][2], ENDTOPSOUTH[5][3], ENDTOPSOUTH[5][4], ENDTOPSOUTH[5][5]);
	protected static final VoxelShape ENDTOPSOUTHPart7 = Block.makeCuboidShape(ENDTOPSOUTH[6][0], ENDTOPSOUTH[6][1], ENDTOPSOUTH[6][2], ENDTOPSOUTH[6][3], ENDTOPSOUTH[6][4], ENDTOPSOUTH[6][5]);
	private static final VoxelShape FULL_ENDTOPSOUTH_SHAPE = VoxelShapes.or(ENDTOPSOUTHPart1, ENDTOPSOUTHPart2, ENDTOPSOUTHPart3, ENDTOPSOUTHPart4, ENDTOPSOUTHPart5, ENDTOPSOUTHPart6, ENDTOPSOUTHPart7);

	/* END TOP EAST */
	protected static final double[][] ENDTOPEAST = {{9, 8, 7, 16, 9, 9},
	                                                {13, 12, 3, 16, 13, 13},
	                                                {10, 9, 6, 16, 10, 10},
	                                                {14, 13, 2, 16, 14, 14},
	                                                {11, 10, 5, 16, 11, 11},
	                                                {15, 14, 1, 16, 15, 15},
	                                                {12, 11, 4, 16, 12, 12}};
	protected static final VoxelShape ENDTOPEASTPart1 = Block.makeCuboidShape(ENDTOPEAST[0][0], ENDTOPEAST[0][1], ENDTOPEAST[0][2], ENDTOPEAST[0][3], ENDTOPEAST[0][4], ENDTOPEAST[0][5]);
	protected static final VoxelShape ENDTOPEASTPart2 = Block.makeCuboidShape(ENDTOPEAST[1][0], ENDTOPEAST[1][1], ENDTOPEAST[1][2], ENDTOPEAST[1][3], ENDTOPEAST[1][4], ENDTOPEAST[1][5]);
	protected static final VoxelShape ENDTOPEASTPart3 = Block.makeCuboidShape(ENDTOPEAST[2][0], ENDTOPEAST[2][1], ENDTOPEAST[2][2], ENDTOPEAST[2][3], ENDTOPEAST[2][4], ENDTOPEAST[2][5]);
	protected static final VoxelShape ENDTOPEASTPart4 = Block.makeCuboidShape(ENDTOPEAST[3][0], ENDTOPEAST[3][1], ENDTOPEAST[3][2], ENDTOPEAST[3][3], ENDTOPEAST[3][4], ENDTOPEAST[3][5]);
	protected static final VoxelShape ENDTOPEASTPart5 = Block.makeCuboidShape(ENDTOPEAST[4][0], ENDTOPEAST[4][1], ENDTOPEAST[4][2], ENDTOPEAST[4][3], ENDTOPEAST[4][4], ENDTOPEAST[4][5]);
	protected static final VoxelShape ENDTOPEASTPart6 = Block.makeCuboidShape(ENDTOPEAST[5][0], ENDTOPEAST[5][1], ENDTOPEAST[5][2], ENDTOPEAST[5][3], ENDTOPEAST[5][4], ENDTOPEAST[5][5]);
	protected static final VoxelShape ENDTOPEASTPart7 = Block.makeCuboidShape(ENDTOPEAST[6][0], ENDTOPEAST[6][1], ENDTOPEAST[6][2], ENDTOPEAST[6][3], ENDTOPEAST[6][4], ENDTOPEAST[6][5]);
	private static final VoxelShape FULL_ENDTOPEAST_SHAPE = VoxelShapes.or(ENDTOPEASTPart1, ENDTOPEASTPart2, ENDTOPEASTPart3, ENDTOPEASTPart4, ENDTOPEASTPart5, ENDTOPEASTPart6, ENDTOPEASTPart7);

	/* END TOP WEST */
	protected static final double[][] ENDTOPWEST = {{0, 8, 7, 7, 9, 9},
	                                                {0, 12, 3, 3, 13, 13},
	                                                {0, 9, 6, 6, 10, 10},
	                                                {0, 13, 2, 2, 14, 14},
	                                                {0, 10, 5, 5, 11, 11},
	                                                {0, 14, 1, 1, 15, 15},
	                                                {0, 11, 4, 4, 12, 12}};
	protected static final VoxelShape ENDTOPWESTPart1 = Block.makeCuboidShape(ENDTOPWEST[0][0], ENDTOPWEST[0][1], ENDTOPWEST[0][2], ENDTOPWEST[0][3], ENDTOPWEST[0][4], ENDTOPWEST[0][5]);
	protected static final VoxelShape ENDTOPWESTPart2 = Block.makeCuboidShape(ENDTOPWEST[1][0], ENDTOPWEST[1][1], ENDTOPWEST[1][2], ENDTOPWEST[1][3], ENDTOPWEST[1][4], ENDTOPWEST[1][5]);
	protected static final VoxelShape ENDTOPWESTPart3 = Block.makeCuboidShape(ENDTOPWEST[2][0], ENDTOPWEST[2][1], ENDTOPWEST[2][2], ENDTOPWEST[2][3], ENDTOPWEST[2][4], ENDTOPWEST[2][5]);
	protected static final VoxelShape ENDTOPWESTPart4 = Block.makeCuboidShape(ENDTOPWEST[3][0], ENDTOPWEST[3][1], ENDTOPWEST[3][2], ENDTOPWEST[3][3], ENDTOPWEST[3][4], ENDTOPWEST[3][5]);
	protected static final VoxelShape ENDTOPWESTPart5 = Block.makeCuboidShape(ENDTOPWEST[4][0], ENDTOPWEST[4][1], ENDTOPWEST[4][2], ENDTOPWEST[4][3], ENDTOPWEST[4][4], ENDTOPWEST[4][5]);
	protected static final VoxelShape ENDTOPWESTPart6 = Block.makeCuboidShape(ENDTOPWEST[5][0], ENDTOPWEST[5][1], ENDTOPWEST[5][2], ENDTOPWEST[5][3], ENDTOPWEST[5][4], ENDTOPWEST[5][5]);
	protected static final VoxelShape ENDTOPWESTPart7 = Block.makeCuboidShape(ENDTOPWEST[6][0], ENDTOPWEST[6][1], ENDTOPWEST[6][2], ENDTOPWEST[6][3], ENDTOPWEST[6][4], ENDTOPWEST[6][5]);
	private static final VoxelShape FULL_ENDTOPWEST_SHAPE = VoxelShapes.or(ENDTOPWESTPart1, ENDTOPWESTPart2, ENDTOPWESTPart3, ENDTOPWESTPart4, ENDTOPWESTPart5, ENDTOPWESTPart6, ENDTOPWESTPart7);

	/* LONG END NORTH */
	protected static final double[][] LONGENDNORTH = {{7, 7, -7, 9, 8, 0},
	                                                  {3, 3, -3, 13, 4, 0},
	                                                  {6, 6, -6, 10, 7, 0},
	                                                  {2, 2, -2, 14, 3, 0},
	                                                  {5, 5, -5, 11, 6, 0},
	                                                  {1, 1, -1, 15, 2, 0},
	                                                  {4, 4, -4, 12, 5, 0}};
	protected static final VoxelShape LONGENDNORTHPart1 = Block.makeCuboidShape(LONGENDNORTH[0][0], LONGENDNORTH[0][1], LONGENDNORTH[0][2], LONGENDNORTH[0][3], LONGENDNORTH[0][4], LONGENDNORTH[0][5]);
	protected static final VoxelShape LONGENDNORTHPart2 = Block.makeCuboidShape(LONGENDNORTH[1][0], LONGENDNORTH[1][1], LONGENDNORTH[1][2], LONGENDNORTH[1][3], LONGENDNORTH[1][4], LONGENDNORTH[1][5]);
	protected static final VoxelShape LONGENDNORTHPart3 = Block.makeCuboidShape(LONGENDNORTH[2][0], LONGENDNORTH[2][1], LONGENDNORTH[2][2], LONGENDNORTH[2][3], LONGENDNORTH[2][4], LONGENDNORTH[2][5]);
	protected static final VoxelShape LONGENDNORTHPart4 = Block.makeCuboidShape(LONGENDNORTH[3][0], LONGENDNORTH[3][1], LONGENDNORTH[3][2], LONGENDNORTH[3][3], LONGENDNORTH[3][4], LONGENDNORTH[3][5]);
	protected static final VoxelShape LONGENDNORTHPart5 = Block.makeCuboidShape(LONGENDNORTH[4][0], LONGENDNORTH[4][1], LONGENDNORTH[4][2], LONGENDNORTH[4][3], LONGENDNORTH[4][4], LONGENDNORTH[4][5]);
	protected static final VoxelShape LONGENDNORTHPart6 = Block.makeCuboidShape(LONGENDNORTH[5][0], LONGENDNORTH[5][1], LONGENDNORTH[5][2], LONGENDNORTH[5][3], LONGENDNORTH[5][4], LONGENDNORTH[5][5]);
	protected static final VoxelShape LONGENDNORTHPart7 = Block.makeCuboidShape(LONGENDNORTH[6][0], LONGENDNORTH[6][1], LONGENDNORTH[6][2], LONGENDNORTH[6][3], LONGENDNORTH[6][4], LONGENDNORTH[6][5]);
	private static final VoxelShape FULL_LONGENDNORTH_SHAPE = VoxelShapes.or(LONGENDNORTHPart1, LONGENDNORTHPart2, LONGENDNORTHPart3, LONGENDNORTHPart4, LONGENDNORTHPart5, LONGENDNORTHPart6, LONGENDNORTHPart7);

	/* LONG END SOUTH */
	protected static final double[][] LONGENDSOUTH = {{7, 7, 16, 9, 8, 23},
	                                                  {3, 3, 16, 13, 4, 19},
	                                                  {6, 6, 16, 10, 7, 22},
	                                                  {2, 2, 16, 14, 3, 18},
	                                                  {5, 5, 16, 11, 6, 21},
	                                                  {1, 1, 16, 15, 2, 17},
	                                                  {4, 4, 16, 12, 5, 20}};
	protected static final VoxelShape LONGENDSOUTHPart1 = Block.makeCuboidShape(LONGENDSOUTH[0][0], LONGENDSOUTH[0][1], LONGENDSOUTH[0][2], LONGENDSOUTH[0][3], LONGENDSOUTH[0][4], LONGENDSOUTH[0][5]);
	protected static final VoxelShape LONGENDSOUTHPart2 = Block.makeCuboidShape(LONGENDSOUTH[1][0], LONGENDSOUTH[1][1], LONGENDSOUTH[1][2], LONGENDSOUTH[1][3], LONGENDSOUTH[1][4], LONGENDSOUTH[1][5]);
	protected static final VoxelShape LONGENDSOUTHPart3 = Block.makeCuboidShape(LONGENDSOUTH[2][0], LONGENDSOUTH[2][1], LONGENDSOUTH[2][2], LONGENDSOUTH[2][3], LONGENDSOUTH[2][4], LONGENDSOUTH[2][5]);
	protected static final VoxelShape LONGENDSOUTHPart4 = Block.makeCuboidShape(LONGENDSOUTH[3][0], LONGENDSOUTH[3][1], LONGENDSOUTH[3][2], LONGENDSOUTH[3][3], LONGENDSOUTH[3][4], LONGENDSOUTH[3][5]);
	protected static final VoxelShape LONGENDSOUTHPart5 = Block.makeCuboidShape(LONGENDSOUTH[4][0], LONGENDSOUTH[4][1], LONGENDSOUTH[4][2], LONGENDSOUTH[4][3], LONGENDSOUTH[4][4], LONGENDSOUTH[4][5]);
	protected static final VoxelShape LONGENDSOUTHPart6 = Block.makeCuboidShape(LONGENDSOUTH[5][0], LONGENDSOUTH[5][1], LONGENDSOUTH[5][2], LONGENDSOUTH[5][3], LONGENDSOUTH[5][4], LONGENDSOUTH[5][5]);
	protected static final VoxelShape LONGENDSOUTHPart7 = Block.makeCuboidShape(LONGENDSOUTH[6][0], LONGENDSOUTH[6][1], LONGENDSOUTH[6][2], LONGENDSOUTH[6][3], LONGENDSOUTH[6][4], LONGENDSOUTH[6][5]);
	private static final VoxelShape FULL_LONGENDSOUTH_SHAPE = VoxelShapes.or(LONGENDSOUTHPart1, LONGENDSOUTHPart2, LONGENDSOUTHPart3, LONGENDSOUTHPart4, LONGENDSOUTHPart5, LONGENDSOUTHPart6, LONGENDSOUTHPart7);

	/* LONG END EAST */
	protected static final double[][] LONGENDEAST = {{16, 7, 7, 23, 8, 9},
	                                                 {16, 3, 3, 19, 4, 13},
	                                                 {16, 6, 6, 22, 7, 10},
	                                                 {16, 2, 2, 18, 3, 14},
	                                                 {16, 5, 5, 21, 6, 11},
	                                                 {16, 1, 1, 17, 2, 15},
	                                                 {16, 4, 4, 20, 5, 12}};
	protected static final VoxelShape LONGENDEASTPart1 = Block.makeCuboidShape(LONGENDEAST[0][0], LONGENDEAST[0][1], LONGENDEAST[0][2], LONGENDEAST[0][3], LONGENDEAST[0][4], LONGENDEAST[0][5]);
	protected static final VoxelShape LONGENDEASTPart2 = Block.makeCuboidShape(LONGENDEAST[1][0], LONGENDEAST[1][1], LONGENDEAST[1][2], LONGENDEAST[1][3], LONGENDEAST[1][4], LONGENDEAST[1][5]);
	protected static final VoxelShape LONGENDEASTPart3 = Block.makeCuboidShape(LONGENDEAST[2][0], LONGENDEAST[2][1], LONGENDEAST[2][2], LONGENDEAST[2][3], LONGENDEAST[2][4], LONGENDEAST[2][5]);
	protected static final VoxelShape LONGENDEASTPart4 = Block.makeCuboidShape(LONGENDEAST[3][0], LONGENDEAST[3][1], LONGENDEAST[3][2], LONGENDEAST[3][3], LONGENDEAST[3][4], LONGENDEAST[3][5]);
	protected static final VoxelShape LONGENDEASTPart5 = Block.makeCuboidShape(LONGENDEAST[4][0], LONGENDEAST[4][1], LONGENDEAST[4][2], LONGENDEAST[4][3], LONGENDEAST[4][4], LONGENDEAST[4][5]);
	protected static final VoxelShape LONGENDEASTPart6 = Block.makeCuboidShape(LONGENDEAST[5][0], LONGENDEAST[5][1], LONGENDEAST[5][2], LONGENDEAST[5][3], LONGENDEAST[5][4], LONGENDEAST[5][5]);
	protected static final VoxelShape LONGENDEASTPart7 = Block.makeCuboidShape(LONGENDEAST[6][0], LONGENDEAST[6][1], LONGENDEAST[6][2], LONGENDEAST[6][3], LONGENDEAST[6][4], LONGENDEAST[6][5]);
	private static final VoxelShape FULL_LONGENDEAST_SHAPE = VoxelShapes.or(LONGENDEASTPart1, LONGENDEASTPart2, LONGENDEASTPart3, LONGENDEASTPart4, LONGENDEASTPart5, LONGENDEASTPart6, LONGENDEASTPart7);

	/* LONG END WEST */
	protected static final double[][] LONGENDWEST = {{-7, 7, 7, 0, 8, 9},
	                                                 {-3, 3, 3, 0, 4, 13},
	                                                 {-6, 6, 6, 0, 7, 10},
	                                                 {-2, 2, 2, 0, 3, 14},
	                                                 {-5, 5, 5, 0, 6, 11},
	                                                 {-1, 1, 1, 0, 2, 15},
	                                                 {-4, 4, 4, 0, 5, 12}};
	protected static final VoxelShape LONGENDWESTPart1 = Block.makeCuboidShape(LONGENDWEST[0][0], LONGENDWEST[0][1], LONGENDWEST[0][2], LONGENDWEST[0][3], LONGENDWEST[0][4], LONGENDWEST[0][5]);
	protected static final VoxelShape LONGENDWESTPart2 = Block.makeCuboidShape(LONGENDWEST[1][0], LONGENDWEST[1][1], LONGENDWEST[1][2], LONGENDWEST[1][3], LONGENDWEST[1][4], LONGENDWEST[1][5]);
	protected static final VoxelShape LONGENDWESTPart3 = Block.makeCuboidShape(LONGENDWEST[2][0], LONGENDWEST[2][1], LONGENDWEST[2][2], LONGENDWEST[2][3], LONGENDWEST[2][4], LONGENDWEST[2][5]);
	protected static final VoxelShape LONGENDWESTPart4 = Block.makeCuboidShape(LONGENDWEST[3][0], LONGENDWEST[3][1], LONGENDWEST[3][2], LONGENDWEST[3][3], LONGENDWEST[3][4], LONGENDWEST[3][5]);
	protected static final VoxelShape LONGENDWESTPart5 = Block.makeCuboidShape(LONGENDWEST[4][0], LONGENDWEST[4][1], LONGENDWEST[4][2], LONGENDWEST[4][3], LONGENDWEST[4][4], LONGENDWEST[4][5]);
	protected static final VoxelShape LONGENDWESTPart6 = Block.makeCuboidShape(LONGENDWEST[5][0], LONGENDWEST[5][1], LONGENDWEST[5][2], LONGENDWEST[5][3], LONGENDWEST[5][4], LONGENDWEST[5][5]);
	protected static final VoxelShape LONGENDWESTPart7 = Block.makeCuboidShape(LONGENDWEST[6][0], LONGENDWEST[6][1], LONGENDWEST[6][2], LONGENDWEST[6][3], LONGENDWEST[6][4], LONGENDWEST[6][5]);
	private static final VoxelShape FULL_LONGENDWEST_SHAPE = VoxelShapes.or(LONGENDWESTPart1, LONGENDWESTPart2, LONGENDWESTPart3, LONGENDWESTPart4, LONGENDWESTPart5, LONGENDWESTPart6, LONGENDWESTPart7);
	
	/* LONG END TOP NORTH */
	protected static final double[][] LONGENDTOPNORTH = {{7, 8, -7, 9, 9, 0},
	                                                     {3, 12, -3, 13, 13, 0},
	                                                     {6, 9, -6, 10, 10, 0},
	                                                     {2, 13, -2, 14, 14, 0},
	                                                     {5, 10, -5, 11, 11, 0},
	                                                     {1, 14, -1, 15, 15, 0},
	                                                     {4, 11, -4, 12, 12, 0}};
	protected static final VoxelShape LONGENDTOPNORTHPart1 = Block.makeCuboidShape(LONGENDTOPNORTH[0][0], LONGENDTOPNORTH[0][1], LONGENDTOPNORTH[0][2], LONGENDTOPNORTH[0][3], LONGENDTOPNORTH[0][4], LONGENDTOPNORTH[0][5]);
	protected static final VoxelShape LONGENDTOPNORTHPart2 = Block.makeCuboidShape(LONGENDTOPNORTH[1][0], LONGENDTOPNORTH[1][1], LONGENDTOPNORTH[1][2], LONGENDTOPNORTH[1][3], LONGENDTOPNORTH[1][4], LONGENDTOPNORTH[1][5]);
	protected static final VoxelShape LONGENDTOPNORTHPart3 = Block.makeCuboidShape(LONGENDTOPNORTH[2][0], LONGENDTOPNORTH[2][1], LONGENDTOPNORTH[2][2], LONGENDTOPNORTH[2][3], LONGENDTOPNORTH[2][4], LONGENDTOPNORTH[2][5]);
	protected static final VoxelShape LONGENDTOPNORTHPart4 = Block.makeCuboidShape(LONGENDTOPNORTH[3][0], LONGENDTOPNORTH[3][1], LONGENDTOPNORTH[3][2], LONGENDTOPNORTH[3][3], LONGENDTOPNORTH[3][4], LONGENDTOPNORTH[3][5]);
	protected static final VoxelShape LONGENDTOPNORTHPart5 = Block.makeCuboidShape(LONGENDTOPNORTH[4][0], LONGENDTOPNORTH[4][1], LONGENDTOPNORTH[4][2], LONGENDTOPNORTH[4][3], LONGENDTOPNORTH[4][4], LONGENDTOPNORTH[4][5]);
	protected static final VoxelShape LONGENDTOPNORTHPart6 = Block.makeCuboidShape(LONGENDTOPNORTH[5][0], LONGENDTOPNORTH[5][1], LONGENDTOPNORTH[5][2], LONGENDTOPNORTH[5][3], LONGENDTOPNORTH[5][4], LONGENDTOPNORTH[5][5]);
	protected static final VoxelShape LONGENDTOPNORTHPart7 = Block.makeCuboidShape(LONGENDTOPNORTH[6][0], LONGENDTOPNORTH[6][1], LONGENDTOPNORTH[6][2], LONGENDTOPNORTH[6][3], LONGENDTOPNORTH[6][4], LONGENDTOPNORTH[6][5]);
	private static final VoxelShape FULL_LONGENDTOPNORTH_SHAPE = VoxelShapes.or(LONGENDTOPNORTHPart1, LONGENDTOPNORTHPart2, LONGENDTOPNORTHPart3, LONGENDTOPNORTHPart4, LONGENDTOPNORTHPart5, LONGENDTOPNORTHPart6, LONGENDTOPNORTHPart7);

	/* LONG END TOP SOUTH */
	protected static final double[][] LONGENDTOPSOUTH = {{7, 8, 16, 9, 9, 23},
	                                                     {3, 12, 16, 13, 13, 19},
	                                                     {6, 9, 16, 10, 10, 22},
	                                                     {2, 13, 16, 14, 14, 18},
	                                                     {5, 10, 16, 11, 11, 21},
	                                                     {1, 14, 16, 15, 15, 17},
	                                                     {4, 11, 16, 12, 12, 20}};
	protected static final VoxelShape LONGENDTOPSOUTHPart1 = Block.makeCuboidShape(LONGENDTOPSOUTH[0][0], LONGENDTOPSOUTH[0][1], LONGENDTOPSOUTH[0][2], LONGENDTOPSOUTH[0][3], LONGENDTOPSOUTH[0][4], LONGENDTOPSOUTH[0][5]);
	protected static final VoxelShape LONGENDTOPSOUTHPart2 = Block.makeCuboidShape(LONGENDTOPSOUTH[1][0], LONGENDTOPSOUTH[1][1], LONGENDTOPSOUTH[1][2], LONGENDTOPSOUTH[1][3], LONGENDTOPSOUTH[1][4], LONGENDTOPSOUTH[1][5]);
	protected static final VoxelShape LONGENDTOPSOUTHPart3 = Block.makeCuboidShape(LONGENDTOPSOUTH[2][0], LONGENDTOPSOUTH[2][1], LONGENDTOPSOUTH[2][2], LONGENDTOPSOUTH[2][3], LONGENDTOPSOUTH[2][4], LONGENDTOPSOUTH[2][5]);
	protected static final VoxelShape LONGENDTOPSOUTHPart4 = Block.makeCuboidShape(LONGENDTOPSOUTH[3][0], LONGENDTOPSOUTH[3][1], LONGENDTOPSOUTH[3][2], LONGENDTOPSOUTH[3][3], LONGENDTOPSOUTH[3][4], LONGENDTOPSOUTH[3][5]);
	protected static final VoxelShape LONGENDTOPSOUTHPart5 = Block.makeCuboidShape(LONGENDTOPSOUTH[4][0], LONGENDTOPSOUTH[4][1], LONGENDTOPSOUTH[4][2], LONGENDTOPSOUTH[4][3], LONGENDTOPSOUTH[4][4], LONGENDTOPSOUTH[4][5]);
	protected static final VoxelShape LONGENDTOPSOUTHPart6 = Block.makeCuboidShape(LONGENDTOPSOUTH[5][0], LONGENDTOPSOUTH[5][1], LONGENDTOPSOUTH[5][2], LONGENDTOPSOUTH[5][3], LONGENDTOPSOUTH[5][4], LONGENDTOPSOUTH[5][5]);
	protected static final VoxelShape LONGENDTOPSOUTHPart7 = Block.makeCuboidShape(LONGENDTOPSOUTH[6][0], LONGENDTOPSOUTH[6][1], LONGENDTOPSOUTH[6][2], LONGENDTOPSOUTH[6][3], LONGENDTOPSOUTH[6][4], LONGENDTOPSOUTH[6][5]);
	private static final VoxelShape FULL_LONGENDTOPSOUTH_SHAPE = VoxelShapes.or(LONGENDTOPSOUTHPart1, LONGENDTOPSOUTHPart2, LONGENDTOPSOUTHPart3, LONGENDTOPSOUTHPart4, LONGENDTOPSOUTHPart5, LONGENDTOPSOUTHPart6, LONGENDTOPSOUTHPart7);

	/* LONG END TOP EAST */
	protected static final double[][] LONGENDTOPEAST = {{16, 8, 7, 23, 9, 9},
	                                                    {16, 12, 3, 19, 13, 13},
	                                                    {16, 9, 6, 22, 10, 10},
	                                                    {16, 13, 2, 18, 14, 14},
	                                                    {16, 10, 5, 21, 11, 11},
	                                                    {16, 14, 1, 17, 15, 15},
	                                                    {16, 11, 4, 20, 12, 12}};
	protected static final VoxelShape LONGENDTOPEASTPart1 = Block.makeCuboidShape(LONGENDTOPEAST[0][0], LONGENDTOPEAST[0][1], LONGENDTOPEAST[0][2], LONGENDTOPEAST[0][3], LONGENDTOPEAST[0][4], LONGENDTOPEAST[0][5]);
	protected static final VoxelShape LONGENDTOPEASTPart2 = Block.makeCuboidShape(LONGENDTOPEAST[1][0], LONGENDTOPEAST[1][1], LONGENDTOPEAST[1][2], LONGENDTOPEAST[1][3], LONGENDTOPEAST[1][4], LONGENDTOPEAST[1][5]);
	protected static final VoxelShape LONGENDTOPEASTPart3 = Block.makeCuboidShape(LONGENDTOPEAST[2][0], LONGENDTOPEAST[2][1], LONGENDTOPEAST[2][2], LONGENDTOPEAST[2][3], LONGENDTOPEAST[2][4], LONGENDTOPEAST[2][5]);
	protected static final VoxelShape LONGENDTOPEASTPart4 = Block.makeCuboidShape(LONGENDTOPEAST[3][0], LONGENDTOPEAST[3][1], LONGENDTOPEAST[3][2], LONGENDTOPEAST[3][3], LONGENDTOPEAST[3][4], LONGENDTOPEAST[3][5]);
	protected static final VoxelShape LONGENDTOPEASTPart5 = Block.makeCuboidShape(LONGENDTOPEAST[4][0], LONGENDTOPEAST[4][1], LONGENDTOPEAST[4][2], LONGENDTOPEAST[4][3], LONGENDTOPEAST[4][4], LONGENDTOPEAST[4][5]);
	protected static final VoxelShape LONGENDTOPEASTPart6 = Block.makeCuboidShape(LONGENDTOPEAST[5][0], LONGENDTOPEAST[5][1], LONGENDTOPEAST[5][2], LONGENDTOPEAST[5][3], LONGENDTOPEAST[5][4], LONGENDTOPEAST[5][5]);
	protected static final VoxelShape LONGENDTOPEASTPart7 = Block.makeCuboidShape(LONGENDTOPEAST[6][0], LONGENDTOPEAST[6][1], LONGENDTOPEAST[6][2], LONGENDTOPEAST[6][3], LONGENDTOPEAST[6][4], LONGENDTOPEAST[6][5]);
	private static final VoxelShape FULL_LONGENDTOPEAST_SHAPE = VoxelShapes.or(LONGENDTOPEASTPart1, LONGENDTOPEASTPart2, LONGENDTOPEASTPart3, LONGENDTOPEASTPart4, LONGENDTOPEASTPart5, LONGENDTOPEASTPart6, LONGENDTOPEASTPart7);

	/* LONG END TOP WEST */
	protected static final double[][] LONGENDTOPWEST = {{-7, 8, 7, 0, 9, 9},
	                                                    {-3, 12, 3, 0, 13, 13},
	                                                    {-6, 9, 6, 0, 10, 10},
	                                                    {-2, 13, 2, 0, 14, 14},
	                                                    {-5, 10, 5, 0, 11, 11},
	                                                    {-1, 14, 1, 0, 15, 15},
	                                                    {-4, 11, 4, 0, 12, 12}};
	protected static final VoxelShape LONGENDTOPWESTPart1 = Block.makeCuboidShape(LONGENDTOPWEST[0][0], LONGENDTOPWEST[0][1], LONGENDTOPWEST[0][2], LONGENDTOPWEST[0][3], LONGENDTOPWEST[0][4], LONGENDTOPWEST[0][5]);
	protected static final VoxelShape LONGENDTOPWESTPart2 = Block.makeCuboidShape(LONGENDTOPWEST[1][0], LONGENDTOPWEST[1][1], LONGENDTOPWEST[1][2], LONGENDTOPWEST[1][3], LONGENDTOPWEST[1][4], LONGENDTOPWEST[1][5]);
	protected static final VoxelShape LONGENDTOPWESTPart3 = Block.makeCuboidShape(LONGENDTOPWEST[2][0], LONGENDTOPWEST[2][1], LONGENDTOPWEST[2][2], LONGENDTOPWEST[2][3], LONGENDTOPWEST[2][4], LONGENDTOPWEST[2][5]);
	protected static final VoxelShape LONGENDTOPWESTPart4 = Block.makeCuboidShape(LONGENDTOPWEST[3][0], LONGENDTOPWEST[3][1], LONGENDTOPWEST[3][2], LONGENDTOPWEST[3][3], LONGENDTOPWEST[3][4], LONGENDTOPWEST[3][5]);
	protected static final VoxelShape LONGENDTOPWESTPart5 = Block.makeCuboidShape(LONGENDTOPWEST[4][0], LONGENDTOPWEST[4][1], LONGENDTOPWEST[4][2], LONGENDTOPWEST[4][3], LONGENDTOPWEST[4][4], LONGENDTOPWEST[4][5]);
	protected static final VoxelShape LONGENDTOPWESTPart6 = Block.makeCuboidShape(LONGENDTOPWEST[5][0], LONGENDTOPWEST[5][1], LONGENDTOPWEST[5][2], LONGENDTOPWEST[5][3], LONGENDTOPWEST[5][4], LONGENDTOPWEST[5][5]);
	protected static final VoxelShape LONGENDTOPWESTPart7 = Block.makeCuboidShape(LONGENDTOPWEST[6][0], LONGENDTOPWEST[6][1], LONGENDTOPWEST[6][2], LONGENDTOPWEST[6][3], LONGENDTOPWEST[6][4], LONGENDTOPWEST[6][5]);
	private static final VoxelShape FULL_LONGENDTOPWEST_SHAPE = VoxelShapes.or(LONGENDTOPWESTPart1, LONGENDTOPWESTPart2, LONGENDTOPWESTPart3, LONGENDTOPWESTPart4, LONGENDTOPWESTPart5, LONGENDTOPWESTPart6, LONGENDTOPWESTPart7);
	
	private static final VoxelShape BottomFalseFalseFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE);
	private static final VoxelShape BottomFalseFalseFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseFalseFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseFalseTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomFalseFalseLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomFalseFalseTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseFalseTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseFalseLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseFalseLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseTrueFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE);
	private static final VoxelShape BottomFalseTrueFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseTrueFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseTrueTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomFalseTrueLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomFalseTrueTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseTrueTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseTrueLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseTrueLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseLongFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE);
	private static final VoxelShape BottomFalseLongFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseLongFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseLongTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomFalseLongLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomFalseLongTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseLongTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomFalseLongLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomFalseLongLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueFalseFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE);
	private static final VoxelShape BottomTrueFalseFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueFalseFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueFalseTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomTrueFalseLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomTrueFalseTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueFalseTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueFalseLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueFalseLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueTrueFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE);
	private static final VoxelShape BottomTrueTrueFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueTrueFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueTrueTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomTrueTrueLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomTrueTrueTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueTrueTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueTrueLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueTrueLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueLongFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE);
	private static final VoxelShape BottomTrueLongFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueLongFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueLongTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomTrueLongLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomTrueLongTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueLongTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomTrueLongLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomTrueLongLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongFalseFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE);
	private static final VoxelShape BottomLongFalseFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongFalseFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongFalseTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomLongFalseLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomLongFalseTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongFalseTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongFalseLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongFalseLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongTrueFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE);
	private static final VoxelShape BottomLongTrueFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongTrueFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongTrueTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomLongTrueLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomLongTrueTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongTrueTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongTrueLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongTrueLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongLongFalseFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE);
	private static final VoxelShape BottomLongLongFalseTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongLongFalseLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongLongTrueFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE);
	private static final VoxelShape BottomLongLongLongFalse = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE);
	private static final VoxelShape BottomLongLongTrueTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongLongTrueLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape BottomLongLongLongTrue = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE);
	private static final VoxelShape BottomLongLongLongLong = VoxelShapes.or(FULL_DOTBOTTOM_SHAPE, FULL_ENDNORTH_SHAPE, FULL_LONGENDNORTH_SHAPE, FULL_ENDSOUTH_SHAPE, FULL_LONGENDSOUTH_SHAPE, FULL_ENDEAST_SHAPE, FULL_LONGENDEAST_SHAPE, FULL_ENDWEST_SHAPE, FULL_LONGENDWEST_SHAPE);
	private static final VoxelShape TopFalseFalseFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE);
	private static final VoxelShape TopFalseFalseFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseFalseFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseFalseTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopFalseFalseLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopFalseFalseTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseFalseTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseFalseLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseFalseLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseTrueFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE);
	private static final VoxelShape TopFalseTrueFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseTrueFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseTrueTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopFalseTrueLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopFalseTrueTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseTrueTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseTrueLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseTrueLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseLongFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE);
	private static final VoxelShape TopFalseLongFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseLongFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseLongTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopFalseLongLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopFalseLongTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseLongTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseLongLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopFalseLongLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueFalseFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE);
	private static final VoxelShape TopTrueFalseFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueFalseFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueFalseTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopTrueFalseLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopTrueFalseTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueFalseTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueFalseLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueFalseLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueTrueFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE);
	private static final VoxelShape TopTrueTrueFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueTrueFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueTrueTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopTrueTrueLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopTrueTrueTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueTrueTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueTrueLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueTrueLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueLongFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE);
	private static final VoxelShape TopTrueLongFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueLongFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueLongTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopTrueLongLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopTrueLongTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueLongTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueLongLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopTrueLongLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongFalseFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE);
	private static final VoxelShape TopLongFalseFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongFalseFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongFalseTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopLongFalseLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopLongFalseTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongFalseTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongFalseLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongFalseLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongTrueFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE);
	private static final VoxelShape TopLongTrueFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongTrueFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongTrueTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopLongTrueLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopLongTrueTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongTrueTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongTrueLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongTrueLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongLongFalseFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE);
	private static final VoxelShape TopLongLongFalseTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongLongFalseLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongLongTrueFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE);
	private static final VoxelShape TopLongLongLongFalse = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE);
	private static final VoxelShape TopLongLongTrueTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongLongTrueLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongLongLongTrue = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE);
	private static final VoxelShape TopLongLongLongLong = VoxelShapes.or(FULL_DOTTOP_SHAPE, FULL_ENDTOPNORTH_SHAPE, FULL_LONGENDTOPNORTH_SHAPE, FULL_ENDTOPSOUTH_SHAPE, FULL_LONGENDTOPSOUTH_SHAPE, FULL_ENDTOPEAST_SHAPE, FULL_LONGENDTOPEAST_SHAPE, FULL_ENDTOPWEST_SHAPE, FULL_LONGENDTOPWEST_SHAPE);
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		if (state.get(HALF) == Half.BOTTOM) {
			if (state.get(NORTH) == MultipleNorth.FALSE) {
				if (state.get(SOUTH) == MultipleSouth.FALSE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseFalseFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseFalseFalseTrue;
						} else {
							return BottomFalseFalseFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseFalseTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseFalseTrueTrue;
						} else {
							return BottomFalseFalseTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseFalseLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseFalseLongTrue;
						} else {
							return BottomFalseFalseLongLong;
						}
					}
				} else if (state.get(SOUTH) == MultipleSouth.TRUE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseTrueFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseTrueFalseTrue;
						} else {
							return BottomFalseTrueFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseTrueTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseTrueTrueTrue;
						} else {
							return BottomFalseTrueTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseTrueLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseTrueLongTrue;
						} else {
							return BottomFalseTrueLongLong;
						}
					}
				} else {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseLongFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseLongFalseTrue;
						} else {
							return BottomFalseLongFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseLongTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseLongTrueTrue;
						} else {
							return BottomFalseLongTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomFalseLongLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomFalseLongLongTrue;
						} else {
							return BottomFalseLongLongLong;
						}
					}
				}
			} else if (state.get(NORTH) == MultipleNorth.TRUE) {
				if (state.get(SOUTH) == MultipleSouth.FALSE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueFalseFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueFalseFalseTrue;
						} else {
							return BottomTrueFalseFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueFalseTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueFalseTrueTrue;
						} else {
							return BottomTrueFalseTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueFalseLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueFalseLongTrue;
						} else {
							return BottomTrueFalseLongLong;
						}
					}
				} else if (state.get(SOUTH) == MultipleSouth.TRUE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueTrueFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueTrueFalseTrue;
						} else {
							return BottomTrueTrueFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueTrueTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueTrueTrueTrue;
						} else {
							return BottomTrueTrueTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueTrueLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueTrueLongTrue;
						} else {
							return BottomTrueTrueLongLong;
						}
					}
				} else {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueLongFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueLongFalseTrue;
						} else {
							return BottomTrueLongFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueLongTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueLongTrueTrue;
						} else {
							return BottomTrueLongTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomTrueLongLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomTrueLongLongTrue;
						} else {
							return BottomTrueLongLongLong;
						}
					}
				}
			} else {
				if (state.get(SOUTH) == MultipleSouth.FALSE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongFalseFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongFalseFalseTrue;
						} else {
							return BottomLongFalseFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongFalseTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongFalseTrueTrue;
						} else {
							return BottomLongFalseTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongFalseLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongFalseLongTrue;
						} else {
							return BottomLongFalseLongLong;
						}
					}
				} else if (state.get(SOUTH) == MultipleSouth.TRUE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongTrueFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongTrueFalseTrue;
						} else {
							return BottomLongTrueFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongTrueTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongTrueTrueTrue;
						} else {
							return BottomLongTrueTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongTrueLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongTrueLongTrue;
						} else {
							return BottomLongTrueLongLong;
						}
					}
				} else {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongLongFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongLongFalseTrue;
						} else {
							return BottomLongLongFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongLongTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongLongTrueTrue;
						} else {
							return BottomLongLongTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return BottomLongLongLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return BottomLongLongLongTrue;
						} else {
							return BottomLongLongLongLong;
						}
					}
				}
			}
		} else if (state.get(HALF) == Half.TOP) {
			if (state.get(NORTH) == MultipleNorth.FALSE) {
				if (state.get(SOUTH) == MultipleSouth.FALSE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseFalseFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseFalseFalseTrue;
						} else {
							return TopFalseFalseFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseFalseTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseFalseTrueTrue;
						} else {
							return TopFalseFalseTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseFalseLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseFalseLongTrue;
						} else {
							return TopFalseFalseLongLong;
						}
					}
				} else if (state.get(SOUTH) == MultipleSouth.TRUE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseTrueFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseTrueFalseTrue;
						} else {
							return TopFalseTrueFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseTrueTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseTrueTrueTrue;
						} else {
							return TopFalseTrueTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseTrueLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseTrueLongTrue;
						} else {
							return TopFalseTrueLongLong;
						}
					}
				} else {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseLongFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseLongFalseTrue;
						} else {
							return TopFalseLongFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseLongTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseLongTrueTrue;
						} else {
							return TopFalseLongTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopFalseLongLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopFalseLongLongTrue;
						} else {
							return TopFalseLongLongLong;
						}
					}
				}
			} else if (state.get(NORTH) == MultipleNorth.TRUE) {
				if (state.get(SOUTH) == MultipleSouth.FALSE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueFalseFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueFalseFalseTrue;
						} else {
							return TopTrueFalseFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueFalseTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueFalseTrueTrue;
						} else {
							return TopTrueFalseTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueFalseLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueFalseLongTrue;
						} else {
							return TopTrueFalseLongLong;
						}
					}
				} else if (state.get(SOUTH) == MultipleSouth.TRUE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueTrueFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueTrueFalseTrue;
						} else {
							return TopTrueTrueFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueTrueTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueTrueTrueTrue;
						} else {
							return TopTrueTrueTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueTrueLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueTrueLongTrue;
						} else {
							return TopTrueTrueLongLong;
						}
					}
				} else {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueLongFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueLongFalseTrue;
						} else {
							return TopTrueLongFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueLongTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueLongTrueTrue;
						} else {
							return TopTrueLongTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopTrueLongLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopTrueLongLongTrue;
						} else {
							return TopTrueLongLongLong;
						}
					}
				}
			} else {
				if (state.get(SOUTH) == MultipleSouth.FALSE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongFalseFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongFalseFalseTrue;
						} else {
							return TopLongFalseFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongFalseTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongFalseTrueTrue;
						} else {
							return TopLongFalseTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongFalseLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongFalseLongTrue;
						} else {
							return TopLongFalseLongLong;
						}
					}
				} else if (state.get(SOUTH) == MultipleSouth.TRUE) {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongTrueFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongTrueFalseTrue;
						} else {
							return TopLongTrueFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongTrueTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongTrueTrueTrue;
						} else {
							return TopLongTrueTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongTrueLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongTrueLongTrue;
						} else {
							return TopLongTrueLongLong;
						}
					}
				} else {
					if (state.get(EAST) == MultipleEast.FALSE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongLongFalseFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongLongFalseTrue;
						} else {
							return TopLongLongFalseLong;
						}
					} else if (state.get(EAST) == MultipleEast.TRUE) {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongLongTrueFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongLongTrueTrue;
						} else {
							return TopLongLongTrueLong;
						}
					} else {
						if (state.get(WEST) == MultipleWest.FALSE) {
							return TopLongLongLongFalse;
						} else if (state.get(WEST) == MultipleWest.TRUE) {
							return TopLongLongLongTrue;
						} else {
							return TopLongLongLongLong;
						}
					}
				}
			}
		}
		return VoxelShapes.fullCube();
	}
	
	public TriangleRamp(Block baseBlock) {
		super(Block.Properties.from(baseBlock));
		this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false).with(HALF, Half.BOTTOM).with(NORTH, MultipleNorth.FALSE).with(SOUTH, MultipleSouth.FALSE).with(EAST, MultipleEast.FALSE).with(WEST, MultipleWest.FALSE));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, HALF, NORTH, EAST, SOUTH, WEST);
	}
	
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos blockpos = context.getPos();
		FluidState FluidState = context.getWorld().getFluidState(blockpos);
		Direction direction = context.getFace();
	    BlockState blockstate = this.getDefaultState();
		BlockPos blockpos1 = blockpos.north();
	    BlockPos blockpos2 = blockpos.south();
	    BlockPos blockpos3 = blockpos.west();
	    BlockPos blockpos4 = blockpos.east();
		BlockState blockstate1 = context.getWorld().getBlockState(blockpos1);
	    BlockState blockstate2 = context.getWorld().getBlockState(blockpos2);
	    BlockState blockstate3 = context.getWorld().getBlockState(blockpos3);
	    BlockState blockstate4 = context.getWorld().getBlockState(blockpos4);
	    Block block1 = blockstate1.getBlock();
	    Block block2 = blockstate2.getBlock();
	    Block block3 = blockstate3.getBlock();
	    Block block4 = blockstate4.getBlock();
	    
	    if (block1 instanceof TriangleRamp) {
	    	blockstate = blockstate.with(NORTH, MultipleNorth.TRUE);
	    } else if (block1 instanceof RampBlock && blockstate1.get(RampBlock.FACING) == Direction.NORTH && blockstate1.get(RampBlock.HALF) == blockstate.get(HALF)) {
	    	blockstate = blockstate.with(NORTH, MultipleNorth.LONG);
	    } else {
	    	blockstate = blockstate.with(NORTH, MultipleNorth.FALSE);
	    }
	    
	    if (block2 instanceof TriangleRamp) {
	    	blockstate = blockstate.with(SOUTH, MultipleSouth.TRUE);
	    } else if (block2 instanceof RampBlock && blockstate2.get(RampBlock.FACING) == Direction.SOUTH && blockstate2.get(RampBlock.HALF) == blockstate.get(HALF)) {
	    	blockstate = blockstate.with(SOUTH, MultipleSouth.LONG);
	    } else {
	    	blockstate = blockstate.with(SOUTH, MultipleSouth.FALSE);
	    }
	    
	    if (block3 instanceof TriangleRamp) {
	    	blockstate = blockstate.with(WEST, MultipleWest.TRUE);
	    } else if (block3 instanceof RampBlock && blockstate3.get(RampBlock.FACING) == Direction.WEST && blockstate3.get(RampBlock.HALF) == blockstate.get(HALF)) {
	    	blockstate = blockstate.with(WEST, MultipleWest.LONG);
	    } else {
	    	blockstate = blockstate.with(WEST, MultipleWest.FALSE);
	    }
	    
	    if (block4 instanceof TriangleRamp) {
	    	blockstate = blockstate.with(EAST, MultipleEast.TRUE);
	    } else if (block4 instanceof RampBlock && blockstate4.get(RampBlock.FACING) == Direction.EAST && blockstate4.get(RampBlock.HALF) == blockstate.get(HALF)) {
	    	blockstate = blockstate.with(EAST, MultipleEast.LONG);
	    } else {
	    	blockstate = blockstate.with(EAST, MultipleEast.FALSE);
	    }
	    
        if (direction != Direction.DOWN && (direction == Direction.UP || !(context.getHitVec().y - (double)blockpos.getY() > 0.5D))) {
        	blockstate = blockstate.with(HALF, Half.BOTTOM);
        } else {
        	blockstate = blockstate.with(HALF, Half.TOP);
        }
        
        return blockstate.with(WATERLOGGED, Boolean.valueOf(FluidState.getFluid() == Fluids.WATER));
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
	
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (stateIn.get(WATERLOGGED)) {
			worldIn.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(worldIn));
		}
		
		BlockPos blockpos1 = currentPos.north();
	    BlockPos blockpos2 = currentPos.south();
	    BlockPos blockpos3 = currentPos.west();
	    BlockPos blockpos4 = currentPos.east();
		BlockState blockstate1 = worldIn.getBlockState(blockpos1);
	    BlockState blockstate2 = worldIn.getBlockState(blockpos2);
	    BlockState blockstate3 = worldIn.getBlockState(blockpos3);
	    BlockState blockstate4 = worldIn.getBlockState(blockpos4);
	    Block block1 = blockstate1.getBlock();
	    Block block2 = blockstate2.getBlock();
	    Block block3 = blockstate3.getBlock();
	    Block block4 = blockstate4.getBlock();
	    
	    if (block1 instanceof TriangleRamp) {
	    	stateIn = stateIn.with(NORTH, MultipleNorth.TRUE);
	    } else if (block1 instanceof RampBlock && blockstate1.get(RampBlock.FACING) == Direction.NORTH && blockstate1.get(RampBlock.HALF) == stateIn.get(HALF)) {
	    	stateIn = stateIn.with(NORTH, MultipleNorth.LONG);
	    } else {
	    	stateIn = stateIn.with(NORTH, MultipleNorth.FALSE);
	    }
	    
	    if (block2 instanceof TriangleRamp) {
	    	stateIn = stateIn.with(SOUTH, MultipleSouth.TRUE);
	    } else if (block2 instanceof RampBlock && blockstate2.get(RampBlock.FACING) == Direction.SOUTH && blockstate2.get(RampBlock.HALF) == stateIn.get(HALF)) {
	    	stateIn = stateIn.with(SOUTH, MultipleSouth.LONG);
	    } else {
	    	stateIn = stateIn.with(SOUTH, MultipleSouth.FALSE);
	    }
	    
	    if (block3 instanceof TriangleRamp) {
	    	stateIn = stateIn.with(WEST, MultipleWest.TRUE);
	    } else if (block3 instanceof RampBlock && blockstate3.get(RampBlock.FACING) == Direction.WEST && blockstate3.get(RampBlock.HALF) == stateIn.get(HALF)) {
	    	stateIn = stateIn.with(WEST, MultipleWest.LONG);
	    } else {
	    	stateIn = stateIn.with(WEST, MultipleWest.FALSE);
	    }
	    
	    if (block4 instanceof TriangleRamp) {
	    	stateIn = stateIn.with(EAST, MultipleEast.TRUE);
	    } else if (block4 instanceof RampBlock && blockstate4.get(RampBlock.FACING) == Direction.EAST && blockstate4.get(RampBlock.HALF) == stateIn.get(HALF)) {
	    	stateIn = stateIn.with(EAST, MultipleEast.LONG);
	    } else {
	    	stateIn = stateIn.with(EAST, MultipleEast.FALSE);
	    }

	    return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
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
