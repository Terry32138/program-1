package com.company;

/********
 Author: Professor Wooster
 Program: test program for Money class
 Due Date:
 Time Spent:
 Purpose: provide a test driver for the Money class of program assignment #1
 Accomplishments: provide a test driver program for my Java students to be able to test their first program assignment
 ********/

import java.util.Scanner;

public class moneyTest
{
  public static void main(String[] args)
  {
    String command;
    Money money = new Money();
    Scanner scan = new Scanner(System.in);
    //
    // read each command and call the appropriate Money method
    //
    while (scan.hasNextLine())
    {
      command = scan.nextLine();
      //
      // based on the value read into command, call a Money method
      //
      switch (command)
      {
        case "change":
          money.processChange(scan);
          break;
        case "float":
          money.processFloat(scan);
          break;
        case "check":
          money.processCheck(scan);
          break;
        case "change-float":
          money.processChangeFloat(scan);
          break;
        case "change-change":
          money.processChangeChange(scan);
          break;
        default:
          System.out.println("invalid command: " + command);
          System.exit(1);
      }
    }
  }
}
