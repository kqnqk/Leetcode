// We can shift a string by shifting each of its letters to its successive letter.
// * For example, "abc" can be shifted to be "bcd".
// We can keep shifting the string to form a sequence.
// * For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
// Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

// Example 1:
// Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
// Output: [["abc","bcd","xyz"],["az","ba"],["acef"],["a","z"]]

// abcz
// 1-1-1-25

// bcda

// 0-25
// a b c .. z
// 0 1 2 .. 25

// (z -> b) 1 - 25 = -24
// (y - a) 0 - 24 = -24

// abc
// 1-1-1
// {
//   [1-1-1]: ["abc", "bcd"]
//   [1]: ["a", "z"]
// }

const getDistanceKey = (word: string) => {
  if (word.length == 1) {
    return "empty";
  }
  let key = "";
  for (let i = 0; i < word.length - 1; i++) {
    const first = word[i];
    const second = word[i + 1];

    let diff = second.charCodeAt(0) - first.charCodeAt(0);
    if (diff < 0) diff = diff + 26; 
    key += diff + "-";
  }
  return key;
};

const getShiftyPatterns = (inputs: string[]) => {
  const patterns: {[key:string]: string[]} = {};
  for (let value of inputs) {
    const key = getDistanceKey(value);
    console.log(key, "key")
    patterns[key] = patterns[key] == null ? [value] : [...patterns[key], value];
  }
  const values = Object.values(patterns);
  return values;
};

console.log(
  "value ==>",
  getShiftyPatterns(["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z", "ya", "zb", "xz"])
  // getShiftyPatterns(["az", "ba"])
);
