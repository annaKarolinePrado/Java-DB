
package Model;

public class Cidade extends Padrao{
    private Estado estado;
    private String cep;
    
    public Cidade(){
        
    }
    public Cidade(Estado estado, int id, String nome, String cep){
        super(id, nome);
        this.setEstado(estado);
        this.setCep(cep);
    }

    public Estado getEstado() {
        return estado;
    }
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }    
}
