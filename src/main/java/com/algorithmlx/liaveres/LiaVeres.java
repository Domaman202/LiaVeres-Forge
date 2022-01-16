package com.algorithmlx.liaveres;

//import com.algorithmlx.algocore.registry.AlgoMod;
import com.algorithmlx.liaveres.setup.ClientSetup;
import com.algorithmlx.liaveres.setup.ModSetup;
import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LiaVeres.ModId)
@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LiaVeres /*implements AlgoMod*/ {
    public static final String ModId = "liaveres";
    public static final Logger LOGGER = LogManager.getLogger();

    public LiaVeres() {
        DistExecutor.safeRunWhenOn(Dist.CLIENT, ()-> ClientSetup::new);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.init();

        eventBus.addListener(ModSetup::init);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        Registration.BLOCK.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry()
                    .register(new BlockItem(block, new Item.Properties().tab(ModSetup.CLASSIC_TAB))
                            .setRegistryName(block.getRegistryName()));
        });
    }
}
