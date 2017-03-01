package edu.cvtc.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import edu.cvtc.shapes.Sphere;
import junitparams.JUnitParamsRunner;
import edu.cvtc.shapes.Dialog;
import edu.cvtc.shapes.NegativeNumberException;

/**
 * @author gcedarblade
 *
 */
@RunWith(JUnitParamsRunner.class)
public class SphereUnitTests {
	
	/**
	 * Test method for {@link edu.cvtc.shapes.Sphere#surfaceArea()}.
	 */
	@Test
	@junitparams.Parameters({
		"178",
		"103",
		"658",
		"53"
	})
	public void testSurfaceArea(float radius) throws NegativeNumberException {
		
		if (radius < 0) {
			throw new NegativeNumberException("Neither Radius may not be negative");
		} else {
			// 1. Arrange
			Sphere sphere = new Sphere(radius, null);
			float expected = 4.0f * (float)Math.PI * sphere.getRadius() * sphere.getRadius();
			
			// 2. Act
			float actual = sphere.surfaceArea();
			
			// 3. Assert
			assertEquals(expected, actual, .001f);
		}
	}
	
	@Test(expected = NegativeNumberException.class)
	@junitparams.Parameters({
		"-1783",
		"-27",
		"-65",
		"-3"
	})
	public void testSurfaceAreaWithNegativeValues(float radius) throws NegativeNumberException {
		
		if (radius < 0) {
			throw new NegativeNumberException("Neither Radius or Height may not be negative");
		} else {
			// 1. Arrange
			Sphere sphere = new Sphere(radius, null);
			float expected = 4.0f * (float)Math.PI * sphere.getRadius() * sphere.getRadius();
			
			// 2. Act
			float actual = sphere.surfaceArea();
			
			// 3. Assert
			assertEquals(expected, actual, .0001);
		}
	}

	/**
	 * Test method for {@link edu.cvtc.shapes.Sphere#volume()}.
	 */
	@Test
	@junitparams.Parameters({
		"20",
		"12834",
		"280",
		"828"
	})
	public void testVolume(float radius) {
		
		// 1. Arrange
		Sphere sphere = new Sphere(radius, null);
		float expected = 4.0f / 3.0f * (float)Math.PI * (sphere.getRadius() * sphere.getRadius() * sphere.getRadius());
		
		// 2. Act
		float actual = sphere.volume();
		
		// 3. Assert
		assertEquals(expected, actual, .001);
	}


	@Test
	@junitparams.Parameters({
		"23",
		"2"
	})
	public void testCylinder(float radius) {
		// 1. Arrange
		Sphere sphere = new Sphere(radius, new MessageBoxSub());
		
		// 2. Act/Assert
		sphere.render();
	}
	
	@Test
	public void testCylinderAgain() {
		Dialog messageBox = new MessageBoxSub();
		Sphere sphere = new Sphere(12, messageBox);
		
		sphere.render();
		
		
	}

}
