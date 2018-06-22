package com.danoff.common.converter;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
public interface GenericObjectConverter<E, U> {

	E createFrom(U internalObject);

	default List<E> createFrom(Collection<U> internalObjects) {
		return Optional.ofNullable(internalObjects).map(Collection::stream).orElseGet(Stream::empty)
				.map(this::createFrom).collect(Collectors.toList());
	}
}
