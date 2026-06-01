package mx.florinda.cli;

public class TesteString {
    void main() {
        String nomeItem1 = "Refresco do Chaves";

        IO.println(nomeItem1.toUpperCase());
        IO.println(nomeItem1.toLowerCase());
        IO.println(nomeItem1.length());
        IO.println(nomeItem1.charAt(0));
        IO.println(nomeItem1.charAt(1));

        IO.println(nomeItem1.toLowerCase().replace(" ", "-"));
        IO.println(nomeItem1.contains("Chaves"));
        IO.println(nomeItem1.contains("chaves"));
        IO.println(nomeItem1.contains("Kiko"));
        IO.println(nomeItem1.startsWith("Chaves"));
        IO.println(nomeItem1.startsWith("Chaves"));
        IO.println(nomeItem1.substring(0, 8));

        // Comparar conteudo de string
        IO.println(nomeItem1.equals("Refresco do Chaves"));
        IO.println(nomeItem1.equalsIgnoreCase("refresco do chaves"));

        // Nada do que foi feito altera a string original
        // String é imutável
        IO.println(nomeItem1);

        // Com o StringBuilder a string se torma mutável

        long inicio = System.currentTimeMillis();
        String teste = "";
        for (int i = 0; i< 1_000; i++){
            teste += i + ", ";
        }
        long fim = System.currentTimeMillis();
        IO.println("Tempo com string imutavel: " + (fim - inicio) +" ms");
        IO.println(teste);

        long inicioSB = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< 1_000; i++){
            builder.append(i).append(", ");
        }
        long fimSB = System.currentTimeMillis();
        IO.println("Tempo com StringBuilder: " + (fimSB - inicioSB) +" ms");
        IO.println(builder);

    /**
     * Toda concatenação com "a" + "b" utiliza o StringBuilder
     */
    }
}