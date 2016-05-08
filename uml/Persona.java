package veterinario;

import java.util.ArrayList;

public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    // Creamos un array para conocer con qué clientes está asociada la Persona
    private ArrayList clientes = new ArrayList();
    
    public Persona(){
    }
    
    public Persona(String aNombre, String aPellidos, String aDni){
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getDni(){
        return dni;
    }
    
    // Método para añadir las familias asociadas con la Persona
    public void addFamilia(Familia cliente){
    }
    
    // Método para eliminar una familia que ya no está asociada con las Persona
    // Pasamos el parámetro de la posición del array que deseamos eliminar
    public void removeFamilia(int index){
    }
    
}
    
    
