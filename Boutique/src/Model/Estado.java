
package Model;

public class Estado extends Padrao {    
    private String sigla;
    
    public Estado(){
        
    }
    public Estado(int id, String nome, String sigla){
        super(id, nome);
        this.setSigla(sigla);
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }      
}
