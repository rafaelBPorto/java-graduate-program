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



    }
}