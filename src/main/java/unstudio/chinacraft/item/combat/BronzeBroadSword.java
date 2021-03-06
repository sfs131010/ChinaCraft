package unstudio.chinacraft.item.combat;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.StatCollector;

import unstudio.chinacraft.client.render.item.SpecialItemRender;
import unstudio.chinacraft.common.ChinaCraft;
import unstudio.chinacraft.util.annotation.register.ISpecialEquippedRender;

public class BronzeBroadSword extends ItemSword implements ISpecialEquippedRender{
    private String jade = null;

    public BronzeBroadSword(ToolMaterial toolMaterial, String name) {
        super(toolMaterial);
        setUnlocalizedName("bronze_bigsword");
        if (name != null)
            jade = name;
        setMaxStackSize(1);
        setMaxDamage(500);
        setCreativeTab(ChinaCraft.tabTool);
    }

    @Override
    public String getItemStackDisplayName(ItemStack p_77653_1_) {
        if (jade != null) {
            return super.getItemStackDisplayName(p_77653_1_) + " - "
                    + StatCollector.translateToLocal("item.jade_" + jade + ".name");
        }
        return super.getItemStackDisplayName(p_77653_1_);
    }

    @Override
    public void doRender() {

    }

    @Override
    public SpecialItemRender.RenderType getSpecialRenderType() {
        return SpecialItemRender.RenderType.huge;
    }
}
