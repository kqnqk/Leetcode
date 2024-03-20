// Part 1 of 3: buildGuessResult

// Given an answer word and a guess word, return an array of length 5 that 
// determines the result of the guess. This array will return "G" for green if the 
// guessed letter is at the same index of the answer, "Y" for yellow if the guessed
// letter is in the answer (but not at the same index) and "_" otherwise.

// Assume no word has multiple of the same letter (all letters in a word are unique).

// const answer = "spare"
// const guess = "solar"
// buildGuessResult(answer, guess) => ["G", "_", "_", "Y", "Y"]

// const answer = "bool"
// const guess = "fole"

// const answer = "piano"
// const guess = "logic"
// buildGuessResult(answer, guess) => ["_", "Y", "_", "Y", "_"]


class Mon0311 {
    public static void main(String[] args) {
        System.out.println(buildGuessResult("spare","solar").toString());
    }

    public static char[] buildGuessResult(String answer, String guess) {
        int [] memo = new int[26];
        var result = new char[answer.length()];
        for(char c: answer.toCharArray()) memo[c -'a']++;

        for(int i =0; i< guess.length(); i++){
            var cA = answer.charAt(i);
            var cB = guess.charAt(i);
            result[i] = cA == cB? 'G': (memo[cB] > 0? 'Y' : '_');
        }

        return result;


    }

    
}