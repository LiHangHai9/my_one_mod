package com.lihanghai.my_mod;

import net.minecraft.network.chat.Component;

public class EasterEggs {
    static boolean broadcastDone = false;
    public static void run() {
        if (
            Config.stacks_max_64 && !broadcastDone
        ) {
            MyOneMod.SERVER.getPlayerList().broadcastSystemMessage(Component.translatable("easter_eggs.my_mod.config_max_max"), false);
        }else if(
            (
                Config.CONFIG.iron_powder_block_stacks_to > 32 ||
                Config.CONFIG.iron_chisel_stacks_to > 8
            ) && !broadcastDone
        ) {
            MyOneMod.SERVER.getPlayerList().broadcastSystemMessage(Component.translatable("easter_eggs.my_mod.config_max"), false);
        } else if (
            (
                Config.CONFIG.iron_powder_stacks_to < 64 ||
                Config.CONFIG.iron_powder_block_stacks_to < 32 ||
                Config.CONFIG.iron_chisel_stacks_to < 8 ||
                Config.CONFIG.advanced_crafting_table_stacks_to < 64
            ) && !broadcastDone
        ) {
            MyOneMod.SERVER.getPlayerList().broadcastSystemMessage(Component.translatable("easter_eggs.my_mod.config_min"), false);
        }
        broadcastDone = true;
    }
}
