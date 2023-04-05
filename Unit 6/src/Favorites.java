import java.util.List;
import java.util.ArrayList;

public class Favorites {
    List<String> favorites = new ArrayList<String>();
    List<String> options = new ArrayList<String>();
    public Favorites() {
        favorites.add("The Office");
        favorites.add("Saturday Night Live");
        favorites.add("The Simpsons");
        favorites.add("Stranger Things");
        favorites.add("Family Guy");
        favorites.add("Game of Thrones");
        favorites.add("The Mandalorian");
        favorites.add("The Big Bang Theory");
        favorites.add("His Dark Materials");
        favorites.add("Avatar: The Last Airbender");
    }

    public List<String> askQuestions() {
        if (favorites.size() == 1) {
            options.add(favorites.get(0));
            return options;
        }
        while (options.size() < 3) {
            int index = (int) (Math.random() * favorites.size());
            if (!options.contains(favorites.get(index))) {
                options.add(favorites.get(index));
            }
            if (options.size() == favorites.size()) {
                break;
            }
        }
        return options;
    }

    public void selectedOption(int option) {
        //Remove the option from options, and remove the remaining elements from favorites
        options.remove(option);
        for (int i = 0; i < options.size(); i++) {
            favorites.remove(options.get(i));
        }
        options = new ArrayList<String>();
    }

    public List<String> getFavorites() {
        return favorites;
    }
}
