package com.pointer;

import org.junit.Assert;
import org.junit.Test;

import com.pointer.Pointers;

public class DefaultPointerTest {
	@Test
	public void testGet() {
		Assert.assertTrue(1 == Pointers.newPointer(1).get());
		Assert.assertTrue("test" == Pointers.newPointer("test").get());
		Assert.assertTrue(true == Pointers.newPointer(true).get());
		Assert.assertTrue(false == Pointers.newPointer(false).get());
		Assert.assertTrue(null == Pointers.newPointer(null).get());
	}

	@Test
	public void testSet() {
		Assert.assertTrue(1 == Pointers.newPointer(1).get());
		Assert.assertTrue("test1" == Pointers.newPointer("test").set("test1").get());
		Assert.assertTrue(false == Pointers.newPointer(true).set(false).get());
		Assert.assertTrue(true == Pointers.newPointer(false).set(true).get());
		Assert.assertTrue(null != Pointers.newPointer(null).set(new Object()).get());
	}
}
