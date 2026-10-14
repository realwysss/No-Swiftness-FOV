/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1320
 *  net.minecraft.class_6880
 *  net.minecraft.class_742
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package dev.noswiftnessfov.mixin;

import dev.noswiftnessfov.SpeedFovMath;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1320;
import net.minecraft.class_6880;
import net.minecraft.class_742;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_742.class})
abstract class AbstractClientPlayerEntityMixin {
    AbstractClientPlayerEntityMixin() {
    }

    @Redirect(method={"method_3118"}, allow=1, at=@At(value="INVOKE", target="Lnet/minecraft/class_742;method_45325(Lnet/minecraft/class_6880;)D"))
    private double noswiftnessfov$removeSwiftnessFromFov(class_742 player, class_6880<class_1320> attribute) {
        double movementSpeed = player.method_45325(attribute);
        class_1293 swiftness = player.method_6112(class_1294.field_5904);
        if (swiftness == null) {
            return movementSpeed;
        }
        return SpeedFovMath.removeSwiftnessModifier(movementSpeed, swiftness.method_5578());
    }
}

