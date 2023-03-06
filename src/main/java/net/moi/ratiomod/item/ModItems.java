package net.moi.ratiomod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.moi.ratiomod.RatioMod;
import net.moi.ratiomod.item.custom.*;

public class ModItems {


    public static final Item RATIO_GEM = registerItem("ratio_gem",
            new Item(new FabricItemSettings().group(ModItemGroup.RATIO)));

    public static final Item ITEM_TEST = registerItem("test_item",
            new TestItem(new FabricItemSettings().group(ModItemGroup.RATIO).maxCount(1)));
    public static final Item TELEPORT_STAFF = registerItem("teleport_staff",
            new TeleportStaffItem(new FabricItemSettings().group(ModItemGroup.RATIO).maxCount(1)));
    public static final Item LIGHTNING_STAFF = registerItem("lightning_staff",
            new LightningStaffItem(new FabricItemSettings().group(ModItemGroup.RATIO).maxCount(1)));
    public static final Item KNOCKBACK_STAFF = registerItem("knockback_staff",
            new KnockBackStaff(new FabricItemSettings().group(ModItemGroup.RATIO).maxCount(1)));
    public static final Item POISON_STAFF = registerItem("poison_staff",
            new PoisonStaffItem(new FabricItemSettings().group(ModItemGroup.RATIO).maxCount(1)));
    public static final Item GARNIER_STEAK = registerItem("garnier_steak",
            new GarnierSteakItem(new Item.Settings().group(ItemGroup.FOOD).food(FoodComponents.APPLE).group(ModItemGroup.RATIO).maxCount(1)));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(RatioMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        RatioMod.LOGGER.debug("Register mod items for " + RatioMod.MOD_ID);
    }
}
