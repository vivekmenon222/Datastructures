package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Task socks=new Task(UUID.randomUUID(),"socks");
        Task shoes=new Task(UUID.randomUUID(),"shoes");
        Task underwear=new Task(UUID.randomUUID(),"underwear");
        Task pants=new Task(UUID.randomUUID(),"pants");
        Task shirt=new Task(UUID.randomUUID(),"shirt");
        Task jacket=new Task(UUID.randomUUID(),"jacket");
        Task watch=new Task(UUID.randomUUID(),"watch");

        shoes.addDependency(socks);
        pants.addDependency(underwear); 
        shoes.addDependency(pants);
        jacket.addDependency(shirt);

        TopologicalSorter sorter=new TopologicalSorter();
        sorter.addTaskToSort(socks);
        sorter.addTaskToSort(shoes);
        sorter.addTaskToSort(underwear);
        sorter.addTaskToSort(pants);
        sorter.addTaskToSort(shirt);
        sorter.addTaskToSort(jacket);
        sorter.addTaskToSort(watch);

        List<Task>sorted=sorter.getSortedList();
        for(Task task:sorted)
        {
            System.out.println(task.getName());
        }
    }
}
