package com.pointer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.pointer.base.Pointer;
import com.pointer.util.Callback1;
import com.pointer.util.Callback2;
import com.pointer.util.Function1;

class DefaultPointer<T> implements Pointer<T> {
	protected T value;
	protected Map<String, Object> dummy = new ConcurrentHashMap<String, Object>();

	public DefaultPointer() {
		super();
	}

	public DefaultPointer(T value) {
		super();
		this.value = value;
	}

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
	public Pointer<T> action(Callback1<Pointer<T>> callback) {
		callback.apply(this);
		return this;
	}

	@Override
	public Pointer<T> when(Function1<Boolean, Pointer<T>> state, Callback1<Pointer<T>> then) {
		return this.when(state.apply(this), then);
	}

	@Override
	public Pointer<T> when(Boolean state, Callback1<Pointer<T>> then) {
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
	public Pointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError) {
		try {
			action.apply(this);

		} catch (Throwable e) {
			onError.apply(this, e);
		}
		return this;
	}

	@Override
	public <F> Pointer<F> map(Function1<F, Pointer<T>> callback) {
		return Pointers.create(callback.apply(this));
	}

	@Override
	public Pointer<T> tryCatch(Callback1<Pointer<T>> action, Callback1<Pointer<T>> onFinally) {
		try {
			action.apply(this);
		} finally {
			onFinally.apply(this);
		}
		return this;
	}

	@Override
	public Pointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError,
			Callback1<Pointer<T>> onFinally) {
		try {
			action.apply(this);
		} catch (Throwable e) {
			onError.apply(this, e);
		} finally {
			onFinally.apply(this);
		}
		return this;
	}

}
