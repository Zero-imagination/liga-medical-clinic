package liga.medical.medicalmonitoring.core.antisolid;

public class AntiO {
    private String[] fruits = new String[]{"banana", "blueberry", "strawberry"};

    public String fruitColor(String[] fruits){
        for (String fruit: fruits) {
            if (fruit.equals("banana")) return "yellow";
            if (fruit.equals("blueberry")) return "black";
            if (fruit.equals("strawberry")) return "red";
        }
        return "[404] fruit not found";
    }

    public AntiO(){
        fruitColor(fruits);
    }

}
