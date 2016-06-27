package com.company;

/**
 * Created by menonv on 6/26/2016.
 */

import java.lang.invoke.ConstantCallSite;

/**
 * Created by Home on 6/5/2016.
 */
public class City {

   private String name;
   private boolean visited;
   private City parent;
   private int depth;

   public City(String name) {
      this.name = name.toLowerCase();
   }

   public String getName() {
      return name;
   }

   public void visit(City parent, boolean doPrint) {
      this.visited = true;
      if (parent != null) {
         this.parent = parent;
         this.depth = parent.depth + 1;
      } else {
         this.depth = 0;
      }
      if (doPrint) {
         print();
      }
   }

   private void print() {
      if (this.parent != null) {
         System.out.println("Parent: " + this.parent.name);
      }
      System.out.println("Airport:" + this.name);

      System.out.println("Depth: " + this.depth);
      System.out.println("----------------");
   }

   @Override
   public int hashCode() {
      return name.hashCode();
   }

   @Override
   public boolean equals(Object obj) {
      boolean returnVal = false;
      if (obj == null || !(obj instanceof City)) {
         returnVal = false;
      } else if (((City) obj).name.equals(this.name)) {
         returnVal = true;
      }

      return returnVal;
   }

   public boolean isVisited() {
      return visited;
   }

   public City getParent() {
      return parent;
   }

   public void setParent(City parent) {
      this.parent = parent;
   }

   public int getDepth() {
      return depth;
   }

   public void setDepth(int depth) {
      this.depth = depth;
   }

   public void resetVisited() {
      visited = false;
   }
}
