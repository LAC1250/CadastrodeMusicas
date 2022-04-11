package cadastrodemusicas;

import java.util.Objects;

public class Musica {
    private int id;
    private String titulo;
    private String genero;
    private String artista;
    private String compositor;

    public Musica(int id, String titulo, String genero, String artista, String compositor) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.artista= artista;
        this.compositor = compositor;
    }

    @Override
    public String toString() {
        return "Musica{id= " + id + "titulo=" + titulo + ", genero=" + genero + ", artista=" + artista + ", compositor=" + compositor + '}';
    }

    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musica other = (Musica) obj;
        if(!Objects.equals(this.titulo, other.titulo)){
             return false;
        }
        return true;
    }
    
    
}
