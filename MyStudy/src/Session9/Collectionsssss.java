package Session9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CollecionCompare implements Comparator<CollectionModel>
{
	public int compare(CollectionModel o1, CollectionModel o2) 
	{
		
		return o1.getName().compareTo(o2.getName());
	}
	
}

public class Collectionsssss
{
	public static void main(String[] args) 
	{
		List<CollectionModel> li = new ArrayList<CollectionModel>();
		 li.add(new CollectionModel(1, "Nayeon", "Lead Vocalist"));
		 li.add(new CollectionModel(2, "Jungyeon", "Lead Vocalist"));
		 li.add(new CollectionModel(3, "Momo", "Main Dancer"));
		 li.add(new CollectionModel(4, "Sana", "Lead Vocalist"));
		 li.add(new CollectionModel(5, "Jihyo", "Main Vocalist"));
		 li.add(new CollectionModel(6, "Mina", "Lead Vocalist"));
		 li.add(new CollectionModel(7, "Dahyun", "Lead Rapper"));
		 li.add(new CollectionModel(8, "Chaeyoung", "Main Rapper"));
		 li.add(new CollectionModel(9, "Tzuyu", "Lead Dancer"));
		 
		 
		 Comparator<CollectionModel> comm = new CollecionCompare();
		 Collections.sort(li, comm);
		 
		 for(CollectionModel c : li)
		 {
			 System.out.println(c.getName());
		 }
	}
}
