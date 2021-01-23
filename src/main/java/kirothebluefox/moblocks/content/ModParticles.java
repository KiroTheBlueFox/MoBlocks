package kirothebluefox.moblocks.content;

import kirothebluefox.moblocks.MoBlocks;
import kirothebluefox.moblocks.content.customproperties.CustomParticleType;
import kirothebluefox.moblocks.content.decoration.colorableblock.inkblock.InkParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(MoBlocks.MODID)
public class ModParticles {
	public static final ParticleType<InkParticleData> DRIPPING_INK = new CustomParticleType<InkParticleData>(false, InkParticleData.DESERIALIZER, InkParticleData.field_239802_b_);
	public static final ParticleType<InkParticleData> FALLING_INK = new CustomParticleType<InkParticleData>(false, InkParticleData.DESERIALIZER, InkParticleData.field_239802_b_);
	public static final ParticleType<InkParticleData> LANDING_INK = new CustomParticleType<InkParticleData>(false, InkParticleData.DESERIALIZER, InkParticleData.field_239802_b_);
}
