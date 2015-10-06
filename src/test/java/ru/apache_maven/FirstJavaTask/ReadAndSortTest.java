
package ru.apache_maven.FirstJavaTask;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ReadAndSortTest extends TestCase {

	/** Setting user directory. */
	String	userDirectory	= System.getProperty("user.dir");

	/** Created text file. */
	File	fileInUserDir	= new File(userDirectory + "/testOfClass_In.txt");

	public ReadAndSortTest(String testName) {

		super(testName);
	}

	/** Testing program in the directory on home computer. */
	public void testWriteAndSort() {

		ArrayList<String> asd, zxc;

		asd = ReadAndSortFile.writeInArrayAndSort("A:\\test_in.txt");
		zxc = ReadAndSortFile.writeInArrayAndSort("A:\\test_out.txt");

		assertTrue(asd.size() == zxc.size());
	}

	/** Testing program in the user directory. */
	public void testWriteAndSortAgain() {

		Random random = new Random();
		int numeral;

		try {

			/**
			 * Creating a text files in the user directory. In one of the files
			 * written random numbers
			 */
			BufferedWriter writeTextFile_Out = new BufferedWriter(
					new FileWriter(userDirectory + "/testOfClass_Out.txt"));
			BufferedWriter writeTextFile_In = new BufferedWriter(
					new FileWriter(userDirectory + "/testOfClass_In.txt"));

			for (int i = 0; i < 5; i++) {
				numeral = random.nextInt(25);
				writeTextFile_In.write(numeral);
			}

			ArrayList<String> outFile, inFile;

			outFile = ReadAndSortFile.writeInArrayAndSort(userDirectory
					+ "/testOfClass_Out.txt");
			inFile = ReadAndSortFile.writeInArrayAndSort(userDirectory
					+ "/testOfClass_In.txt");

			/** Compares the size of the two files. */
			assertTrue(outFile.size() == inFile.size());

			writeTextFile_Out.close();
			writeTextFile_In.close();
		} catch (IOException input) {
			System.out.println("Something is wrong");
		}
	}

	public static Test suite() {

		return new TestSuite(ReadAndSortTest.class);
	}

	public void testApp() {

		TestRunner runner = new TestRunner();
		TestSuite suite = new TestSuite();

		suite.addTest(new ReadAndSortTest("testWriteAndSort"));

		suite.addTest(new ReadAndSortTest("testWriteAndSortAgain"));

		runner.doRun(suite);
	}

}
