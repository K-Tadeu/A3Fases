# Projeto A3 - Algoritmos e Estrutura de Dados
---

## Integrantes

| RA        | Nome Completo   |
-----------|-----------------
| 822135849 | Danilo Tolini   |
| 822145075 | Kleber Tadeu   |


## Descrição do Projeto

Este projeto consiste em duas fases que simulam estruturas de dados para manipulação de grupos e filas:

### Fase 1 — Pessoas Conhecem Pessoas
Implementa uma estrutura que agrupa pessoas que se conhecem. Permite criar grupos, verificar se uma pessoa existe, e se duas pessoas se conhecem (estão no mesmo grupo).

### Fase 2 — Filas Brasileiras
Simula filas para compra de ingressos com a característica de inserir pessoas próximas aos seus conhecidos dentro das filas, otimizando o atendimento. Inclui comandos para criar filas, adicionar pessoas, remover pessoas que desistem e atender as filas.

---

## Tecnologias e Ferramentas
- Java 21
- Maven (Build System)
- IntelliJ IDEA (IDE)

---

## Implementação e Justificativas das Estruturas de Dados

### Fase 1 — Pessoas Conhecem Pessoas
Utilizamos um `Map<String, Set<String>>` para representar grupos de pessoas que se conhecem, onde a chave é o nome do grupo e o valor o conjunto de pessoas. A busca para verificar existência e relacionamento é eficiente com essas estruturas, proporcionando complexidade média constante para buscas e inserções.

### Fase 2 — Filas Brasileiras
Para simular as filas, utilizamos:
- `LinkedHashMap<String, FilaBrasileira>` para manter a ordem de criação das filas.
- `LinkedList<String>` dentro de cada fila para manipular a ordem das pessoas.

A inserção respeita a ordem e permite inserir uma pessoa atrás da última pessoa que ela conhece na fila, simulando a característica da fila brasileira. A remoção também é eficiente na cabeça da fila.

---

## Exemplo de Entrada e Saída

### Entrada Fase 1 (`fase1_entrada.txt`)

grupo: Ana Bia Guga Pedro
grupo: Joao Olga
existe: Bia
conhece: Ana Pedro
conhece: Joao Olga


### Saída Fase 1 (`fase1_saida.txt`)

[Bia] existe!
[Ana] conhece [Pedro]
[Joao] conhece [Olga]


### Entrada Fase 2 (`fase2_entrada.txt`)

criaFila: Guiche1 Guiche2
chegou: Ana Maria Pedro
desiste: Maria
atendeFila: Guiche1
imprime:


### Saída Fase 2 (`fase2_saida.txt`)

#Guiche1 [Pedro]
#Guiche2 []
