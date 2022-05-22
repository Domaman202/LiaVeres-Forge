package com.algorithmlx.liaveres.client.screen.book.page;

import com.algorithmlx.liaveres.common.LiaVeres;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;

public class LiaBookMainPage extends Screen {
    public LiaBookMainPage() {
        super(new TranslatableComponent("book." + LiaVeres.ModId + ".liaBook.main"));
    }
}
