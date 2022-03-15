
package Models;


public class Departamento extends Model{

    String nombre;

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public Departamento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
