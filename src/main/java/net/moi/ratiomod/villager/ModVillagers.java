package net.moi.ratiomod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.moi.ratiomod.RatioMod;
import net.moi.ratiomod.block.ModBlocks;
import net.moi.ratiomod.item.ModItems;


public class ModVillagers {
    public static final PointOfInterestType GARNIER_POI = registerPOI("garnier_poi", Blocks.CAKE);
    public static final PointOfInterestType RICH_POI = registerPOI("rich_poi", ModBlocks.RICH_BLOCK);


    public static final VillagerProfession RICH = registerProfession("rich",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(RatioMod.MOD_ID, "rich_poi")));

    public static final VillagerProfession GARNIER = registerProfession("garnier",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(RatioMod.MOD_ID, "garnier_poi")));



    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type){
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(RatioMod.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(RatioMod.MOD_ID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(RatioMod.MOD_ID, name),
                1, 1, ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void  registerVillager(){
        RatioMod.LOGGER.debug("Registering Villager for " + RatioMod.MOD_ID);
    }

    public static void registerTrades(){
        TradeOfferHelper.registerVillagerOffers(GARNIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ModBlocks.JUMP_BLOCK,1),
                            6,2,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(GARNIER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.CAKE, 1),
                            new ItemStack(Items.EMERALD,5),
                            1000,4,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(GARNIER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.PUMPKIN_PIE, 1),
                            new ItemStack(Items.EMERALD,4),
                            1000,4,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(GARNIER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.COOKIE, 8),
                            new ItemStack(Items.EMERALD,12),
                            1000,4,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(GARNIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.COOKED_CHICKEN, 1),
                            new ItemStack(Items.EMERALD,4),
                            1000,4,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(GARNIER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                        new ItemStack(Items.BEEF, 16),
                            new ItemStack(Items.EMERALD,20),
                            1000,4,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(RICH, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 64),
                            new ItemStack(Items.EMERALD,1),
                            new ItemStack(Items.EMERALD,1),
                            3,100,0.02f
                    ));
                });
        TradeOfferHelper.registerVillagerOffers(RICH, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD_BLOCK,64),
                            new ItemStack(Items.EMERALD_BLOCK,64),
                            new ItemStack(ModItems.POISON_STAFF,1),
                            1,2,0.02f
                    )));
                });
        TradeOfferHelper.registerVillagerOffers(RICH,2,
                factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD_BLOCK,64),
                    new ItemStack(Items.EMERALD_BLOCK,64),
                    new ItemStack(ModItems.TELEPORT_STAFF,1),
                    1,2,0.02f
            ));
                });

    }
}
