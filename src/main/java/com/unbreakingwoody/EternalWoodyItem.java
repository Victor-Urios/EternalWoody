package com.unbreakingwoody;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class EternalWoodyItem extends Item {

    // fakying rainbow effect!
    private static final ChatFormatting[] RAINBOW = {
            ChatFormatting.RED,
            ChatFormatting.GOLD,
            ChatFormatting.YELLOW,
            ChatFormatting.GREEN,
            ChatFormatting.AQUA,
            ChatFormatting.BLUE,
            ChatFormatting.LIGHT_PURPLE
    };

    public EternalWoodyItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        // Enchanted thinggie!
        return true;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.add(rainbowText("amigo estou aqui~ amigo estou aqui~"));
    }

    private static MutableComponent rainbowText(String text) {
        MutableComponent line = Component.empty();
        for (int i = 0; i < text.length(); i++) {
            line.append(Component.literal(String.valueOf(text.charAt(i)))
                    .withStyle(RAINBOW[i % RAINBOW.length]));
        }
        return line;
    }
}
