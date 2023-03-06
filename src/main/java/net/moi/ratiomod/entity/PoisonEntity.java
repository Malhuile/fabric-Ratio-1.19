package net.moi.ratiomod.entity;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;


public class PoisonEntity extends ThrownItemEntity implements PoisonEntitytest {

   public PoisonEntity(World world, LivingEntity owner) {
       super(EntityType.SNOWBALL, owner, world);
   }

    public PoisonEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, this.world);
            lightning.setPos(hitResult.getPos().x, hitResult.getPos().y,hitResult.getPos().z);
            this.world.spawnEntity(lightning);
            this.world.sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            this.discard();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
