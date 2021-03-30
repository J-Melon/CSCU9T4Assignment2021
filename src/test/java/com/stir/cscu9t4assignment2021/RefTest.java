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

public class RefTest
{
	
	public RefTest()
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
	 * Test of getTitle method, of class Ref.
	 */
	@Test public void testGetTitle()
	{
		System.out.println("getTitle");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "Effects of cocaine on honey bee dance behaviour";
		String result = instance.getTitle();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getAuthors method, of class Ref.
	 */
	@Test public void testGetAuthors()
	{
		System.out.println("getAuthors");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "Andrew Barron, Maleszka Barron, ";
		String result = instance.getAuthors();
		assertEquals(expResult, result);
		
	}
	
	/**
	 * Test of getPubYear method, of class Ref.
	 */
	@Test public void testGetPubYear()
	{
		System.out.println("getPubYear");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "2009";
		String result = instance.getPubYear();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getPublisher method, of class Ref.
	 */
	@Test public void testGetPublisher()
	{
		System.out.println("getPublisher");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "Journal of Experimental Biology";
		String result = instance.getPublisher();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getDoi method, of class Ref.
	 */
	@Test public void testGetDoi()
	{
		System.out.println("getDoi");String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "10.1242/jeb.025361";
		String result = instance.getDoi();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getDateAdded method, of class Ref.
	 */
	@Test public void testGetDateAdded()
	{
		System.out.println("getDateAdded");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "25/03/2021";
		String result = instance.getDateAdded();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getCitation method, of class Ref.
	 */
	@Test public void testGetCitation()
	{
		System.out.println("getCitation");
		String[] authors = {"Andrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		Ref instance = new Ref("Effects of cocaine on honey bee dance behaviour", authors, "10.1242/jeb.025361",
				"Journal of Experimental Biology", 2009, dateAdded);
		String expResult = "Andrew Barron, Maleszka Barron, 2009. Effects of cocaine on honey bee dance behaviour. " +
				"Journal of Experimental Biology. DOI: 10.1242/jeb.025361. Accessed: 25/03/2021.";
		String result = instance.getCitation();
		assertEquals(expResult, result);
	}
}
