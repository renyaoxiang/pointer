package com.pointer.base;

public interface Transform<T> {
	<F> F transform(Function<T, F> callback);
}
