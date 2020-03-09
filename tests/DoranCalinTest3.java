import cm.CarParkKind;
import cm.CarParkStatus;
import cm.Period;
import cm.Rate;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DoranCalinTest3 {

    // ### Rate test methods ###

    @Test
    public void successTest() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void normalRateNeg() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(-2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void normalRateNULL() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = null;
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reducedRateFail() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(3);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reducedRateNULL() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = null;
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = NullPointerException.class)
    public void normalPerNULL() {
        Period periodA = null;
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = NullPointerException.class)
    public void reducedPerNULL() {
        Period periodA = new Period(0, 7);
        Period periodB = null;
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reducedRateNeg() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(-1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void normRateOverlap() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(6, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reducedRateOverlap() {
        Period periodA = new Period(0, 9);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void normPeriodHourLess() {
        Period periodA = new Period(-1, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reducedPeriodHourLess() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(-1, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    // ### New or modified tests ###

    @Test(expected = IllegalArgumentException.class)
    public void normalPeriodNull() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.FULL;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reducedPeriodNull() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.OPEN;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, null, normalP);
    }

    @Test
    public void isValidPeriod() {
        Period periodC = new Period(0, 7);
        Period periodD = new Period(7, 8);
        Period periodE = new Period(8, 9);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodC);
        normalP.add(periodD);
        normalP.add(periodE);
        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.CLOSED;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidNormalPeriod() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(4, 8);
        Period periodC = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        normalP.add(periodB);
        normalP.add(periodC);
        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.FULL;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notValidReducedPeriod() {
        Period periodC = new Period(0, 7);
        Period periodD = new Period(4, 8);
        Period periodE = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        reducedP.add(periodC);
        reducedP.add(periodD);
        reducedP.add(periodE);
        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.FULL;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlapNormalReduced() {
        Period periodA = new Period(0, 8);
        Period periodB = new Period(9, 12);
        Period periodC = new Period(11, 13);
        Period periodD = new Period(14, 23);

        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        normalP.add(periodB);
        reducedP.add(periodC);
        reducedP.add(periodD);

        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.FULL;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    // ### Calculate test methods ###

    @Test
    public void testCalculate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(6, 9);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(3));
    }

    @Test(expected = NullPointerException.class)
    public void nullTestCalculate() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = null;
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(3));
    }

    // ### Task3 Tests ###

    @Test
    public void task3TestVisitorFree() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(1, 5);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(0));
    }

    @Test
    public void task3TestVisitorHalfPriceAfter() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(1, 7);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(8));
    }

    @Test
    public void task3TestManagementMinimum() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 1);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(3));
    }

    @Test
    public void task3TestManagementAfterMin() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 5);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(10));
    }

    @Test
    public void task3TestStudentAtBase() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 3);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(5.50));
    }

    @Test
    public void task3TestStudentAbove() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 4);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(6));
    }

    @Test
    public void task3TestStudentBelow() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 1);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(2));
    }

    @Test(expected = NullPointerException.class)
    public void task3TestStudentReturn() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = null;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 1);
        Assert.assertEquals(testRate.calculate(periodStay), null);
    }

    @Test
    public void task3TestStaffAbove() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 10);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(16));
    }

    @Test
    public void task3TestStaffBelow() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);

        Period periodStay = new Period(0, 2);
        Assert.assertEquals(testRate.calculate(periodStay), new BigDecimal(4));
    }

    // ### End of Task3 ###

    // ### Bug tests ###

    @Test(expected = IllegalArgumentException.class)
    public void normalReducedRateZero() {
        Period periodA = new Period(0, 7);
        Period periodB = new Period(8, 12);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        reducedP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        CarParkStatus status = CarParkStatus.FULL;
        BigDecimal normal = new BigDecimal(0);
        BigDecimal reduced = new BigDecimal(0);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void periodOutOfScope() {
        Period periodA = new Period(0, 24);
        Period periodB = new Period(0, 25); // comment this line out to see it work
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodA);
        normalP.add(periodB);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Rate testRate = new Rate(kind, normal, reduced, reducedP, normalP);
    }
}
