# Projeto A3 - Algoritmos e Estrutura de Dados
---

## Integrantes

| RA        | Nome Completo   |
-----------|-----------------
| 822135849 | Danilo Tolini   |
| 822145075 | Kleber Tadeu   |
| 822159844 | Tadeo Caceres |
| 822164517 | Luiz Lorentz |
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

ALERTA: Altere o local dos arquivos de entrada e saída nas respectivas fases nos arquivos MainFase1 e MainFase2. 
Os arquivos de entrada e saída estão localizados nas pastas resourcesFase1 e resourcesFase2. 

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

grupo: Lucas Fernando Bia Pedro Ana
grupo: Maria Jonas Fabi
grupo: Ivo Paulo Junior Ivone

existe: Bia
existe: Alberto
conhece: Lucas Pedro
conhece: Fernando Fabi

chegou: Ana Bia Guga
chegou: Maria Manuel
desiste: Guga
chegou: Pedro Olga
chegou: Joao ALface

imprime:
desiste: Bia
atendeFila: Guiche1
chegou: Bia
imprime:



### Saída Fase 2 (`fase2_saida.txt`)

 [Bia] existe!

 [Alberto] NÃO existe!

 [Lucas] conhece [Pedro]

 [Fernando] NÃO conhece [Fabi]

#Guiche1 [Ana] [Bia] [Pedro] [Manuel]
#Guiche2 [Maria] [Olga] [Joao] [ALface]
#Guiche1 [Pedro] [Bia] [Manuel]
#Guiche2 [Maria] [Olga] [Joao] [ALface]
