package com.company;


public class Main {

    public static void main(String[] args) {


        FlightsGraph paths=new FlightsGraph();
        City boston=new City("Boston");
        City paris=new City("Paris");
        City chicago=new City("Chicago");
        City mumbai=new City("Mumbai");
        City delhi=new City("Delhi");
        City beijing=new City("Beijing");



        paths.addPath(boston,paris);
        paths.addPath(boston,chicago);
        paths.addPath(paris,mumbai);
        paths.addPath(mumbai,beijing);
        paths.addPath(mumbai,delhi);
        paths.breadthFirstSearch(boston);
    }
}
