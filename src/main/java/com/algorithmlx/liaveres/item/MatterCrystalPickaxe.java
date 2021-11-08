package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.api.enums.LVToolTier;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;


public class MatterCrystalPickaxe extends PickaxeItem {
    public static boolean skip = false;

    public MatterCrystalPickaxe() {
        super(LVToolTier.MatterCrystalTier, 2147483647, 340282356779733661637539395458142568447F, new Properties().fireResistant().tab(LIAVERES_ALL));
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        ItemStack itemstack = context.getItemInHand();
        if (player == null) return ActionResultType.FAIL;
        World world = context.getPlayer().getEntity().level;
        if (!world.isClientSide() && !player.isShiftKeyDown() && !player.getCooldowns().isOnCooldown(itemstack.getItem()) && player instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;

            if (!skip) {
                List<BlockPos> blocks = new ArrayList<>();

                for (int x = 0; x < 32; x++) {
                    for (int y = 0; y < 32; y++) {
                        for (int z = 0; z < 32; z++) {
                            int posX = pos.getX();
                            int posY = pos.getY();
                            int posZ = pos.getZ();

                            switch (player.getDirection()) {
                                case SOUTH:
                                    blocks.add(new BlockPos(posX + 17 - x, posY - 1 + y, posZ + z));
                                    break;
                                case NORTH:
                                    blocks.add(new BlockPos(posX - 17 + x, posY - 1 + y, posZ - z));
                                    break;
                                case EAST:
                                    blocks.add(new BlockPos(posX + x, posY - 1 + y, posZ + 17 - z));
                                    break;
                                case WEST:
                                    blocks.add(new BlockPos(posX - x, posY - 1 + y, posZ - 17 + z));
                                    break;
                            }
                        }
                    }
                }
                skip = true;
                for (BlockPos position : blocks) {
                    BlockState state = world.getBlockState(position);
                    if (!state.isAir()) {
                        serverPlayer.gameMode.destroyBlock(position);

                    }
                }
                skip = false;
            }
            player.getCooldowns().addCooldown(this, 240);
        }
        return super.useOn(context);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        p_77624_3_.add(new TranslationTextComponent("msg."+ModId+".matter_crystal_pickaxe"));
        p_77624_3_.add(new TranslationTextComponent("msg."+ModId+".matter_crystal_pickaxe2"));
        super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }
}