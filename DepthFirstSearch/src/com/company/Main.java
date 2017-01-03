package com.company;

public class Main {

    public static void main(String[] args) {
        Task shirtOn=new Task("Put shirt on");
        Task underShirtOn=new Task("Put under shirt on");
        Task pantOn=new Task("Put pant on");
        Task watchOn=new Task("Wear watch");
        Task underpantOn=new Task("Wear underpants");
        Task sweaterOn=new Task("Wear Sweater");
        Task jacketOn=new Task("Wear jacket");
        Task socksOn=new Task("Put socks on");
        Task shoesOn=new Task("Put shoes on");

        TaskGraph getDressedForWork=new TaskGraph();
        getDressedForWork.addTask(sweaterOn,jacketOn);
        getDressedForWork.addTask(sweaterOn,watchOn);
        getDressedForWork.addTask(underShirtOn,shirtOn);
        getDressedForWork.addTask(shirtOn,sweaterOn);
        getDressedForWork.addTask(socksOn,shoesOn);
        getDressedForWork.addTask(pantOn,socksOn);
        getDressedForWork.addTask(underpantOn,pantOn);
        getDressedForWork.depthFirstSearch();

    }
}
