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
	private JTextField JTitle = new JTextField(60);
	private JTextField JAuthors = new JTextField(30);
	private JTextField JPublisher = new JTextField(30);
	private JTextField JPubYear = new JTextField(4);
	private JTextField JDoi = new JTextField(55);
	private JTextField JDayAdded = new JTextField(2);
	private JTextField JMonthAdded = new JTextField(2);
	private JTextField JYearAdded = new JTextField(4);
	
	//Journal Fields
	private JTextField JJournal = new JTextField(30);
	private JTextField JVolume = new JTextField(3);
	private JTextField JIssue = new JTextField(3);
	
	//Conference Fields
	private JTextField JVenue = new JTextField(15);
	private JTextField JLocation = new JTextField(15);
	
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
	
	//Conference Fields
	private JLabel labVenue = new JLabel(" Venue:");
	private JLabel labLocation = new JLabel(" Location:");
	
	//Publication type dropdown list
	String[] pubTypes = new String[] {"Journal", "Conference", "Book"};
	JComboBox<String> refList = new JComboBox<>(pubTypes);
	private String refType = "";
	
	//Buttons
	private JButton addR = new JButton("Add");
	
	private JTextArea outputArea = new JTextArea(5, 70);
	
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
		add(refList);
		refList.addActionListener(this);
		refList.setSelectedItem("Journal");
		
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
		
		//BUTTONS
		add(addR);
		addR.addActionListener(this);
		
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 250);
		setVisible(true);
		blankDisplay();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String message = "";
		
		if (event.getSource() == addR)
		{
			message = addEntry();
		}
		
		if (event.getSource() == refList)
		{
			JComboBox<String> combo = (JComboBox<String>) event.getSource();
			refType = (String) combo.getSelectedItem();
			System.out.println(combo.getSelectedItem() + " is selected");
		}
		
		//setEditable
		switch (refType)
		{
			case "Journal":
				JJournal.setEditable(true);
				JVolume.setEditable(true);
				JIssue.setEditable(true);
				//Conference blank
				JVenue.setEditable(false);
				JLocation.setEditable(false);
				break;
			case "Conference":
				JVenue.setEditable(true);
				JLocation.setEditable(true);
				//Journal blank
				JJournal.setEditable(false);
				JVolume.setEditable(false);
				JIssue.setEditable(false);
				break;
			default:
				//Journal blank
				JJournal.setEditable(false);
				JVolume.setEditable(false);
				JIssue.setEditable(false);
				//Conference blank
				JVenue.setEditable(false);
				JLocation.setEditable(false);
				break;
		}
		
		outputArea.setText(message);
		blankDisplay();
	}
	
	public String addEntry()
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
		String[] authors = bibliography.parseAuthors(JAuthors.getText());
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
		
		Calendar dateAdded = bibliography.isValidDate(day, month, year);
		
		if (dateAdded == null) { return "Please enter a valid date."; }
		
		//-----RefJournal-----//
		String journal = JJournal.getText();
		
		if (journal.isBlank()) { return "Please enter a journal."; }
		
		int volume = 0;
		int issue = 0;
		
		try
		{
			volume = Integer.parseInt(JVolume.getText());
			issue = Integer.parseInt(JIssue.getText());
		}
		catch (NumberFormatException e)
		{
			return "Please enter a valid volume and issue or change reference types.";
		}
		
		//----- RefConference -----//
		String venue = JVenue.getText();
		String location = JLocation.getText();
		
		if (venue.isBlank()) { return "Please enter a venue."; }
		if (location.isBlank()) { return "Please enter a location.";}
		
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
			default:
				System.out.println("Something went wrong. Please try again.");
				r = new Ref(title, authors, doi, publisher, pubYear, dateAdded);
				break;
		}
		
		bibliography.addCitation(r);
		System.out.println(r.getCitation());
		return "Citation added.";
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
	}
}