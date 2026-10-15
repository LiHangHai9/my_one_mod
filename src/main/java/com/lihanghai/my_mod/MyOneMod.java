package com.lihanghai.my_mod;

import com.lihanghai.my_mod.block.ModBlocks;
import com.lihanghai.my_mod.recipe.ModOneRecipes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lihanghai.my_mod.item.ModItem;

public class MyOneMod implements ModInitializer {
	public static final String MOD_ID = "my_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static MinecraftServer SERVER = null;

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> MyOneMod.SERVER = server);
		ServerLifecycleEvents.SERVER_STOPPED.register(server -> MyOneMod.SERVER = null);
		Config.load();
		ModItem.register();
		ModItemGroups.register();
		ModBlocks.register();
		ModOneRecipes.register();
		com.lihanghai.my_mod.blockEntity.ModMenus.register();
		com.lihanghai.my_mod.blockEntity.ModBlockEntities.register();
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			EasterEggs.run();
		});
		LOGGER.info("Hello Fabric world! (my_mod)");
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
