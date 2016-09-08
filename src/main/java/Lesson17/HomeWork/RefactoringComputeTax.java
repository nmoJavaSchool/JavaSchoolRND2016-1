package Lesson17.HomeWork;

/**
 * Created by user on 08.09.16.
 */
import java.util.Scanner;

public class RefactoringComputeTax {
    private final double income;
    private final int status;
    private final double FIRST_PERCENT = 0.10;
    private final double SECOND_PERCENT = 0.15;
    private final double THIRD_PERCENT = 0.25;
    private final double FOURTH_PERCENT = 0.28;
    private final double FIFTH_PERCENT = 0.33;
    private final double SIXTH_PERCENT = 0.35;
    private double tax = 0;

    private final double [][] MONEY = new double[][]{
            {8350, 33950, 82250, 171550, 372950},
            {16700, 67900, 137050, 208850, 372950},
            {8350, 33950, 68525, 104425, 186475},
            {11950, 45500, 117450, 190200, 372950}
    };

    public RefactoringComputeTax(double income, int status) throws Exception{
        this.income = income;
        this.status = status;
        if(status>3)
            new Exception("Invalid status");
    }

    public double getTax(){
        if (income <= MONEY[status][0])
            tax = income * FIRST_PERCENT;
        else if (income <= MONEY[status][1])
            tax = MONEY[status][0] * FIRST_PERCENT + (income - MONEY[status][0]) * SECOND_PERCENT;
        else if (income <= MONEY[status][2])
            tax = MONEY[status][0] * FIRST_PERCENT + (MONEY[status][1] - MONEY[status][0]) * SECOND_PERCENT +
                    (income - MONEY[status][1]) * THIRD_PERCENT;
        else if (income <= MONEY[status][3])
            tax = MONEY[status][0] * FIRST_PERCENT + (MONEY[status][1] - MONEY[status][0]) * SECOND_PERCENT +
                    (MONEY[status][2] - MONEY[status][1]) * THIRD_PERCENT + (income - MONEY[status][2]) * FOURTH_PERCENT;
        else if (income <= MONEY[status][4])
            tax = MONEY[status][0] * FIRST_PERCENT + (MONEY[status][1] - MONEY[status][0]) * SECOND_PERCENT +
                    (MONEY[status][2] - MONEY[status][1]) * THIRD_PERCENT + (MONEY[status][3] - MONEY[status][2]) * FOURTH_PERCENT +
                    (income - MONEY[status][3]) * FIFTH_PERCENT;
        else
            tax = MONEY[status][0] * FIRST_PERCENT + (MONEY[status][1] - MONEY[status][0]) * SECOND_PERCENT +
                    (MONEY[status][2] - MONEY[status][1]) * THIRD_PERCENT + (MONEY[status][3] - MONEY[status][2]) * FOURTH_PERCENT +
                    (MONEY[status][4] - MONEY[status][3]) * FIFTH_PERCENT + (income - MONEY[status][4]) * SIXTH_PERCENT;
        return tax;
    }

    public void printTax(){
        System.out.println("Refactoring Tax is " + (int)(getTax() * 100) / 100.0);
    }
}
