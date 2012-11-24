import java.util.*;



public class Test {
	public static void main(String[] args) {
		//hihi
		test1();
		
		/*
		Android s12;
		Android s13;
		Android h11;
		Android h12;
		Android g8;
		
		s12 = new Servant(12) {};
		s12.setSkin(new TouchSensitiveSkin());
		System.out.println(al.insert(s12));

		s13 = new Servant(13) {};
		s13.setSkin(new SolidSkin());
		System.out.println(al.insert(s13));

		h11 = new HeavyWorker(11) {};
		h11.setSkin(new ArmoredSkin());
		System.out.println(al.insert(h11));

		h12 = new HeavyWorker(12) {};
		h12.setSkin(new TouchSensitiveSkin());
		System.out.println(al.insert(h12));

		g8 = new Guard(8) {};
		g8.setSkin(new SolidSkin());
		System.out.println(al.insert(g8));
		
		g8 = new Guard(8) {};
		g8.setSkin(new TouchSensitiveSkin());
		System.out.println(al.insert(g8));*/
		
	}


private static void test1()
{
	//Test history logging function of AndroidList
	AndroidList al = new AndroidList();
	ArrayList<Aktor> ak = new ArrayList<Aktor>();
	ak.add(new Aktor(12, "Putzen", 0.5));
	ArrayList<Sensor> as = new ArrayList<Sensor>();
	as.add(new Sensor(12, "Staub"));
	
	Android s201 = new Associate(12, new Kit(12, ak, as), new TouchSensitiveSkin(12), new Associate.BaseSoftware(12, new SecurityLevel1()));
	System.out.println(al.insert(s201)+ "\tcreate new Associate Android");
	
	System.out.println();
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("Ausgelieferter Android Nr.: ", al);
	System.out.println();
	
	//same Android will be edited and gets Waschen Aktor
	ak = new ArrayList<Aktor>();
	ak.add(new Aktor(12, "Putzen", 0.5));
	ak.add(new Aktor(12, "Waschen", 0.5));
	
	Android s202 = new Assistant(12, new Kit(12, ak, as), new TouchSensitiveSkin(12) , new Assistant.BaseSoftware(12, new SecurityLevel2()));
	System.out.println(al.insert(s202) + "\tAndroid will be edited and gets Waschen Aktor");
	
	//next Android should be invalid (SecLev5 not allowed)
	Android s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Associate.BaseSoftware(21, new SecurityLevel5()) );
	System.out.println(al.insert(s210)+ "\tSecLev5 not allowed");
	
	//next Android should be invalid, Android who was Servant may not become a Fighter
	s210 = new Fighter(21, new Kit(21, ak, as), new ArmoredSkin(21), new Fighter.BaseSoftware(21, new SecurityLevel5()));
	System.out.println(al.insert(s210) + "\tAndroid who was Servant may not become a Fighter");
	
	//create new Fighter Android
	ak = new ArrayList<Aktor>(); ak.add(new Aktor(22, "Augen ausstechen", 1.));
	ak.add(new Aktor(22, "Explodieren", 50.));
	ak.add(new Aktor(22, "Giftgasabsorber", 5.));
	as = new ArrayList<Sensor>(); as.add(new Sensor(22, "Gas-Sensor"));as.add(new Sensor(22, "Notfallassistenz"));
	Android s220 = new Fighter(22, new Kit(22, ak, as), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel5()));
	System.out.println(al.insert(s220) + "\tcreate new Fighter Android");
	
	//Fighter may become Bodyguard
	ak = new ArrayList<Aktor>(); ak.add(new Aktor(22, "Augen ausstechen", 1.));
	ak.add(new Aktor(22, "Panzerkorb", 1.));
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel4()));
	System.out.println(al.insert(s220) + "\tFighter may become Bodyguard");
	
	System.out.println();
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("Ausgelieferter Android Nr.: ", al);
	
	System.out.println();
	System.out.println("Zeige bisherige Konfigurationen des Androiden mit ID 12");
	System.out.println("Gesellschafter -> Hilfskraft mit Waschfunktion :O");
	showLog(12, al);
	
	System.out.println();
	System.out.println("Zeige bisherige Konfigurationen des Androiden mit ID 22");
	System.out.println("Kaempfer -> Beschuetzer");
	showLog(22, al);
}

private static void showAndroids(String text, AndroidList al)
{
	int cnt = 0;
	Iterator<Android> iti = al.iterator();
	while(iti.hasNext())
	{
		cnt++;
		System.out.println(text + cnt);
		System.out.println(iti.next());
		System.out.println();
	}
	System.out.println();
}

private static void showLog(int id, AndroidList al)
{
	int cnt = 0;
	Iterator<Android> iti = al.iterator(id);
	while(iti.hasNext())
	{
		cnt++;
		System.out.println("Konfiguration Nr.:" + cnt);
		System.out.println(iti.next());
		System.out.println();
	}	
	System.out.println();
}
}