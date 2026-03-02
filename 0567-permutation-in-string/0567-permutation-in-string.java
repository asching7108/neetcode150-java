class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] frequencyMap = new int[26];
        for (char ch : s1.toCharArray()) {
            frequencyMap[ch - 'a'] += 1;
        }

        int start = 0;
        for (int end = 0; end < s2.length(); end++) {
            char ch = s2.charAt(end);
            frequencyMap[ch - 'a'] -= 1;

            // Window is too large, shrink from left
            if (end >= s1.length()) {
                frequencyMap[s2.charAt(start) - 'a'] += 1;
                start += 1;
            }

            // Check permutation
            if (end - start + 1 == s1.length() &&
                Arrays.stream(frequencyMap).allMatch(val -> val == 0)) {
                return true;
            }
        }

        return false;
    }
}
