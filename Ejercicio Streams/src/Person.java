public class Person {

    private String name, city;
    private int age;

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString(){
        return "/// Nombre Completo: " + this.name + ", Ciudad: " + this.city + ", Edad: " + this.age+" ///";
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public void setAge(int newAge){
        this.age = newAge;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setCity(String newCity){
        this.city = newCity;
    }

}