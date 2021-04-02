package com.stir.cscu9t4assignment2021;

import java.util.Calendar;

public class RefBookChapter extends Ref
{
	private String book;
	private  String editor;
	
	/**
	 * Constructor
	 * @param title title of chapter
	 * @param authors list of authors
	 * @param doi Digital Object Identifier
	 * @param publisher name of publisher
	 * @param pubYear year of publication
	 * @param dateAdded date in which citation was added to system
	 * @param book book referenced
	 * @param editor editor of book
	 */
	public RefBookChapter(String title, String[] authors, String doi, String publisher, int pubYear, Calendar dateAdded,
			   String book, String editor)
	{
		super(title, authors, doi, publisher, pubYear, dateAdded);
		this.book = book;
		this.editor = editor;
	}
	
	public String getBook()
	{
		return book;
	}
	
	public String getEditor()
	{
		return editor;
	}
	
	/**
	 * Gets a citation and concatenated it into a string.
	 * Format:
	 * "Marianne Lien, 2015, 'Becoming Sentient: Choreographies of Caring and Killing', in Darra Goldstein (ed)
	 * Becoming salmon, University of California Press, DOI: https://doi.org/10.1525/9780520961838, Accessed: 25/03/2021.
	 * @return citation string
	 */
	@Override
	public String getCitation()
	{
		return getAuthors() + getPubYear() + ", '" + getTitle() + "', in " + getEditor() + " (ed) " + getBook() + ", " +
				getPublisher() + ", DOI: " + getDoi() + ", Accessed: " + getDateAdded() + ".";
	}
}
