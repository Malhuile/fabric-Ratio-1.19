package net.moi.ratiomod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.gen.feature.PlacedFeature;

public class KnockBackStaff extends Item {


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(!user.world.isClient){
            entity.takeKnockback(2,user.getX()-entity.getX(),user.getZ()-entity.getZ());
            if(entity instanceof PlayerEntity playerEntity){
                playerEntity.takeKnockback(2,user.getX()-entity.getX(),user.getZ()-entity.getZ());
            }
        }
        


        return super.useOnEntity(stack, user, entity, hand);
    }



    public KnockBackStaff(Settings settings) {
        super(settings);
    }
}
