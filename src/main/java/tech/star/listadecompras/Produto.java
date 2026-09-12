package tech.star.listadecompras;

public class Produto {

    private String nome;
    private boolean comprado;

    public Produto(String nome){
        this.nome = nome;
        this.comprado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isComprado(){
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
}
