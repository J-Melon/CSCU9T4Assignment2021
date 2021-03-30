package com.stir.cscu9t4assignment2021;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

public class RefCollection
{
	private final int MAX_AUTHORS = 10; //Maximum number of authors
	private List<Ref> refList;
	
	/** Constructor */
	public RefCollection()
	{
		refList = new ArrayList<Ref>();
	}
	
	/**
	 * Adds citation (reference) to reference list
	 * @param reference citation to be added
	 */
	public void addCitation(Ref reference)
	{
		refList.add(reference);
	}
	
	/**
	 * Parses a string of authors into a string array of less than max authors
	 * @param authorStr author string to be parsed
	 * @return boolean fail/pass
	 */
	public String[] parseAuthors(String authorStr)
	{
		String[] authors = new String[MAX_AUTHORS];
		StringBuilder currentAuthor = new StringBuilder();
		
		char[] authorCh = authorStr.toCharArray();
	
		int count = 0; //Counts number of authors added
		boolean lastComma = false; //Accounts for space after comma
		
		//Splits author string and puts into array
		for (int i = 0; i < authorCh.length - 1; i++)
		{
			if (authorCh[i] == ',')
			{
				count++;
				lastComma = true;
				
				if (count <= MAX_AUTHORS)
				{
					authors[count - 1] = currentAuthor.toString();
					currentAuthor.setLength(0);
				}
				else
				{
					return null; //Failed
				}
			}
			else if (lastComma && authorCh[i] == ' ') //Discards comma space
			{
				lastComma = false;
			}
			else
			{
				currentAuthor.append(authorCh[i]);
			}
		}
		
		authors[count] = currentAuthor.toString();
		
		return authors; //Passed
	}
	
	/**
	 * Checks if year is not negative and less than current year
	 * @param year a year
	 * @return boolean fail/pass
	 */
	public boolean isValidYear(int year)
	{
		return year >= 0 && year <= Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * Checks if given date is valid
	 * @param day a day
	 * @param month a month
	 * @param year a year
	 * @return
	 */
	public Calendar isValidDate(int day, int month, int year)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setLenient(false);
		
		try
		{
			calendar.set(year, month, day);
			calendar.getTime(); //To throw exception as check done lazily
		}
		catch (Exception e)
		{
			return null;
		}
		
		return calendar;
	}
	
	/**
	 * Counts the number of entries
	 * @return number of entries
	 */
	public int getNumberOfEntries()
	{
		return refList.size();
	}
}
