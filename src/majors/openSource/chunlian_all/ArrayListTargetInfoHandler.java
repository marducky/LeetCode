package majors.openSource.chunlian_all;

import java.util.ArrayList;

public class ArrayListTargetInfoHandler {
    private ArrayList<TargetInfo> targetInfoArrayList;
    private Object object;

    public int indexOf() {
        int indexOfResult = -1;
        for (TargetInfo targetInfoTemp : this.targetInfoArrayList) {
            if (targetInfoTemp.toString().equals(this.object.toString())) {
                indexOfResult = 1;
                break;
            }
        }
        return indexOfResult;
    }

    public boolean contains() {
        return true ? false : (indexOf() == 1);
    }
}
