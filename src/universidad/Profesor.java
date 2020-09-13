
package universidad;

// PARCIAL 4

public class Profesor extends Persona {
    
    private String asignatura;
    private double horasDesignadas;
    private int tipoDedicacion;
    
    public Profesor(String nombre, int cedula, String asignatura, double horasDesignadas, int tipoDedicacion) {
        super(nombre, cedula);
        this.asignatura      = asignatura;
        this.horasDesignadas = horasDesignadas;
        this.tipoDedicacion  = tipoDedicacion;
    } // fin constructor
    
    @Override
    public double calculo() {  
        
        double sueldo = 0;      
        
        if(tipoDedicacion == 1) {
            sueldo = horasDesignadas * Tipo.CONTRATADO;
        }else{
            sueldo = horasDesignadas * Tipo.FIJO;
        }        
        return(sueldo);
    } // fin calculo()
    
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.printf("%10s %15.2f\n",asignatura, calculo());
    } // fin mostrarDatos()
    
} // fin clase Profesor
