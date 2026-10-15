package com.lihanghai.my_mod.recipe;

import com.lihanghai.my_mod.MyOneMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class ModOneRecipes {
    public static final RecipeType<ModOneRecipe> MOD_ONE_TYPE = new RecipeType<>() {};
    public static final RecipeSerializer<ModOneRecipe> MOD_ONE_SERIALIZER = new ModOneRecipeSerializer() {};

    public static void register() {
        Registry.register(
            BuiltInRegistries.RECIPE_TYPE,
            MyOneMod.id("mod_one"),
            MOD_ONE_TYPE
        );
        Registry.register(
            BuiltInRegistries.RECIPE_SERIALIZER,
            MyOneMod.id("mod_one"),
            MOD_ONE_SERIALIZER
        );
    }
}
