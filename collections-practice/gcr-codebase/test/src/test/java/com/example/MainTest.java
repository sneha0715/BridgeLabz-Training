package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainTest {

  @Test
  void testAddition() {
    Main obj = new Main();
    int result = obj.add(2, 3);
    assertEquals(5, result);
  }
}
