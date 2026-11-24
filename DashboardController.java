public class DashboardController {
    private Dashboard modelo;
    private DashboardView vista;

    public DashboardController(Dashboard modelo, DashboardView vista) {
        this.modelo = modelo;
        this.vista = vista;
        inicializarEventos();
        vista.renderizarWidgets(modelo.getWidgets());
    }

    private void inicializarEventos() {
        vista.getBtnBuscar().addActionListener(e -> {
            String criterio = vista.getTextoBusqueda();
            vista.renderizarWidgets(modelo.buscar(criterio));
        });

        vista.getBtnOrdenarMayorMenor().addActionListener(e -> {
            modelo.ordenarPorConsumo(true);
            vista.renderizarWidgets(modelo.getWidgets());
        });

        vista.getBtnMostrarTodos().addActionListener(e -> {
            vista.renderizarWidgets(modelo.getWidgets());
        });
    }
}