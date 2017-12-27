//Synchronized don't use the string as the lock object.
//use object object to store the string instance.
package knowledge.multiProcess.chapter2;

public class StringPool {
    public static void main(String[] args){
        String a="book";
        String b="book";
        System.out.println(a==b);

        String c="a";
        String d="a";
        System.out.println(c==d);

        String e="a";
        String f=new String(e);
        System.out.println(e==f);
        System.out.println(e);
    }
}
