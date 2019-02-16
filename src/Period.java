/*
	Author: Craig Lawlor
	Date: February 16 2019
	Description: The Period class for the verification project - Software Engineering
*/

public class Period {
	
	int startHour;
	int endHour;
	
	public Period() {
		
	}
	
	public Period(int start, int end) {
		startHour = start;
		endHour = end;
	}
	
	public int duration() {
		
		return 1; // fix
	}
	
	public Boolean overlaps(Period period) {
		
		return true; // fix
	}
	
}
