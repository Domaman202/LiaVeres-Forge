package com.algorithmlx.liaveres.block;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class AmdanorSpawner extends Block {
    public AmdanorSpawner() {
        super(Properties.of(Material.METAL).strength(-1F, 340282356779733661637539395458142568447F).noOcclusion());
    }

    @Override
    public @NotNull BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack mainItem = pPlayer.getMainHandItem();
        Item activator = Registration.AMDANOR_UNLOCKER_KEY.get();
        if (!pLevel.isClientSide) {
            if ((pLevel.getDifficulty() != Difficulty.PEACEFUL) && (mainItem.getItem() == activator && pHand == InteractionHand.MAIN_HAND)) {
                Registration.AMDANOR_SKELETON.get().spawn((ServerLevel) pLevel, mainItem, pPlayer, pPos, MobSpawnType.SPAWN_EGG, true, false);
                if (!pPlayer.isCreative()) {
                    mainItem.shrink(1);
                }
                pPlayer.sendMessage(new TranslatableComponent("msg." + LiaVeres.ModId + ".amdanorSpawner.success"), pPlayer.getUUID());
            } else if (pLevel.getDifficulty() == Difficulty.PEACEFUL) {
                pPlayer.sendMessage(new TranslatableComponent("msg." + LiaVeres.ModId + ".amdanorSpawner.peaceful"), pPlayer.getUUID());
            }
        }
        return InteractionResult.SUCCESS;
    }
}
