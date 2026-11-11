public interface Widget {
    String getId();
    String getNombre();
    int getConsumo();

    void recargar();
    void dibujar();
    
    Boolean esVisible();
}
