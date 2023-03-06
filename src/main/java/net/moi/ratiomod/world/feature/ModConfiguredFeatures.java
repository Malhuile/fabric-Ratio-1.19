package net.moi.ratiomod.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.moi.ratiomod.RatioMod;
import net.moi.ratiomod.block.ModBlocks;

import java.rmi.registry.Registry;
import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_RATIO_ORES = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RATIO_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RATIO_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> RATIO_ORE =
            ConfiguredFeatures.register("ratio_ore", Feature.ORE, new OreFeatureConfig(OVERWORLD_RATIO_ORES,3));

    public static void registerConfiguredFeatures(){
        RatioMod.LOGGER.debug("Registering the ModConfiguredFeatures for" + RatioMod.MOD_ID);
    }
}
