package knowledge.javaCore.javaHighLevel;

import java.util.*;

class OrderV {
    private String OrderNo;
    private String UserId;

    public String getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(String orderNo) {
        OrderNo = orderNo;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}

public class DuplicateOrder {
    private static List<OrderV> removeDuplicateOrder(List<OrderV> orderVS) {
        Set<OrderV> set = new TreeSet<OrderV>(new Comparator<OrderV>() {
            @Override
            public int compare(OrderV o1, OrderV o2) {
                return o1.getUserId().compareTo(o2.getUserId());
            }
        });
        set.addAll(orderVS);
        return new ArrayList<OrderV>(set);
    }

    public static void main(String[] args) {
        //main method
        List<OrderV> orderVList = new ArrayList<OrderV>();
        OrderV v1 = new OrderV();
        v1.setOrderNo("11");
        v1.setUserId("aa");
        orderVList.add(v1);

        OrderV v2 = new OrderV();
        v2.setOrderNo("22");
        v2.setUserId("bb");
        orderVList.add(v2);

        OrderV v3 = new OrderV();
        v3.setOrderNo("33");
        v3.setUserId("aa");
        orderVList.add(v3);

        List<OrderV> dataList = removeDuplicateOrder(orderVList);
        for (OrderV data : dataList) {
            System.out.println(data.getOrderNo() + " : " + data.getUserId());
        }
    }
}
