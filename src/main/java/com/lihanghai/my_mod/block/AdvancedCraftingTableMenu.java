package com.lihanghai.my_mod.block;

import com.lihanghai.my_mod.blockEntity.ModMenus;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;

public class AdvancedCraftingTableMenu extends AbstractContainerMenu {
    private final Container container;
    private final AdvancedCraftingTableBlockEntity blockEntity;

    public AdvancedCraftingTableMenu(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, null);
    }

    public AdvancedCraftingTableMenu(int syncId, Inventory playerInventory, AdvancedCraftingTableBlockEntity be) {
        super(ModMenus.ADVANCED_CRAFTING_TABLE_MENU, syncId);
        this.blockEntity = be;
        this.container = (be != null) ? be.container : new SimpleContainer(10);
        this.container.startOpen(playerInventory.player);

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
                addSlot(new Slot(container, col + row * 3, 30 + col * 18, 17 + row * 18));

        addSlot(new Slot(container, 9, 124, 35) {
            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);
                for (int i = 0; i < 9; i++) {
                    ItemStack s = container.getItem(i);
                    if (!s.isEmpty() && !(s.getItem() instanceof TieredItem)) {
                        container.removeItem(i, 1);
                        break;
                    }
                }
                for (int i = 0; i < 9; i++) {
                    ItemStack s = container.getItem(i);
                    if (!s.isEmpty() && s.getItem() instanceof TieredItem) {
                        s.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                        break;
                    }
                }
            }
        });

        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 9; col++)
                addSlot(new Slot(playerInventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
        for (int col = 0; col < 9; col++)
            addSlot(new Slot(playerInventory, col, 8 + col * 18, 142));
    }

    @Override
    public void slotsChanged(Container c) {
        super.slotsChanged(c);
        if (blockEntity != null) {
            blockEntity.updateCrafting();
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return ItemStack.EMPTY;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
