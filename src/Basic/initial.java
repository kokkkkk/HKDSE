package Basic;
import java.util.Random;

public class initial {
	static Random rand = new Random();
	
	/*initial setting*/
	public static int day = 1;
	public static int Chin = 0; //Chinese
	public static int Eng = 0;  //English
	public static int Math = 0; //Mathematics
	public static int ls = 0; //Mathematics
	public static int sub_1 = 0; // Subject 1
	public static int sub_2 = 0; // Subject 2
	public static int iniValue = rand.nextInt(11)+1;
	public static int moneyValue = rand.nextInt(200)+1;
	public static int[] study = {0,0,0,0,0,0,0}; //null, chin, eng, math, ls, sub1, sub2
	public static int[] knowledge = {0,0,0,0,0,0,0};
	public static int[] examSkill = {0,0,0,0,0,0,0};
	public static String[] subject = {"null","Chinese", "English", "Math", "LS", "Sub1", "Sub2"};
	
	//Used by main.energy class
	public static int energyValue = 100;
	public static int energyUseupDay = 0;
	public static boolean exhaust = false;
	
	//Used by main.study class
	public static boolean tired = false;
	
	//Used by main.money class
	public static boolean moneyUseup = false;
	
	//For value reset
	private static int[] o_study = {0,0,0,0,0,0,0};
	private static int[] o_knowledge = {0,0,0,0,0,0,0};
	private static int[] o_examSkill = {0,0,0,0,0,0,0};
	
	
	public static void valueSetup(int dayValue, int money, int[] studyValue, int[] knowledgeValue, int[]examSkillValue){
		day = dayValue;
		
		moneyValue = money;
	
		study = studyValue;
		knowledge = knowledgeValue;
		examSkill = examSkillValue;
		
		 Chin = study[1]; //Chinese
		 Eng = study[2];   //English
		 Math = study[3];  //Mathematics
		 ls = study[4];  //Mathematics
		 sub_1 = study[5]; // Subject 1
		 sub_2 =study[6];  // Subject 2

	}
	
	public static void valueReset(){
		day = 1;
		Chin = 0; //Chinese
		Eng = 0;  //English
		Math = 0; //Mathematics
		ls = 0; //Mathematics
		sub_1 = 0; // Subject 1
		sub_2 = 0; // Subject 2
		iniValue = rand.nextInt(11)+1;
		moneyValue = 0;
		study = o_study; //null, chin, eng, math, ls, sub1, sub2
		knowledge = o_knowledge;
		examSkill = o_examSkill;
		
		energyValue = 100;
		energyUseupDay = 0;
		exhaust = false;
		
		//Used by main.study class
		tired = false;
		
		//Used by main.money class
		moneyUseup = false;
	}
}
