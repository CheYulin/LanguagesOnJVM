/**
 * Created by cheyulin on 10/8/16.
 */
public class Customer {

    private String name;

    public Customer(String s){
        name = s;
    }

    public String getName() {
        System.out.println("Getter");
        return name;
    }

    public void setName(String name) {
        System.out.println("Setter");
        this.name = name;
    }
}