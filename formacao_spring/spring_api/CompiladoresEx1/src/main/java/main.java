import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

    public static void main(String[] args) {
        String input = "program p;\n" +
                "var x: integer;\n" +
                "begin\n" +
                "x := 1;\n" +
                "while ( x < 3 ) do\n" +
                "x := x + 1;\n" +
                "end.";
        List<String> cadeias = tokenize(input);

        System.out.println(String.format("%15s", "Cadeia") + "        | " + String.format("%15s", "Token"));
        System.out.println("--------------------------------------------------------------");

        for (String item : cadeias) {
            System.out.println(String.format("%15s", item) + "        | " + String.format("%15s", getPascalToken(item)));
        }

    }

    public static List<String> tokenize(String input) {
        String[] tokensProcesso1 = input.split("\\s+");
        List<String> tokensProcesso2 = new ArrayList<>();
        for (String token : tokensProcesso1) {
            if (token.contains(";")) {
                tokensProcesso2.add(token.substring(0, token.length() - 1));
                tokensProcesso2.add(";");
            }
            else if (token.contains(":") && !token.contains(":=")) {
                tokensProcesso2.add(token.substring(0, token.length() - 1));
                tokensProcesso2.add(":");
            }
            else if (token.contains(".")) {
                tokensProcesso2.add(token.substring(0, token.length() - 1));
                tokensProcesso2.add(".");
            }
            else {
                tokensProcesso2.add(token);
            }
        }
        return tokensProcesso2;
    }

    public static String getPascalToken(String token) {
        if (getKeyword(token) != null) {
            return getKeyword(token);
        } else if (getTipo(token) != null) {
            return getTipo(token);
        } else if (getPontoEVirgula(token) != null) {
            return getPontoEVirgula(token);
        } else if (getNumero(token) != null) {
            return getNumero(token);
        } else if (getAtribuicao(token) != null) {
            return getAtribuicao(token);
        } else if (getPonto(token) != null) {
            return getPonto(token);
        } else if (getAbreParenteses(token) != null) {
            return getAbreParenteses(token);
        } else if (getFechaParenteses(token) != null) {
            return getFechaParenteses(token);
        } else if (getMais(token) != null) {
            return getMais(token);
        } else if (getMenor(token) != null) {
            return getMenor(token);
        } else if (getDoisPontos(token) != null) {
            return getDoisPontos(token);
        }
        return isIdentifier(token) ? "t_id" : "t_unknown";
    }

    public static String getKeyword(String token) {
        String[] keywords = { "begin", "end", "program", "while", "do", "var"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_" + matcher.group();
            }
        }
        return null;
    }

    public static String getTipo(String token) {
        String[] keywords = { "integer", "real", "string"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_tipo";
            }
        }
        return null;
    }

    public static String getPontoEVirgula(String token) {
        String[] keywords = { ";"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_ptvg";
            }
        }
        return null;
    }

    public static String getAtribuicao(String token) {
        String[] keywords = { ":="};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_atrib";
            }
        }
        return null;
    }

    public static String getAbreParenteses(String token) {
        String[] keywords = { "\\("};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_abrepar";
            }
        }
        return null;
    }

    public static String getFechaParenteses(String token) {
        String[] keywords = { "\\)"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_fechapar";
            }
        }
        return null;
    }

    public static String getPonto(String token) {
        String[] keywords = { "\\."};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_pt";
            }
        }
        return null;
    }

    public static String getNumero(String token) {
        String[] keywords = { "^[0-9].*"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_num";
            }
        }
        return null;
    }

    public static String getMais(String token) {
        String[] keywords = { "\\+"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_mais";
            }
        }
        return null;
    }

    public static String getMenor(String token) {
        String[] keywords = { "\\<"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_mais";
            }
        }
        return null;
    }

    public static boolean isIdentifier(String token) {
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]*$");
        Matcher matcher = pattern.matcher(token);
        return matcher.matches();
    }

    public static String getDoisPontos(String token) {
        String[] keywords = { "\\:"};
        for (String regex : keywords) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(token);
            if (matcher.matches()) {
                return "t_doispt";
            }
        }
        return null;
    }

}
