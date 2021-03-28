/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author saemundur
 */
public class RefSystemGUI extends JFrame implements ActionListener
{
	//-----GUI DECLARATION-----//
	//Fields
	private JTextField JTitle = new JTextField(30);
	private JTextField JAuthors = new JTextField(30);
	private JTextField JPublisher = new JTextField(30);
	private JTextField JPubYear = new JTextField(30);
	private JTextField JDoi = new JTextField(30);
	private JTextField JDateAdded = new JTextField(30);
	
	//Labels
	private JLabel labTitle = new JLabel(" Title:");
	private JLabel labAuthors = new JLabel(" Authors:");
	private JLabel labPublisher = new JLabel(" Publisher:");
	private JLabel labPubYear = new JLabel(" Year Published:");
	private JLabel labDoi = new JLabel(" DOI:");
	private JLabel labDateAdded = new JLabel(" Date Added:");
	
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
		//Window title
		super("Bibliography");
		setLayout(new FlowLayout());
		
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
		add(labDateAdded);
		add(JDateAdded);
		JDateAdded.setEditable(true);
		
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
	}
	
	public String addEntry()
	{
		String message;
		
		String title = JTitle.getText();
		
		//List of authors
		
		String publisher = JPublisher.getText();
		
		//Year of publication
		
		String doi = JDoi.getText();
		
		//Date added
		
		//DEFAULT EMPTY FIELD VALIDATION
		if (title.isEmpty())
		{
			return "Please enter a title.";
		}
		else if (publisher.isEmpty())
		{
			return "Please enter a publisher.";
		}
		else if (doi.isEmpty())
		{
			return "Please enter a DOI";
		}
		
		return ""; //TODO CHANGE THIS
		
	}
	
	/** Blanks all fields in GUI */
	public void blankDisplay()
	{
		JTitle.setText("");
		JAuthors.setText("");
		JPublisher.setText("");
		JPubYear.setText("");
		JDoi.setText("");
		JDateAdded.setText("");
	}
}