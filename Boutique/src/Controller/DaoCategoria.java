
package Controller;


import Model.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCategoria extends Dao {
    
    public int addCategoria(Categoria categoria) throws SQLException{
        String sql = "INSERT INTO categoria( nome, status) VALUES (?,?)";
        return (super.executeUpdate(sql,
                    categoria.getNome(),
                    categoria.isStatus()
                ));
    }
    public int updateCategoria(Categoria categoria) throws SQLException{
        String sql = "UPDATE categoria SET nome = ?, status = ? WHERE id = ?";
        return (super.executeUpdate(sql,
                    categoria.getNome(),
                    categoria.isStatus(),
                    categoria.getId()
                ));
    }    
    public int deleteCategoria(Categoria categoria) throws SQLException{
        String  sql = "DELETE FROM categoria WHERE id = ?";
        return (super.executeUpdate(
                    sql, 
                    categoria.getId()
                ));
    }    
    public Categoria getCategoria(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM categoria WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Categoria> getCategoriaList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM categoria ORDER BY nome");
        LinkedList<Categoria> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Categoria> getCategoriaList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM categoria WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Categoria> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Categoria populateObject(ResultSet rs) throws SQLException{
        return (new Categoria(rs.getInt("id"), rs.getString("nome"), rs.getBoolean("status")));
    }
}
