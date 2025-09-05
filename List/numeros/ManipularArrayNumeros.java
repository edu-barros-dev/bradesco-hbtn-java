import java.util.List;

public abstract class ManipularArrayNumeros {

    static int buscarPosicaoNumero (List<Integer> numeros, int numero) {
        return numeros.indexOf(numero);
    }

    static void adicionarNumero (List<Integer> numeros, int numero) throws Exception {
        if (buscarPosicaoNumero(numeros, numero) != -1) {
            throw new Exception("Numero jah contido na lista");
        }
        numeros.add(numero);
    }

    static void removerNumero (List<Integer> numeros, int numero) throws Exception {
        int posicao = buscarPosicaoNumero(numeros, numero);
        if (posicao == -1) {
            throw new Exception("Numero nao encontrado na lista");
        }
        numeros.remove(posicao);
    }

    static void substituirNumero (List<Integer> numeros, int numeroSubstituir, int numeroSubstituto) throws Exception {
        int posicao = buscarPosicaoNumero(numeros, numeroSubstituir);
        if (posicao == -1) {
            adicionarNumero(numeros, numeroSubstituto);
        } else {
            numeros.set(posicao, numeroSubstituto);
        }
    }

}