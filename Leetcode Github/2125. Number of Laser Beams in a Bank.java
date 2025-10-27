class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeams = 0;
        int prevDevices = 0;

        for (String row : bank) {
            int currentDevices = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') currentDevices++;
            }
            if (currentDevices > 0) {
                totalBeams += prevDevices * currentDevices;
                prevDevices = currentDevices;
            }
            // if currentDevices == 0 => skip (prevDevices remains same)
        }

        return totalBeams;
    }
}
