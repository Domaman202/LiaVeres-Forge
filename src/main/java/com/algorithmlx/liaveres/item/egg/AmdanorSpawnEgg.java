package com.algorithmlx.liaveres.item.egg;

import com.algorithmlx.liaveres.setup.ModSetup;
import com.algorithmlx.liaveres.setup.Registration;
import net.minecraftforge.common.ForgeSpawnEggItem;

public class AmdanorSpawnEgg extends ForgeSpawnEggItem {
    public AmdanorSpawnEgg() {
        super(Registration.AMDANOR_SKELETON, 0x000000, 0xffffff, new Properties().tab(ModSetup.MOBS_TAB));
    }

//    public AmdanorSpawnEgg() {
//        super(new Properties().tab(ModSetup.MOBS_TAB));
//    }
//
//    @Override
//    public @NotNull InteractionResult useOn(UseOnContext context) {
//        Level level = context.getLevel();
//        if (!level.isClientSide) {
//            ItemStack itemStack = context.getItemInHand();
//            BlockPos blockPos = context.getClickedPos();
//            Direction direction = context.getClickedFace();
//            BlockState blockState = level.getBlockState(blockPos);
//            BlockEntity tileEntity = level.getBlockEntity(blockPos);
//
//            if (tileEntity instanceof SpawnerBlockEntity) {
//                BaseSpawner baseSpawner = ((SpawnerBlockEntity) tileEntity).getSpawner();
//                baseSpawner.setEntityId(Registration.AMDANOR_SKELETON.get());
//                tileEntity.setChanged();
//                level.sendBlockUpdated(blockPos, blockState, blockState, Block.UPDATE_ALL);
//                itemStack.shrink(1);
//                return InteractionResult.SUCCESS;
//            }
//
//            BlockPos blockPos1;
//
//            if (blockState.getCollisionShape(level, blockPos).isEmpty()) {
//                blockPos1 = blockPos;
//            } else {
//                blockPos1 = blockPos.relative(direction);
//            }
//
//            if (Registration.AMDANOR_SKELETON.get().spawn((ServerLevel) level, itemStack, context.getPlayer(),
//                    blockPos1, MobSpawnType.SPAWN_EGG, true,
//                    !Objects.equals(blockPos, blockPos1)
//                            && direction == Direction.UP) != null) {
//                itemStack.shrink(1);
//            }
//        }
//        return InteractionResult.SUCCESS;
//    }
}
