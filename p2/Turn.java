package crewmanagement;

public class Turn {
    String day;
    int initH;
    int finH;
       
    /**
     * Constructor por defecto
     * @author Mª Carmen
     */
    public Turn(){
      //  this(null,0,0);
    }
    
    /**
     * Constructor sobrecargado que guarda el día de la semana intriducido
     * @param aDay 
     */
    public Turn(String aDay){
        this(aDay,0,0);
    }
    
    /**
     * Constructor sobrecargado que guarda el día y la hora de inicio y finalización del turno
     * introducidos como parámetros
     * @param aDay
     * @param aInitHour
     * @param aFinishHour 
     */
    public Turn(String aDay, int aInitHour, int aFinishHour){
        setDay(aDay);
        setInitHour(aInitHour);
        setFinishHour(aFinishHour);
    }
    
    /**
     * Guarda el día de la semana, en mayúsculas si no es null
     * @param aDay 
     */
    public void setDay(String aDay){
        day = (aDay == null) ? null : aDay.toUpperCase();
    }
    
    /**
     * Devuelve el valor de la variable dia
     * @return 
     */
    public String getDay(){
        return day;
    }
    
    /**
     * Guarda el valor de la hora de inicio del turno, solo en el caso en que
     * el valor dado esté entre los valores permitidos
     * @param aInitHour 
     */
    public void setInitHour(int aInitHour){
        if(aInitHour >= 0 && aInitHour <= 23)
            initH = aInitHour;
    }
    
    /**
     * Devuelve el valor de la hora de inicio
     * @return 
     */
    public int getInitHour(){
        return initH;
    }
    
    /**
     * Guarda el valor de la hora de finalización del turno, solo en el caso 
     * en que el valor dado esté entre los valores permitidos
     * @param aFinishHour 
     */
    public void setFinishHour(int aFinishHour){
        if(aFinishHour >= 0 && aFinishHour <= 23)
            finH = aFinishHour;
    }
    
    /**
     * Devuelve el valor de la hora de finalización
     * @return 
     */
    public int getFinishHour(){
        return finH;
    }
}

