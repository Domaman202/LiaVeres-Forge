package com.algorithmlx.liaveres.common.setup;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static final ForgeConfigSpec.Builder LIAVERES_CONFIG = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec CONFIG_COMMON;

    static {
        LIAVERES_CONFIG.push("LiaVeres Config");
    }

    public static final ForgeConfigSpec.ConfigValue<Boolean> commonModule = LIAVERES_CONFIG
            .comment("Enable All items and blocks from common module").define("commonModule", true);
    public static final ForgeConfigSpec.ConfigValue<Boolean> artifactModule = LIAVERES_CONFIG
            .comment("Enable All artifacts from artifact module").define("artifactModule", true);
    public static final ForgeConfigSpec.ConfigValue<Boolean> netheriteModule = LIAVERES_CONFIG
            .comment("Enable All netherite items from netherite module").define("netheriteModule", true);
    public static final ForgeConfigSpec.ConfigValue<Boolean> backpackModule = LIAVERES_CONFIG
            .comment("Enable All backpacks from backpack module").define("backpackModule", true);

    static {
        LIAVERES_CONFIG.pop();
        CONFIG_COMMON = LIAVERES_CONFIG.build();
    }
}
