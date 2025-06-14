package com.portalcraft.block;

import com.portalcraft.PortalCraft;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class PortalCraftBlocks {

    public static final Block WHITE_WALL_TILE = register("white_wall_tile", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), true);
    public static final Block WHITE_FLOOR_TILE_HALF = register("white_floor_tile_half", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), true);
    public static final Block CHECKER_FLOOR_TILE = register("checker_floor_tile", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), true);
    public static final Block WHITE_CEILING_TILE_HALF = register("white_ceiling_tile_half", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), true);
    public static final Block WHITE_WALL_TILE_HALF = register("white_wall_tile_half", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), true);

    public static final Block WHITE_WALL_TILE_STAIRS = register("white_wall_tile_stairs", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);
    public static final Block WHITE_WALL_TILE_SLAB = register("white_wall_tile_slab", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);

    public static final Block WHITE_FLOOR_TILE_STAIRS = register("white_floor_tile_stairs", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);
    public static final Block WHITE_FLOOR_TILE_SLAB = register("white_floor_tile_slab", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);

    public static final Block WHITE_CEILING_TILE_STAIRS = register("white_ceiling_tile_stairs", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);
    public static final Block WHITE_CEILING_TILE_SLAB = register("white_ceiling_tile_slab", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);

    public static final Block PEDESTAL_BUTTON = register("pedestal_button", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);
    public static final Block WEIGHTED_BUTTON = register("weighted_button", Block::new, AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE), false);

    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

//    private static void registerBlockItemMethod(String name, Block block) {
//        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PortalCraft.MOD_ID, name));
//        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
//        Registry.register(Registries.ITEM, key, item);
//    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(PortalCraft.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PortalCraft.MOD_ID, name));
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