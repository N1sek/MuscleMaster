public abstract class Mejora {
    protected String nombre;
    protected int nivel;
    protected double precioBase;

    public Mejora(String nombre, double precioBase) {
        this.nombre = nombre;
        this.nivel = 0;
        this.precioBase = precioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void incrementarNivel() {
        nivel++;
    }

    public int getPrecio() {
        return (int) precioBase * (nivel + 1);
    }

    public abstract double getIncrementoCPS();
}

