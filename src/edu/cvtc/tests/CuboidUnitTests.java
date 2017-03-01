package edu.cvtc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.cvtc.shapes.Cuboid;
import edu.cvtc.shapes.Dialog;
import edu.cvtc.shapes.NegativeNumberException;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class CuboidUnitTests {

	@Test
	public void test() {
		Dialog messageBox = new MessageBoxSub();
		Cuboid cube = new Cuboid(12, 13, 18, messageBox);
		
		cube.render();
		
		
	}
	
	/**
	 * Test method for {@link edu.cvtc.shapes.Cuboid#surfaceArea()}.
	 */
	@Test
	@junitparams.Parameters({
		"178, 23, 24",
		"103, 27, 2",
		"65, 28, 78",
		"5, 3, 7"
	})
	public void testSurfaceArea(float width, float height,  float depth) throws NegativeNumberException {
		
		if (width < 0 || height < 0 || depth < 0) {
			throw new NegativeNumberException("Numbers may not be negative");
		} else {
			// 1. Arrange
			Cuboid cube = new Cuboid(width, height, depth, null);
			float expected = (cube.getWidth() * cube.getDepth() + cube.getHeight() * cube.getDepth() + cube.getHeight() * cube.getWidth()) * 2.0f;
			
			// 2. Act
			float actual = cube.surfaceArea();
			
			// 3. Assert
			assertEquals(expected, actual, .001);
		}
	}
	
	@Test(expected = NegativeNumberException.class)
	@junitparams.Parameters({
		"-178, 23, -23",
		"103, -27, -5",
		"-65, -28, 78",
		"5, -3, 7"
	})
	public void testSurfaceAreaWithNegativeValues(float width, float height,  float depth) throws NegativeNumberException {
		
		if (width < 0 || height < 0 || depth < 0) {
			throw new NegativeNumberException("Numbers may not be negative");
		} else {
			// 1. Arrange
			Cuboid cube = new Cuboid(width, height, depth, null);
			float expected = (cube.getWidth() * cube.getDepth() + cube.getHeight() * cube.getDepth() + cube.getHeight() * cube.getWidth()) * 2.0f;
			
			// 2. Act
			float actual = cube.surfaceArea();
			
			// 3. Assert
			assertEquals(expected, actual, .0001);
		}
	}

	/**
	 * Test method for {@link edu.cvtc.shapes.Cuboid#volume()}.
	 */
	@Test
	@junitparams.Parameters({
		"20, 48, 23",
		"12, 834, 50",
		"2883, 230, 20",
		"82222, 28, 2409"
	})
	public void testVolume(float width, float height,  float depth) {
		
		// 1. Arrange
		Cuboid cube = new Cuboid(width, height, depth, null);
		float expected = cube.getWidth() * cube.getDepth() * cube.getHeight();
		
		// 2. Act
		float actual = cube.volume();
		
		// 3. Assert
		assertEquals(expected, actual, .0001);
	}


	@Test
	@junitparams.Parameters({
		"23, 38, 24",
		"2, 3, 3"
	})
	public void testCuboid(float width, float height,  float depth) {
		// 1. Arrange
		Cuboid cube = new Cuboid(width, height, depth, new MessageBoxSub());
		
		// 2. Act/Assert
		cube.render();
	}


}