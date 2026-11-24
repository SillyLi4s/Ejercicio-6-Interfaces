import javax.swing.JComponent;

public interface Widget extends Comparable<Widget> {
    String getId();
    String getNombre();
    int getConsumo();
    boolean esVisible();
    
    //construye y retorna su propio panel visual
    JComponent obtenerVista();

    // ordenar mayor consumo a menor
    @Override
    default int compareTo(Widget otro) {
        return Integer.compare(this.getConsumo(), otro.getConsumo());
    }
}