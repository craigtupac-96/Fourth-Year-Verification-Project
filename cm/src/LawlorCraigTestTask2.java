/*
	Author: Craig Lawlor
	Date: February 11 2019
	Description: A test case for the verification project - Software Engineering
*/
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LawlorCraigTestTask2 {

	ArrayList<Period> reducedPeriodList = new ArrayList<Period>();
	ArrayList<Period> normalPeriodList = new ArrayList<Period>();

	@Before
	public void setUp() throws Exception {
		// The following period values will be used for tests 1 - 12
		reducedPeriodList.add(new Period(9, 11));
		reducedPeriodList.add(new Period(19, 22));
		normalPeriodList.add(new Period(12, 18));
		normalPeriodList.add(new Period(0, 8));
	}

	// Test case 1
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeNormalRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(-1), new BigDecimal(3), reducedPeriodList, normalPeriodList);
	}

	// Test Case 2
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeReducedRate() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(-1), reducedPeriodList, normalPeriodList);
	}

	// Test Case 3
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedGreaterThanNormal() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(6), reducedPeriodList, normalPeriodList);
	}

	// Test Case 4 
	@org.junit.Test
	public void reducedRateZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(6), new BigDecimal(0), reducedPeriodList, normalPeriodList);
	}

	// Test Case 5 
	@org.junit.Test
	public void ratesAreEqual() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), reducedPeriodList, normalPeriodList);
	}

	// Test Case 6
	@org.junit.Test
	public void ratesAreEqualAndZero() {
		new Rate(CarParkKind.STAFF, new BigDecimal(0), new BigDecimal(0), reducedPeriodList, normalPeriodList);
	}

	// Test Case 7 
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateIsLetter() {
		new Rate(CarParkKind.STAFF, new BigDecimal('a'), new BigDecimal(3), reducedPeriodList, normalPeriodList);
	}

	// Test Case 8
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedRateIsLetter() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal('b'), reducedPeriodList, normalPeriodList);
	}

	// Test Case 9
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalRateIsNull() {
		new Rate(CarParkKind.STAFF, null, new BigDecimal(3), reducedPeriodList, normalPeriodList);
	}

	// Test Case 10
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedRateIsNull() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), null, reducedPeriodList, normalPeriodList);
	}

	// Test Case 11
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void carParkKindIsNull() {
		new Rate(null, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, normalPeriodList);
	}

	// Test Case 12
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void carParkKindDoesNotExist() {
		new Rate(CarParkKind.valueOf("SUPER-HERO"), new BigDecimal(5), new BigDecimal(3), reducedPeriodList, normalPeriodList);
	}

	// Test Case 13
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedOverlapsNormalPeriod() {
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();

		alternateReducedPeriod.add(new Period(9, 13));
		alternateReducedPeriod.add(new Period(19, 22));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList);
	}

	// Test Case 14
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalOverlapsReducedPeriod() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 20));
		alternateNormalPeriod.add(new Period(0, 8));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
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

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, alternateNormalPeriod);
	}

	// Test Case 16
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodsOverlap() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 16));
		alternateNormalPeriod.add(new Period(15, 18));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
	}

	// Test Case 17
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeReducedPeriod() {
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();

		alternateReducedPeriod.add(new Period(-1, 11));
		alternateReducedPeriod.add(new Period(19, 22));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList);
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

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList);
	}

	// Test Case 20
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void reducedPeriodIsLetter() {
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();

		alternateReducedPeriod.add(new Period(9, 11));
		alternateReducedPeriod.add(new Period('s', 22));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList);
	}

	// Test Case 21
	@org.junit.Test
	public void reducedPeriodEqualTo23() {
		ArrayList<Period> alternateReducedPeriod = new ArrayList<Period>();

		alternateReducedPeriod.add(new Period(9, 11));
		alternateReducedPeriod.add(new Period(19, 23));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), alternateReducedPeriod, normalPeriodList);
	}

	// Test Case 22
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void negativeNormalPeriod() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(-1, 18));
		alternateNormalPeriod.add(new Period(0, 8));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
	}

	// Test Case 23
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodEqualTo24() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 18));
		alternateNormalPeriod.add(new Period(24, 8));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
	}

	// Test Case 24
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodGreaterThan24() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 18));
		alternateNormalPeriod.add(new Period(25, 8));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
	}

	// Test Case 25
	@org.junit.Test
	public void normalPeriodEqualTo23() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period(12, 18));
		alternateNormalPeriod.add(new Period(22, 23));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
	}

	// Test Case 26
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void normalPeriodIsLetter() {
		ArrayList<Period> alternateNormalPeriod = new ArrayList<Period>();

		alternateNormalPeriod.add(new Period('t', 18));
		alternateNormalPeriod.add(new Period(0, 8));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, alternateNormalPeriod);
	}

	// Test for a null value as reduced Period
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void nullReducedPeriod() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), null, normalPeriodList);
	}

	// Test for a null value as normal Period
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void nullNormalPeriod() {
		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(5), reducedPeriodList, null);
	}

	// Test with only 1 of each period type
	@org.junit.Test
	public void lessThan2OfEachPeriod() {
		ArrayList<Period> singleReducedList = new ArrayList<Period>();
		ArrayList<Period> singleNormalList = new ArrayList<Period>();

		singleReducedList.add(new Period(11, 12));
		singleNormalList.add(new Period(13, 14));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), singleReducedList, singleNormalList);
	}

	// Test with more than 2 of each type of period
	@org.junit.Test(expected = IllegalArgumentException.class)
	public void overlappingWithManyPeriods() {
		ArrayList<Period> manyReducedPeriodsList = new ArrayList<Period>();
		ArrayList<Period> manyNormalPeriodsList = new ArrayList<Period>();

		manyReducedPeriodsList.add(new Period(0, 3));
		manyReducedPeriodsList.add(new Period(2, 5));
		manyReducedPeriodsList.add(new Period(6, 9));
		manyNormalPeriodsList.add(new Period(8, 12));
		manyNormalPeriodsList.add(new Period(11, 14));
		manyNormalPeriodsList.add(new Period(15, 18));

		new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), manyReducedPeriodsList, manyNormalPeriodsList);
	}

	// Test the calculate method properly
	@org.junit.Test
	public void calcTest() {
		Rate rate = new Rate(CarParkKind.STAFF, new BigDecimal(5), new BigDecimal(3), reducedPeriodList, normalPeriodList);

		assertEquals(new BigDecimal(6), rate.calculate(new Period(9, 11)));
	}

}