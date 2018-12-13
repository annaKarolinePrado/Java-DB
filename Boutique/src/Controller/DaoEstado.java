
package Controller;

import Model.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoEstado extends Dao {
    
    public Estado getEstado(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM estados WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Estado> getEstadoList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM estados ORDER BY nome");
        LinkedList<Estado> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Estado> getEstadoList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM estados WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Estado> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Estado populateObject(ResultSet rs) throws SQLException{
        return (new Estado(rs.getInt("id"), rs.getString("nome"), rs.getString("sigla")));
    }
}
