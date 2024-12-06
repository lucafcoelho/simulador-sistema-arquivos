Simulador de Sistema de Arquivos com Journaling

Este projeto implementa um simulador de sistema de arquivos em Java. Ele permite realizar operações básicas de manipulação de arquivos e diretórios, incluindo o uso de journaling para garantir a integridade das operações realizadas.


Objetivo

Desenvolver um simulador de sistema de arquivos que:

Implemente operações básicas, como criar, apagar, renomear arquivos e diretórios.

Suporte a Journaling para garantir a integridade das operações.

Simule um sistema de arquivos por meio de uma interface interativa no console.


Funcionalidades Implementadas

Operações com Diretórios:

Criar um novo diretório.

Listar o conteúdo de um diretório.

Apagar um diretório existente.


Operações com Arquivos:

Criar um arquivo dentro de um diretório.

Apagar arquivos de um diretório.


Journaling:

Registra todas as operações realizadas no sistema.

Exibe o log de operações no formato de console.


Interface de Console:

Menu interativo para executar todas as operações.


Pré-requisitos
Java Development Kit (JDK) instalado (versão 8 ou superior).

Um editor de texto ou IDE para rodar o código (como VS Code, IntelliJ IDEA ou Eclipse).

Um terminal para executar o programa.


Como Executar o Programa

1.Clonar o Repositório:

git clone <link-do-repositorio>
cd <nome-do-repositorio>


2.Compilar o Código: Compile o arquivo Main.java:

javac Main.java


3.Executar o Programa: Execute o arquivo compilado:

java Main


4.Interagir com o Menu: Escolha as opções apresentadas no menu para realizar as operações.


Exemplo de Uso

Criar um diretório chamado docs:

Enter parent directory: root
Enter directory name: docs

Criar um arquivo chamado example.txt no diretório docs:

Enter directory name: docs
Enter file name: example.txt

Exibir o log de operações:

Choose an option: 6


Arquitetura do Projeto

Classes Implementadas:

Main: Classe principal que contém o método main e gerencia as interações do usuário.
Directory: Representa um diretório no sistema de arquivos, armazenando subdiretórios e arquivos.
FileEntry: Representa um arquivo simples.
Journal: Gerencia o log de operações para o journaling.

Estrutura de Dados:

Diretórios são organizados em uma hierarquia por meio de listas de subdiretórios.
Arquivos são armazenados como objetos simples dentro de cada diretório.
As operações realizadas são registradas em um log (Journal) para garantir a integridade das ações.


Resultados Esperados

Simulação bem-sucedida de um sistema de arquivos simples.
Registro de todas as operações no journaling.
Demonstração clara de como um sistema de arquivos básico opera internamente.


Bibliotecas Utilizadas

Nenhuma biblioteca externa foi utilizada. Apenas as bibliotecas padrão do Java (java.util e java.io).
Entrega
Este README é parte do relatório, conforme a estrutura solicitada no projeto.
O link para este repositório foi enviado no formato .txt no AVA.


Desenvolvido por: Luca Fiuza Coelho
Disciplina: Proj de sistema operacional
Professor: Izequiel Pereira
