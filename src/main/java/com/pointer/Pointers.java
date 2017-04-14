package com.pointer;

import com.pointer.base.Pointer;

public final class Pointers {
	public static final <T> Pointer<T> newPointer(T value) {
		return new DefaultPointer<T>().set(value);
	}

	public static final <T> Pointer<T> newPointer() {
		return new DefaultPointer<T>();
	}


}
