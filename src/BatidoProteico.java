public class BatidoProteico extends Mejora {
    public BatidoProteico() {
        super("Batido Proteico", 100);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 0.5;
    }
}
