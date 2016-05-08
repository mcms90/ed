package veterinario;

import java.util.ArrayList;
import java.util.Date;

public class CalendarioVacunacion {
    private Animal mascota;
    private ArrayList<Date> fechasVacunacion = new ArrayList<Date>();
    private ArrayList<Enfermedad> enfermedades = new ArrayList<Enfermedad>();
    
    public CalendarioVacunacion(){
    }
    
    public CalendarioVacunacion(Animal mascota){
    }
    
    public Animal getMascota(){
        return mascota;
    }
    
    public void addFechaVacunacion(Date aFecha){
    }
    
    public void addEnfermedad(Enfermedad aEnfermedad){
    }
    
}
