grammar Graph;

file : statement+ ;

statement : (ID '->' ID )|(ID '->' list);
list:  '['ID (','+ID)*']';

ID : [A-Z]+ ;
WS : [ \t\r\n]+ -> skip ;
