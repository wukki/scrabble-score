import java.util.*;

public class Scrabble {
    private int score;
    private Map<Character, Integer> scores;

    public Scrabble(String input) {
        scores = createScores();
        if (input == null) {
            score = 0;
        } else {
            input = input.replaceAll("\\s|\t|\n", "");
            for (int i = 0; i < input.length(); i++) {
                score += scores.get(input.charAt(i));
            }
        }
    }

    public int getScore() {
        return score;
    }

    private Map<Character, Integer> createScores() {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Character[] twoPoint = {'d', 'g'};
        Character[] threePoint = {'b', 'c', 'm', 'p'};
        Character[] fourPoint = {'f', 'h', 'v', 'w', 'y'};
        Character[] fivePoint = {'k'};
        Character[] eightPoint = {'j', 'x'};
        Character[] tenPoint = {'q', 'z'};
        for (int c = 'a'; c <= 'z'; c++) {
            Character character = Character.toChars(c)[0];
            int value = 1;
            if (Arrays.asList(twoPoint).contains(character)) value = 2;
            if (Arrays.asList(threePoint).contains(character)) value = 3;
            if (Arrays.asList(fourPoint).contains(character)) value = 4;
            if (Arrays.asList(fivePoint).contains(character)) value = 5;
            if (Arrays.asList(eightPoint).contains(character)) value = 8;
            if (Arrays.asList(tenPoint).contains(character)) value = 10;
            map.put(character, value);
        }
        return map;
    }
}
