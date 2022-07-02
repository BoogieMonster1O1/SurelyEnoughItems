package io.github.boogiemonster1o1.sei;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.ingame.SurvivalInventoryScreen;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.item.ItemStack;

public class SurvivalInventoryWrapper extends SurvivalInventoryScreen {
	public SurvivalInventoryWrapper(SurvivalInventoryScreen original) {
		super(MinecraftClient.getInstance().player);
	}

	@Override
	protected void drawForeground(int mouseX, int mouseY) {
		DiffuseLighting.enable();
		int xInitial = backgroundWidth + 4;
		int x = xInitial;
		int y = - this.y + 32;
		for (ItemStack stack : SurelyEnoughItems.itemRegistry.itemList) {
			drawItemStack(stack, x, y);
			x += 18;
			if (x + 16 + this.x > backgroundWidth) {
				x = xInitial;
				y += 18;
			}

			if (y + 16 + this.y > backgroundHeight)
				break;
		}
		DiffuseLighting.disable();

		super.drawForeground(mouseX, mouseY);
	}

	private void drawItemStack(ItemStack stack, int xPos, int yPos) {
		System.out.println("bruh" + stack);
		TextRenderer font = MinecraftClient.getInstance().textRenderer;
		this.itemRenderer.renderInGuiWithOverrides(stack, xPos, yPos);
		this.itemRenderer.method_1549(font, stack, xPos, yPos);
	}
}
