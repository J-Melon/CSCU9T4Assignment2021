package com.stir.cscu9t4assignment2021;

import java.util.Calendar;

public class RefJournal extends Ref
{
	private String journal;
	private int volume;
	private int issue;
	
	/**
	 * Constructor
	 * @param title title of article
	 * @param authors list of authors
	 * @param doi Digital Object Identifier
	 * @param publisher name of publisher
	 * @param pubYear year of publication
	 * @param dateAdded date in which citation was added to system
	 * @param journal journal that the article is in
	 * @param volume volume of journal that the article is in
	 * @param issue issue of journal that the article is in
	 */
	public RefJournal(String title, String[] authors, String doi, String publisher, int pubYear, Calendar dateAdded,
					  String journal, int volume, int issue)
	{
		super(title, authors, doi, publisher, pubYear, dateAdded);
		this.journal = journal;
		this.volume = volume;
		this.issue = issue;
	}
	
	/** @return journal that the article is in */
	public String getJournal()
	{
		return journal;
	}
	
	/** @return volume of journal that the article is in */
	public String getVolume()
	{
		return String.valueOf(volume);
	}
	
	/** @return issue of journal that the article is in */
	public String getIssue()
	{
		return String.valueOf(issue);
	}
	
	/**
	 * Gets a citation and concatenated it into a string.
	 * Format:
	 * "Olaf Bininda-Emonds, 2007, The delayed rise of present-day mammals, Nature,
	 * Nature Research, vol. 28, no. 8, DOI: https://doi.org/10.1038/nature05634, Accessed: 05/12/2020.
	 * @return citation string
	 */
	@Override
	public String getCitation()
	{
		return getAuthors() + getPubYear() + ", " + getTitle() + ", " + getJournal() + ", " + getPublisher() +
				", vol. " + getVolume() + ", no. " + getIssue() + ", DOI: " + getDoi() + ", Accessed: " +
				getDateAdded() + ".";
	}
}
