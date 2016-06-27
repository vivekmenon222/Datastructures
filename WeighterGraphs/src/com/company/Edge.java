package com.company;

/**
 * Created by menonv on 6/26/2016.
 */
public class Edge implements Comparable<Edge> {
   private City city1;
   private City city2;
   private int weight;

   public Edge(City city1, City city2, int weight) {

      this.city1 = city1;
      this.city2 = city2;
      this.weight = weight;
   }

   public City getCity1() {
      return city1;
   }

   public void setCity1(City city1) {
      this.city1 = city1;
   }

   public City getCity2() {
      return city2;
   }

   public void setCity2(City city2) {
      this.city2 = city2;
   }

   @Override
   public int hashCode() {
      return city1.hashCode() + city2.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      if (!(obj instanceof Edge)) {
         return false;
      }
      if (obj == this) {
         return true;
      }

      Edge that = (Edge) obj;

      if (this.city1.equals(that.city1) && this.city2.equals(that.city2)) {
         return true;
      } else if (this.city1.equals(that.city2) && this.city2.equals(that.city1)) {
         return true;
      } else {
         return false;
      }
   }

   public int getWeight() {
      return weight;
   }

   public void setWeight(int weight) {
      this.weight = weight;
   }

   /**
    * Compares this object with the specified object for order.  Returns a
    * negative integer, zero, or a positive integer as this object is less
    * than, equal to, or greater than the specified object.
    */
   @Override
   public int compareTo(Edge that) {
      return this.weight - that.weight;
   }
}