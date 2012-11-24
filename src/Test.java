import java.util.*;



public class Test {
	public static void main(String[] args) {
		
		AndroidList al = new AndroidList();
		ArrayList<Aktor> ak = new ArrayList<Aktor>();
		ak.add(new Aktor(12, "Putzen", 0.5));
		ArrayList<Sensor> as = new ArrayList<Sensor>();
		as.add(new Sensor(12, "Staub"));
		Kit k201 = new Kit(12, ak, as);
		Android s201 = new Associate(12, k201, new TouchSensitiveSkin(12), new Associate.BaseSoftware(12, new SecurityLevel1()));
		al.insert(s201);
		ArrayList<Aktor> ak2 = (ArrayList<Aktor>)ak.clone();  ak2.add(new Aktor(12, "Waschen", 0.5));
		k201 = new Kit(12, ak2, as);
		Android s202 = new Assistant(12, k201 , new TouchSensitiveSkin(12) , new Associate.BaseSoftware(12, new SecurityLevel1()) );
		al.insert(s202);
		System.out.println("Iterator");
		Iterator<Android> iti = al.iterator();
		while(iti.hasNext())
		{
			System.out.println(iti.next());
		}
		
		iti = al.iterator(12);
		int cnt = 0;
		while(iti.hasNext())
		{
			cnt++;
			System.out.println("Konfiguration Nr.:" +  cnt);
			System.out.println(iti.next());
		}
		
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
}
