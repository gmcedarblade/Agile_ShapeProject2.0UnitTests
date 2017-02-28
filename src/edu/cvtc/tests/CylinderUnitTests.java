package edu.cvtc.tests;

import edu.cvtc.shapes.*;
import junitparams.JUnitParamsRunner;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author gcedarblade
 *
 */

@RunWith(JUnitParamsRunner.class)
public class CylinderUnitTests {

	
	/**
	 * Test method for {@link edu.cvtc.shapes.Cylinder#surfaceArea()}.
	 */
	@Test
	@junitparams.Parameters({
		"178, 23",
		"103, 27",
		"65, 28",
		"5, 3"
	})
	public void testSurfaceArea(float radius, float height) throws NegativeNumberException {
		
		if (radius < 0 || height < 0) {
			throw new NegativeNumberException("Neither Radius or Height may not be negative");
		} else {
			// 1. Arrange
			Cylinder cylinder = new Cylinder(radius, height, null);
			int expected = (int) (2.0f * (float)Math.PI * cylinder.getRadius() * cylinder.getHeight() + 2.0f * (float)Math.PI * (cylinder.getRadius() * cylinder.getRadius()));
			
			// 2. Act
			int actual = (int) cylinder.surfaceArea();
			
			// 3. Assert
			assertEquals(expected, actual);
		}
	}
	
	@Test(expected = NegativeNumberException.class)
	@junitparams.Parameters({
		"-178, 23",
		"103, -27",
		"-65, -28",
		"5, -3"
	})
	public void testSurfaceAreaWithNegativeValues(float radius, float height) throws NegativeNumberException {
		
		if (radius < 0 || height < 0) {
			throw new NegativeNumberException("Neither Radius or Height may not be negative");
		} else {
			// 1. Arrange
			Cylinder cylinder = new Cylinder(radius, height, null);
			int expected = (int) (2.0f * (float)Math.PI * cylinder.getRadius() * cylinder.getHeight() + 2.0f * (float)Math.PI * (cylinder.getRadius() * cylinder.getRadius()));
			
			// 2. Act
			int actual = (int) cylinder.surfaceArea();
			
			// 3. Assert
			assertEquals(expected, actual);
		}
	}

	/**
	 * Test method for {@link edu.cvtc.shapes.Cylinder#volume()}.
	 */
	@Test
	@junitparams.Parameters({
		"20, 48",
		"12, 834",
		"2883, 230",
		"82222, 28"
	})
	public void testVolume(float radius, float height) {
		
		// 1. Arrange
		Cylinder cylinder = new Cylinder(radius, height, null);
		int expected = (int) ((cylinder.getRadius() * cylinder.getRadius()) * (float)Math.PI * cylinder.getHeight());
		
		// 2. Act
		int actual = (int) cylinder.volume();
		
		// 3. Assert
		assertEquals("They are equal", expected, actual);
	}


	@Test
	@junitparams.Parameters({
		"23, 38",
		"2, 3"
	})
	public void testCylinder(float radius, float height) {
		// 1. Arrange
		Cylinder cylinder = new Cylinder(radius, height, new MessageBoxSub());
		
		// 2. Act/Assert
		cylinder.render();
	}
	
	@Test
	public void testCylinderAgain() {
		Dialog messageBox = new MessageBoxSub();
		Cylinder cylinder = new Cylinder(12, 18, messageBox);
		
		cylinder.render();
		
		
	}

}