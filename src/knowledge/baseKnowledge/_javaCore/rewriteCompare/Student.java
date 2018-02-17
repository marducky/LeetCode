package knowledge.baseKnowledge._javaCore.rewriteCompare;

class Student implements Comparable<Student> {
    private int age;
    private float height;
    private String name;

    public Student(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + Float.floatToIntBits(height);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (obj == this) {
            return true;
        }
        if (obj != null && obj instanceof Student) {
            Student student = (Student) obj;
            return student.age == this.age && Float.floatToIntBits(student.height) == Float.floatToIntBits(this.height)
                    && (this.name == null ? student.name == null : this.name.equals(student.name));
        }
        return false;

    }

    @Override
    public int compareTo(Student student) {
        // TODO Auto-generated method stub
        if (this.age > student.age) {
            return 1;
        }
        if (this.age < student.age) {
            return -1;
        }
        if (this.height > student.height) {
            return 1;
        }
        if (this.height < student.height) {
            return -1;
        }
        return this.name.compareTo(student.name);
    }
}