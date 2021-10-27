package com.algorithmlx.liaveres.common.items;

import com.algorithmlx.liaveres.common.api.enums.LVItemTiers;
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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.algorithmlx.liaveres.common.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalPickaxe extends PickaxeItem {
    public static boolean skip = false;

    public MatterCrystalPickaxe() {
        super(LVItemTiers.MatterTear, 30, 99999999999999999999999999999999999999F, new Properties().fireResistant().tab(LIAVERES_ALL));
    }
    //`a` - modMapping name (full - algorithmlx)
    //mapping type `c` - context mapping
    //mapping type `d` - data mapping
    //mapping type `p` - pos mapping
    //and etd

    @Override
    public InteractionResult useOn(UseOnContext a_22iG45_c) {
        Player a_2938I8_d = a_22iG45_c.getPlayer();
        BlockPos a_897ZH1_p = a_22iG45_c.getClickedPos();
        ItemStack a_49218Q_d = a_22iG45_c.getItemInHand();
        if (a_2938I8_d == null) return InteractionResult.FAIL;
        Level a_cfMk2H_d = a_22iG45_c.getPlayer().level;
        if (!a_cfMk2H_d.isClientSide() && !a_2938I8_d.isShiftKeyDown() && !a_2938I8_d.getCooldowns().isOnCooldown(a_49218Q_d.getItem()) && a_2938I8_d instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) a_2938I8_d;

            if (!skip) {
                List<BlockPos> blocks = new ArrayList<>();

                for (int x = 0; x < 32; x++) {
                    for (int y = 0; y < 32; y++) {
                        for (int z = 0; z < 32; z++) {
                            int posX = a_897ZH1_p.getX();
                            int posY = a_897ZH1_p.getY();
                            int posZ = a_897ZH1_p.getZ();

                            switch (a_2938I8_d.getDirection()) {
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
                    BlockState state = a_cfMk2H_d.getBlockState(position);
                    if (!state.isAir()) {
                        serverPlayer.gameMode.destroyBlock(position);

                    }
                }
                skip = false;
            }
            a_2938I8_d.getCooldowns().addCooldown(this, 240);
        }
        return super.useOn(a_22iG45_c);
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack s, @Nullable Level w, List<Component> l, TooltipFlag f) {
        l.add(new TranslatableComponent("msg.matter_crystal_pickaxe"));
        l.add(new TranslatableComponent("msg.matter_crystal_pickaxe2"));
    }
}