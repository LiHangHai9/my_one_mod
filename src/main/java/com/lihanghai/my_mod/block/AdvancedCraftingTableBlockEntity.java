package com.lihanghai.my_mod.block;

import com.lihanghai.my_mod.blockEntity.ModBlockEntities;
import com.lihanghai.my_mod.recipe.ModOneRecipe;
import com.lihanghai.my_mod.recipe.ModOneRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AdvancedCraftingTableBlockEntity extends BlockEntity implements MenuProvider {
    public final SimpleContainer container = new SimpleContainer(10);
    private boolean crafting = false;

    public AdvancedCraftingTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ADVANCED_CRAFTING_TABLE_BE, pos, state);
    }

    public void updateCrafting() {
        if (crafting) return;
        crafting = true;
        try {
            if (!(this.level instanceof ServerLevel server)) return;

            int toolSlot = -1;
            ModOneRecipe matchedRecipe = null;

            for (int i = 0; i < 9; i++) {
                ItemStack stack = container.getItem(i);
                if (stack.isEmpty()) continue;

                if (stack.getItem() instanceof TieredItem) {
                    if (toolSlot == -1) toolSlot = i;
                    continue;
                }

                for (RecipeHolder<ModOneRecipe> holder : server.getRecipeManager().getAllRecipesFor(ModOneRecipes.MOD_ONE_TYPE)) {
                    ModOneRecipe recipe = holder.value();
                    if (recipe.matches(new SingleRecipeInput(stack), server)) {
                        matchedRecipe = recipe;
                        break;
                    }
                }
                if (matchedRecipe != null) break;
            }

            ItemStack out = ItemStack.EMPTY;
            if (matchedRecipe != null && toolSlot != -1) {
                ItemStack tool = container.getItem(toolSlot);
                if (toolMatchesTier(tool, matchedRecipe.getToolTier())) {
                    out = matchedRecipe.getResultItem(server.registryAccess());
                }
            }
            container.setItem(9, out);
        } finally {
            crafting = false;
        }
    }

    private boolean toolMatchesTier(ItemStack tool, String requiredTier) {
        if (tool.isEmpty()) return false;
        if (!(tool.getItem() instanceof TieredItem tiered)) return false;
        return tierLevel(tiered.getTier()) >= tierLevel(requiredTier);
    }

    private int tierLevel(Tier tier) {
        if (tier == Tiers.WOOD) return 0;
        if (tier == Tiers.STONE) return 1;
        if (tier == Tiers.IRON) return 2;
        if (tier == Tiers.DIAMOND) return 3;
        if (tier == Tiers.NETHERITE) return 4;
        if (tier == Tiers.GOLD) return 0;
        return -1;
    }

    private int tierLevel(String name) {
        return switch (name.toLowerCase()) {
            case "wood", "wooden" -> 0;
            case "stone" -> 1;
            case "iron" -> 2;
            case "diamond" -> 3;
            case "netherite" -> 4;
            case "gold", "golden" -> 0;
            default -> -1;
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.my_mod.advanced_crafting_table");
    }

    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new AdvancedCraftingTableMenu(syncId, inventory, this);
    }
}
