package gamess;

import java.util.Scanner;

public class GradesStatistics2
{
    public void average2()
    {
        System.out.println("Enter the number of students: ");
        Scanner in = new Scanner(System.in);
        int num_students = in.nextInt();
        int[] grades = new int[num_students];

        int currentstudent = 0;
        double average = 0;

        for (currentstudent = 1; currentstudent<=num_students; currentstudent++)
        {
            System.out.println("Enter the grade for student: " + currentstudent);
            grades [currentstudent-1] = in.nextInt();

            if(grades[currentstudent-1]>100)
            {
                System.out.println("Invalid grade, try again... ");
                currentstudent--;
            }
            else average = average + grades[currentstudent-1];
        }
        average = average/num_students;
        System.out.println("The average is: " + average);
        max_min(grades);
        standard(grades, average, num_students);
    }

    public void max_min(int[]grades)
    {
        int min = grades[0];
        int max = grades[0];

        for(int current = 0; current<grades.length; current++)
        {
            if(grades[current]<min)
            {
                min = grades[current];
            }
            else if (grades[current]>max)
            {
                max = grades[current];
            }
        }
        System.out.println("The minimum is: " + min);
        System.out.println("The maximum is: " + max);
    }

    public void standard(int[]grades, double average, int num_students)
    {
        double sum = 0;

        for(int current = 0; current<grades.length; current++)
        {
            sum = sum+(grades[current]*grades[current]) - 2*(grades[current]*average)+(average*average);
        }
        double stdv = 0;
        stdv = Math.sqrt(sum/num_students);
        System.out.println("The standard deviation is: " + stdv);
    }
}
