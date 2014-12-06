package Jocurilee;

import java.util.Scanner;

public class Hex2Bin
{
    public String hexToBinary(String hex)
    {
        int hexnumber = Integer.parseInt(hex, 16);
        //int hexnumber = new String[16];
        String bin = Integer.toBinaryString(hexnumber);
        System.out.println(bin);
        return bin;
    }
}
