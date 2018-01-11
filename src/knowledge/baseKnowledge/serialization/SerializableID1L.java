package knowledge.baseKnowledge.serialization;

/**
 * https://www.ibm.com/developerworks/cn/java/j-lo-serial/
 */

import java.io.Serializable;

public class SerializableID1L implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
