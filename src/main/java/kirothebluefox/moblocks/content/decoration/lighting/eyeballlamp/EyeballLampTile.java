package kirothebluefox.moblocks.content.decoration.lighting.eyeballlamp;

import kirothebluefox.moblocks.content.ModTileEntities;
import kirothebluefox.moblocks.content.decoration.colorableblock.ColorableBlockTile;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;

public class EyeballLampTile extends ColorableBlockTile {
	public static final String HORIZONTAL_ANGLE = "horizontalAngle";
	public static final String VERTICAL_ANGLE = "verticalAngle";
	public static final String FOLLOW_PLAYER = "followPlayer";
	public float horizontalAngle = 0;
	public float verticalAngle = 0;
	public boolean followPlayer = false;

	public EyeballLampTile() {
		super(ModTileEntities.EYEBALL_LAMP);
	}

	@Override
	public void read(BlockState blockState, CompoundNBT compound) {
		super.read(blockState, compound);
	this.horizontalAngle = compound.getInt(HORIZONTAL_ANGLE);
	this.verticalAngle = compound.getInt(VERTICAL_ANGLE);
	this.followPlayer = compound.getBoolean(FOLLOW_PLAYER);
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
	compound.putFloat(HORIZONTAL_ANGLE, this.horizontalAngle);
	compound.putFloat(VERTICAL_ANGLE, this.verticalAngle);
	compound.putBoolean(FOLLOW_PLAYER, this.followPlayer);
	return super.write(compound);
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT tag = super.getUpdateTag();
	tag.putFloat(HORIZONTAL_ANGLE, this.horizontalAngle);
	tag.putFloat(VERTICAL_ANGLE, this.verticalAngle);
	tag.putBoolean(FOLLOW_PLAYER, this.followPlayer);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(BlockState blockstate, CompoundNBT tag) {
		super.read(blockstate, tag);
		setAngle(tag.getInt(HORIZONTAL_ANGLE), tag.getInt(VERTICAL_ANGLE));
		setFollowPlayer(tag.getBoolean(FOLLOW_PLAYER));
	}

	public void setAngle(float newHAngle, float newVAngle) {
		this.horizontalAngle = newHAngle;
		this.verticalAngle = newVAngle;
		notifyBlock();
	}
	
	public float getHorizontalAngle() {
		return this.horizontalAngle;
	}
	
	public float getVerticalAngle() {
		return this.verticalAngle;
	}
	
	public void setFollowPlayer(boolean followPlayer) {
		this.followPlayer = followPlayer;
		notifyBlock();
	}

	public boolean followPlayer() {
		return followPlayer;
	}
}
