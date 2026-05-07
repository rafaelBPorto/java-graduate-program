Anotações durantea a aula
Neste Código
 Classe main é o  Command Line Interface (CLI) -> Nossa UI
 Calsses do Domínio do Problema que esta sendo resolvido:
   Cardapio
   CategoriaCardapio
   ItemCardapio
   ItemCardapioIsento

Como inicio o código
```shell
  src
    main.java
    Cardapio.java
    CategoriaCardapio.java
    ItemCardapio.java
    ItemCardapioIsento.java
```

 Portanto para melhorar a organização o código pode ser separado em pastas: package

```shell
  src
    mx.florinda.cli
      main.java
    mx.florinda.modelo
      Cardapio.java
      CategoriaCardapio.java
      ItemCardapio.java
      ItemCardapioIsento.java
```

Nos arquivos das pasta `mx.florinda.modelo`
é preciso criar o `package` no topo do arquivo

`package mx.florinda.modelo`


Ao separar as classes por pacotes
Por padrão essas classes so se comunicam no mesmo pacote

Para que outras clasees possam acessar essses pacotes
É necessário criar os **Modificaroes de acesso**

`padrão` - não colocar nada
`public ` -  qualquer classe de qualquer pacote consegue acessar

Exemplo:
`public class Cardapiop`


O nome completo de uma classe é o: `pacote.nomeDaClasse`
Então em main precisa onde era

`Cardapio cardapio = new Cardapio();`
mudar para
`mx.florinda.modelo.Cardapio cardapio = new Cardapio();`

Além de modificaroes de acesso para as classes também são necessários nos
Atributos
Métodos
Construtoires

Tipos de modificadores
`padrão` - sem nada
`public` - qualquer classe de qualquer pacote pode ler, acessar e modificar
`private` - Só pode ser acessado dentro da mesma classe


Até o momento essas alterações não foram adotadas **boas práticas**

Convenção de nome de pacotes -> Usar o reverse domain name
exemplo:
domain name (site) => mx.florinda.mx -> `mx.mx.florinda`
`mx.mx.florinda.mx.florinda.cli`
`mx.mx.florinda.mx.florinda.modelo`

**Não precisa ter o dóminio registrado** é uma convenção

Sobre os tipos de modicadores por regra os atributos são sempre private (a não ser no quarkus)

Logo:
atributos privados + métodos de acesso
=> obtém  -> get
=> define -> set

ver https://download.oracle.com/otndocs/jcp/7224-javabeans-1.01-fr-spec-oth-JSpec/

 
# Encapsulamento
Tudo isso de atributos públicos e privados 
getters e setters
servem para facilitar a manutenção do código

# Conceitos aplicados de Orientação ao objeto (OO) aplicados até o momento
atributos + métodos
herança
polimorfismo
encapsulamento