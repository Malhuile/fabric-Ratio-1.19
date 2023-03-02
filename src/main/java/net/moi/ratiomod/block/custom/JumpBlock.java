package net.moi.ratiomod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlimeBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;

public class JumpBlock extends SlimeBlock {
    public JumpBlock(Settings settings) {
        super(settings);
    }



    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,12,5));
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}
