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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println("reloj:");
        while (true) {
            // Obtenemos la hora actual
            LocalTime horaActual = LocalTime.now();
            
            // Imprimimos la hora formateada (\r sobrescribe la línea anterior)
            System.out.print("\rHora actual: " + horaActual.format(dtf));

            try {
                // Pausamos el programa durante 1000 milisegundos (1 segundo)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("\nEl reloj fue interrumpido.");
                break;
            }
        }
    }    

    public Boolean esVisible(){
        return true;
    }
}
