
package Model;

public class Categoria extends Padrao {
    private boolean status;
    
    public Categoria(){
        
    }
    public Categoria(int id, String nome, boolean status){
        super(id, nome);
        this.setStatus(status);
    }

    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }   
}
