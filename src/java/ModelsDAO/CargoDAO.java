
package ModelsDAO;

import Config.Conexion;
import Interfaces.Interfaz;
import Models.Cargo;
import Models.Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO implements Interfaz{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cargo cargo = new Cargo();
    
    @Override
    public List index() {
        ArrayList<Cargo>list = new ArrayList<>();
        String sql = "Select * from cargos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId((rs.getInt("id")));
                cargo.setNombre(rs.getString("nombre"));
                list.add(cargo);
            }
        } catch (Exception e) {
        }
        
        return list;
    }

    @Override
    public Model show(int id) {
        String sql = "SELECT * FROM cargos WHERE id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                cargo.setId((rs.getInt("id")));
                cargo.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        
        return cargo;
    }

    public boolean store(Cargo cargo) {
        String sql = "INSERT INTO cargos(nombre)"
                           + "VALUES"
                           + "('"+ cargo.getNombre() +"');";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    public boolean update(Cargo cargo) {
         String sql = "UPDATE cargos SET nombre='"+ cargo.getNombre()+"' where id="+ cargo.getId();
        
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
        String sql = "DELETE FROM cargos WHERE id="+id;
        
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
        ArrayList<Cargo>list = new ArrayList<>();
        String sql = "SELECT COUNT(nombres) AS cantidad, nombre FROM cargos LEFT JOIN trabajadores ON id_cargo=cargos.id GROUP BY (nombre);";
        try{
                con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setNombre(rs.getString("nombre"));
                cargo.setCantidad(rs.getInt("cantidad"));
                list.add(cargo);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("finalizo");
        return list;
                
    }
    
    public boolean Exists(String nombre){
         String sql = "SELECT * FROM cargos WHERE nombre ILIKE '%"+nombre+"%'";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
             
            while (rs.next()) {
                cargo.setId((rs.getInt("id")));
                cargo.setNombre(rs.getString("nombre"));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
        
        
    }
    
}
