package ru.apache_maven.FirstJavaTask;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

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
    
    public void testWriteAndSort(String[] a){
    	ArrayList<String> asd, zxc;
    	
    	asd = ReadAndSortFile.writeInArrayAndSort(a[0]);
    	zxc = ReadAndSortFile.writeInArrayAndSort(a[1]);
    	
    	assertTrue( asd.size() == zxc.size() );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ReadAndSortTest .class );
    }

    
    public void testApp()
    {
        assertTrue( true );
    }
    
    public static void main(String[] args){
    	
    TestRunner runner = new TestRunner();
    TestSuite suite = new TestSuite();
    
    suite.addTest(new ReadAndSortTest("testWriteAndSort"));
    
    runner.doRun(suite);
    }
    
}
