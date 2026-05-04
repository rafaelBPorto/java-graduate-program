/*
  Exercícios Práticos
  Exercício 1: 
  Crie uma classe Produto com:
  - atributos:
   codigo (long), nome (String), preco (double) e quantidadeEmEstoque (int). 
  - Crie um construtor que inicialize todos esses atributos. 
  - Adicione um método valorTotalEmEstoque() 
      que retorna o valor total dos itens em estoque (preço * quantidade). 
  - Crie uma instância de Produto no método main e exiba o valor total em estoque.
  
  Exercício 2: Na classe Produto do exercício anterior, adicione um método
  void adicionarEstoque(int quantidade) que aumenta a quantidade de
  itens em estoque. Adicione também um método boolean
  removerEstoque(int quantidade) que diminui a quantidade em estoque
  e retorna true se a operação foi bem-sucedida (havia estoque suficiente)
  ou false caso contrário (a quantidade a ser removida é maior que o
  estoque atual). Teste os dois métodos no main.
*/

void main(){
 Produto pera = new Produto(1, "pera", 1.99, 10);

 IO.println("Valor total em " + pera.nome)
}

class Produto {
  // Atributos
  long codigo;
  String nome;
  double preco;
  int quantidadeEmEstoque;


  // Construtores
  Produto (){}
  Produto ( long codigo, String nome, double preco, int quantidadeEmEstoque){
    this.codigo = codigo;
    this.nome = nome;
    this.preco = preco;
    this.quantidadeEmEstoque = quantidadeEmEstoque
  }

  //Metodos
  double valorTotalEmEstoque(){
    return quantidadeEmEstoque * preco;
  }
}