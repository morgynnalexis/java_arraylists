/* --------------------------------
    Fill in your information here


  ---------------------------------  */


import jsjf.ArrayStack;
import java.util.Scanner;

public class CanineApp
{
   
   public static void main (String[] args)
   {
      ArrayStack<String> stack = new ArrayStack<String>();
      Scanner scan = new Scanner(System.in);
      String direction, numAsString;
      int northCount = 0, eastCount = 0, southCount = 0, westCount = 0;
      
      
      
      //------------------------------------------------------------
      // This lets the user input directions until they are finished.
      // the directions are add to the stack until they type quit
      //------------------------------------------------------------
      
      System.out.println("Please enter a valid direction(North, East, South, West) or Quit when you are finished.");
      System.out.println("Enter a direction: ");
      direction = scan.nextLine();
      direction = direction.toLowerCase();
      while(!direction.equals("quit")){
        
          if(direction.equals("south") || direction.equals("north") || direction.equals("east") || direction.equals("west")){
               stack.push(direction);
               System.out.println("Enter another direction or quit: ");
               direction = scan.nextLine();
               direction = direction.toLowerCase();
          }//end of if
          else{
             System.out.println("Please enter a valid direction or quit to stop: ");
             direction = scan.nextLine();
             direction = direction.toLowerCase();
          }//end of else         
          
    }//end of while
      
        
      //---------------------------------------------------
      // This method takes items from the stack one at a time
      // and creates a new stack that contains the directions to get home
      //---------------------------------------------------
         String getDir;
         String temp;
         ArrayStack<String> rtrnStack = new ArrayStack<String>();
         
         while(!stack.isEmpty()){
               getDir = stack.pop();
               if(getDir.equals("south")){
                  getDir = "north";
                  rtrnStack.push(getDir);
               }
               else if(getDir.equals("north")){
                    getDir = "south";
                    rtrnStack.push(getDir);
               }
               else if(getDir.equals("east")){
                    getDir = "west";
                    rtrnStack.push(getDir);
               }
               else if(getDir.equals("west")){
                    getDir = "east";
                    rtrnStack.push(getDir);
               }
                 
         }//end of while

         System.out.println("Here are the directions home: ");
         System.out.println( rtrnStack.toString() );

    //-----------------------------
    // Gets a count of all the directions
    //------------------------------
    while(!rtrnStack.isEmpty()){
         direction = rtrnStack.pop();
         if(direction.equals("south")){
            southCount++; 
         }
         else if(direction.equals("north")){
             northCount++; 
         }
         else if(direction.equals("east")){
             eastCount++;
         }
         else if(direction.equals("west")){
             westCount++; 
         }
    }//end of while loop
    
    
    //------------------------------------------
    // Prints out the shortest route home
    //------------------------------------------
    
    System.out.println("The shortest route home is: ");
    
    if(southCount > northCount){
         southCount = southCount - northCount;
         numAsString = String.valueOf(southCount);
         System.out.println("Go " + numAsString + " block(s) south");
    }
    else if(northCount > southCount){
         northCount = northCount - southCount;
         numAsString = String.valueOf(northCount);
         System.out.println("Go " + numAsString + " block(s) north");
    }
    else{
         System.out.println("You do not need to go north or south any blocks");
    }
    if(eastCount > westCount){
        eastCount = eastCount - westCount;
        numAsString = String.valueOf(eastCount);
        System.out.println("and go " + numAsString + " block(s) east.");
    }
    else if(westCount > eastCount){
        westCount = westCount - eastCount;
        numAsString = String.valueOf(westCount);
        System.out.println("and go " + numAsString + " block(s) west.");
    }
    else{
         System.out.println("You do not need to go east or west any blocks");
    }
    System.out.println("Then you will be home.");
}
   }