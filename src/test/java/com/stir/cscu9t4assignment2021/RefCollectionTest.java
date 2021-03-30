/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

public class RefCollectionTest
{
	public RefCollectionTest()
	{
	}
	
	@BeforeAll public static void setUpClass()
	{
	}
	
	@AfterAll public static void tearDownClass()
	{
	}
	
	@BeforeEach public void setUp()
	{
	}
	
	@AfterEach public void tearDown()
	{
	}
	
	/**
	 * Test of addCite method, of class RefCollection.
	 */
	@Test public void testAddCite()
	{
		System.out.println("addCite");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref ref1 = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"The Company of Biologists Ltd", 2009, dateAdded);
		Ref ref2 = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1243/jeb.025361",
				"The Company of Biologists Ltd", 2009, dateAdded);
		Ref ref3 = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1244/jeb.025361",
				"The Company of Biologists Ltd", 2009, dateAdded);
		RefCollection instance = new RefCollection();
		instance.addCitation(ref1);
		instance.addCitation(ref2);
		instance.addCitation(ref3);
		assertEquals(instance.getNumberOfEntries(), 3);
	}
	
//	/**
//	 * Test of lookUpByJournal method, of class RefCollection.
//	 */
//	@Test public void testLookUpByJournal()
//	{
//		System.out.println("lookUpByJournal");
//		String journal = "";
//		RefCollection instance = new RefCollection();
//		String expResult = "";
//		String result = instance.lookUpByJournal(journal);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of loopUpByVenue method, of class RefCollection.
//	 */
//	@Test public void testLoopUpByVenue()
//	{
//		System.out.println("loopUpByVenue");
//		String venue = "";
//		RefCollection instance = new RefCollection();
//		String expResult = "";
//		String result = instance.loopUpByVenue(venue);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of lookUpByPublisher method, of class RefCollection.
//	 */
//	@Test public void testLookUpByPublisher()
//	{
//		System.out.println("lookUpByPublisher");
//		String publisher = "";
//		RefCollection instance = new RefCollection();
//		String expResult = "";
//		String result = instance.lookUpByPublisher(publisher);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of getNumberOfRefs method, of class RefCollection.
//	 */
//	@Test public void testGetNumberOfRefs()
//	{
//		System.out.println("getNumberOfRefs");
//		String type = "";
//		RefCollection instance = new RefCollection();
//		int expResult = 0;
//		int result = instance.getNumberOfRefs(type);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of exportAll method, of class RefCollection.
//	 */
//	@Test public void testExportAll()
//	{
//		System.out.println("exportAll");
//		RefCollection instance = new RefCollection();
//		String expResult = "";
//		String result = instance.exportAll();
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
//
//	/**
//	 * Test of importMany method, of class RefCollection.
//	 */
//	@Test public void testImportMany()
//	{
//		System.out.println("importMany");
//		String filePath = "";
//		RefCollection instance = new RefCollection();
//		String expResult = "";
//		String result = instance.importMany(filePath);
//		assertEquals(expResult, result);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
}
