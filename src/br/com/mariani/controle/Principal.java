package br.com.mariani.controle;

import br.com.mariani.controle.ControleEstoque;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author maryucha
 */
public class Principal {

    public static void main(String[] args) throws InterruptedException, ParseException {

        ControleEstoque controle = new ControleEstoque();
        controle.controle();
    }
}
