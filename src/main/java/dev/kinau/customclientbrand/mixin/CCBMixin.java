package dev.kinau.customclientbrand.mixin;

import dev.kinau.customclientbrand.config.CCBConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ServerboundCustomPayloadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerboundCustomPayloadPacket.class)
public class CCBMixin {

	@Inject(method = "write(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At(value = "HEAD"), cancellable = true)
	public void changeClientBrand(FriendlyByteBuf buf, CallbackInfo ci) {
		if (((ServerboundCustomPayloadPacket)(Object)this).getIdentifier() == ServerboundCustomPayloadPacket.BRAND) {
			String customBrand = AutoConfig.getConfigHolder(CCBConfig.class).get().customBrand();
			if (customBrand == null || customBrand.isEmpty()) return;
			buf.writeResourceLocation(ServerboundCustomPayloadPacket.BRAND);
			buf.writeUtf(customBrand);
			ci.cancel();
		}
	}
}
