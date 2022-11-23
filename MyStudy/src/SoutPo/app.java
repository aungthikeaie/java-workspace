package SoutPo;

import java.util.ArrayList;
import java.util.List;



public class app 
{
	public static void main(String[] args) 
	{
		List<Student> stu=showInfo();
		for(Student s:stu)
		{
			System.out.println(s.getId()+s.getName());
		}
		
		
	}
	
	public static List<Student> showInfo()
	{
		String name="Ma Ma";
		int id=1;
		
		Student sd1 = new Student("dsjkj",7);
		Student sd2 = new Student("dsjkj",7);
		Student sd3 = new Student("dsjkj",7);
		List<Student> list = new ArrayList<Student>();
		list.add(sd1);
		list.add(sd2);
		list.add(sd3);
		
		
		return list;
	}
}