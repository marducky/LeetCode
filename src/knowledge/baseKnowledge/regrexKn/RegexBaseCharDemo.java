package knowledge.baseKnowledge.regrexKn;

import java.util.regex.Pattern;

public class RegexBaseCharDemo {
    public static void main(String[] args) {
        String regrexDemo = "1.21.31.21.3123hu12hu122hu12hu12qimengqialibabalibabalibabalibab22aliba2alibab333.3333";
        //all
        System.out.println(regrexDemo.matches(".*"));
        //a char
        System.out.println("a".matches(".*"));
        // some same char
        System.out.println("aaaaaa".matches("a+"));
        //0 or 1 char
        System.out.println("".matches("a?"));
        System.out.println("a".matches("a?"));
        // o or n char
        System.out.println("".matches("a*"));
        System.out.println("a".matches("a*"));
        System.out.println("aa".matches("a*"));
        // nat match
        System.out.println(Pattern.matches(".", regrexDemo));
        //1 or n char, and the int\
        System.out.println("qqqqq2".matches("q+[0-9]"));
        //12-100 int
        System.out.println("12345667890123".matches("\\d{12,100}"));
        System.out.println("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
        System.out.println("192".matches("[0-2][0-9][0-9]"));
        // 4个任意空白
        System.out.println(" \n\r\t".matches("\\s{4}"));
        // 特殊字符\需转义
        System.out.println("\\".matches("\\\\"));
        // 以h开头，中间有0~N个字符，最后以o结尾
        System.out.println("hello".matches("^.*o$"));
        // 以h开头，中间1~3个字母尾随一个o，接着空白连着0~N个字符并以d结尾
        System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));
        // 以任意空白且不以换行开头为开头，并以换行结尾
        System.out.println("   \n".matches("^[\\s&&[^\\n]]*\\n$"));
        // 0~N个字符，连接4个数字和一个字符
        System.out.println("aaa 2222q".matches(".*\\d{4}."));

    }
}
