package unstudio.chinacraft.item.jade;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import unstudio.chinacraft.common.ChinaCraft;
import unstudio.chinacraft.event.jade.PlayerUseJadeEvent;

public class Jade extends Item {

    public Jade(String s) {
        setUnlocalizedName(s);
        setMaxStackSize(1);
        setMaxDamage(6);
        setCreativeTab(ChinaCraft.tabCore);
    }

    public Jade(String s, int level) {
        setUnlocalizedName(s);
        setMaxStackSize(16);
        setCreativeTab(ChinaCraft.tabCore);
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        PlayerUseJadeEvent.ItemRightClick e = new PlayerUseJadeEvent.ItemRightClick(playerIn, stack);
        if (MinecraftForge.EVENT_BUS.post(e))
            return false;

        return true;
    }
}
