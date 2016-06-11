package propertyshop;

public class Property {
    String nombre;
    String direccion;
    double metrosConst;
    double metrosUtiles;
    String propietario;
    String dirPropietario;
    int precio;
    
    
    /**
     * Guarda el nombre del inmueble, en minúsculas
     * 
     * @author Mª Carmen
     * @param newName 
     */
    public void setName(String newName) {
        nombre = (newName == null) ? null : newName.toLowerCase();
    }
    /**
     * Devuelve el nombre del inmueble guardado
     * @return
     */
    public String getName() {
        return nombre;
    }
    
    /**
     * Guarda la dirección del inmueble, en mayúsculas
     * @param newAddress 
     */
    public void setAddress(String newAddress) {
        direccion = (newAddress == null) ? null : newAddress.toUpperCase();
    }
    /**
     * Devuelve la dirección del inmueble guardada
     * @return 
     */
    public String getAddress() {
        return direccion;
    }
    
    /**
     * Guarda los metros construidos (siempre positivos mayores que 0)
     * Dado que pide que si se introduce un numero negativo o 0, no se actualice el valor,
     * en el main introduzco un do..while para que lea el número de metros introducido mientras
     * no sea estrictamente positivo
     * 
     * @param newConst 
     */
    public void setConstructedSurface(double newConst) {
        if(newConst > 0)
            metrosConst = newConst;
    }
    /**
     * Devuelve el número de metros construidos, estrictamente positivos
     * @return 
     */
    public double getConstructedSurface() {
        return metrosConst;
    }
    
    /**
     * Guarda los metros útiles (positivos mayores que 0)
     * Como en el caso anterior, introduciremos un do..while para controlar que el número
     * sea estrictamente positivo
     * @param newAv 
     */
    public void setAvailableSurface(double newAv) {
        if(newAv > 0)
            metrosUtiles = newAv;
    }
    /**
     * Devuelve el número de metros útiles, estrictamente positivo
     * @return 
     */
    public double getAvailableSurface() {
        return metrosUtiles;
    }
    
    /**
     * Guarda el nombre del propietario del inmueble
     * @param newOwner 
     */
    public void setOwner(String newOwner) {
        propietario = (newOwner == null) ? null : newOwner;
    }
    /**
     * Devuelve el nombre del propietario guardado en el método anterior
     * @return 
     */
    public String getOwner() {
        return propietario;
    }
    
    /**
     * Guarda la dirección del propietario del inmueble
     * @param newOwnerAd 
     */
    public void setOwnerAddress(String newOwnerAd) {
        dirPropietario = (newOwnerAd == null) ? null : newOwnerAd;
    }
    /**
     * Devuelve la dirección guardada del propietario
     * @return 
     */
    public String getOwnerAddress() {
        return dirPropietario;
    }
    
    /**
     * Guarda el precio del inmueble, siempre positivo, por lo que tendremos otro do..while
     * para controlar que no se introduzcan números negativos
     * @param newPrice 
     */
    public void setPrice(int newPrice) {
        if(newPrice > 0)
            precio = newPrice;
    }
    /**
     * Devuelve el precio del inmueble guardado
     * @return 
     */
    public int getPrice() {
        return precio;
    }
}
