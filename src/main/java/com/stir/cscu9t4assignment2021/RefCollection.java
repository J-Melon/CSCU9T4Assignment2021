package com.stir.cscu9t4assignment2021;

import java.util.*;

public class RefCollection
{
	private final int MAX_AUTHORS = 10; //Maximum number of authors
	private final int MAX_RESULTS = 20; //Maximum number of results by lookup
	private List<Ref> refList;
	
	/** Constructor */
	public RefCollection()
	{
		refList = new ArrayList<>();
	}
	
	/**
	 * Adds citation (reference) to reference list
	 * @param reference citation to be added
	 */
	public void addCitation(Ref reference)
	{
		refList.add(reference);
	}
	
	public String lookupByJournal(String journal)
	{
		ListIterator<Ref> iter = refList.listIterator();
		ArrayList<Ref> results = new ArrayList<>();
		
		
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getJournal().equals(journal))
			{
				results.add(current);
			}
		}
		
		sort(results);
		iter = results.listIterator();
		StringBuilder resultStr = new StringBuilder();
		
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getJournal().equals(journal))
			{
				resultStr.append(current.getCitation());
			}
		}
		
		return resultStr.toString();
	}
	
	public String lookupByVenue(String venue)
	{
		ListIterator<Ref> iter = refList.listIterator();
		ArrayList<Ref> results = new ArrayList<>();
		
		
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getVenue().equals(venue))
			{
				results.add(current);
			}
		}
		
		sort(results);
		iter = results.listIterator();
		StringBuilder resultStr = new StringBuilder();
		
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getVenue().equals(venue))
			{
				resultStr.append(current.getCitation());
			}
		}
		
		return resultStr.toString();
	}
	
	public String lookupByPublisher(String publisher)
	{
		ListIterator<Ref> iter = refList.listIterator();
		ArrayList<Ref> results = new ArrayList<>();
		
		
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getPublisher().equals(publisher))
			{
				results.add(current);
			}
		}
		
		sort(results);
		iter = results.listIterator();
		StringBuilder resultStr = new StringBuilder();
		
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getPublisher().equals(publisher))
			{
				resultStr.append(current.getCitation());
			}
		}
		
		return resultStr.toString();
	}
	
	public static void sort(ArrayList<Ref> arrList)
	{
		Ref temp;
		
		//Sort results arraylist for author alphabetically
		for (int i = 0; i < arrList.size() - 1; i++)
		{
			for (int j = i + 1; j < arrList.size(); j++)
			{
				if (arrList.get(i).getFirstAuthor().compareToIgnoreCase(arrList.get(j).getFirstAuthor()) > 0)
				{
					temp = arrList.get(i);
					arrList.set(i, arrList.get(j));
					arrList.set(j, temp);
				}
			}
		}
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
		for (char ch : authorCh)
		{
			if (ch == ',')
			{
				count++;
				lastComma = true;
				
				if (count < MAX_AUTHORS)
				{
					authors[count - 1] = currentAuthor.toString();
					currentAuthor.setLength(0);
				}
				else
				{
					return null; //Failed
				}
			}
			else if (lastComma && ch == ' ') //Discards comma space
			{
				lastComma = false;
			}
			else
			{
				currentAuthor.append(ch);
			}
		}
		
		authors[count] = currentAuthor.toString(); //For last author (no comma)
		
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
			calendar.set(year, month - 1, day); //As January = 0
			//calendar.getTime(); //To throw exception as check done lazily
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
	public int getNumberOfRefs()
	{
		return refList.size();
	}
	
	public String[] removeNull(String[] a)
	{
		ArrayList<String> removedNull = new ArrayList<>();
		for (String str : a)
		{
			if (str != null)
			{
				removedNull.add(str);
			}
		}
		
		return removedNull.toArray(new String[0]);
	}
}
