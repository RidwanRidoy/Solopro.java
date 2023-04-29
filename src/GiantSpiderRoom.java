public class GiantSpiderRoom extends EnemyRoom{
    public GiantSpiderRoom(int x, int y, Enemy enemy) {
        super(x, y, enemy);
    }
    private String[] OGRE_INTRO = {"Ugly crawling Monster.", "It can jump and bite, so stay away!"};

    public String intro_text(){
        return OGRE_INTRO[(int) (java.lang.Math.random() * OGRE_INTRO.length)];
    }
}
