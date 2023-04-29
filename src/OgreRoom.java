import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class OgreRoom extends EnemyRoom{
    public OgreRoom(int x, int y, Enemy enemy) {
        super(x, y, enemy);
    }

    private final String[] OGRE_INTRO = {"Vicious creature, you stay away at all cost!.\", \"Most likely you will not survive\",\n" +
            "            \"A monster that is large, hideous, man like being that eats human. Careful!.\",\"Better to leave than to be sorry"};

    public String intro_text(){
        return OGRE_INTRO[new Random().nextInt(OGRE_INTRO.length)];
    }
    public void modify_player(Player player) throws IOException {
        if( intro_text() == OGRE_INTRO[3]){
            System.out.print("You've been spotted by the creature, It's going towards you slowly" );
            Enemy ogre = new Ogre();
            int randy = (int) (java.lang.Math.random() * 3);
            if(randy == 1){
                System.out.print("Out frustration \nUnconciously you are attacking the Ogre!");
                //fight
                Player.attackEnemy(ogre);
                int randy2 = (int) (java.lang.Math.random() * 3);
                if (randy2 == 1){
                    System.out.print("\n....The Ogre seems not be a threat");

                    int randy3 = (int) (java.lang.Math.random() * 2);
                    if (randy3 == 1){
                        System.out.print("\nOgre demands restitution for the injury you caused");
                        System.out.print("\nWould you like to show the inventory to the Ogre? y/n: ");
                        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                        char response_input = in.readLine().charAt(0);
                        if (response_input != 'y') {
                            System.out.print("Ogre is looking at the damage spots");
                            Ogre.OgreCombat(ogre);
                        }else{
                            Item ogreTheft = Player.inventory.remove((int) (java.lang.Math.random() * Player.inventory.size()));
                            System.out.print("\nOgre took the offer " +  ogreTheft + "\nYou should feel lucky!" );
                        }
                    } else if (randy3 == 2) {
                        System.out.print("\n Some other mean Ogre spotted you");
                        Ogre.drawOgre();
                        Ogre.Isthreat = true;
                        Enemy ogre1 = new Ogre();
                        ogre1.name = "Mean Ogre";
                        Ogre.OgreCombat(ogre);
                        while(!ogre1.IsAlive()){
                            randy3 = 2;
                        }
                    }
                } else if (randy2 == 2) {//fight
                    ogre.Isthreat = true;
                    Ogre.OgreCombat(ogre);
                } else if (randy2 == 3) {
                    ogre.Isthreat = true;
                    Ogre.OgreCombat(ogre);
                    if(!ogre.IsAlive()){



                        System.out.print("that was not easy");
                    }
                }
            }else if(randy == 2){
                System.out.print("find place to hide");
                System.out.print("...........What's that? \n Would you mind to check it? y/n: ");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                char response_input = in.readLine().charAt(0);
                if (response_input == 'y') {
                    int rInput = new Random().nextInt(4);
                    if (rInput == 1) {
                        System.out.print("Score! A Mace!");
                        Player.inventory.add(new Mace("Mace", "Fairly used Mace, How did it get here!", 5,(int) (java.lang.Math.random() * 15) ));
                    }
                    if (rInput == 2) {
                        System.out.print("A box of tampons?....um okay ");
                        Player.inventory.add(new Waste("Old un open box"));
                    }
                    if (rInput == 3) {
                        System.out.print("you seemed to slipped and the Ogre noticed it");

                    }
                }else if(randy == 3){
                    System.out.print("The beast and you make eye contact");
                }
            }


        }
    }
}
