# Padrão Composite em Java

Projeto desenvolvido para a atividade de APSII com o objetivo de demonstrar o padrão de projeto **Composite** usando Java.

## Sobre o projeto

O programa representa a estrutura de arquivos e pastas de um projeto. Tanto arquivos quanto pastas podem ser tratados por meio da mesma interface, chamada `ItemSistema`.

O programa também calcula o tamanho total de uma pasta, somando os tamanhos dos arquivos que estão nela e em suas subpastas.

## Estrutura de pastas

```text
projeto-composite/
├── src/
│   ├── ItemSistema.java
│   ├── Arquivo.java
│   ├── Pasta.java
│   └── Main.java
├── .gitignore
└── README.md
```

## Como o Composite foi aplicado

- **Component:** `ItemSistema` define as operações comuns aos elementos do sistema.
- **Leaf:** `Arquivo` representa um arquivo individual e não possui elementos filhos.
- **Composite:** `Pasta` pode armazenar arquivos e outras pastas, além de executar as operações sobre seus elementos.

Assim, o código consegue exibir a estrutura e calcular tamanhos sem precisar tratar cada nível de pasta de uma maneira diferente.

## Exemplo de execução

A estrutura criada na classe `Main` contém:

- `Main.java`: 12 KB
- `Pasta.java`: 8 KB
- `relatorio.pdf`: 300 KB
- `README.md`: 2 KB

O tamanho total esperado é **322 KB**.

## Relação com os princípios SOLID

- **S — Responsabilidade única:** cada classe tem uma função principal: a interface define o contrato, `Arquivo` representa arquivos, `Pasta` gerencia seus elementos e `Main` executa o exemplo.
- **O — Aberto/fechado:** é possível criar novos tipos de elementos que implementem `ItemSistema` sem precisar mudar a estrutura principal de `Pasta`.
- **L — Substituição de Liskov:** arquivos e pastas implementam `ItemSistema` e podem ser usados onde essa abstração é esperada.
- **I — Segregação de interfaces:** a interface contém apenas operações relacionadas ao comportamento comum dos elementos deste exemplo.
- **D — Inversão de dependência:** `Pasta` trabalha com a abstração `ItemSistema`, em vez de depender diretamente apenas da classe `Arquivo`.

## Como executar

É necessário ter o JDK instalado.

No terminal, dentro da pasta do repositório, execute:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

O programa exibirá a árvore de pastas e arquivos e, ao final, o tamanho total do projeto.
