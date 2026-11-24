import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DashboardView extends JFrame {
    private JPanel panelCuadricula;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    private JButton btnOrdenarMayorMenor;
    private JButton btnMostrarTodos;

    public DashboardView() {
        setTitle("Panel de Control Modular - Dashboard");
        setSize(950, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel barraSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        barraSuperior.add(new JLabel("Buscar (ID o Nombre):"));
        txtBuscar = new JTextField(15);
        btnBuscar = new JButton("Buscar");
        btnOrdenarMayorMenor = new JButton("Ordenar KB (Mayor a Menor)");
        btnMostrarTodos = new JButton("Listar Todos");

        barraSuperior.add(txtBuscar);
        barraSuperior.add(btnBuscar);
        barraSuperior.add(btnOrdenarMayorMenor);
        barraSuperior.add(btnMostrarTodos);

        add(barraSuperior, BorderLayout.NORTH);

        panelCuadricula = new JPanel(new GridLayout(0, 3, 10, 10));
        panelCuadricula.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(panelCuadricula), BorderLayout.CENTER);
    }

    public void renderizarWidgets(List<Widget> widgets) {
        panelCuadricula.removeAll();
        for (Widget w : widgets) {
            if (w.esVisible()) {
                panelCuadricula.add(w.obtenerVista());
            }
        }
        panelCuadricula.revalidate();
        panelCuadricula.repaint();
    }

    public String getTextoBusqueda() { return txtBuscar.getText(); }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JButton getBtnOrdenarMayorMenor() { return btnOrdenarMayorMenor; }
    public JButton getBtnMostrarTodos() { return btnMostrarTodos; }
}