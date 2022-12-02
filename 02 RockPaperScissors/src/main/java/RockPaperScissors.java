import java.io.File;
import java.util.Scanner;

/*The winner of the whole tournament is the player with the highest score.
 Your total score is the sum of your scores for each round. The score for a
 single round is the score for the shape you selected (1 for Rock, 2 for Paper,
 and 3 for Scissors) plus the score for the outcome of the round (0 if you lost,
 3 if the round was a draw, and 6 if you won).
*/

public class RockPaperScissors {
    public static void main(String[] args) {
        File strategyGuide = new File("src/rpsStrategyGuide.txt");
        Scanner reader;
        int score =0;
        //A-Rock: 1, B-Paper: 2, C-Scissors: 3
        //X,Y,Z - LOSE, DRAW, WIN
        //Lost: 0, Tie: 3, Won: 6
        try {
            reader = new Scanner(strategyGuide);
            while(reader.hasNext()){
                String line = reader.nextLine();
                if(line.endsWith("Z")){
                    score += 6;
                    if(line.startsWith("A")){
                        score +=2;
                    }else if(line.startsWith("B")){
                        score +=3;
                    }else{
                        score+=1;
                    }
                }else if(line.endsWith("Y")){
                    score +=3;
                    if(line.startsWith("A")){
                        score +=1;
                    }else if(line.startsWith("B")){
                        score +=2;
                    }else score+=3;
                }else if(line.endsWith("X")){
                    if(line.startsWith("A")){
                        score +=3;
                    }else if(line.startsWith("B")){
                        score +=1;
                    }else score +=2;
                }
            }
            System.out.println(score);
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage()) ;
        }
    }
}
