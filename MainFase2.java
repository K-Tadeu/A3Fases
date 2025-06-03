import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MainFase2 {
    public static void main(String[] args) {
        try {
            // Entrada e saída
            String caminhoEntrada = "C:\\Users\\822145075\\Documents\\Estrutura de Dados\\a3\\resourcesFase2\\fase2_entrada.txt";
            String caminhoSaida = "C:\\Users\\822145075\\Documents\\Estrutura de Dados\\a3\\resourcesFase2\\fase2_saida.txt";

            // Grupos fictícios para testar
            PessoasConhecemPessoas estrutura = new PessoasConhecemPessoas();
            estrutura.criarGrupo(List.of("Ana", "Bia", "Guga", "Pedro"));
            estrutura.criarGrupo(List.of("Joao", "Olga"));
            estrutura.criarGrupo(List.of("Maria", "Manuel", "Alface"));

            // Executa o parser
            ParserFase2 parser = new ParserFase2(estrutura);
            parser.executar(caminhoEntrada, caminhoSaida);

            System.out.println("Fase 2 executada com sucesso!");
            System.out.println("Saída gerada em: " + caminhoSaida);

            // Mostrar resultado no console também
            System.out.println("\nConteúdo da saída:");
            Files.readAllLines(Paths.get(caminhoSaida)).forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
