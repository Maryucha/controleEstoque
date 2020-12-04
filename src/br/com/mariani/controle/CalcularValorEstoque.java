package br.com.mariani.controle;

import br.com.mariani.modelo.Estoque;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

/**
 *
 * @author maryucha
 */
public class CalcularValorEstoque {

    public void salvaListaValorEstoque(List<Estoque> lista) throws InterruptedException {
       
        String path = "D:\\Cursos\\SENAI\\VOID\\controleEstoque\\desenv\\valorEstoque.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {  // abre o arquivo
            for (Estoque linhaProdutos : lista) {                
//                bw.write("NOME: " + linhaProdutos.getNome()
//                        + "\nVALOR: " + linhaProdutos.getValor()
//                        + "\nQUANTIDADE: " + linhaProdutos.getQtdProduto()
//                        + "\nVALOR ESTOQUE: " + (linhaProdutos.getValor() * linhaProdutos.getQtdProduto()));
//                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
