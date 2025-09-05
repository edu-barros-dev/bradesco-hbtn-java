import java.util.*;
import java.util.stream.Collectors;

public class Blog {

    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        for (Post p : postagens) {
            if (p.getAutor().equals(postagem.getAutor()) && p.getTitulo().equals(postagem.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        this.postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new HashSet<>();
        for (Post postagem : postagens) {
            autores.add(postagem.getAutor());
        }
        List<Autor> autoresOrdenados = new ArrayList<>(autores);
        autoresOrdenados.sort(Comparator.comparing(Autor::getNome));

        return new LinkedHashSet<>(autoresOrdenados);
    }

    public Map<Categorias, Integer> obterContagemPorCategoria () {

        Map<Categorias, Integer> contagem = new HashMap<>();
        for (Post p : postagens) {
            Categorias categoria = p.getCategoria();
            if (contagem.containsKey(categoria)) {
                contagem.put(categoria, contagem.get(categoria) + 1);
            } else {
                contagem.put(categoria, 1);
            }
        }
        return contagem.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> postsPorAutor = new TreeSet<>(Comparator.comparing(Post::getTitulo));
        for (Post postagem : postagens) {
            if (postagem.getAutor().getNome().equals(autor.getNome())) {
                postsPorAutor.add(postagem);
            }
        }
        return postsPorAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> postsPorCategoria = new TreeSet<>(Comparator.comparing(Post::getTitulo));
        for (Post postagem : postagens) {
            if (postagem.getCategoria() == categoria) {
                postsPorCategoria.add(postagem);
            }
        }
        return postsPorCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postsPorCategoria = new TreeMap<>();
        for (Post postagem : postagens) {
            Categorias categoria = postagem.getCategoria();
            if (!postsPorCategoria.containsKey(categoria)) {
                postsPorCategoria.put(categoria, new TreeSet<>(Comparator.comparing(Post::getTitulo)));
            }
            postsPorCategoria.get(categoria).add(postagem);
        }
        return postsPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new TreeMap<>();
        for (Post postagem : postagens) {
            Autor autor = postagem.getAutor();
            if (!postsPorAutor.containsKey(autor)) {
                postsPorAutor.put(autor, new TreeSet<>(Comparator.comparing(Post::getTitulo)));
            }
            postsPorAutor.get(autor).add(postagem);
        }
        return postsPorAutor;
    }

}