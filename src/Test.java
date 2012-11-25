import java.util.*;

public class Test {
	public static void main(String[] args) {
		test3();
		test1();
		test2();
	}

/**
 * Error test: change main Android Type
 * From					To
 * Assistant			Fighter
 * 
 * Valid test: change main Android Type
 * From					To
 * Associate			Assistant
 * Fighter				Bodyguard
 * 
 * Error: Wrong Skin
 * Assistant	ArmoredSkin
 * 
 * Valid: Right Skin
 * Assistant	TouchSensitive
 * 
 * 
 * Error: Wrong Security Level
 * Assistant	Level 3,4,5
 * Bodyguard	Level 1,2,3,5
 * Fighter		Level 1,2,3,4
 * 
 * Valid: Right Security Level
 * Associate	Level 1
 * Assistant	Level 1,2
 * Fighter		Level 5
 * Bodyguard	Level 4
 * 
 */
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
	
	Android s202 = new Assistant(12, new Kit(12, ak, as), new TouchSensitiveSkin(12) , new Assistant.BaseSoftware(12, new SecurityLevel1()));
	System.out.println(al.insert(s202) + "\tAndroid will be edited and gets Waschen Aktor");
	
	s202 = new Assistant(12, new Kit(12, ak, as), new TouchSensitiveSkin(12) , new Assistant.BaseSoftware(12, new SecurityLevel1()));
	System.out.println(al.insert(s202) + "\tAndroid will be edited and gets SecLev1");
	
	//next Android should be invalid (SecLev5 not allowed)
	Android s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Associate.BaseSoftware(21, new SecurityLevel5()) );
	System.out.println(al.insert(s210)+ "\tAssistant may not have SecLev5");
	
	s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Associate.BaseSoftware(21, new SecurityLevel4()) );
	System.out.println(al.insert(s210)+ "\tAssistant may not have SecLev4");
	
	s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Associate.BaseSoftware(21, new SecurityLevel3()) );
	System.out.println(al.insert(s210)+ "\tAssistant may not have SecLev3");
	
	s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Associate.BaseSoftware(21, new SecurityLevel2()) );
	System.out.println(al.insert(s210)+ "\tAssistant may not have SecLev2");
	
	s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Assistant.BaseSoftware(21, new SecurityLevel2()) );
	System.out.println(al.insert(s210)+ "\twill be edited and gets SecLev1");
	
	s210 = new Assistant(21, new Kit(21, ak, as), new ArmoredSkin(21) , new Associate.BaseSoftware(21, new SecurityLevel5()) );
	System.out.println(al.insert(s210)+ "\tAssistant may not have Armored Skin");
	
	s210 = new Assistant(21, new Kit(21, ak, as), new TouchSensitiveSkin(21) , new Assistant.BaseSoftware(21, new SecurityLevel2()) );
	System.out.println(al.insert(s210)+ "\tnew Assistant");
	
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
	
	s220 = new Fighter(22, new Kit(22, ak, as), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel4()));
	System.out.println(al.insert(s220) + "\tFighter may not have SecLev4");
	
	s220 = new Fighter(22, new Kit(22, ak, as), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel3()));
	System.out.println(al.insert(s220) + "\tFighter may not have SecLev3");
	
	s220 = new Fighter(22, new Kit(22, ak, as), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel2()));
	System.out.println(al.insert(s220) + "\tFighter may not have SecLev2");
	
	s220 = new Fighter(22, new Kit(22, ak, as), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel1()));
	System.out.println(al.insert(s220) + "\tFighter may not have SecLev1");
	
	//Fighter may become Bodyguard
	ak = new ArrayList<Aktor>(); ak.add(new Aktor(22, "Augen ausstechen", 1.));
	ak.add(new Aktor(22, "Panzerkorb", 1.));
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel4()));
	System.out.println(al.insert(s220) + "\tFighter may become Bodyguard");
	
	ak = new ArrayList<Aktor>(); ak.add(new Aktor(22, "Augen ausstechen", 1.));
	ak.add(new Aktor(22, "Explodieren", 50.));
	ak.add(new Aktor(22, "Giftgasabsorber", 5.));
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel4()));
	System.out.println(al.insert(s220) + "\tBodyguard may not have 56kW Aktors");
	
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel2()));
	System.out.println(al.insert(s220) + "\tBodyguard may not have SecLev 2");
	
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel3()));
	System.out.println(al.insert(s220) + "\tBodyguard may not have SecLev 3");
	
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel5()));
	System.out.println(al.insert(s220) + "\tBodyguard may not have SecLev 5");
	
	s220 = new Bodyguard(22, new Kit(22, ak, as), new ArmoredSkin(22), new Bodyguard.BaseSoftware(22, new SecurityLevel1()));
	System.out.println(al.insert(s220) + "\tBodyguard may not have SecLev 1");
	
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

//returns Kits of 1kW, 5kW, 10kW, 5000kW with given id
public static class gKit{
	
	
	public Kit _1kw(int id)
	{
		ArrayList<Aktor> a1kw = new ArrayList<Aktor>();
		a1kw.add(new Aktor(id, "minimal", 1.));
		ArrayList<Sensor> sl = new ArrayList<Sensor>();
		sl.add(new Sensor(id, "sample sensor"));
		return new Kit(id, a1kw, sl);
	}
	
	public Kit _5kw(int id)
	{
		ArrayList<Aktor> a5kw = new ArrayList<Aktor>();
		a5kw.add(new Aktor(id, "mittel", 5.));
		ArrayList<Sensor> sl = new ArrayList<Sensor>();
		sl.add(new Sensor(id, "sample sensor"));
		return new Kit(id, a5kw, sl);
	}
	
	public Kit _10kw(int id)
	{
		ArrayList<Aktor> a10kw = new ArrayList<Aktor>();
		a10kw.add(new Aktor(id, "hoch", 10.));
		ArrayList<Sensor> sl = new ArrayList<Sensor>();
		sl.add(new Sensor(id, "sample sensor"));
		return new Kit(id, a10kw, sl);
	}
	
	public Kit _infkw(int id)
	{
		ArrayList<Aktor> ainfkw = new ArrayList<Aktor>();
		ainfkw.add(new Aktor(id, "unendlich", 5000.));
		ArrayList<Sensor> sl = new ArrayList<Sensor>();
		sl.add(new Sensor(id, "sample sensor"));
		return new Kit(id, ainfkw, sl);
	}
}

/**
 * Error test: change main Android Type
 * From					To
 * 
 * 
 * Valid test: change main Android Type
 * From					To
 * 
 * 
 * Error: Wrong Skin
 * Assistant	ArmoredSkin, SolidSkin
 * 
 * Valid: Right Skin
 * Assistant	TouchSensitive
 * 
 * 
 * Error: Wrong Security Level
 * Assistant	Level 3,4,5
 * 
 * 
 * Valid: Right Security Level
 * Associate	Level 1
 * Assistant	Level 1,2
 * 
 * 
 */
private static void test2()
{
	gKit x = new gKit();
	AndroidList al = new AndroidList();
	
	
	
	Android s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel1()));
	System.out.println(al.insert(s1) + "Vailid Assistant");
	
	s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel2()));
	System.out.println("Invalid SecLev2\t" + al.insert(s1));
	s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel3()));
	System.out.println("Invalid SecLev3\t" + al.insert(s1));
	s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel4()));
	System.out.println("Invalid SecLev4\t" + al.insert(s1));
	s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel5()));
	System.out.println("Invalid SecLev5\t" + al.insert(s1));
	
	s1 = new Assistant(1, x._5kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel1()));
	System.out.println("Invalid 5kW\t" + al.insert(s1));
	s1 = new Assistant(1, x._10kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel1()));
	System.out.println("Invalid 10kW\t" + al.insert(s1));
	s1 = new Assistant(1, x._infkw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel1()));
	System.out.println("Invalid infkW\t" + al.insert(s1));
	
	s1 = new Assistant(1, x._1kw(1), new ArmoredSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel1()));
	System.out.println("Invalid ArmoredSkin\t" + al.insert(s1));
	s1 = new Assistant(1, x._1kw(1), new SolidSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel1()));
	System.out.println("Invalid SolidSkin\t" + al.insert(s1));
	
	s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Associate.BaseSoftware(1, new SecurityLevel1()));
	System.out.println("Invalid ?\t" + al.insert(s1));
	s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Associate.BaseSoftware(1, new SecurityLevel2()));
	System.out.println("Invalid ?\t" + al.insert(s1));
	s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1), new Associate.BaseSoftware(1, new SecurityLevel2()));
	System.out.println("Invalid ?\t" + al.insert(s1));
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
	Iterator<Android> iti = al.history(id);
	while(iti.hasNext())
	{
		cnt++;
		System.out.println("Konfiguration Nr.:" + cnt);
		System.out.println(iti.next());
		System.out.println();
	}	
	System.out.println();
}


/*Die Leistung aller Aktoren eines Bedieners darf zusammen die Grenze von 1 kW nicht überschreiten.
 * Für Kämpfer ist die Leistung nicht begrenzt. Bei allen Androiden, die mit Software der Stufe 3 ausgestattet sind,
 * darf die Grenze von 5 kW nicht überschritten werden, bei Androiden mit Software der Stufe 4 die Grenze von 10 kW. */
private static void test3()
{
	System.out.print("\n\n\nTeste Aktoren zulaessige Leistung\n");
	
	gKit x = new gKit();
	AndroidList al = new AndroidList();
		
	Android s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel2()));
	System.out.println("Valid Assistant max 1kW " + al.insert(s1));
	
	s1 = new Assistant(1, x._5kw(1), new TouchSensitiveSkin(1), new Assistant.BaseSoftware(1, new SecurityLevel2()));
	System.out.println("Invalid Assistant 5kW " + al.insert(s1));
	
	Android s2 = new Associate(2, x._1kw(2), new TouchSensitiveSkin(2), new Associate.BaseSoftware(2, new SecurityLevel1()));
	System.out.println("Valid Associate max 1kW " + al.insert(s2));
	
	s2 = new Associate(2, x._5kw(2), new TouchSensitiveSkin(2), new Associate.BaseSoftware(2, new SecurityLevel1()));
	System.out.println("Invalid Associate 5kW " + al.insert(s2));
	
	Android w1 = new ServiceTechnician(3, x._1kw(3), new SolidSkin(3), new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
	System.out.println("Valid ServiceTechnician 1kW " + al.insert(w1));
	
	w1 = new ServiceTechnician(3, x._5kw(3), new SolidSkin(3), new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
	System.out.println("Valid ServiceTechnician max 5kW " + al.insert(w1));
	
	w1 = new ServiceTechnician(3, x._10kw(3), new SolidSkin(3), new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
	System.out.println("Invalid ServiceTechnician 10kW " + al.insert(w1));
	
	
	Android o1 = new ObjectGuard(4, x._5kw(4), new SolidSkin(4), new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
	System.out.println("Valid ObjectGuard 5kW " + al.insert(o1));
	
	o1 = new ObjectGuard(4, x._10kw(4), new SolidSkin(4), new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
	System.out.println("Valid ObjectGuard max 10kW " + al.insert(o1));
	
	o1 = new ObjectGuard(4, x._infkw(4), new SolidSkin(4), new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
	System.out.println("Invalid ObjectGuard 5000kW " + al.insert(o1));
	
	Android f1 = new Fighter(5, x._5kw(5), new SolidSkin(5), new Fighter.BaseSoftware(5, new SecurityLevel5()));
	System.out.println("Valid Fighter 5kW " + al.insert(f1));
	
	f1 = new Fighter(5, x._infkw(5), new SolidSkin(5), new Fighter.BaseSoftware(5, new SecurityLevel5()));
	System.out.println("Valid Fighter 5000kW " + al.insert(f1));
	
}

}
