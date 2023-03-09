package net.moi.ratiomod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.moi.ratiomod.RatioMod;
import net.moi.ratiomod.block.custom.JumpBlock;
import net.moi.ratiomod.block.custom.TrapBlock;
import net.moi.ratiomod.item.ModItemGroup;

public class ModBlocks {

    public static final Block RATIO_BLOCK = registerBlock("ratio_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.RATIO);
    public static final Block CANDY_CANE_BLOCK = registerBlock("candy_cane",
            new Block(FabricBlockSettings.of(Material.WOOD).strength(4f).requiresTool()), ModItemGroup.RATIO);
    public static final Block RICH_BLOCK = registerBlock("rich_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.RATIO);
    public static final Block RATIO_ORE = registerBlock("ratio_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
            UniformIntProvider.create(3, 7)),ModItemGroup.RATIO);
    public static final Block DEEPSLATE_RATIO_ORE = registerBlock("deepslate_ratio_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(),
            UniformIntProvider.create(3, 7)),ModItemGroup.RATIO);
    public static final Block JUMP_BLOCK = registerBlock("jump_block",
            new JumpBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.RATIO);
    public static final Block TRAP_BLOCK = registerBlock("trap_block",
            new TrapBlock(FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()), ModItemGroup.RATIO);


    public static void registerModBlocks(){
        RatioMod.LOGGER.debug("Registering ModBlocks for " + RatioMod.MOD_ID);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(RatioMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(RatioMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }
}
