package Day16;

public class StringBufferConstructors 
{
	public static void main(String[] args) 
	{
		StringBuffer buffer1,buffer2,buffer3;
		String output;
		
		buffer1 = new StringBuffer();
		buffer2 = new StringBuffer(10);
		buffer3 = new StringBuffer("Hello");
		
		output = "buffer1 = "+buffer1.toString()+"\""
				+ "\nbuffer2 = "+buffer2.toString()+"\""
				+ "\nbuffer3 = "+buffer3.toString()+"\"";
		
	}
}
