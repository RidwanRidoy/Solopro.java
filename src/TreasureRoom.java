public class TreasureRoom extends MapTile{
    public TreasureRoom(int x, int y) {
        super(x, y);
    }
    private String[] TREAS_INTRO = {"The whole place is shinning!", "Its filled with Precious metals: gold, silver, platinum,",
            "Also: Gemstones, diamonds, rubies, sapphires, emeralds, etc.", " But you should hurry and pick because there might be traps all around. "};

    public String intro_text(){
        return TREAS_INTRO[(int) (java.lang.Math.random() * TREAS_INTRO.length)];
    }

    public void modify_player(Player player){

    }
}
