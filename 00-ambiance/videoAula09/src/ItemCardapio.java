class ItemCardapio {

    // atributos
    long id;
    String nome;
    String descricao;
    boolean emPromocao;
    double preco;
    double precoComDesconto;
    CategoriaCardapio categoria;

    /* Adicionar imposto
    * Taxa de Imposto é 10 para maioria dos produtos
    * mas existem produtod que são isentos (não tem imposto)
    * É calculado em cima do preco efetivo, ou seja, preco o precoComDesconto
    * Valor do imposto é => a taxa * preco efetico
    * PIPOCA, CHURROS, TACOS são isentos de imposto
    *
    * HERANÇA
    * Criar um tipo especial da classe ItemCardapio na qual o imposto é isento -> HERANÇA (extends) -> itemCardapioIsento
    *
    * ItemCardapio (superclasse / classe mãe) <- ItemCardapioIsento (subclasse / classe filha)
    * Herda caracteristicas da mae mas pode adiconar ou mudar alumas coisas
    *
    * Existem muitas forma de ter ItemCardapio (varias Filhas -> ItemCardapioVegano, ItemCardapioCarnivoro)
    * Muitas -> Poli
    * Formas -> Morphus
    *
    * Então entra o conceito de POLIMORFISMO
    * */

    //construtor
    ItemCardapio(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    //metodos
    double calculaPorcentagemDesconto() {
        return (preco - precoComDesconto) / preco * 100;
    }

    CategoriaCardapio obtemNomeCategoria() {
        return categoria;
    }

    void definePromocao(double precoComDesconto) {
        emPromocao = true;
        this.precoComDesconto = precoComDesconto;
    }

    double calculaImposto() {
        double imposto;
        if (emPromocao) {
            imposto = precoComDesconto * 0.1;
        } else {
            imposto = preco * 0.1;
        }

        return imposto;
    }

}
