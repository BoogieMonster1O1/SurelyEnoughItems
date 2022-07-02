package io.github.boogiemonster1o1.sei.mixin;

import io.github.boogiemonster1o1.sei.SurvivalInventoryWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.SurvivalInventoryScreen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
	@ModifyVariable(at = @At("HEAD"), method = "openScreen", argsOnly = true, ordinal = 0)
	public Screen modifyScreen(Screen screen) {
		if (screen instanceof SurvivalInventoryScreen) {
			return new SurvivalInventoryWrapper((SurvivalInventoryScreen) screen);
		}
		return screen;
	}
}
