package net.moi.ratiomod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TeleportStaffItem extends Item {
    private boolean test = false;
    private String[] outputstring;


    public TeleportStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        if(test){
            return true;
        }else  return false;
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        String inputstring;

        if(!world.isClient && hand == Hand.MAIN_HAND){

            if(!test){
               test = true;
                inputstring = user.getPos().toString();
                inputstring = inputstring.replace("(","");
                inputstring = inputstring.replace(")","");
                outputstring = inputstring.split(",");
                for(String i: outputstring){
                    user.sendMessage(Text.literal(i));
                }
            }else if (test && user.world.getDimension().natural()){
                test = false;
                user.teleport(Double.parseDouble(outputstring[0]) ,Double.parseDouble(outputstring[1]) ,Double.parseDouble(outputstring[2]));
            }

        }
        return super.use(world, user, hand);
    }
}

