package kirothebluefox.moblocks.content.decoration.colorableblock.inkblock;

import kirothebluefox.moblocks.content.ModParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class InkDripParticle extends TextureSheetParticle {
    private final Fluid fluid;
    protected boolean fullbright;

    private InkDripParticle(ClientLevel world, double x, double y, double z, Fluid fluid, float red, float green, float blue) {
        super(world, x, y, z);
        this.setSize(0.01F, 0.01F);
        this.gravity = 0.06F;
        this.fluid = fluid;
        this.setColor(red, green, blue);
    }

    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public int getLightColor(float partialTick) {
        return this.fullbright ? 240 : super.getLightColor(partialTick);
    }

    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        this.ageParticle();
        if (!this.removed) {
            this.yd -= this.gravity;
            this.move(this.xd, this.yd, this.zd);
            this.updateMotion();
            if (!this.removed) {
                this.xd *= 0.98F;
                this.yd *= 0.98F;
                this.zd *= 0.98F;
                BlockPos blockpos = new BlockPos(this.x, this.y, this.z);
                FluidState fluidstate = this.level.getFluidState(blockpos);
                if (fluidstate.getType() == this.fluid && this.y < (double) ((float) blockpos.getY() + fluidstate.getHeight(this.level, blockpos))) {
                    this.remove();
                }

            }
        }
    }

    protected void ageParticle() {
        if (this.lifetime-- <= 0) {
            this.remove();
        }

    }

    protected void updateMotion() {
    }

    @OnlyIn(Dist.CLIENT)
    static class Dripping extends InkDripParticle {
        private final InkParticleData particleData;

        private Dripping(ClientLevel world, double x, double y, double z, Fluid fluid, InkParticleData particleData) {
            super(world, x, y, z, fluid, particleData.getRed(), particleData.getGreen(), particleData.getBlue());
            this.particleData = particleData;
            this.gravity *= 0.02F;
            this.lifetime = 40;
        }

        protected void ageParticle() {
            if (this.lifetime-- <= 0) {
                this.remove();
                this.level.addParticle(this.particleData, this.x, this.y, this.z, this.xd, this.yd, this.zd);
            }

        }

        protected void updateMotion() {
            this.xd *= 0.02D;
            this.yd *= 0.02D;
            this.zd *= 0.02D;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class DrippingInkFactory implements ParticleProvider<InkParticleData> {
        protected final SpriteSet spriteSet;

        public DrippingInkFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(InkParticleData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            InkDripParticle.Dripping dripparticle$dripping = new InkDripParticle.Dripping(worldIn, x, y, z, Fluids.EMPTY, new InkParticleData(ModParticles.FALLING_INK, typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue()));
            dripparticle$dripping.fullbright = true;
            dripparticle$dripping.gravity *= 0.01F;
            dripparticle$dripping.lifetime = 100;
            dripparticle$dripping.pickSprite(this.spriteSet);
            return dripparticle$dripping;
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class FallingLiquidParticle extends InkDripParticle.FallingNectarParticle {
        protected final InkParticleData particleData;

        private FallingLiquidParticle(ClientLevel world, double x, double y, double z, Fluid fluid, InkParticleData landingInk) {
            super(world, x, y, z, fluid, landingInk);
            this.particleData = landingInk;
        }

        protected void updateMotion() {
            if (this.onGround) {
                this.remove();
                this.level.addParticle(this.particleData, this.x, this.y, this.z, 0.0D, 0.0D, 0.0D);
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    static class FallingNectarParticle extends InkDripParticle {
        private FallingNectarParticle(ClientLevel world, double x, double y, double z, Fluid fluid, InkParticleData particleData) {
            super(world, x, y, z, fluid, particleData.getRed(), particleData.getGreen(), particleData.getBlue());
            this.lifetime = (int) (64.0D / (Math.random() * 0.8D + 0.2D));
        }

        protected void updateMotion() {
            if (this.onGround) {
                this.remove();
            }

        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class FallingInkFactory implements ParticleProvider<InkParticleData> {
        protected final SpriteSet spriteSet;

        public FallingInkFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(InkParticleData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            InkDripParticle dripparticle = new InkDripParticle.FallingLiquidParticle(worldIn, x, y, z, Fluids.EMPTY, new InkParticleData(ModParticles.LANDING_INK, typeIn.getRed(), typeIn.getGreen(), typeIn.getBlue()));
            dripparticle.fullbright = true;
            dripparticle.gravity = 0.01F;
            dripparticle.pickSprite(this.spriteSet);
            return dripparticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class Landing extends InkDripParticle {
        private Landing(ClientLevel world, double x, double y, double z, Fluid fluid, InkParticleData particleData) {
            super(world, x, y, z, fluid, particleData.getRed(), particleData.getGreen(), particleData.getBlue());
            this.lifetime = (int) (16.0D / (Math.random() * 0.8D + 0.2D));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class LandingInkFactory implements ParticleProvider<InkParticleData> {
        protected final SpriteSet spriteSet;

        public LandingInkFactory(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(InkParticleData typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            InkDripParticle dripparticle = new InkDripParticle.Landing(worldIn, x, y, z, Fluids.EMPTY, typeIn);
            dripparticle.fullbright = true;
            dripparticle.lifetime = (int) (28.0D / (Math.random() * 0.8D + 0.2D));
            dripparticle.pickSprite(this.spriteSet);
            return dripparticle;
        }
    }
}
