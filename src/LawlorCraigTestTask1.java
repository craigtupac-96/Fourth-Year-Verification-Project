/*
	Author: Craig Lawlor
	Date: February 11 2019
	Description: A test case for the verification project - Software Engineering
*/
import java.math.BigDecimal;
import java.util.ArrayList;

public class LawlorCraigTestTask1 {
	
	
	ArrayList<Period> reducedPeriodList;
	ArrayList<Period> normalPeriodList;
	
	public void initialiseLists() {
		reducedPeriodList.add(new Period(9, 11));
		reducedPeriodList.add(new Period(19, 22));
		normalPeriodList.add(new Period(12, 18));
		normalPeriodList.add(new Period(0, 8));
	}	
	
	// Test case 1
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeNormalRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(3), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 2
	
	
	/*@org.junit.Test(expected = IllegalArgumentException.class)
    public void belowZero() throws Exception {
        Student std = new Student();
        std.getAttendanceGrade(-1);
    }*/ // example taken from the jenkins project

}
