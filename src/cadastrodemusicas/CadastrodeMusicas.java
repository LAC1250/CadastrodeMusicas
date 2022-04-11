package cadastrodemusicas;

import java.awt.Label;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CadastrodeMusicas {
    public static void main(String[] args) {
       int opcao = 0;
       CadastroBD cadastro = new CadastroBD();
       while(opcao != 5){
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1-Listar\n2-Incluir\n3-Excluir\n4-Alterar\n5-Sair\nDigite Opção Desejada: "));
            switch(opcao){
               case 1: {
                  cadastro.listar();
                  break;
                } 
               case 2: {
                    String titulo = JOptionPane.showInputDialog("Informe o titulo: ");
                    String genero = JOptionPane.showInputDialog("Informe o genero: ");
                    String artista = JOptionPane.showInputDialog("Informe o artista: ");
                    String compositor = JOptionPane.showInputDialog("Informe o compositor: ");
                    Musica musica = new Musica(0, titulo, genero, artista, compositor);
                    cadastro.incluir(musica);
                    break;
                }
               case 3: {
                    String titulo = JOptionPane.showInputDialog("Informe o titulo: ");
                    cadastro.excluir(titulo);
                    break;
                }
               case 4: {
                    String titulo = JOptionPane.showInputDialog("Informe o titulo: ");
                    Musica MusicaAntiga = cadastro.getMusicaByTitulo(titulo);
                    if (MusicaAntiga != null) {
                        JOptionPane.showMessageDialog(null, MusicaAntiga);
                        int id = MusicaAntiga.getId();
                        String genero = JOptionPane.showInputDialog("Informe o genero: ");
                        String artista= JOptionPane.showInputDialog("Informe o artista: ");
                        String compositor = JOptionPane.showInputDialog("Informe o compositor: ");
                        Musica musica = new Musica(id, titulo, genero, artista, compositor);
                        cadastro.alterar(musica);
                    } else {
                        JOptionPane.showMessageDialog(null, "Musica não encontrada");
                    }
                    break;                  
     
               }
                case 5: {
                    JOptionPane.showMessageDialog(null, "encerrando ...");
                    break;
                }
                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida, tente novamente");
            }
       }
    }   
}
