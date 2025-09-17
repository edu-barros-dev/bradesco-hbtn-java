import java.util.List;
import java.util.stream.Collectors;

public class ConsultaProdutos {

    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {

        return produtos.stream()
                .filter(p -> criterio.testar(p))
                .collect(Collectors.toList());

    }

}