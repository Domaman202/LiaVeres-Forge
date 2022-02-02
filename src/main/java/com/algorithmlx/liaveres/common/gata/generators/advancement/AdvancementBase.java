package com.algorithmlx.liaveres.common.gata.generators.advancement;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.HashCache;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

@SuppressWarnings("deprecation")
public class AdvancementBase extends AdvancementProvider {
    private final Path generatorOutput;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public AdvancementBase(DataGenerator generatorIn) {
        super(generatorIn);
        this.generatorOutput = generatorIn.getOutputFolder();
    }

    @Override
    public void run(HashCache pCache) {
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancements -> {
           if (!set.add(advancements.getId())) {
               throw new IllegalStateException("Advancement is Dublicated: " + advancements.getId());
           } else {
               Path path = createPath(generatorOutput, advancements);

               try {
                   DataProvider.save(GSON, pCache, advancements.deconstruct().serializeToJson(), path);
               } catch (IOException exception) {
                   LiaVeres.LOGGER.error("Cannot save advancement: {}", path, exception);
               }
           }
        });
        new Advancements().accept(consumer);
    }

    private static Path createPath(Path pathIn, Advancement advancementIn) {
        return pathIn.resolve("data/" + LiaVeres.ModId + "/advancements/" + advancementIn.getId().getPath() + ".json");
    }

    public static void advancement(Advancement parent, ItemLike display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden, String modId) {
        Advancement.Builder.advancement().parent(parent).display(display,
                new TranslatableComponent("advancement." + modId + "." + name),
                new TranslatableComponent("advancement." + modId + "." + name + ".desc"),
                null, frame, showToast, announceToChat, hidden);
    }

    public static void advancement(Advancement parent, ItemStack display, String name, FrameType frame, boolean showToast, boolean announceToChat, boolean hidden, String modId) {
        Advancement.Builder.advancement().parent(parent).display(display,
                new TranslatableComponent("advancement." + modId + "." + name),
                new TranslatableComponent("advancement." + modId + "." + name + ".desc"),
                null, frame, showToast, announceToChat, hidden);
    }
}
