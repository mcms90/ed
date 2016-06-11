package crewmanagement;

public class Employee {
    
    final int MAX_TURNS = 7;    
    String name;
    String surname;
    String dni;
    Turn[] turns = new Turn[MAX_TURNS];
    int turnCount = 0;
    
    /**
     * Constructor por defecto
     * @author Mª Carmen
     */
    public Employee(){
       // this(null,null,null);
    }
    
    /**
     * Constructor que guarda el valor de las variables nombre y apellidos
     * introducidas
     * @param aName
     * @param aSurname 
     */
    public Employee(String aName, String aSurname){
        this(null,aName,aSurname);
    }
    
    /**
     * Constructor que guarda el valor de las 3 variables introducidas:
     * dni, nombre y apellidos
     * @param aDNI
     * @param aName
     * @param aSurname 
     */
    public Employee(String aDNI, String aName, String aSurname){
        setDNI(aDNI);
	name = aName;
	surname = aSurname;
    }
    
    /**
     * Guarda el valor del nombre del empleado
     * @param aName 
     */
    public void setName(String aName){
        name = aName;
    }
    
    /**
     * Devuelve el valor de la variable nombre
     * @return 
     */
    public String getName(){
        return name;
    }
    
    /**
     * Guarda los apellidos del empleado
     * @param aSurname 
     */
    public void setSurname(String aSurname){
        surname = aSurname;
    }
    
    /**
     * Devuelve el valor de la variable apellidos
     * @return 
     */
    public String getSurname(){
        return surname;
    }
	
    /**
     * Devuelve el valor del nombre del empleado, en mayúsculas si es distinto de null y 
     * el parámetro introducido es true
     * @param upperCase
     * @return 
     */
    String getSafeName(boolean upperCase) {
	return (name != null) ? (upperCase ? name.toUpperCase() : name) : "";
    }
    
    /**
     * Devuelve el valor de los apellidos del empleado, en mayúsculas si es distinto
     * de null y el parámetro introducido es true
     * @param upperCase
     * @return 
     */
    String getSafeSurname(boolean upperCase){
        return (surname != null) ? (upperCase ? surname.toUpperCase() : surname) : "";
    }
    
    /**
     * Devuelve el nombre completo del empleado
     * @param nameInUpperCase
     * @param surnameInUpperCase
     * @return 
     */
    public String getFullName(boolean nameInUpperCase, boolean surnameInUpperCase){
	if (name == null && surname == null)
            return "";
        
        String separator = (name == null || surname == null) ? "" : ", ";
	return getSafeName(nameInUpperCase) + separator + getSafeSurname(surnameInUpperCase);
    }
    
    /**
     * Comprueba si el DNI introducido es correcto o no
     * @param aDNI
     * @return 
     */
    public boolean comprobarDNI(String aDNI){
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        int modulo;
        int dniSinLetra;
        char letraDni;
        String num;

        if(aDNI.length() != 9)
            return false;

        num = aDNI.substring(0,8);
      
        dniSinLetra = Integer.parseInt(num);
        
        modulo = dniSinLetra % 23;
        letraDni = letrasDNI.charAt(modulo);
        
        return letraDni == aDNI.toUpperCase().charAt(8);
    }
    
    /**
     * Guarda el valor del DNI de el empleado
     * Si no es correcto, no guarda nada
     * @param aDNI 
     */
    public void setDNI(String aDNI){  
        dni = (aDNI == null) ? null : (comprobarDNI(aDNI) ? aDNI : dni);
    }
    
    /**
     * Devuelve el valor de la variable DNI
     * @return 
     */
    public String getDNI(){
        return dni;
    }
    
    /**
     * Añade un turno al empleado, siempre que el número de turnos sea menor de 7
     * y el parámetro introducido no sea null
     * @param aTurn 
     */
    public void addTurn(Turn aTurn){
        if(turnCount < MAX_TURNS && aTurn != null){
            turns[turnCount] = aTurn;
            turnCount++;
        }
    }
    
    /**
     * Busca la posición en el array de Turnos donde se encuentran los turnos
     * del día que se quieren borrar
     * @param aDay
     * @return 
     */
    int findTurnPosition(String aDay){
        for(int i=0; i < turnCount; i++){
            if(turns[i].day.equalsIgnoreCase(aDay))
                return i;
        }
        return -1; 
    }
    
    /**
     * Borra los turnos del empleado asignados al día que se introduzca como
     * parámetro
     * @param aDay 
     */
    public void removeTurn(String aDay){
        int index = findTurnPosition(aDay);
        
        if(index >= 0){
            for(int i = index; i < turnCount-1; i++){
                turns[i] = turns[i+1];
            }
            turns[turnCount-1] = null;
            turnCount--;
        }
    }
    
    /**
     * Devuelve el número de turnos que tiene el empleado
     * @return 
     */
    public int getTurnCount(){
        return turnCount;
    }
    
    /**
     * 
     * @param anIndex
     * @return 
     */
    public Turn getTurnAt(int anIndex){
        if(turnCount > 0){
            if(anIndex >= 0 && anIndex < turnCount)
                return (turns[anIndex] == null) ? null : turns[anIndex];
        }
        
        return null;
    }
    
    /**
     * Devuelve un array con los turnos que tiene asignados el empleado
     * @return 
     */
    public Turn[] getTurns(){
        if(turnCount == 0)
            return null;
        else{	
            Turn[] temp = new Turn[turnCount];
            
            for(int i = 0; i < turnCount; i++){
                temp[i] = turns[i];
            }
            return temp;
        }
    }
}
