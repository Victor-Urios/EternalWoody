package com.unbreakingwoody;

import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

/**
o mod consiste em ser client side a parte de renderização oque nao pesa em servidor.
 */
@EventBusSubscriber(modid = UnbreakingWoodyMod.MOD_ID, value = Dist.CLIENT)
public class ClientTooltipHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        if (!event.getItemStack().has(ModDataComponents.RAINBOW_NAME.get())) {
            return;
        }

        List<Component> tooltip = event.getToolTip();
        if (tooltip.isEmpty()) {
            return;
        }
        String rawName = event.getItemStack().getHoverName().getString();
        int phase = (int) (System.currentTimeMillis() / 100L);
        tooltip.set(0, RainbowTextUtil.rainbow(rawName, phase));
    }
}
