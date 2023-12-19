package calculator;

public class RegexUtils {
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    public static final String NUMBER_REGEX = "[0-9]+";

    public static String[] split(String input, String regex) {
        return input.split(regex);
    }
}
