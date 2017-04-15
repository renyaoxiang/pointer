package com.pointer;

import org.junit.Assert;
import org.junit.Test;

public class DefaultPointerTest {
	@Test
	public void testGet() {
		Assert.assertTrue(1 == Pointers.create(1).get());
		Assert.assertTrue("test" == Pointers.create("test").get());
		Assert.assertTrue(true == Pointers.create(true).get());
		Assert.assertTrue(false == Pointers.create(false).get());
		Assert.assertTrue(null == Pointers.create(null).get());
	}

	@Test
	public void testSet() {
		Assert.assertTrue(1 == Pointers.create(1).get());
		Assert.assertTrue("test1" == Pointers.create("test").set("test1").get());
		Assert.assertTrue(false == Pointers.create(true).set(false).get());
		Assert.assertTrue(true == Pointers.create(false).set(true).get());
		Assert.assertTrue(null != Pointers.create(null).set(new Object()).get());
	}
}
