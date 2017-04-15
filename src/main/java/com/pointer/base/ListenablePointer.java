package com.pointer.base;

import java.util.Map;

import com.pointer.util.Callback1;
import com.pointer.util.Callback2;
import com.pointer.util.Function1;

public interface ListenablePointer<T> extends Pointer<T> {
	ListenablePointer<T> setListener(PointerListener<T> listener);

	ListenablePointer<T> listenable(boolean flag);

	ListenablePointer<T> triggerEvent(Map<String, Object> event);

	@Override
	ListenablePointer<T> action(Callback1<Pointer<T>> callback);

	@Override
	ListenablePointer<T> when(Function1<Boolean, Pointer<T>> state, Callback1<Pointer<T>> then);

	@Override
	ListenablePointer<T> when(Boolean state, Callback1<Pointer<T>> then);

	@Override
	ListenablePointer<T> set(T value);

	@Override
	T get();

	@Override
	<F> ListenablePointer<F> map(Function1<F, Pointer<T>> callback);

	@Override
	ListenablePointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError,
			Callback1<Pointer<T>> onFinally);

	@Override
	ListenablePointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError);

	@Override
	ListenablePointer<T> tryCatch(Callback1<Pointer<T>> action, Callback1<Pointer<T>> onFinally);

	@Override
	Map<String, Object> coloeDummies();

	@Override
	Object getDummy(String key);

	@Override
	ListenablePointer<T> setDummy(String key, Object value);
}
