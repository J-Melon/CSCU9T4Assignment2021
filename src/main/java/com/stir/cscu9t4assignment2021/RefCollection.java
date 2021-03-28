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
	public void addCite(Ref reference)
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
		
		//Splits author string and puts into array
		for (int i = 0; i < authorCh.length - 1; i++)
		{
			if (authorCh[i] == ',')
			{
				count++;
				currentAuthor.setLength(0);
				
				if (count <= MAX_AUTHORS)
				{
					authors[count] = currentAuthor.toString();
				}
				else
				{
					return null; //Failed
				}
			}
			else
			{
				currentAuthor.append(authorCh[i]);
			}
		}
		
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
	public boolean isValidDate(int day, int month, int year)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setLenient(false);
		
		try
		{
			calendar.set(year, month, day);
		}
		catch (Exception e)
		{
			return false;
		}
		
		return true;
	}
}
