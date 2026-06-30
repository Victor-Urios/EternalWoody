package com.unbreakingwoody;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(UnbreakingWoodyMod.MOD_ID)
public class UnbreakingWoodyMod {

    public static final String MOD_ID = "unbreakingwoody";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UnbreakingWoodyMod(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
        ModItems.CREATIVE_TABS.register(modEventBus);
        ModRecipes.RECIPE_SERIALIZERS.register(modEventBus);
        ModDataComponents.DATA_COMPONENTS.register(modEventBus);
        LOGGER.info("[UnbreakingWoody] Mod initialized.");
    }
}
