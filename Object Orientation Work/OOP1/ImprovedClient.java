import java.util.*;

public class ImprovedClient {
  public static void main(String[] args) {
    Map <Pet, String> ourAnimals = new HashMap <Pet, String>() {{
                                     put(new Chinchilla(), "Killa Chinchilla");
                                     put(new ZebraFinch(), "Cheep and Cheerful");
                                     put(new Rabbit(), "Bugs Bunny");
                                     put(new Canary(), "Cheep and Tuneful"); }};


    for (Pet p : ourAnimals.keySet()) {
      p.setName(ourAnimals.get(p));
      System.out.print("The " + p.classOfAnimal() + "'s name is " + p.getName());
    if (p.canFly())
      System.out.println(" and it *can* fly");
    else
      System.out.println(" and it *cannot* fly");      
    }
  }
}
