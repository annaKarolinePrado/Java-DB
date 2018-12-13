
package Teste;

import Controller.DaoEstado;
import Model.Estado;
import java.sql.SQLException;

public class Teste {
    public static void main(String[] args) throws SQLException {
        DaoEstado daoEstado = new DaoEstado();
        Estado estado = new Estado();
        
        estado = daoEstado.getEstado(1);
        
        System.out.println(estado.getNome());
    }
 
}
