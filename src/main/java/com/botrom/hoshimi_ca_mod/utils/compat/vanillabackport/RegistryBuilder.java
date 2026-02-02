package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class RegistryBuilder {
    protected final String modId;

    protected RegistryBuilder(String modId) {
        this.modId = modId;
    }

    public static RegistryBuilder create(String modId) {
        throw new AssertionError();
    }

    public <T> ResourceKey<Registry<T>> resource(String name) {
        return ResourceKey.createRegistryKey(new ResourceLocation(this.modId, name));
    }

    public abstract <T> Supplier<Registry<T>> registry(ResourceKey<Registry<T>> var1);

    public <T> RegistryReference<T> reference(String name) {
        Objects.requireNonNull(name, "Registry name cannot be null");
        ResourceKey<Registry<T>> resource = this.resource(name);
        return new RegistryReference(resource, this.registry(resource));
    }

    public static void bootstrap() {
    }

    public static record RegistryReference<T>(ResourceKey<Registry<T>> resource, Supplier<Registry<T>> registry) {
        public RegistryReference(ResourceKey<Registry<T>> resource, Supplier<Registry<T>> registry) {
            this.resource = resource;
            this.registry = registry;
        }

        public ResourceLocation location() {
            return this.resource.location();
        }

        public ResourceKey<Registry<T>> resource() {
            return this.resource;
        }

        public Supplier<Registry<T>> registry() {
            return this.registry;
        }
    }
}
