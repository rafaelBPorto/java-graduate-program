package mx.florinda.modelo;

import mx.florinda.modelo.isento.ItemCardapioIsento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Cardapio {

    private final ItemCardapio[] itens;

    public Cardapio(String nomeArquivo) throws IOException {
        Path arquivo = Path.of(nomeArquivo);
        String conteudoArquivo = Files.readString(arquivo);
        String[] linhasArquivo = conteudoArquivo.split("\n");

        itens = new ItemCardapio[linhasArquivo.length];

        for(int i = 0; i < linhasArquivo.length; i++) {
            String linha = linhasArquivo[i];
            if (nomeArquivo.endsWith(".csv")){
                // tratar csv

                String[] partes = linha.split(";");
                long id = Long.parseLong(partes[0]);
                String nome = partes[1];
                String descricao = partes[2];
                double preco = Double.parseDouble(partes[3]);
                CategoriaCardapio categoria = CategoriaCardapio.valueOf(partes[4]);

                ItemCardapio item;
                boolean impostoIsento = Boolean.parseBoolean(partes[7]);
                if (impostoIsento) {
                    item = new ItemCardapioIsento(id, nome, descricao, preco, categoria);
                } else {
                    item = new ItemCardapio(id, nome, descricao, preco, categoria);
                }

                boolean emPromocao = Boolean.parseBoolean((partes[5]));
                if(emPromocao){
                    double precoDesconto = Double.parseDouble(partes[6]);
                    item.setPromocao(precoDesconto);
                }

                itens[i] = item;

            } else if ( nomeArquivo.endsWith(".json")) {
                // tratar json
            } else {
                IO.println("Arquivo com extensão inválida:  " + nomeArquivo);
            }
        }

    }

    public ItemCardapio getItemPorId(long idSelecionado){
        return itens [((int) idSelecionado)-1];
    }

    public ItemCardapio[] getItens(){
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