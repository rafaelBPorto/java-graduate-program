# Anotações de Aula: Módulo 0 - Aula 07 - ARRAYS DE OBJETOS, COMPOSIÇÃO E ENUMS 📚
 Este resumo foca nos três pilares trabalhados: **Arrays de Objetos**, **Composição** e **Enums**

---

## Arrays de Objetos, Composição e Enums

Nesta aula, o foco foi a refatoração de um código procedural para uma estrutura robusta de **Programação Orientada a Objetos (POO)**. 
Saímos de variáveis soltas no `main` para uma arquitetura onde as classes gerenciam seus próprios dados e comportamentos.

---

## 1. Arrays de Objetos 📦
Diferente dos tipos primitivos, um array de objetos armazena referências para instâncias de uma classe. 
*   **Declaração:** `ItemCardapio[] itens;`
*   **Inicialização:** Pode ser feita definindo o tamanho (`new ItemCardapio[7]`) ou de forma literal usando chaves `{}`.
*   **Uso no Código:** No construtor da classe `Cardapio`, inicializamos o array e atribuímos cada item criado às posições do índice (0 a 6).

---

## 2. Composição 🧩
A **Composição** é o princípio onde uma classe "tem um" (ou vários) objetos de outra classe como seus atributos.
*   **Aplicação:** A classe `Cardapio` é composta por um array de `ItemCardapio.
*   **Encapsulamento de Lógica:** Movemos a responsabilidade de calcular a soma de preços (`obtemSomaDosPrecos`) e contar promoções (`obtemTotalDeItensEmPromocao`) do `main` para dentro da classe `Cardapio`. Isso centraliza a regra de negócio.

---

## 3. Enums (Enumerados) 🏷️
Substituímos os "números mágicos" (como usar `int categoria = 4` para representar bebidas) por tipos enumerados.
*   **Vantagem:** Aumenta a legibilidade e a segurança do código, impedindo valores inválidos.
*   **Exemplo:**
    ```java
    enum CategoriaCardapio {
      ENTRADAS, PRATOS_PRINCIPAIS, SOBREMESAS, BEBIDAS  
    }
    ```
*   **No Objeto:** O atributo `categoria` na classe `ItemCardapio` agora é do tipo `CategoriaCardapio`, e não mais um `int` ou `String`.

---

## 4. Destaques Técnicos do Código
*   **Busca com Early Return:** O método `obtemPrimeiroPrecoMaiorQueLimite` utiliza o comando `break` para interromper o laço `for` assim que a condição é atingida, otimizando a execução.
*   **Tipagem Long:** Uso do sufixo `L` (ex: `1L`) para garantir que o ID seja tratado como um tipo `long` de 64 bits.
*   **Interatividade:** Uso de `IO.readln` e `Long.parseLong` para capturar e converter a entrada do usuário via terminal.

---

## 5. Desafio de Aprofundamento (Baseado na Aula)
1.  **Refatorar a Busca:** No código atual, o item é acessado diretamente pelo índice `id-1`. O desafio proposto é usar um laço `for` dentro de `Cardapio` para buscar o item comparando o atributo `.id`, tornando a busca independente da ordem do array.
2.  **Filtro por Categoria:** Criar um método `imprimeItensPorCategoria(CategoriaCardapio categoria)` que percorre o array e exibe apenas os itens correspondentes.

---
**Links Úteis Referenciados:**
*   [Documentação Oracle: Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
*   [Documentação Oracle: Enums](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)

---

# Anotações de Aula: Módulo 0 - Aula 08 - INTELLIJ IDE E DEBUG 📚

## Opções de IDE
 - Eclipse
 - NetBeans
 - VSCode (com extensões)
 - IntelliJ IDEA da JetBrains

# Anotações de Aula: Módulo 0 - Aula 09 - ORGANIZANDO EM ARQUIVOS E HERANÇA 📚

Inicio da organização do codigo
- Seperação entre main, classes e enum
- Introdução a herança e polimorfismo
- Notation @override
- utilização so `super()` para se referir a itens da classe mãe no construtor


*Notas tomadas por Rafael Porto durante a pós-graduação Java Elite.*
