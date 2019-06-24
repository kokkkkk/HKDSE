package Basic;
import java.util.Random;

public class initial {
	Random rand = new Random();
	
	public int day = 1;
	public int Chin = 0; //Chinese
	public int Eng = 0;  //English
	public int Math = 0; //Mathematics
	public int ls = 0; //Mathematics
	public int sub_1 = 0; // Subject 1
	public int sub_2 = 0; // Subject 2
	public int iniValue = rand.nextInt(11)+1;
	public int[] study = {0,0,0,0,0,0,0}; //null, chin, eng, math, ls, sub1, sub2
	public String[] subject = {"null","Chinese", "English", "Math", "LS", "Sub1", "Sub2"};
}
