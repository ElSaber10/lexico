package org.example.lexer;

public class Tokens {
    public final Type t;
    public final String c; // para recibir los tokens
    // could have column and line number fields too, for reporting errors later
    public final int linea;
    public final int columa;

    //Recibimos el Typo de tokens y la cadena ¿
    public Tokens(Type t, String c, int columa, int linea) {
        this.t = t;
        this.c = c;
        this.linea = linea;
        this.columa = columa;
    }
    public String toString() {
        if(t == Type.ID) {
            return "IDENTIDICADOR<" + c + ">" + "linea " + linea + " columna " + columa;
        }
        if (t == Type.COMENTARIO){
            return "COMENTARIO<" + c +">"+ "linea " + linea + " columna " + columa;
        }
        if (t == Type.LPAREN){
            return "PARENTERTESIS_ISZQUIERDO <" + c + ">"+ "linea " + linea + " columna " + columa;
        }
        if (t == Type.RPAREN){
            return "PARENTERTESIS_DERECHO <" + c + ">"+ "linea " + linea + " columna " + columa;
        }
        if (t == Type.ERROR){
            return "ERROR <" + c + ">"+ "linea " + linea + " columna " + columa;
        }
        return t.toString();
    }
}
