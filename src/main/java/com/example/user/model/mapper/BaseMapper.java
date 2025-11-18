package com.example.user.model.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public abstract class BaseMapper <E, D> {

    public abstract E convertToEntity(D dto, Object... args);
    public abstract D convertToDto(E entity, Object... args);

    // Core conversion methods
    public List<E> convertToEntity(Collection<D> dtos, Object... args) {
        return dtos
                .stream()
                .map(dto -> convertToEntity(dto, args))
                .collect(toList());
    }

    public List<D> convertToDto(Collection<E> entities, Object... args) {
        return entities
                .stream()
                .map(entity -> convertToDto(entity, args))
                .collect(toList());
    }

    // Set conversions
    public Set<E> convertToEntitySet(Collection<D> dtos, Object... args) {
        return dtos
                .stream()
                .map(dto -> convertToEntity(dto, args))
                .collect(toSet());
    }

    public Set<D> convertToDtoSet(Collection<E> entities, Object... args) {
        return entities
                .stream()
                .map(entity -> convertToDto(entity, args))
                .collect(toSet());
    }
}
