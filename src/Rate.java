/*
	Author: Craig Lawlor
	Date: February 16 2019
	Description: The Rate class for the verification project - Software Engineering
*/
import java.math.BigDecimal;
import java.util.ArrayList;

public class Rate {
	
	CarParkKind kind;
	BigDecimal hourlyNormalRate;
	BigDecimal hourlyReducedRate;
	
	public Rate() {
		// default constructor
	}
	
	public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods, 
			ArrayList<Period> normalPeriods) {
		this.hourlyNormalRate = normalRate;
		this.hourlyReducedRate = reducedRate;
		this.kind = kind;
		
	}
	
	/*public BigDecimal calculate(Period calculationPeriod) {
		
		return BigDecimal;
	}*/
	
}
