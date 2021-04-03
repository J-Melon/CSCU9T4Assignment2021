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
		assertEquals(instance.getNumberOfRefs(), 3);
	}
	
	/**
	 * Test of lookupByJournal method, of class RefCollection.
	 */
	@Test public void testLookupByJournal()
	{
		System.out.println("lookupByJournal");
		String journal = "Journal of Experimental Biology";
		String[] authors1 = {"Andrew BarroZ", "Maleszka Barron"};
		String[] authors2 = {"Andrew Barron", "Maleszka Barron"};
		String[] authors3 = {"AAdrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefJournal ref1 = new RefJournal("Effects of cocaine", authors1,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref2 = new RefJournal("Effects of bee dance behaviour", authors2,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref3 = new RefJournal("Effects of cocaine on honey bee dance behaviour", authors3,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref4 = new RefJournal("Effects of milk on honey bee dance behaviour", authors2,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Faker", 212, 2);
		String expResult = "AAdrew Barron, Maleszka Barron, 2009, Effects of cocaine on honey bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew Barron, Maleszka Barron, 2009, Effects of bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
		
				"Andrew BarroZ, Maleszka Barron, 2009, Effects of cocaine, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n";
		RefCollection instance = new RefCollection();
		instance.addCitation(ref1);
		instance.addCitation(ref2);
		instance.addCitation(ref3);
		String result = instance.lookupByJournal(journal);
		assertEquals(expResult, result);
	}

	/**
	 * Test of loopUpByVenue method, of class RefCollection.
	 */
	@Test public void testLoopUpByVenue()
	{
		System.out.println("loopUpByVenue");
		String venue = "EMNLP";
		String[] authors1 = {"Eric HolgatZ", "Isabel Cachola"};
		String[] authors2 = {"Eric Holgate", "Isabel Cachola"};
		String[] authors3 = {"EAic Holgate", "Isabel Cachola"};
		Calendar dateAdded = Calendar.getInstance();;
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefConference ref1 = new RefConference("Why?",
				authors1, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2018, dateAdded, "EMNLP", "Brussels");
		RefConference ref2 = new RefConference("Why swear? analyzing and inferring the intentions of vulgar expressions",
				authors2, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2018, dateAdded, "EMNLP", "Brussels");
		RefConference ref3 = new RefConference("Why swear? Yes!",
				authors3, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2018, dateAdded, "EMNLP", "Brussels");
		RefConference ref4 = new RefConference("Why swear? Because you're worth it!",
				authors2, "https://www.aclweb.org/anthology/D18-1471.pdf", "Association for Computational Linguistics",
				2018, dateAdded, "Faker", "Brussels");
		String expResult = "EAic Holgate, Isabel Cachola, 2018, " +
				"Why swear? Yes!, " +
				"Association for Computational Linguistics, EMNLP, Brussels, " +
				"DOI: https://www.aclweb.org/anthology/D18-1471.pdf, Accessed: " + "25/03/2021.\n" +
				
				"Eric Holgate, Isabel Cachola, 2018, " +
				"Why swear? analyzing and inferring the intentions of vulgar expressions, " +
				"Association for Computational Linguistics, EMNLP, Brussels, " +
				"DOI: https://www.aclweb.org/anthology/D18-1471.pdf, Accessed: " + "25/03/2021.\n" +
				
				"Eric HolgatZ, Isabel Cachola, 2018, " +
				"Why?, " +
				"Association for Computational Linguistics, EMNLP, Brussels, " +
				"DOI: https://www.aclweb.org/anthology/D18-1471.pdf, Accessed: " + "25/03/2021.\n";
		RefCollection instance = new RefCollection();
		instance.addCitation(ref1);
		instance.addCitation(ref2);
		instance.addCitation(ref3);
		String result = instance.lookupByVenue(venue);
		assertEquals(expResult, result);
	}

	/**
	 * Test of lookUpByPublisher method, of class RefCollection.
	 */
	@Test public void testLookUpByPublisher()
	{
		System.out.println("lookUpByPublisher");
		String publisher = "The Company of Biologists Ltd";
		String[] authors1 = {"Andrew BarroZ", "Maleszka Barron"};
		String[] authors2 = {"Andrew Barron", "Maleszka Barron"};
		String[] authors3 = {"AAdrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();
		dateAdded.set(2021, Calendar.MARCH, 25);
		RefJournal ref1 = new RefJournal("Effects of cocaine", authors1,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref2 = new RefJournal("Effects of bee dance behaviour", authors2,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref3 = new RefJournal("Effects of cocaine on honey bee dance behaviour", authors3,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref4 = new RefJournal("Effects of milk on honey bee dance behaviour", authors2,
				"10.1242/jeb.025361", "Faker Inc.", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		String expResult = "AAdrew Barron, Maleszka Barron, 2009, Effects of cocaine on honey bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew Barron, Maleszka Barron, 2009, Effects of bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew BarroZ, Maleszka Barron, 2009, Effects of cocaine, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n";
		RefCollection instance = new RefCollection();
		instance.addCitation(ref1);
		instance.addCitation(ref2);
		instance.addCitation(ref3);
		String result = instance.lookupByPublisher(publisher);
		assertEquals(expResult, result);
	}

	/**
	 * Test of getNumberOfRefs method, of class RefCollection.
	 */
	@Test public void testGetNumberOfRefs()
	{
		System.out.println("getNumberOfRefs");
		String[] authors1 = {"Andrew BarroZ", "Maleszka Barron"};
		String[] authors2 = {"Andrew Barron", "Maleszka Barron"};
		String[] authors3 = {"AAdrew Barron", "Maleszka Barron"};
		Calendar dateAdded = Calendar.getInstance();
		RefJournal ref1 = new RefJournal("Effects of cocaine", authors1,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref2 = new RefJournal("Effects of bee dance behaviour", authors2,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref3 = new RefJournal("Effects of cocaine on honey bee dance behaviour", authors3,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefJournal ref4 = new RefJournal("Effects of milk on honey bee dance behaviour", authors2,
				"10.1242/jeb.025361", "Faker Inc.", 2009, dateAdded,
				"Journal of Experimental Biology", 212, 2);
		RefCollection instance = new RefCollection();
		instance.addCitation(ref1);
		instance.addCitation(ref2);
		instance.addCitation(ref3);
		instance.addCitation(ref4);
		int expResult = 4;
		int result = instance.getNumberOfRefs();
		assertEquals(expResult, result);
	}

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
