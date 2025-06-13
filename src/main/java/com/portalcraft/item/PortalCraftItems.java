package com.portalcraft.item;

import com.portalcraft.PortalCraft;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class PortalCraftItems {

    public static final Item PEDESTAL_BUTTON = registerItem("pedestal_button", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PortalCraft.MOD_ID,"pedestal_button")))));
    public static final Item WEIGHTED_BUTTON = registerItem("weighted_button", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PortalCraft.MOD_ID, "weighted_button")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PortalCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PortalCraft.LOGGER.info("Registering PortalCraft Items for " + PortalCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PEDESTAL_BUTTON);
            fabricItemGroupEntries.add(WEIGHTED_BUTTON);
        });
    }
}
