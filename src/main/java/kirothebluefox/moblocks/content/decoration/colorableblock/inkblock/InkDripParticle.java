package kirothebluefox.moblocks.content.decoration.colorableblock.inkblock;

import kirothebluefox.moblocks.content.ModParticles;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class InkDripParticle extends SpriteTexturedParticle {
	private final Fluid fluid;
	protected boolean fullbright;

	private InkDripParticle(ClientWorld world, double x, double y, double z, Fluid fluid, float red, float green, float blue) {
		super(world, x, y, z);
		this.setSize(0.01F, 0.01F);
		this.particleGravity = 0.06F;
		this.fluid = fluid;
		this.setColor(red, green, blue);
	}

	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	public int getBrightnessForRender(float partialTick) {
		return this.fullbright ? 240 : super.getBrightnessForRender(partialTick);
	}

	public void tick() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.ageParticle();
		if (!this.isExpired) {
			this.motionY -= (double)this.particleGravity;
			this.move(this.motionX, this.motionY, this.motionZ);
			this.updateMotion();
			if (!this.isExpired) {
				this.motionX *= (double)0.98F;
				this.motionY *= (double)0.98F;
				this.motionZ *= (double)0.98F;
				BlockPos blockpos = new BlockPos(this.posX, this.posY, this.posZ);
				FluidState fluidstate = this.world.getFluidState(blockpos);
				if (fluidstate.getFluid() == this.fluid && this.posY < (double)((float)blockpos.getY() + fluidstate.getActualHeight(this.world, blockpos))) {
					this.setExpired();
				}

			}
		}
	}

	protected void ageParticle() {
		if (this.maxAge-- <= 0) {
			this.setExpired();
		}

	}

	protected void updateMotion() {
	}

	@OnlyIn(Dist.CLIENT)
	static class Dripping extends InkDripParticle {
		private final InkParticleData particleData;

		private Dripping(ClientWorld world, double x, double y, double z, Fluid fluid, InkParticleData particleData) {
			super(world, x, y, z, fluid, particleData.getRed(), particleData.getGreen(), particleData.getBlue());
			this.particleData = particleData;
			this.particleGravity *= 0.02F;
			this.maxAge = 40;
		}

		protected void ageParticle() {
			if (this.maxAge-- <= 0) {
				this.setExpired();
				this.world.addParticle(this.particleData, this.posX, this.posY, this.posZ, this.motionX, this.motionY, this.motionZ);
			}

		}

		protected void updateMotion() {
			this.motionX *= 0.02D;
			this.motionY *= 0.02D;
			this.motionZ *= 0.02D;
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class DrippingInkFactory implements IParticleFactory<InkParticleData> {
		protected final IAnimatedSprite spriteSet;

		public DrippingInkFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(InkParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			InkDripParticle.Dripping dripparticle$dripping = new InkDripParticle.Dripping(worldIn, x, y, z, Fluids.EMPTY, new InkParticleData(ModParticles.FALLING_INK, typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue()));
			dripparticle$dripping.fullbright = true;
			dripparticle$dripping.particleGravity *= 0.01F;
			dripparticle$dripping.maxAge = 100;
			dripparticle$dripping.selectSpriteRandomly(this.spriteSet);
			return dripparticle$dripping;
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	static class FallingLiquidParticle extends InkDripParticle.FallingNectarParticle {
		protected final InkParticleData particleData;

		private FallingLiquidParticle(ClientWorld world, double x, double y, double z, Fluid fluid, InkParticleData landingInk) {
			super(world, x, y, z, fluid, landingInk);
			this.particleData = landingInk;
		}

		protected void updateMotion() {
			if (this.onGround) {
				this.setExpired();
				this.world.addParticle(this.particleData, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}

		}
	}

	@OnlyIn(Dist.CLIENT)
	static class FallingNectarParticle extends InkDripParticle {
		private FallingNectarParticle(ClientWorld world, double x, double y, double z, Fluid fluid, InkParticleData particleData) {
			super(world, x, y, z, fluid, particleData.getRed(), particleData.getGreen(), particleData.getBlue());
			this.maxAge = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
		}

		protected void updateMotion() {
			if (this.onGround) {
				this.setExpired();
			}

		}
	}
	
	@OnlyIn(Dist.CLIENT)
	public static class FallingInkFactory implements IParticleFactory<InkParticleData> {
		protected final IAnimatedSprite spriteSet;

		public FallingInkFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(InkParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			InkDripParticle dripparticle = new InkDripParticle.FallingLiquidParticle(worldIn, x, y, z, Fluids.EMPTY, new InkParticleData(ModParticles.LANDING_INK, typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue()));
			dripparticle.fullbright = true;
			dripparticle.particleGravity = 0.01F;
			dripparticle.selectSpriteRandomly(this.spriteSet);
			return dripparticle;
		}
	}

	@OnlyIn(Dist.CLIENT)
	static class Landing extends InkDripParticle {
		private Landing(ClientWorld world, double x, double y, double z, Fluid fluid, InkParticleData particleData) {
			super(world, x, y, z, fluid, particleData.getRed(), particleData.getGreen(), particleData.getBlue());
			this.maxAge = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class LandingInkFactory implements IParticleFactory<InkParticleData> {
		protected final IAnimatedSprite spriteSet;

		public LandingInkFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(InkParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			InkDripParticle dripparticle = new InkDripParticle.Landing(worldIn, x, y, z, Fluids.EMPTY, typeIn);
			dripparticle.fullbright = true;
			dripparticle.maxAge = (int)(28.0D / (Math.random() * 0.8D + 0.2D));
			dripparticle.selectSpriteRandomly(this.spriteSet);
			return dripparticle;
		}
	}
}
