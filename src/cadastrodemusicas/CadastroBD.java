package cadastrodemusicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroBD {
    
    private Connection getConnection(){
        String url = "jdbc:postgresql://localhost/trablp3?user=postgres&password=postgres";
        Connection conn; 
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex){
          ex.printStackTrace();
          conn = null;
        }
        return conn;
    }

   public void incluir(Musica musica)  {
      String sql = "INSERT INTO musica (titulo, genero, artista, compositor) VALUES (?,?,?,?)";
      Connection bd = getConnection();
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setString(1, musica.getTitulo());
          sentenca.setString(2, musica.getGenero());
          sentenca.setString(3, musica.getArtista());
          sentenca.setString(4, musica.getCompositor());
          sentenca.execute();
          sentenca.close();
          bd.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
  }
    
      public void listar() {
      Connection bd = getConnection();
      String sql = "SELECT * FROM musica ORDER BY id";
      String listaMusicas = "Lista de musicas\n";
      try {
          Statement sentenca = bd.createStatement();
          ResultSet resultado = sentenca.executeQuery(sql);
          while(resultado.next()) {
              int id = resultado.getInt("id");
              String titulo = resultado.getString("titulo");
              String genero = resultado.getString("genero");
              String artista = resultado.getString("artista");
              String compositor = resultado.getString("compositor");
              Musica musica = new Musica(id, titulo, genero , artista, compositor);
              listaMusicas += "\n"+musica;
          }
          JOptionPane.showMessageDialog(null, listaMusicas);
          resultado.close();
          sentenca.close();
          bd.close();
      } catch (SQLException ex) {
          System.out.println("Erro");
      }
  }
    public void excluir(String titulo){
      String sql = "DELETE FROM musica WHERE titulo=?";
      Connection bd = getConnection();
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setString(1, titulo);
          sentenca.execute();
          sentenca.close();
          bd.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
    }
    
    public void alterar(Musica musica){
           String sql = "UPDATE musica SET titulo=?, genero=?, artista=?, compositor=? WHERE id=?";
      Connection bd = getConnection();
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setString(1, musica.getTitulo());
          sentenca.setString(2, musica.getGenero());
          sentenca.setString(3, musica.getArtista());
          sentenca.setString(4, musica.getCompositor());
          sentenca.setInt(5, musica.getId());
          sentenca.execute();
          sentenca.close();
          bd.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
    }
    
    public Musica getMusicaByTitulo(String titulo){
      String sql = "SELECT * FROM musica WHERE titulo=?";
      Connection bd = getConnection();
      Musica musica = null;
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setString(1, titulo);
          ResultSet resultado = sentenca.executeQuery();
          
          if(resultado.next()) {
              int id = resultado.getInt("id");
              String genero = resultado.getString("genero");
              String artista = resultado.getString("artista");
              String compositor = resultado.getString("compositor");
              musica = new Musica(id, titulo, genero, artista, compositor);
          }
          resultado.close();
          sentenca.close();
          bd.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }

      return musica;
    }

}
