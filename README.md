# javadoc

Documentação JAVA
Os primeiros computadores não tinham comando para desenvolvimento ou manipulação.
O Java foi administrado pela empresa Sum mas atualmente é operado pela Oracle.
Ele tem um poder muito grande, sendo usado para diversos projetos, dos mais pequenos aos mais grandes, até mesmo o hover que pousou em Marte foi programado em java. sistemas bancários, cartões de crédito, apps…

é uma linguagem compilada mas diferente da linguagem C , uma vez passado pelo compilador de qualquer plataforma, o bytecode gerado consegue ser lido e interpretado por qualquer máquina virtual java em qualquer plataforma.

WORA - write once run anywhere - escreva uma vez só e execute em qualquer plataforma que tenha uma JVM (java virtual machine).
Dicas de provas:
O comando JAVA do JDK (J2SE Development Kit) executa as aplicações java.
O comando JAVAC do JDK é responsável por compilar programas em Java.
Todo arquivo de programa java deve terminar com a extensão .java.
Quando um programa java é compilado, o arquivo produzido pelo compilador termina com a extensão .class.
O arquivo produzido pelo compilador java contém BYTECODE que é executado pela JVM (java virtual machine).

algumas diferenças entre um programa compilador e/ou interpretado:

Programa Compilado
Programa Interpretado
Consome mais memória
Consome menos memória
LEva menos tempo para ser executado
Leva mais tempo para executar

Processo de compilação:
Código fonte
“Um programa pode existir em 3 níveis: FONTE(simbólico), RELOCÁVEL e OBJETO (executável)”

“O compilador vai verificar a sintaxe dos comandos, buscar por erros, realizar a tradução do código simbólico em múltiplas instruções essenciais.”

“O montador ou assembler realiza cálculos de endereçamento e transforma as instruções aplicáveis em linguagem de máquina.”
Compilador
Código relocável
Montador

Código objeto

JRE - java runtime environment (ambiente de execução java - usado para executar java - )
JVM ((java virtual machine - máquina virtual java)
loader (carrega o bytecode na memória virtual da máquina)
verificador (verifica se o código está correto para execução)
interpretador (pega o bytecode e transforma em linguagem de máquina)
gerenciador de memória (cuida da memória da jvm para gerenciar variáveis e o código em si)
compilador JIT (ele já compila parte do código que é muito importante diretamente em linguagem de máquina diretamente no bytecode para otimizar o processo)
bibliotecas (APIs)

JDK - java development kit (kit de desenvolvimento java - ele já vem com o JRE (com todas as ferramentas) e mais algumas outras ferramentas que possibilitam o desenvolvimento dos projetos em java)
javalang (linguagem java)
javatools (conjunto de ferramentas)
javaC (compilador java que transforma o código fonte em bytecode)
debugger (que permite ver como o código está sendo executado em tempo real, possibilitando verificar erros e desvios)
APIs

todos os programas são feitos em pacotes (package). toda classe java deve conter o cabeçalho da classe:
public class PrimeiroPrograma { (classe com cabeçalho padrão)
public static void main(String[] args) { (método principal do programa)
System.out.printLn(“Hellow word!”);
}
}

Nomeação de identificadores:
Se a primeira letra for maiuscula: Classe ou interface;
se a primeira for minúscula e as outras forem camelcase: variável, atributo ou método;
se todas as letras forem minúsculas trata-se de um nome de package;
se todas as letras forem maiúsculas: constante;

Importação de bibliotecas:
Usar “import”;

Bibliotecas:

Herança:
extends

Encapsulamento:
private

Interface:
implements

Comentários:
// este é um comentário de uma linha

/\*

- nos comentários de muitas linhas
- podemos escrever o quanto quisermos
- até indicarmos o final do comentário.
  \*/

/\*_ (um asterisco extra é usado para indicar documentação)
Exemplo para o CursoEmVideo de Java
@author Gustavo Guanabara
@version 1.0
@since 2015-01-01
_/

Tipos primitivos:
Existem 4 famílias em java.

Família
Tipo primitivo
classe invólucro
tamanho
exemplo
Lógico
boolean
Boolean
1 byte
true
Literais
char
Character
1 byte
‘A’
–
String
1 byte / cada
“JAVA”
Inteiros
byte
Byte
1 byte
127
short
Short
2 byte
32 767
int
Integer
4 byte
2 147 483
long
Long
8 byte
2ª(63)
Reais
float
Float
4 byte
3.4eª(+38)
double
Double
8 byte
1.8eª(+308)

Declaração de Variáveis:

int idade = 3; tipo / nomeVariavel / atribuição; - variável
int idade = (int) 3; typecast - variável
Integer idade = new Integer(3); object.

float sal = 1825.54f; não esquecer o f
float sal = (float) 1825.54; typecast
FLoat idade = new Float(1825.54); object.

char letra = ‘g’; o java usa aspas simples.
char letra = (char) ‘g’;
Character letra = new Character(‘g’);

boolean casado = false;
boolean casado = (boolean) false;
Boolean casado = new Boolean(false);

Saída de dados:
Exemplo: float nota 8.5f;
System.out.print(“Sua nota é ” + nota);
System.out.println(“Sua nota é ” + nota);
System.out,printf(“Sua nota é %.2f”, nota); (2 casas decimais)
System.out.format(“Sua nota é %.2f”, nota);

Entrada de dados:
import java.util.Scanner; // importação da classe

// Instância do objeto para usar a classe.
Scanner teclado = new Scanner(System.in); (vai monitorar a entrada padrão do sistema)

exemplos de métodos dessa classe:
int idade = teclado.nextInt();
float salario = teclado.nextFloat();
String nome = nextLine();

Método:

Integer.toString(var);
Float.parseFloat(var);

Operadores aritméticos

- Adição

* Subtração

- Multiplicação
  /
  Divisão
  %
  Resto

Ordem de prioridade: \* / % + -

Operadores Unários

- Incremento
  a + +
  a = a + 1

* Decremento
  a - -
  a = a - 1

Operadores de atribuição

+=
somar e atribuir
a += b
a = a + b
-=
subtrair e atribuir
a -= b
a = a + b
_=
multiplicar e atribuir
a _= b
a = a \* b
/=
Dividir e atribuir
a /= b
a = a / b
%=
Resto e atribuir
a %= b
a = a % b

classe math

PI
Constante de pi
Math.PI
3,1415…
pow
Exponenciação
Math.pow(5,2)
25
sqrt
Raiz quadrada
Math.sqrt(25)
5
cbrt
Raiz cúbica
Math.cbrt(27)
3
abs
absoluto
Math.abs(-10)
10
floor
Arredondamento cima
Math.floor(3,9)
3
ceil
arredondamento baixo
Math.ceil(4,2)
5
round
Arredondamento aritmético
Math.round(5,6)
6
random
número randômico
Math.random()
5 + Math.random() \* (10-5);
double - entre 0 1
