import java.io.*;
import java.util.*;

public class ParserFase2 {

    private PessoasConhecemPessoas estruturaGrupos;
    private GerenciadorDeFilas gerenciador;

    public ParserFase2(PessoasConhecemPessoas estrutura) {
        this.estruturaGrupos = new PessoasConhecemPessoas();
        this.gerenciador = new GerenciadorDeFilas();
    }

    public void executar(String entrada, String saida) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(entrada));
        BufferedWriter writer = new BufferedWriter(new FileWriter(saida));
        String linha;

        while ((linha = reader.readLine()) != null) {
            linha = linha.trim();
            if (linha.isEmpty()) continue;

            if (linha.startsWith("grupo:")) {
                // Exemplo: grupo: Ana Bia Guga Pedro
                String[] partes = linha.substring(6).trim().split("\\s+");
                List<String> nomes = Arrays.asList(partes);
                boolean sucesso = estruturaGrupos.criarGrupo(nomes);
                // Pode logar erro se quiser

            } else if (linha.startsWith("existe:")) {
                // Exemplo: existe: Bia
                String nome = linha.substring(7).trim();
                boolean existe = estruturaGrupos.existe(nome);
                if (existe) {
                    writer.write(" [" + nome + "] existe!\n");
                } else {
                    writer.write(" [" + nome + "] NÃO existe!\n");
                }
                writer.newLine();

            } else if (linha.startsWith("conhece:")) {
                // Exemplo: conhece: Maria Alface
                String[] nomes = linha.substring(8).trim().split("\\s+");
                if (nomes.length == 2) {
                    boolean conhece = estruturaGrupos.conhece(nomes[0], nomes[1]);
                    if (conhece) {
                        writer.write(" [" + nomes[0] + "] conhece [" + nomes[1] + "]\n");
                    } else {
                        writer.write(" [" + nomes[0] + "] NÃO conhece [" + nomes[1] + "]\n");
                    }
                    writer.newLine();
                }

            } else if (linha.startsWith("criaFila:")) {
                String[] partes = linha.substring(9).trim().split("\\s+");
                for (String id : partes) {
                    gerenciador.criarFila(id);
                }

            } else if (linha.startsWith("atendeFila:")) {
                String[] partes = linha.substring(11).trim().split("\\s+");
                for (String id : partes) {
                    gerenciador.atenderFila(id);
                }

            } else if (linha.startsWith("chegou:")) {
                String[] nomes = linha.substring(7).trim().split("\\s+");
                for (String nome : nomes) {
                    gerenciador.chegouPessoa(nome, estruturaGrupos);
                }

            } else if (linha.startsWith("desiste:")) {
                String[] nomes = linha.substring(8).trim().split("\\s+");
                for (String nome : nomes) {
                    gerenciador.desistePessoa(nome);
                }

            } else if (linha.equals("imprime:")) {
                List<String> filas = gerenciador.imprimirFilas();
                for (String f : filas) {
                    writer.write(f);
                    writer.newLine();
                }
            }
        }

        reader.close();
        writer.close();
    }
}
