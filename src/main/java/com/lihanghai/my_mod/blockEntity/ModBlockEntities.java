package com.lihanghai.my_mod.blockEntity;

import com.lihanghai.my_mod.MyOneMod;
import com.lihanghai.my_mod.block.AdvancedCraftingTableBlockEntity;
import com.lihanghai.my_mod.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {
    public static final BlockEntityType<AdvancedCraftingTableBlockEntity> ADVANCED_CRAFTING_TABLE_BE =
            BlockEntityType.Builder.of(
                    AdvancedCraftingTableBlockEntity::new,
                    ModBlocks.ADVANCED_CRAFTING_TABLE
            ).build(null);
    public static void register() {
        Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                MyOneMod.id("advanced_crafting_table"),
                ADVANCED_CRAFTING_TABLE_BE
        );
    }
}
