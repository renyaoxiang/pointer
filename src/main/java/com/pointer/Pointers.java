package com.pointer;

import com.pointer.base.ListenablePointer;
import com.pointer.base.Pointer;

public final class Pointers {
	public static final <T> Pointer<T> create(T value) {
		return new DefaultPointer<T>().set(value);
	}

	public static final <T> Pointer<T> create() {
		return new DefaultPointer<T>();
	}

	public static final <T> ListenablePointer<T> listenable(T value) {
		
		return new DefaultListenablePointer<T>(new DefaultPointer<T>(value) ,null) ;
	}

	public static final <T> ListenablePointer<T> listenable() {
		return new DefaultListenablePointer<T>(new DefaultPointer<T>(),null) ;
	}
	public static final <T> ListenablePointer<T> listenable(Pointer<T> pointer) {
		assert(pointer!=null);
		return new DefaultListenablePointer<T>(pointer,null) ;
	}
}
