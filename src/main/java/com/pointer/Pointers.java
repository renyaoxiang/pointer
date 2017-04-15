package com.pointer;

import com.pointer.base.ListenablePointer;
import com.pointer.base.Pointer;

public final class Pointers {
	public static final <T> Pointer<T> newPointer(T value) {
		return new DefaultPointer<T>().set(value);
	}

	public static final <T> Pointer<T> newPointer() {
		return new DefaultPointer<T>();
	}

	public static final <T> ListenablePointer<T> newListenablePointer(T value) {
		
		return new DefaultListenablePointer<T>(new DefaultPointer<T>().set(value),null) ;
	}

	public static final <T> ListenablePointer<T> newListenablePointer() {
		return new DefaultListenablePointer<T>(new DefaultPointer<T>(),null) ;
	}
}
