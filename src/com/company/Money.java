package com.company;

/********
 Author: Terry Smith
 Program: Money class - program assignment #1
 Due Date: 2/3/2020
 Purpose: Manipulate US currency from and into different formats
 ********/

import java.util.*;
import java.text.*;

public class Money
{
    // declare class variables
    double total; // used to store the Money value as a double precision floating point number like 34.2
    // you will need more variables declared here to handle each of the currency types; for example int hundreds to keep track of how many hundred dollar bills 
    int hundreds, tens, fives, ones, quarters, dimes, nickels, pennies;
    // this one will help you print floating point values in US currency format like $10.50
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

    // convert current currency values to a string
    public String toString()
    {
        return "";
    }

    // converts amount to US currency format
    public String toCurrency(double amount)
    {
      return nf.format(Math.round(amount * 100.0) / 100.0);
    }
    
    // convert currency to float
    // read currency values from Scanner s and compute value
    // output results
    public void processChange(Scanner s)
    {
       //read in values for currencies
        hundreds = s.nextInt();
        tens = s.nextInt();
        fives = s.nextInt();
        ones = s.nextInt();
        quarters = s.nextInt();
        dimes = s.nextInt();
        nickels = s.nextInt();
        pennies = s.nextInt();
        // storing original values for later use
        String origInput = (hundreds + " hundreds " + tens + " tens " + fives + " fives " + ones + " ones " +
                quarters + " quarters "  + dimes + " dimes " + nickels + " nickels " + pennies + " pennies");

        hundreds = hundreds * 100;
        tens = tens * 10;
        fives = fives * 5;
        ones = ones * 1;
        double quaRters = quarters;
        quaRters = quaRters * .25;
        double diMes = dimes;
        diMes = diMes * 0.10;
        double niCkel = nickels;
        niCkel = nickels * 0.05;
        double pennIes = pennies;
        pennIes = pennies * 0.01;
        total = (hundreds + tens + fives + ones + quaRters + diMes + niCkel + pennIes);
        System.out.println(origInput +  " = " + toCurrency(total));


    }

    // read from Scanner s and process float command
    // convert float to change
    // output results
    public void processFloat(Scanner s)
    {

        float change;
        change = s.nextFloat();
        change *= 100;
        hundreds = (int) change / 10000;
        tens = ((int) change - (hundreds * 10000))/1000;
        fives = ((int) change - (tens * 1000 + hundreds * 10000))/500;
        ones = ((int) change - (hundreds * 10000 + tens * 1000 + fives * 500))/100;
        quarters = ((int) change - (hundreds * 10000 + tens * 1000 + fives * 500 + ones * 100))/25;
        dimes = ((int) change - ((hundreds * 10000 + tens * 1000 + fives * 500) + ones * 100 + quarters * 25))/10;
        nickels = ((int) change - (hundreds * 10000 + tens * 1000 + fives * 500 + ones * 100 + quarters * 25 + dimes * 10))/5;
        pennies = ((int) change - (tens * 1000 + hundreds * 10000 + fives * 500 + ones * 100 + quarters * 25 + dimes * 10 + nickels * 5))/1;
        change = change / 100;
        System.out.println(toCurrency(change) + " = " + hundreds + " hundreds " + tens + " tens " + fives + " fives " + ones + " ones " + quarters
                + " qaurters "  + dimes + " dimes " + nickels + " nickels " + pennies + " pennies");
    }

    // read from Scanner s and process check command
    // convert float to dollar words & cents
    // output results
    public void processCheck(Scanner s)
    {

    }

    // read from Scanner s and process change-float command
    // read float of customer payment
    // read float of transaction cost
    // calculate difference and compute change values
    // output the results
    public void processChangeFloat(Scanner s)
    {
        int hundreds, tens, fives, ones, quarters, dimes, nickels, pennies;
        double amountPaid;
        double cost;

        // reading input for the cost and amount given by the customer
        amountPaid = s.nextDouble();
        cost = s.nextDouble();
        double difference = amountPaid - cost;

        // taking the difference and storing the outermost value to represent the number of that type of currency is there
        double updatedDiff = difference * 100;
        int hundreds2 = (int) updatedDiff / 10000;
        int tens2 = ((int) updatedDiff - (hundreds2 * 10000))/1000;
        int fives2 = ((int) updatedDiff - (tens2 * 1000 + hundreds2 * 10000))/500;
        int ones2 = ((int) updatedDiff - (hundreds2 * 10000 + tens2 * 1000 + fives2 * 500))/100;
        int quarters2 = ((int) updatedDiff - (hundreds2 * 10000 + tens2 * 1000 + fives2 * 500 + ones2 * 100))/25;
        int dimes2 = ((int) updatedDiff - ((hundreds2 * 10000 + tens2 * 1000 + fives2 * 500) + ones2 * 100 + quarters2 * 25))/10;
        int nickels2 = ((int) updatedDiff - (hundreds2 * 10000 + tens2 * 1000 + fives2 * 500 + ones2 * 100 + quarters2 * 25 + dimes2 * 10))/5;
        int pennies2 = ((int) updatedDiff - (tens2 * 1000 + hundreds2 * 10000 + fives2 * 500 + ones2 * 100 + quarters2 * 25 + dimes2 * 10 + nickels2 * 5))/1;
        System.out.println("change back on " + toCurrency(amountPaid) + " for purchase of " + nf.format(cost) + " is " + nf.format(difference) + " " + hundreds2 + " hundreds " + tens2 + " tens " + fives2 + " fives " + ones2 + " ones " + quarters2 + " quarters " + dimes2 + " dimes " + nickels2 + " nickels " + pennies2 + " pennies");



    }

    // read from Scanner s and process change-change command
    // read change of customer payment
    // read float of transaction cost
    // calculate difference and compute change values
    // output the results
    public void processChangeChange(Scanner s)
    {

        // this takes the change format and turns it into the float format

        //declaring variables for the change
        int hundreds, tens, fives, ones, quarters, dimes, nickels, pennies;
        double total;
        String amount;
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        // taking in input for each money type
        hundreds = s.nextInt();
        tens = s.nextInt();
        fives = s.nextInt();
        ones = s.nextInt();
        quarters = s.nextInt();
        dimes = s.nextInt();
        nickels = s.nextInt();
        pennies = s.nextInt();

        // taking the values of the variables and multiplying them by their corresponding currency value
        hundreds = hundreds * 100;
        tens = tens * 10;
        fives = fives * 5;
        ones = ones * 1;
        double quaRters = quarters;
        quaRters = quaRters * .25;
        double diMes = dimes;
        diMes = diMes * 0.10;
        double niCkel = nickels;
        niCkel = nickels * 0.05;
        double pennIes = pennies;
        pennIes = pennies * 0.01;
        total = (hundreds + tens + fives + ones + quaRters + diMes + niCkel + pennIes);
        //System.out.println("Total = " + nf.format(total));


        int hundreds1, tens1, fives1, ones1, quarters1, dimes1, nickels1, pennies1;
// this takes a float amount and outputs the change amount
        float cost;
        cost = s.nextFloat();
        float costTwo = cost;
        cost = (float) total - cost;
        amount = nf.format(cost);
        // multiplying by 100 to remove the decimal portion of the money making it into an integer
         /* getting the leftmost value and storing it into seperate variables. example 437.25 = 43725 / 10000 = 4.
          then taking that value multiplying it by 4 and subtracting that product from cost and their difference by 1000 to get 3 and etc */
        cost *= 100;
        hundreds1 = (int) cost / 10000;
        tens1 = ((int) cost - (hundreds1 * 10000))/1000;
        fives1 = ((int) cost - (tens1 * 1000 + hundreds1 * 10000))/500;
        ones1 = ((int) cost - (hundreds1 * 10000 + tens1 * 1000 + fives1 * 500))/100;
        quarters1 = ((int) cost - (hundreds1 * 10000 + tens1 * 1000 + fives1 * 500 + ones1 * 100))/25;
        dimes1 = ((int) cost - ((hundreds1 * 10000 + tens1 * 1000 + fives1 * 500) + ones1 * 100 + quarters1 * 25))/10;
        nickels1 = ((int) cost - (hundreds1 * 10000 + tens1 * 1000 + fives1 * 500 + ones1 * 100 + quarters1 * 25 + dimes1 * 10))/5;
        pennies1 = ((int) cost - (tens1 * 1000 + hundreds1 * 10000 + fives1 * 500 + ones1 * 100 + quarters1 * 25 + dimes1 * 10 + nickels1 * 5))/1;
        System.out.println("change back on " + nf.format(total) + " for purchase of " + nf.format(costTwo) + " is " + amount + " which is " + hundreds1 + " hundreds " + tens1 + " tens " + fives1 + " fives " + ones1 + " ones " + quarters1 + " quarters "  + dimes1 + " dimes " + nickels1 + " nickels " + pennies1 + " pennies");
        float costthree = (float)total;

        // doing the same as above except instead of outputing out the change format as the customers amount given rather then in float format
        costthree *= 100;
        int hundreds2 = (int) costthree / 10000;
        int tens2 = ((int) costthree - (hundreds2 * 10000))/1000;
        int fives2 = ((int) costthree - (tens2 * 1000 + hundreds2 * 10000))/500;
        int ones2 = ((int) costthree - (hundreds2 * 10000 + tens2 * 1000 + fives2 * 500))/100;
        int quarters2 = ((int) costthree - (hundreds2 * 10000 + tens2 * 1000 + fives2 * 500 + ones2 * 100))/25;
        int dimes2 = ((int) costthree - ((hundreds2 * 10000 + tens2 * 1000 + fives2 * 500) + ones2 * 100 + quarters2 * 25))/10;
        int nickels2 = ((int) costthree - (hundreds2 * 10000 + tens2 * 1000 + fives2 * 500 + ones2 * 100 + quarters2 * 25 + dimes2 * 10))/5;
        int pennies2 = ((int) costthree - (tens2 * 1000 + hundreds2 * 10000 + fives2 * 500 + ones2 * 100 + quarters2 * 25 + dimes2 * 10 + nickels2 * 5))/1;
        System.out.println("change back on " + hundreds2 + " hundreds " + tens2 + " tens " + fives2 + " fives " + ones2 + " ones " + quarters2 + " quarters " + dimes2 + " dimes " + nickels2 + " nickels " + pennies2 + " pennies for purchase of " + nf.format(costTwo) + " is " + amount + " which is " + hundreds1 + " hundreds " + tens1 + " tens " + fives1 + " fives " + ones1 + " ones " + quarters1 + " qaurters "  + dimes1 + " dimes " + nickels1 + " nickels " + pennies1 + " pennies");


    }
}
