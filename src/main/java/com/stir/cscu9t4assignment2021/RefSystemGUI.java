/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

public class RefSystemGUI extends JFrame implements ActionListener
{
	//-----GUI DECLARATION-----//
	//OG Fields
	private JTextField JTitle = new JTextField(59);
	private JTextField JAuthors = new JTextField(30);
	private JTextField JPublisher = new JTextField(30);
	private JTextField JPubYear = new JTextField(4);
	private JTextField JDoi = new JTextField(55);
	private JTextField JDayAdded = new JTextField(2);
	private JTextField JMonthAdded = new JTextField(2);
	private JTextField JYearAdded = new JTextField(4);
	
	//Journal Fields
	private JTextField JJournal = new JTextField(31);
	private JTextField JVolume = new JTextField(3);
	private JTextField JIssue = new JTextField(3);
	
	//Conference Fields
	private JTextField JVenue = new JTextField(15);
	private JTextField JLocation = new JTextField(29);
	
	//Book Chapter Fields
	private JTextField JBook = new JTextField(15);
	private JTextField JEditor = new JTextField(50);
	
	//CSV
	private JTextField JCSVPath = new JTextField(30);
	
	//OG Labels
	private JLabel labTitle = new JLabel(" Title:");
	private JLabel labAuthors = new JLabel(" Authors:");
	private JLabel labPublisher = new JLabel(" Publisher:");
	private JLabel labPubYear = new JLabel(" Year Published:");
	private JLabel labDoi = new JLabel(" DOI:");
	private JLabel labDayAdded = new JLabel(" Day Added:");
	private JLabel labMonthAdded = new JLabel(" Month Added:");
	private JLabel labYearAdded = new JLabel(" Year Added:");
	
	//Journal Labels
	private JLabel labJournal = new JLabel(" Journal:");
	private JLabel labVolume = new JLabel(" Volume:");
	private JLabel labIssue = new JLabel(" Issue:");
	
	//Conference Labels
	private JLabel labVenue = new JLabel(" Venue:");
	private JLabel labLocation = new JLabel(" Location:");
	
	//Book Chapter Labels
	private JLabel labBook = new JLabel(" Book:");
	private JLabel labEditor = new JLabel(" Editor:");
	
	//CSV Label
	private JLabel labCSVPath = new JLabel(" CSV Path:");
	
	//Publication type dropdown list
	String[] pubTypes = new String[] {"Journal", "Conference", "Book Chapter"};
	JComboBox<String> JRefList = new JComboBox<>(pubTypes);
	private String refType = "";
	
	//Checkbox
	private JCheckBox JAllData = new JCheckBox("All reference types?");
	
	//Buttons
	private JButton addR = new JButton("Add");
	private JButton lookupR = new JButton("Lookup");
	private JButton importCSV = new JButton("Import CSV");
	
	public JTextArea outputArea = new JTextArea(26, 70);
	
	private RefCollection bibliography = new RefCollection();
	
	public static void main(String[] args)
	{
		RefSystemGUI applic = new RefSystemGUI();
	}
	
	public RefSystemGUI()
	{
		//Window
		super("Bibliography");
		setLayout(new FlowLayout());
		
		//-----GUI LAYOUT-----//
		//OG FIELDS
		//Publication type dropdown
		add(JRefList);
		JRefList.addActionListener(this);
		JRefList.setSelectedItem("Journal");
		
		//Title
		add(labTitle);
		add(JTitle);
		JTitle.setEditable(true);
		
		//Authors
		add(labAuthors);
		add(JAuthors);
		JAuthors.setEditable(true);
		
		//Publication
		add(labPublisher);
		add(JPublisher);
		JPublisher.setEditable(true);
		
		//Year Published
		add(labPubYear);
		add(JPubYear);
		JPubYear.setEditable(true);
		
		//DOI
		add(labDoi);
		add(JDoi);
		JDoi.setEditable(true);
		
		//Date Added
		add(labDayAdded);
		add(JDayAdded);
		JDayAdded.setEditable(true);
		add(labMonthAdded);
		add(JMonthAdded);
		JMonthAdded.setEditable(true);
		add(labYearAdded);
		add(JYearAdded);
		JYearAdded.setEditable(true);
		
		//JOURNAL FIELDS - DEFAULT
		//Journal
		add(labJournal);
		add(JJournal);
		JJournal.setEditable(true);
		
		//Volume
		add(labVolume);
		add(JVolume);
		JVolume.setEditable(true);
		
		//Issue
		add(labIssue);
		add(JIssue);
		JIssue.setEditable(true);
		
		//CONFERENCE FIELDS
		//Venue
		add(labVenue);
		add(JVenue);
		JVenue.setEditable(false);
		
		//Location
		add(labLocation);
		add(JLocation);
		JLocation.setEditable(false);
		
		//BOOK CHAPTER FIELDS
		//Book
		add(labBook);
		add(JBook);
		JBook.setEditable(false);
		
		//Editor
		add(labEditor);
		add(JEditor);
		JEditor.setEditable(false);
		
		//CSV
		add(labCSVPath);
		add(JCSVPath);
		JCSVPath.setEditable(true);
		
		//CHECK BOX
		add(JAllData);
		JAllData.addActionListener(this);
		
		//BUTTONS
		add(addR);
		addR.addActionListener(this);
		
		add(lookupR);
		lookupR.addActionListener(this);
		lookupR.setEnabled(false);
		
		add(importCSV);
		importCSV.addActionListener(this);
		
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 720);
		setVisible(true);
		blankDisplay();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String message = "";
		if ((event.getSource() == JAllData)) { return; }
		
		if (event.getSource() == addR) { message = addCitation(); }
		
		if (event.getSource() == JRefList)
		{
			JComboBox<String> combo = (JComboBox<String>) event.getSource();
			refType = (String) combo.getSelectedItem();
			
			switch (refType)
			{
				case "Journal":
					JJournal.setEditable(true);
					JVolume.setEditable(true);
					JIssue.setEditable(true);
					//Conference blank
					JVenue.setEditable(false);
					JLocation.setEditable(false);
					//BookChap blank
					JBook.setEditable(false);
					JEditor.setEditable(false);
					break;
				case "Conference":
					JVenue.setEditable(true);
					JLocation.setEditable(true);
					//Journal blank
					JJournal.setEditable(false);
					JVolume.setEditable(false);
					JIssue.setEditable(false);
					//BookChap blank
					JBook.setEditable(false);
					JEditor.setEditable(false);
					break;
				case "Book Chapter":
					JBook.setEditable(true);
					JEditor.setEditable(true);
					//Journal blank
					JJournal.setEditable(false);
					JVolume.setEditable(false);
					JIssue.setEditable(false);
					//Conference blank
					JVenue.setEditable(false);
					JLocation.setEditable(false);
				default:
					break;
			}
			
			return;
		}
		
		if (event.getSource() == lookupR)
		{
			switch (refType)
			{
				case "Journal":
					if (!JJournal.getText().isBlank()) { message = lookupByJournal(); }
					else { message = lookupByPublisher(); }
					break;
				case "Conference":
					if (!JVenue.getText().isBlank()) { message = lookupByVenue(); }
					else { message = lookupByPublisher(); }
					break;
				default: //Used by any type
					message = lookupByPublisher();
			}
		}
		
		if (event.getSource() == importCSV)
		{
			message = importCSV();
		}
		
		if (bibliography.getNumberOfRefs() >= 1)
		{
			lookupR.setEnabled(true);
		}
		
		outputArea.setText(message);
		blankDisplay();
	}
	
	public String addCitation()
	{
		String title = JTitle.getText();
		String publisher = JPublisher.getText();
		String doi = JDoi.getText();
		
		//VALIDATION
		//-----Default empty field-----//
		if (title.isBlank()) { return "Please enter a title."; }
		else if (publisher.isBlank()) { return "Please enter a publisher."; }
		else if (doi.isBlank()) { return "Please enter a DOI"; }
		
		//-----Publish year-----/
		int pubYear = 0;
		try { pubYear = Integer.parseInt(JPubYear.getText()); }
		catch (NumberFormatException e) { return "Please enter a number for publication year."; }
		if (! bibliography.isValidYear(pubYear)) { return "Please enter a valid year."; }
		
		//-----Author-----//
		String authorsStr = JAuthors.getText();
		if (authorsStr.isBlank()) { return "Please enter the author(s)."; }
		
		String[] authors = bibliography.parseAuthors(authorsStr);
		if (authors == null) { return "Please enter 10 or less authors separated by commas (,)."; }
		
		//-----Date Added-----/
		int day = 0;
		int month = 0;
		int year = 0;
		
		//If no date entered - use current date
		if (JDayAdded.getText().isBlank() && JMonthAdded.getText().isBlank() && JMonthAdded.getText().isBlank())
		{
			day = Calendar.getInstance().get(Calendar.DATE);
			month = Calendar.getInstance().get(Calendar.MONTH);
			year = Calendar.getInstance().get(Calendar.YEAR);
		}
		else
		{
			try
			{
				day = Integer.parseInt(JDayAdded.getText());
				month = Integer.parseInt(JMonthAdded.getText());
				year = Integer.parseInt(JYearAdded.getText());
			}
			catch (NumberFormatException e)
			{
				return "Please enter a valid day, month, and year.";
			}
		}
		
		Calendar dateAdded = bibliography.isValidDate(day, month - 1, year); //As Jan = 0
		
		if (dateAdded == null) { return "Please enter a valid date."; }
		
		//-----RefJournal-----//
		String journal = JJournal.getText();
		if (refType.equals("Journal")) { if (journal.isBlank()) { return "Please enter a journal."; } }
			
		int volume = 0;
		int issue = 0;
		
		if (refType.equals("Journal"))
		{
			try
			{
				volume = Integer.parseInt(JVolume.getText());
				issue = Integer.parseInt(JIssue.getText());
			}
			catch (NumberFormatException e)
			{
				return "Please enter a valid volume and issue or change reference types.";
			}
		}
		
		//----- RefConference -----//
		String venue = JVenue.getText();
		String location = JLocation.getText();
		
		if (refType.equals("Conference"))
		{
			if (venue.isBlank() && JVenue.isEnabled()) { return "Please enter a venue."; }
			if (location.isBlank()) { return "Please enter a location.";}
		}
		
		//----- RefBookChap -----//
		String book = JBook.getText();
		String editor = JEditor.getText();
		
		if (refType.equals("Book Chapter"))
		{
			if (book.isBlank()) { return "Please enter a book title."; }
			if (editor.isBlank()) { return "Please enter an editor.";}
		}
		
		//ADD TO COLLECTION
		Ref r;
		
		switch (refType)
		{
			case "Journal":
				r = new RefJournal(title, authors, doi, publisher, pubYear, dateAdded, journal, volume, issue);
				break;
			case "Conference":
				r = new RefConference(title, authors, doi, publisher, pubYear, dateAdded, venue, location);
				break;
			case "Book Chapter":
				r = new RefBookChapter(title, authors, doi, publisher, pubYear, dateAdded, book, editor);
				break;
			default:
				System.out.println("Something went wrong. Please try again.");
				r = new Ref(title, authors, doi, publisher, pubYear, dateAdded);
				break;
		}
		
		System.out.println(r.getCitation());
		
		bibliography.addCitation(r);
		return "Citation added.";
	}
	
	public String importCSV()
	{
		String path = JCSVPath.getText();
		if (path.isBlank()) { return "Please enter a path to import CSV file from."; }
		
		outputArea.setText("looking up record by journal ...");
		
		if (JAllData.isSelected())
		{
			return bibliography.importCSV(path, "all");
		}
		
		return bibliography.importCSV(path, refType);
	}
	
	public String lookupByJournal()
	{
		String journal = JJournal.getText();
		if (refType.equals("Journal")) { if (journal.isBlank()) { return "Please enter a journal."; } }
		
		outputArea.setText("looking up record by journal ...");
		String result = bibliography.lookupByJournal(journal);
		if (result.isBlank()) { return "No references found."; }
		return result;
	}
	
	public String lookupByVenue()
	{
		String venue = JVenue.getText();
		if (refType.equals("Conference")) { if (venue.isBlank()) { return "Please enter a venue."; } }
		
		outputArea.setText("looking up record by venue ...");
		String result = bibliography.lookupByVenue(venue);
		if (result.isBlank()) { return "No references found."; }
		return result;
	}
	
	public String lookupByPublisher()
	{
		String publisher = JPublisher.getText();
		if (publisher.isBlank()) { return "Please enter a publisher."; }
		
		outputArea.setText("looking up record by publisher ...");
		String result = bibliography.lookupByPublisher(publisher);
		if (result.isBlank()) { return "No references found."; }
		return result;
	}
	
	/** Blanks all fields in GUI */
	public void blankDisplay()
	{
		JTitle.setText("");
		JAuthors.setText("");
		JPublisher.setText("");
		JPubYear.setText("");
		JDoi.setText("");
		JDayAdded.setText("");
		JMonthAdded.setText("");
		JYearAdded.setText("");
		
		//RefJournal
		JJournal.setText("");
		JVolume.setText("");
		JIssue.setText("");
		
		//RefConference
		JVenue.setText("");
		JLocation.setText("");
		
		//RefBookChap
		JBook.setText("");
		JEditor.setText("");
		
		//CSV
		JCSVPath.setText("");
	}
	
	/** Enters text into GUI (Journal) for testing */
	public void enterJournal(String title, String authors, String doi, String publisher, String pubYear, String dayAdded,
							 String monthAdded, String yearAdded, String journal, String volume, String issue)
	{
		JRefList.setSelectedItem("Journal");
		JTitle.setText(title);
		JAuthors.setText(authors);
		JPublisher.setText(publisher);
		JPubYear.setText(pubYear);
		JDoi.setText(doi);
		JDayAdded.setText(dayAdded);
		JMonthAdded.setText(monthAdded);
		JYearAdded.setText(yearAdded);
		
		//RefJournal
		JJournal.setText(journal);
		JVolume.setText(volume);
		JIssue.setText(issue);
	}
	
	/** Enters text into GUI (Conference) for testing */
	public void enterConference(String title, String authors, String doi, String publisher, String pubYear, String dayAdded,
							 String monthAdded, String yearAdded, String venue, String location)
	{
		JRefList.setSelectedItem("Conference");
		JTitle.setText(title);
		JAuthors.setText(authors);
		JPublisher.setText(publisher);
		JPubYear.setText(pubYear);
		JDoi.setText(doi);
		JDayAdded.setText(dayAdded);
		JMonthAdded.setText(monthAdded);
		JYearAdded.setText(yearAdded);
		
		JVenue.setText(venue);
		JLocation.setText(location);
	}
	
	/** Enters text into GUI (Book Chapter) for testing */
	public void enterBookChapter(String title, String authors, String doi, String publisher, String pubYear, String dayAdded,
								String monthAdded, String yearAdded,String book, String editor)
	{
		JRefList.setSelectedItem("Book Chapter");
		JTitle.setText(title);
		JAuthors.setText(authors);
		JPublisher.setText(publisher);
		JPubYear.setText(pubYear);
		JDoi.setText(doi);
		JDayAdded.setText(dayAdded);
		JMonthAdded.setText(monthAdded);
		JYearAdded.setText(yearAdded);
		
		JBook.setText(book);
		JEditor.setText(editor);
	}
}