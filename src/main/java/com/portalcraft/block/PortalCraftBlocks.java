package com.portalcraft.block;

import com.portalcraft.PortalCraft;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class PortalCraftBlocks {

    public static final Block WHITE_WALL_TILE = registerBlock("white_wall_tile", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block WHITE_FLOOR_TILE_HALF = registerBlock("white_floor_tile_half", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block CHECKER_FLOOR_TILE = registerBlock("checker_floor_tile", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block WHITE_CEILING_TILE_HALF = registerBlock("white_ceiling_tile_half", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block WHITE_WALL_TILE_HALF = registerBlock("white_wall_tile_half", AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(PortalCraft.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItemMethod(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItemMethod(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PortalCraft.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {

        PortalCraft.LOGGER.info("Registering PortalCraft Blocks for " + PortalCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(PortalCraftBlocks.WHITE_WALL_TILE);
            fabricItemGroupEntries.add(PortalCraftBlocks.WHITE_FLOOR_TILE_HALF);
            fabricItemGroupEntries.add(PortalCraftBlocks.CHECKER_FLOOR_TILE);
            fabricItemGroupEntries.add(PortalCraftBlocks.WHITE_CEILING_TILE_HALF);
            fabricItemGroupEntries.add(PortalCraftBlocks.WHITE_WALL_TILE_HALF);
        });
    }
}