/*
	Author: Craig Lawlor
	Date: February 11 2019
	Description: A test case for the verification project - Software Engineering
*/
import static org.junit.Assert.assertEquals;

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
	
	// Test Case 13
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedOverlapsNormalPeriod() {		
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(9, 13));
		alternateReducedPeriod.add(new Period(19, 22));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList );
	}
	
	// Test Case 14
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalOverlapsReducedPeriod() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();
		
		alternateNormalPeriod.add(new Period(12, 20));
		alternateNormalPeriod.add(new Period(0, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Test Case 15
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedPeriodsOverlap() {		
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(16, 19));
		alternateReducedPeriod.add(new Period(18, 22));
		alternateNormalPeriod.add(new Period(12, 15));
		alternateNormalPeriod.add(new Period(0, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, alternateNormalPeriod );
	}
	
	// Test Case 16
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodsOverlap() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 16));
		alternateNormalPeriod.add(new Period(15, 18));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Test Case 17
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeReducedPeriod() {		
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(-1, 11));
		alternateReducedPeriod.add(new Period(19, 22));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList );
	}
	
	// Test Case 18
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedPeriodEqualTo24() {		
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(9, 11));
		alternateReducedPeriod.add(new Period(19, 24));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList );
	}
	
	// Test Case 19
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedPeriodGreaterThan24() {		
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(9, 11));
		alternateReducedPeriod.add(new Period(19, 25));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList );
	}
	
	// Test Case 20
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedPeriodIsLetter() {		
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(9, 11));
		alternateReducedPeriod.add(new Period('s', 22));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList );
	}
	
	// Test Case 21
	@org.junit.Test
	public void reducedPeriodEqualTo23() {
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();
		
		alternateReducedPeriod.add(new Period(9, 11));
		alternateReducedPeriod.add(new Period(19, 23));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList );
	}
	
	// Test Case 22 
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeNormalPeriod() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(-1, 18));
		alternateNormalPeriod.add(new Period(0, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Test Case 23 
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodEqualTo24() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 18));
		alternateNormalPeriod.add(new Period(24, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Test Case 24 
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodGreaterThan24() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 18));
		alternateNormalPeriod.add(new Period(25, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Test Case 25    
	@org.junit.Test
	public void normalPeriodEqualTo23() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 18));
		alternateNormalPeriod.add(new Period(23, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Test Case 26   
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodIsLetter() {		
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period('t', 18));
		alternateNormalPeriod.add(new Period(0, 8));
		
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod );
	}
	
	// Calculation tests begin here
	
	// Test Case 27
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativePeriod() {		
		
		new Rate().calculate(new Period(-1, 18));
	}
	
	// Test Case 28
	@org.junit.Test
	public void periodEqualTo0() {		
		
		assertEquals(new BigDecimal(15) ,new Rate().calculate(new Period(0, 18)));
	}
	
	// Test Case 29
	@org.junit.Test
	public void periodEqualTo7() {		
		
		assertEquals(new BigDecimal(15) ,new Rate().calculate(new Period(7, 18)));
	}
	
	// Test Case 30
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void periodGreaterThan24() {		
		
		new Rate().calculate(new Period(7, 25));
	}
	
	// Test Case 31
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void periodEqualTo24() {		
		
		new Rate().calculate(new Period(7, 24));
	}
	
	// Test Case 32
	@org.junit.Test
	public void periodEqualTo23() {		
		
		assertEquals(new BigDecimal(15) ,new Rate().calculate(new Period(7, 23)));
	}
	
	// Test Case 33
		@org.junit.Test(expected = IllegalArgumentException.class)
		public void periodEqualTo57() {		
			
			new Rate().calculate(new Period(7, 57));
		}
}
