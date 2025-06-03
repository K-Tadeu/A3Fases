import java.util.*;

public class PessoasConhecemPessoas {

    // Mapeia nome da pessoa para o grupo dela
    private Map<String, Set<String>> grupos;

    // Para garantir que pessoa não esteja em mais de um grupo
    private Set<String> pessoasCadastradas;

    public PessoasConhecemPessoas() {
        grupos = new HashMap<>();
        pessoasCadastradas = new HashSet<>();
    }

    // Cria um grupo a partir dos nomes (se não houver conflito)
    public boolean criarGrupo(List<String> nomes) {
        // Verifica se alguma pessoa já está cadastrada em outro grupo
        for (String nome : nomes) {
            if (pessoasCadastradas.contains(nome)) {
                return false; // conflito, não pode adicionar
            }
        }
        // Cria um Set com todos os nomes do grupo
        Set<String> grupo = new HashSet<>(nomes);
        // Mapeia cada pessoa para o grupo criado (mesmo objeto)
        for (String nome : nomes) {
            grupos.put(nome, grupo);
            pessoasCadastradas.add(nome);
        }
        return true;
    }

    // Verifica se a pessoa existe em algum grupo
    public boolean existe(String nome) {
        return pessoasCadastradas.contains(nome);
    }

    // Verifica se nome1 conhece nome2 (estão no mesmo grupo)
    public boolean conhece(String nome1, String nome2) {
        if (!existe(nome1) || !existe(nome2)) {
            return false;
        }
        Set<String> grupo1 = grupos.get(nome1);
        Set<String> grupo2 = grupos.get(nome2);
        return grupo1 == grupo2; // mesma referência indica mesmo grupo
    }
}
