public class EmptyCavePathRoom extends MapTile{
    public EmptyCavePathRoom(int x, int y) {
        super(x, y);
    }
    private final String[] ECP_INTRO = {"This might be an empty path", "Don't get fooled",
            "There might be unknown creatures here", "It's better to turn around before it's too late",
    };
    public String intro_text(){
        return ECP_INTRO[(int) (java.lang.Math.random() * ECP_INTRO.length)];
    }
}
