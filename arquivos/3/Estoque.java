import java.io.*;
import java.util.*;

public class Estoque {
    private List<Produto> produtos;
    private String caminhoArquivo;

    public Estoque(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        this.produtos = new ArrayList<>();
        carregarProdutos();
    }

    // Carrega produtos do arquivo CSV
    private void carregarProdutos() {
        produtos.clear();
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
                return;
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] partes = linha.split(",");
                if (partes.length != 4) continue;
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                int quantidade = Integer.parseInt(partes[2]);
                double preco = Double.parseDouble(partes[3]);
                produtos.add(new Produto(id, nome, quantidade, preco));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    // Salva produtos no arquivo CSV
    private void salvarProdutos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    // Gera um novo ID único
    private int gerarNovoId() {
        int maxId = 0;
        for (Produto p : produtos) {
            if (p.getId() > maxId) maxId = p.getId();
        }
        return maxId + 1;
    }

    // Adiciona um novo produto
    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (quantidade < 0 || preco < 0) {
            System.out.println("Quantidade e preço devem ser positivos.");
            return;
        }
        int novoId = gerarNovoId();
        Produto novoProduto = new Produto(novoId, nome, quantidade, preco);
        produtos.add(novoProduto);
        salvarProdutos();
    }

    // Exclui produto pelo ID
    public void excluirProduto(int id) {
        boolean removido = produtos.removeIf(p -> p.getId() == id);
        if (removido) {
            salvarProdutos();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // Exibe todos os produtos
    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    // Atualiza quantidade de produto pelo ID
    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("Quantidade deve ser positiva.");
            return;
        }
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);
                salvarProdutos();
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
}