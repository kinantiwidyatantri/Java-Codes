public abstract class Pet { 
    protected String name;    

    public void setName(String name){   //setter for name field, basically the same thing as the setName in the unedited subclass
        this.name = name;
    }
    
    public String getName(){    //getter for name field, basically the same thing as the setName in the unedited subclass
        return name;
    }

    public abstract String classOfAnimal();  //methods that return the class of animal from the subclass

    public abstract boolean canFly(); //methods that return whether the animal can fly or not 
}

