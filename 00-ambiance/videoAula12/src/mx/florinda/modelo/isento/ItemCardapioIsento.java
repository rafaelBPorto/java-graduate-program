package mx.florinda.modelo.isento;

import mx.florinda.modelo.CategoriaCardapio;
import mx.florinda.modelo.ItemCardapio;

// ItemCardapioIsento é um  ItemCardapio
public class ItemCardapioIsento extends ItemCardapio {


    // construtor
    public ItemCardapioIsento(long id, String nome, String descricao, double preco, CategoriaCardapio categoria) {
        //super refere-se aos itens da classe mãe
        super(id, nome, descricao, preco, categoria);
    }

    //  reescrita de metodo (override)
    // Anaotação (notation) Não é obrigatório mas é um indicador que este metodo foi reescrito
    // Também fornce dica a IDE se o nome for modificado na classe mãe
    @Override
    public double getImposto() {
        return 0.0;
    }
}