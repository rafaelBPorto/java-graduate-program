class Cardapio {

    ItemCardapio[] itens;

    Cardapio() {
        ItemCardapio item1 = new ItemCardapio(1L, "Refresco do Chaves", "Suco de limão que parece de tamarindo e tem gosto de groselha.", 2.99, CategoriaCardapio.BEBIDAS);

        ItemCardapio item2 = new ItemCardapio(2L, "Sanduíche de Presunto do Chaves", "Sanduíche de presunto simples, mas feito com muito amor.", 3.50, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item2.definePromocao(2.99);

        ItemCardapio item3 = new ItemCardapio(3L, "Torta de Frango da Dona Florinda", "Torta de frango com recheio cremoso e massa crocante.", 12.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item3.definePromocao(10.99);

        ItemCardapio item4 = new ItemCardapioIsento(4L, "Pipoca do Quico", "Balde de pipoca preparado com carinho pelo Quico.", 4.99, CategoriaCardapio.PRATOS_PRINCIPAIS);
        item4.definePromocao(3.99);

        ItemCardapio item5 = new ItemCardapio(5L, "Água de Jamaica", "Água aromatizada com hibisco e toque de açúcar.", 2.5, CategoriaCardapio.SOBREMESAS);
        item5.definePromocao(2.0);

        ItemCardapioIsento item6 = new ItemCardapioIsento(6L, "Churros do Chaves", "Churros recheados com doce de leite, clássicos e irresistíveis.", 4.99, CategoriaCardapio.SOBREMESAS);
        item6.definePromocao(3.99);

        ItemCardapioIsento item7 = new ItemCardapioIsento(7L, "Tacos de Carnitas", "Tacos recheados com carne tenra", 25.9, CategoriaCardapio.PRATOS_PRINCIPAIS);

        // Variael ItemCardapio pode receber ItemCardapio ou qualque classe filha como exemplo ItemCardapioIsento
        itens = new ItemCardapio[7];
        itens[0] = item1;
        itens[1] = item2;
        itens[2] = item3;
        itens[3] = item4; // Consigo colocar objetos da classe filha
        itens[4] = item5;
        itens[5] = item6; // Consigo colocar objetos da classe filha
        itens[6] = item7; // Consigo colocar objetos da classe filha
    }

    double obtemSomaDosPrecos() {
        double totalDePrecos = 0.0;
        for (ItemCardapio item : itens) {
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