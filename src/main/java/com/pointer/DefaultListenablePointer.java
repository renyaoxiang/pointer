package com.pointer;

import java.util.Map;

import com.pointer.base.ListenablePointer;
import com.pointer.base.Pointer;
import com.pointer.base.PointerListener;
import com.pointer.util.Callback1;
import com.pointer.util.Callback2;
import com.pointer.util.Function1;

class DefaultListenablePointer<T> implements ListenablePointer<T> {


	private boolean listenable = true;
	private PointerListener<T> listener = null;
	private Pointer<T> pointer;

	public DefaultListenablePointer(Pointer<T> pointer, PointerListener<T> listener) {
		super();
		this.pointer = pointer;
		this.listener = listener;
	}

	@Override
	public T get() {
		if (this.shouldQuiety()) {
			boolean temp = this.listenable;
			this.listenable = false;
			try {
				this.listener.onGet(() -> this.pointer.get());
			} finally {
				this.listenable = temp;
			}
		}
		return this.pointer.get();
	}

	private boolean shouldQuiety() {
		return this.listener == null || this.listenable == false;
	}

	@Override
	public ListenablePointer<T> set(T value) {

		if (this.shouldQuiety()) {
			this.pointer.set(value);
		} else {
			boolean temp = this.listenable;
			this.listenable = false;
			try {
				this.listener.onSet(value, newValue -> this.pointer.set(newValue));
			} finally {
				this.listenable = temp;
			}
		}
		return this;
	}

	@Override
	public ListenablePointer<T> action(Callback1<Pointer<T>> callback) {

		if (this.shouldQuiety()) {
			this.pointer.action(callback);
		} else {
			boolean temp = this.listenable;
			this.listenable = false;
			try {
				this.listener.onAction(callback, (newCallback) -> this.pointer.action(callback));
			} finally {
				this.listenable = temp;
			}
		}
		return this;
	}

	@Override
	public ListenablePointer<T> when(Function1<Boolean, Pointer<T>> state, Callback1<Pointer<T>> then) {
		if (state.apply(this)) {
			then.apply(this);
		}
		return this;

	}

	@Override
	public ListenablePointer<T> when(Boolean state, Callback1<Pointer<T>> then) {
		if (state) {
			then.apply(this);
		}
		return this;
	}

	@Override
	public Map<String, Object> coloeDummies() {

		return this.pointer.coloeDummies();
	}

	@Override
	public Object getDummy(String key) {
		return this.pointer.getDummy(key);
	}

	@Override
	public ListenablePointer<T> setDummy(String key, Object value) {
		this.pointer.setDummy(key, value);
		return this;
	}

	@Override
	public ListenablePointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError) {
		this.pointer.tryCatch(action, onError);
		return this;
	}

	@Override
	public <F> DefaultListenablePointer<F> map(Function1<F, Pointer<T>> callback) {
		Pointer<F> p = this.pointer.map(callback);
		return new DefaultListenablePointer<F>(p, null);
	}

	@Override
	public ListenablePointer<T> setListener(PointerListener<T> listener) {
		this.listener = listener;
		return this;
	}

	@Override
	public ListenablePointer<T> listenable(boolean flag) {
		this.listenable = flag;
		return this;
	}

	@Override
	public ListenablePointer<T> triggerEvent(Map<String, Object> eventContext) {

		if (!this.shouldQuiety()) {
			boolean temp = this.listenable;
			this.listenable = false;
			try {
				this.listener.onEvent(this, eventContext);
			} finally {
				this.listenable = temp;
			}
		}
		return this;
	}

	@Override
	public ListenablePointer<T> tryCatch(Callback1<Pointer<T>> action, Callback2<Pointer<T>, Throwable> onError,
			Callback1<Pointer<T>> onFinally) {
		this.tryCatch(action, onError, onFinally);
		return this;
	}

	@Override
	public ListenablePointer<T> tryCatch(Callback1<Pointer<T>> action, Callback1<Pointer<T>> onFinally) {
		this.tryCatch(action, onFinally);
		return this;
	}

}
