package net.moi.ratiomod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class TrapBlock extends Block {
    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    public TrapBlock(Settings settings) {
        super(settings);
    }



    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof LivingEntity livingEntity && livingEntity.getHealth() > 0.5){
            livingEntity.setHealth((float)0.5);
            if(entity instanceof PlayerEntity playerEntity ){
                playerEntity.getHungerManager().setFoodLevel(1);
            }
        }


       /** if(entity instanceof PlayerEntity playerEntity){

            playerEntity.setHealth((float)playerEntity.getMaxHealth());
            playerEntity.getHungerManager().setFoodLevel(20);


        }*/
        super.onSteppedOn(world, pos, state, entity);
    }



    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

       /** if(!world.isClient() && hand == Hand.MAIN_HAND){
            world.setBlockState(pos, state.cycle(LIT));
            player.sendMessage(Text.literal(world.getBlockState(pos).toString()));
        }*/
        return super.onUse(state, world, pos, player, hand, hit);
    }
}