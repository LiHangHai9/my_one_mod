package com.lihanghai.my_mod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class IronPowderBlock extends Block {
    public static final SoundType IRON_POWDER_BLOCK_SOUND = new SoundType(
            0.9F,
            1.5F,
            SoundEvents.METAL_BREAK,
            SoundEvents.METAL_STEP,
            SoundEvents.METAL_PLACE,
            SoundEvents.METAL_HIT,
            SoundEvents.METAL_FALL
    );
    public IronPowderBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(4.5F,6.5F)
                .sound(IRON_POWDER_BLOCK_SOUND)
        );
    }
}
