/*
* Arquivo no padrão JEP 512 (https://openjdk.org/jeps/512)
* Promove uma escrita de pequenos programas concisos, sem a necessidade de construções destinadas à programação em larga escala.
*/

/*
  Item de um Cardapio:
    Atributos:
      - nome
      - descricao
      - emPromocao
      - preco
      - precoComDesconto
      - id
      - categoria

  Portanto podemos criar uma Classe ItemCardapio
  Classe -> Será a estrutura de um objeto
  Objeto -> é um item que tem os atributos de uma Classe
*/




void main() {
  ItemCardapio item1 =  new ItemCardapio(); // Criação do objeto item1 a partir da classe

  item1.nome = "Refresco do Chaves";
  item1.descricao = "Suco de limão que parece tamarim com gosto de groselha.";
  item1.emPromocao = false;
  item1.preco = 2.99;
  // item1.precoComDesconto;
  item1.id = 1L;
  item1.categoria = 4;

  IO.println("Nome: " + item1.nome);
  IO.println("Descricao: " + item1.descricao);
  IO.println("Promoção: " + item1.emPromocao);
  IO.println("Preço: " + item1.preco);




  ItemCardapio item2 =  new ItemCardapio(); // Criação do objeto item1 a partir da classe

  item2.nome = "Sanduíche de Presunto do Chaves";
  item2.descricao = "Sanduíche de presunsto simples, sem presunto";
  item2.emPromocao = true;
  item2.preco = 3.50;
  item1.precoComDesconto = 2.99;
  item2.id = 2L;
  item2.categoria = 2;


}

// Convesção Java CamelCase para nome de Classes
class ItemCardapio{

  // Atributos -> Tipo nomeAtributo
  
  String nome;
  String descricao;
  boolean emPromocao;
  double preco;
  double precoComDesconto;
  long id;
  int categoria;

}



