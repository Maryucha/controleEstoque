package br.com.mariani.controle;

import br.com.mariani.modelo.Estoque;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class ControleEstoque {

    List<Estoque> listaProdutos = new ArrayList<Estoque>();
    Estoque produto = new Estoque();
    Scanner entrada = new Scanner(System.in);
    Integer menu = 0;
    PopularEstoque carrregamento = new PopularEstoque();
    CalcularValorEstoque calculadora = new CalcularValorEstoque();

    public void controle() throws InterruptedException {
        do {
            try {
                System.out.println("============MENU PRINCIPAL============="
                        + "\n1 Cadastrar produto: "
                        + "\n2 Mostrar Produtos: "
                        + "\n3 Editar Produto: "
                        + "\n4 Excluir produto: "
                        + "\n5 Popular Automático: "
                        + "\n6 Criar Lista de Valor do Estoque: "
                        + "\n7 Sair: "
                        + "\n===============================================");
                menu = entrada.nextInt();
                entrada.nextLine();
            } catch (HeadlessException | NumberFormatException e) {
                menu = null;
            }
            if (menu != null) {
                switch (menu) {
                    case 1:
                        listaProdutos.add(produto.criaProduto());
                        break;
                    case 2:
                        imprimeEstoque();
                        break;
                    case 3:
                        editaListaProdutos();
                        break;
                    case 4:
                        removeProduto();
                        break;
                    case 5:
                        listaProdutos=carrregamento.cargaPorScanner();
                        break;
                    case 6:
                        calculadora.salvaListaValorEstoque(listaProdutos);
                        break;    
                    case 7:
                        System.out.println("Até logo!");
                        break;    
                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }

        } while (menu != 7);

        System.out.println("-------------------------------------------------");

    }

    public void imprimeEstoque() {
        System.out.println("-------------PRODUTOS EM ESTOQUE------------");
        if (listaProdutos.isEmpty()) {
            System.out.println("Ainda não temos produtos cadastrados!");
        } else {
            for (int i = 0; i < listaProdutos.size(); i++) {
                listaProdutos.listIterator(i).next().imprime();
            }
        }
    }

    public void editaListaProdutos() {
        System.out.println("-----------EDITAR---------");
        System.out.print("Digite o ID do produto que deseja editar: ");
        int id = entrada.nextInt();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id) {
                listaProdutos.get(i).editarProduto();
                System.out.println("Produto editado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
            imprimeEstoque();
        }
    }

    public void removeProduto() {
        System.out.println("-----------REMOVER---------");
        System.out.print("Digite o ID do produto que deseja Excluir: ");
        int id = entrada.nextInt();
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getId() == id) {
                listaProdutos.remove(i);
                System.out.println("Produto Removido com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
            imprimeEstoque();
        }
    }
}
