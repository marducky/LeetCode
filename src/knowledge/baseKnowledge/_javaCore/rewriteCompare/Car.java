package knowledge.baseKnowledge._javaCore.rewriteCompare;

class Car implements Comparable<Object> {
    public final static int STRNO = 1;
    public final static int STRNAME = 2;
    public final static int PRICE = 3;
    public final static int SALE = 4;
    public static int SortFiled = STRNO;

    private long strNo;
    private String strName;
    private int price;
    private int sale;

    public long getStrNo() {
        return strNo;
    }

    public void setStrNo(long strNo) {
        this.strNo = strNo;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Car(long strNo, String strName, int price, int sale) {
        super();
        this.strNo = strNo;
        this.strName = strName;
        this.price = price;
        this.sale = sale;
    }

    //按价格
    public int compareTo(Object o) {
        Car car = (Car) o;
        switch (SortFiled) {
            case STRNO:
                return (int) (this.strNo - car.strNo);
            case STRNAME:
                return this.strName.compareTo(car.strName);
            case PRICE:
                return this.price - car.price;
            case SALE:
                return this.sale - car.sale;
            default:
                break;
        }
        return 0;
    }

}
