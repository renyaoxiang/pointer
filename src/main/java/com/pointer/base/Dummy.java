package com.pointer.base;

import java.util.Map;

public interface Dummy<T> {

	Map<String, Object> coloeDummies();

	Object getDummy(String key);

	Pointer<T> setDummy(String key, Object value);
}
