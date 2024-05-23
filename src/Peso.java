public class Peso extends Mejora{
    private String[] nombres = {"Disco 10Kg", "Disco 20Kg", "Disco 50Kg", "Disco 100Kg", "Disco 200Kg", "Coche", "Tractor", "Boeing 747"};
    public Peso() {
        super("Peso", 10);
    }

    @Override
    public int getPrecio() {
        return (int) ((int) (precioBase * (nivel+1)) * (precioBase * (nivel+1)));
    }

    @Override
    public String getNombre() {
        return nombres[nivel];
    }

    public int getCantidadNombres() {
        return nombres.length;
    }

    public int getInclementoClicks() {
        if (nivel == 0) {
            return 1;
        }
        return (nivel * 2) * (nivel * 2);
    }

    @Override
    public double getIncrementoCPS() {
        return nivel * 0;
    }


}
