/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt 
  to change this license
 */
package com.home.task_2_1_en;
import java.io.*;
/**
 *
 * @author PC
 */
public class Program 
{

    public static void main(String[] args) throws Exception
    {
        int a; // lower limit of safe readings
        int b; // upper limit of safe readings
        int n; // interference level value
        int c = 0; // counter for safe readings
        int d = 0; // variable to store the length of the safe reading segment
        int m = 0; // local maximum length of the safe reading segment
        // final maximum of the length of the safe reading segment
        int max_len = 0; 
        // Data input
        var stdin=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the safety limits for readings");
        System.out.print("Lower limit: ");
        a = Integer.parseInt(stdin.readLine());
        System.out.print("Upper limit: ");
        b = Integer.parseInt(stdin.readLine());
        System.out.println("Enter orbital station sensor readings");
        System.out.println("0 - end data input");
        // Input the first interference level value
        n = Integer.parseInt(stdin.readLine()); 
        while (n != 0) // Input readings until the value is 0
        {
            if ((n >= a) && (n <= b)) // condition for safe readings
            {
                c++; // Increment the safe readings counter
            }
            else
            {
               // If readings are unsafe, store the count of safe readings
               // and reset the counter
               d = c;
               c = 0; 
            }
            /* Determine the maximum length of the segment
            where readings are safe. If the counter was reset
            (the chain of safe data was interrupted), the maximum length
            is the old counter value (variable "d"). 
            Otherwise, it is the current (new) counter value (variable "c").
            Intermediate result.
            */
            if (d > c)
                m = d;
            else
                m = c;
            /*Final maximum length of the segment
            where readings are safe.*/
            if (m > max_len)
            {
                max_len = m;
            }
            // input the next data point
            n = Integer.parseInt(stdin.readLine()); 
        }
        // Output information to the screen
        System.out.println
        (
           "Length of the interval where all readings are safe: " + 
           max_len
        );
    }
}