package com.pointer.base;

public interface Pointer<T> extends Get<T>, Set<T>, Action<T>, When<T>, Dummy<T>, TryCatch<T>, Transform<Pointer<T>> {

}
