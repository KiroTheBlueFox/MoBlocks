package kirothebluefox.moblocks.content.customproperties;

import com.mojang.serialization.Codec;

import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;

public class CustomParticleType<T extends IParticleData> extends ParticleType<T> {
	private final Codec<T> codec;
	
	@SuppressWarnings("deprecation")
	public CustomParticleType(boolean alwaysShow, IParticleData.IDeserializer<T> deserializer, Codec<T> codec) {
		super(alwaysShow, deserializer);
		this.codec = codec;
	}

	@Override
	public Codec<T> func_230522_e_() {
		return this.codec;
	}
}
