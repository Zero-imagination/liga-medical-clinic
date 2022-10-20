package liga.medical.medicalmonitoring.core.antisolid;

import java.util.ArrayList;
import java.util.List;

public class AntiD {
    public class Fruit{

    }
    public class Vegetable{

    }
    public class Cart{
        private List<Fruit> fruits;
        private List<Vegetable> vegetables;

        public Cart(){
            fruits = new ArrayList<>();
            vegetables = new ArrayList<>();
        }

        public void addFruit(Fruit fruit){
            fruits.add(fruit);
        }
        public void addVegetable(Vegetable vegetable){
            vegetables.add(vegetable);
        }
    }
}
