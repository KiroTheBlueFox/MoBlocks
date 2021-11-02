package kirothebluefox.moblocks.content.decoration.colorableblock.inkblock;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Locale;

public class InkParticleData implements ParticleOptions {
	public static final InkParticleData REDSTONE_DUST = new InkParticleData(1.0F, 0.0F, 0.0F);
	private ParticleType<InkParticleData> type;
	public static final Codec<InkParticleData> CODEC = RecordCodecBuilder.create((p_239803_0_) -> {
		return p_239803_0_.group(Codec.FLOAT.fieldOf("r").forGetter((p_239807_0_) -> {
			return p_239807_0_.red;
		}), Codec.FLOAT.fieldOf("g").forGetter((p_239806_0_) -> {
			return p_239806_0_.green;
		}), Codec.FLOAT.fieldOf("b").forGetter((p_239805_0_) -> {
			return p_239805_0_.blue;
		})).apply(p_239803_0_, InkParticleData::new);
	});
	@SuppressWarnings("deprecation")
	public static final ParticleOptions.Deserializer<InkParticleData> DESERIALIZER = new ParticleOptions.Deserializer<InkParticleData>() {
		public InkParticleData fromCommand(ParticleType<InkParticleData> particleTypeIn, StringReader reader) throws CommandSyntaxException {
			reader.expect(' ');
			float f = (float)reader.readDouble();
			reader.expect(' ');
			float f1 = (float)reader.readDouble();
			reader.expect(' ');
			float f2 = (float)reader.readDouble();
			return new InkParticleData(particleTypeIn, f, f1, f2);
		}

		public InkParticleData fromNetwork(ParticleType<InkParticleData> particleTypeIn, FriendlyByteBuf buffer) {
			return new InkParticleData(particleTypeIn, buffer.readFloat(), buffer.readFloat(), buffer.readFloat());
		}
	};

	public final float red;
	public final float green;
	public final float blue;

	public InkParticleData(float red, float green, float blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public InkParticleData(ParticleType<InkParticleData> type, float red, float green, float blue) {
		this.type = type;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	public InkParticleData(ParticleType<InkParticleData> type) {
		this.type = type;
		this.red = 1;
		this.green = 1;
		this.blue = 1;
	}

	public void writeToNetwork(FriendlyByteBuf buffer) {
		buffer.writeFloat(this.red);
		buffer.writeFloat(this.green);
		buffer.writeFloat(this.blue);
	}

	@SuppressWarnings("deprecation")
	public String writeToString() {
		return String.format(Locale.ROOT, "%s %.2f %.2f %.2f", Registry.PARTICLE_TYPE.getKey(this.getType()), this.red, this.green, this.blue);
	}

	public ParticleType<InkParticleData> getType() {
		return this.type;
	}

	@OnlyIn(Dist.CLIENT)
	public float getRed() {
		return this.red;
	}

	@OnlyIn(Dist.CLIENT)
	public float getGreen() {
		return this.green;
	}

	@OnlyIn(Dist.CLIENT)
	public float getBlue() {
		return this.blue;
	}
}
