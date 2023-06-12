package com.mycompany.number_guessing_game;
import java.util.*;
import java.util.Scanner;
public class Number_Guessing_Game {
    public static void main(String[] args){
        int min = 1;
        int max = 100;
        int attempts = 5;
        int score = 0;
        
        System.out.println("Number Guessing Game");
        
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String PlayAgain;
        
        do{
            int randomNo = r.nextInt(max - min + 1) + min;
            System.out.println("Guess the Number I selected Between "+min+" and "+max+" . ");
            System.out.println("Play Carefully you have "+attempts+" total attempts");
            
            int count = 0;
            boolean correct = false;
            
            while(count<attempts && !correct){
                System.out.println("Enter your Guess: ");
                int guess = sc.nextInt();
                sc.nextLine();
                
                count++;
                
                if(guess == randomNo){
                    System.out.println("WooHoo!! You guessed the number correctly in "+count+" attempts");
                    score += attempts - count +1;
                    correct = true;
                }else if (guess<randomNo){
                    System.out.println("Too Low! Try Again.");
                }else{
                    System.out.println("Too High! Try Again");
                }
            }
            if(!correct){
                System.out.println("Hard Luck! you couldn't guess the number. \nThe Correct Number was"+randomNo+".");
            }
            System.out.println("Score : "+score);
            System.out.println("DO You want to play again? (yes/no): ");
            PlayAgain = sc.nextLine();
        }while(PlayAgain.equalsIgnoreCase("yes"));
        System.out.println("Thank You!");
    }
}
