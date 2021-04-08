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

public class RefJournalTest
{
	
	public RefJournalTest()
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
	 * Test of getJournal method, of class RefJournal.
	 */
	@Test public void testGetJournal()
	{
		System.out.println("getJournal");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefJournal instance = new RefJournal("Effects of cocaine on honey bee dance behaviour", authors,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		String expResult = "Journal of Experimental Biology";
		String result = instance.getJournal();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getCitation method, of class RefJournal.
	 */
	@Test public void testGetCitation()
	{
		System.out.println("getCitation");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefJournal instance = new RefJournal("Effects of cocaine on honey bee dance behaviour", authors,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		String expResult = "Andrew Barron, Maleszka Barron, 2009, Effects of cocaine on honey bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n";
		String result = instance.getCitation();
		assertEquals(expResult, result);
	}
	
}
