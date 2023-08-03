package org.example.lexer;

public enum Type {
    // This Scheme-like language has three token types:
    // open parens, close parens, and an "atom" type
    LPAREN, RPAREN, ID, CADENA, COMENTARIO,

    //Suma +
    //Resta -
    //Exponente **
    //División /, //
    //Módulo %
    //Multiplicación *
    ARITMETICOS,

    //Igual ==
    //Diferente !=
    //Mayor que >
    //Menor que <
    //Mayor o igual que >=
    //Menor o igual que <=
    COMPARACION,

    //y and
    //o or
    //negación not
    LOGICOS,

    //Asignación =
    ASIGNACION,

    //and, as, assert, break, class, continue, def, del, elif, else, except, False, finally, for, from
    //global, if, import, in, is, lambda, None, nonlocal, not. or, pass, raise, return, True, try, while, with, yield
    PALABRAS_CLAVE,

    //Entero 1 ,2...n
    //Decimal 1.4, 0.001
    //Cadena “una cadena”
    //123’
    //dentro de comillas
    //simples o dobles
    //booleanas True, False
    CONSTANTES,

    //Paréntesis (,)
    //Llaves {,}
    //Corchetes [,]
    //Coma ,
    //Punto y coma ;
    //Dos puntos :
    OTROS,

    ERROR
}
