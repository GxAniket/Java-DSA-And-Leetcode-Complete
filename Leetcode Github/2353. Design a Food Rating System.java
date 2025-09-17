import java.util.*;

/**
 * LeetCode 2353: Design a Food Rating System
 * 
 * We need to:
 * 1. Keep track of foods, their cuisines, and ratings.
 * 2. Efficiently change ratings.
 * 3. Quickly get the highest rated food of a cuisine
 *    (if ratings tie, lexicographically smallest name wins).
 */
class FoodRatings {

    /** Node representing (food name, rating) with custom ordering */
    private static class Node implements Comparable<Node> {
        String food;
        int rating;

        Node(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        /** Order by rating descending, then food name ascending */
        @Override
        public int compareTo(Node other) {
            if (this.rating != other.rating) {
                return other.rating - this.rating; // higher rating first
            }
            return this.food.compareTo(other.food); // lexicographically smaller first
        }

        /** For TreeSet remove to work correctly */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node n = (Node) o;
            return rating == n.rating && food.equals(n.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food, rating);
        }
    }

    // Maps
    private final Map<String, String> foodToCuisine = new HashMap<>();
    private final Map<String, Node> foodToNode = new HashMap<>();
    private final Map<String, TreeSet<Node>> cuisineToSet = new HashMap<>();

    /** Constructor: build maps and TreeSets */
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);

            Node node = new Node(food, rating);
            foodToNode.put(food, node);

            cuisineToSet.computeIfAbsent(cuisine, k -> new TreeSet<>()).add(node);
        }
    }

    /** Change the rating of a food */
    public void changeRating(String food, int newRating) {
        Node oldNode = foodToNode.get(food);
        String cuisine = foodToCuisine.get(food);
        TreeSet<Node> set = cuisineToSet.get(cuisine);

        // Remove the old node from TreeSet
        set.remove(oldNode);

        // Create new node with updated rating
        Node newNode = new Node(food, newRating);
        foodToNode.put(food, newNode);

        // Add updated node to TreeSet
        set.add(newNode);
    }

    /** Return the highest rated food for a cuisine */
    public String highestRated(String cuisine) {
        // TreeSet is always sorted, first() is the highest rated
        return cuisineToSet.get(cuisine).first().food;
    }

    /** MAIN method for demonstration */
    public static void main(String[] args) {
        // Example from LeetCode
        String[] foods = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] cuisines = {"korean","japanese","japanese","greek","japanese","korean"};
        int[] ratings = {9,12,8,15,14,7};

        // Create FoodRatings object
        FoodRatings fr = new FoodRatings(foods, cuisines, ratings);

        // Query highest rated japanese
        System.out.println(fr.highestRated("japanese")); // Output: "ramen"

        // Change rating of sushi to 16
        fr.changeRating("sushi", 16);

        // Now sushi should be highest rated japanese
        System.out.println(fr.highestRated("japanese")); // Output: "sushi"

        // Change rating of ramen to 16 too; lexicographically smaller wins
        fr.changeRating("ramen", 16);

        // Among sushi(16) and ramen(16), ramen is lexicographically smaller
        System.out.println(fr.highestRated("japanese")); // Output: "ramen"
    }
}
