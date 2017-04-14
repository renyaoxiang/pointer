package com.pointer.base;

@FunctionalInterface
public interface Callback<T> {
	void apply(T p);
}
