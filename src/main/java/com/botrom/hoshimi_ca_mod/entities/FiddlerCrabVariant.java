package com.botrom.hoshimi_ca_mod.entities;

import net.minecraft.world.item.DyeColor;

import java.util.Arrays;
import java.util.Comparator;

public enum FiddlerCrabVariant {
    BLACK(0),
    BLUE(1),
    BROWN(2),
    CYAN(3),
    GRAY(4),
    GREEN(5),
    LIGHT_BLUE(6),
    LIGHT_GRAY(7),
    LIME(8),
    MAGENTA(9),
    ORANGE(10),
    PINK(11),
    PURPLE(12),
    RED(13),
    WHITE(14),
    YELLOW(15);

    private static final FiddlerCrabVariant[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(FiddlerCrabVariant::getId)).toArray(FiddlerCrabVariant[]::new);
    private final int id;

    FiddlerCrabVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static FiddlerCrabVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }

    public static FiddlerCrabVariant fromDyeColor(DyeColor color) {
        return switch (color) {
            case BLACK -> FiddlerCrabVariant.BLACK;
            case BLUE -> FiddlerCrabVariant.BLUE;
            case BROWN -> FiddlerCrabVariant.BROWN;
            case CYAN -> FiddlerCrabVariant.CYAN;
            case GRAY -> FiddlerCrabVariant.GRAY;
            case GREEN -> FiddlerCrabVariant.GREEN;
            case LIGHT_BLUE -> FiddlerCrabVariant.LIGHT_BLUE;
            case LIGHT_GRAY -> FiddlerCrabVariant.LIGHT_GRAY;
            case LIME -> FiddlerCrabVariant.LIME;
            case MAGENTA -> FiddlerCrabVariant.MAGENTA;
            case ORANGE -> FiddlerCrabVariant.ORANGE;
            case PINK -> FiddlerCrabVariant.PINK;
            case PURPLE -> FiddlerCrabVariant.PURPLE;
            case RED -> FiddlerCrabVariant.RED;
            case WHITE -> FiddlerCrabVariant.WHITE;
            case YELLOW -> FiddlerCrabVariant.YELLOW;
        };
    }

    public DyeColor getDyeColor() {
        return switch (this) {
            case BLACK -> DyeColor.BLACK;
            case BLUE -> DyeColor.BLUE;
            case BROWN -> DyeColor.BROWN;
            case CYAN -> DyeColor.CYAN;
            case GRAY -> DyeColor.GRAY;
            case GREEN -> DyeColor.GREEN;
            case LIGHT_BLUE -> DyeColor.LIGHT_BLUE;
            case LIGHT_GRAY -> DyeColor.LIGHT_GRAY;
            case LIME -> DyeColor.LIME;
            case MAGENTA -> DyeColor.MAGENTA;
            case ORANGE -> DyeColor.ORANGE;
            case PINK -> DyeColor.PINK;
            case PURPLE -> DyeColor.PURPLE;
            case RED -> DyeColor.RED;
            case WHITE -> DyeColor.WHITE;
            case YELLOW -> DyeColor.YELLOW;
        };
    }
}
