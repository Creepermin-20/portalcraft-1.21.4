package com.portalcraft.item;

import com.portalcraft.PortalCraft;
import com.portalcraft.block.PortalCraftBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PortalCraftItemGroups {

    public static final ItemGroup PORTAL_BLOCKS = Registry.register(Registries.ITEM_GROUP, Identifier.of(PortalCraft.MOD_ID, "portal_block_items"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(PortalCraftBlocks.WHITE_WALL_TILE))
            .displayName(Text.translatable("itemgroup.portalcraft.portal_block_items"))
            .entries((displayContext, entries) -> {
                entries.add(PortalCraftBlocks.WHITE_WALL_TILE);
                entries.add(PortalCraftBlocks.WHITE_WALL_TILE_HALF);
                entries.add(PortalCraftBlocks.WHITE_CEILING_TILE_HALF);
                entries.add(PortalCraftBlocks.WHITE_FLOOR_TILE_HALF);
                entries.add(PortalCraftBlocks.CHECKER_FLOOR_TILE);
//                entries.add(PortalCraftBlocks.WHITE_WALL_TILE_STAIRS);
//                entries.add(PortalCraftBlocks.WHITE_WALL_TILE_SLAB);
//                entries.add(PortalCraftBlocks.WHITE_FLOOR_TILE_STAIRS);
//                entries.add(PortalCraftBlocks.WHITE_FLOOR_TILE_SLAB);
//                entries.add(PortalCraftBlocks.WHITE_CEILING_TILE_STAIRS);
//                entries.add(PortalCraftBlocks.WHITE_CEILING_TILE_SLAB);
            }).build());

    public static final ItemGroup PORTAL_FUNCTIONALS = Registry.register(Registries.ITEM_GROUP, Identifier.of(PortalCraft.MOD_ID, "portal_functionals"), FabricItemGroup.builder()
            .icon(() -> new ItemStack(PortalCraftItems.WEIGHTED_BUTTON))
            .displayName(Text.translatable("itemgroup.portalcraft.portal_functionals"))
            .entries((displayContext, entries) -> {
                entries.add(PortalCraftItems.PEDESTAL_BUTTON);
                entries.add(PortalCraftItems.WEIGHTED_BUTTON);
            }).build());

    public static void registerModItemGroups() {
        PortalCraft.LOGGER.info("Registering PortalCraft Item Groups in " + PortalCraft.MOD_ID);
    }
}
