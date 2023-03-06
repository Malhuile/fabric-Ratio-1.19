package net.moi.ratiomod;

import net.fabricmc.api.ModInitializer;
import net.moi.ratiomod.block.ModBlocks;
import net.moi.ratiomod.item.ModItems;
import net.moi.ratiomod.util.ModLootTableModifiers;
import net.moi.ratiomod.villager.ModVillagers;
import net.moi.ratiomod.world.feature.ModConfiguredFeatures;
import net.moi.ratiomod.world.gen.ModOreGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Very important comment
public class RatioMod implements ModInitializer {
	public static final String MOD_ID = "ratiomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModConfiguredFeatures.registerConfiguredFeatures();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModVillagers.registerVillager();
		ModVillagers.registerTrades();
		ModOreGeneration.generateOres();
		ModLootTableModifiers.modifylootTables();
	}
}
