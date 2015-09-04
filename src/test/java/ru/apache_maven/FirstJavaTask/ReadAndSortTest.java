package ru.apache_maven.FirstJavaTask;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

public class ReadAndSortTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReadAndSortTest ( String testName )
    {
        super( testName );
    }
    
    public void testWriteAndSort(String[] args){
    	ArrayList<String> asd, zxc;
    	
    	asd = ReadAndSortFile.writeInArrayAndSort(args[0]);
    	zxc = ReadAndSortFile.writeInArrayAndSort(args[1]);
    	
    	assertTrue( asd.size() == zxc.size() );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReadAndSortTest .class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    
}
