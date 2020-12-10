package br.com.mariani.controle;

import br.com.mariani.modelo.Estoque;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author maryucha
 */
public class ControleEstoque {

    static List<Estoque> listaProdutos = new ArrayList<Estoque>();
    static Estoque produto = new Estoque();
    private Scanner entrada = new Scanner(System.in);
    private Integer menu = 0;
    
     JSONParser jsonParser = new JSONParser();

        String StringJson = ControleEstoque.carregarListaProdutoJSONSTRING();

        

    public void controle() throws InterruptedException, ParseException {

        JSONParser jsonParser = new JSONParser();

        String StringJson = ControleEstoque.carregarListaProdutoJSONSTRING();

        JSONArray jobj = (JSONArray) jsonParser.parse(StringJson);

      
        do {
            try {
                System.out.println("============MENU PRINCIPAL============="
                        + "\n1 Cadastrar produto: "
                        + "\n2 Mostrar Produtos: "
                        + "\n3 Editar Produto: "
                        + "\n4 Excluir produto: "
                        + "\n5 Popular Automático: "
                        + "\n6 Criar Lista de Valor do Estoque: "
                        + "\n7 Ler arquivo Json: "
                        + "\n8 Popular lista de produtos pelo JsonJson: "
                        + "\n9 Sair: "
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
                        cargaPorScanner();
                        break;
                    case 6:
                        descarregarNoDocumento(listaProdutos);
                        break;
                    case 7:
                        carregarListaProdutoJSONSTRING();
                        break;
                    case 8:
                        popularListaProdutosTirandoDoJson();
                        break;
                    case 9:
                        System.out.println("Até logo!");
                        break;    
                    default:
                        System.out.println("Escolha uma opção válida!");
                        break;
                }
            }

        } while (menu != 9);

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

    public void descarregarNoDocumento(List<Estoque> listaProdutos) {
        String path = "D:\\Cursos\\SENAI\\VOID\\controleEstoque\\desenv\\valorEstoque.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {  // abre o arquivo
            for (Estoque linhaProdutos : listaProdutos) {
                bw.write("NOME: " + linhaProdutos.getNome()
                        + "\nVALOR: " + linhaProdutos.getValor()
                        + "\nQUANTIDADE: " + linhaProdutos.getQtdProduto()
                        + "\nVALOR ESTOQUE: " + (linhaProdutos.getValor() * linhaProdutos.getQtdProduto())
                        + "\n------------------------------------------------------------------------------");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Estoque> cargaPorScanner() throws InterruptedException {
        File arquivo = new File("D:\\Cursos\\SENAI\\VOID\\controleEstoque\\desenv\\carga.csv");
        Scanner sc = null;

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

                listaProdutos.add(e);

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
        return listaProdutos;
    }

    public static String carregarListaProdutoJSONSTRING() {
        File file = new File("D:\\Cursos\\SENAI\\VOID\\controleEstoque\\desenv\\produtos.json");
        Scanner sc = null;
        String aux = "";
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {

                aux += sc.nextLine();

            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return aux;
    }
    
    public void popularListaProdutosTirandoDoJson() throws ParseException{
        
        JSONArray jsonArray = (JSONArray) jsonParser.parse(StringJson);
        
              
      for(int i=0;i<jsonArray.size();i++){
          Estoque e = new Estoque(); 
          JSONObject objetoJson = (JSONObject) jsonArray.get(i);
          e.setId(i);
          e.setNome(objetoJson.get("nome").toString());
          e.setValor(Double.parseDouble(objetoJson.get("preco").toString()));
          e.setQtdProduto(Integer.parseInt(objetoJson.get("quantidade").toString())); 
          listaProdutos.add(e);
      }
      
      //System.out.println(jsonArray.toString());
    }

}
