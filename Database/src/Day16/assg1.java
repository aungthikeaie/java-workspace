package Day16;

import java.util.StringTokenizer;

public class assg1 
{
	public static void main(String[] args) 
	{
		String nrc = new String("12/SaKhaNa(Naing)123456");
		String s = "(Naing)";
		StringTokenizer stk = new StringTokenizer(nrc,"/()");
		
		
		System.out.println("division/state = " + stk.nextToken());
		System.out.println("city = " + stk.nextToken());
		stk.nextToken();
		System.out.println("number = " + stk.nextToken());
		
	}
}
