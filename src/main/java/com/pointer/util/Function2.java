package com.pointer.util;

@FunctionalInterface
public interface Function2<Result, Arg0, Arg1> {
	Result apply(Arg0 arg0 ,Arg1 arg1);
}
