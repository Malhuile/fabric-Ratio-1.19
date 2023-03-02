package net.moi.ratiomod.entity;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class PoisonEntity extends ThrownItemEntity {

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

        if (!this.world.isClient) {

            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, this.world);
            lightning.setPos(blockHitResult.getBlockPos().getX(),blockHitResult.getBlockPos().getY(),blockHitResult.getBlockPos().getZ());
            this.world.spawnEntity(lightning);

        }
        super.onBlockHit(blockHitResult);
    }

   public PoisonEntity(World world, LivingEntity owner) {
       super(EntityType.SNOWBALL, owner, world);
   }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if (!this.world.isClient) {

            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, this.world);
            lightning.setPos(entityHitResult.getEntity().getX(),entityHitResult.getEntity().getY(),entityHitResult.getEntity().getZ());
            this.world.spawnEntity(lightning);

        }
        super.onEntityHit(entityHitResult);
    }

    public PoisonEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
