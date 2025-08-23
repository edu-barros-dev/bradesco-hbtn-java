import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWritingExercise {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();


        // implemente o codigo aqui

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            String line;
            System.out.println("Digite linhas de texto (digite 'sair' para terminar):");
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("sair")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        } finally{
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Ocorreu um erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
        System.out.println("Arquivo salvo com sucesso!");
        scanner.close();
    }

}