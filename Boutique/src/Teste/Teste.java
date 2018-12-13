
package Teste;

import Controller.DaoCidade;
import Controller.DaoEstado;
import Model.Cidade;
import Model.Estado;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Teste {
    public static void main(String[] args) throws SQLException {
        /*
        DaoEstado daoEstado = new DaoEstado();
        Estado estado = new Estado();
        
        estado = daoEstado.getEstado(1);
        
        System.out.println(estado.getNome());
        */
        
        DaoCidade daoCidade = new DaoCidade();
        Cidade cidade = new Cidade();
        
        cidade = daoCidade.getCidade(1);
        
        System.out.println(cidade.getNome());
        
        List<Cidade> listas = daoCidade.getCidadeList("criciú");
        
        for (Cidade lista : listas) {
            System.out.println(lista.getEstado().getNome()+" - "+ lista.getNome());
        }
    }
 
}
