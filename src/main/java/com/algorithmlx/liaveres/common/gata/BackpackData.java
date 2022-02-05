package com.algorithmlx.liaveres.common.gata;

import net.minecraft.sounds.SoundEvent;

public class BackpackData {
    private final String name;
    private final int rowWidth;
    private final int rows;
    private final boolean fireResistant;
    private final SoundEvent soundEvent;

    public BackpackData(String name, int rowWidth, int rows, boolean fireResistant, SoundEvent soundEvent) {
        this.name = name;
        this.rowWidth = rowWidth;
        this.rows = rows;
        this.fireResistant = fireResistant;
        this.soundEvent = soundEvent;
    }

    public String getName() {
        return this.name;
    }

    public int getRowWidth() {
        return this.rowWidth;
    }

    public int getRows() {
        return this.rows;
    }

    public boolean getFireResistant() {
        return this.fireResistant;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public static BackpackData of(String name, int rowWidth, int rows, boolean fireResistant, SoundEvent soundEvent) {
        return new BackpackData(name, rowWidth, rows, fireResistant, soundEvent);
    }
}
