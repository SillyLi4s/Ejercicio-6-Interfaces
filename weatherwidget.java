public class weatherwidget implements Widget {
    private String Id;
    private String nombre;
    private int consumo;
    private double temp;
    private boolean esCelsius;
    private enumCiudad ciudad;

    public weatherwidget(String Id, String nombre, int consumo, double temp, boolean esCelsius, enumCiudad ciudad){
        this.Id = Id;
        this.nombre = nombre;
        this.consumo = consumo;
        this.temp = temp;
        this.esCelsius = esCelsius;
        this.ciudad = ciudad;
    }

    public void recargar(){}
    public void dibujar(){}
    public Boolean esVisible(){
        return true;
    }

    public void cambiartemp(double temp, boolean esCelsius){
        // Cambia de Celsius a Fahrenheit o viceversa
        if(this.esCelsius != esCelsius){
            if(esCelsius){
                this.temp = (temp - 32) * 5/9; // Convertir a Celsius
            } else {
                this.temp = (temp * 9/5) + 32; // Convertir a Fahrenheit
            }
            this.esCelsius = esCelsius;
        } else {
            this.temp = temp;
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
    public double getTemp(){
        return temp;
    }
    public enumCiudad getCiudad(){
        return ciudad;
    }
    
}
