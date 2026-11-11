public class AlertWidget implements Widget {
    private String id;
    private String nombre;
    private int consumo;
    private enumNivel nivel;
    private Boolean esLeida;

    AlertWidget(String id, String nombre, int consumo, enumNivel nivel, Boolean esLeida) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.nivel = nivel;
        this.esLeida = esLeida;
    }

    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getConsumo() {
        return consumo;
    }
    public enumNivel getNivel() {
        return nivel;
    }

    public void recargar() {}
    public void dibujar() {}
    public Boolean esVisible() {
        return true;
    }

    public Boolean marcarComoLeida() {
        if (!esLeida) {
            esLeida = true;
            return true;
        }
        return false;
    }    
}
