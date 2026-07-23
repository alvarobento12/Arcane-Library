# Arcane Library

Sistema de gerenciamento de biblioteca desenvolvido em **Java** como projeto de aperfeiçoamento da disciplina de **Orientação a Objetos**. O sistema controla o cadastro de leitores, materiais (livros e mangás) e o ciclo de empréstimos, incluindo um programa de pontos para leitores Premium.

## Sobre o projeto

A "Arcane Library" empresta livros e mangás para dois tipos de leitor:

- **Leitor Comum**: ganha pontos normalmente ao devolver materiais no prazo.
- **Leitor Premium**: ganha pontos em dobro e pode usar seus pontos acumulados para **estender o prazo de devolução** de um empréstimo em andamento.

Além do empréstimo em si, o sistema calcula multa por atraso na devolução, usando uma calculadora de multas desacoplada da regra de negócio (para permitir trocar a política de cobrança sem alterar a classe `Emprestimo`).

## Funcionalidades

- Cadastro, busca, listagem e remoção de leitores, materiais e empréstimos
- Empréstimo de materiais com controle de estoque (`quantDisponivel`)
- Devolução de materiais com cálculo automático de multa em caso de atraso
- Acúmulo de pontos de leitura ao devolver no prazo (Comum: 1 ponto / Premium: 2 pontos)
- Extensão de prazo de empréstimo usando pontos (exclusivo para leitores Premium)
- Tratamento de erros com exceções customizadas para regras de negócio

## Conceitos de POO aplicados

| Conceito | Onde está aplicado |
|---|---|
| **Herança** | `LeitorComum` e `LeitorPremium` herdam de `Leitor`; `Livros` e `Mangas` herdam de `Material` |
| **Classe abstrata** | `Leitor` define o contrato `calcularPontosDeLeitura()`, implementado de forma diferente por cada subtipo |
| **Polimorfismo** | `Emprestimo.devolverMaterial()` chama `leitor.calcularPontosDeLeitura()` sem saber (nem precisar saber) se é um leitor Comum ou Premium |
| **Encapsulamento** | Atributos privados com acesso controlado por getters/setters; `adicionarPontos()` é `protected`, só as subclasses de `Leitor` podem chamá-lo |
| **Interface / Strategy** | `CalculadoraMulta` é uma interface implementada por `CalculadoraMultaPadrao`, permitindo trocar a política de multa sem alterar `Emprestimo` |
| **Exceções customizadas** | `MaterialIndisponivelException`, `PontosInsuficientesException` e `PagamentoPremiumException` modelam regras de negócio como erros de domínio, não erros técnicos genéricos |
| **Enums** | `SituacaoMaterial`, `SituacaoEmprestimo` e `SituacaoReserva` representam estados válidos, evitando o uso de `Strings`/`ints` soltos |
| **Composição** | `Emprestimo` é composto por vários `ItemEmprestimo`, e cada `GerenciadorX` encapsula uma coleção da entidade que gerencia |

## strutura do projeto

```
src/br/edu/arcanelibrary/
├── Main.java                     # Classe de teste/demonstração
├── excecao/
│   ├── MaterialIndisponivelException.java
│   ├── PagamentoPremiumException.java
│   └── PontosInsuficientesException.java
├── modelo/
│   ├── Leitor.java                (abstrata)
│   ├── LeitorComum.java
│   ├── LeitorPremium.java
│   ├── Material.java
│   ├── Livros.java
│   ├── Mangas.java
│   ├── Emprestimo.java
│   ├── ItemEmprestimo.java
│   ├── GerenciadorLeitor.java
│   ├── GerenciadorMaterial.java
│   ├── GerenciadorEmprestimo.java
│   ├── SituacaoMaterial.java
│   ├── SituacaoEmprestimo.java
│   └── SituacaoReserva.java
└── servico/
    ├── CalculadoraMulta.java      (interface)
    └── CalculadoraMultaPadrao.java
```

## ▶Como executar

### Opção 1 — Pela IDE (IntelliJ, Eclipse, VS Code)

1. Abra a pasta do projeto na sua IDE.
2. Marque `src` como *Source Root* (o IntelliJ já reconhece isso pelo `.iml`).
3. Rode a classe `br.edu.arcanelibrary.Main`.

### Opção 2 — Pela linha de comando

Na raiz do projeto:

```bash
# Compilar
mkdir -p out
javac -encoding UTF-8 -d out $(find src -name "*.java")

# Executar
java -cp out br.edu.arcanelibrary.Main
```

##  Exemplo de saída

```
===== SISTEMA ARCANE LIBRARY =====

--- Cadastro de leitores ---
João Pedro
Maria Júlia
Existe CPF 111.111.111-11? true

--- Empréstimo do leitor comum ---
Empréstimo criado: Empréstimo #1 - Leitor: João Souza - Situação: ABERTO - Previsão devolução: 2026-08-06
...
```

A `Main.java` executa um roteiro completo: cadastro, empréstimo, devolução no prazo, extensão de prazo com pontos (sucesso e falha por saldo insuficiente), tentativa de empréstimo sem estoque e cálculo de multa — cobrindo os principais fluxos e exceções do sistema.

## Possíveis evoluções futuras

- Implementar o fluxo de **reserva** de materiais indisponíveis (o enum `SituacaoReserva` já existe, mas ainda não há uma classe `Reserva`)
- Persistência dos dados (arquivo ou banco de dados) — hoje tudo vive em memória
- Testes automatizados com JUnit
- Interface de linha de comando interativa (menu) em vez de um roteiro fixo na `Main`

##  Autor

- (https://github.com/alvarobento12)

Projeto desenvolvido para fins acadêmicos e de portfólio.
