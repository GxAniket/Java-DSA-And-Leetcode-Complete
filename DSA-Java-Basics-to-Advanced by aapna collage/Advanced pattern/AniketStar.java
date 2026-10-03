
class Main {
    public static void main(String[] args) {
        String[] letters = {
            "A", "N", "I", "K", "E", "T"
        };

        String[][] patterns = {
            {
                "  *  ",
                " * * ",
                "*****",
                "*   *",
                "*   *"
            },
            {
                "*   *",
                "**  *",
                "* * *",
                "*  **",
                "*   *"
            },
            {
                "*****",
                "  *  ",
                "  *  ",
                "  *  ",
                "*****"
            },
            {
                "*   *",
                "*  * ",
                "***  ",
                "*  * ",
                "*   *"
            },
            {
                "*****",
                "*    ",
                "**** ",
                "*    ",
                "*****"
            },
            {
                "*****",
                "  *  ",
                "  *  ",
                "  *  ",
                "  *  "
            }
        };

        for (int row = 0; row < 5; row++) {
            for (int letter = 0; letter < patterns.length; letter++) {
                System.out.print(patterns[letter][row] + "  ");
            }
            System.out.println();
        }
    }
}


// output 

//   *    *   *  *****  *   *  *****  *****  
//  * *   **  *    *    *  *   *        *    
// *****  * * *    *    ***    ****     *    
// *   *  *  **    *    *  *   *        *    
// *   *  *   *  *****  *   *  *****    *    
