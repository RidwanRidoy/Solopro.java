public class Zombie extends Enemy {

    private int speed;

    public Zombie(int speed){
        super("Zombie", 12, 6);
        this.speed = speed;
    }
}
