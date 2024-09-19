public class Bear {
    // Properties of bear
    public String name;
    public String species;
    public int age;
    
    // Constructor Method
    public Bear(String BearName, String BearSpecies, int BearAge) {
        this.name = BearName;
        this.species = BearSpecies;
        this.age = BearAge;
        
    }

    // methods
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }



    // String representation of the Bear object
   
    public String BearAllInfo() {
        return "this bears name is " + name + ", his species is " + species + " Bear. He is " + age + " years old ";
    }
}





