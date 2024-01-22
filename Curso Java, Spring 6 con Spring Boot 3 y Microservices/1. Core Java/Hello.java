import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hello {
    public static void main(String[] args)
    {
        List<String> fruits = Arrays.asList("banana", "apple", "orange");
        List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());

        System.out.println(sortedFruits);
    }
}

