package com.unbreakingwoody;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(UnbreakingWoodyMod.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnbreakingWoodyMod.MOD_ID);

    public static final DeferredItem<Item> ETERNAL_STICK =
            ITEMS.registerItem("eternal_woody",
                    EternalWoodyItem::new,
                    new Item.Properties().stacksTo(16));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> UNBREAKING_TAB =
            CREATIVE_TABS.register("unbreaking_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.unbreakingwoody.tab"))
                            .icon(() -> ModItems.ETERNAL_STICK.get().getDefaultInstance())
                            .displayItems((params, output) -> {
                                output.accept(ETERNAL_STICK.get());
                            })
                            .build());
}
