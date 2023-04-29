public class LeaveCaveRoom extends MapTile{
    public LeaveCaveRoom(int x, int y) {
        super(x, y);
    }
    private String[] OGRE_INTRO = {"Ugly crawling Monster, It can jump and bite, so stay away!"};

    public String intro_text(){
        return OGRE_INTRO[(int) (java.lang.Math.random() * OGRE_INTRO.length)];
    }
}
