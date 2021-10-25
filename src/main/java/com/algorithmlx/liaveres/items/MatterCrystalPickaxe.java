package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.api.enums.LVItemTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalPickaxe extends PickaxeItem {
    //public static boolean skip = false;

    public MatterCrystalPickaxe() {
        super(LVItemTiers.MatterTear, 30, 99999999999999999999999999999999999999F, new Properties().fireResistant().tab(LIAVERES_ALL));
    }

    /*@Override
    public ActionResultType use(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getPos();
        ItemStack itemstack = context.getItem();
        if (player == null) return ActionResultType.FAIL;
        World world = context.getPlayer().getEntityWorld();
        if (!world.isRemote() && !player.isSneaking() && !player.getCooldownTracker().hasCooldown(itemstack.getItem()) && player instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

            if (!skip) {
                List<BlockPos> blocks = new ArrayList<>();

                for (int x = 0; x < 31; x++) {
                    for (int y = 0; y < 31; y++) {
                        for (int z = 0; z < 31; z++) {
                            int posX = pos.getX();
                            int posY = pos.getY();
                            int posZ = pos.getZ();

                            switch (player.getHorizontalFacing()) {
                                case SOUTH:
                                    blocks.add(new BlockPos(posX + 16 - x, posY - 1 + y, posZ + z));
                                    break;
                                case NORTH:
                                    blocks.add(new BlockPos(posX - 16 + x, posY - 1 + y, posZ - z));
                                    break;
                                case EAST:
                                    blocks.add(new BlockPos(posX + x, posY - 1 + y, posZ + 16 - z));
                                    break;
                                case WEST:
                                    blocks.add(new BlockPos(posX - x, posY - 1 + y, posZ - 16 + z));
                                    break;
                            }
                        }
                    }
                }
                skip = true;
                for (BlockPos position : blocks) {
                    BlockState state = world.getBlockState(position);
                    if (!state.isAir()) {
                        serverPlayer.interactionManager.tryHarvestBlock(position);

                    }
                }
                skip = false;
            }
            player.getCooldownTracker().setCooldown(this, 240);
        }
        return super.onItemUse(context);
    }*/
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack s, @Nullable Level w, List<Component> l, TooltipFlag f) {
        l.add(new TranslatableComponent("msg.matter_crystal_pickaxe"));
    }
}