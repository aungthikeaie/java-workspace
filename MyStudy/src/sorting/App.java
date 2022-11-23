package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PesonComparator implements Comparator<Peson>{

	@Override
	public int compare(Peson p1, Peson p2) {
		if(p1.getId()>p2.getId())
		{
			return -1;
		}
		return 1;
	}
	
}
public class App {

	public static void main(String[] args) {
		
		List<Peson> list = new ArrayList<Peson>();
		list.add(new Peson(1,"kknjknj"));
		list.add(new Peson(2,"kknjkn3"));
		list.add(new Peson(2,"kknjkn2"));
		list.add(new Peson(3,"kknjknj"));
		
		Comparator<Peson> p=new PesonComparator();
		Collections.sort(list,p);
		for(Peson p1:list)
		{
			System.out.println(p1.getId()+":"+p1.getName());
		}
	}
}
