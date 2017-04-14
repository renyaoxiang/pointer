package com.pointer.base;

@FunctionalInterface
public interface Function<T, F> {
	F apply(T pointer);
}
