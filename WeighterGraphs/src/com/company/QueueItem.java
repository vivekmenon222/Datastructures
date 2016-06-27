package com.company;

/**
 * Created by menonv on 6/26/2016.
 */
public class QueueItem {
   private City city;
   private City parent;

   public QueueItem(City city, City parent)
   {
      this.city=city;
      this.parent=parent;

   }

   public City getCity() {
      return city;
   }

   public void setCity(City city) {
      this.city = city;
   }

   public City getParent() {
      return parent;
   }

   public void setParent(City parent) {
      this.parent = parent;
   }
}
