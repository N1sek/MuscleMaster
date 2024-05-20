public class Testosterona extends Mejora{
    public Testosterona() {
        super("Testosterona", 200);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 3;
    }
}
