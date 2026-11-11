public class QuoteWidget implements Widget {
    private String id;
    private String nombre;
    private int consumo;
    private String frase;

    public QuoteWidget(String id, String nombre, int consumo, String frase) {
        this.id = id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.frase = frase;
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

    public void recargar(){}
    public void dibujar(){
        System.out.println("Cita: " + frase);
    }    

    public Boolean esVisible(){
        return true;
    }
    
}
