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

/**
 * @author saemundur
 */
public class RefConferenceTest
{
	
	public RefConferenceTest()
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
	 * Test of getVenue method, of class RefConference.
	 */
	@Test public void testGetVenue()
	{
		System.out.println("getVenue");
		String[] authors = {"Eric Holgate", "Isabel Cachola"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefConference instance = new RefConference("Why swear? analyzing and inferring the intentions of vulgar expressions",
				authors, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2009, dateAdded, "EMNLP", "Brussels");
		String expResult = "EMNLP";
		String result = instance.getVenue();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getLocation method, of class RefConference.
	 */
	@Test public void testGetLocation()
	{
		System.out.println("getLocation");
		String[] authors = {"Eric Holgate", "Isabel Cachola"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefConference instance = new RefConference("Why swear? analyzing and inferring the intentions of vulgar expressions",
				authors, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2009, dateAdded, "EMNLP", "Brussels");
		String expResult = "Brussels";
		String result = instance.getLocation();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getCitation method, of class RefConference.
	 */
	@Test public void testGetCitation()
	{
		System.out.println("getCitation");
		String[] authors = {"Eric Holgate", "Isabel Cachola"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefConference instance = new RefConference("Why swear? analyzing and inferring the intentions of vulgar expressions",
				authors, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2018, dateAdded, "EMNLP", "Brussels");
		String expResult = "Eric Holgate, Isabel Cachola, 2018, " +
				"Why swear? analyzing and inferring the intentions of vulgar expressions, " +
				"Association for Computational Linguistics, EMNLP, Brussels, " +
				"DOI: https://www.aclweb.org/anthology/D18-1471.pdf, Accessed: " + "25/03/2021.\n";
		String result = instance.getCitation();
		assertEquals(expResult, result);
	}
}
