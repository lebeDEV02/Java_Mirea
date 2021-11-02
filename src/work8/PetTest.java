package work8;

import java.util.HashMap;
import java.util.Map;

public class PetTest {

    private static HashMap<String, Pet> pets = new HashMap<>();

    private static void initPets() {
        pets.put("Bobik", new Dog(29, 10.1));
        pets.put("Murka", new Cat(55, 22.2));
        pets.put("Owl", new Owl(3, 1.55));
    }

    private static void printPets() {
        for (Map.Entry<String, Pet> petEntry : pets.entrySet()) {
            System.out.println(petEntry.getKey() + " " + petEntry.getValue().getAge()
                    + " " + petEntry.getValue().getWeight());
        }
    }

    public static void main(String[] args) {
        initPets();
        printPets();
        pets.put("Owl", new Owl(5, 5.3));
        pets.put("Meow", new Cat(55, 12.5));
        printPets();
    }
}