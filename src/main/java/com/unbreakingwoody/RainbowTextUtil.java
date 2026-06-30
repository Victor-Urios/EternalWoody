package com.unbreakingwoody;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public final class RainbowTextUtil {

    private static final ChatFormatting[] RAINBOW = {
            ChatFormatting.RED,
            ChatFormatting.GOLD,
            ChatFormatting.YELLOW,
            ChatFormatting.GREEN,
            ChatFormatting.AQUA,
            ChatFormatting.BLUE,
            ChatFormatting.LIGHT_PURPLE
    };

    private RainbowTextUtil() {
    }

    /** o texto é fixo, toda letra tem sua cor atribuida */
    public static MutableComponent rainbow(String text) {
        return rainbow(text, 0);
    }

    /**
     * Se colocasse i + phase ele iria rodar o nome arco-iro ao contrario então pra ele funcionar da esquerda pra direita
     * o melhor jeito foi colocando i - phase mesmo.
     */
    public static MutableComponent rainbow(String text, int phase) {
        MutableComponent line = Component.empty();
        for (int i = 0; i < text.length(); i++) {
            ChatFormatting color = RAINBOW[Math.floorMod(i - phase, RAINBOW.length)];
            line.append(Component.literal(String.valueOf(text.charAt(i))).withStyle(color));
        }
        return line;
    }
}
