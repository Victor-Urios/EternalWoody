package com.unbreakingwoody;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public class EternalWoodySmithingRecipe implements SmithingRecipe {

    private final Ingredient addition;

    public EternalWoodySmithingRecipe(Ingredient addition) {
        this.addition = addition;
    }

    // slot checks

    @Override
    public boolean isTemplateIngredient(ItemStack stack) {
        return stack.isEmpty();
    }

    @Override
    public boolean isBaseIngredient(ItemStack stack) {
        // Any item that has durability (tools, weapons, armor, bows, etc.) works to any modded items too!
        return stack.isDamageableItem();
    }

    @Override
    public boolean isAdditionIngredient(ItemStack stack) {
        return addition.test(stack);
    }

    @Override
    public boolean matches(SmithingRecipeInput input, Level level) {
        return isTemplateIngredient(input.template())
                && isBaseIngredient(input.base())
                && isAdditionIngredient(input.addition());
    }

    // output

    @Override
    public ItemStack assemble(SmithingRecipeInput input, HolderLookup.Provider registries) {
        ItemStack result = input.base().copy();
        // showInTooltip=true displays "Unbreakable" in the item tooltip
        result.set(DataComponents.UNBREAKABLE, new Unbreakable(true));
        // a marcação do item é feito a partir do momento que é colocada na smithing table
        // como isso vai ficar na NBT do item
        // a anvil não vai remover o efeito de arco-iro dele.
        result.set(ModDataComponents.RAINBOW_NAME.get(), net.minecraft.util.Unit.INSTANCE);
        return result;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return ItemStack.EMPTY;
    }

    // type

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ETERNAL_WOODY_SMITHING.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.SMITHING;
    }

    public static class Serializer implements RecipeSerializer<EternalWoodySmithingRecipe> {

        private static final MapCodec<EternalWoodySmithingRecipe> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(
                        Ingredient.CODEC.fieldOf("addition")
                                .forGetter(r -> r.addition)
                ).apply(inst, EternalWoodySmithingRecipe::new));

        private static final StreamCodec<RegistryFriendlyByteBuf, EternalWoodySmithingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, r -> r.addition,
                        EternalWoodySmithingRecipe::new
                );

        @Override
        public MapCodec<EternalWoodySmithingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, EternalWoodySmithingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
