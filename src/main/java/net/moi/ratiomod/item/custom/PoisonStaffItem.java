package net.moi.ratiomod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SnowballItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.moi.ratiomod.entity.PoisonEntity;
import net.moi.ratiomod.item.ModItems;


public class PoisonStaffItem extends Item{

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
   //     entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,120,1),user);

        return super.useOnEntity(stack, user, entity, hand);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
       /** ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient){
            ArrowEntity arrowEntity = new ArrowEntity(EntityType.ARROW,user.world);
            arrowEntity.addEffect(new StatusEffectInstance(StatusEffects.WITHER,120,1));

            arrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            world.spawnEntity(arrowEntity);
        }

        return TypedActionResult.success(itemStack, world.isClient());*/

        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            PoisonEntity poisonEntity = new PoisonEntity(world, user);
            poisonEntity.setItem(ModItems.RATIO_GEM.getDefaultStack());
            poisonEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 1.5f, 1.0f);
            world.spawnEntity(poisonEntity);

        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    public PoisonStaffItem(Settings settings) {
        super(settings);
    }
}
