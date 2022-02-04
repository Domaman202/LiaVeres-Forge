package com.algorithmlx.liaveres.common.item.artifact;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class LightningArtifact extends Item {
    public LightningArtifact() {
        super(new Properties().durability(10000).tab(ModSetup.ARTIFACT_TAB).rarity(Rarity.EPIC).fireResistant());
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Vec3 start  = player.getEyePosition(1);
        Vec3 vec31 = player.getViewVector(1);
        Vec3 end = start.add(vec31.x * 5, vec31.y * 5, vec31.z * 5);
        ClipContext pos = new ClipContext(start, end, ClipContext.Block.OUTLINE, ClipContext.Fluid.ANY, player);

        double x = pos.getTo().x;
        double y = pos.getTo().y;
        double z = pos.getTo().z;

        world.getBlockState(new BlockPos(x, y, z));
        LightningBolt bolt1 = new LightningBolt(EntityType.LIGHTNING_BOLT, world),
                bolt2 = new LightningBolt(EntityType.LIGHTNING_BOLT, world),
                bolt3 = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
        bolt1.moveTo(x,y,z);
        bolt2.moveTo(x,y,z);
        bolt3.moveTo(x,y,z);
        world.addFreshEntity(bolt1);
        world.addFreshEntity(bolt2);
        world.addFreshEntity(bolt3);
        if (!player.isCreative()) {
            stack.hurtAndBreak(1, player, (p_220009_1_) -> {
                p_220009_1_.broadcastBreakEvent(player.getUsedItemHand());
            });
        }
        return InteractionResultHolder.success(stack);
    }
}
