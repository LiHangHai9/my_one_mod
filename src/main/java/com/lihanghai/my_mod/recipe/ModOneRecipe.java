package com.lihanghai.my_mod.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class ModOneRecipe implements Recipe<SingleRecipeInput> {
    private final Ingredient item;
    private final ItemStack result;
    private final String toolTier;
    public ModOneRecipe(Ingredient item, ItemStack result, String toolTier) {
        this.item = item;
        this.result = result;
        this.toolTier = toolTier;
    }

    @Override
    public boolean matches(SingleRecipeInput inv, Level level) {
        return item.test(inv.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput recipeInput, HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int j) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return result.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModOneRecipes.MOD_ONE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModOneRecipes.MOD_ONE_TYPE;
    }

    public Ingredient getItem() {return item;}
    public ItemStack getResult() {return result;}
    public String getToolTier() {return toolTier;}
}
