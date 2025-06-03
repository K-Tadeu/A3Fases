import java.util.*;

public class GerenciadorDeFilas {

    private Map<String, FilaBrasileira> filas;

    public GerenciadorDeFilas() {
        filas = new LinkedHashMap<>(); // mantém a ordem de criação
    }

    public void criarFila(String id) {
        if (!filas.containsKey(id)) {
            filas.put(id, new FilaBrasileira(id));
        }
    }

    public void atenderFila(String id) {
        FilaBrasileira fila = filas.get(id);
        if (fila != null) {
            fila.removerPrimeiro();
        }
    }

    public void chegouPessoa(String pessoa, PessoasConhecemPessoas estrutura) {
        if (filas.isEmpty())
            return;

        String melhorFilaId = null;
        int melhorPosicao = -1;

        for (FilaBrasileira fila : filas.values()) {
            List<String> lista = fila.getFila();
            int ultimaPosicaoConhecido = -1;

            for (int i = 0; i < lista.size(); i++) {
                if (estrutura.conhece(pessoa, lista.get(i))) {
                    ultimaPosicaoConhecido = i;
                }
            }

            // Se conhece alguém nessa fila e está mais no fim
            if (ultimaPosicaoConhecido > melhorPosicao) {
                melhorPosicao = ultimaPosicaoConhecido;
                melhorFilaId = fila.getId();
            }
        }

        if (melhorFilaId == null) {
            // Não conhece ninguém → escolher a menor fila
            int menorTamanho = Integer.MAX_VALUE;
            for (FilaBrasileira fila : filas.values()) {
                if (fila.getFila().size() < menorTamanho) {
                    menorTamanho = fila.getFila().size();
                    melhorFilaId = fila.getId();
                }
            }
        }

        filas.get(melhorFilaId).inserirPessoa(pessoa, estrutura);
    }

    public void desistePessoa(String nome) {
        for (FilaBrasileira fila : filas.values()) {
            fila.removerPessoa(nome);
        }
    }

    public List<String> imprimirFilas() {
        List<String> saidas = new ArrayList<>();
        for (FilaBrasileira fila : filas.values()) {
            saidas.add(fila.imprimir());
        }
        return saidas;
    }
}
