package TestPack;
import Twice.*;

public class FirstProgram extends Summing
{
	public FirstProgram(int a, int b) 
	{
		super(a, b);
	}

	public static void main(String[] args) 
	{
		FirstProgram fp = new FirstProgram(3,6);
		System.out.println(fp.summ());
	}
}
