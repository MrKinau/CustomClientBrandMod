package dev.kinau.customclientbrand.config;

import lombok.Getter;
import lombok.experimental.Accessors;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "customclientbrand")
@Accessors(fluent = true)
@Getter
public class CCBConfig implements ConfigData {

    private String customBrand;

}
