package com.pointer.base;

public interface Action<T> {
	Pointer<T> action(Callback<Pointer<T>> callback);
 
}
