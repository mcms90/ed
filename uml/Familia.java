package veterinario;

import java.util.ArrayList;

public class Familia {
    private String codigo;
    private String apellido;
    private int cuentaBancaria;
    private String direccion;
    private int telefono;
    // Array de las personas que componen cada Familia
    private ArrayList<Persona> personas = new ArrayList<Persona>();
    // Array de las mascotas que tiene cada Familia
    private ArrayList<Animal> mascotas = new ArrayList<Animal>();
    private Aplicacion aplicacion;
    
    public Familia (){
    }
    
    public Familia(String aCodigo, String aApellido, int aCuentaBancaria, String aDireccion, int aTelefono){
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setCuentaBancaria(int aCuentaBancaria){
    }
    public int getCuentaBancaria(){
        return cuentaBancaria;
    }
    
    public void setDireccion(String aDireccion){
    }
    public String getDireccion(){
        return direccion;
    }
    
    public void setTelefono(int aTelefono){
    }
    public int getTelefono(){
        return telefono;
    }
    
    // Método para añadir una Persona a la Familia
    public void addPersona(Persona aPersona){
    }
    // Método para eliminar una Persona de la Familia
    // Necesitamos saber la posición
    public void removePersona(int index){
    }
    
    // Método para añadir una mascota a la Familia
    public void addMascota(Animal mascota){
    }
    // Método para eliminar una mascota de la Familia
    // Necesitamos saber la posición
    public void removeMascota(int index){
    }
}
