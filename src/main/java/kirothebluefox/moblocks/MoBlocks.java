package kirothebluefox.moblocks;

import kirothebluefox.moblocks.content.creativetabs.Decoration;
import kirothebluefox.moblocks.content.creativetabs.Furnitures;
import kirothebluefox.moblocks.content.creativetabs.SpecialBlocks;
import kirothebluefox.moblocks.utils.ConfigHelper;
import kirothebluefox.moblocks.utils.ConfigHelper.ConfigValueListener;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(MoBlocks.MODID)
public class MoBlocks {
    public static final String MODID = "moblocks";
	public static ConfigImplementation config;
    
    public static final ItemGroup special_blocks_creative_tab = new SpecialBlocks().setNoTitle().setBackgroundImageName("item_search.png");
    public static final ItemGroup decoration_creative_tab = new Decoration().setNoTitle().setBackgroundImageName("item_search.png");
    public static final ItemGroup furnitures_creative_tab = new Furnitures().setNoTitle().setBackgroundImageName("item_search.png");
    
    public MoBlocks() {
    	config = ConfigHelper.register(ModConfig.Type.CLIENT, ConfigImplementation::new);
    }
    
	public static class ConfigImplementation {	
		public ConfigValueListener<Boolean> shelves_quantity;
		public ConfigValueListener<Boolean> crates_quantity;
		
		public ConfigImplementation(ForgeConfigSpec.Builder builder, ConfigHelper.Subscriber subscriber) {
			builder.push("General Category");
			this.shelves_quantity = subscriber.subscribe(builder
					.comment("Shelves Quantity Text")
					.translation("config.moblocks.shelves_quantity")
					.define("shelves_quantity", true));
			this.crates_quantity = subscriber.subscribe(builder
					.comment("Crates Quantity Text")
					.translation("config.moblocks.crates_quantity")
					.define("crates_quantity", true));

			builder.pop();
		}
	}
    
    public void commonSetup(FMLCommonSetupEvent event) {
    }
}