import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class StartingRoom extends MapTile {

    public StartingRoom(int x, int y) {
        super(x, y);
    }

    public String intro_text() {
        final String[] STRT_INTRO = {"This is where you start, you are all alone!", "Careful on where you go, there might be unknown creatures." +
                " Be cautious at all cost!", "If you're clever, you might be rewarded."};
        return STRT_INTRO[new Random().nextInt(STRT_INTRO.length)];
    }

    @Override
    public void modify_player(Player player) throws IOException {
        int rHapp =  (int) (java.lang.Math.random() * 10);
        if (rHapp == 3 || rHapp == 6){
            Dog dog = new Dog();
        }
        if(rHapp == 2 || rHapp == 4){
            System.out.print("The floor is wet");
        }
        if(rHapp == 5 || rHapp == 7 || rHapp == 8 || rHapp == 9){
            System.out.print("Somethings moving in the corner \n Would you like to check? y/n: ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            char response_input = in.readLine().charAt(0);
            if (response_input == 'y') {
                int rInput = new Random().nextInt(5);
                if (rInput == 1) {
                    System.out.print("You found a map");
                    Player.inventory.add(new Map());
                }
                else if (rInput == 2){System.out.print("Ah, it looks like we have here the remains of a zombie's torso, completely dehydrated");
                    if (((int) (java.lang.Math.random() * 3)) % 2 == 0) {
                        System.out.print("\nYou just smelled the torso");
                        Player.hp -= 5;
                        System.out.print("\nRemaining health point is " + Player.hp);
                    }
                }
                else if (rInput == 3){
                    System.out.print("Good News! seems like you're surrounded by all the golds");
                    Player.inventory.add(new Gold(((int) (java.lang.Math.random() * 50))));}

                else if (rInput == 4) {System.out.print("\nYou have just disturbed a sleeping dog.");
                    Dog dog = new Dog();
                    dog.amicability = (int) (java.lang.Math.random() * 10);
                    if (dog.amicability <= 5) {
                        dog.Isthreat = true;
                        dog.Dogattack(dog);
                        dog.drawDog();
                        System.out.println("You should run, the dog seems in a bad mood");
                    } else if(dog.amicability > 5){
                        //Isfriend = true;
                        //Dogfriend();
                        System.out.println("Too bad! the dog is front of you, Be alert!");

                    }
                }
                else if (rInput == 5){
                    System.out.print("Interesting find");
                    Player.inventory.add(new Waste("What can you do with it."));
                }
            }
        }
    }
}