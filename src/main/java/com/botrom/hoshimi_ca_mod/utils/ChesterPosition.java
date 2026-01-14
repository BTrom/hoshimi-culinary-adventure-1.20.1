package com.botrom.hoshimi_ca_mod.utils;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class ChesterPosition implements INBTSerializable<CompoundTag> {
    private double posX;
    private double posY;
    private double posZ;
    private String dim;

    public ChesterPosition(double posX, double posY, double posZ, String dim) {
        this.setPosition(posX, posY, posZ, dim);
    }

    public ChesterPosition(CompoundTag tagCompoundIn) {
        this.deserializeNBT(tagCompoundIn);
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getPosZ() {
        return this.posZ;
    }

    public String getDim() {
        return this.dim;
    }

    public void setPosition(double posX, double posY, double posZ, String dim) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.dim = dim;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble("PosX", posX);
        nbt.putDouble("PosY", posY);
        nbt.putDouble("PosZ", posZ);
        nbt.putString("Dim", dim);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.posX = nbt.getDouble("PosX");
        this.posY = nbt.getDouble("PosY");
        this.posZ = nbt.getDouble("PosZ");
        this.dim = nbt.getString("Dim");
    }

    public String toString() {
        return "X: " + (int)this.posX + " / " + "Y: " + (int)this.posY + " / " + "Z: " + (int)this.posZ + " / " + "Dimension: " + this.dim.toUpperCase();
    }

    class NbtKey {
        public static final String POS_X = "PosX";
        public static final String POS_Y = "PosY";
        public static final String POS_Z = "PosZ";
        public static final String DIM = "Dim";

        NbtKey() {}
    }
}
