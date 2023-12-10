package dev.kinau.customclientbrand;

import dev.kinau.customclientbrand.config.CCBConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomClientBrand implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("customclientbrand");

	@Override
	public void onInitialize() {
		AutoConfig.register(CCBConfig.class, GsonConfigSerializer::new);
	}
}
