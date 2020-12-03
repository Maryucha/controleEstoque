package br.com.mariani.main;

import br.com.mariani.controle.ControleEstoque;


/**
 *
 * @author maryucha
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException {

        ControleEstoque controle = new ControleEstoque();
        controle.controle();
    }
}
