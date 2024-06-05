import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // Initialize the frequency map with the first word
        for (char c : words[0].toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Update the frequency map with the minimum frequencies
        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> currentMap = new HashMap<>();
            for (char c : words[i].toCharArray()) {
                currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
            }

            // Retain only the minimum frequency of each character
            for (char key : freqMap.keySet()) {
                if (currentMap.containsKey(key)) {
                    freqMap.put(key, Math.min(freqMap.get(key), currentMap.get(key)));
                } else {
                    freqMap.put(key, 0); // Ensure characters not in current word are set to 0
                }
            }
        }

        // Prepare the list of common characters
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            for (int j = 0; j < val; j++) {
                result.add(String.valueOf(key));
            }
        }

        return result;
    }
}
