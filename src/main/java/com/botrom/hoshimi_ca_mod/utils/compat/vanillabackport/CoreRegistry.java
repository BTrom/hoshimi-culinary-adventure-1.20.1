package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class CoreRegistry<T> {
    protected final String modId;
    protected final Registry<T> registry;
    protected boolean isPresent = false;
    protected final Set<Supplier<T>> entries = new HashSet<>();

    // Constructor accepts the Registry directly
    protected CoreRegistry(Registry<T> registry, String modId) {
        this.modId = modId;
        this.registry = registry;
    }

    // 1. Fix the create method to return a functional instance
    public static <T> CoreRegistry<T> create(Registry<T> registry, String modId) {
        return new CoreRegistry<>(registry, modId);
    }

    // Unused in your current stack, but kept to prevent compilation errors
    public static <T> CoreRegistry<T> create(ResourceKey<? extends Registry<T>> key, String modId) {
        throw new UnsupportedOperationException("Use the Registry<T> create method instead.");
    }

    // 2. Implement the register method to actually register items
    public <E extends T> Supplier<E> register(String name, Supplier<E> entrySupplier) {
        ResourceLocation location = new ResourceLocation(this.modId, name);
        E entry = entrySupplier.get();

        // Directly register to the vanilla registry
        Registry.register(this.registry, location, entry);

        Supplier<E> ret = () -> entry;
        this.entries.add((Supplier<T>) ret);
        return ret;
    }

    public <E extends T> ResourceKey<T> resource(String name, Supplier<E> entry) {
        this.register(name, entry);
        return ResourceKey.create(this.key(), new ResourceLocation(this.modId, name));
    }

    public Collection<Supplier<T>> entries() {
        return Collections.unmodifiableSet(this.entries);
    }

    public ResourceKey<? extends Registry<T>> key() {
        return this.registry.key();
    }

    public Registry<T> registry() {
        return this.registry;
    }

    public String modId() {
        return this.modId;
    }

    public void register() {
        if (this.isPresent) {
            // Depending on strictness, you can throw an error or just return.
            // throw new IllegalArgumentException("Duplication of Registry: " + String.valueOf(this.key()));
        } else {
            this.isPresent = true;
            this.bootstrap();
        }
    }

    protected void bootstrap() {
        // No-op for this implementation
    }
}