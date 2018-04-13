package knowledge.baseKnowledge.jsonDemo;


import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

import java.lang.reflect.Field;

public class JsonBean {
    @SerializedName("NAME")
    private String name;
    private String school;
    private boolean has_girlfriend;
    private double age;
    private Object car;
    private Object house;
    private String[] major;
    private String comment;
    private transient String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isHas_girlfriend() {
        return has_girlfriend;
    }

    public void setHas_girlfriend(boolean has_girlfriend) {
        this.has_girlfriend = has_girlfriend;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Object getCar() {
        return car;
    }

    public void setCar(Object car) {
        this.car = car;
    }

    public Object getHouse() {
        return house;
    }

    public void setHouse(Object house) {
        this.house = house;
    }

    public String[] getMajor() {
        return major;
    }

    public void setMajor(String[] major) {
        this.major = major;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    private static void createJsonByBean() {
        JsonBean bean = new JsonBean();
//        bean.setName("
        bean.setName("王小二");
        bean.setAge(25.2);
        bean.setBirthday("1990-01-01");
        bean.setSchool("蓝翔");
        bean.setMajor(new String[]{"理发", "挖掘机"});
        bean.setHas_girlfriend(false);
        bean.setHouse(null);
        bean.setCar(null);
        bean.setComment("这是一个注释");
        System.out.println(new JSONObject(bean));
        Gson gson = new Gson();
        System.out.println(gson.toJson(bean));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                if (field.getName().equals("age")) {
                    return "AGE";
                }
                return field.getName();
            }
        });
        Gson gson1 = gsonBuilder.create();
        System.out.println(gson1.toJson(bean));

    }

    public static void main(String[] args) {
        createJsonByBean();

    }
}
