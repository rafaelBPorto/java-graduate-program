package mx.florinda.leitor;

public class FabricaLeitoItensCardapio {

    public LeitorItensCardapio criarLeitor(String nomeArquivo) {
        LeitorItensCardapio leitor = null;
        if (nomeArquivo.endsWith(".csv")) {
            leitor = new LeitorItensCardapioCSV();
        } else if (nomeArquivo.endsWith(".json")) {
            leitor = new LeitorItensCardapioJSON();
        }
        return leitor;
    }
}
