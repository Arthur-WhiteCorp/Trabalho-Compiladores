/*
Representação Intermediária - Trabalho de Compiladores

Integrantes: 
Arthur Matias
Bianka Vasconcelos
Micael Viana

Segue abaixo a gramática do MiniC.
*/

grammar MiniC;
program: definition (definition)* EOF;

INT: 'int';
CHAR: 'char';
TIPO: (INT|CHAR);
IF: 'if';
WHILE: 'while';
ELSE: 'else';
BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';

definition: data_definition | function_definition;
data_definition: ('int' | 'char') declarator  (',' declarator )* ';'; 

declarator: Identifier;

//Identifier: [a-zA-Z]+;
Identifier: [a-zA-Z_]+[a-zA-Z0-9_]*; // identificadores das variáveis 

function_definition : ('int' | 'char') function_header function_body;
function_header : declarator parameter_list;
parameter_list: '(' (parameter_declaration)?  ')' ;
parameter_declaration : ('int' | 'char') declarator ( ',' ('int' | 'char') declarator )* ;

// function_body : '{' (data_definition)*  (statement)* '}';
function_body: '{' (data_definition)* (statement)* '}';

// function_body
//     : '{' (data_definition | statement)* '}'
//     ;


// statement
// : [ expression ] ‘;‘ 
// | IF ‘(‘ expression ‘)‘ statement [ ELSE statement ]
// | WHILE ‘(‘ expression ‘)‘ statement
// | BREAK ‘;‘
// | CONTINUE ‘;‘
// | RETURN [ expression ] ‘;‘

block
 : '{' (statement)+ '}'
 ;

//outras paradas
statement
: expression ';'  
| IF '(' expression ')'   statement  ( ELSE statement )? 
// | IF '(' expression ')'   '{' statement+ '}' ( ELSE '{' statement+ '}' )? 
// | WHILE '(' expression ')'  '{' statement+ '}'
| WHILE '(' expression ')'  statement
// | IF '(' expression ')' ('{')? statement ('}')? (ELSE ('{')? statement ('}')? ) ?
// | WHILE '(' expression ')' ('{')? statement ('}')? 
| BREAK ';' 
| CONTINUE ';' 
| RETURN (expression)? ';' 
| block
| ';'
;

expression : binary ( ',' binary )* ;

// binary: Identifier '=' binary | unary ; 
// binary
// : Identifier '=' binary  #atribuicao
// | Identifier '+=' binary #maisIgual
// | Identifier '-=' binary #menosIgual
// | Identifier '*=' binary #multIgual
// | Identifier '/=' binary #divIgual
// | Identifier '%=' binary #restIgual
// | binary '==' binary     #compara
// | binary '!=' binary     #diferente
// | binary '<=' binary     #menorIgual
// | binary '>=' binary     #maiorIgual
// | binary '>' binary      #maior
// | binary '<' binary      #menor
// | binary '+' binary      #adicao
// | binary '-' binary      #subtracao
// | binary '*' binary      #multiplicacao
// | binary '/' binary      #divisao
// | binary '%' binary      #resto
// | unary                  #unario
// ;

binary
: Identifier '=' binary  
| Identifier '+=' binary
| Identifier '-=' binary
| Identifier '*=' binary 
| Identifier '/=' binary 
| Identifier '%=' binary 
| binary '==' binary     
| binary '!=' binary     
| binary '<=' binary     
| binary '>=' binary     
| binary '>' binary      
| binary '<' binary      
| binary '+' binary      
| binary '-' binary      
| binary '*' binary      
| binary '/' binary      
| binary '%' binary      
| unary                  
;

// unary: primary |  '++' Identifier ; 
unary
: '++'Identifier
| '--'Identifier
| primary
;

primary
: Identifier 
| CONSTANT_INT
| CONSTANT_CHAR
| '(' expression ')'
| Identifier '('  (argument_list)?  ')' ; 

argument_list: binary (',' binary )* ;

CONSTANT_INT : [0-9]+;
//CONSTANT_INT: '-'?[0-9]+;
//CONSTANT_CHAR: "[.]";
CONSTANT_CHAR : '\'' . '\'' ;


// STRING : '"' (ESC | ~["\\\r\n])* '"';
// fragment ESC : '\\\\' . | '\\"' ;

// Digit: [0-9]+;
//ainda vou descobrir
// Nome: ~('h' | 't' | 'p' | 'f') ('https' | 'ftp' | [a-zA-Z]+);
//final e essencial
COMMENT: '//' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;