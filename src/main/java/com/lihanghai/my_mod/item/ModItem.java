package com.lihanghai.my_mod.item;

import com.lihanghai.my_mod.Config;
import com.lihanghai.my_mod.MyOneMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

public class ModItem {
    public static final Item IRON_CHISEL = new Item(new Item.Properties().stacksTo(Config.CONFIG.iron_chisel_stacks_to));
    public static final Item IRON_POWDER = new Item(new Item.Properties().stacksTo(Config.CONFIG.iron_powder_stacks_to));

    public static void register() {
        Registry.register(
                BuiltInRegistries.ITEM,
                MyOneMod.id("iron_chisel"),
                IRON_CHISEL
        );
        Registry.register(
                BuiltInRegistries.ITEM,
                MyOneMod.id("iron_powder"),
                IRON_POWDER
        );
    }
}
