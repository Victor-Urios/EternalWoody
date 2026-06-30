package com.unbreakingwoody;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.Unit;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModDataComponents {

    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, UnbreakingWoodyMod.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Unit>> RAINBOW_NAME =
            DATA_COMPONENTS.register("rainbow_name",
                    () -> DataComponentType.<Unit>builder()
                            .persistent(Unit.CODEC)
                            .networkSynchronized(StreamCodec.unit(Unit.INSTANCE))
                            .build());
}
