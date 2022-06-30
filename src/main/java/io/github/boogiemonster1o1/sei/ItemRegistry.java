package io.github.boogiemonster1o1.sei;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;

public class ItemRegistry {
	public ArrayList<ItemStack> itemList = new ArrayList<ItemStack>();
	public HashSet<String> itemNameSet = new HashSet<String>();

	public ItemRegistry() {

		for (Block block : Block.REGISTRY)
			addItemStackAndSubtypes(new ItemStack(block));

		for (Item item : Item.REGISTRY)
			addItemStackAndSubtypes(new ItemStack(item));
	}

	public void addItemStackAndSubtypes(ItemStack itemStack) {
		if (itemStack == null)
			return;

		Item item = itemStack.getItem();

		if (item == null)
			return;

		if (itemStack.hasSubTypes()) {
			ArrayList<ItemStack> subItems = new ArrayList<>();
			item.appendItemStacks(item, null, subItems);
			addItemStacks(subItems);
		} else {
			addItemStack(itemStack);
		}
	}

	public void addItemStacks(Iterable<ItemStack> stacks) {
		for (ItemStack stack : stacks)
			addItemStack(stack);
	}

	public void addItemStack(ItemStack stack) {
		if (itemNameSet.contains(stack.getTranslationKey()))
			return;
		itemNameSet.add(stack.getTranslationKey());
		itemList.add(stack);
	}
}
