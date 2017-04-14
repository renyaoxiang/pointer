package com.pointer.base;

public interface When<T> {
	Pointer<T> when(Function<Pointer<T>, Boolean> state, Callback<Pointer<T>> then);

	Pointer<T> when(Boolean state, Callback<Pointer<T>> then);
}
