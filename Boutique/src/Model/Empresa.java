
package Model;

public class Empresa {
    private int id;
    private String nome_fantasia; 
    private String razao_social; 
    private int inscricao_municipal; 
    private int inscricao_estadual; 
    private char estado;
    private String cidade; 
    private String regime_tributario; 
    private String cnpj;

    public Empresa(int id, String nome_fantasia, String razao_social, int inscricao_municipal, int inscricao_estadual, char estado, String cidade, String regime_tributario, String cnpj) {
        this.setId (id);
        this.setNome_fantasia(nome_fantasia);
        this.setRazao_social(razao_social);
        this.setInscricao_municipal(inscricao_municipal);
        this.setInscricao_estadual(inscricao_estadual);
        this.setEstado(estado);
        this.setCidade(cidade);
        this.setRegime_tributario(regime_tributario);
        this.setCnpj(cnpj);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }
    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public String getRazao_social() {
        return razao_social;
    }
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public int getInscricao_municipal() {
        return inscricao_municipal;
    }
    public void setInscricao_municipal(int inscricao_municipal) {
        this.inscricao_municipal = inscricao_municipal;
    }

    public int getInscricao_estadual() {
        return inscricao_estadual;
    }
    public void setInscricao_estadual(int inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public char getEstado() {
        return estado;
    }
    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRegime_tributario() {
        return regime_tributario;
    }
    public void setRegime_tributario(String regime_tributario) {
        this.regime_tributario = regime_tributario;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return nome_fantasia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
