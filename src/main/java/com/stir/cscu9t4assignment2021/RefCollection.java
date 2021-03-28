package com.stir.cscu9t4assignment2021;

import java.util.List;
import java.util.ArrayList;

public class RefCollection
{
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
}
