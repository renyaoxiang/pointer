package com.pointer.base;

import com.pointer.util.Callback1;
import com.pointer.util.Function1;

public interface When<T> {
	Pointer<T> when(Function1<Boolean, Pointer<T>> state, Callback1<Pointer<T>> then);

	Pointer<T> when(Boolean state, Callback1<Pointer<T>> then);
}
