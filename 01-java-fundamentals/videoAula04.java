/*
* Arquivo no padrão JEP 512 (https://openjdk.org/jeps/512)
* Promove uma escrita de pequenos programas concisos, sem a necessidade de construções destinadas à programação em larga escala.
*/

void main() {
    IO.println("------");
    IO.println("Arrays");
    IO.println("------");

    double[] precos = new double[7]; // O array obrigatórioamente precisa ter o tamanho definido no momento da criação 

    precos[0] = 2.99;
    precos[1] = 3.50;
    precos[2] = 12.99;
    precos[3] = 4.99;
    precos[4] = 2.50;
    precos[5] = 4.99;
    precos[6] = 25.90;

    boolean[] emPromocao = {false, true, true, true, true, true, false}; // declaração literal
    
    IO.println("Preco do item 3: " + precos[2]);
    IO.println("Tamanho do Array de precos: " + precos.length);
    IO.println("Tamanho do Array emPromocao: " + emPromocao.length);

    IO.println("O item 3 esta é promoção?  " + emPromocao[2]);

    double totalDePrecos = 0.0;
    int contador = 0;
    while (contador < precos.length) {
        double preco = precos[contador];
        totalDePrecos = totalDePrecos + preco;
        contador++;
    }

    IO.println("Soma dos preços: " + totalDePrecos);



}