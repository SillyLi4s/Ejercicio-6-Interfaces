import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Dashboard {
    private List<Widget> widgets;

    public Dashboard() {
        this.widgets = new ArrayList<>();
        init();
    }

    public void init() {
        agregarWidget(new WeatherWidget("W01", "Clima Guatemala", 120, 24.5, true, enumCiudad.GUATEMALA));
        agregarWidget(new WeatherWidget("W02", "Clima Moscú", 135, -3.0, true, enumCiudad.MOSCOW));
        agregarWidget(new ClockWidget("W03", "Reloj Local", 45));
        agregarWidget(new QuoteWidget("W04", "Frase Ágil", 30, "Hazlo funcionar, hazlo bien, hazlo rápido."));
        
        TaskWidget tareasDev = new TaskWidget("W05", "Ejercicio 6 POO", 210);
        tareasDev.agregarTarea("T1", "Implementar interfaces SOLID");
        tareasDev.agregarTarea("T2", "Conectar vista Swing");
        agregarWidget(tareasDev);

        agregarWidget(new AlertWidget("W06", "Servidor CPU", 180, enumNivel.ALTO, false));
        agregarWidget(new AlertWidget("W07", "Actualización SDK", 95, enumNivel.BAJO, true));
        agregarWidget(new QuoteWidget("W08", "Frase Clean Code", 35, "La simplicidad es la máxima sofisticación."));
        agregarWidget(new ClockWidget("W09", "Reloj Servidor", 50));

        TaskWidget tareasQa = new TaskWidget("W10", "Pruebas Ej6", 190);
        tareasQa.agregarTarea("T3", "Validar ordenamiento por KB");
        agregarWidget(tareasQa);
    }

    public void agregarWidget(Widget widget) {
        if (widget != null) {
            widgets.add(widget);
        }
    }

    // Con instanceof identifica si es interactuable
    public boolean interactuarConWidget(String id) {
        for (Widget w : widgets) {
            if (w.getId().equalsIgnoreCase(id)) {
                if (w instanceof WidgetInteractivo) {
                    ((WidgetInteractivo) w).interactuar();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public List<Widget> buscar(String criterio) {
        if (criterio == null || criterio.isBlank()) {
            return new ArrayList<>(widgets);
        }
        String filtro = criterio.toLowerCase();
        return widgets.stream()
                .filter(w -> w.getId().toLowerCase().contains(filtro) || 
                             w.getNombre().toLowerCase().contains(filtro))
                .collect(Collectors.toList());
    }

    public void ordenarPorConsumo(boolean descendente) {
        if (descendente) {
            widgets.sort(Collections.reverseOrder());
        } else {
            Collections.sort(widgets);
        }
    }

    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }
}