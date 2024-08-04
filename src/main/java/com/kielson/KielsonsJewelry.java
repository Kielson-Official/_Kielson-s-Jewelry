package com.kielson;

import com.kielson.item.ModItemGroups;
import com.kielson.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KielsonsJewelry implements ModInitializer {
	public static final String MOD_ID = "kielsons_jewelry";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}