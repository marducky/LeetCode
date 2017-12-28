package knowledge.baseKnowledge.objectClassKn;

class City {
    private String name;

    City(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}

public class NumGroupCopy {
    public static void main(String[] args) {
        double[] temps = {98.6, 32.0, 100.0, 212.0, 53.5};
        for (double temp : temps)
            System.out.printf("%.1f ", temp);
        System.out.println();
        double[] temps2 = temps.clone();
        for (double temp : temps2)
            System.out.printf("%.1f ", temp);
        System.out.println();
        System.out.println();
        City[] cities = {new City("Denver"), new City("Chicago")};
        for (City city : cities)
            System.out.printf("%s ", city.getName());
        System.out.println();
        City[] cities2 = cities.clone();
        for (City city : cities2)
            System.out.printf("%s ", city.getName());
        System.out.println();
        cities[0].setName("Dallas");
        for (City city : cities2)
            System.out.printf("%s ", city.getName());
        System.out.println();
    }
}

