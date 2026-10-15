package com.lihanghai.my_mod.block;

import com.lihanghai.my_mod.Config;
import com.lihanghai.my_mod.MyOneMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModBlocks {
    public static final Block IRON_POWDER_BLOCK = new IronPowderBlock();
    public static final Block ADVANCED_CRAFTING_TABLE = new AdvancedCraftingTable();
    public static void register() {
        Registry.register(
                BuiltInRegistries.BLOCK,
                MyOneMod.id("iron_powder_block"),
                IRON_POWDER_BLOCK
        );
        Registry.register(
                BuiltInRegistries.ITEM,
                MyOneMod.id("iron_powder_block"),
                new BlockItem(
                        IRON_POWDER_BLOCK,
                        new Item.Properties().stacksTo(Config.CONFIG.iron_powder_block_stacks_to)
                )
        );
        Registry.register(
                BuiltInRegistries.BLOCK,
                MyOneMod.id("advanced_crafting_table"),
                ADVANCED_CRAFTING_TABLE
        );
        Registry.register(
                BuiltInRegistries.ITEM,
                MyOneMod.id("advanced_crafting_table"),
                new BlockItem(
                        ADVANCED_CRAFTING_TABLE,
                        new Item.Properties().stacksTo(Config.CONFIG.advanced_crafting_table_stacks_to)
                )
        );
    }
}
