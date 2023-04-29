public class Gold extends Item{

    protected int amt;

    public Gold(int amt){
        super("Biscuit Gold", String.format("It's shape like rectangle with a number in the middle.", (amt)), amt);
        this.amt = amt;
    }
}
