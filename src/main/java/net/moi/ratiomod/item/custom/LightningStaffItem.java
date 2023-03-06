package net.moi.ratiomod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class LightningStaffItem extends Item {
   

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack itemStack = context.getPlayer().getStackInHand(context.getHand());

        if (!context.getWorld().isClient && context.getHand() == Hand.MAIN_HAND) {

            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, context.getPlayer().world);
            lightning.setPos(context.getBlockPos().getX(),context.getBlockPos().getY(),context.getBlockPos().getZ());
            context.getWorld().spawnEntity(lightning);
            context.getWorld().createExplosion(lightning,context.getBlockPos().getX(),context.getBlockPos().getY(),context.getBlockPos().getZ(),2, Explosion.DestructionType.DESTROY);

        }
        return super.useOnBlock(context);
    }

    public LightningStaffItem(Settings settings) {
        super(settings);
    }
}
