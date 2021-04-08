package com.stir.cscu9t4assignment2021;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RefCollection
{
	private final int MAX_AUTHORS = 10; //Maximum number of authors
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
	public void addCitation(Ref reference) { refList.add(reference); }
	
	/**
	 * Searches for references containing a specific journal.
	 * @param journal journal to be searched
	 * @return references concatenated into a string
	 */
	public String lookupByJournal(String journal, boolean write)
	{
		ListIterator<Ref> iter = refList.listIterator();
		ArrayList<Ref> results = new ArrayList<>();
		
		//Search list
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
		
		//Iterate list to get string
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getJournal().equals(journal))
			{
				resultStr.append(current.getCitation());
			}
		}
		
		if (write)
		{
			String pathname = new File("").getAbsolutePath() + "\\" +
					new SimpleDateFormat("mmss-").format(new Date()) + "JournalReferences" + ".txt";
			return writeFile(pathname, resultStr);
		}
		
		return resultStr.toString();
	}
	
	/**
	 * Searches for references containing a specific venue.
	 * @param venue venue to be searched
	 * @return references concatenated into a string
	 */
	public String lookupByVenue(String venue, boolean write)
	{
		ListIterator<Ref> iter = refList.listIterator();
		ArrayList<Ref> results = new ArrayList<>();
		
		//Search list
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
		
		//Iterate list to get string
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getVenue().equals(venue))
			{
				resultStr.append(current.getCitation());
			}
		}
		
		if (write)
		{
			String pathname = new File("").getAbsolutePath() + "\\" +
					new SimpleDateFormat("mmss-").format(new Date()) + "ConferenceReferences" + ".txt";
			return writeFile(pathname, resultStr);
		}
		
		return resultStr.toString();
	}
	
	/**
	 * Searches for references containing a specific publisher.
	 * @param publisher publisher to be searched
	 * @return references concatenated into a string
	 */
	public String lookupByPublisher(String publisher, boolean write)
	{
		ListIterator<Ref> iter = refList.listIterator();
		ArrayList<Ref> results = new ArrayList<>();
		
		//Search list
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
		
		//Iterate list to get string
		while (iter.hasNext())
		{
			Ref current = iter.next();
			if (current.getPublisher().equals(publisher))
			{
				resultStr.append(current.getCitation());
			}
		}
		
		if (write)
		{
			String pathname = new File("").getAbsolutePath() + "\\" +
					new SimpleDateFormat("mmss-").format(new Date()) + "PublisherReferences" + ".txt";
			return writeFile(pathname, resultStr);
		}
		
		return resultStr.toString();
	}
	
	/**
	 * Sorts a list of references alphabetically by the first author starting from first name.
	 * @param arrList list of references
	 */
	public static void sort(List<Ref> arrList)
	{
		Ref temp;
		
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
	 * Parses a CSV into references which are added to refList.
	 * @param path path of CSV file
	 * @param refType type of reference CSV contains from: "all", "journal", "conference", "book chapter"
	 * @return result string to be outputted
	 */
	public String importCSV(String path, String refType)
	{
		File file = new File(path);
		Ref reference;
		
		try
		{
			Scanner scan = new Scanner(file);
			scan.useDelimiter(",|\\r\\n|\\n|\\r"); //Linux/OSX(Old)/Windows
			scan.nextLine(); //Headings
			
			while (scan.hasNext())
			{
				//Basic Reference
				String scanTitle = scan.next();
				if (scanTitle.isBlank()) { return "Found blank line in CSV, please remove."; }
				
				String scanAuthors = scan.next();
				String scanYear = scan.next();
				String scanPublisher = scan.next();
				String scanDOI = scan.next();
				String scanDate = scan.next();
				
				//Declarations
				String scanJournal = "";
				String scanVolume = "";
				String scanIssue = "";
				String scanVenue = "";
				String scanLocation = "";
				String scanBook = "";
				String scanEditor = "";
				
				if (refType.equals("Journal") || refType.equals("all"))
				{
					//Journal
					scanJournal = scan.next();
					scanVolume = scan.next();
					scanIssue = scan.next();
				}
				
				if (refType.equals("Conference") || refType.equals("all"))
				{
					//Conference
					scanVenue = scan.next();
					scanLocation = scan.next();
				}
				
				if (refType.equals("Book Chapter") || refType.equals("all"))
				{
					//Book Chapter
					scanBook = scan.next();
					scanEditor = scan.next();
				}
				
				//INTEGER PARSING
				int pubYear;
				int volume;
				int issue;
				
				//Year
				try { pubYear = Integer.parseInt(scanYear); }
				catch (NumberFormatException e)
				{
					scanYear = "0";
					pubYear = Integer.parseInt(scanYear);
				}
				
				//Volume
				try { volume = Integer.parseInt(scanVolume); }
				catch (NumberFormatException e)
				{
					scanVolume = "0";
					volume = Integer.parseInt(scanVolume);
				}
				
				//Issue
				try { issue = Integer.parseInt(scanIssue); }
				catch (NumberFormatException e)
				{
					scanIssue = "0";
					issue = Integer.parseInt(scanIssue);
				}
				
				//OTHER PARSING
				//Authors
				String[] authors = parseAuthors(scanAuthors);
				
				//Date
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				
				if (! scanDate.isBlank())
				{
					calendar.setTime(sdf.parse(scanDate));
					
					if (isValidDate(calendar) == null)
					{
						calendar = Calendar.getInstance();
					}
				}
				
				//Decides reference type per record
				if (! scanJournal.isBlank() && ! scanVolume.isBlank() && ! scanIssue.isBlank())
				{
					reference = new RefJournal(scanTitle, authors, scanDOI, scanPublisher, pubYear, calendar,
							scanJournal, volume, issue);
				}
				else if (! scanVenue.isBlank() && ! scanLocation.isBlank())
				{
					reference = new RefConference(scanTitle, authors, scanDOI, scanPublisher, pubYear, calendar,
							scanVenue, scanLocation);
				}
				else
				{
					reference = new RefBookChapter(scanTitle, authors, scanDOI, scanPublisher, pubYear, calendar,
							scanBook, scanEditor);
				}
				
				addCitation(reference);
			}
			
		}
		catch (IOException e)
		{
			return "CSV import failed. Make sure to enter a correct path.";
		}
		catch (ParseException e)
		{
			return "CSV import failed. Make sure to enter valid dates and select the appropriate type.";
		}
		
		return "CSV imported successfully";
	}
	
	/**
	 * Exports references as a sorted test file.
	 * @return result string to be outputted
	 */
	public String exportTXT()
	{
		sort(refList);
		ListIterator<Ref> iter = refList.listIterator();
		String pathname = new File("").getAbsolutePath() + "\\" +
				new SimpleDateFormat("mmss-").format(new Date()) + "References" + ".txt";
		StringBuilder references = new StringBuilder();
		
		//Iterate list to get string
		while (iter.hasNext())
		{
			String current = iter.next().getCitation();
			references.append(current);
		}
		
		return writeFile(pathname, references);
	}
	
	public String writeFile(String pathname, StringBuilder references)
	{
		File outFile = new File(new File(pathname).getAbsolutePath());
		
		try
		{
			if (outFile.createNewFile())
			{
				System.out.println();
				PrintWriter wri = new PrintWriter(outFile);
				wri.write(references.toString());
				wri.close();
				return "Exported to TXT successfully.\nFile created at: " + outFile.getAbsolutePath();
			}
			else { return("Error: File already exists."); }
		}
		catch (IOException e)
		{
			return ("Error: IO exception.");
		}
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
	 * @return validated calendar
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
	 * Checks if given date is valid (overload)
	 * @param calendar a calendar
	 * @return validated calendar
	 */
	public Calendar isValidDate(Calendar calendar)
	{
		calendar.setLenient(false);
		
		try
		{
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
	public int getNumberOfRefs()
	{
		return refList.size();
	}
}
