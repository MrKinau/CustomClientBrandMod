package dev.kinau.customclientbrand.mixin;

import dev.kinau.customclientbrand.config.CCBConfig;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CustomPayloadC2SPacket.class)
public class CCBMixin {

	@Inject(method = "write(Lnet/minecraft/network/PacketByteBuf;)V", at = @At(value = "HEAD"), cancellable = true)
	public void changeClientBrand(PacketByteBuf buf, CallbackInfo ci) {
		if (((CustomPayloadC2SPacket)(Object)this).getChannel() == CustomPayloadC2SPacket.BRAND) {
			buf.writeIdentifier(CustomPayloadC2SPacket.BRAND);
			buf.writeString(AutoConfig.getConfigHolder(CCBConfig.class).get().customBrand());
			ci.cancel();
		}
	}
}
