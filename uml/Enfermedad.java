package veterinario;

import java.util.ArrayList;

public class Enfermedad {
    private String nombre;
    private String descripcion;
    private ArrayList<HistorialMedico> historiales = new ArrayList<HistorialMedico>();
    private ArrayList<CalendarioVacunacion> calendarios = new ArrayList<CalendarioVacunacion>();
    
    public Enfermedad(){
    }
    
    public Enfermedad(String aNombre, String aDescripcion){
    }
    
    public String getNombre(){
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    public void addHistorialMedico(HistorialMedico historial){
    }
    
    public void addCalendarioVacunacion(CalendarioVacunacion calendario){
    }
}
