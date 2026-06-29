package com.unbreakingwoody;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, UnbreakingWoodyMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EternalWoodySmithingRecipe>> ETERNAL_WOODY_SMITHING =
            RECIPE_SERIALIZERS.register("eternal_woody_smithing",
                    EternalWoodySmithingRecipe.Serializer::new);
}
