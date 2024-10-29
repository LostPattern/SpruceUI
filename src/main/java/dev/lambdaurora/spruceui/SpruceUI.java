package dev.lambdaurora.spruceui;

import dev.lambdaurora.spruceui.hud.HudManager;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.io.ResourceReloader;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;

@Mod(value = "spruceui", dist = Dist.CLIENT)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class SpruceUI {
    @SubscribeEvent
    public static void setup(RegisterClientReloadListenersEvent event) {
        HudManager.initialize();
    }

    @EventBusSubscriber
    public static class Event2 {
        @SubscribeEvent
        public static void clientTick(ClientTickEvent.Post event) {
            HudManager.endClientTick(Minecraft.getInstance());
        }
    }
}
