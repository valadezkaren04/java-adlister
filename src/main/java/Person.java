public class Person {
    private String name;
    private char gender;
    private int heightInCM;

    public Person() {

    }

    public Person(String name, char gender, int heightInCM) {
        this.name = name;
        this.gender = gender;
        this.heightInCM = heightInCM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(int heightInCM) {
        this.heightInCM = heightInCM;
    }


}
