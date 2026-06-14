package com.anaphan.dispenserplanting;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jspecify.annotations.NonNull;

public class PlantableDispenseBehavior extends OptionalDispenseItemBehavior {

    @Override
    protected @NonNull ItemStack execute(@NonNull BlockSource source, ItemStack dispensed) {
        if (!(dispensed.getItem() instanceof BlockItem blockItem)) return dispensed;

        Level level = source.level();
        Direction direction = source.state().getValue(DispenserBlock.FACING);
        BlockPos soilPos = source.pos().relative(direction);
        BlockPos basePos = soilPos.above();

        Block crop = blockItem.getBlock();

        BlockState state = crop.defaultBlockState();

        // 1. Must have space at base
        if (!level.getBlockState(basePos).isAir()) {
            return dispensed;
        }

        // 2. Handle double plants (rose bushes, sunflowers, etc.)
        if (state.hasProperty(DoublePlantBlock.HALF)) {
            BlockPos abovePos = basePos.above();

            if (!level.getBlockState(abovePos).isAir()) {
                return dispensed;
            }

            level.setBlock(basePos,
                    state.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER),
                    3);

            level.setBlock(abovePos,
                    state.setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER),
                    3);

            dispensed.shrink(1);
            setSuccess(true);
            return dispensed;
        }

        // 3. Normal single-block plant
        if (!level.getBlockState(basePos).isAir()) {
            return dispensed;
        }

        if (state.canSurvive(level, basePos)) {
            level.setBlockAndUpdate(basePos, state);

            dispensed.shrink(1);
            setSuccess(true);
        }

        return dispensed;
    }
}