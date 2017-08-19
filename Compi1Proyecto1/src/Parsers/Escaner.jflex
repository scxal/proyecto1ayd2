package Parsers;
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

abreback = "<background>"
cierraback = "</background>"
abreconfig = "<configuration>"
cierraconfig = "</configuration>"
abrefig = "<figure>"
cierrafig = "</figure>"
abredesign = "<design>"
cierradesign = "</design>"
xtipo = "x-tipo"
xheroe = "x-heroe;"
xenemigo = "x-villano;"
xvida = "x-vida"
xdestruir = "x-destruir"
xdescripcion = "x-descripcion"
xnombre = "x-nombre"
ximg = "x-imagen"
xmeta = "x-meta;"
xbloque = "x-bloque;"
xbonus = "x-bonus;"
xbomba = "x-bomba;"
xarma = "x-arma;"
xcreditos = "x-creditos"

acorchete = ("{")
ccorchete = ("}")
coma = ","
igual = "="
puntoComa = ";"
comilla = ("\"")([a-z | 0-9 | "/" | ":" | "." | "," | A-Z]+)("\";")

letra = [a-z | A-Z]
numero = [0-9]+
letraXNombre = [a-z | 0-9 | "_" | A-Z]
palabraXNombre = ("=")({letra})({letraXNombre}*)(";")


%%


{abredesign} {return new Symbol(tabla_simbolos.adesign, yycolumn,yyline,new String(yytext()));}
{cierradesign} {return new Symbol(tabla_simbolos.cdesign, yycolumn,yyline,new String(yytext()));}
{xcreditos} {return new Symbol(tabla_simbolos.xcreditos, yycolumn,yyline,new String(yytext()));}
{xmeta} {return new Symbol(tabla_simbolos.xmeta, yycolumn,yyline,new String(yytext()));}
{xbloque} {return new Symbol(tabla_simbolos.xbloque, yycolumn,yyline,new String(yytext()));}
{xbonus} {return new Symbol(tabla_simbolos.xbonus, yycolumn,yyline,new String(yytext()));}
{xbomba} {return new Symbol(tabla_simbolos.xbomba, yycolumn,yyline,new String(yytext()));}
{xarma} {return new Symbol(tabla_simbolos.xarma, yycolumn,yyline,new String(yytext()));}

{abrefig} {return new Symbol(tabla_simbolos.afig, yycolumn,yyline,new String(yytext()));}
{cierrafig} {return new Symbol(tabla_simbolos.cfig, yycolumn,yyline,new String(yytext()));}
{comilla} {return new Symbol(tabla_simbolos.comilla, yycolumn,yyline,new String(yytext()));}
{xtipo} {return new Symbol(tabla_simbolos.xtipo, yycolumn,yyline,new String(yytext()));}
{xheroe} {return new Symbol(tabla_simbolos.xheroe, yycolumn,yyline,new String(yytext()));}
{xenemigo} {return new Symbol(tabla_simbolos.xenemigo, yycolumn,yyline,new String(yytext()));}
{xdescripcion} {return new Symbol(tabla_simbolos.xdescripcion, yycolumn,yyline,new String(yytext()));}
{xdestruir} {return new Symbol(tabla_simbolos.xdestruir, yycolumn,yyline,new String(yytext()));}
{xvida} {return new Symbol(tabla_simbolos.xvida, yycolumn,yyline,new String(yytext()));}
{numero} {return new Symbol(tabla_simbolos.numero, yycolumn,yyline,new String(yytext()));}
{puntoComa} {return new Symbol(tabla_simbolos.puntoComa, yycolumn,yyline,new String(yytext()));}
{abreback} {return new Symbol(tabla_simbolos.aback, yycolumn,yyline,new String(yytext()));}
{acorchete} {return new Symbol(tabla_simbolos.acorchete, yycolumn,yyline,new String(yytext()));}
{ccorchete} {return new Symbol(tabla_simbolos.ccorchete, yycolumn,yyline,new String(yytext()));}
{coma} {return new Symbol(tabla_simbolos.coma, yycolumn,yyline,new String(yytext()));}
{palabraXNombre} {return new Symbol(tabla_simbolos.pxnombre, yycolumn,yyline,new String(yytext()));}
{xnombre} {return new Symbol(tabla_simbolos.xnombre, yycolumn,yyline,new String(yytext()));}
{ximg} {return new Symbol(tabla_simbolos.ximg, yycolumn,yyline,new String(yytext()));}
{igual} {return new Symbol(tabla_simbolos.igual, yycolumn,yyline,new String(yytext()));}
{abreconfig} {return new Symbol(tabla_simbolos.aconfig, yycolumn,yyline,new String(yytext()));}
{cierraconfig} {return new Symbol(tabla_simbolos.cconfig, yycolumn,yyline,new String(yytext()));}
{cierraback} {return new Symbol(tabla_simbolos.cback, yycolumn,yyline,new String(yytext()));}


/* BLANCOS */
[ \t\r\f\n]+ { /* Se ignoran */}
/* CUAQUIER OTRO */
. {compi1_proyecto1.Compi1_Proyecto1.erroresLex1.add(new compi1_proyecto1.Error(yytext(),yycolumn, yyline));}

