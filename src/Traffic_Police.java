public class Traffic_Police {
    int PoliceID;
    public String Name;     //police-name
    private int Salary;
    private int Age;
    public int YearsOfExperience;
    private String Address;

    public Traffic_Police(int policeID, String name, int salary, int age, int yearsOfExperience, String address) {
        PoliceID = policeID;
        Name = name;
        Salary = salary;
        Age = age;
        YearsOfExperience = yearsOfExperience;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public int getSalary() {
        return Salary;
    }

    public int getAge() {
        return Age;
    }

    public int getYearsOfExperience() {
        return YearsOfExperience;
    }

    public String getAddress() {
        return Address;
    }
}
