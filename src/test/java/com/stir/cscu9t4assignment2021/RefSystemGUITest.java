/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import java.awt.event.ActionEvent;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author saemundur
 */
public class RefSystemGUITest
{
	
	public RefSystemGUITest()
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
	 * Test of main method, of class RefSystemGUI.
	 * Just tests if the GUI initiates without explicit fail
	 */
	@Test public void testMain()
	{
		System.out.println("main");
		String[] args = null;
		RefSystemGUI.main(args);
	}
	
//	/**
//	 * Test of actionPerformed method, of class RefSystemGUI.
//	 * You might want to add an action and a few more test cases with
//	 * different actions
//	 */
//	@Test public void testActionPerformed()
//	{
//		System.out.println("actionPerformed");
//		ActionEvent event = null;
//		RefSystemGUI instance = new RefSystemGUI();
//		instance.actionPerformed(event);
//	}
	
	@Test public void testAddCitationTitle()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal(null, "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Please enter a title.", result);
	}
	
	@Test public void testAddCitationAuthors()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", null,
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Please enter the author(s).", result);
		
		
	}
	
	@Test public void testAddCitationAuthorsNum()
	{
		RefSystemGUI instance = new RefSystemGUI();
		
		//Edge Case
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Adelardo Potočnik, " +
						"Artemon Bennet, Tumelo Neal, Loke Eckstein, Pyrrhus Queen, Romana Rios, Dušan Sýkora, Grier Constantin, Aodh Appelhof, " +
						"Alemayehu Lenz",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Citation added.", result);
		
		//Exception Case
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Adelardo Potočnik, " +
						"Artemon Bennet, Tumelo Neal, Loke Eckstein, Pyrrhus Queen, Romana Rios, Dušan Sýkora, Grier Constantin, Aodh Appelhof, " +
						"Alemayehu Lenz, Theodorus Heinrich",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		result = instance.addCitation();
		assertEquals("Please enter 10 or less authors separated by commas (,).", result);
	}
	
	@Test public void testAddCitationDOI()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				null, "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Please enter a DOI", result);
	}
	
	@Test public void testAddCitationPublisher()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", null, "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Please enter a publisher.", result);
	}
	
	@Test public void testAddCitationPubYear()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", null, "25",
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Please enter a number for publication year.", result);
	}
	
	@Test public void testAddCitationDateAdded()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", null,
				"3", "2021", "Journal of Experimental Biology", "212", "2");
		String result = instance.addCitation();
		assertEquals("Please enter a valid day, month, and year.", result);
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				null, "2021", "Journal of Experimental Biology", "212", "2");
		result = instance.addCitation();
		assertEquals("Please enter a valid day, month, and year.", result);
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", null,
				null, null, "Journal of Experimental Biology", "212", "2");
		result = instance.addCitation();
		assertEquals("Citation added.", result);
	}
	
	@Test public void testAddCitationVolumeIssue()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", null, "2");
		String result = instance.addCitation();
		assertEquals("Please enter a valid volume and issue or change reference types.", result);
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009", "25",
				"3", "2021", "Journal of Experimental Biology", "212", null);
		result = instance.addCitation();
		assertEquals("Please enter a valid volume and issue or change reference types.", result);
	}
	
	@Test public void testAddCitationVenue()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterConference("Why swear? analyzing and inferring the intentions of vulgar expressions",
				"Eric Holgate, Isabel Cachola", "https://www.aclweb.org/anthology/D18-1471.pdf",
				"Association for Computational Linguistics", "2018", "25", "3",
				"2021", null, "Brussels");
		String result = instance.addCitation();
		assertEquals("Please enter a venue.", result);
	}
	
	@Test public void testAddCitationLocation()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterConference("Why swear? analyzing and inferring the intentions of vulgar expressions",
				"Eric Holgate, Isabel Cachola", "https://www.aclweb.org/anthology/D18-1471.pdf",
				"Association for Computational Linguistics", "2018", "25", "3",
				"2021", "EMNLP", null);
		String result = instance.addCitation();
		assertEquals("Please enter a location.", result);
	}
	
	@Test public void testAddCitationBook()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterBookChapter("Becoming Sentient: Choreographies of Caring and Killing", "Marianne Lien",
				"https://doi.org/10.1525/9780520961838", "University of California Press", "2015",
				"25", "3", "2021", null, "Darra Goldstein");
		String result = instance.addCitation();
		assertEquals("Please enter a book title.", result);
	}
	
	@Test public void testAddCitationEditor()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterBookChapter("Becoming Sentient: Choreographies of Caring and Killing", "Marianne Lien",
				"https://doi.org/10.1525/9780520961838", "University of California Press", "2015",
				"25", "3", "2021", "Becoming salmon", null);
		String result = instance.addCitation();
		assertEquals("Please enter an editor.", result);
	}
	
	@Test public void testLookupByJournal()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine", "Andrew BarroZ, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021", "Journal of Experimental Biology",
				"212", "2");
		instance.addCitation();
		
		instance.enterJournal("Effects of bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021",
				"Journal of Experimental Biology", "212", "2");
		instance.addCitation();
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "AAdrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021",
				"Journal of Experimental Biology", "212", "2");
		instance.addCitation();
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "AAdrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021",
				"Journal of Unethical Biology", "212", "2");
		instance.addCitation();
		
		instance.enterJournal(null, null, null, null, null, null,
				null, null, "Journal of Experimental Biology", null, null);
		
		String expResult = "AAdrew Barron, Maleszka Barron, 2009, Effects of cocaine on honey bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew Barron, Maleszka Barron, 2009, Effects of bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew BarroZ, Maleszka Barron, 2009, Effects of cocaine, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n";
		String result = instance.lookupByJournal();
		assertEquals(expResult, result);
	}
	
	@Test public void testLookupByVenue()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterConference("Why?", "Eric HolgatZ, Isabel Cachola", "https://www.aclweb.org/anthology/D18-1471.pdf",
				"Association for Computational Linguistics", "2018",
				"25","3","2021", "EMNLP","Brussels");
				
		instance.addCitation();
		
		instance.enterConference("Why swear? analyzing and inferring the intentions of vulgar expressions", "Eric Holgate, Isabel Cachola", "https://www.aclweb.org/anthology/D18-1471.pdf",
				"Association for Computational Linguistics", "2018",
				"25","3","2021", "EMNLP","Brussels");
		instance.addCitation();
		
		instance.enterConference("Why swear? Yes!", "EAic Holgate, Isabel Cachola", "https://www.aclweb.org/anthology/D18-1471.pdf",
				"Association for Computational Linguistics", "2018",
				"25","3","2021", "EMNLP","Brussels");
		instance.addCitation();
		
		instance.enterConference("Why swear? Yes!", "EAic Holgate, Isabel Cachola", "https://www.aclweb.org/anthology/D18-1471.pdf",
				"Association for Computational Linguistics", "2018",
				"25","3","2021", "A Black Hole","Brussels");
		instance.addCitation();
		
		instance.enterConference(null, null, null, null, null, null,
				null, null, "EMNLP", null);
		
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
		String result = instance.lookupByVenue();
		assertEquals(expResult, result);
	}
	
	@Test public void testLookupByPublisher()
	{
		RefSystemGUI instance = new RefSystemGUI();
		instance.enterJournal("Effects of cocaine", "Andrew BarroZ, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021", "Journal of Experimental Biology",
				"212", "2");
		instance.addCitation();
		
		instance.enterJournal("Effects of bee dance behaviour", "Andrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021",
				"Journal of Experimental Biology", "212", "2");
		instance.addCitation();
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "AAdrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Biologists Ltd", "2009",
				"25", "3", "2021",
				"Journal of Experimental Biology", "212", "2");
		instance.addCitation();
		
		instance.enterJournal("Effects of cocaine on honey bee dance behaviour", "AAdrew Barron, Maleszka Barron",
				"10.1242/jeb.025361", "The Company of Angry Biologists Ltd", "2009",
				"25", "3", "2021",
				"Journal of Experimental Biology", "212", "2");
		instance.addCitation();
		
		instance.enterJournal(null, null, null, "The Company of Biologists Ltd",
				null, null, null, null, null, null, null);
		
		String expResult = "AAdrew Barron, Maleszka Barron, 2009, Effects of cocaine on honey bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew Barron, Maleszka Barron, 2009, Effects of bee dance behaviour, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n" +
				
				"Andrew BarroZ, Maleszka Barron, 2009, Effects of cocaine, " +
				"Journal of Experimental Biology, The Company of Biologists Ltd, vol. 212, no. 2, " +
				"DOI: 10.1242/jeb.025361, Accessed: 25/03/2021.\n";
		String result = instance.lookupByPublisher();
		assertEquals(expResult, result);
	}
}


