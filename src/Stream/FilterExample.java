package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        System.out.println(getProducts().stream().filter(it -> it.getPrice() > 100000.0).collect(Collectors.toList()));
    }



    static List<Product> getProducts(){
        List<Product> mobiles = new ArrayList<>();
        mobiles.add(new Product(1, "Apple", 150000.0));
        mobiles.add(new Product(2, "Samsung", 140000.0));
        mobiles.add(new Product(3, "Google Pixel", 80000.0));
        mobiles.add(new Product(4, "Motorola", 40000.0));
        return mobiles;
    }
}

