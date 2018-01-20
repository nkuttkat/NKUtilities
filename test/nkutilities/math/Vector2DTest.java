/*
 * Copyright (C) 2018 Nils Kuttkat<nkuttkat@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nkutilities.math;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nils Kuttkat<nkuttkat@gmail.com>
 */
public class Vector2DTest {
    
    public Vector2DTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setA method, of class Vector2D.
     */
    @Test
    public void testSetA() {
        System.out.println("setA");
        double a = 0.0;
        Vector2D instance = new Vector2D();
        instance.setA(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setB method, of class Vector2D.
     */
    @Test
    public void testSetB() {
        System.out.println("setB");
        double b = 0.0;
        Vector2D instance = new Vector2D();
        instance.setB(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getA method, of class Vector2D.
     */
    @Test
    public void testGetA() {
        System.out.println("getA");
        Vector2D instance = new Vector2D();
        double expResult = 0.0;
        double result = instance.getA();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getB method, of class Vector2D.
     */
    @Test
    public void testGetB() {
        System.out.println("getB");
        Vector2D instance = new Vector2D();
        double expResult = 0.0;
        double result = instance.getB();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Vector2D.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        double factor = 0.0;
        Vector2D instance = new Vector2D();
        instance.multiply(factor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Vector2D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Vector2D vector = null;
        Vector2D instance = new Vector2D();
        Vector2D expResult = null;
        Vector2D result = instance.add(vector);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
