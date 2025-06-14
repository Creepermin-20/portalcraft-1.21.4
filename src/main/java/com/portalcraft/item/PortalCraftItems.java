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

    public static final Item PEDESTAL_BUTTON = registerItem("pedestal_button", new Item.Settings());
    public static final Item WEIGHTED_BUTTON = registerItem("weighted_button", new Item.Settings());

    private static Item registerItem(String name, Item.Settings itemSettings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PortalCraft.MOD_ID, name));
        Item item = new Item(itemSettings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModItems() {
        PortalCraft.LOGGER.info("Registering PortalCraft Items for " + PortalCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PEDESTAL_BUTTON);
            fabricItemGroupEntries.add(WEIGHTED_BUTTON);
        });
    }
}
