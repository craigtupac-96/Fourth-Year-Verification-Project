/*
	Author: Craig Lawlor
	Date: February 16 2019
	Description: The Rate class for the verification project - Software Engineering
*/
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;
    private ArrayList<Period> reduced = new ArrayList<>();
    private ArrayList<Period> normal = new ArrayList<>();

    public Rate(CarParkKind kind, BigDecimal normalRate, BigDecimal reducedRate, ArrayList<Period> reducedPeriods
            , ArrayList<Period> normalPeriods) {
        if (reducedPeriods == null || normalPeriods == null) {
            throw new IllegalArgumentException("periods cannot be null");
        }
        if (normalRate == null || reducedRate == null) {
            throw new IllegalArgumentException("The rates cannot be null");
        }
        if (normalRate.compareTo(BigDecimal.ZERO) < 0 || reducedRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A rate cannot be negative");
        }
        if (normalRate.compareTo(reducedRate) <= 0) {
            throw new IllegalArgumentException("The normal rate cannot be less or equal to the reduced rate");
        }
        if (!isValidPeriods(reducedPeriods) || !isValidPeriods(normalPeriods)) {
            throw new IllegalArgumentException("The periods are not valid individually");
        }
        if (!isValidPeriods(reducedPeriods, normalPeriods)) {
            throw new IllegalArgumentException("The periods overlaps");
        }
        this.kind = kind;
        this.hourlyNormalRate = normalRate;
        this.hourlyReducedRate = reducedRate;
        this.reduced = reducedPeriods;
        this.normal = normalPeriods;
    }

    /**
     * Checks if two collections of periods are valid together
     * @param periods1
     * @param periods2
     * @return true if the two collections of periods are valid together
     */
    private boolean isValidPeriods(ArrayList<Period> periods1, ArrayList<Period> periods2) {
        Boolean isValid = true;
        int i = 0;
        while (i < periods1.size() && isValid) {
            isValid = isValidPeriod(periods1.get(i), periods2);
            i++;
        }
        return isValid;
    }

    /**
     * checks if a collection of periods is valid
     * @param list the collection of periods to check
     * @return true if the periods do not overlap
     */
    private Boolean isValidPeriods(ArrayList<Period> list) {
        Boolean isValid = true;
        if (list.size() >= 2) {
            Period secondPeriod;
            int i = 0;
            int lastIndex = list.size()-1;
            while (i < lastIndex && isValid) {
                isValid = isValidPeriod(list.get(i), ((List<Period>)list).subList(i + 1, lastIndex+1));
                i++;
            }
        }
        return isValid;
    }

    /**
     * checks if a period is a valid addition to a collection of periods
     * @param period the Period addition
     * @param list the collection of periods to check
     * @return true if the period does not overlap in the collecton of periods
     */
    private Boolean isValidPeriod(Period period, List<Period> list) {
        Boolean isValid = true;
        int i = 0;
        while (i < list.size() && isValid) {
            isValid = !period.overlaps(list.get(i));
            i++;
        }
        return isValid;
    }


    public BigDecimal calculate(Period periodStay) {
        int normalRateHours = periodStay.occurences(normal);
        int reducedRateHours = periodStay.occurences(reduced);
        BigDecimal bigDtotal = new BigDecimal(0);
        BigDecimal returnTotal = new BigDecimal(0);

        MathContext mc = new MathContext(2);

        bigDtotal = (this.hourlyNormalRate.multiply(BigDecimal.valueOf(normalRateHours))).add(
                this.hourlyReducedRate.multiply(BigDecimal.valueOf(reducedRateHours)));


        if(this.kind.toString().equals("VISITOR")){
            // if greater than 8
            if(bigDtotal.compareTo(new BigDecimal(8)) > 0){
                returnTotal = bigDtotal.subtract(new BigDecimal(8), mc);
                returnTotal = returnTotal.multiply(new BigDecimal(0.5));
            }
            // if less than or equal to 8
            else if(bigDtotal.compareTo(new BigDecimal(8)) <= 0){
                returnTotal = new BigDecimal(0);
            }
        }
        else if(this.kind.toString().equals("MANAGEMENT")){
            // if less than 3
            if(bigDtotal.compareTo(new BigDecimal(3)) < 0){
                returnTotal = new BigDecimal(3);
            }
            else{
                returnTotal = bigDtotal;
            }
        }
        else if(this.kind.toString().equals("STUDENT")){
            // if less than 5.50
            if(bigDtotal.compareTo(new BigDecimal(5.50)) < 0){
                returnTotal = bigDtotal;
            }
            else if(bigDtotal.compareTo(new BigDecimal(5.50)) > 0){
                BigDecimal discount = new BigDecimal(0);

                discount = bigDtotal.subtract(new BigDecimal(5.50));
                returnTotal = bigDtotal.subtract(discount.multiply(new BigDecimal(0.25)));
            }
        }
        else if(this.kind.toString().equals("STAFF")){
            // if greater than 16
            if(bigDtotal.compareTo(new BigDecimal(16)) > 0) {
                returnTotal = new BigDecimal(16);
            }
            else{
                returnTotal = bigDtotal;
            }
        }

        return returnTotal.setScale(2, RoundingMode.HALF_UP);
    }

}
