package com.pointer.base;

import com.pointer.util.Callback1;

public interface Action<T> {
	Pointer<T> action(Callback1<Pointer<T>> callback);

}
