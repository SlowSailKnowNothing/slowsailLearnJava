package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class streamTest {
    public static void main(String[] args) {
        List<String> list= Arrays.asList("abc","cdf","efg");
        list.stream().filter(str->str.contains("f")).collect(Collectors.toList());
    }
}
