
void main() {
	
	Cardapio cardapio = new Cardapio();
	
	String linha = IO.readln("Digite um id de um item de cardápio: ");
	long idSelecionado  = Long.parseLong(linha);

	ItemCardapio itemSelecionado = cardapio.itens[((int) idSelecionado )- 1];

	IO.println("== Item do cardápio ==");
	IO.println("ID: " + itemSelecionado.id);
	IO.println("Nome: " + itemSelecionado.nome);	
	IO.println("Descrição: " + itemSelecionado.descricao);
	if(itemSelecionado.emPromocao) {
		IO.println("Item em promoção 🤑");
		double porcentagemDesconto = itemSelecionado.calculaPorcentagemDesconto();
		IO.println("Preco de: " + itemSelecionado.preco + " por " + itemSelecionado.precoComDesconto);
		IO.println("Porcentagem de desconto: " + porcentagemDesconto);
	}else {
		IO.println("Preço : " + itemSelecionado.preco);
		IO.println("Item não está com desconto");
	}
	IO.println("Categoria: " + itemSelecionado.obtemNomeCategoria());

	IO.println("-------");

	double[] precos = new double[7];

	precos[0] = 2.99;
	precos[1] = 3.50;
	precos[2] = 12.99;
	precos[3] = 4.99;
	precos[4] = 2.50;
	precos[5] = 4.99;
	precos[6] = 25.90;

	boolean[] emPromocao = { false, true, true, true, true, true, false };

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
			continue;
		}
	}

}

class ItemCardapio {

	// atributos
	long id;
	String nome;
	String descricao;
	boolean emPromocao;
	double preco;
	double precoComDesconto;
	CategoriaCardapio categoria;

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

}

class Cardapio {

	ItemCardapio[] itens;

	Cardapio() {
		var item1 = new ItemCardapio(1L, "Refresco do Chaves", 
		"Suco de limão que parece de tamarindo e tem gosto de groselha.", 2.99, CategoriaCardapio.BEBIDAS);

    var item2 = new ItemCardapio(2L, "Sanduíche de Presunto do Chaves", 
                "Sanduíche de presunto simples, mas feito com muito amor.", 3.50, CategoriaCardapio.PRATOS_PRINCIPAIS);
    item2.definePromocao(2.99);

    var item3 = new ItemCardapio(3L, "Torta de Frango da Dona Florinda", 
                "Torta de frango com recheio cremoso e massa crocante.", 12.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
    item3.definePromocao(10.99);

    var item4 = new ItemCardapio(4L, "Pipoca do Quico", 
                "Balde de pipoca preparado com carinho pelo Quico.", 4.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
    item4.definePromocao(3.99);

    var item5 = new ItemCardapio(5L, "Água de Jamaica", 
                "Água aromatizada com hibisco e toque de açúcar.", 2.5, CategoriaCardapio.SOBREMESAS);
    item5.definePromocao(2.0);

    var item6 = new ItemCardapio(6L, "Churros do Chaves", 
                "Churros recheados com doce de leite, clássicos e irresistíveis.", 4.99, CategoriaCardapio.SOBREMESAS);
    item6.definePromocao(3.99);

    var item7 = new ItemCardapio(7L, "Tacos de Carnitas", 
                "Tacos recheados com carne tenra", 25.9, CategoriaCardapio.PRATOS_PRINCIPAIS);
	
		itens = new ItemCardapio[7];
		itens[0] = item1;
		itens[1] = item2; 
		itens[2] = item3; 
		itens[3] = item4; 
		itens[4] = item5; 
		itens[5] = item6; 
		itens[6] = item7; 
	}

	double obtemSomaDosPrecos(){
		double totalDePrecos = 0.0;
		int i = 0;
		for (ItemCardapio item : itens){
			totalDePrecos += item.preco;
		}
		return totalDePrecos;
	}

	int obtemTotalDeItensEmPromocao() {
		int totalItensEmPromocao = 0;
		for (ItemCardapio item : itens) {
			if (item.emPromocao) {
				totalItensEmPromocao++;
			}
		}
		return totalItensEmPromocao;
	}

	double obtemPrimeiroPrecoMaiorQueLimite(double precoLimite) {
		double precoMaiorQueLimite = -1.0; 
		for (ItemCardapio item : itens) {
			if (item.preco > precoLimite) {
				precoMaiorQueLimite = item.preco;
				break;
			}
		}

		return precoMaiorQueLimite;
	}
}

enum CategoriaCardapio {
	ENTRADAS, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS	
}