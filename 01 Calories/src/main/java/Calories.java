/* Advent of Code Challenge #1 https://adventofcode.com/2022/day/1 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calories {
    public static void main(String[] args) {

        File myFile = new File("src/calories.txt");
        Scanner reader;
        int largest = 0;
        int second = 0;
        int third = 0;
        int currentSum = 0;
        int lineCounter = 0;

        try {
            reader = new Scanner(myFile);

            while(reader.hasNext()){
                String line = reader.nextLine();
                lineCounter++;
                if(!line.isEmpty()){
                    currentSum += Integer.parseInt(line);
                }else{
                    if(currentSum>third&&currentSum<second){
                        third=currentSum;
                        //linecounter and Souts are for testing
                        System.out.println("*** LINE " + lineCounter+" ***");
                        System.out.println("Third: "+third);
                        System.out.println("Second: "+second);
                        System.out.println("First: "+largest);
                    }else if(currentSum>second&&currentSum<largest){
                        third=second;
                        second=currentSum;
                        System.out.println("*** LINE " + lineCounter+" ***");
                        System.out.println("Third: "+third);
                        System.out.println("Second: "+second);
                        System.out.println("First: "+largest);
                    }else if(currentSum>largest){
                        third=second;
                        second=largest;
                        largest=currentSum;
                        System.out.println("*** LINE " + lineCounter+" ***");
                        System.out.println("Third: "+third);
                        System.out.println("Second: "+second);
                        System.out.println("First: "+largest);
                    }
                    currentSum=0;
                }
            }
            System.out.println("*******Top 3**********");
            System.out.println("Third: "+third);
            System.out.println("Second: "+second);
            System.out.println("First: "+largest);
            System.out.print("*Top 3 Total: ");
            System.out.println(largest+second+third);

        }catch (FileNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}

