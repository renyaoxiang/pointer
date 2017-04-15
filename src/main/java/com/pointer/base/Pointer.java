package com.pointer.base;

public interface Pointer<T> extends Getter<T>, Setter<T>, Action<T>, When<T>, Dummy<T>, TryCatch<T>, Mapper<Pointer<T>> {

}
