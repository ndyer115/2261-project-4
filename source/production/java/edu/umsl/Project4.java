package edu.umsl;
import java.util.Scanner;
public class Project4 {
    static int c;
    static int heads,tails;
    public static void main(String agrs[]) {
        printrules();
        playgame();
    }
    public static void printrules() {
        System.out.println("Hydra Vs the Knight PyPy!\n");
        System.out.println("Rules and moves:");
        System.out.println("The only way to kill the hydra is to cut off all of its heads and tails.");
        System.out.println("First move, you can cut off exactly one of the hydra’s heads.");
        System.out.println("Second move, you can cut off exactly one of the hydra’s tails.");
        System.out.println("Third move, you can cut off exactly two of the hydra’s heads.");
        System.out.println("Fourth move, you can cut off exactly two of the hydra’s tails.");
        System.out.println("You cannot use the above moves if there are not enough heads or tails");
        System.out.println("\nIf you cut off exactly one head, a new head grows immediately.");
        System.out.println("If you cut off exactly one tail, two new tails grow immediately.");
        System.out.println("If you cuts off exactly two heads, nothing happens.");
        System.out.println("If you cuts off exactly two tails, a new head grows immediately.");
    }
    public static void playgame() {
        boolean check1 = true, check2 = true;
        Scanner scanner = new Scanner(System.in);
        int move;
        while (check1) {
            try {
                System.out.print("\nChoose how many heads the hydra should start with: ");
                heads = scanner.nextInt();
                break;
               } catch (Exception e) {
                System.out.println("invalid input, try again");
                scanner.nextLine();
               }
           }
        while (check2) {
            try {
               System.out.print("Choose how many tails the hydra should start with: ");
               tails = scanner.nextInt();
               break;
           }catch(Exception e){
                System.out.println("invalid input, try again");
                scanner.nextLine();
               }
           }
        while (heads > 0 || tails > 0) {
            try {
                System.out.println("Enter 1: cut off one hydra head.");
                System.out.println("Enter 2: cut off one hydra tail.");
                System.out.println("Enter 3: cut off two hydra heads.");
                System.out.println("Enter 4: cut off two hydra tails.");
                System.out.println("Enter 5: The hydra has bested you, quit.");
                System.out.println("Choose Move :");
                move = scanner.nextInt();
                if (move > 0 && move < 6) {
                    if (move==5) {
                        c = -1;
                        break;
                    } else if (move == 1) {
                        if (heads > 0) {
                            c++;
                        }

                         else{
                            System.out.println("Cannot perform this move, not enough hydra heads left!");
                        }


                    } else if (move==2) {
                        if (tails > 0) {
                            c++;
                            tails++;
                        } else {
                            System.out.println("Cannot perform this move, not enough hydra tails left!");
                        }
                    } else if (move==3) {
                        if (heads >= 2) {
                            c++;
                            heads = heads - 2;
                        } else {
                            System.out.println("Cannot perform this move, not enough hydra heads left!");
                        }
                    } else {
                        if (tails > 1) {
                            c++;
                            tails = tails - 2;
                            heads++;
                        } else {
                            System.out.println("Cannot perform this move, not enough hydra tails left!");
                        }
                    }
                } else {
                    System.out.println("invalid input, try again");
                }
                System.out.println("Hydra: Head=" + heads + " Tail=" + tails + "\n");
            }catch(Exception e){
                System.out.println("invalid input, try again");
                scanner.nextLine();
            }
        }
        if (c == -1)
            System.out.println("You failed to kill the hydra!");
        else {
            System.out.println("You killed the hydra in " + c + " moves!");
        }
       }
}
