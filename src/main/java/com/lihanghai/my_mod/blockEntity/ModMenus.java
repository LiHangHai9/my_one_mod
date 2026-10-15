package com.lihanghai.my_mod.blockEntity;

import com.lihanghai.my_mod.MyOneMod;
import com.lihanghai.my_mod.block.AdvancedCraftingTableMenu;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenus {
    public static final MenuType<AdvancedCraftingTableMenu> ADVANCED_CRAFTING_TABLE_MENU =
            new MenuType<>(AdvancedCraftingTableMenu::new, FeatureFlags.DEFAULT_FLAGS);

    public static void register() {
        Registry.register(
                BuiltInRegistries.MENU,
                MyOneMod.id("advanced_crafting_table"),
                ADVANCED_CRAFTING_TABLE_MENU
        );
    }
}
