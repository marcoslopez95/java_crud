
package Models;

public class Trabajador extends Model{
    String cedula;
    String nombres;
    String cargo;
    String departamento;
    int id_departamento;
    int id_cargo;
    int edad;

    public Trabajador() {
    }

    public Trabajador(String cedula, String nombres, String cargo, String departamento, int id_departamento, int id_cargo, int edad) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.cargo = cargo;
        this.departamento = departamento;
        this.id_departamento = id_departamento;
        this.id_cargo = id_cargo;
        this.edad = edad;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    
    

}
