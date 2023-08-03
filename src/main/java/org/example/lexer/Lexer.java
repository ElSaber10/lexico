package org.example.lexer;

import java.util.ArrayList;
import java.util.List;

    public class Lexer {
        static int f =1;
        static int c = 1;
         // Actptamos la cadena y un índice, obtenemos el token que comienza en ese índice
        public static Tokens getAtom(String s, int i) {
            Type tipoToken = Type.ID;
            int j = i;
            for( ; j < s.length(); ) {
                if (s.charAt(j) == 10 || s.charAt(j) == 32 || s.charAt(j) == 9) {
                    Tokens token = new Tokens(tipoToken, s.substring(i, j - 1), c, f);
                    if (s.charAt(j) == 10) {
                        f++;
                        c = 1;
                    }
                    return token;
                }
                if(!(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'
                        || (s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
                        || (s.charAt(j) >= '0' && s.charAt(j) <= '9') || s.charAt(j) == '_')){
                    tipoToken = Type.ERROR;
                }
                j++;
            }
            return (new Tokens(tipoToken,s.substring(i,j),c,f));
        }
        public static String getAtomComent(String s, int i) { //Recibe la cadena
            int j = i;
            for( ; j < s.length(); ) {
                if (s.charAt(j) == 10) {
                    break;
                }
                j++;
            }
            return s.substring(i, j);
        }

        public static List<Tokens> lex(String input) {
            List<Tokens> result = new ArrayList<Tokens>();
            for(int i = 0; i < input.length(); ) {
                switch(input.charAt(i)) {
                    case '(':
                        result.add(new Tokens(Type.OTROS, "(", c++,f));
                        i++;
                        break;
                    case ')':
                        result.add(new Tokens(Type.OTROS, ")", c++, f));
                        i++;
                        break;
                    case '#':
                        String comentAtom = getAtomComent(input, i);
                        i += comentAtom.length();
                        result.add(new Tokens(Type.COMENTARIO, comentAtom, c++, f));
                        break;
                    case '"':
                        String comilla = getAtomComent(input, i);
                        i += comilla.length();
                        result.add(new Tokens(Type.COMENTARIO, comilla, c++, f));
                        break;
                    default:
                        if(input.charAt(i) == 32) {
                            i++;
                        } else if (input.charAt(i) == 10){
                            System.out.println("Encontro un salto de linea");
                            i++;
                            f++;
                            c=1;
                            break;
                        }else if(input.charAt(i) >= 'A' && input.charAt(i) <= 'Z'
                                || (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
                                || (input.charAt(i) >= '0' && input.charAt(i) <= '9')){
                            Tokens atom = getAtom(input, i);
                            i += atom.c.length();
                            result.add(atom);
                        }else {
                            System.out.println("error");
                            for( ; i < input.length(); ) {
                                if (input.charAt(i) == 10 || input.charAt(i) == 32 || input.charAt(i) == 9) {
                                    break;
                                }
                                i++;
                            }
                            break;
                        }
                }
            }
            return result;
        }


    }
