import java.util.*;

public class Test {
	public static void main(String[] args) {

		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
	}

/**
 * Testet die Funktionalitaet von AndroidList.
 */
private static void test1()
{
	AndroidList list = new AndroidList();
	Iterator<Android> iter;
	Android android12;
	ArrayList<Aktor> aktoren12 = new ArrayList<Aktor>();
	ArrayList<Sensor> sensoren12 = new ArrayList<Sensor>();
	Android android22;
	ArrayList<Aktor> aktoren22 = new ArrayList<Aktor>();
	ArrayList<Sensor> sensoren22 = new ArrayList<Sensor>();

	//Erstelle neuen Gesellschafter
	aktoren12.add(new Aktor(12, "Putzen", 0.5));
	sensoren12.add(new Sensor(12, "Staub"));
	android12 = new Associate(12, new Kit(aktoren12, sensoren12), new TouchSensitiveSkin(12), new Associate.BaseSoftware(12, new SecurityLevel1()));
	System.out.println("Erstelle neuen Gesellschafter: " + list.insert(android12));
	
	//Erstelle neuen Kaempfer
	aktoren22.add(new Aktor(22, "Augen ausstechen", 1.));
	aktoren22.add(new Aktor(22, "Explodieren", 50.));
	aktoren22.add(new Aktor(22, "Giftgasabsorber", 5.));
	sensoren22.add(new Sensor(22, "Gas-Sensor"));
	sensoren22.add(new Sensor(22, "Notfallassistenz"));
	android22 = new Fighter(22, new Kit(aktoren22, sensoren22), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel5()));
	System.out.println("Erstelle neuen Kaempfer: " + list.insert(android22));

	//Ausgabe aller Androiden in Einfuegereihenfolge
	System.out.println();
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("Ausgelieferter Android Nr.: ", list);

	
	//Ueberschreibe Android 12
	aktoren12.add(new Aktor(12, "Waschen", 0.5));
	android12 = new Assistant(12, new Kit(aktoren12, sensoren12), new TouchSensitiveSkin(12) , new Assistant.BaseSoftware(12, new SecurityLevel1()));
	System.out.println("Aendere den Gesellschafter: " + list.insert(android12));
	
	//Keine Ueberschreibung von Android 22, da dieser ungueltig ist
	android22 = new Fighter(22, new Kit(aktoren22, sensoren22), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel2()));
	System.out.println("Aendere Sicherheitslevel des Kaempfers (ungueltige Aenderung): "+list.insert(android22));

	//Ausgabe aller Androiden in Einfuegereihenfolge
	System.out.println();
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("Ausgelieferter Android Nr.: ", list);
	
	
	//Aendere die Hilfskraft abermals
	android12 = new Associate(12, new Kit(aktoren12, sensoren12), new TouchSensitiveSkin(12) , new Associate.BaseSoftware(12, new SecurityLevel1()));
	System.out.println("Aendere die Hilfskraft: " + list.insert(android12));

	//Ausgabe aller Androiden in Einfuegereihenfolge
	System.out.println();
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("Ausgelieferter Android Nr.: ", list);
	
	
	//Zeige den Aenderungsverlauf von Android 12
	System.out.println("Zeige den Aenderungsverlauf von Android 12");
	iter = list.history(12);
	for(int i = 0; iter.hasNext(); i++) {
		System.out.println("Nummer "+i);
		System.out.println(iter.next());
		System.out.println();
	}
	
	
	//Gib Android 12 und 22 ueber find aus
	System.out.println("Ausgabe der Androiden mit find:");
	System.out.println("Android 12");
	System.out.println(list.find(12));
	System.out.println();
	System.out.println("Android 22");
	System.out.println(list.find(22));
	System.out.println();

//		AndroidList al = new AndroidList();
//
//		ArrayList<Aktor> ak = new ArrayList<Aktor>();
//		ak.add(new Aktor(12, "Putzen", 0.5));
//		ArrayList<Sensor> as = new ArrayList<Sensor>();
//		as.add(new Sensor(12, "Staub"));
//
//		Android s201 = new Associate(12, new Kit(ak, as),
//				new TouchSensitiveSkin(12), new Associate.BaseSoftware(12,
//						new SecurityLevel1()));
//		System.out.println("Valid Associate" + al.insert(s201));
//		System.out.println(al.insert(s201) + "\tcreate new Associate Android");
//
//		System.out.println();
//		System.out.println("Zeige bisher ausgelieferte Androiden");
//		showAndroids("Ausgelieferter Android Nr.: ", al);
//		System.out.println();
//
//		// same Android will be edited and gets Waschen Aktor
//		ak.add(new Aktor(12, "Waschen", 0.5));
//
//		Android s202 = new Assistant(12, new Kit(ak, as),
//				new TouchSensitiveSkin(12), new Assistant.BaseSoftware(12,
//						new SecurityLevel1()));
//		System.out.println("Associate becomes Assistant" + al.insert(s202));
//		System.out.println(al.insert(s202)
//				+ "\tAndroid will be edited and gets Waschen Aktor");
//
//		s202 = new Assistant(12, new Kit(ak, as), new TouchSensitiveSkin(12),
//				new Assistant.BaseSoftware(12, new SecurityLevel2()));
//		System.out.println("Invalid Security Level must not change"
//				+ al.insert(s202));
//
//		s202 = new Assistant(12, new Kit(ak, as), new TouchSensitiveSkin(12),
//				new Assistant.BaseSoftware(12, new SecurityLevel1()));
//		System.out.println(al.insert(s202)
//				+ "\tAndroid will be edited and gets SecLev1");
//
//		// next Android should be invalid (SecLev5 not allowed)
//		Android s210 = new Assistant(21, new Kit(ak, as),
//				new TouchSensitiveSkin(21), new Associate.BaseSoftware(21,
//						new SecurityLevel5()));
//		System.out
//				.println(al.insert(s210) + "\tAssistant may not have SecLev5");
//
//		s210 = new Assistant(21, new Kit(ak, as), new TouchSensitiveSkin(21),
//				new Associate.BaseSoftware(21, new SecurityLevel4()));
//		System.out
//				.println(al.insert(s210) + "\tAssistant may not have SecLev4");
//
//		s210 = new Assistant(21, new Kit(ak, as), new TouchSensitiveSkin(21),
//				new Associate.BaseSoftware(21, new SecurityLevel3()));
//		System.out
//				.println(al.insert(s210) + "\tAssistant may not have SecLev3");
//
//		s210 = new Assistant(21, new Kit(ak, as), new TouchSensitiveSkin(21),
//				new Associate.BaseSoftware(21, new SecurityLevel2()));
//		System.out
//				.println(al.insert(s210) + "\tAssistant may not have SecLev2");
//
//		s210 = new Assistant(21, new Kit(ak, as), new TouchSensitiveSkin(21),
//				new Assistant.BaseSoftware(21, new SecurityLevel2()));
//		System.out.println(al.insert(s210)
//				+ "\twill be edited and gets SecLev1");
//
//		s210 = new Assistant(21, new Kit(ak, as), new ArmoredSkin(21),
//				new Associate.BaseSoftware(21, new SecurityLevel5()));
//		System.out.println(al.insert(s210)
//				+ "\tAssistant may not have Armored Skin");
//
//		s210 = new Assistant(21, new Kit(ak, as), new TouchSensitiveSkin(21),
//				new Assistant.BaseSoftware(21, new SecurityLevel2()));
//		System.out.println(al.insert(s210) + "\tnew Assistant");
//
//		// next Android should be invalid, Android who was Servant may not
//		// become a Fighter
//		s210 = new Fighter(21, new Kit(ak, as), new ArmoredSkin(21),
//				new Fighter.BaseSoftware(21, new SecurityLevel5()));
//		System.out.println(al.insert(s210)
//				+ "\tAndroid who was Servant may not become a Fighter");
//
//		// create new Fighter Android
//		ak = new ArrayList<Aktor>();
//		ak.add(new Aktor(22, "Augen ausstechen", 1.));
//		ak.add(new Aktor(22, "Explodieren", 50.));
//		ak.add(new Aktor(22, "Giftgasabsorber", 5.));
//		as = new ArrayList<Sensor>();
//		as.add(new Sensor(22, "Gas-Sensor"));
//		as.add(new Sensor(22, "Notfallassistenz"));
//		Android s220 = new Fighter(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Fighter.BaseSoftware(22, new SecurityLevel5()));
//		System.out.println(al.insert(s220) + "\tcreate new Fighter Android");
//
//		s220 = new Fighter(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Fighter.BaseSoftware(22, new SecurityLevel4()));
//		System.out.println(al.insert(s220) + "\tFighter may not have SecLev4");
//
//		s220 = new Fighter(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Fighter.BaseSoftware(22, new SecurityLevel3()));
//		System.out.println(al.insert(s220) + "\tFighter may not have SecLev3");
//
//		s220 = new Fighter(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Fighter.BaseSoftware(22, new SecurityLevel2()));
//		System.out.println(al.insert(s220) + "\tFighter may not have SecLev2");
//
//		s220 = new Fighter(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Fighter.BaseSoftware(22, new SecurityLevel1()));
//		System.out.println(al.insert(s220) + "\tFighter may not have SecLev1");
//
//		// Fighter may become Bodyguard
//		ak = new ArrayList<Aktor>();
//		ak.add(new Aktor(22, "Augen ausstechen", 1.));
//		ak.add(new Aktor(22, "Panzerkorb", 1.));
//		s220 = new Bodyguard(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Bodyguard.BaseSoftware(22, new SecurityLevel4()));
//		System.out.println(al.insert(s220) + "\tFighter may become Bodyguard");
//
//		ak = new ArrayList<Aktor>();
//		ak.add(new Aktor(22, "Augen ausstechen", 1.));
//		ak.add(new Aktor(22, "Explodieren", 50.));
//		ak.add(new Aktor(22, "Giftgasabsorber", 5.));
//		s220 = new Bodyguard(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Bodyguard.BaseSoftware(22, new SecurityLevel4()));
//		System.out.println(al.insert(s220)
//				+ "\tBodyguard may not have 56kW Aktors");
//
//		s220 = new Bodyguard(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Bodyguard.BaseSoftware(22, new SecurityLevel2()));
//		System.out.println(al.insert(s220)
//				+ "\tBodyguard may not have SecLev 2");
//
//		s220 = new Bodyguard(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Bodyguard.BaseSoftware(22, new SecurityLevel3()));
//		System.out.println(al.insert(s220)
//				+ "\tBodyguard may not have SecLev 3");
//
//		s220 = new Bodyguard(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Bodyguard.BaseSoftware(22, new SecurityLevel5()));
//		System.out.println(al.insert(s220)
//				+ "\tBodyguard may not have SecLev 5");
//
//		s220 = new Bodyguard(22, new Kit(ak, as), new ArmoredSkin(22),
//				new Bodyguard.BaseSoftware(22, new SecurityLevel1()));
//		System.out.println(al.insert(s220)
//				+ "\tBodyguard may not have SecLev 1");
//
//		System.out.println();
//		System.out.println("Zeige bisher ausgelieferte Androiden");
//		showAndroids("Ausgelieferter Android Nr.: ", al);
//
//		// Show Curriculum Vitae of Android with ID 12
//		System.out.println();
//		System.out
//				.println("Zeige bisherige Konfigurationen des Androiden mit ID 12");
//		System.out.println("Gesellschafter -> Hilfskraft mit Waschfunktion :O");
//		showLog(12, al);
//
//		// Show Curriculum Vitae of Android with ID 22
//		System.out.println();
//		System.out
//				.println("Zeige bisherige Konfigurationen des Androiden mit ID 22");
//		System.out.println("Kaempfer -> Beschuetzer");
//		showLog(22, al);
	}

	/** returns Kits of 1kW, 5kW, 10kW, 5000kW with given id */
	public static class gKit {

		public Kit _1kw(int id) {
			ArrayList<Aktor> a1kw = new ArrayList<Aktor>();
			a1kw.add(new Aktor(id, "minimal", 1.));
			ArrayList<Sensor> sl = new ArrayList<Sensor>();
			sl.add(new Sensor(id, "sample sensor"));
			return new Kit(a1kw, sl);
		}

		public Kit _5kw(int id) {
			ArrayList<Aktor> a5kw = new ArrayList<Aktor>();
			a5kw.add(new Aktor(id, "mittel", 5.));
			ArrayList<Sensor> sl = new ArrayList<Sensor>();
			sl.add(new Sensor(id, "sample sensor"));
			return new Kit(a5kw, sl);
		}

		public Kit _10kw(int id) {
			ArrayList<Aktor> a10kw = new ArrayList<Aktor>();
			a10kw.add(new Aktor(id, "hoch", 10.));
			ArrayList<Sensor> sl = new ArrayList<Sensor>();
			sl.add(new Sensor(id, "sample sensor"));

			return new Kit(a10kw, sl);
		}

		public Kit _infkw(int id) {
			ArrayList<Aktor> ainfkw = new ArrayList<Aktor>();
			ainfkw.add(new Aktor(id, "unendlich", 5000.));
			ArrayList<Sensor> sl = new ArrayList<Sensor>();
			sl.add(new Sensor(id, "sample sensor"));
			return new Kit(ainfkw, sl);
		}
	}

	/**
	 * Error test: change main Android Type From To
	 * 
	 * 
	 * Valid test: change main Android Type From To
	 * 
	 * 
	 * Error: Wrong Skin Assistant ArmoredSkin, SolidSkin
	 * 
	 * Valid: Right Skin Assistant TouchSensitive
	 * 
	 * 
	 * Error: Wrong Security Level Assistant Level 3,4,5
	 * 
	 * 
	 * Valid: Right Security Level Associate Level 1 Assistant Level 1,2
	 * 
	 * 
	 */
	private static void test2() {
		gKit x = new gKit();
		AndroidList al = new AndroidList();

		Android s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println(al.insert(s1) + "Vailid Assistant");

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid SecLev2\t" + al.insert(s1));
		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid SecLev3\t" + al.insert(s1));
		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid SecLev4\t" + al.insert(s1));
		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid SecLev5\t" + al.insert(s1));

		s1 = new Assistant(1, x._5kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid 5kW\t" + al.insert(s1));
		s1 = new Assistant(1, x._10kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid 10kW\t" + al.insert(s1));
		s1 = new Assistant(1, x._infkw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid infkW\t" + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new ArmoredSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid ArmoredSkin\t" + al.insert(s1));
		s1 = new Assistant(1, x._1kw(1), new SolidSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid SolidSkin\t" + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid ?\t" + al.insert(s1));
		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid ?\t" + al.insert(s1));
		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid ?\t" + al.insert(s1));
	}

	/**
	 * Jeder Androide muss mit einer beruehrungssensitiven, hochfesten oder
	 * gepanzerten Skin ausgestattet sein. Bediener benötigen unbedingt eine
	 * berührungssensitive Skin, und nur Beschützer dürfen eine gepanzerte Skin
	 * haben.
	 * */
	private static void test4() {

		gKit x = new gKit();
		AndroidList al = new AndroidList();

		// Associate
		Android s1 = new Associate(1234, x._1kw(1234), new TouchSensitiveSkin(
				1234), new Associate.BaseSoftware(1234, new SecurityLevel1()));
		System.out.println("Valid Associate\t\t\t" + al.insert(s1));
		s1 = new Associate(1234, x._1kw(1234), new SolidSkin(1234),
				new Associate.BaseSoftware(1234, new SecurityLevel1()));
		System.out.println("Invalid Associate\t\t" + al.insert(s1));
		s1 = new Associate(1234, x._1kw(1234), new ArmoredSkin(1234),
				new Associate.BaseSoftware(1234, new SecurityLevel1()));
		System.out.println("Invalid Associate\t\t" + al.insert(s1));

		// Assistant
		Android s2 = new Assistant(1235, x._1kw(1235), new TouchSensitiveSkin(
				1235), new Assistant.BaseSoftware(1235, new SecurityLevel2()));
		System.out.println("Valid Assistant\t\t\t" + al.insert(s2));
		s2 = new Assistant(1235, x._1kw(1235), new SolidSkin(1235),
				new Assistant.BaseSoftware(1235, new SecurityLevel2()));
		System.out.println("Valid Assistant\t\t\t" + al.insert(s2));
		s2 = new Assistant(1235, x._1kw(1235), new ArmoredSkin(1235),
				new Assistant.BaseSoftware(1235, new SecurityLevel2()));
		System.out.println("Invalid Assistant\t\t\t" + al.insert(s2));

		// BuildingWorker
		Android s3 = new BuildingWorker(1236, x._5kw(1236),
				new SolidSkin(1236), new BuildingWorker.BaseSoftware(1236,
						new SecurityLevel3()));
		System.out.println("Valid BuildingWorker\t\t" + al.insert(s3));
		s3 = new BuildingWorker(1236, x._5kw(1236),
				new TouchSensitiveSkin(1236), new BuildingWorker.BaseSoftware(
						1236, new SecurityLevel3()));
		System.out.println("Valid BuildingWorker\t\t" + al.insert(s3));
		s3 = new BuildingWorker(1236, x._5kw(1236), new ArmoredSkin(1236),
				new BuildingWorker.BaseSoftware(1236, new SecurityLevel3()));
		System.out.println("Invalid BuildingWorker\t\t" + al.insert(s3));

		// ServiceTechnician
		Android s4 = new ServiceTechnician(1237, x._5kw(1237),
				new TouchSensitiveSkin(1237),
				new ServiceTechnician.BaseSoftware(1237, new SecurityLevel3()));
		System.out.println("Valid ServiceTechnician\t\t" + al.insert(s4));
		s4 = new ServiceTechnician(1237, x._5kw(1237), new SolidSkin(1237),
				new ServiceTechnician.BaseSoftware(1237, new SecurityLevel3()));
		System.out.println("Valid ServiceTechnician\t" + al.insert(s4));
		s4 = new ServiceTechnician(1237, x._5kw(1237), new ArmoredSkin(1237),
				new ServiceTechnician.BaseSoftware(1237, new SecurityLevel3()));
		System.out.println("Invalid ServiceTechnician\t" + al.insert(s4));

		// Fighter
		Android s5 = new Fighter(666, x._infkw(666), new ArmoredSkin(666),
				new Fighter.BaseSoftware(666, new SecurityLevel5()));
		System.out.println("Valid Fighter\t\t\t" + al.insert(s5));
		s5 = new Fighter(666, x._infkw(666), new TouchSensitiveSkin(666),
				new Fighter.BaseSoftware(666, new SecurityLevel5()));
		System.out.println("Valid Fighter\t\t\t" + al.insert(s5));
		s5 = new Fighter(666, x._infkw(666), new SolidSkin(666),
				new Fighter.BaseSoftware(666, new SecurityLevel5()));
		System.out.println("Valid Fighter\t\t\t" + al.insert(s5));

		// Bodyguard
		Android s6 = new Bodyguard(111, x._10kw(111), new ArmoredSkin(111),
				new Bodyguard.BaseSoftware(111, new SecurityLevel4()));
		System.out.println("Valid Bodyguard\t\t\t" + al.insert(s6));
		s6 = new Bodyguard(111, x._10kw(111), new SolidSkin(111),
				new Bodyguard.BaseSoftware(111, new SecurityLevel4()));
		System.out.println("Valid Bodyguard\t\t" + al.insert(s6));
		s6 = new Bodyguard(111, x._10kw(111), new TouchSensitiveSkin(111),
				new Bodyguard.BaseSoftware(111, new SecurityLevel4()));
		System.out.println("Valid Bodyguard\t\t" + al.insert(s6));

	}

	private static void showAndroids(String text, AndroidList al) {
		int cnt = 0;
		Iterator<Android> iti = al.iterator();
		while (iti.hasNext()) {
			cnt++;
			System.out.println(text + cnt);
			System.out.println(iti.next());
			System.out.println();
		}
		System.out.println();
	}

	private static void showLog(int id, AndroidList al) {
		int cnt = 0;
		Iterator<Android> iti = al.history(id);
		while (iti.hasNext()) {
			cnt++;
			System.out.println("Konfiguration Nr.:" + cnt);
			System.out.println(iti.next());
			System.out.println();
		}
		System.out.println();
	}

	/*
	 * Die Leistung aller Aktoren eines Bedieners darf zusammen die Grenze von 1
	 * kW nicht überschreiten. Für Kämpfer ist die Leistung nicht begrenzt. Bei
	 * allen Androiden, die mit Software der Stufe 3 ausgestattet sind, darf die
	 * Grenze von 5 kW nicht überschritten werden, bei Androiden mit Software
	 * der Stufe 4 die Grenze von 10 kW.
	 */
	private static void test3() {
		System.out.print("\n\n\nTeste Aktoren zulaessige Leistung\n");

		gKit x = new gKit();
		AndroidList al = new AndroidList();

		Android s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Valid Assistant max 1kW " + al.insert(s1));

		s1 = new Assistant(1, x._5kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Assistant 5kW " + al.insert(s1));

		Android s2 = new Associate(2, x._1kw(2), new TouchSensitiveSkin(2),
				new Associate.BaseSoftware(2, new SecurityLevel1()));
		System.out.println("Valid Associate max 1kW " + al.insert(s2));

		s2 = new Associate(2, x._5kw(2), new TouchSensitiveSkin(2),
				new Associate.BaseSoftware(2, new SecurityLevel1()));
		System.out.println("Invalid Associate 5kW " + al.insert(s2));

		Android w1 = new ServiceTechnician(3, x._1kw(3), new SolidSkin(3),
				new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
		System.out.println("Valid ServiceTechnician 1kW " + al.insert(w1));

		w1 = new ServiceTechnician(3, x._5kw(3), new SolidSkin(3),
				new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
		System.out.println("Valid ServiceTechnician max 5kW " + al.insert(w1));

		w1 = new ServiceTechnician(3, x._10kw(3), new SolidSkin(3),
				new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
		System.out.println("Invalid ServiceTechnician 10kW " + al.insert(w1));

		Android o1 = new ObjectGuard(4, x._5kw(4), new SolidSkin(4),
				new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
		System.out.println("Valid ObjectGuard 5kW " + al.insert(o1));

		o1 = new ObjectGuard(4, x._10kw(4), new SolidSkin(4),
				new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
		System.out.println("Valid ObjectGuard max 10kW " + al.insert(o1));

		o1 = new ObjectGuard(4, x._infkw(4), new SolidSkin(4),
				new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
		System.out.println("Invalid ObjectGuard 5000kW " + al.insert(o1));

		Android f1 = new Fighter(5, x._5kw(5), new SolidSkin(5),
				new Fighter.BaseSoftware(5, new SecurityLevel5()));
		System.out.println("Valid Fighter 5kW " + al.insert(f1));

		f1 = new Fighter(5, x._infkw(5), new SolidSkin(5),
				new Fighter.BaseSoftware(5, new SecurityLevel5()));
		System.out.println("Valid Fighter 5000kW " + al.insert(f1));

	}

	/**
	 * Die Software muss dem Einsatzgebiet des Androiden entsprechen. Analog zu
	 * den Androide-Typen gibt es Hilfskraft-Software, Gesellschafter-Software,
	 * Bauarbeiter-Software und so weiter.
	 * */
	private static void test5() {
		System.out.print("\n\n\nTeste unzulaessige Software\n");

		gKit x = new gKit();
		AndroidList al = new AndroidList();

		// Assistant
		Android s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		s1 = new Assistant(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Invalid Software for Assistant " + al.insert(s1));

		// Associate
		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		s1 = new Associate(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Invalid Software for Associate " + al.insert(s1));

		// BodyGuard
		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		s1 = new Bodyguard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for BodyGuard " + al.insert(s1));

		// Fighter
		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		s1 = new Fighter(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Invalid Software for Fighter " + al.insert(s1));

		// ObjectGuard
		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		s1 = new ObjectGuard(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for ObjectGuard " + al.insert(s1));

		// ServiceTechnician
		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for ServiceTechnician "
				+ al.insert(s1));

		// TransportWorker
		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		s1 = new TransportWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Invalid Software for TransportWorker "
				+ al.insert(s1));

		// BuildingWorker
		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));

		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));

		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));

		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));

		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));

		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));

		s1 = new BuildingWorker(1, x._1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("Invalid Software for BuildingWorker "
				+ al.insert(s1));
	}

	/*
	 * Die Software muss entsprechend der Sicherheitsstufen 1 bis 5 zertifiziert
	 * sein. Gesellschafter benötigen Software der Stufe 1, alle anderen
	 * Bediener Software der Stufen 1 oder 2. Schwerarbeiter können mit Software
	 * der Stufen 3 und 4 ausgestattet sein. Kämpfer müssen Software der Stufe 5
	 * haben, alle anderen Beschützer Software der Stufe 4.
	 */
	private static void test6() {
		// Test Security Levels, if cnt is a comment this means it is tested to
		// change an androids SecLev which must be invalid

		AndroidList al = new AndroidList();

		gKit x = new gKit();

		int cnt = 0;

		// Associate
		cnt++;
		Android s201 = new Associate(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new Associate.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Valid Associate" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Invalid Associate" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Invalid Associate" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Invalid Associate" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Invalid Associate" + al.insert(s201));

		System.out.println("\n\n");

		// Assistant
		cnt++;
		s201 = new Assistant(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Valid Assistant" + al.insert(s201));

		// cnt++;
		s201 = new Assistant(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Invalid Assistant" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Valid Assistant" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Invalid Assistant" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Invalid Assistant" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Invalid Assistant" + al.insert(s201));

		System.out.println("\n\n");

		// TransportWorker
		cnt++;
		s201 = new TransportWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel1()));
		System.out.println("Invalid TransportWorker" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel2()));
		System.out.println("Invalid TransportWorker" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel3()));
		System.out.println("Valid TransportWorker" + al.insert(s201));

		// cnt++;
		s201 = new TransportWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel4()));
		System.out.println("Invalid TransportWorker" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel4()));
		System.out.println("Valid TransportWorker" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel5()));
		System.out.println("Invalid TransportWorker" + al.insert(s201));

		System.out.println("\n\n");

		// BuildingWorker
		cnt++;
		s201 = new BuildingWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel1()));
		System.out.println("Invalid BuildingWorker" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel2()));
		System.out.println("Invalid BuildingWorker" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel3()));
		System.out.println("Valid BuildingWorker" + al.insert(s201));

		// cnt++;
		s201 = new BuildingWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel4()));
		System.out.println("Invalid BuildingWorker" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel4()));
		System.out.println("Valid BuildingWorker" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, x._1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel5()));
		System.out.println("Invalid BuildingWorker" + al.insert(s201));

		System.out.println("\n\n");

		// ServiceTechnician
		cnt++;
		s201 = new ServiceTechnician(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel1()));
		System.out.println("Invalid ServiceTecnician" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel2()));
		System.out.println("Invalid ServiceTecnician" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel3()));
		System.out.println("Valid ServiceTecnician" + al.insert(s201));

		// cnt++;
		s201 = new ServiceTechnician(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel4()));
		System.out.println("Invalid ServiceTecnician" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel4()));
		System.out.println("Valid ServiceTecnician" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, x._1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel5()));
		System.out.println("Invalid ServiceTecnician" + al.insert(s201));

		System.out.println("\n\n");

		// ObjectGuard
		cnt++;
		s201 = new ObjectGuard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Invalid ObjectGuard" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Invalid ObjectGuard" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Invalid ObjectGuard" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Valid ObjectGuard" + al.insert(s201));

		// cnt++;
		s201 = new ObjectGuard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Invalid ObjectGuard" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Invalid ObjectGuard" + al.insert(s201));

		System.out.println("\n\n");

		// Bodyguard
		cnt++;
		s201 = new Bodyguard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Invalid Bodyguard" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Invalid Bodyguard" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Invalid Bodyguard" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Valid Bodyguard" + al.insert(s201));

		// cnt++;
		s201 = new Bodyguard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Invalid Bodyguard" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Invalid Bodyguard" + al.insert(s201));

		System.out.println("\n\n");

		// Fighter
		cnt++;
		s201 = new Fighter(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Invalid Fighter" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Invalid Fighter" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Invalid Fighter" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Invalid Fighter" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, x._1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Valid Fighter" + al.insert(s201));

		System.out.println("\n\n");
	}

}
