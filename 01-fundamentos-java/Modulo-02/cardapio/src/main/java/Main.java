import com.google.gson.Gson;
import mx.florinda.cardapio.ItemCardapio;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ItemCardapio refrescoDoChaves = new ItemCardapio(1L, "Refresco do Chaves", """
                Sico de limão, que parece tamarino mas que tem gosto groselha""", ItemCardapio.CategoriaCardapio.BEBIDAS, new BigDecimal("9.99"), null);

        Gson gson = new Gson();
        String json = gson.toJson(refrescoDoChaves);

        System.out.println(json);

    }
}
