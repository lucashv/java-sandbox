package com.lhvsofteng.java.sandbox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Gene {
  /*
  AB
  A
  A
   */
  public static void main(String[] args) {
    System.out.println(getPossibleCombinations("AB", "A", "A"));
  }

  private static List<String> getPossibleCombinations(
      String parent1, String parent2, String child) {
    List<String> p1 = getPhenotype(parent1);
    List<String> p2 = getPhenotype(parent2);

    Set<String> result = new TreeSet<>();
    for (String string : p1) {
      for (String s : p2) {
        result.addAll(createCombination(string, s));
      }
    }

    return result.stream().toList();
  }

  private static Set<String> createCombination(String gen1, String gen2) {
    Set<String> combinations = new HashSet<>();
    for (int i = 0; i < gen1.length(); i++) {
      for (int j = 0; j < gen2.length(); j++) {
        combinations.add(gen1.charAt(i) + "" + gen2.charAt(j));
      }
    }
    return combinations;
  }

  private static List<String> getPhenotype(String gen) {
    List<String> phenotypes = new ArrayList<>();

    switch (gen) {
      case "A":
        phenotypes.add("AA");
        phenotypes.add("AO");
        break;
      case "B":
        phenotypes.add("BB");
        phenotypes.add("BO");
        break;
      case "O":
        phenotypes.add("OO");
        break;
      case "AB":
      case "BA":
      default:
        phenotypes.add("AB");
        break;
    }

    return phenotypes;
  }
}
