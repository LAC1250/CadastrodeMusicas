package cadastrodemusicas;
import java.sql.Connection;
import java.util.Scanner;
public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroBD cadastro = new CadastroBD();
        /*Connection bd = cadastro.getConnection();
        System.out.println(bd);*/
        System.out.println("titulo: ");
        String titulo = sc.nextLine();
        System.out.println("genero: ");
        String genero = sc.nextLine();
        System.out.println("artista: ");
        String artista = sc.nextLine();
        System.out.println("compositor: ");
        String compositor = sc.nextLine();
        
        //Musica musica = new Musica(id,titulo, genero, artista, compositor);
        //cadastro.incluir(musica);
        System.out.println("incluido");
    }
}
