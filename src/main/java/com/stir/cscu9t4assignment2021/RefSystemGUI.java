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
	//Fields
	private JTextField JTitle = new JTextField(60);
	private JTextField JAuthors = new JTextField(30);
	private JTextField JPublisher = new JTextField(30);
	private JTextField JPubYear = new JTextField(4);
	private JTextField JDoi = new JTextField(55);
	private JTextField JDayAdded = new JTextField(2);
	private JTextField JMonthAdded = new JTextField(2);
	private JTextField JYearAdded = new JTextField(4);
	
	
	//Labels
	private JLabel labTitle = new JLabel(" Title:");
	private JLabel labAuthors = new JLabel(" Authors:");
	private JLabel labPublisher = new JLabel(" Publisher:");
	private JLabel labPubYear = new JLabel(" Year Published:");
	private JLabel labDoi = new JLabel(" DOI:");
	private JLabel labDayAdded = new JLabel(" Day Added:");
	private JLabel labMonthAdded = new JLabel(" Month Added:");
	private JLabel labYearAdded = new JLabel(" Year Added:");
	
	//Publication type dropdown list
	String[] pubTypes = new String[] {"Journal", "Conference", "Book"};
	JComboBox<String> pubTypeList = new JComboBox<>(pubTypes);
	private String pubType = "";
	
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
		//setPreferredSize(100);
		
		//-----GUI LAYOUT-----//
		//FIELDS
		//Publication type dropdown
		add(pubTypeList);
		pubTypeList.addActionListener(this);
		pubTypeList.setSelectedItem("Journal");
		
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
		
		outputArea.setText(message);
		blankDisplay();
	}
	
	public String addEntry()
	{
		String message;
		
		String title = JTitle.getText();
		String publisher = JPublisher.getText();
		String doi = JDoi.getText();
		
		//VALIDATION
		//Default empty field
		if (title.isBlank()) { return "Please enter a title."; }
		else if (publisher.isBlank()) { return "Please enter a publisher."; }
		else if (doi.isBlank()) { return "Please enter a DOI"; }
		
		//Publish year
		int pubYear = 0;
		try { pubYear = Integer.parseInt(JPubYear.getText()); }
		catch (NumberFormatException e) { return "Please enter a number for publication year."; }
		if (! bibliography.isValidYear(pubYear)) { return "Please enter a valid year."; }
		
		//Author
		String[] authors = bibliography.parseAuthors(JAuthors.getText());
		if (authors == null) { return "Please enter 10 or less authors separated by commas (,)."; }
		
		//Date Added
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
			return "Please enter a number for the day, month, and year.";
		}
		
		Calendar dateAdded = bibliography.isValidDate(day, month, year);
		
		if (dateAdded == null) { return "Please enter a valid date"; }
		
		//ADD TO COLLECTION
		Ref r;
		r = new Ref(title, authors, doi, publisher, pubYear, dateAdded);
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
	}
}