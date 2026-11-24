import javax.swing.*;
import java.awt.*;

public class AlertWidget implements Widget, WidgetInteractivo {
    private String id;
    private String nombre;
    private int consumo;
    private enumNivel nivel;
    private boolean esLeida;
    private JLabel lblAlerta;

    public AlertWidget(String id, String nombre, int consumo, enumNivel nivel, boolean esLeida) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.nivel = nivel;
        this.esLeida = esLeida;
    }

    @Override
    public void interactuar() {
        if (!esLeida) {
            esLeida = true;
            if (lblAlerta != null) {
                lblAlerta.setText(formatearAlerta());
            }
        }
    }

    private String formatearAlerta() {
        return "Nivel: " + nivel + " | Estado: " + (esLeida ? "Leída" : "NO LEÍDA");
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(nombre + " (" + consumo + " KB)"));

        lblAlerta = new JLabel(formatearAlerta(), SwingConstants.CENTER);
        JButton btnLeida = new JButton("Marcar como leída");
        btnLeida.addActionListener(e -> interactuar());

        panel.add(lblAlerta, BorderLayout.CENTER);
        panel.add(btnLeida, BorderLayout.SOUTH);
        return panel;
    }

    @Override public String getId() { return id; }
    @Override public String getNombre() { return nombre; }
    @Override public int getConsumo() { return consumo; }
    @Override public boolean esVisible() { return true; }
}