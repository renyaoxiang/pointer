package com.pointer.base;

import com.pointer.util.Function1;

public interface Mapper<T> {
	<F> Pointer<F> map(Function1<F, T> callback);
}
