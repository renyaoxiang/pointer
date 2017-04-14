package com.pointer.base;

public interface TryCatch<T> {
	Pointer<T> tryCatch(Callback<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError);
}
