package net.moi.ratiomod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.moi.ratiomod.RatioMod;

public class ModItemGroup {
    public static final ItemGroup RATIO = FabricItemGroupBuilder.build(
            new Identifier(RatioMod.MOD_ID, "ratio"), () -> new ItemStack(ModItems.RATIO_GEM));
}
