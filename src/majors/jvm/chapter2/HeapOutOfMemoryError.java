/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
package majors.jvm.chapter2;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryError {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (list.add(new OOMObject())) ;
    }

}
