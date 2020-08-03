package Basic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class encryption {
	SecretKey key;
	Cipher cip;
	
	public encryption(){

		try {
				
			cip = Cipher.getInstance("AES");
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			key = keyGenerator.generateKey();
			initial.key = key;
				
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
				
				e.printStackTrace();
			}
		}

	public String encrypt(String text){
		
		byte[] textEncrypted = null;
		
		try {
			byte[] t = text.getBytes("UTF8");
			
			cip.init(Cipher.ENCRYPT_MODE, key);
			
			textEncrypted = cip.doFinal(t);
			
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
	
		}
		
		return Base64.getEncoder().encodeToString(textEncrypted);
		
	}
	
	public String decrypt(String text){
		byte[] textDecrypted = null;
		
		try {
			cip.init(Cipher.DECRYPT_MODE, key);
			textDecrypted = cip.doFinal(Base64.getDecoder().decode(text));
			
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			
			e.printStackTrace();
		}
		
		return new String(textDecrypted);
	}
	
	public void updateKey(SecretKey key){
		this.key = key; 
	}
}
