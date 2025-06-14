package com.portalcraft;

import com.portalcraft.block.PortalCraftBlocks;
import com.portalcraft.item.PortalCraftItemGroups;
import com.portalcraft.item.PortalCraftItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PortalCraft implements ModInitializer {
	public static final String MOD_ID = "portalcraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		PortalCraftItemGroups.registerModItemGroups();
		PortalCraftItems.registerModItems();
		PortalCraftBlocks.registerModBlocks();
	}
}