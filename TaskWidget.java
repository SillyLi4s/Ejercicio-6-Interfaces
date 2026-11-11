import java.util.List;
import java.util.ArrayList;

public class TaskWidget implements Widget{
    private String Id;
    private String nombre;
    private int consumo;
    private List<Tarea> tarea;

    public TaskWidget(String Id, String nombre, int consumo){
        this.Id = Id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.tarea = new ArrayList<>();
    }

    public void agregarTarea(String id, String descripcion){
        Tarea nuevaTarea = new Tarea(id, descripcion);
        tarea.add(nuevaTarea);
    }

    public void completarTarea(String id){
        for(Tarea t : tarea){
            if(t.getId().equals(id)){
                t.marcarCompletada();
                break;
            }
        }
    }

    public String getId(){
        return Id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getConsumo(){
        return consumo;
    }

    public void recargar(){
        tarea.removeIf(Tarea::esCompletada); // Elimina las completadas
    }
    public void dibujar(){}
    
    public Boolean esVisible(){
        return true;
    }

}
