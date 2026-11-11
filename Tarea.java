public class Tarea {
    private String id;
    private String descripcion;
    private boolean completada = false;

    public Tarea(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public boolean esCompletada() {
        return completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }
    public void marcarIncompleta() {
        this.completada = false;
    }
}
