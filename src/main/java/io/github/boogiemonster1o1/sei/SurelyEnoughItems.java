package io.github.boogiemonster1o1.sei;

import net.fabricmc.api.ClientModInitializer;

public class SurelyEnoughItems implements ClientModInitializer {

	public static ItemRegistry itemRegistry = new ItemRegistry();
	@Override
	public void onInitializeClient() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
	}
}
