Para dominar a plataforma Java (especialmente em cenários de alta performance e arquiteturas robustas), entender a fundo o ecossistema de **Collections** e a mecânica de **Multithreading** é um divisor de águas.

Abaixo, está o guia completo com as características, complexidade assintótica (Big O), boas práticas e o comportamento delas em ambientes concorrentes.

---

## 1. List (Lista Ordenada, Permite Duplicados)

As listas mantêm a **ordem de inserção** e permitem elementos repetidos.

### ArrayList

* **Características:** Baseado em um **array dinâmico** interno. Quando o array enche, o Java cria um novo (geralmente com 50% a mais de capacidade) e copia os dados.
* **Big O:** Busca por índice: $O(1)$. Busca por valor (com `contains` ou `indexOf`): $O(n)$. Inserção/Remoção no final: $O(1)$ amortizado. Inserção/Remoção no início/meio: $O(n)$ porque precisa deslocar os outros elementos.
* **Quando utilizar:** É a escolha **padrão** para quase tudo. Ideal quando você precisa ler dados frequentemente filtrando por índice ou iterando sequencialmente, e as inserções ocorrem majoritariamente no final.
* **Boas/Más Práticas:** * *Boa:* Se você já sabe o tamanho aproximado que a lista terá, instancie informando a capacidade inicial: `new ArrayList<>(1000)`. Isso evita múltiplos *resizes* e cópias internas de memória.
* *Má:* Usar `ArrayList` se você precisa fazer inserções e deleções constantes no início ou meio da lista.



### LinkedList

* **Características:** Implementação baseada em **Lista Duplamente Encadeada**. Cada elemento (nó) conhece o anterior e o próximo na memória.
* **Big O:** Busca por índice: $O(n)$ (precisa navegar nó por nó). Inserção/Remoção nas pontas (início/fim): $O(1)$. Inserção/Remoção no meio: $O(n)$ porque primeiro precisa achar a posição.
* **Quando utilizar:** Muito raro no dia a dia. Útil apenas se você estiver implementando filas (Queues), pilhas (Stacks) ou se o seu algoritmo fizer inserções/remoções massivas estritamente nas pontas da lista.
* **Boas/Más Práticas:** * *Má:* Usar para iterar com laços `for (int i=0; i < list.size(); i++)` chamando `list.get(i)`. Isso transforma um loop simples em um algoritmo catastrófico de complexidade $O(n^2)$.

### Vector

* **Características:** Legado do Java 1.0. Funciona exatamente como um `ArrayList`, mas **todos os seus métodos são sincronizados (`synchronized`)** individualmente.
* **Big O:** Mesmos do `ArrayList`.
* **Quando utilizar:** **Nunca.** É obsoleto.
* **Boas/Más Práticas:**
* *Má:* Utilizar `Vector` em código moderno. O bloqueio thread-by-thread dele gera um overhead de performance massivo e desnecessário, mesmo que você esteja rodando em uma única thread.



---

## 2. Set (Coleções de Elementos Únicos)

Não permitem elementos duplicados. A identificação de duplicidade depende estritamente da correta implementação dos métodos `hashCode()` e `equals()` no seu objeto.

### HashSet

* **Características:** Baseado em uma tabela Hash (internamente usa um `HashMap`). Não garante **nenhuma ordem** dos elementos.
* **Big O:** Inserção, remoção e busca (`contains`): $O(1)$ em condições ideais.
* **Quando utilizar:** Quando você precisa de uma coleção de itens exclusivos e a velocidade de checagem/inserção é crítica, sem se importar com a ordem.
* **Boas/Más Práticas:**
* *Boa:* Sempre implemente `equals()` e `hashCode()` nas suas entidades/DTOs de forma consistente se for usá-los em Sets. Se quebrar o contrato do `hashCode`, o `HashSet` aceitará duplicados ou "perderá" objetos lá dentro.



### LinkedHashSet

* **Características:** É um `HashSet`, mas mantém uma lista duplamente encadeada por trás para preservar a **ordem de inserção**.
* **Big O:** Inserção, remoção e busca: $O(1)$. O custo de memória é ligeiramente maior que o `HashSet`.
* **Quando utilizar:** Quando você precisa garantir elementos únicos, performance rápida, mas a **ordem em que os elementos foram inseridos** importa para a lógica de negócio.

### TreeSet

* **Características:** Armazena os elementos em uma estrutura de **Árvore Rubro-Negra** (Red-Black Tree). Os elementos são mantidos em sua **ordem natural** (alfabética, numérica) ou via um `Comparator` customizado.
* **Big O:** Inserção, remoção e busca: $O(\log n)$.
* **Quando utilizar:** Quando você precisa manter a coleção constantemente ordenada de forma automática à medida que insere os dados.
* **Boas/Más Práticas:**
* *Má:* Usar `TreeSet` se você só precisa ordenar a lista uma única vez no final do processo. É muito mais eficiente usar `HashSet` e ordenar apenas na saída.



---

## 3. Map (Estruturas de Chave-Valor)

*Nota: No seu prompt você digitou "Map (HashSet...)", mas o correto para as implementações de Map são `HashMap`, `LinkedHashMap` e `TreeMap`.*

Maps mapeiam chaves únicas para valores. Chaves duplicadas não são permitidas.

### HashMap

* **Características:** Organiza os dados por meio de funções Hash na chave. Não garante nenhuma ordem de iteração.
* **Big O:** Busca, inserção e remoção por chave: $O(1)$.
* **Quando utilizar:** É a implementação de Map padrão e a mais performática para indexação rápida de dados por uma chave.

### LinkedHashMap

* **Características:** Mantém a **ordem de inserção** das chaves usando uma estrutura encadeada por trás do mapa.
* **Big O:** Busca, inserção e remoção: $O(1)$.
* **Quando utilizar:** Útil para construir caches simples (como algoritmos LRU - *Least Recently Used*) ou quando o output do mapa precisa refletir exatamente a ordem de entrada.

### TreeMap

* **Características:** Baseado em árvore navegável. Mantém as **chaves ordenadas** de forma natural ou por um comparador.
* **Big O:** Busca, inserção e remoção: $O(\log n)$.
* **Quando utilizar:** Quando você precisa iterar pelas chaves em ordem alfabética/numérica ou extrair sub-mapas facilmente (ex: "me dê todas as chaves entre A e F").

---

## Tabela Resumo (Big O)

| Estrutura | Inserção (Média) | Busca (Média) | Ordenado por |
| --- | --- | --- | --- |
| **ArrayList** | $O(1)$ (no fim) | $O(1)$ (por índice) / $O(n)$ (por valor) | Ordem de inserção |
| **LinkedList** | $O(1)$ (nas pontas) | $O(n)$ | Ordem de inserção |
| **HashSet** | $O(1)$ | $O(1)$ | Nenhuma ordem |
| **TreeSet** | $O(\log n)$ | $O(\log n)$ | Ordem Natural / Customizada |
| **HashMap** | $O(1)$ | $O(1)$ | Nenhuma ordem |
| **TreeMap** | $O(\log n)$ | $O(\log n)$ | Ordem das Chaves |

---

## 4. Multithreading: O que usar e o que evitar?

Quando múltiplas Threads acessam e modificam a mesma estrutura de dados ao mesmo tempo, ocorre a famigerada **Race Condition** (Condição de Corrida), que corrompe os dados ou estoura uma `ConcurrentModificationException`.

### ❌ O que NÃO utilizar em ambiente Multithread

* **ArrayList, LinkedList, HashSet, HashMap:** Nenhuma dessas coleções padrão é *Thread-Safe*. Se uma thread estiver lendo e outra injetando dados nelas sem sincronização externa, a aplicação vai quebrar ou apresentar comportamentos imprevisíveis.
* **Vector e Hashtable (Legados):** Embora sejam thread-safe porque usam travas (`synchronized`) em cada método, eles bloqueiam a coleção inteira para qualquer operação elementar. Isso gera gargalos massivos de concorrência. São considerados antipadrões modernos.

### ⚙️ O que utilizar no lugar? (As alternativas modernas)

O Java introduziu no pacote `java.util.concurrent` coleções otimizadas com travas parciais e algoritmos *Lock-Free* de altíssima performance.

#### 1. Para substituir Maps: `ConcurrentHashMap`

* **Por que usar:** Em vez de travar o mapa inteiro ao inserir um valor, ele divide o mapa em segmentos e trava apenas a "gaveta" (bucket) específica onde o dado está sendo inserido. Outras threads podem ler e escrever em outras partes do mapa simultaneamente sem nenhum bloqueio.

#### 2. Para substituir Lists: `CopyOnWriteArrayList`

* **Por que usar:** Toda vez que a lista é alterada (adicionar/remover), o Java cria uma cópia inteira do array subjacente. As threads de leitura continuam lendo o array antigo sem precisar de travas enquanto a escrita acontece na cópia.
* **Atenção:** Só utilize se o seu cenário tiver **muitíssimas leituras** e **raríssimas escritas**, caso contrário, o custo de copiar o array toda hora vai degradar a memória.

#### 3. Para Filas de Mensagens e Produtor/Consumidor: `BlockingQueue` (ex: `LinkedBlockingQueue`)

* **Por que usar:** Perfeito para cenários onde threads produzem tarefas e threads de background as consomem. Se a fila estiver vazia, a thread consumidora espera automaticamente até que um dado apareça, de forma segura e eficiente.

#### 4. O Coringa: `Collections.synchronizedList()` / `synchronizedSet()`

* **Por que usar:** Se você precisa converter um `ArrayList` ou `HashSet` existente em uma versão thread-safe de forma rápida, esses wrappers sincronizam o acesso ao objeto.
* **Atenção:** Eles usam travas globais similares ao antigo `Vector`. Use apenas se a concorrência for muito baixa e você não puder usar as coleções do pacote `concurrent`.

---
# Exemplo de busca com cada estrutura

Para consolidar de vez o entendimento dessas estruturas, vamos criar um exemplo prático completo para cada uma. Imagine um cenário com objetos simples (Strings) para facilitar a visualização de como cada estrutura organiza os dados, realiza buscas e exibe a saída.

---

## 1. List (ArrayList vs LinkedList)

### ArrayList

* **Como funciona:** Array dinâmico colado na memória. Excelente para leitura por índice.
* **Busca:** Usando `.get(indice)` ($O(1)$) ou `.contains(valor)` ($O(n)$).

```java
import java.util.ArrayList;
import java.util.List;

public class ExemploArrayList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("Corsa");
        lista.add("Golf");
        lista.add("Civic");
        lista.add("Corsa"); // Aceita duplicados

        // Como buscar por índice
        String carroPosicao1 = lista.get(1); // "Golf"

        // Como buscar por valor
        boolean temCivic = lista.contains("Civic"); // true

        System.out.println("Saída ArrayList: " + lista);
    }
}

```

* **Saída no console (Mantém estritamente a ordem de inserção):**
`Saída ArrayList: [Corsa, Golf, Civic, Corsa]`

---

### LinkedList

* **Como funciona:** Nós encadeados por ponteiros. Excelente para manipulação nas pontas (início e fim).
* **Busca:** Percorre os nós um por um ($O(n)$).

```java
import java.util.LinkedList;

public class ExemploLinkedList {
    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();
        lista.add("Corsa");
        lista.add("Golf");
        lista.addFirst("Civic"); // Adiciona no início facilmente

        // Busca por valor
        boolean temGolf = lista.contains("Golf"); // true

        System.out.println("Saída LinkedList: " + lista);
    }
}

```

* **Saída no console (Ordem alterada pela inserção no início):**
`Saída LinkedList: [Civic, Corsa, Golf]`

---

## 2. Set (HashSet vs TreeSet)

Os Sets **não aceitam duplicados**. Se tentar adicionar um item que já existe, o Java simplesmente ignora.

### HashSet

* **Como funciona:** Tabela Hash pura. Não se importa com nenhuma ordem.
* **Busca:** Instantânea usando `.contains(valor)` ($O(1)$).

```java
import java.util.HashSet;
import java.util.Set;

public class ExemploHashSet {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Golf");
        conjunto.add("Corsa");
        conjunto.add("Civic");
        conjunto.add("Golf"); // Ignorado silenciosamente (duplicado)

        // Busca: Muito rápida, vai direto na gaveta matemática do elemento
        boolean temCorsa = conjunto.contains("Corsa"); // true

        System.out.println("Saída HashSet: " + conjunto);
    }
}

```

* **Saída no console (Ordem caótica/aleatória, baseada nos hashes internos):**
`Saída HashSet: [Civic, Golf, Corsa]` *(pode variar a cada execução)*

---

### TreeSet

* **Como funciona:** Árvore binária em background. Mantém tudo ordenado automaticamente.
* **Busca:** Navega pelos galhos da árvore com `.contains(valor)` ($O(\log n)$).

```java
import java.util.TreeSet;
import java.util.Set;

public class ExemploTreeSet {
    public static void main(String[] args) {
        Set<String> conjunto = new TreeSet<>();
        conjunto.add("Golf");
        conjunto.add("Corsa");
        conjunto.add("Civic");

        // Busca
        boolean temPalio = conjunto.contains("Palio"); // false

        System.out.println("Saída TreeSet: " + conjunto);
    }
}

```

* **Saída no console (Sempre em ordem alfabética/natural):**
`Saída TreeSet: [Civic, Corsa, Golf]`

---

## 3. Map (HashMap vs TreeMap)

Estruturas de **Chave-Valor**. As chaves funcionam como um `Set` (são únicas), mas os valores podem se repetir.

### HashMap

* **Como funciona:** Indexa valores através do hash da chave. Rápido e sem ordem.
* **Busca:** Pela chave usando `.get(chave)` ($O(1)$) ou `.containsKey(chave)` ($O(1)$).

```java
import java.util.HashMap;
import java.util.Map;

public class ExemploHashMap {
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();
        // .put(Chave, Valor)
        mapa.put("AAA-1234", "Corsa");
        mapa.put("BBB-5678", "Golf");
        mapa.put("CCC-9999", "Civic");

        // Busca por Chave: Retorna o Valor associado àquela chave
        String carroDaPlaca = mapa.get("BBB-5678"); // "Golf"

        // Verificar se a chave existe antes de buscar
        boolean temPlaca = mapa.containsKey("AAA-1234"); // true

        System.out.println("Saída HashMap: " + mapa);
    }
}

```

* **Saída no console (Chaves desordenadas):**
`Saída HashMap: {CCC-9999=Civic, AAA-1234=Corsa, BBB-5678=Golf}`

---

### TreeMap

* **Como funciona:** Árvore de chaves. Mantém as **chaves** rigorosamente ordenadas.
* **Busca:** Caminha pela árvore de chaves usando `.get(chave)` ($O(\log n)$).

```java
import java.util.TreeMap;
import java.util.Map;

public class ExemploTreeMap {
    public static void main(String[] args) {
        Map<String, String> mapa = new TreeMap<>();
        mapa.put("CCC-9999", "Civic");
        mapa.put("AAA-1234", "Corsa");
        mapa.put("BBB-5678", "Golf");

        // Busca
        String carro = mapa.get("CCC-9999"); // "Civic"

        System.out.println("Saída TreeMap: " + mapa);
    }
}

```

* **Saída no console (Chaves perfeitamente ordenadas em ordem alfabética de placas):**
`Saída TreeMap: {AAA-1234=Corsa, BBB-5678=Golf, CCC-9999=Civic}`

---

## 💡 Resumo Visual de Comportamento

| Estrutura | Aceita Duplicados? | Como organiza a Saída? | Método de Busca Principal |
| --- | --- | --- | --- |
| **ArrayList** | Sim | Exatamente na ordem em que você adicionou | `get(index)` ou `contains(obj)` |
| **LinkedList** | Sim | Exatamente na ordem em que você adicionou | `contains(obj)` |
| **HashSet** | Não | Bagunçada/Sem nenhuma ordem garantida | `contains(obj)` *(Ultra rápido)* |
| **TreeSet** | Não | Ordenada (A-Z, 1-9...) | `contains(obj)` |
| **HashMap** | Chaves: Não / Valores: Sim | Bagunçada/Sem nenhuma ordem de chaves | `get(chave)` ou `containsKey(chave)` |
| **TreeMap** | Chaves: Não / Valores: Sim | Chaves perfeitamente ordenadas | `get(chave)` |

---
Aqui está o guia definitivo com exemplos práticos rodando **todas as principais operações** que você vai usar no dia a dia com cada uma dessas estruturas: **Inserção**, **Busca**, **Remoção**, **Tamanho** e **Atualização/Verificação**.

---

## 1. As Listas (ArrayList e LinkedList)

As operações básicas de manipulação são idênticas porque ambas implementam a interface `List`, mas lembre-se de que o `ArrayList` é muito mais rápido para buscar por índice (`get`), enquanto o `LinkedList` oferece métodos extras para manipulação rápida nas pontas (`addFirst`, `removeFirst`).

### ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class OperacoesArrayList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        // 1. INSERÇÃO
        lista.add("Corsa");
        lista.add("Golf");
        lista.add("Civic");

        // 2. BUSCA
        String segundoItem = lista.get(1); // Busca por ÍNDICE [O(1)] -> "Golf"
        boolean existeGolf = lista.contains("Golf"); // Busca por VALOR [O(n)] -> true

        // 3. ATUALIZAÇÃO
        lista.set(0, "Palio"); // Substitui o elemento do índice 0 ("Corsa" vira "Palio")

        // 4. REMOÇÃO
        lista.remove(2); // Remove pelo índice (Remove "Civic")
        lista.remove("Golf"); // Remove pelo valor diretamente

        // 5. TAMANHO / VERIFICAÇÃO
        int tamanho = lista.size(); // Retorna quantos itens restaram -> 1
        boolean estaVazia = lista.isEmpty(); // false

        System.out.println("ArrayList Final: " + lista); // [Palio]
    }
}

```

### LinkedList (Foco nas Pontas)

```java
import java.util.LinkedList;

public class OperacoesLinkedList {
    public static void main(String[] args) {
        // Usamos a referência da classe concreta para acessar métodos específicos das pontas
        LinkedList<String> lista = new LinkedList<>();

        // 1. INSERÇÃO (Normal e nas Pontas)
        lista.add("Golf");         // Adiciona no fim
        lista.addFirst("Corsa");    // Adiciona no INÍCIO [O(1)]
        lista.addLast("Civic");     // Adiciona no FIM [O(1)]

        // 2. BUSCA NAS PONTAS
        String primeiro = lista.getFirst(); // "Corsa"
        String ultimo = lista.getLast();   // "Civic"

        // 3. REMOÇÃO NAS PONTAS
        lista.removeFirst(); // Remove "Corsa" do início instantaneamente
        lista.removeLast();  // Remove "Civic" do fim instantaneamente

        System.out.println("LinkedList Final: " + lista); // [Golf]
    }
}

```

---

## 2. Os Conjuntos (HashSet e TreeSet)

Sets **não possuem índices** (você não consegue dar um `.get(0)`). O foco deles é garantir elementos únicos e fazer buscas por valor de forma extremamente rápida.

### HashSet (Busca Instantânea, Sem Ordem)

```java
import java.util.HashSet;
import java.util.Set;

public class OperacoesHashSet {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();

        // 1. INSERÇÃO
        conjunto.add("Golf");
        conjunto.add("Corsa");
        boolean adicionouDuplicado = conjunto.add("Golf"); // Retorna false e ignora!

        // 2. BUSCA (Ultra veloz)
        boolean temCorsa = conjunto.contains("Corsa"); // O(1) -> true

        // 3. REMOÇÃO
        conjunto.remove("Corsa"); // Remove pelo valor diretamente

        // 4. VERIFICAÇÃO
        int quantidade = conjunto.size(); // 1
        
        System.out.println("HashSet Final: " + conjunto); // [Golf]
    }
}

```

### TreeSet (Elementos Sempre Ordenados)

```java
import java.util.TreeSet;

public class OperacoesTreeSet {
    public static void main(String[] args) {
        // Usamos a classe concreta para expor operações de navegação de árvore
        TreeSet<String> conjunto = new TreeSet<>();

        // 1. INSERÇÃO (Armazena em ordem alfabética)
        conjunto.add("Golf");
        conjunto.add("Corsa");
        conjunto.add("Civic");

        // 2. OPERAÇÕES EXCLUSIVAS DE ÁRVORE (Buscas Avançadas)
        String primeiroAlfa = conjunto.first(); // Retorna o primeiro da ordem -> "Civic"
        String ultimoAlfa = conjunto.last();   // Retorna o último da ordem -> "Golf"
        
        // Retorna o maior elemento menor que o informado (quem vem antes de "Golf"?)
        String antesDoGolf = conjunto.lower("Golf"); // "Corsa"

        // 3. REMOÇÃO
        conjunto.remove("Civic");

        System.out.println("TreeSet Final: " + conjunto); // [Corsa, Golf]
    }
}

```

---

## 3. Os Mapas (HashMap e TreeMap)

Mapas gerenciam pares de **Chave-Valor**. Em vez de buscar por um número de índice, você busca pela Chave que você mesmo definiu.

### HashMap (Acesso Instantâneo por Chave)

```java
import java.util.HashMap;
import java.util.Map;

public class OperacoesHashMap {
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();

        // 1. INSERÇÃO / ATUALIZAÇÃO
        mapa.put("Placa-111", "Corsa");
        mapa.put("Placa-222", "Golf");
        mapa.put("Placa-111", "Civic"); // ATUALIZAÇÃO: Se a chave já existir, substitui o valor! ("Corsa" vira "Civic")

        // 2. BUSCA
        String carroPlaca222 = mapa.get("Placa-222"); // Retorna "Golf" [O(1)]
        String carroInexistente = mapa.get("Placa-999"); // Se não achar, retorna null

        // 3. VERIFICAÇÃO DE EXISTÊNCIA
        boolean temChave = mapa.containsKey("Placa-222"); // true
        boolean temValor = mapa.containsValue("Corsa");   // false (pois virou Civic)

        // 4. REMOÇÃO
        mapa.remove("Placa-222"); // Remove a chave e o valor associado a ela

        // 5. SEGURO CONTRA NULL (Boa prática)
        // Se não achar a chave, retorna o valor padrão informado no segundo parâmetro
        String carroSeguro = mapa.getOrDefault("Placa-999", "Carro Desconhecido"); 

        System.out.println("HashMap Final: " + mapa); // {Placa-111=Civic}
    }
}

```

### TreeMap (Chaves Automaticamente Ordenadas)

```java
import java.util.TreeMap;

public class OperacoesTreeMap {
    public static void main(String[] args) {
        // Usamos a classe concreta para expor métodos de navegação por chaves
        TreeMap<Integer, String> usuarios = new TreeMap<>();

        // 1. INSERÇÃO (Chave é o ID do usuário. Vai ordenar numericamente pelas chaves)
        usuarios.put(50, "Rafael");
        usuarios.put(10, "Joice");
        usuarios.put(30, "Lucas");

        // 2. BUSCA POR CHAVE
        String usuario30 = usuarios.get(30); // "Lucas"

        // 3. OPERAÇÕES DE NAVEGAÇÃO NA ÁRVORE DE CHAVES
        Integer menorId = usuarios.firstKey(); // Retorna a menor chave -> 10
        Integer maiorId = usuarios.lastKey();  // Retorna a maior chave -> 50
        
        // Busca o primeiro ID que seja MAIOR ou IGUAL a 25
        Integer idProximo = usuarios.ceilingKey(25); // 30

        System.out.println("TreeMap Ordenado por Chave: " + usuarios); 
        // Saída: {10=Joice, 30=Lucas, 50=Rafael}
    }
}

```

---

# Exemplo principais ações
Aqui está o guia definitivo com exemplos práticos rodando **todas as principais operações** que você vai usar no dia a dia com cada uma dessas estruturas: **Inserção**, **Busca**, **Remoção**, **Tamanho** e **Atualização/Verificação**.

---

## 1. As Listas (ArrayList e LinkedList)

As operações básicas de manipulação são idênticas porque ambas implementam a interface `List`, mas lembre-se de que o `ArrayList` é muito mais rápido para buscar por índice (`get`), enquanto o `LinkedList` oferece métodos extras para manipulação rápida nas pontas (`addFirst`, `removeFirst`).

### ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class OperacoesArrayList {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();

        // 1. INSERÇÃO
        lista.add("Corsa");
        lista.add("Golf");
        lista.add("Civic");

        // 2. BUSCA
        String segundoItem = lista.get(1); // Busca por ÍNDICE [O(1)] -> "Golf"
        boolean existeGolf = lista.contains("Golf"); // Busca por VALOR [O(n)] -> true

        // 3. ATUALIZAÇÃO
        lista.set(0, "Palio"); // Substitui o elemento do índice 0 ("Corsa" vira "Palio")

        // 4. REMOÇÃO
        lista.remove(2); // Remove pelo índice (Remove "Civic")
        lista.remove("Golf"); // Remove pelo valor diretamente

        // 5. TAMANHO / VERIFICAÇÃO
        int tamanho = lista.size(); // Retorna quantos itens restaram -> 1
        boolean estaVazia = lista.isEmpty(); // false

        System.out.println("ArrayList Final: " + lista); // [Palio]
    }
}

```

### LinkedList (Foco nas Pontas)

```java
import java.util.LinkedList;

public class OperacoesLinkedList {
    public static void main(String[] args) {
        // Usamos a referência da classe concreta para acessar métodos específicos das pontas
        LinkedList<String> lista = new LinkedList<>();

        // 1. INSERÇÃO (Normal e nas Pontas)
        lista.add("Golf");         // Adiciona no fim
        lista.addFirst("Corsa");    // Adiciona no INÍCIO [O(1)]
        lista.addLast("Civic");     // Adiciona no FIM [O(1)]

        // 2. BUSCA NAS PONTAS
        String primeiro = lista.getFirst(); // "Corsa"
        String ultimo = lista.getLast();   // "Civic"

        // 3. REMOÇÃO NAS PONTAS
        lista.removeFirst(); // Remove "Corsa" do início instantaneamente
        lista.removeLast();  // Remove "Civic" do fim instantaneamente

        System.out.println("LinkedList Final: " + lista); // [Golf]
    }
}

```

---

## 2. Os Conjuntos (HashSet e TreeSet)

Sets **não possuem índices** (você não consegue dar um `.get(0)`). O foco deles é garantir elementos únicos e fazer buscas por valor de forma extremamente rápida.

### HashSet (Busca Instantânea, Sem Ordem)

```java
import java.util.HashSet;
import java.util.Set;

public class OperacoesHashSet {
    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<>();

        // 1. INSERÇÃO
        conjunto.add("Golf");
        conjunto.add("Corsa");
        boolean adicionouDuplicado = conjunto.add("Golf"); // Retorna false e ignora!

        // 2. BUSCA (Ultra veloz)
        boolean temCorsa = conjunto.contains("Corsa"); // O(1) -> true

        // 3. REMOÇÃO
        conjunto.remove("Corsa"); // Remove pelo valor diretamente

        // 4. VERIFICAÇÃO
        int quantidade = conjunto.size(); // 1
        
        System.out.println("HashSet Final: " + conjunto); // [Golf]
    }
}

```

### TreeSet (Elementos Sempre Ordenados)

```java
import java.util.TreeSet;

public class OperacoesTreeSet {
    public static void main(String[] args) {
        // Usamos a classe concreta para expor operações de navegação de árvore
        TreeSet<String> conjunto = new TreeSet<>();

        // 1. INSERÇÃO (Armazena em ordem alfabética)
        conjunto.add("Golf");
        conjunto.add("Corsa");
        conjunto.add("Civic");

        // 2. OPERAÇÕES EXCLUSIVAS DE ÁRVORE (Buscas Avançadas)
        String primeiroAlfa = conjunto.first(); // Retorna o primeiro da ordem -> "Civic"
        String ultimoAlfa = conjunto.last();   // Retorna o último da ordem -> "Golf"
        
        // Retorna o maior elemento menor que o informado (quem vem antes de "Golf"?)
        String antesDoGolf = conjunto.lower("Golf"); // "Corsa"

        // 3. REMOÇÃO
        conjunto.remove("Civic");

        System.out.println("TreeSet Final: " + conjunto); // [Corsa, Golf]
    }
}

```

---

## 3. Os Mapas (HashMap e TreeMap)

Mapas gerenciam pares de **Chave-Valor**. Em vez de buscar por um número de índice, você busca pela Chave que você mesmo definiu.

### HashMap (Acesso Instantâneo por Chave)

```java
import java.util.HashMap;
import java.util.Map;

public class OperacoesHashMap {
    public static void main(String[] args) {
        Map<String, String> mapa = new HashMap<>();

        // 1. INSERÇÃO / ATUALIZAÇÃO
        mapa.put("Placa-111", "Corsa");
        mapa.put("Placa-222", "Golf");
        mapa.put("Placa-111", "Civic"); // ATUALIZAÇÃO: Se a chave já existir, substitui o valor! ("Corsa" vira "Civic")

        // 2. BUSCA
        String carroPlaca222 = mapa.get("Placa-222"); // Retorna "Golf" [O(1)]
        String carroInexistente = mapa.get("Placa-999"); // Se não achar, retorna null

        // 3. VERIFICAÇÃO DE EXISTÊNCIA
        boolean temChave = mapa.containsKey("Placa-222"); // true
        boolean temValor = mapa.containsValue("Corsa");   // false (pois virou Civic)

        // 4. REMOÇÃO
        mapa.remove("Placa-222"); // Remove a chave e o valor associado a ela

        // 5. SEGURO CONTRA NULL (Boa prática)
        // Se não achar a chave, retorna o valor padrão informado no segundo parâmetro
        String carroSeguro = mapa.getOrDefault("Placa-999", "Carro Desconhecido"); 

        System.out.println("HashMap Final: " + mapa); // {Placa-111=Civic}
    }
}

```

### TreeMap (Chaves Automaticamente Ordenadas)

```java
import java.util.TreeMap;

public class OperacoesTreeMap {
    public static void main(String[] args) {
        // Usamos a classe concreta para expor métodos de navegação por chaves
        TreeMap<Integer, String> usuarios = new TreeMap<>();

        // 1. INSERÇÃO (Chave é o ID do usuário. Vai ordenar numericamente pelas chaves)
        usuarios.put(50, "Rafael");
        usuarios.put(10, "Joice");
        usuarios.put(30, "Lucas");

        // 2. BUSCA POR CHAVE
        String usuario30 = usuarios.get(30); // "Lucas"

        // 3. OPERAÇÕES DE NAVEGAÇÃO NA ÁRVORE DE CHAVES
        Integer menorId = usuarios.firstKey(); // Retorna a menor chave -> 10
        Integer maiorId = usuarios.lastKey();  // Retorna a maior chave -> 50
        
        // Busca o primeiro ID que seja MAIOR ou IGUAL a 25
        Integer idProximo = usuarios.ceilingKey(25); // 30

        System.out.println("TreeMap Ordenado por Chave: " + usuarios); 
        // Saída: {10=Joice, 30=Lucas, 50=Rafael}
    }
}

```