package kirothebluefox.moblocks;

import kirothebluefox.moblocks.content.CommonSetup;
import kirothebluefox.moblocks.content.creativetabs.Decoration;
import kirothebluefox.moblocks.content.creativetabs.Furnitures;
import kirothebluefox.moblocks.content.creativetabs.SpecialBlocks;
import kirothebluefox.moblocks.utils.ConfigHelper;
import kirothebluefox.moblocks.utils.ConfigHelper.ConfigValueListener;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoBlocks.MODID)
public class MoBlocks {
    public static final String MODID = "moblocks";
	public static ConfigImplementation config;
	
    public static final CreativeModeTab special_blocks_creative_tab = new SpecialBlocks().hideTitle().setBackgroundSuffix("item_search.png");
    public static final CreativeModeTab decoration_creative_tab = new Decoration().hideTitle().setBackgroundSuffix("item_search.png");
    public static final CreativeModeTab furnitures_creative_tab = new Furnitures().hideTitle().setBackgroundSuffix("item_search.png");
    
    public MoBlocks() {
    	config = ConfigHelper.register(ModConfig.Type.CLIENT, ConfigImplementation::new);
    	FMLJavaModLoadingContext.get().getModEventBus().addListener(CommonSetup::init);
    }
    
	public static class ConfigImplementation {	
		public ConfigValueListener<Boolean> tooltip_rendering;
		public ConfigValueListener<Boolean> shelves_quantity;
		public ConfigValueListener<Boolean> crates_quantity;
		
		public ConfigImplementation(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber) {
			builder.push("General Category");
			this.shelves_quantity = subscriber.subscribe(builder
					.comment("Show Shelves Quantity : Shows amount of items in stacks on shelves")
					.translation("config.moblocks.shelves_quantity")
					.define("shelves_quantity", true));
			this.crates_quantity = subscriber.subscribe(builder
					.comment("Show Crate Quantity : Shows amount of items in stacks on crates")
					.translation("config.moblocks.crates_quantity")
					.define("crates_quantity", true));
			this.tooltip_rendering = subscriber.subscribe(builder
					.comment("Tooltip Rendering : Render tooltip when hovering an item on a block without GUI.")
					.translation("config.moblocks.tooltip_rendering")
					.define("tooltip_rendering", true));

			builder.pop();
		}
	}
}