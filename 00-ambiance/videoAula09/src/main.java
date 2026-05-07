void main() {

    Cardapio cardapio = new Cardapio();

    String linha = IO.readln("Digite um id de um item de cardápio: ");
    long idSelecionado = Long.parseLong(linha);

    ItemCardapio itemSelecionado = cardapio.itens[((int) idSelecionado) - 1];

    IO.println("== Item do cardápio ==");
    IO.println("ID: " + itemSelecionado.id);
    IO.println("Nome: " + itemSelecionado.nome);
    IO.println("Descrição: " + itemSelecionado.descricao);
    if (itemSelecionado.emPromocao) {
        IO.println("Item em promoção 🤑");
        double porcentagemDesconto = itemSelecionado.calculaPorcentagemDesconto();
        IO.println("Preco de: " + itemSelecionado.preco + " por " + itemSelecionado.precoComDesconto);
        IO.println("Porcentagem de desconto: " + porcentagemDesconto);
    } else {
        IO.println("Preço : " + itemSelecionado.preco);
        IO.println("Item não está com desconto");
    }
    IO.println("Categoria: " + itemSelecionado.obtemNomeCategoria());
    IO.println("Imposto: " + itemSelecionado.calculaImposto());

    IO.println("-------");

    IO.println("Soma dos preços: " + cardapio.obtemSomaDosPrecos());
    IO.println("Total de itens em promoção: " + cardapio.obtemTotalDeItensEmPromocao());

    // achar o primeiro preco que eh maior que 10.0
    double precoLimite = 10.0;

    IO.println("O primeiro preço que é maior que " + precoLimite + ": " + cardapio.obtemPrimeiroPrecoMaiorQueLimite(precoLimite));

    IO.println("-------");

    // Imprimir todos os precos menores ou iguais ao limite
    for (ItemCardapio item : cardapio.itens) {
        if (item.preco <= precoLimite) {
            IO.println("Preço menor que " + precoLimite + ": " + item.preco);
        }
    }
}