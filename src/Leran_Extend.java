import Animal.Animal;
import Animal.Bird;
import Animal.DoveBird;

public class Leran_Extend {
    public static void main(String[] args) {
        Animal a = new Animal();
        Bird b = new Bird();
        DoveBird c = new DoveBird();
        b.fly();
        a.fly();
        a.say();
        c.fly();
        c.say();
        c.say();
    }
}
