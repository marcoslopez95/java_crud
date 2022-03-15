
package Models;

public class Trabajador extends Model{
    String cedula;
    String nombres;
    int id_departamento;
    int id_cargo;
    int edad;

    public Trabajador() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Trabajador(String cedula, String nombres, int id_departamento, int id_cargo, int edad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.id_departamento = id_departamento;
        this.id_cargo = id_cargo;
        this.edad = edad;
    }

}
