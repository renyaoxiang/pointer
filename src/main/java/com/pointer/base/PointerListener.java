package com.pointer.base;

import java.util.Map;

import com.pointer.util.Callback1;
import com.pointer.util.Function;
import com.pointer.util.Function1;

public interface PointerListener<T> {

	void onGet(Function<T> next);

	void onSet(T value, Function1<Pointer<T>, T> next);

	void onAction(Callback1<Pointer<T>> value, Function1<Pointer<T>, Callback1<Pointer<T>>> next);

	void onEvent(Pointer<T> pointer, Map<String, Object> eventContext);
}
