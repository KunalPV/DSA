package Algorithms.Math.Medium;

// Solution1: Use only when the given num factorial is less than long range,
// return num * factorial(num - 1), as n! = n * (n-1) * (n-2) * .... * 2, 1
// ** base case here is, if n == 0, then return 1

// Solution2: Used for all positive numbers
// create a list, and list_size as 1, and also add 1 to list,
// run a loop 2 till n and also n, store list_size = multiply(i, list, list_size)
// reverse list and return list;

// in multiply(int i, List<Integer> list, int list_size), initialize carry with 0,
// run a loop 0 till list_size, initialize prod with list.get(j) * i + carry,
// then list.set(j, prod % 10), *** Do not use add method as it inserts the elem at give index and shifts all elems to right, instead use set method
// set carry as prod / 10;
// run loop till carry != 0, list.add(list_size, carry % 10),
// then set carry to carry / 10, and increament list_size
// return list_size;

import java.util.*;

// Good Approach, But works till the long max value, (2^63 - 1)
// Time: O(n), multiplcation happens once (constant time) but here the multiplication happens n times, n = num
// Space: O(n), n recursive calls in the stack, n = num
class Solution1 {
  public long factorial(int num) {
    if (num == 0) {
      return 1;
    }

    return (long) num * factorial(num - 1);
  }
}

// Optimal Expected Solution for large numbers whose factorial value is more
// than long range,
// Time: O(n^2 logn) -> n [loop in factorial func] * n logn [loop in multiply +
// loop for carry] -> n * log (base10 of n!) -> n * n logn, n = num
// Space:O(n logn) -> n [loop runs n times] * logn [is the size of the list (ex:
// 5 -> log(5) -> 3 -> list.reverse() -> {1, 2, 0})]
class Solution2 {
  public List<Integer> factorial(int num) {
    List<Integer> list = new ArrayList<>();

    list.add(0, 1);
    int list_size = 1;

    if (num == 1) {
      return list;
    }

    for (int i = 2; i <= num; i++) {
      list_size = multiply(i, list, list_size);
    }

    Collections.reverse(list);
    return list;
  }

  private int multiply(int i, List<Integer> list, int list_size) {
    int carry = 0;

    for (int j = 0; j < list_size; j++) {
      int prod = (list.get(j) * i) + carry;
      list.set(j, prod % 10);

      carry = prod / 10;
    }

    while (carry != 0) {
      list.add(list_size, carry % 10);
      carry = carry / 10;
      list_size++;
    }

    return list_size;
  }
}