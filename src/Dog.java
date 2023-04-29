import java.util.*;

public class Dog extends Enemy {

    public int amicability;
    public boolean Isfriend = false;

    //The tendency for the dog to be friendly
    public Dog() {
        super("dog", 10, 3);
    }

    private void Friend() {
        Enemy dog = new Dog();
        amicability = (int) (java.lang.Math.random() * 10);
        if (amicability <= 5) {
            Isthreat = true;
            //Dogattack(dog);
            System.out.println("This dog does not seem friendly. Best Run! ");
        } else if(amicability > 5){
            //Isfriend = true;
            //Dogfriend();
            System.out.println("You've come across a dog. Keep your guard up ");

        }

    }
    public void drawDog(){
        System.out.println(
                "     /\\_/\\  \n" +
                        "    ( o   o )  \n" +
                        "     =\\_~_/=  \n" +
                        "     /     \\ \\   \n" +
                        "    |       |\\ \\  \n" +
                        "     \\     /  \\ \\ \n" +
                        "     /_   _\\   > )\n" +
                        "    (@)\\^/(@)----'  \\ \n" +
                        "     \"  \"  \"        \\__\n"

        );
    }

    public void Dogattack(Dog dog) {
        //Enemy dog = new Dog();
        int reruns = 5;
        while (reruns != 0) {
            Player.hp -= dog.damage;
            String[] DogAttack = {"\nYou were just mauled! ", "\nThe dog struck you with its claws! ", "\nThat scratch just might bruise ",
                    "\nA sharp bite against your ankles...looks bad "};
            System.out.print(DogAttack[(int) (java.lang.Math.random() * DogAttack.length)]);
            System.out.print("\nYour health is now" + ' ' + Player.hp);
            Player.attackEnemy(dog);
            reruns -= 1;
            if (dog.hp <= 2){
                Isthreat = false;
                reruns = 0;
                System.out.print("\nThe dog ran into a hole in the wall. \nGood riddance.");
            }
            if (dog.IsAlive() == true && dog.hp > 2 && reruns == 0){
                reruns += 1;
            }
            else if( dog.IsAlive() == false && reruns != 0){
                reruns = 0;
            }
        }
    }

    public void Dogfriend(){
        Enemy dog = new Dog();
        String[] DogFriend = {"\nDog's are friendly, they wants to play with you"};
        System.out.print(DogFriend[(int) (java.lang.Math.random() * DogFriend.length)]);
        Isthreat = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("\nGive a name: ");
        String ourdog = sc.nextLine();
        dog.name = ourdog;
        System.out.printf("Name of the Dog: %s", dog.name);
    }
}