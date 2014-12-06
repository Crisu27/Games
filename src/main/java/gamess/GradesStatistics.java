package Jocurilee;

import java.util.Scanner;

public class GradesStatistics
{
    public void average()
    {
        System.out.println("Enter the number of students");
        Scanner in = new Scanner(System.in);
        int num_Students = in.nextInt();
        System.out.println("Number of students is: " + num_Students);
        int[] grades = new int[num_Students];

        int currentstudent = 0;
        int average = 0;

        for (currentstudent = 1; currentstudent<=num_Students; currentstudent++)
        {
            System.out.println("Enter the grade for student " + currentstudent + ":");
            grades[currentstudent-1] = in.nextInt();

            if(grades[currentstudent-1]>100)
            {
                System.out.println("Invalid grade, try again...");
                currentstudent--;
            }
            else average = average + grades[currentstudent-1];
        }
        System.out.println("Average is: " + average/num_Students);
    }

}


