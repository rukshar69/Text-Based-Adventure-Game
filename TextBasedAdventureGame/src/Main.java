import java.util.Random;
import java.util.Scanner;

/**
 * Created by Rukshar Alam on 6/22/2017.
 */
public class Main {
    public static void main(String[] args) {
        //System objects
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Game Variables
        String[] enemies = {"Skeleton","Zombie","Assassin","Warrior"};
        int enemyAttackDamage = 25;
        int maxEnemyHealth = 75;

        //Player variable
        int health = 100;
        int attackDamage = 50;
        int numHealthPotion = 3;
        int healthPotionAmount = 30;
        int healthPotionDropChance = 50;

        boolean running = true;

        System.out.println("WELCOME TO DUNGEON!!!!!");
        GAME:
        while (running)
        {
            System.out.println("------------------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t## "+enemy+" has appeared ##");
            while (enemyHealth>0)
            {
                System.out.println("\t Your Health HP: "+health);
                System.out.println("\t Enemy HP: "+enemyHealth);
                System.out.println("\t What's your decision?");
                System.out.println("\t 1.Attack");
                System.out.println("\t 2.Drink potion");
                System.out.println("\t 3.Run");

                String input = sc.nextLine();
                if(input.equals("1"))
                {
                    int damageDealt ,damagaeTaken;
                    damageDealt = rand.nextInt(attackDamage);
                    damagaeTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damagaeTaken;
                    System.out.println("\t>You strike the "+enemy+"for "+damageDealt+" damage");
                    System.out.println("\t>You receive "+damagaeTaken+ " damage as retaliation");

                    if(health<1)
                    {
                        System.out.println("XXX: YOU HAVE TAKEN TOO MUCH DAMAGE ... YOU'RE UNABLE TO GO ON");
                        break ;
                    }
                }
                else if(input.equals("2"))
                {
                    if(numHealthPotion>0)
                    {
                        if(health == 100)
                        {
                            System.out.println("\t>You are at full health no need for a potion!!!!");
                        }
                        else {
                            health += healthPotionAmount;
                            numHealthPotion--;
                            System.out.println("\t> You have taken a health potion!!!");
                            System.out.println("\t> Your current health HP: " + health);
                            System.out.println("\t> Now you have " + numHealthPotion + " potions left!!!");
                        }
                    }
                    else {
                        System.out.println("\t> You don't have any potions left !!!");
                        System.out.println("\t> Defeat enemies to get the chance to earn a potion  !!!");

                    }
                }
                else if(input.equals("3"))
                {
                    System.out.println("\t> You ran away from "+enemy+"!!!!");
                    continue GAME;
                }
                else
                {
                    System.out.println("XXXXX INVALID COMMAND XXXXXX");
                }
            }

            if(health<1)
            {
                System.out.println("You limp out of the dungeon weak from battle");
                break;
            }
            System.out.println("----------------------------------------------");
            System.out.println("\t## Hooray!!! Your enemy the "+enemy+" has been defeated ##");
            System.out.println("\t## You  have "+numHealthPotion+" potion(s) left ##");
            if(rand.nextInt(100)<healthPotionDropChance)
            {
                numHealthPotion++;
                System.out.println("\t## The enemy: "+enemy+" has dropped a health potion ##");
                System.out.println("\t## You NOW have "+numHealthPotion+" potion(s) ##");

            }

            System.out.println("----------------------------------------------");
            System.out.println("\t#What is your wish??????#");
            System.out.println("\t>1. To continue");
            System.out.println("\t>2. To exit");
            String  input = sc.nextLine();
            while (!input.equals("1") && !input.equals("2"))
            {
                System.out.println("XXXXX INVALID COMMAND XXXXXX");
            }

            if(input.equals("1"))
            {
                System.out.println("^_^ You Continue On Your Adventure.... ^_^ !!!!");
            }
            else if(input.equals("2"))
            {
                System.out.println("!!!!! You decide to quit... leaving successfully from your travels to dungeon world!!!!!");
                break ;
            }


        }
        System.out.println("#########################");
        System.out.println("# Thanks for playing!!! #");
        System.out.println("#########################");
    }
}
