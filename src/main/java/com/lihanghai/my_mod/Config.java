package com.lihanghai.my_mod;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

public class Config {
    public int iron_chisel_stacks_to = 8;
    public int iron_powder_stacks_to = 64;
    public int iron_powder_block_stacks_to = 32;
    public int advanced_crafting_table_stacks_to = 64;

    public static final Config CONFIG = new Config();
    static boolean stacks_max_64 = false;

    public static final Path PATH = FabricLoader.getInstance().getConfigDir().resolve("my_mod.json");
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void load () {
        if (Files.exists(PATH)) {
            try {
                String json = Files.readString(PATH);
                Config loaded = GSON.fromJson(json, Config.class);
                CONFIG.iron_powder_stacks_to = loaded.iron_powder_stacks_to;
                CONFIG.iron_powder_block_stacks_to = loaded.iron_powder_block_stacks_to;
                CONFIG.iron_chisel_stacks_to = loaded.iron_chisel_stacks_to;
                CONFIG.advanced_crafting_table_stacks_to = loaded.advanced_crafting_table_stacks_to;
                if (
                    Config.CONFIG.iron_powder_stacks_to > 64 ||
                    Config.CONFIG.iron_powder_block_stacks_to > 64 ||
                    Config.CONFIG.iron_chisel_stacks_to > 64 ||
                    Config.CONFIG.advanced_crafting_table_stacks_to > 64
                ) {
                    Config.CONFIG.iron_powder_block_stacks_to = 32;
                    Config.CONFIG.iron_powder_stacks_to = 64;
                    Config.CONFIG.iron_chisel_stacks_to = 8;
                    Config.CONFIG.advanced_crafting_table_stacks_to = 64;
                    stacks_max_64 = true;
                }
            } catch (IOException e) {
                MyOneMod.LOGGER.error("Failed to load config file!", e);
            }
        } else {
            save();
        }
    }
    public static void save () {
        try {
            Files.createDirectories(PATH.getParent());
            Files.writeString(PATH,GSON.toJson(CONFIG));
        } catch (IOException e) {
            MyOneMod.LOGGER.error("Failed to save config file!", e);
        }
    }
}
