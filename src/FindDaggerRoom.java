public class FindDaggerRoom extends MapTile{
    public FindDaggerRoom(int x, int y) {
        super(x, y);
    }
    private String[] OGRE_INTRO = {"Vicious creature, you stay away at all cost!.", "Most likely you will not survive.",
            "A monster that is large, hideous, man like being that eats human. Careful!."," Better to leave than to be sorry"};

    public String intro_text(){
        return OGRE_INTRO[(int) (java.lang.Math.random() * OGRE_INTRO.length)];
    }

    public void modify_player(Player player){

    }
}
