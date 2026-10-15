package com.lihanghai.my_mod.client;

import com.lihanghai.my_mod.blockEntity.ModMenus;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class MyOneModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenus.ADVANCED_CRAFTING_TABLE_MENU, AdvancedCraftingTableScreen::new);
    }
}
