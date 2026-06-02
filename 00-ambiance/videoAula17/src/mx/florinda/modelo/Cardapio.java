package mx.florinda.modelo;

import mx.florinda.leitor.LeitorItensCardapio;

import java.io.IOException;

public class Cardapio {

    private final ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {
        LeitorItensCardapio leitor = LeitorItensCardapio.criarLeitor(nomeArquivo);
        if (leitor != null) {
            itens = leitor.processaArquivo();
        } else {
            IO.println("Arquivo com extensão inválida:  " + nomeArquivo);
            itens = new ItemCardapio[0];
        }

    }

    public ItemCardapio getItemPorId(long idSelecionado) {
        return itens[((int) idSelecionado) - 1];
    }

    public ItemCardapio[] getItens() {
        return itens;
    }

    public double getSomaDosPrecos() {
        double totalDePrecos = 0.0;
        for (ItemCardapio item : itens) {
            totalDePrecos += item.getPreco();
        }
        return totalDePrecos;
    }

    public int getTotalDeItensEmPromocao() {
        int totalItensEmPromocao = 0;
        for (ItemCardapio item : itens) {
            if (item.isEmPromocao()) {
                totalItensEmPromocao++;
            }
        }
        return totalItensEmPromocao;
    }

    public double getPrimeiroPrecoMaiorQueLimite(double precoLimite) {
        double precoMaiorQueLimite = -1.0;
        for (ItemCardapio item : itens) {
            if (item.getPreco() > precoLimite) {
                precoMaiorQueLimite = item.getPreco();
                break;
            }
        }

        return precoMaiorQueLimite;
    }
}