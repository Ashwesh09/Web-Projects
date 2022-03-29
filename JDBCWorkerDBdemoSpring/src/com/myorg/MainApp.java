package com.myorg;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myorg.helpers.WorkerHelper;
import com.myorg.models.Worker;
import com.myorg.services.WorkerJDBCTemplate;

public class MainApp {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		WorkerJDBCTemplate workerJDBCTemplate = (WorkerJDBCTemplate) context.getBean("workerJDBCTemplate");
		
		System.out.println("************** Records Creation **************");
		Worker worker1 = new Worker(21, "Ashwesh", "a.a@my_org.in");
		workerJDBCTemplate.create(worker1);
		System.out.println();
		
		System.out.println("************** Records Updation **************");
		Worker worker2 = new Worker(21, "Sakura", "s.s@my_org.in");
		workerJDBCTemplate.update(worker2);
		System.out.println();
		
		System.out.println("************** Records Reading **************");
		System.out.println(workerJDBCTemplate.getWorkerById(21));
		System.out.println();
		
		System.out.println("************** Displaying Worker Records **************");
		List<Worker> workers = workerJDBCTemplate.getAllWorkers(); 
		WorkerHelper.printAllWorkers(workers);
		
		System.out.println("************** Records Deleting **************");
		workerJDBCTemplate.delete(21);
		System.out.println();
	}
}