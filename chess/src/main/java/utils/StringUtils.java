package utils;

public class StringUtils {
    public static final String NEWLINE = System.getProperty("line.separator");

    //생성자를 private으로 선언: 객체 생성을 방지
    private StringUtils(){
    }
    public static String appendNewLine(String str){
        return str + NEWLINE;
    }

}
