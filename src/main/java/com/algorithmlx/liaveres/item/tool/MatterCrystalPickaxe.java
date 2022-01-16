package com.algorithmlx.liaveres.item.tool;

import com.algorithmlx.liaveres.api.LVItemTier;
import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class MatterCrystalPickaxe extends PickaxeItem {
    public static boolean skip = false;

    public MatterCrystalPickaxe() {
        super(LVItemTier.MatterTear, 2147483647, 340282356779733661637539395458142568447F, new Properties().fireResistant().tab(ModSetup.CLASSIC_TAB));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
        return super.use(p_41432_, p_41433_, p_41434_);
    }
//ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player p_41433_ = context.getPlayer();
        BlockPos blockPos = context.getClickedPos();
        ItemStack p_41421_ = context.getItemInHand();
        if (p_41433_ == null) return InteractionResult.FAIL;
        Level p_41432_ = context.getPlayer().level;
        if (!p_41432_.isClientSide() && !p_41433_.isShiftKeyDown() && !p_41433_.getCooldowns().isOnCooldown(p_41421_.getItem()) && p_41433_ instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) p_41433_;

            if (!skip) {
                List<BlockPos> blocks = new ArrayList<>();

                for (int x = 0; x < 32; x++) {
                    for (int y = 0; y < 32; y++) {
                        for (int z = 0; z < 32; z++) {
                            int posX = blockPos.getX();
                            int posY = blockPos.getY();
                            int posZ = blockPos.getZ();

                            switch (p_41433_.getDirection()) {
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
                    BlockState state = p_41432_.getBlockState(position);
                    if (!state.isAir()) {
                        serverPlayer.gameMode.destroyBlock(position);

                    }
                }
                skip = false;
            }
            p_41433_.getCooldowns().addCooldown(this, 240);
        }
        return super.useOn(context);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg."+ModId+".matter_crystal_pickaxe"));
        p_41423_.add(new TranslatableComponent("msg."+ModId+".matter_crystal_msg"));
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack.copy();
    }
}