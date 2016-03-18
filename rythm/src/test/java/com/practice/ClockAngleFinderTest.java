package com.practice;

import org.junit.Assert;
import org.junit.Test;

import com.practice.angle.ClockAngleFinder;

public class ClockAngleFinderTest {
	@Test
	public void validTest1() {
		ClockAngleFinder clock = new ClockAngleFinder();
		Assert.assertTrue(75 == clock.getTheAngle(3, 30, 0));

	}

	@Test
	public void validTest2() {
		ClockAngleFinder clock = new ClockAngleFinder();
		Assert.assertTrue(79 == clock.getTheAngle(3, 30, 45));

	}

	@Test
	public void validTest3() {
		ClockAngleFinder clock = new ClockAngleFinder();
		Assert.assertTrue(165 == clock.getTheAngle(12, 30, 0));

	}

}
