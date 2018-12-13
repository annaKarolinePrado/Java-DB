
package Controller;

import Model.Cidade;
import Model.Estado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCidade extends Dao{
    
     public Cidade getCidade(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidades WHERE id="+pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    public List<Cidade> getCidadeList() throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidades ORDER BY nome");
        LinkedList<Cidade> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;
    }
    public List<Cidade> getCidadeList(String filtro) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM cidades WHERE nome LIKE ? ORDER BY nome",
                "%"+filtro.toUpperCase()+"%");
        LinkedList<Cidade> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateObject(rs));                    
        }        
        return lista;        
    }
    private Cidade populateObject(ResultSet rs) throws SQLException{
        DaoEstado daoEstado = new DaoEstado();
        return (new Cidade(daoEstado.getEstado(rs.getInt("estado")) ,rs.getInt("id"), rs.getString("nome"), rs.getString("cep")));
    }
}
