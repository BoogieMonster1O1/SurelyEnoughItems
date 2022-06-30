package io.github.boogiemonster1o1.sei;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ingame.SurvivalInventoryScreen;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.item.ItemStack;

public class InventoryWrapper extends SurvivalInventoryScreen {
	public InventoryWrapper() {
		super(MinecraftClient.getInstance().player);
	}

	@Override
	protected void drawForeground(int mouseX, int mouseY) {
		DiffuseLighting.enable();
		int xInitial = width + 4;
		int x = xInitial;
		int y = - this.y + 32;
		for (ItemStack stack : SurelyEnoughItems.itemRegistry.itemList) {
			drawItemStack(stack, x, y);
			x += 18;
			if (x + 16 + this.x > width) {
				x = xInitial;
				y += 18;
			}

			if (y + 16 + this.y > height)
				break;
		}
		DiffuseLighting.disable();

		super.drawForeground(mouseX, mouseY);
	}

	private void drawItemStack(ItemStack stack, int xPos, int yPos) {
		TextRenderer font = MinecraftClient.getInstance().textRenderer;
		this.itemRenderer.renderInGuiWithOverrides(stack, xPos, yPos);
		this.itemRenderer.renderGuiItemOverlay(font, stack, xPos, yPos, null);
	}
}
