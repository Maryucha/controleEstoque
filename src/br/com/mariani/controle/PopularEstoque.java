package br.com.mariani.controle;

import br.com.mariani.modelo.Estoque;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class PopularEstoque {

    File arquivo = new File("D:\\Cursos\\SENAI\\VOID\\controleEstoque\\desenv\\carga.csv");
    Scanner sc = null;

    public List<Estoque> cargaPorScanner() throws InterruptedException {
        List<Estoque> lista = new ArrayList<>();

        try {
            sc = new Scanner(arquivo);
            while (sc.hasNextLine()) {

                String linhaProduto = sc.nextLine();
                System.out.println("Linha: " + linhaProduto);
                String[] vec = linhaProduto.split(";");

                System.out.println("Nome: " + vec[0]);
                System.out.println("Preço: " + vec[1]);
                System.out.println("Quantidade: " + vec[2]);

                System.out.println();
                Estoque e = new Estoque();
                e.setNome(vec[0]);
                e.setValor(Double.parseDouble(vec[1]));
                e.setQtdProduto(Integer.parseInt(vec[2]));

                lista.add(e);

            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();

                System.out.println("Carregando...");
                Thread.sleep(1000);
                System.out.println("Produtos carregados com sucesso!");
            }
        }
        return lista;
    }
}
