package com.algorithmlx.liaveres.common.item.tool;

import com.algorithmlx.liaveres.common.item.material.LVToolMaterial;
import com.algorithmlx.liaveres.common.setup.Config;
import com.algorithmlx.liaveres.common.setup.Constants;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;

@SuppressWarnings("ALL")
public class MatterCrystalPickaxe extends PickaxeItem {
    private static int excavate = Constants.fullExcavateRadius;
    private static int configExcavate = Constants.excavate;
    public static boolean skip = false;

    public MatterCrystalPickaxe() {
        super(LVToolMaterial.MATTER_CRYSTAL, Integer.MAX_VALUE, Float.MAX_VALUE, new Properties().fireResistant().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary));
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Player pPlayer = context.getPlayer();
        BlockPos blockPos = context.getClickedPos();
        ItemStack pItemStack = context.getItemInHand();
        if (pPlayer == null) return InteractionResult.FAIL;
        Level pLevel = pPlayer.getLevel();
        if (!pLevel.isClientSide() && !pPlayer.isShiftKeyDown() && !pPlayer.getCooldowns().isOnCooldown(pItemStack.getItem())
                && pPlayer instanceof ServerPlayer serverPlayer) {

            if (!skip) {
                List<BlockPos> blocks = new ArrayList<>();

                for (int x = 0; x < (Config.pickaxeExcavationRadius.get() * 2 - 2); x++) {
                    for (int y = 0; y < (Config.pickaxeExcavationRadius.get() * 2 - 2); y++) {
                        for (int z = 0; z < (Config.pickaxeExcavationRadius.get() * 2 - 2); z++) {
                            int posX = blockPos.getX();
                            int posY = blockPos.getY();
                            int posZ = blockPos.getZ();

                            switch (pPlayer.getDirection()) {
                                case SOUTH -> blocks.add(new BlockPos(posX + Config.pickaxeExcavationRadius.get() - x, posY - 1 + y, posZ + z));
                                case NORTH -> blocks.add(new BlockPos(posX - Config.pickaxeExcavationRadius.get() + x, posY - 1 + y, posZ - z));
                                case EAST -> blocks.add(new BlockPos(posX + x, posY - 1 + y, posZ + Config.pickaxeExcavationRadius.get() - z));
                                case WEST -> blocks.add(new BlockPos(posX - x, posY - 1 + y, posZ - Config.pickaxeExcavationRadius.get() + z));
                            }
                        }
                    }
                }
                skip = true;
                for (BlockPos position : blocks) {
                    BlockState state = pLevel.getBlockState(position);
                    if (!state.isAir()) {
                        serverPlayer.gameMode.destroyBlock(position);

                    }
                }
                skip = false;
            }
            pPlayer.getCooldowns().addCooldown(this, 240);
        }
        return super.useOn(context);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(@NotNull ItemStack pItemStack, Level p_41422_, List<Component> p_41423_, @NotNull TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg."+ModId+".matter_crystal_pickaxe"));
        p_41423_.add(new TranslatableComponent("msg."+ModId+".matter_crystal_msg").withStyle(ChatFormatting.RED, ChatFormatting.YELLOW, ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE));
        super.appendHoverText(pItemStack, p_41422_, p_41423_, p_41424_);
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