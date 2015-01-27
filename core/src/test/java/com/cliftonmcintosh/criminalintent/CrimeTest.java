package com.cliftonmcintosh.criminalintent;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import java.util.UUID;

/**
 * Crime Tester.
 *
 * @author <Authors Clifton McIntosh>
 * @version 1.0
 * @since <pre>Jan 26, 2015</pre>
 */
public class CrimeTest {

    Crime crime;

    @Before
    public void before() throws Exception {
        crime = new Crime();
    }

    /**
     * Method: getId()
     */
    @Test
    public void testGetId() throws Exception {
        UUID id = crime.getId();

        assertNotNull(id);
    }

    /**
     * Method: getTitle()
     */
    @Test
    public void testGetTitle() throws Exception {
        assertNull(crime.getTitle());

        String title = "title";
        crime.setTitle(title);

        assertNotNull(crime.getTitle());
        assertEquals(title, crime.getTitle());
    }

    /**
     * Method: setTitle(String title)
     */
    @Test
    public void testSetTitle() throws Exception {
        assertNull(crime.getTitle());

        String title = "title";
        crime.setTitle(title);

        assertNotNull(crime.getTitle());
        assertEquals(title, crime.getTitle());
    }


} 
