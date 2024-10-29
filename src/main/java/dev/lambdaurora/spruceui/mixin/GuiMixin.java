package dev.lambdaurora.spruceui.mixin;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {
    @Inject(method="render", at=@At("TAIL"))
    private void onRender(GuiGraphics arg, DeltaTracker arg2, CallbackInfo ci) {
        HudManager.hudRenderCallback(arg, arg2);
    }
}
