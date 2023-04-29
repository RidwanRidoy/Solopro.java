public class Ogre extends Enemy{

    public Ogre() {
        super("Ogre", 17, 10);
    }
    public static void OgreCombat(Enemy ogre){
        ogre.damage = (int) (java.lang.Math.random() * 15);
        int reruns = 5;
        while(reruns!= 0){
            Player.hp -= ogre.damage;
            String[] OgreAttack = {"\nThe ogre hits yu hard ony your head ", "\n Then try to bite you, hold you tight. ", "\n You will suffer the pain",};
            int randy_OgreAttack = (int) (java.lang.Math.random() * OgreAttack.length);
            System.out.print(OgreAttack[randy_OgreAttack]);
            if(OgreAttack[randy_OgreAttack] == OgreAttack[3]){
                Player.hp -= (int) (java.lang.Math.random() * 5);
            }
            System.out.print("\nHealth point now" + ' ' + Player.hp);
            Player.attackEnemy(ogre);
            reruns -= 1;
            if(!ogre.IsAlive()){
                reruns = 0;
            }
        }
    }
    public static void drawOgre(){
        System.out.println(
                "                   .-^-.\n" +
                        "                  /_/_\\_\\\n" +
                        "                 ' ' | ` `\n" +
                        "                /    |     \\n" +
                        "               ,-.   |   ,-,  \n" +
                        "               |   `\"` `\"`   | \n" +
                        "               \\            /\n" +
                        "            ___/ \\__/\\__/ \\___ \n" +
                        "          /                      \\\n" +
                        "        /                            \\\n" +
                        "       /                              \\\n" +
                        "      /            ___             \\\n" +
                        "     /             |  |             \\\n" +
                        "     |    ___      |  |     ___     |\n" +
                        "     |   /   \\     |  |    /   \\    |\n" +
                        "     \\__/     \\____|__|___/     \\__/\n" +
                        "         \\         /     \\         /\n" +
                        "          \\       /       \\       /\n" +
                        "           `\"`'\"`\"`         `\"`'\"`\"`\n"
        );
    }
}

