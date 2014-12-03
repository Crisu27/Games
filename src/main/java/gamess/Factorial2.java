package gamess;

public class Factorial2
{
    public static int fact(int l)
    {
        int result = 1;
        while (l !=0)
        {
            result = result*l;
            l--;
        }
        return result;
    }
}
