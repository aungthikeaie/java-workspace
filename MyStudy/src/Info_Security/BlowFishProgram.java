package Info_Security;

import javax.crypto.*;
import java.util.*;

public class BlowFishProgram 
{
	public static void main(String[] args) throws Exception 
	{
		SecretKey key = KeyGenerator.getInstance("BlowFish").generateKey();
		Cipher cip = Cipher.getInstance("BlowFish");
		cip.init(Cipher.ENCRYPT_MODE, key);
		//Scanner sc = new Scanner(System.in); 
		String pt = "Ong Sike Aie";
		byte[] encrypted = cip.doFinal(pt.getBytes());
		cip.init(Cipher.DECRYPT_MODE, key);
		byte[] ct = cip.doFinal(encrypted);
		System.out.println(new String(encrypted) + " " + new String(ct));
	}
}
