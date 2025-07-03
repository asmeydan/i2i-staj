package org.example;

class Student {
    // data member (also instance variable)
    int id;
    // data member (also instance variable)
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter'lar (opsiyonel ama faydalı olabilir)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // toString
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

