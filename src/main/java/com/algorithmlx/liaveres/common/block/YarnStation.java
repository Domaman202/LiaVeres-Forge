package com.algorithmlx.liaveres.common.block;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.block.entity.YarnStationBlockEntity;
import com.algorithmlx.liaveres.common.container.YarnStationContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class YarnStation extends Block implements EntityBlock {
    public YarnStation() {
        super(BlockBehaviour.Properties.of(Material.WOOD)
                .strength(5f, 5f)
                .noOcclusion()
        );
    }

    @Override
    public @NotNull InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof YarnStationBlockEntity) {
                MenuProvider menuProvider = new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return new TranslatableComponent("block." + LiaVeres.ModId + ".yarn_station");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
                        return new YarnStationContainer(pContainerId, pLevel, pPos, pInventory, pPlayer);
                    }
                };
                NetworkHooks.openGui((ServerPlayer) pPlayer, menuProvider, blockEntity.getBlockPos());
            }
            else {
                throw new IllegalStateException("Our named menu provider is missing!");
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new YarnStationBlockEntity(pPos, pState);
    }
}
