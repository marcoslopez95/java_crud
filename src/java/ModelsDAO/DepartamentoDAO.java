
package ModelsDAO;

import Config.Conexion;
import Interfaces.Interfaz;
import Models.Departamento;
import Models.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements Interfaz{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Departamento dep = new Departamento();
    
    @Override
    public List index() {
        ArrayList<Departamento>list = new ArrayList<>();
        String sql = "Select * from departamentos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                Departamento dep = new Departamento();
                dep.setId((rs.getInt("id")));
                dep.setNombre(rs.getString("nombre"));
                list.add(dep);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Model show(int id) {
        String sql = "SELECT * FROM departamentos WHERE id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                dep.setId((rs.getInt("id")));
                dep.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        
        return dep;
    }

    public boolean store(Departamento dep) {
        String sql = "INSERT INTO departamentos(nombre)"
                           + "VALUES"
                           + "('"+ dep.getNombre() +"');";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean update(Departamento dep) {
         String sql = "UPDATE departamentos SET "
                          + "nombre='"+ dep.getNombre()+"'"
                          + "where id="+ dep.getId();
        
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
        String sql = "DELETE FROM departamentos WHERE id="+id;
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean store(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(Model model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List getCountAllTrabajadores(){
        System.out.println("algo");
        ArrayList<Departamento>list = new ArrayList<>();
        String sql = "SELECT COUNT(nombres) AS cantidad, nombre FROM departamentos LEFT JOIN trabajadores ON id_departamento=departamentos.id GROUP BY (nombre);";
        try{
                con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setNombre(rs.getString("nombre"));
                departamento.setCantidad(rs.getInt("cantidad"));
                list.add(departamento);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("finalizo");
        return list;
                
    }
    
}
