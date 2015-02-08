package com.cliftonmcintosh.criminalintent;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

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
     * Method: getExternalId()
     */
    @Test
    public void testGetExternalId() throws Exception {
        String id = crime.getExternalId();

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
