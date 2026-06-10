package mx.florinda.cardapio;

import java.math.BigDecimal;

public record ItemCardapio(
            Long id,
            String name,
            String description,
            CategoriaCardapio categoria,
            BigDecimal preco,
            BigDecimal precoComDesconto
) {

    public enum CategoriaCardapio {
        ENTRADAS, PRATOS_PRINCIPAIS, BEBIDAS, SOBREMESA;
    }

}
