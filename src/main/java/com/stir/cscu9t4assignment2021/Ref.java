package com.stir.cscu9t4assignment2021;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ref
{
	private String title;
	private String[] authors;
	private String doi;
	private String publisher;
	private int pubYear;
	private Calendar dateAdded;
	
	/**
	 * Constructor
	 * @param title title of article
	 * @param authors list of authors
	 * @param doi Digital Object Identifier
	 * @param publisher name of publisher
	 * @param pubYear year of publication
	 * @param dateAdded date in which citation was added to system
	 */
	public Ref(String title, String[] authors, String doi, String publisher, int pubYear, Calendar dateAdded)
	{
		this.title = title;
		this.authors = authors;
		this.doi = doi;
		this.publisher = publisher;
		this.pubYear = pubYear;
		this.dateAdded = dateAdded;
	}
	
	/** @return title of article */
	public String getTitle()
	{
		return title;
	}
	
	/** @return list of authors */
	public String getAuthors()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < authors.length - 1; i++)
		{
			sb.append(authors[i]).append(", ");
		}
		
		return sb.toString();
	}
	
	/** @return name of publisher */
	public String getPublisher()
	{
		return publisher;
	}
	
	/** @return year of publication */
	public String getPubYear()
	{
		return String.valueOf(pubYear);
	}
	
	/** @return Digital Object Identifier */
	public String getDoi()
	{
		return doi;
	}
	
	/** @return date in which citation was added to system */
	public String getDateAdded()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(dateAdded);
	}
	
	/**
	 * Gets a citation and concatenated it into a string.
	 * Format:
	 * "Bininda-Emonds, 2007. The delayed rise of present-day mammals.
	 * Nature Research. DOI: https://doi.org/10.1038/nature05634. Accessed: 05/12/2020.
	 * @return citation string
	 */
	public String getCitation()
	{
		return getAuthors() + pubYear + ". " + title + ". " + publisher + ". DOI: " + doi + ". Accessed: " + dateAdded;
	}
}
