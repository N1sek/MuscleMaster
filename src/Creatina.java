public class Creatina extends Mejora{

    public Creatina() {
        super("Creatina", 50);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 2;
    }
}
