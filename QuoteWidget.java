import javax.swing.*;
import java.awt.*;

public class QuoteWidget implements Widget {
    private String id;
    private String nombre;
    private int consumo;
    private String frase;

    public QuoteWidget(String id, String nombre, int consumo, String frase) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.frase = frase;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(nombre + " (" + consumo + " KB)"));

        JLabel lblFrase = new JLabel("<html><center>\"" + frase + "\"</center></html>", SwingConstants.CENTER);
        panel.add(lblFrase, BorderLayout.CENTER);
        return panel;
    }

    @Override public String getId() { return id; }
    @Override public String getNombre() { return nombre; }
    @Override public int getConsumo() { return consumo; }
    @Override public boolean esVisible() { return true; }
}