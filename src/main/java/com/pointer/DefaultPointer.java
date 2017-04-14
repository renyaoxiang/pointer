package com.pointer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.pointer.base.Callback;
import com.pointer.base.Callback2;
import com.pointer.base.Function;
import com.pointer.base.Pointer;

class DefaultPointer<T> implements Pointer<T> {
	protected T value;
	protected Map<String, Object> dummy = new ConcurrentHashMap<String, Object>();

	@Override
	public T get() {
		return value;
	}

	@Override
	public Pointer<T> set(T value) {
		this.value = value;
		return this;
	}

	@Override
	public Pointer<T> action(Callback<Pointer<T>> callback) {
		callback.apply(this);
		return this;
	}

	@Override
	public Pointer<T> when(Function<Pointer<T>, Boolean> state, Callback<Pointer<T>> then) {
		return this.when(state.apply(this), then);
	}

	@Override
	public Pointer<T> when(Boolean state, Callback<Pointer<T>> then) {
		if (state) {
			then.apply(this);
		}
		return this;
	}

	@Override
	public Map<String, Object> coloeDummies() {
		return new ConcurrentHashMap<>(this.dummy);
	}

	@Override
	public Object getDummy(String key) {
		return this.dummy.get(key);
	}

	@Override
	public Pointer<T> setDummy(String key, Object value) {
		this.dummy.put(key, value);
		return this;
	}

	@Override
	public Pointer<T> tryCatch(Callback<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError) {
		try {
			action.apply(this);

		} catch (Throwable e) {
			onError.apply(this, e);
		}
		return this;
	}

	@Override
	public <F> F transform(Function<Pointer<T>, F> callback) {
		return callback.apply(this);
	}

}
