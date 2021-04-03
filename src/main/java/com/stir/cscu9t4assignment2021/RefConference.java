package com.stir.cscu9t4assignment2021;

import java.util.Calendar;

public class RefConference extends Ref
{
	private String venue;
	private String location;
	
	/**
	 * Constructor
	 * @param title title of article
	 * @param authors list of authors
	 * @param doi Digital Object Identifier
	 * @param publisher name of publisher
	 * @param pubYear year of publication
	 * @param dateAdded date in which citation was added to system
	 * @param venue venue conference took place at
	 * @param location location of venue conference took place at
	 */
	public RefConference(String title, String[] authors, String doi, String publisher, int pubYear, Calendar dateAdded,
						 String venue, String location)
	{
		super(title, authors, doi, publisher, pubYear, dateAdded);
		this.venue = venue;
		this.location = location;
	}
	
	/** @return venue conference took place at */
	@Override
	public String getVenue()
	{
		return venue;
	}
	
	/** @return location of venue conference took place at */
	public String getLocation()
	{
		return location;
	}
	
	/**
	 * Gets a citation and concatenated it into a string.
	 * Format:
	 * Eric Holgate, Isabel Cachola, 2018, Why swear? analyzing and inferring the intentions of vulgar expressions,
	 * Association for Computational Linguistics, EMNLP, Brussels, DOI: https://www.aclweb.org/anthology/D18-1471.pdf,
	 * Accessed: 05/12/2020.
	 * @return citation string
	 */
	@Override
	public String getCitation()
	{
		return getAuthors() + getPubYear() + ", " + getTitle() + ", " + getPublisher() + ", " + getVenue() + ", " +
				getLocation() + ", DOI: " + getDoi() + ", Accessed: " + getDateAdded() + ".\n";
	}
}
