package Parsers2;
import java_cup.runtime.Symbol;
%%

%cupsym tabla_simbolos
%class lexico
%cup
%public
%unicode
%line
%column
%char
%ignorecase

abreEscenario = "<escenarios background"
cierraEscenario = "</escenarios>"
ancho = "ancho"
alto = "alto"
apersonas = "<personajes>"
cpersonas = "</personajes>"
aheroe = "<heroes>"
cheroe = "</heroes>"
avillanos = "<villanos>"
cvillanos = "</villanos>"
abreParedes = "<paredes>"
cierraParedes = "</paredes>"

axextras = "<extras>"
cxextras = "</extras>"
axarmas = "<armas>"
cxarmas = "</armas>"
axbonus = "<bonus>"
cxbonus = "</bonus>"
axmeta = "<meta>"
cxmeta = "</meta>"


puntos = ".."
cParen = ")"
mayorQue = ">"
coma = ","
igual = "="
puntoComa = ";"



letra = [a-z | A-Z]
numero = [0-9]+
letraXNombre = [a-z | 0-9 | "_" | A-Z]
palabraXNombre = ("=")({letra})({letraXNombre}*)(";")
palabraNombre = ({letra})({letraXNombre}*)("(")

%%

{axextras} {return new Symbol(tabla_simbolos.axextras, yycolumn,yyline,new String(yytext()));}
{cxextras} {return new Symbol(tabla_simbolos.cxextras, yycolumn,yyline,new String(yytext()));}
{axarmas} {return new Symbol(tabla_simbolos.axarmas, yycolumn,yyline,new String(yytext()));}
{cxarmas} {return new Symbol(tabla_simbolos.cxarmas, yycolumn,yyline,new String(yytext()));}
{axbonus} {return new Symbol(tabla_simbolos.axbonus, yycolumn,yyline,new String(yytext()));}
{cxbonus} {return new Symbol(tabla_simbolos.cxbonus, yycolumn,yyline,new String(yytext()));}
{axmeta} {return new Symbol(tabla_simbolos.axmeta, yycolumn,yyline,new String(yytext()));}
{cxmeta} {return new Symbol(tabla_simbolos.cxmeta, yycolumn,yyline,new String(yytext()));}
{cierraEscenario} {return new Symbol(tabla_simbolos.cEscenario, yycolumn,yyline,new String(yytext()));}

{abreParedes} {return new Symbol(tabla_simbolos.aparedes, yycolumn,yyline,new String(yytext()));}
{cierraParedes} {return new Symbol(tabla_simbolos.cparedes, yycolumn,yyline,new String(yytext()));}
{puntos} {return new Symbol(tabla_simbolos.puntos, yycolumn,yyline,new String(yytext()));}
{apersonas} {return new Symbol(tabla_simbolos.apersonas, yycolumn,yyline,new String(yytext()));}
{cpersonas} {return new Symbol(tabla_simbolos.cpersonas, yycolumn,yyline,new String(yytext()));}
{aheroe} {return new Symbol(tabla_simbolos.aheroe, yycolumn,yyline,new String(yytext()));}
{cheroe} {return new Symbol(tabla_simbolos.cheroe, yycolumn,yyline,new String(yytext()));}
{avillanos} {return new Symbol(tabla_simbolos.avillanos, yycolumn,yyline,new String(yytext()));}
{cvillanos} {return new Symbol(tabla_simbolos.cvillanos, yycolumn,yyline,new String(yytext()));}
{abreEscenario} {return new Symbol(tabla_simbolos.aEscenario, yycolumn,yyline,new String(yytext()));}
{ancho} {return new Symbol(tabla_simbolos.tancho, yycolumn,yyline,new String(yytext()));}
{alto} {return new Symbol(tabla_simbolos.talto, yycolumn,yyline,new String(yytext()));}
{cParen} {return new Symbol(tabla_simbolos.cParen, yycolumn,yyline,new String(yytext()));}

{mayorQue} {return new Symbol(tabla_simbolos.mayorQue, yycolumn,yyline,new String(yytext()));}
{coma} {return new Symbol(tabla_simbolos.coma, yycolumn,yyline,new String(yytext()));}
{igual} {return new Symbol(tabla_simbolos.igual, yycolumn,yyline,new String(yytext()));}
{puntoComa} {return new Symbol(tabla_simbolos.puntoComa, yycolumn,yyline,new String(yytext()));}
{numero} {return new Symbol(tabla_simbolos.numero, yycolumn,yyline,new String(yytext()));}
{palabraXNombre} {return new Symbol(tabla_simbolos.pxnombre, yycolumn,yyline,new String(yytext()));}
{palabraNombre} {return new Symbol(tabla_simbolos.pnombre, yycolumn,yyline,new String(yytext()));}


/* BLANCOS */
[ \t\r\f\n]+ { /* Se ignoran */}
/* CUAQUIER OTRO */
. {compi1_proyecto1.Compi1_Proyecto1.doerroresLex2(new compi1_proyecto1.Error(yytext(),yycolumn, yyline));}

