
package universidad;

// PARCIAL 4

public class Estudiante extends Persona {
    
    private double notas[];
    
    public Estudiante(String nombre, int cedula, double notas[]) {
        super(nombre, cedula);
        this.notas = notas;
    } // fin constructor
    
    @Override
    public double calculo() {
        
        double promedio = 0;
        
        for(int i=0; i<notas.length; i++) {
            promedio += notas[i];
        }
        return(promedio/4);
    } // fin calculo()
    
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        for(int i=0; i<notas.length; i++) {
            System.out.printf("%8.2f", notas[i]);
        }
        System.out.printf("%12.2f\n",calculo());        
    } // fin mostrarDatos()
    
} // fin clase Persona
