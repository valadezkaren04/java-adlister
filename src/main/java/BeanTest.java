import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        Album butter = new Album(1,"BTS", "Butter", 2021, 32.2, "K-Pop");
        Author hp = new Author(1, "J.K", "Rowling");
        Quote quote = new Quote(1, "\"It does not do well to dwell on dreams and forget to live.\"", hp);

        System.out.println(butter.getGenre());
        System.out.println(quote.getAuthor().getId());
        System.out.println(quote.getContent());

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(2, "\"To the well-organized mind, death is but the next great adventure.\"", new Author(2, "Albus", "Dumbledore")));
        quotes.add(new Quote(3, "\"But you know, happiness can be found even in the darkest of times, if one only remembers to turn on the light.\"", hp));

        for (Quote quotee : quotes){
            System.out.println("Here's a quote for you! ***");
            System.out.printf("%s%n    - %s %s%n", quotee.getContent(), quotee.getAuthor().getFirstName(), quotee.getAuthor().getLastName());
        }
    }

}
