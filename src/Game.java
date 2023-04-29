import  java.io.*;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Scanner;
public class Game {

    public static void main(String[] args) throws IOException{
        World world = new World();
        world.load_tiles();
        Scanner input = new Scanner(System.in);
        String playerName= "Mortal Explorer";
        Player player = new Player(playerName);
        MapTile room = World.tile_exists(player.location_x, player.location_y);
        if(room != null)
        {
            System.out.print(room.intro_text());
            while ((player.IsAlive()) && (!player.victory)){
                room = World.tile_exists(player.location_x, player.location_y);
                System.out.println(room.intro_text());
                room.modify_player(player);
                if ((player.IsAlive()) && (!player.victory)){
                    System.out.print(" Please choose action:\n");
                    ArrayList<Action> available_actions = room.available_actions();
                    for (Action action:available_actions){
                        System.out.print(action.getHotkey() +" : " + action.getName()+"\n");
                    }
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Put Your Action: ");
                    char action_input = in.readLine().charAt(0);

                    for (Action action:available_actions){
                        if (action_input == action.getHotkey()){
                            player.do_action(action, action.getKwargs(),room);
                            break;
                        }
                    }
                }
                else{
                    System.out.println("\n \t The End!!!");
                    player.writeToFile();
                }
            }
        }
    }

}
