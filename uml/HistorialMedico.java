package veterinario;

import java.util.Date;

public class HistorialMedico {
    private Date fecha;
    private Animal mascota;
    private Enfermedad enfermedad;
    
    public HistorialMedico(){
    }
    
    public HistorialMedico(Date aFecha, Animal aMascota, Enfermedad aEnfermedad){
    }
    
    public Date getFecha(){
        return fecha;
    }
    public Animal getMascota(){
        return mascota;
    }
    public Enfermedad getEnfermedad(){
        return enfermedad;
    }
}
