package br.com.mariani.modelo;

import java.util.Scanner;

/**
 *
 * @author maryucha
 */
public class Estoque {

    private Scanner entrada = new Scanner(System.in);
    private String nome;
    private double valor;
    private int qtdProduto;
    private int id;

    public Estoque() {

    }

    public Estoque(String nome, double valor, int qtdProduto, int id) {
        this.nome = nome;
        this.valor = valor;
        this.qtdProduto = qtdProduto;
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public void cadProduto() {
        System.out.println("-----------FICHA DO PRODUTO--------");
        System.out.print("Digite o nome do seu produto: ");
        this.setNome(entrada.nextLine());
        System.out.print("Digite o ID: ");
        this.setId(entrada.nextInt());
        entrada.nextLine();
        System.out.print("Digite o valor: ");
        this.setValor(entrada.nextDouble());
        entrada.nextLine();
        System.out.print("Digite a quantidade: ");
        this.setQtdProduto(entrada.nextInt());
        entrada.nextLine();
    }
   
    public void editarProduto(){
        System.out.println("-----------FICHA DO PRODUTO--------");
        System.out.print("Digite o nome do seu produto: ");
        this.setNome(entrada.nextLine());
        System.out.print("Digite o valor: ");
        this.setValor(entrada.nextDouble());
        entrada.nextLine();
        System.out.print("Digite a quantidade: ");
        this.setQtdProduto(entrada.nextInt());
        entrada.nextLine();
    }
    
    public Estoque criaProduto(){
        Estoque listaProdutos = new Estoque();
        listaProdutos.cadProduto();
        return listaProdutos;
    }
    
    public void imprime(){
        System.out.println("ID ["+this.getId()+"] PRODUTO ["+this.getNome()+"] | VALOR ["+this.getValor()+"] | QUANTIDADE ["+this.getQtdProduto()+"]");
    }

}
