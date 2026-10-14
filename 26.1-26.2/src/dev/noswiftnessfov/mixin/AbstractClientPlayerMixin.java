/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.player.AbstractClientPlayer
 *  net.minecraft.core.Holder
 *  net.minecraft.world.effect.MobEffectInstance
 *  net.minecraft.world.effect.MobEffects
 *  net.minecraft.world.entity.ai.attributes.Attribute
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package dev.noswiftnessfov.mixin;

import dev.noswiftnessfov.SpeedFovMath;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attribute;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={AbstractClientPlayer.class})
abstract class AbstractClientPlayerMixin {
    AbstractClientPlayerMixin() {
    }

    @Redirect(method={"getFieldOfViewModifier"}, allow=1, at=@At(value="INVOKE", target="Lnet/minecraft/client/player/AbstractClientPlayer;getAttributeValue(Lnet/minecraft/core/Holder;)D"))
    private double noswiftnessfov$removeSwiftnessFromFov(AbstractClientPlayer player, Holder<Attribute> attribute) {
        double movementSpeed = player.getAttributeValue(attribute);
        MobEffectInstance swiftness = player.getEffect(MobEffects.SPEED);
        if (swiftness == null) {
            return movementSpeed;
        }
        return SpeedFovMath.removeSwiftnessModifier(movementSpeed, swiftness.getAmplifier());
    }
}

