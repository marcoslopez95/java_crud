
package ModelsDAO;

import Config.Conexion;
import Interfaces.Interfaz;
import Models.Trabajador;
import Models.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO implements Interfaz{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Trabajador trabajador = new Trabajador();
    
    @Override
    public List index() {
        ArrayList<Trabajador>list = new ArrayList<>();
        String sql = "SELECT trabajadores.*, "
                            + "departamentos.nombre as nombre_departamento, "
                            + "cargos.nombre as nombre_cargo "
                            + "FROM trabajadores "
                            + "INNER JOIN departamentos "
                                + "ON id_departamento=departamentos.id"
                            + " INNER JOIN cargos "
                                + "ON id_cargo=cargos.id;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                Trabajador trab = new Trabajador();
                trab.setId((rs.getInt("id")));
                trab.setCedula(rs.getString("cedula"));
                trab.setNombres(rs.getString("nombres"));
                trab.setDepartamento(rs.getString("nombre_departamento"));
                trab.setCargo(rs.getString("nombre_cargo"));
                trab.setEdad((rs.getInt("edad")));
                trab.setId_departamento((rs.getInt("id_departamento")));
                trab.setId_cargo((rs.getInt("id_cargo")));
                list.add(trab);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Model show(int id) {
         String sql = "SELECT trabajadores.* "
                            + "FROM trabajadores"
                            + " WHERE id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                trabajador.setId((rs.getInt("id")));
                trabajador.setCedula(rs.getString("cedula"));
                trabajador.setNombres(rs.getString("nombres"));
                trabajador.setEdad((rs.getInt("edad")));
                trabajador.setId_departamento((rs.getInt("id_departamento")));
                trabajador.setId_cargo((rs.getInt("id_cargo")));
            }
        } catch (Exception e) {
        }
        
        return trabajador;
    }

    public boolean store(Trabajador trabajador) {
        String sql = "INSERT INTO trabajadores(cedula,nombres,edad,id_departamento,id_cargo) "
                           + "VALUES "
                           + "("
                                + "'"+ trabajador.getCedula()+"',"
                                + "'"+ trabajador.getNombres() +"',"
                                + trabajador.getEdad()+","
                                + trabajador.getId_departamento()+","
                                + trabajador.getId_cargo()
                            + ");";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean update(Trabajador trabajador) {
          String sql = "UPDATE trabajadores SET "
                            +"cedula="+ "'"+ trabajador.getCedula()+"',"
                            +"nombres="+ "'"+ trabajador.getNombres() +"',"
                            +"edad="+ trabajador.getEdad()+","
                            +"id_departamento="+ trabajador.getId_departamento()+","
                            +"id_cargo="+ trabajador.getId_cargo()+" "
                            +"WHERE id="+ trabajador.getId()
                             ;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM Trabajadors WHERE id="+id;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    public List getCountAllNames(){
        System.out.println("algo");
        ArrayList<Trabajador>list = new ArrayList<>();
        String sql = "SELECT COUNT(*) AS cantidad, nombres FROM trabajadores GROUP BY (nombres);";
        try{
                con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Trabajador trab = new Trabajador();
                trab.setNombres(rs.getString("nombres"));
                trab.setCantidad(rs.getInt("cantidad"));
                list.add(trab);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("finalizo");
        return list;
                
    }

    @Override
    public boolean store(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
