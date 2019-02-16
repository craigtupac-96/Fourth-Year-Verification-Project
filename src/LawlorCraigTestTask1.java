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
		// The following period values will be used for tests 1 - 12
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
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeReducedRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(-1), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 3
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedGreaterThanNormal() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(6), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 4 
	@org.junit.Test
	public void normalRateZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(0), new BigDecimal(6), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 5 
	@org.junit.Test
	public void ratesAreEqual() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 6
	@org.junit.Test
	public void ratesAreEqualAndZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(0), new BigDecimal(0), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 7 
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateIsLetter() {
		new Rate(CarParkKind.STAFF, new BigDecimal('a'), new BigDecimal(3), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 8
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedRateIsLetter() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal('b'), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 9
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateIsNull() {
		new Rate(CarParkKind.STAFF, null, new BigDecimal(3), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 10
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedRateIsNull() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), null, reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 11
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void carParkKindIsNull() {
		new Rate(null, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, normalPeriodList );
	}
	
	// Test Case 12
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void carParkKindDoesNotExist() {		
		new Rate(CarParkKind.valueOf("SUPER-HERO"), new BigDecimal(5), new BigDecimal(3), reducedPeriodList, normalPeriodList );
	}
	
	/*// Rate(staff, 5, 3,  [(9, 13), (19, 22)], [(12, 18), (0, 8)])
	// Test Case 13
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedOverlapsNormalPeriod() {		
		
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), ist, normalPeriodList );
	}*/
	
}
