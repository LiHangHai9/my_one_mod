package com.lihanghai.my_mod;

import com.lihanghai.my_mod.block.ModBlocks;
import com.lihanghai.my_mod.item.ModItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final ResourceKey<CreativeModeTab> MY_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            MyOneMod.id("my_tab")
    );

    public static final CreativeModeTab MY_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItem.IRON_CHISEL))
            .title(Component.translatable("itemGroup.my_mod.my_tab"))
            .build();
    public static void register() {
        Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            MY_TAB_KEY,
            MY_TAB
        );

        ItemGroupEvents.modifyEntriesEvent(MY_TAB_KEY).register(itemGroup -> {
            itemGroup.accept(ModItem.IRON_CHISEL);
            itemGroup.accept(ModItem.IRON_POWDER);
            itemGroup.accept(ModBlocks.IRON_POWDER_BLOCK);
            itemGroup.accept(ModBlocks.ADVANCED_CRAFTING_TABLE);
        });
    }
}
