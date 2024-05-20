import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;


public class Juego {
    private Click click;
    private double realValue;
    private Timer timer;
    private boolean timerOn = false;
    private int timerSpeed = 1000;
    private Timer ticks;
    private List<Mejora> mejoras;
    private VentanaPrincipal ui; // Referencia a la UI

    public Juego(VentanaPrincipal ui) {
        this.ui = ui;
        click = new Click();
        mejoras = new ArrayList<>();
        mejoras.add(new BarritaEnergetica());
        mejoras.add(new BatidoProteico());
        mejoras.add(new Creatina());
        mejoras.add(new Testosterona());
        setTicksTimer();
    }

    public Click getClick() {
        return click;
    }

    public double getRealValue() {
        return realValue;
    }

    public void setRealValue(double realValue) {
        this.realValue = realValue;
    }

    public void incrementarValorReal(double valor) {
        realValue += valor;
        ui.actualizarContador(realValue);
    }

    public List<Mejora> getMejoras() {
        return mejoras;
    }

    public void setTicksTimer() {
        ticks = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Mejora mejora : mejoras) {
                    if (realValue >= mejora.getPrecio()) {
                        ui.activarBotonMejora(mejora);
                    } else {
                        ui.desactivarBotonMejora(mejora);
                    }
                    ui.actualizarPrecioYNivelMejora(mejora); // Actualizar UI con los precios y niveles de mejoras
                }
            }
        });
        ticks.start();
    }

    public void setTimer() {
        timer = new Timer(timerSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realValue += click.getClickValue();
                // Actualizar UI del contador
                ui.actualizarContador((int) realValue);
            }
        });
    }

    public void timerUpdate() {
        if (click.getCps() != 0) {
            if (!timerOn) {
                timerOn = true;
            } else {
                timer.stop();
            }
            timerSpeed = (int) Math.round(1 / click.getCps() * 1000);
            setTimer();
            timer.start();
        } else {
            timer.stop();
            timerOn = false;
        }
    }

    public void actualizarCPS() {
        double mult = 0;
        for (Mejora mejora : mejoras) {
            mult += mejora.getIncrementoCPS();
        }
        click.setCps(mult);
        // Actualizar UI de CPS
        ui.actualizarCPS(click.getCps());
        timerUpdate();
    }

    public void comprarMejora(Mejora mejora) {
        if (realValue >= mejora.getPrecio()) {
            realValue -= mejora.getPrecio();
            mejora.incrementarNivel();
            actualizarCPS();
            // Desactivar botón de mejora
            ui.desactivarBotonMejora(mejora);
            // Actualizar contador
            ui.actualizarContador(realValue);
        }
    }
}
