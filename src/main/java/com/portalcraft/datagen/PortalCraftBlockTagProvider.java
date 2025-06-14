package com.portalcraft.datagen;

import com.portalcraft.block.PortalCraftBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class PortalCraftBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public PortalCraftBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(PortalCraftBlocks.CHECKER_FLOOR_TILE)
                .add(PortalCraftBlocks.WHITE_FLOOR_TILE_HALF)
                .add(PortalCraftBlocks.WHITE_CEILING_TILE_HALF)
                .add(PortalCraftBlocks.WHITE_WALL_TILE)
                .add(PortalCraftBlocks.WHITE_WALL_TILE_HALF);
//                .add(PortalCraftBlocks.WHITE_CEILING_TILE_STAIRS)
//                .add(PortalCraftBlocks.WHITE_WALL_TILE_STAIRS)
//                .add(PortalCraftBlocks.WHITE_FLOOR_TILE_STAIRS)
//                .add(PortalCraftBlocks.WHITE_CEILING_TILE_SLAB)
//                .add(PortalCraftBlocks.WHITE_WALL_TILE_SLAB)
//                .add(PortalCraftBlocks.WHITE_FLOOR_TILE_SLAB)
//                .add(PortalCraftBlocks.PEDESTAL_BUTTON)
//                .add(PortalCraftBlocks.WEIGHTED_BUTTON);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(PortalCraftBlocks.CHECKER_FLOOR_TILE)
                .add(PortalCraftBlocks.WHITE_FLOOR_TILE_HALF)
                .add(PortalCraftBlocks.WHITE_CEILING_TILE_HALF)
                .add(PortalCraftBlocks.WHITE_WALL_TILE)
                .add(PortalCraftBlocks.WHITE_WALL_TILE_HALF);
//                .add(PortalCraftBlocks.WHITE_CEILING_TILE_STAIRS)
//                .add(PortalCraftBlocks.WHITE_WALL_TILE_STAIRS)
//                .add(PortalCraftBlocks.WHITE_FLOOR_TILE_STAIRS)
//                .add(PortalCraftBlocks.WHITE_CEILING_TILE_SLAB)
//                .add(PortalCraftBlocks.WHITE_WALL_TILE_SLAB)
//                .add(PortalCraftBlocks.WHITE_FLOOR_TILE_SLAB)
//                .add(PortalCraftBlocks.PEDESTAL_BUTTON)
//                .add(PortalCraftBlocks.WEIGHTED_BUTTON);
    }
}
