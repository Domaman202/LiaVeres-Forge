package com.algorithmlx.liaveres.common.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.logging.log4j.Level;

public class Config {
    public static final ForgeConfigSpec.Builder CONFIG_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec COMMON_CFG;

    static {
        CONFIG_BUILDER.push("LiaVeres Config");
    }

    public static final ForgeConfigSpec.IntValue pickaxeExcavationRadius =
            CONFIG_BUILDER
                    .comment("Lia Pickaxe excavation radius.",
                            "It working like this: ",
                            "16 + 1 = 17; 17 * 2 = 34; 34 - 2 = 32 - pickaxe excavation radius")
                    .defineInRange(
                    "pickaxeExcavationRadius",
                    16 + 1,
                    2 + 1,
                    64 + 1
                    );
    static {
        CONFIG_BUILDER.pop();
        COMMON_CFG = CONFIG_BUILDER.build();
    }
}
