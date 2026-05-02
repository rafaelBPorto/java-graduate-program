/*
* Arquivo no padrão JEP 512 (https://openjdk.org/jeps/512)
* Promove uma escrita de pequenos programas concisos, sem a necessidade de construções destinadas à programação em larga escala.
*/


/*
* Liguagens orientadas a objetos
*  - Atributos -> Dados
*  - Métodos   -> Comportamentos
*/

void main() {
  ItemCardapio item1 =  new ItemCardapio( 1L, "Refresco do Chaves", "Suco de limão que parece tamarim com gosto de groselha.", 2.99, 4); 

  // item1.emPromocao = false;
  // item1.precoComDesconto;

  IO.println("Nome: " + item1.nome);
  IO.println("Descricao: " + item1.descricao);
  IO.println("Preço: " + item1.preco);
  IO.println("Promoção: " + item1.emPromocao);

  IO.println("-----");


  ItemCardapio item2 =  new ItemCardapio(); // Criação do objeto item1 a partir da classe

  item2.nome = "Sanduíche de Presunto do Chaves";
  item2.descricao = "Sanduíche de presunto simples, sem presunto";
  item2.preco = 3.50;
  item2.id = 2L;
  item2.categoria = 2;

  item2.definePromocao(2.99);

  IO.println("Nome: " + item2.nome);
  IO.println("Descricao: " + item2.descricao);
  IO.println("Preço: " + item2.preco);
  IO.println("Promoção: " + item2.emPromocao);
  IO.println("Preço com Desconto " + item2.precoComDesconto);
  IO.println("Porcentagem do Desconto " + item2.calculaPorcentagemDesconto());

  IO.println("Categora: " + item2.obtemNomeCategoria());


}

// Convenção Java CamelCase para nome de Classes
class ItemCardapio{

  /* Atributos
      Valores padrão para atributos
        String: null
        boolean: false
        double: 0.0
        long: 0
  */
  
  // Tipo | nomeAtributo
  
  String nome;
  String descricao;
  boolean emPromocao;
  double preco;
  double precoComDesconto;
  long id;
  int categoria;


  /* Construtor
   - Recebe o nome da clase
   - Pode ter mais de um construto
  */
  
  ItemCardapio() {}

  ItemCardapio(long id, String nome, String descricao, double preco, int categoria ) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.categoria = categoria;
  }

  // Metodos

  // Tipo de Retorno | Nome do Método
  double calculaPorcentagemDesconto() {
    if (emPromocao) {
      return (1 - (precoComDesconto / preco)) * 100;
    } else {
      return 0.0;
    }
  }

  String obtemNomeCategoria() {
    switch(categoria) {
      case 1:
        return "Entradas";
      case 2:
        return "Pratos Principais";
      case 3:
        return "Sobremesas";
      case 4:
        return "Bebidas";
      default:
        return "Não encontrada";
    }
  }

  void definePromocao(double precoComDesconto) {
    emPromocao = true;
    this.precoComDesconto = precoComDesconto;
  }

}



