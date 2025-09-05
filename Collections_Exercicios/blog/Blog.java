import java.util.*;

public class Blog {

    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        this.postagens.add(postagem);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post postagem : postagens) {
            autores.add(postagem.getAutor());
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria () {

        Map<String, Integer> contagem = new TreeMap<>();

        for (Post p : postagens) {
            String categoria = p.getCategoria();
            if (contagem.containsKey(categoria)) {
                contagem.put(categoria, contagem.get(categoria) + 1);
            } else {
                contagem.put(categoria, 1);
            }
        }

        return contagem;

    }

}