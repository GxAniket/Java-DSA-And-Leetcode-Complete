class main{
public static void main(String args[]) {
	int numOne = 10;
	int numTwo = 5;
	boolean isTrue = true;
	System.out.println(numOne++ + " " + ++numOne); //Output will be 10 12
	System.out.println(numTwo-- + " " + --numTwo); //Output will be 5 3
	System.out.println(!isTrue + " " + ~numOne); //Output will be false -13
}
}


// # Java Increment, Decrement and Bitwise Operators Explanation

// ## 📌 Code

// ```java
// public static void main(String args[]) {
//     int numOne = 10;
//     int numTwo = 5;
//     boolean isTrue = true;

//     System.out.println(numOne++ + " " + ++numOne);
//     System.out.println(numTwo-- + " " + --numTwo);
//     System.out.println(!isTrue + " " + ~numOne);
// }
// ```

// ---

// ## 📌 Explanation

// ### 🔹 1. Post and Pre Increment (`numOne++` and `++numOne`)

// * `numOne++` → Post-increment
//   Value is used first, then incremented

//   * Output value: `10`
//   * Updated value: `11`

// * `++numOne` → Pre-increment
//   Value is incremented first, then used

//   * Updated value: `12`
//   * Output value: `12`

// ✅ Output:

// ```
// 10 12
// ```

// ---

// ### 🔹 2. Post and Pre Decrement (`numTwo--` and `--numTwo`)

// * `numTwo--` → Post-decrement
//   Value is used first, then decremented

//   * Output value: `5`
//   * Updated value: `4`

// * `--numTwo` → Pre-decrement
//   Value is decremented first, then used

//   * Updated value: `3`
//   * Output value: `3`

// ✅ Output:

// ```
// 5 3
// ```

// ---

// ### 🔹 3. Logical NOT and Bitwise NOT

// * `!isTrue` → Logical NOT

//   * `true` becomes `false`

// * `~numOne` → Bitwise NOT
//   Formula:

//   ```
//   ~n = -(n + 1)
//   ```

//   For `numOne = 12`:

//   ```
//   ~12 = -(12 + 1) = -13
//   ```

// ✅ Output:

// ```
// false -13
// ```

// ---

// ## 📌 Final Output

// ```
// 10 12
// 5 3
// false -13
// ```

// ---

// ## 📌 Key Concepts

// * Post-increment (`x++`) → Use first, then update
// * Pre-increment (`++x`) → Update first, then use
// * Bitwise NOT (`~n`) → `-(n + 1)`
// * Logical NOT (`!`) → Boolean reversal

// ---

// ## 🚀 Summary

// This program demonstrates how Java handles:

// * Increment and decrement operators
// * Difference between pre and post operations
// * Logical and bitwise operations

// ---
