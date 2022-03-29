package com.myorg.helpers;

import java.util.List;

import com.myorg.models.Worker;

public class WorkerHelper {
	public static void printAllWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
			System.out.println("ID: \t\t" + worker.getWorkerId());
			System.out.println("NAME: \t\t" + worker.getFirstName() + " "+ worker.getLastName() );
			System.out.println("SALARY: \t" + worker.getSalary());
			System.out.println("JOINING DATE : \t" + worker.getJoiningDate());
			System.out.println("DEPARTMENT : \t" + worker.getDepartment());
			System.out.println("EMAIL : \t" + worker.getEmail());
			System.out.println();
		}
	}
}
