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
public class RefBookChapterTest
{
	
	public RefBookChapterTest()
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
	 * Test of getBook method, of class RefBookChapter.
	 */
	@Test public void testGetBook()
	{
		System.out.println("getBook");
		String[] authors = {"Marianne Lien"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefBookChapter instance = new RefBookChapter("Becoming Sentient: Choreographies of Caring and Killing",
				authors, "https://doi.org/10.1525/9780520961838", "University of California Press",
				2015, dateAdded, "Becoming salmon", "Darra Goldstein");
		String expResult = "Becoming salmon";
		String result = instance.getBook();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getEditor method, of class RefBookChapter.
	 */
	@Test public void testGetEditor()
	{
		System.out.println("getBook");
		String[] authors = {"Marianne Lien"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefBookChapter instance = new RefBookChapter("Becoming Sentient: Choreographies of Caring and Killing",
				authors, "https://doi.org/10.1525/9780520961838", "University of California Press",
				2015, dateAdded, "Becoming salmon", "Darra Goldstein");
		String expResult = "Darra Goldstein";
		String result = instance.getEditor();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getCitation method, of class RefBookChapter.
	 */
	@Test public void testGetCitation()
	{
		System.out.println("getCitation");
		String[] authors = {"Marianne Lien"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefBookChapter instance = new RefBookChapter("Becoming Sentient: Choreographies of Caring and Killing",
				authors, "https://doi.org/10.1525/9780520961838", "University of California Press",
				2015, dateAdded, "Becoming salmon", "Darra Goldstein");
		String expResult = "Marianne Lien, 2015, 'Becoming Sentient: Choreographies of Caring and Killing', " +
				"in Darra Goldstein (ed) Becoming " + "salmon, University of California Press, " +
				"DOI: https://doi.org/10.1525/9780520961838, Accessed: 25/03/2021.\n";
		String result = instance.getCitation();
		assertEquals(expResult, result);
	}
	
}
