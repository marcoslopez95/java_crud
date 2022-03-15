
package Interfaces;

import Models.Model;
import java.util.List;

public interface Interfaz {
    public List index();
    public Model show(int id);
    public boolean store(Model mod);
    public boolean update(Model mod);
    public boolean delete(int id);
}