    import java.io.*;
    import java.util.*;

    public class ParserFase1 {

        private PessoasConhecemPessoas estrutura;

        public ParserFase1() {
            estrutura = new PessoasConhecemPessoas();
        }

        public void executar(String arquivoEntrada, String arquivoSaida) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoEntrada));
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoSaida));

            String linha;
            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty()) continue;

                if (linha.startsWith("grupo:")) {
                    // Exemplo: grupo: Ana Bia Guga Pedro
                    String[] partes = linha.substring(6).trim().split("\\s+");
                    List<String> nomes = Arrays.asList(partes);
                    boolean sucesso = estrutura.criarGrupo(nomes);
                    if (!sucesso) {
                        // Se quiser, pode escrever mensagem de erro
                        // Por enquanto, só ignora
                    }

                } else if (linha.startsWith("existe:")) {
                    // Exemplo: existe: Bia
                    String nome = linha.substring(7).trim();
                    boolean existe = estrutura.existe(nome);
                    if (existe) {
                        writer.write(" [" + nome + "] existe!");
                    } else {
                        writer.write(" [" + nome + "] NÃO existe!");
                    }
                    writer.newLine();

                } else if (linha.startsWith("conhece:")) {
                    // Exemplo: conhece: Maria Alface
                    String[] nomes = linha.substring(8).trim().split("\\s+");
                    if (nomes.length == 2) {
                        boolean conhece = estrutura.conhece(nomes[0], nomes[1]);
                        if (conhece) {
                            writer.write(" [" + nomes[0] + "] conhece [" + nomes[1] + "]");
                        } else {
                            writer.write(" [" + nomes[0] + "] NÃO conhece [" + nomes[1] + "]");
                        }
                        writer.newLine();
                    }
                }
            }
            reader.close();
            writer.close();
        }
    }
