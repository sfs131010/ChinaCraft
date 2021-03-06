package unstudio.chinacraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import unstudio.chinacraft.client.gui.GuiID;
import unstudio.chinacraft.common.ChinaCraft;

public class ItemRedPacket extends Item {

    public ItemRedPacket() {
        setCreativeTab(ChinaCraft.tabCore);
        setUnlocalizedName("redpacket");
        setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.openGui(ChinaCraft.instance, GuiID.GUI_RedPacket, world, entityPlayer.chunkCoordX,
                entityPlayer.chunkCoordY, entityPlayer.chunkCoordZ);

        return itemStack;
    }

}
