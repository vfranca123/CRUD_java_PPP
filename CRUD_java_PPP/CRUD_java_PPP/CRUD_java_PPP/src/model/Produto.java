package model;

public class Produto implements Interface {
    private int id;
    private String nome;
    private String descricao;
    private Float preco;
    private int qnt_dEstoqe;

    public Produto( String nome, String descricao, Float preco, int qnt_dEstoqe){
        this.nome= nome;
        this.descricao=descricao;
        this.preco=preco;
        this.qnt_dEstoqe=qnt_dEstoqe;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public int getQnt_dEstoqe() {
        return qnt_dEstoqe;
    }

    public void setQnt_dEstoqe(int qnt_dEstoqe) {
        this.qnt_dEstoqe = qnt_dEstoqe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
