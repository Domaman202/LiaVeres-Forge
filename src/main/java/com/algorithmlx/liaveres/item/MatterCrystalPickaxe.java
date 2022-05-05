package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MatterCrystalPickaxe extends ItemPickaxe {
    public MatterCrystalPickaxe(ToolMaterial material, String itemId) {
        super(material);
        this.setRegistryName(itemId);
    }

//    @Override
//    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//        ItemStack itemstack = context.getItemInHand();
//        if (player == null) return EnumActionResult.FAIL;
//        World world = context.getPlayer().getEntity().level;
//        if (!world.isClientSide() && !player.isShiftKeyDown() && !player.getCooldowns().isOnCooldown(itemstack.getItem()) && player instanceof ServerPlayerEntity) {
//            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
//
//            if (!skip) {
//                List<BlockPos> blocks = new ArrayList<>();
//
//                for (int x = 0; x < 32; x++) {
//                    for (int y = 0; y < 32; y++) {
//                        for (int z = 0; z < 32; z++) {
//                            int posX = pos.getX();
//                            int posY = pos.getY();
//                            int posZ = pos.getZ();
//
//                            switch (player.()) {
//                                case SOUTH:
//                                    blocks.add(new BlockPos(posX + 17 - x, posY - 1 + y, posZ + z));
//                                    break;
//                                case NORTH:
//                                    blocks.add(new BlockPos(posX - 17 + x, posY - 1 + y, posZ - z));
//                                    break;
//                                case EAST:
//                                    blocks.add(new BlockPos(posX + x, posY - 1 + y, posZ + 17 - z));
//                                    break;
//                                case WEST:
//                                    blocks.add(new BlockPos(posX - x, posY - 1 + y, posZ - 17 + z));
//                                    break;
//                            }
//                        }
//                    }
//                }
//                skip = true;
//                for (BlockPos position : blocks) {
//                    BlockState state = world.getBlockState(position);
//                    if (!state.isAir()) {
//                        serverPlayer.gameMode.destroyBlock(position);
//
//                    }
//                }
//                skip = false;
//            }
//            player.getCooldowns().addCooldown(this, 240);
//        }
//        return super.useOn(context);

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("msg."+ LiaVeresLegacy.MOD_ID +".matter_crystal_pickaxe");
        tooltip.add("msg."+ LiaVeresLegacy.MOD_ID +".matter_crystal_pickaxe2");
    }
}
