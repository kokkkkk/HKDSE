package Basic;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javafx.util.Pair;

public class language {
	
	public static int lang_choose = 0;
	
	static ArrayList<Locale> l =  new ArrayList<Locale>(){
		
		private static final long serialVersionUID = -8269431241171064769L;

	{
		this.add(new Locale("en","US"));
		this.add(new Locale("zh","HK"));
		
	}};
	
	public static String lang[] = {"_en_US","_zh_HK"} ;
	
	static String font[] = {"Times New Roman","SimHei"};

	public static Font titleFont,normalFont,smallFont,VerysmallFont;
	
	static ResourceBundle gameText;
	
	static ArrayList <Pair<String,String>> gText = new ArrayList<Pair<String,String>>();
	
	public static void languageSetup(){
		
		gameText = ResourceBundle.getBundle("gameText",l.get(lang_choose));
		
		String gameText_key[] = readText("gameText_key").split("\n");
		
		titleFont = new Font(font[lang_choose], Font.PLAIN,30);
		normalFont = new Font(font[lang_choose], Font.PLAIN,21);
		smallFont = new Font(font[lang_choose], Font.PLAIN,17);
		VerysmallFont = new Font(font[lang_choose], Font.PLAIN,9);
		
		setGameText(gameText_key);
		
	}
	
	private static void setGameText(String text_key[]){
		gText.clear();
		
		for(int i = 0;i < text_key.length;i++){
			gText.add(new Pair<String,String>(text_key[i], gameText.getString(text_key[i])));
		}
		
		
	}
	
	public static Vector<String> langList(){
		Vector<String> list = new Vector<String>();
		
		String t[] = readText("langList").split("\n");
		
		for(int i = 0;i<t.length;i++){
			list.add(t[i]);
		}
		
		return list;
	}

	
	public static String getV(String key){
		
		for(Pair<String,String> p : gText){
			
			if(p.getKey().equals(key)){
				
				
				try {
				
					return new String(p.getValue().getBytes("ISO8859-1"));
					
	
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			}
		}
		return null;
	}
	
	private static String readText(String name) {
		
		String t = "";
		
		InputStream fileName = language.class.getResourceAsStream("/" +name + ".txt");
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fileName));
			
			String line = br.readLine();
			
			while(!line.equals("end")){
				
				t += line + "\n";
				line = br.readLine();
				
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return t;
	}
	
}
