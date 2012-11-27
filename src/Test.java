import java.util.*;

public class Test {
	public static void main(String[] args) {
		testAndroidList();
		testUpdate();
		testPowerClass();
		testSkin();
		testSoftware();
		testSecurityLevel();
		testSerialNumber();
	}

/**
 * Testet die Funktionalitaet von AndroidList.
 */
private static void testAndroidList()
{
	AndroidList list = new AndroidList();
	Android android12;
	ArrayList<Aktor> aktoren12 = new ArrayList<Aktor>();
	ArrayList<Sensor> sensoren12 = new ArrayList<Sensor>();
	Android android22;
	ArrayList<Aktor> aktoren22 = new ArrayList<Aktor>();
	ArrayList<Sensor> sensoren22 = new ArrayList<Sensor>();

	System.out.println("\n\nTeste die Klasse AndroidList\n");

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
	System.out.println();

	//Ausgabe aller Androiden in Einfuegereihenfolge
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("- Ausgelieferter Android Nr.: ", list.iterator());

	
	//Ueberschreibe Android 12
	aktoren12.add(new Aktor(12, "Waschen", 0.5));
	android12 = new Assistant(12, new Kit(aktoren12, sensoren12), new TouchSensitiveSkin(12) , new Assistant.BaseSoftware(12, new SecurityLevel1()));
	System.out.println("Aendere den Gesellschafter: " + list.insert(android12));
	
	//Keine Ueberschreibung von Android 22, da dieser ungueltig ist
	android22 = new Fighter(22, new Kit(aktoren22, sensoren22), new ArmoredSkin(22), new Fighter.BaseSoftware(22, new SecurityLevel2()));
	System.out.println("Aendere Sicherheitslevel des Kaempfers (ungueltige Aenderung): "+list.insert(android22));
	System.out.println();

	//Ausgabe aller Androiden in Einfuegereihenfolge
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("- Ausgelieferter Android Nr.: ", list.iterator());
	
	
	//Aendere die Hilfskraft abermals
	android12 = new Associate(12, new Kit(aktoren12, sensoren12), new TouchSensitiveSkin(12) , new Associate.BaseSoftware(12, new SecurityLevel1()));
	System.out.println("Aendere die Hilfskraft: " + list.insert(android12));
	System.out.println();

	//Ausgabe aller Androiden in Einfuegereihenfolge
	System.out.println("Zeige bisher ausgelieferte Androiden");
	showAndroids("- Ausgelieferter Android Nr.: ", list.iterator());
	
	
	//Zeige den Aenderungsverlauf von Android 12
	System.out.println("Zeige den Aenderungsverlauf von Android 12");
	showAndroids("- Konfiguration Nr.:", list.history(12));
	
	
	//Gib Android 12 und 22 ueber find aus
	System.out.println("Ausgabe der Androiden mit find:");
	System.out.println(" - Android 12");
	System.out.println(list.find(12));
	System.out.println();
	System.out.println(" - Android 22");
	System.out.println(list.find(22));

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

	/**
	 * Testet die Vorraussetzungen die bei einer Aenderung eines Androiden erfuellt sein muessen.
	 * 
	 * Nachtraegliche aenderungen der Androiden sind nur auf eingeschraenkte Weise erlaubt:
	 * Die Seriennummer, der Haupttyp (Bediener, Schwerarbeiter oder Beschuetzer)
	 * sowie die Sicherheitsstufe der Software duerfen nicht geaendert werden.
	 */
	private static void testUpdate() {
		System.out.println("\n\nTeste Einschraenkungen beim Aendern eines Androiden\n");
		
		AndroidList list = new AndroidList();
		Android associate1;
		Android assistant1;
		Android transportWorker2;
		Android buildingWorker2;
		Android bodyguard2;
		Android objectguard1;

		associate1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel1()));
		transportWorker2 = new TransportWorker(2, kit5kw(2), new SolidSkin(2),
				new TransportWorker.BaseSoftware(2, new SecurityLevel4()));
		
		list.insert(associate1);
		list.insert(transportWorker2);
		
		System.out.println("Anfangsbelegung: ");
		showAndroids("#", list.iterator());

		
		System.out.println("Aenderungsversuche mittels \"AndroidList.insert\":");
		
		//Anderer Haupttyp
		bodyguard2 = new Bodyguard(2, kit1kw(2), new SolidSkin(2),
				new Bodyguard.BaseSoftware(2, new SecurityLevel4()));
		System.out.println("Transportarbeiter (Level 4) -> Leibwaechter (Level 4): " + list.insert(bodyguard2));
		
		//Anderer Haupttyp, andere Sicherheitsstufe
		objectguard1 = new ObjectGuard(1, kit1kw(1), new SolidSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Gesellschafter (Level 1) -> Objektbewacher (Level 4): " + list.insert(objectguard1));
		
		//Andere Sicherheitsstufe
		assistant1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Gesellschafter (Level 1) -> Hilfskraft (Level 2): " + list.insert(assistant1));

		System.out.println("\nBelegung nach ungueltigen Operationen unveraendert: ");
		showAndroids("#", list.iterator());
		
		//Gueltige Aenderung
		assistant1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Gesellschafter (Level 1) -> Hilfskraft (Level 1): " + list.insert(assistant1));

		buildingWorker2 = new BuildingWorker(2, kit5kw(2), new TouchSensitiveSkin(2),
				new BuildingWorker.BaseSoftware(2, new SecurityLevel4()));
		System.out.println("Transportarbeiter (Level 4) -> Bauarbeiter (Level 4): " + list.insert(buildingWorker2));

		System.out.println("\nBelegung nach gueltigen Operationen: ");
		showAndroids("#", list.iterator());
		
		
		System.out.println("\nUeberpruefe Aenderbarkeit der Seriennummer mittels \"Android.validate(Android other)\":");
		
		//Aendere Seriennummer (nicht ueber insert moeglich)
		System.out.println("Objektbewacher #1 (Level 4) -> Leibwaechter #2 (Level 4): " + objectguard1.validate(bodyguard2));
		System.out.println("Leibwaechter #2 (Level 4) -> Hilfskraft #1 (Level 2): " + bodyguard2.validate(assistant1));
		
		
		
//		AndroidList al = new AndroidList();
//
//		Android s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println(al.insert(s1) + "Vailid Assistant");
//
//		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel2()));
//		System.out.println("Invalid SecLev2\t" + al.insert(s1));
//		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel3()));
//		System.out.println("Invalid SecLev3\t" + al.insert(s1));
//		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel4()));
//		System.out.println("Invalid SecLev4\t" + al.insert(s1));
//		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel5()));
//		System.out.println("Invalid SecLev5\t" + al.insert(s1));
//
//		s1 = new Assistant(1, kit5kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println("Invalid 5kW\t" + al.insert(s1));
//		s1 = new Assistant(1, kit10kw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println("Invalid 10kW\t" + al.insert(s1));
//		s1 = new Assistant(1, kitinfkw(1), new TouchSensitiveSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println("Invalid infkW\t" + al.insert(s1));
//
//		s1 = new Assistant(1, kit1kw(1), new ArmoredSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println("Invalid ArmoredSkin\t" + al.insert(s1));
//		s1 = new Assistant(1, kit1kw(1), new SolidSkin(1),
//				new Assistant.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println("Invalid SolidSkin\t" + al.insert(s1));
//
//		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Associate.BaseSoftware(1, new SecurityLevel1()));
//		System.out.println("Invalid ?\t" + al.insert(s1));
//		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Associate.BaseSoftware(1, new SecurityLevel2()));
//		System.out.println("Invalid ?\t" + al.insert(s1));
//		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
//				new Associate.BaseSoftware(1, new SecurityLevel2()));
//		System.out.println("Invalid ?\t" + al.insert(s1));
	}

	/*
	 * Die Leistung aller Aktoren eines Bedieners darf zusammen die Grenze von 1
	 * kW nicht ueberschreiten. Fuer Kaempfer ist die Leistung nicht begrenzt. Bei
	 * allen Androiden, die mit Software der Stufe 3 ausgestattet sind, darf die
	 * Grenze von 5 kW nicht ueberschritten werden, bei Androiden mit Software
	 * der Stufe 4 die Grenze von 10 kW.
	 */
	private static void testPowerClass() {
		System.out.println("\n\nTeste Leistungsklassen\n");

		AndroidList al = new AndroidList();

		Android s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (1kW // SecurityLevel2)\t" + al.insert(s1));

		s1 = new Assistant(1, kit5kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (5kW // SecurityLevel2)\t" + al.insert(s1));

		Android s2 = new Associate(2, kit1kw(2), new TouchSensitiveSkin(2),
				new Associate.BaseSoftware(2, new SecurityLevel1()));
		System.out.println("Associate (1kW // SecurityLevel 1)\t" + al.insert(s2));

		s2 = new Associate(2, kit5kw(2), new TouchSensitiveSkin(2),
				new Associate.BaseSoftware(2, new SecurityLevel1()));
		System.out.println("Associate (5kW // SecurityLevel 1)\t" + al.insert(s2));

		Android w1 = new ServiceTechnician(3, kit1kw(3), new SolidSkin(3),
				new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
		System.out.println("ServiceTechnician (1kW // SecurityLevel 3)\t" + al.insert(w1));

		w1 = new ServiceTechnician(3, kit5kw(3), new SolidSkin(3),
				new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
		System.out.println("ServiceTechnician (5kW // SecurityLevel 3)\t" + al.insert(w1));

		w1 = new ServiceTechnician(3, kit10kw(3), new SolidSkin(3),
				new ServiceTechnician.BaseSoftware(3, new SecurityLevel3()));
		System.out.println("ServiceTechnician (10kW // SecurityLevel 3)\t" + al.insert(w1));

		Android o1 = new ObjectGuard(4, kit5kw(4), new SolidSkin(4),
				new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
		System.out.println("ObjectGuard (5kW // SecurityLevel 4)\t" + al.insert(o1));

		o1 = new ObjectGuard(4, kit10kw(4), new SolidSkin(4),
				new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
		System.out.println("ObjectGuard (10kW // SecurityLevel 4)\t" + al.insert(o1));

		o1 = new ObjectGuard(4, kitinfkw(4), new SolidSkin(4),
				new ObjectGuard.BaseSoftware(4, new SecurityLevel4()));
		System.out.println("ObjectGuard (Infinity kW // SecurityLevel 4)\t" + al.insert(o1));

		Android f1 = new Fighter(5, kit5kw(5), new SolidSkin(5),
				new Fighter.BaseSoftware(5, new SecurityLevel5()));
		System.out.println("Fighter (5kW // SecurityLevel 5)\t" + al.insert(f1));

		f1 = new Fighter(5, kitinfkw(5), new SolidSkin(5),
				new Fighter.BaseSoftware(5, new SecurityLevel5()));
		System.out.println("Fighter (Infinity kW // SecurityLevel 5)\t" + al.insert(f1));

	}

	/**
	 * Jeder Androide muss mit einer beruehrungssensitiven, hochfesten oder
	 * gepanzerten Skin ausgestattet sein. Bediener benoetigen unbedingt eine
	 * beruehrungssensitive Skin, und nur Beschuetzer duerfen eine gepanzerte Skin
	 * haben.
	 * */
	private static void testSkin() {
		System.out.println("\n\nTeste Skins\n");

		AndroidList al = new AndroidList();

		// Associate
		Android s1 = new Associate(1234, kit1kw(1234), new TouchSensitiveSkin(
				1234), new Associate.BaseSoftware(1234, new SecurityLevel1()));
		System.out.println("Associate (TouchSensitiveSkin)\t" + al.insert(s1));
		s1 = new Associate(1234, kit1kw(1234), new SolidSkin(1234),
				new Associate.BaseSoftware(1234, new SecurityLevel1()));
		System.out.println("Associate (SolidSkin)\t" + al.insert(s1));
		s1 = new Associate(1234, kit1kw(1234), new ArmoredSkin(1234),
				new Associate.BaseSoftware(1234, new SecurityLevel1()));
		System.out.println("Associate (ArmoredSkin)\t" + al.insert(s1));

		// Assistant
		Android s2 = new Assistant(1235, kit1kw(1235), new TouchSensitiveSkin(
				1235), new Assistant.BaseSoftware(1235, new SecurityLevel2()));
		System.out.println("Assistant (TouchSensitiveSkin)\t" + al.insert(s2));
		s2 = new Assistant(1235, kit1kw(1235), new SolidSkin(1235),
				new Assistant.BaseSoftware(1235, new SecurityLevel2()));
		System.out.println("Assistant (SolidSkin)\t" + al.insert(s2));
		s2 = new Assistant(1235, kit1kw(1235), new ArmoredSkin(1235),
				new Assistant.BaseSoftware(1235, new SecurityLevel2()));
		System.out.println("Assistant (ArmoredSkin)\t" + al.insert(s2));

		// BuildingWorker
		Android s3 = new BuildingWorker(1236, kit5kw(1236),
				new SolidSkin(1236), new BuildingWorker.BaseSoftware(1236,
						new SecurityLevel3()));
		System.out.println("BuildingWorker (SolidSkin)\t" + al.insert(s3));
		s3 = new BuildingWorker(1236, kit5kw(1236),
				new TouchSensitiveSkin(1236), new BuildingWorker.BaseSoftware(
						1236, new SecurityLevel3()));
		System.out.println("BuildingWorker (TouchSensitiveSkin)\t" + al.insert(s3));
		s3 = new BuildingWorker(1236, kit5kw(1236), new ArmoredSkin(1236),
				new BuildingWorker.BaseSoftware(1236, new SecurityLevel3()));
		System.out.println("BuildingWorker (ArmoredSkin)\t" + al.insert(s3));

		// ServiceTechnician
		Android s4 = new ServiceTechnician(1237, kit5kw(1237),
				new TouchSensitiveSkin(1237),
				new ServiceTechnician.BaseSoftware(1237, new SecurityLevel3()));
		System.out.println("ServiceTechnician (TouchSensitiveSkin)\t" + al.insert(s4));
		s4 = new ServiceTechnician(1237, kit5kw(1237), new SolidSkin(1237),
				new ServiceTechnician.BaseSoftware(1237, new SecurityLevel3()));
		System.out.println("ServiceTechnician (SolidSkin)\t" + al.insert(s4));
		s4 = new ServiceTechnician(1237, kit5kw(1237), new ArmoredSkin(1237),
				new ServiceTechnician.BaseSoftware(1237, new SecurityLevel3()));
		System.out.println("ServiceTechnician (ArmoredSkin)\t" + al.insert(s4));

		// Fighter
		Android s5 = new Fighter(666, kitinfkw(666), new ArmoredSkin(666),
				new Fighter.BaseSoftware(666, new SecurityLevel5()));
		System.out.println("Fighter (ArmoredSkin)\t" + al.insert(s5));
		s5 = new Fighter(666, kitinfkw(666), new TouchSensitiveSkin(666),
				new Fighter.BaseSoftware(666, new SecurityLevel5()));
		System.out.println("Fighter (TouchSensitiveSkin)\t" + al.insert(s5));
		s5 = new Fighter(666, kitinfkw(666), new SolidSkin(666),
				new Fighter.BaseSoftware(666, new SecurityLevel5()));
		System.out.println("Fighter (SolidSkin)\t" + al.insert(s5));

		// Bodyguard
		Android s6 = new Bodyguard(111, kit10kw(111), new ArmoredSkin(111),
				new Bodyguard.BaseSoftware(111, new SecurityLevel4()));
		System.out.println("Bodyguard (ArmoredSkin)\t" + al.insert(s6));
		s6 = new Bodyguard(111, kit10kw(111), new SolidSkin(111),
				new Bodyguard.BaseSoftware(111, new SecurityLevel4()));
		System.out.println("Bodyguard (SolidSkin)\t" + al.insert(s6));
		s6 = new Bodyguard(111, kit10kw(111), new TouchSensitiveSkin(111),
				new Bodyguard.BaseSoftware(111, new SecurityLevel4()));
		System.out.println("Bodyguard (TouchSensitiveSkin)\t" + al.insert(s6));

	}
	
	/**
	 * Die Software muss dem Einsatzgebiet des Androiden entsprechen. Analog zu
	 * den Androide-Typen gibt es Hilfskraft-Software, Gesellschafter-Software,
	 * Bauarbeiter-Software und so weiter.
	 * */
	private static void testSoftware() {
		System.out.println("\n\nTeste Software\n");

		AndroidList al = new AndroidList();

		// Assistant
		Android s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (Associate Software)\t" + al.insert(s1));

		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (Bodyguard Software)\t" + al.insert(s1));

		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (Fighter Software)\t" + al.insert(s1));

		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (ObjectGuard Software)\t" + al.insert(s1));

		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (ServiceTechnician Software)\t" + al.insert(s1));

		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (TransportWorker Software)\t" + al.insert(s1));

		s1 = new Assistant(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel2()));
		System.out.println("Assistant (BuildingWorker Software)\t" + al.insert(s1));

		// Associate
		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (Assistant Software)\t" + al.insert(s1));

		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (Bodyguard Software)\t" + al.insert(s1));

		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (Fighter Software)\t" + al.insert(s1));

		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (ObjectGuard Software)\t" + al.insert(s1));

		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (ServiceTechnician Software)\t" + al.insert(s1));

		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (TransportWorker Software)\t" + al.insert(s1));

		s1 = new Associate(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel1()));
		System.out.println("Associate (BuildingWorker Software)\t" + al.insert(s1));

		// BodyGuard
		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (Assistant Software)\t" + al.insert(s1));

		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (Associate Software)\t" + al.insert(s1));

		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (Figter Software)\t" + al.insert(s1));

		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (ObjectGuard Software)\t" + al.insert(s1));

		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (ServiceTechnician Software)\t" + al.insert(s1));

		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (TransportWorker Software)\t" + al.insert(s1));

		s1 = new Bodyguard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Bodyguard (BuildingWorker Software)\t" + al.insert(s1));

		// Fighter
		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (Assistant Software)\t" + al.insert(s1));

		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (Associate Software)\t" + al.insert(s1));

		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (Bodyguard Software)\t" + al.insert(s1));

		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (ObjectGuard Software)\t" + al.insert(s1));

		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (ServiceTechnician Software)\t" + al.insert(s1));

		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (TransportWorker Software)\t" + al.insert(s1));

		s1 = new Fighter(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Fighter (BuildingWorker Software)\t" + al.insert(s1));

		// ObjectGuard
		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (Assistant Software)\t" + al.insert(s1));

		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (Associate Software)\t" + al.insert(s1));

		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (Fighter Software)\t" + al.insert(s1));

		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (Bodyguard Software)\t" + al.insert(s1));

		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (ServiceTechnician Software)\t" + al.insert(s1));

		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (TransportWorker Software)\t" + al.insert(s1));

		s1 = new ObjectGuard(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("ObjectGuard (BuildingWorker Software)\t" + al.insert(s1));

		// ServiceTechnician
		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (Assistant Software)\t"
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (Associate Software)\t"
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (Fighter Software)\t"
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (Bodyguard Software)\t"
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (ObjectGuard Software)\t"
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (TransportWorker Software)\t"
				+ al.insert(s1));

		s1 = new ServiceTechnician(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("ServiceTechnician (BuildingWorker Software)\t"
				+ al.insert(s1));

		// TransportWorker
		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (Assistant Software)\t"
				+ al.insert(s1));

		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (Associate Software)\t"
				+ al.insert(s1));

		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (Fighter Software)\t"
				+ al.insert(s1));

		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (Bodyguard Software)\t"
				+ al.insert(s1));

		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (ObjectGuard Software)\t"
				+ al.insert(s1));

		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (ServiceTechnician Software)\t"
				+ al.insert(s1));

		s1 = new TransportWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new BuildingWorker.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("TransportWorker (BuildingWorker Software)\t"
				+ al.insert(s1));

		// BuildingWorker
		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Assistant.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (Assistant Software)\t"
				+ al.insert(s1));

		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Associate.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (Associate Software)\t"
				+ al.insert(s1));

		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (Fighter Software)\t"
				+ al.insert(s1));

		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new Bodyguard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (Bodyguard Software)\t"
				+ al.insert(s1));

		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (ObjectGuard Software)\t"
				+ al.insert(s1));

		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new ServiceTechnician.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (ServiceTechnician Software)\t"
				+ al.insert(s1));

		s1 = new BuildingWorker(1, kit1kw(1), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(1, new SecurityLevel3()));
		System.out.println("BuildingWorker (TransportWorker Software)\t"
				+ al.insert(s1));
	}

	/*
	 * Die Software muss entsprechend der Sicherheitsstufen 1 bis 5 zertifiziert
	 * sein. Gesellschafter benoetigen Software der Stufe 1, alle anderen
	 * Bediener Software der Stufen 1 oder 2. Schwerarbeiter koennen mit Software
	 * der Stufen 3 und 4 ausgestattet sein. Kaempfer muessen Software der Stufe 5
	 * haben, alle anderen Beschuetzer Software der Stufe 4.
	 */
	private static void testSecurityLevel() {
		// Test Security Levels, if cnt is a comment this means it is tested to
		// change an androids SecLev which must be invalid
		System.out.println("\n\nTeste Sicherheitsstufen\n");

		AndroidList al = new AndroidList();

		int cnt = 0;

		// Associate
		cnt++;
		Android s201 = new Associate(cnt, kit1kw(cnt), new TouchSensitiveSkin(
				cnt), new Associate.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Associate (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Associate (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Associate (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Associate (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new Associate(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Associate.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Associate (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// Assistant
		cnt++;
		s201 = new Assistant(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Assistant (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Assistant (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Assistant (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Assistant (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new Assistant(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Assistant.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Assistant (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// TransportWorker
		cnt++;
		s201 = new TransportWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel1()));
		System.out.println("TransportWorker (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel2()));
		System.out.println("TransportWorker (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel3()));
		System.out.println("TransportWorker (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel4()));
		System.out.println("TransportWorker (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new TransportWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new TransportWorker.BaseSoftware(
						cnt, new SecurityLevel5()));
		System.out.println("TransportWorker (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// BuildingWorker
		cnt++;
		s201 = new BuildingWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel1()));
		System.out.println("BuildingWorker (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel2()));
		System.out.println("BuildingWorker (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel3()));
		System.out.println("BuildingWorker (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel4()));
		System.out.println("BuildingWorker (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new BuildingWorker(cnt, kit1kw(cnt),
				new TouchSensitiveSkin(cnt), new BuildingWorker.BaseSoftware(
						cnt, new SecurityLevel5()));
		System.out.println("BuildingWorker (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// ServiceTechnician
		cnt++;
		s201 = new ServiceTechnician(cnt, kit1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel1()));
		System.out.println("ServiceTechnician (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, kit1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel2()));
		System.out.println("ServiceTechnician (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, kit1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel3()));
		System.out.println("ServiceTechnician (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, kit1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel4()));
		System.out.println("ServiceTechnician (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new ServiceTechnician(cnt, kit1kw(cnt), new TouchSensitiveSkin(
				cnt), new ServiceTechnician.BaseSoftware(cnt,
				new SecurityLevel5()));
		System.out.println("ServiceTechnician (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// ObjectGuard
		cnt++;
		s201 = new ObjectGuard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("ObjectGuard (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("ObjectGuard (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("ObjectGuard (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("ObjectGuard (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new ObjectGuard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new ObjectGuard.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("ObjectGuard (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// Bodyguard
		cnt++;
		s201 = new Bodyguard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Bodyguard (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Bodyguard (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Bodyguard (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Bodyguard (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new Bodyguard(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Bodyguard.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Bodyguard (SecurityLevel 5)\t" + al.insert(s201));

		System.out.println();

		// Fighter
		cnt++;
		s201 = new Fighter(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel1()));
		System.out.println("Fighter (SecurityLevel 1)\t" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel2()));
		System.out.println("Fighter (SecurityLevel 2)\t" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel3()));
		System.out.println("Fighter (SecurityLevel 3)\t" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel4()));
		System.out.println("Fighter (SecurityLevel 4)\t" + al.insert(s201));

		cnt++;
		s201 = new Fighter(cnt, kit1kw(cnt), new TouchSensitiveSkin(cnt),
				new Fighter.BaseSoftware(cnt, new SecurityLevel5()));
		System.out.println("Fighter (SecurityLevel 5)\t" + al.insert(s201));
	}
	
	/**
	 * Testet Androiden mit falsch codierten Bauteilen
	 */
	public static void testSerialNumber() {
		AndroidList list = new AndroidList();
		Android android;
		List<Aktor> actors;
		List<Sensor> sensors;
		
		System.out.println("\n\nTeste Androiden mit falsch codierten Bauteilen\n");

		actors = new ArrayList<Aktor>();
		actors.add(new Aktor(2, "invalid Aktor", 1.5));
		sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(1, "valid Sensor"));
		android = new Fighter(1, new Kit(actors, sensors), new SolidSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Falsch codierter Aktor (#2 statt #1): " + list.insert(android));

		actors = new ArrayList<Aktor>();
		actors.add(new Aktor(1, "valid Aktor", 2.4));
		sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(8, "invalid Sensor"));
		android = new Fighter(1, new Kit(actors, sensors), new SolidSkin(1),
				new Fighter.BaseSoftware(1, new SecurityLevel5()));
		System.out.println("Falsch codierter Sensor (#8 statt #1): " + list.insert(android));

		actors = new ArrayList<Aktor>();
		actors.add(new Aktor(1, "valid Aktor", 2.4));
		sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(1, "valid Sensor"));
		android = new ObjectGuard(1, new Kit(actors, sensors), new TouchSensitiveSkin(54),
				new ObjectGuard.BaseSoftware(1, new SecurityLevel4()));
		System.out.println("Falsch codierter Skin (#54 statt #1): " + list.insert(android));

		android = new TransportWorker(1, new Kit(actors, sensors), new TouchSensitiveSkin(1),
				new TransportWorker.BaseSoftware(23, new SecurityLevel3()));
		System.out.println("Falsch codierte Software (#23 statt #1): " + list.insert(android));

		actors = new ArrayList<Aktor>();
		actors.add(new Aktor(11, "invalid Aktor", 1.5));
		sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(19, "invalid Sensor"));
		android = new TransportWorker(1, new Kit(actors, sensors), new TouchSensitiveSkin(41),
				new TransportWorker.BaseSoftware(23, new SecurityLevel3()));
		System.out.println("Jedes Bauteil mit falscher Codierung: " + list.insert(android));
		
		actors = new ArrayList<Aktor>();
		actors.add(new Aktor(11, "invalid Aktor", 1.5));
		sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(11, "invalid Sensor"));
		android = new TransportWorker(11, new Kit(actors, sensors), new TouchSensitiveSkin(11),
				new TransportWorker.BaseSoftware(11, new SecurityLevel3()));
		System.out.println("Jedes Bauteil mit gueltiger Codierung: " + list.insert(android));
	}
	
	/**
	 * Gibt alle Androiden die der Iterator liefert aus.
	 */
	private static void showAndroids(String text, Iterator<Android> iti) {
		int cnt = 0;
		while (iti.hasNext()) {
			cnt++;
			System.out.println(text + cnt);
			System.out.println(iti.next());
			System.out.println();
		}
	}

	/**
	 * Liefert ein Kit mit Leistungsklasse "<=1kW"
	 */
	public static Kit kit1kw(int id) {
		ArrayList<Aktor> actors = new ArrayList<Aktor>();
		actors.add(new Aktor(id, "minimal", 1.));
		
		ArrayList<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(id, "sample sensor"));
		
		return new Kit(actors, sensors);
	}

	/**
	 * Liefert ein Kit mit Leistungsklasse "<=5kW"
	 */
	public static Kit kit5kw(int id) {
		ArrayList<Aktor> actors = new ArrayList<Aktor>();
		actors.add(new Aktor(id, "mittel", 5.));
		
		ArrayList<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(id, "sample sensor"));
		
		return new Kit(actors, sensors);
	}

	/**
	 * Liefert ein Kit mit Leistungsklasse "<=10kW"
	 */
	public static Kit kit10kw(int id) {
		ArrayList<Aktor> actors = new ArrayList<Aktor>();
		actors.add(new Aktor(id, "hoch", 10.));
		
		ArrayList<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(id, "sample sensor"));

		return new Kit(actors, sensors);
	}

	/**
	 * Liefert ein Kit mit Leistungsklasse "unbegrenzt"
	 */
	public static Kit kitinfkw(int id) {
		ArrayList<Aktor> actors = new ArrayList<Aktor>();
		actors.add(new Aktor(id, "unendlich", 5000.));
		
		ArrayList<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(new Sensor(id, "sample sensor"));
		
		return new Kit(actors, sensors);
	}
}
