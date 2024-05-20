public class Creatina extends Mejora{

    public Creatina() {
        super("Creatina", 1000);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 2;
    }
}
