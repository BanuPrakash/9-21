package demo;


import java.util.List;

class UpperCase implements  StringTemplate.Processor<String, Throwable> {
    @Override
    public String process(StringTemplate stringTemplate) throws Throwable {
        StringBuilder sb = new StringBuilder();
        List<String> fragments = stringTemplate.fragments();
        System.out.println(fragments);
        List<Object> values = stringTemplate.values();
        System.out.println(values);

        for (int i = 0; i < fragments.size(); i++) {
            sb.append(fragments.get(i));
            if (i < values.size()) {
                sb.append(String.valueOf(values.get(i)).toUpperCase());
            }
        }
        return sb.toString();

    }
}

class SQLTemplateProcessor implements StringTemplate.Processor<String,Throwable> {

    @Override
    public String process(StringTemplate stringTemplate) throws Throwable {
        // santize
        return null;
    }

}
public class StringTemplateExample {
    public static void main(String[] args) throws Throwable {
        String p1 = "Laptop";
        double price1 = 282323.22;

        String p2 = "iPhone";
        double price2 = 82323.22;

        String orderDetails = STR."""
                Order Details:

                Item: \{p1}, Price: Rs\{price1}

                 Item: \{p2}, Price: Rs\{price2}
                """;

        System.out.println(orderDetails);

        String name = "Alice";
        String city = "new york";

        // Using the custom UPPERCASE processor
        String processedString = new UpperCase()."Hello, \{name}! You live in \{city}.";
        System.out.println(processedString);
    }
}
