package br.com.mariani.main;

import br.com.mariani.controle.ControleEstoque;
import br.com.mariani.modelo.Estoque;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maryucha
 */
public class Principal {

    public static void main(String[] args) {

        ControleEstoque controle = new ControleEstoque();
        controle.controle();
    }
}
