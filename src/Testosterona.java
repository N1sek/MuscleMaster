public class Testosterona extends Mejora{
    public Testosterona() {
        super("Testosterona", 10000);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 4;
    }
}
