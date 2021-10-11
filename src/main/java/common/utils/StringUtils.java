package common.utils;

public class StringUtils {

    public static String removeEmptyText(String input){
        return input.replaceAll(" ", "");
    }
}
