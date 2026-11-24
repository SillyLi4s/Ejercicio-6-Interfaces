import javax.swing.*;
import java.awt.*;

public class WeatherWidget implements Widget, WidgetInteractivo {
    private String id;
    private String nombre;
    private int consumo;
    private double temp;
    private boolean esCelsius;
    private enumCiudad ciudad;
    private JLabel lblInfo;

    public WeatherWidget(String id, String nombre, int consumo, double temp, boolean esCelsius, enumCiudad ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.temp = temp;
        this.esCelsius = esCelsius;
        this.ciudad = ciudad;
    }

    @Override
    public void interactuar() {
        if (this.esCelsius) {
            this.temp = (this.temp * 9.0 / 5.0) + 32;
            this.esCelsius = false;
        } else {
            this.temp = (this.temp - 32) * 5.0 / 9.0;
            this.esCelsius = true;
        }
        if (lblInfo != null) {
            lblInfo.setText(formatearTexto());
        }
    }

    private String formatearTexto() {
        String unidad = esCelsius ? "°C" : "°F";
        return String.format("%s: %.1f %s", ciudad, temp, unidad);
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createTitledBorder(nombre + " (" + consumo + " KB)"));

        lblInfo = new JLabel(formatearTexto(), SwingConstants.CENTER);
        JButton btnCambiar = new JButton("Cambiar °C / °F");
        btnCambiar.addActionListener(e -> interactuar());

        panel.add(lblInfo, BorderLayout.CENTER);
        panel.add(btnCambiar, BorderLayout.SOUTH);
        return panel;
    }

    @Override public String getId() { return id; }
    @Override public String getNombre() { return nombre; }
    @Override public int getConsumo() { return consumo; }
    @Override public boolean esVisible() { return true; }
}