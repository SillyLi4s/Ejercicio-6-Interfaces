import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClockWidget implements Widget {
    private String id;
    private String nombre;
    private int consumo;

    public ClockWidget(String id, String nombre, int consumo) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(nombre + " (" + consumo + " KB)"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        JLabel lblHora = new JLabel("Hora: " + LocalTime.now().format(dtf), SwingConstants.CENTER);
        
        // Timer de Swing para actualizar en tiempo real sin congelar la ventana
        new Timer(1000, e -> lblHora.setText("Hora: " + LocalTime.now().format(dtf))).start();

        panel.add(lblHora, BorderLayout.CENTER);
        return panel;
    }

    @Override public String getId() { return id; }
    @Override public String getNombre() { return nombre; }
    @Override public int getConsumo() { return consumo; }
    @Override public boolean esVisible() { return true; }
}