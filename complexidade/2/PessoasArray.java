public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {
        nomes =new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    // implementar o método de buscaBinaria
    public void buscaBinaria(String nome){
        boolean encontrado = false;
        System.out.printf("Procurando o nome: \"%s\"\n", nome);
        int inicio = 0;
        int fim = nomes.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            System.out.printf("Passando pelo indice: %d\n", meio);
            if (nomes[meio].equals(nome)) {
                encontrado = true;
                System.out.printf("Nome %s encontrado na posição %d\n", nome, meio);
                break;
            } else if (nomes[meio].compareTo(nome) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            throw new java.lang.IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }

    }
}