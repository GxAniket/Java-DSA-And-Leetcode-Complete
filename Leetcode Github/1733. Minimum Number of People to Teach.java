import java.util.*;

public class MinimumPeopleToTeach {
    
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        
        // Store languages known by each person
        List<Set<Integer>> knows = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) {
                set.add(lang);
            }
            knows.add(set);
        }

        // Find all people who are in friendships but can't talk
        Set<Integer> badPeople = new HashSet<>();
        for (int[] fr : friendships) {
            int a = fr[0] - 1;
            int b = fr[1] - 1;

            // check if they share a language
            boolean share = false;
            for (int lang : knows.get(a)) {
                if (knows.get(b).contains(lang)) {
                    share = true;
                    break;
                }
            }

            if (!share) {
                badPeople.add(a);
                badPeople.add(b);
            }
        }

        if (badPeople.isEmpty()) {
            return 0; // everyone can already talk
        }

        // Try teaching each language to bad people
        int answer = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int person : badPeople) {
                if (!knows.get(person).contains(lang)) {
                    count++;
                }
            }
            answer = Math.min(answer, count);
        }

        return answer;
    }

    public static void main(String[] args) {
        int n1 = 3;
        int[][] langs1 = { {1}, {2}, {3}, {1, 2} };
        int[][] fr1 = { {1, 2}, {1, 3}, {2, 4} };
        System.out.println(minimumTeachings(n1, langs1, fr1)); // 2

        int n2 = 2;
        int[][] langs2 = { {1}, {1, 2}, {2} };
        int[][] fr2 = { {1, 2}, {2, 3} };
        System.out.println(minimumTeachings(n2, langs2, fr2)); // 0

        int n3 = 4;
        int[][] langs3 = { {1}, {2}, {3}, {4} };
        int[][] fr3 = { {1, 2}, {3, 4} };
        System.out.println(minimumTeachings(n3, langs3, fr3)); // 3
    }
}
