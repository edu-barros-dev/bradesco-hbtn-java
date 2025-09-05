public class Post implements Comparable {

    private Autor autor;
    private String titulo, corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Object o) {
        Post outro = (Post) o;
        int cmp = titulo.compareTo(outro.titulo);
        if (cmp != 0) return cmp;
        cmp = corpo.compareTo(outro.corpo);
        if (cmp != 0) return cmp;
        cmp = autor.compareTo(outro.autor);
        if (cmp != 0) return cmp;
        return categoria.compareTo(outro.categoria);
    }

}