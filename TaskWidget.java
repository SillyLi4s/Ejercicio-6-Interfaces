import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TaskWidget implements Widget, WidgetInteractivo {
    private String id;
    private String nombre;
    private int consumo;
    private List<Tarea> tareas;
    private JPanel panelListaTareas;

    public TaskWidget(String id, String nombre, int consumo) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.tareas = new ArrayList<>();
    }

    public void agregarTarea(String idTarea, String descripcion) {
        tareas.add(new Tarea(idTarea, descripcion));
    }

    @Override
    public void interactuar() {
        for (Tarea t : tareas) {
            if (!t.esCompletada()) {
                t.marcarCompletada();
                break;
            }
        }
        actualizarVistaTareas();
    }

    private void actualizarVistaTareas() {
        if (panelListaTareas != null) {
            panelListaTareas.removeAll();
            for (Tarea t : tareas) {
                panelListaTareas.add(crearFilaTarea(t));
            }
            panelListaTareas.revalidate();
            panelListaTareas.repaint();
        }
    }

    private JPanel crearFilaTarea(Tarea t) {
        JPanel fila = new JPanel(new BorderLayout(5, 0));
        fila.setOpaque(false);

        // Estilo: [id] [descripcion]
        String estadoTexto = t.esCompletada() ? " (Completada)" : "";
        JLabel lblInfo = new JLabel("[" + t.getId() + "] " + t.getDescripcion() + estadoTexto);
        if (t.esCompletada()) {
            lblInfo.setForeground(Color.GRAY);
        }

        // Botón: [botón marcar completada]
        JButton btnMarcar = new JButton(t.esCompletada() ? "Completada" : "Marcar completada");
        btnMarcar.setEnabled(!t.esCompletada());
        btnMarcar.addActionListener(e -> {
            t.marcarCompletada();
            actualizarVistaTareas();
        });

        fila.add(lblInfo, BorderLayout.CENTER);
        fila.add(btnMarcar, BorderLayout.EAST);
        return fila;
    }

    @Override
    public JComponent obtenerVista() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(5, 5));
        panelPrincipal.setBorder(BorderFactory.createTitledBorder(nombre + " (" + consumo + " KB)"));

        panelListaTareas = new JPanel();
        panelListaTareas.setLayout(new BoxLayout(panelListaTareas, BoxLayout.Y_AXIS));

        for (Tarea t : tareas) {
            panelListaTareas.add(crearFilaTarea(t));
        }

        JScrollPane scrollPane = new JScrollPane(panelListaTareas);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        return panelPrincipal;
    }

    @Override public String getId() { return id; }
    @Override public String getNombre() { return nombre; }
    @Override public int getConsumo() { return consumo; }
    @Override public boolean esVisible() { return true; }
}