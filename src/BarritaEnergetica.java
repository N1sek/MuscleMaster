public class BarritaEnergetica extends Mejora {
    public BarritaEnergetica() {
        super("Barrita Energetica", 10);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 20.5;
    }
}
