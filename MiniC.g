grammar MiniC;

program: definition (definition)* EOF;

INT: 'int';
IF: 'if';
WHILE: 'while';
ELSE: 'else';
BREAK: 'break';
CONTINUE: 'continue';
RETURN: 'return';

definition: data_definition | function_definition;
data_definition: INT declarator  (',' declarator )* ';'; 

declarator: Identifier;
//Identifier: [a-zA-Z]+;
Identifier: [a-zA-Z_]+[a-zA-Z0-9_]*; // identificadores das variáveis 


function_definition : (INT)? function_header function_body;
function_header : declarator parameter_list;
parameter_list: '(' (parameter_declaration)?  ')' ;
parameter_declaration : INT declarator ( ',' (INT ) declarator )* ;

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
| '(' expression ')'
| Identifier '('  (argument_list)?  ')' ; 

argument_list: binary (',' binary )* ;

CONSTANT_INT : [0-9]+;

// STRING : '"' (ESC | ~["\\\r\n])* '"';
// fragment ESC : '\\\\' . | '\\"' ;

// Digit: [0-9]+;
//ainda vou descobrir
// Nome: ~('h' | 't' | 'p' | 'f') ('https' | 'ftp' | [a-zA-Z]+);
//final e essencial
WS: [ \t\r\n]+ -> skip;
