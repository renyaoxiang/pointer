package com.pointer.base;

import com.pointer.util.Callback1;
import com.pointer.util.Callback2;

public interface TryCatch<T> {
	Pointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError,
			Callback1<Pointer<T>> onFinally);

	Pointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError);

	Pointer<T> tryCatch(Callback1<Pointer<T>> action, Callback1<Pointer<T>> onFinally);
}
