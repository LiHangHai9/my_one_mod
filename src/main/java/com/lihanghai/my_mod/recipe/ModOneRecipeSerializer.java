package com.lihanghai.my_mod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModOneRecipeSerializer implements RecipeSerializer<ModOneRecipe> {

    public static final MapCodec<ModOneRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
        Ingredient.CODEC.fieldOf("item").forGetter(ModOneRecipe::getItem),
        ItemStack.OPTIONAL_CODEC.fieldOf("result").forGetter(ModOneRecipe::getResult),
        Codec.STRING.fieldOf("tool_tier").forGetter(ModOneRecipe::getToolTier)
    ).apply(instance,ModOneRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf,ModOneRecipe> STREAM_CODEC = StreamCodec.composite(
        Ingredient.CONTENTS_STREAM_CODEC,ModOneRecipe::getItem,
        ItemStack.OPTIONAL_STREAM_CODEC,ModOneRecipe::getResult,
        ByteBufCodecs.STRING_UTF8,ModOneRecipe::getToolTier,
        ModOneRecipe::new
    );

    @Override
    public MapCodec<ModOneRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ModOneRecipe> streamCodec() {
        return STREAM_CODEC;
    }
}
