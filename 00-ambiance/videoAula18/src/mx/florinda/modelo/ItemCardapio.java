package mx.florinda.modelo;

import java.util.Objects;

public class ItemCardapio {

    // atributos
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    private CategoriaCardapio categoria;

    private boolean emPromocao;
    private double precoComDesconto;

    //construtor
    public ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    //metodos

    public CategoriaCardapio getCategoria() {
        return categoria;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEmPromocao() {
        return emPromocao;
    }

    public double getPreco() {
        return preco;
    }

    public double getPrecoComDesconto() {
        return precoComDesconto;
    }

    public double getPorcentagemDesconto() {
        return (preco - precoComDesconto) / preco * 100;
    }

    public CategoriaCardapio getNomeCategoria() {
        return categoria;
    }

    public void setPromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }

    public double getImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto * 0.1;
        } else {
            imposto = preco * 0.1;
        }

        return imposto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemCardapio that = (ItemCardapio) o;
        return id == that.id && Double.compare(preco, that.preco) == 0 && emPromocao == that.emPromocao && Double.compare(precoComDesconto, that.precoComDesconto) == 0 && Objects.equals(nome, that.nome) && Objects.equals(descricao, that.descricao) && categoria == that.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, descricao, preco, categoria, emPromocao, precoComDesconto);
    }

    @Override
    public String toString() {
        return "ItemCardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                ", emPromocao=" + emPromocao +
                ", precoComDesconto=" + precoComDesconto +
                '}';
    }
}
