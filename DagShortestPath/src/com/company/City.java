package com.company;

import java.util.Objects;

public class City {
   public String name;

   public City(String name) {
      this.name = name;
   }

   public City parent;

   public boolean isVisited = false;
   public boolean inProcess = false;
   public int distanceFromSource = Integer.MAX_VALUE;

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      City city = (City) o;
      return Objects.equals(name, city.name);
   }

   @Override
   public int hashCode() {
      return Objects.hash(name);
   }

   @Override
   public String toString() {
      return "City{" +
              "name='" + name + '\'' +
              '}';
   }
}
