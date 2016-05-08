package veterinario;

import java.util.ArrayList;
import java.util.Date;

public class Animal {
    private String codigo;
    private String alias;
    private String especie;
    private String raza;
    private String colorPelo;
    private Date fechaNac;
    private double pesoActual;
    // Array con los pesos de las 10 últimas visitas
    private double[] pesos = new double[10];
    private double pesoMedio;
    private Familia cliente;
    private ArrayList<HistorialMedico> historiales = new ArrayList<HistorialMedico>();
    private CalendarioVacunacion calendario;
    
    public Animal(){
    }
    public Animal(String aCodigo, String aAlias, String aEspecie, String aRaza, String aColorPelo, Date aFechaNac, double aPesoActual, Familia aCliente){
    }
    
    public String getCodigo(){
        return codigo;
    }
    public String getAlias(){
        return alias;
    }
    public String getEspecie(){
        return especie;
    }
    public String getRaza(){
        return raza;
    }
    public String getColorPelo(){
        return colorPelo;
    }
    public Date getFechaNac(){
        return fechaNac;
    }
    public void setPesoActual(double aPeso){
    }
    public double getPesoActual(){
        return pesoActual;
    }
    public double getPesoMedio(){
        return pesoMedio;
    }
    public Familia getFamilia(){
        return cliente;
    }
    public CalendarioVacunacion getCalendario(){
        return calendario;
    }
    
    public void addNuevoPeso(double peso){
    }
    
    public void calcularPesoMedio(){
    }
    
    public void addHistorialMedico(HistorialMedico aHistorial){
    }
}
