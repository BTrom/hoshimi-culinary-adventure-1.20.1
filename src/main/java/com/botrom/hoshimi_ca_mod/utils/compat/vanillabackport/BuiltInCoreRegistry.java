package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;

import java.util.*;

public class BuiltInCoreRegistry<T> {
    private final Map<ResourceLocation, T> hardcodedEntries = new HashMap();
    private final Map<ResourceLocation, T> dataDrivenEntries = new HashMap();
    private final String modId;
    private final Registry<T> registry;
    protected boolean isPresent = false;

    public BuiltInCoreRegistry(Registry<T> registry, String modId) {
        this.modId = modId;
        this.registry = registry;
        this.registry.keySet().forEach((id) -> {
            this.hardcodedEntries.putIfAbsent(id, this.registry.get(id));
        });
    }

    public T register(ResourceLocation name, T entry) {
        return this.hardcodedEntries.put(name, entry);
    }

    public T register(String name, T entry) {
        ResourceLocation location = new ResourceLocation(this.modId, name);
        return this.hardcodedEntries.put(location, entry);
    }

    public T registerDataDriven(ResourceLocation name, T entry) {
        return this.dataDrivenEntries.put(name, entry);
    }

    public <E extends T> ResourceKey<T> resource(String name, E entry) {
        this.register(name, entry);
        return ResourceKey.create(this.registry.key(), new ResourceLocation(this.modId, name));
    }

    public T getOrDefault(ResourceLocation name, T fallback) {
        if (this.registry.containsKey(name)) {
            return this.registry.get(name);
        } else if (this.dataDrivenEntries.containsKey(name)) {
            return this.dataDrivenEntries.get(name);
        } else {
            return this.hardcodedEntries.containsKey(name) ? this.hardcodedEntries.get(name) : fallback;
        }
    }

    public T get(ResourceLocation name) {
        return this.dataDrivenEntries.containsKey(name) ? this.dataDrivenEntries.get(name) : this.hardcodedEntries.get(name);
    }

    public T get(ResourceKey<T> name) {
        return this.getOrDefault(name.location(), (T) null);
    }

    public T getOrThrow(ResourceKey<T> key) {
        T value = this.get(key);
        if (value == null) {
            ResourceKey<?> resource = this.registry.key();
            String var10002 = String.valueOf(resource);
            throw new IllegalStateException("Missing key in " + var10002 + ":" + String.valueOf(key));
        } else {
            return value;
        }
    }

    public ResourceLocation getKey(T value) {
        Optional<ResourceLocation> dataDrivenKey = this.dataDrivenEntries.entrySet().stream().filter((entry) -> {
            return Objects.equals(entry.getValue(), value);
        }).findFirst().map(Map.Entry::getKey);
        return (ResourceLocation)dataDrivenKey.orElseGet(() -> {
            return (ResourceLocation)((Map.Entry)this.hardcodedEntries.entrySet().stream().filter((entry) -> {
                return Objects.equals(entry.getValue(), value);
            }).findFirst().orElseThrow(() -> {
                return new IllegalArgumentException("Value not found in registry: " + String.valueOf(value));
            })).getKey();
        });
    }

    public Optional<List<T>> fromTag(TagKey<T> tag) {
        List<T> values = this.getAllEntries().values().stream().filter((value) -> {
            return Holder.direct(value).is(tag);
        }).toList();
        return values.isEmpty() ? Optional.empty() : Optional.of(values);
    }

    public Optional<T> getRandomFromTag(TagKey<T> tag, RandomSource random) {
        return this.fromTag(tag).map((values) -> {
            return this.getRandomElement(values, random);
        });
    }

    public T getRandomElement(Collection<T> collection, RandomSource random) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random element from empty collection");
        } else if (collection instanceof List) {
            List<T> list = (List)collection;
            return list.get(random.nextInt(list.size()));
        } else {
            int index = random.nextInt(collection.size());
            Iterator<T> iterator = collection.iterator();

            for(int i = 0; i < index; ++i) {
                iterator.next();
            }

            return iterator.next();
        }
    }

    public T getRandomElement(RandomSource random) {
        Map<ResourceLocation, T> allEntries = this.getAllEntries();
        if (allEntries.isEmpty()) {
            throw new IllegalStateException("Registry is empty");
        } else {
            return this.getRandomElement(allEntries.values(), random);
        }
    }

    private Map<ResourceLocation, T> getAllEntries() {
        Map<ResourceLocation, T> combined = new HashMap(this.hardcodedEntries);
        combined.putAll(this.dataDrivenEntries);
        return combined;
    }

    public Collection<T> values() {
        return Collections.unmodifiableCollection(this.getAllEntries().values());
    }

    public Map<ResourceLocation, T> entries() {
        return Collections.unmodifiableMap(this.getAllEntries());
    }

    public void clearDataDrivenEntries() {
        this.dataDrivenEntries.clear();
    }

    public void register() {
        if (this.isPresent) {
            throw new IllegalStateException("Duplication of BuiltIn-Registry: " + String.valueOf(this.registry));
        } else {
            this.isPresent = true;
        }
    }
}
