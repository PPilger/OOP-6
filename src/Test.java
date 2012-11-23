import java.util.*;



public class Test {
	public static void main(String[] args) {
		
		AndroidList al = new AndroidList();
		ArrayList<Aktor> ak = new ArrayList<Aktor>();
		ak.add(new Aktor("Putzen", 1, 12));
		ArrayList<Sensor> as = new ArrayList<Sensor>();
		as.add(new Sensor("Staub", 12));
		Kit k201 = new Kit(12, ak, as);
		Android s201 = new Partner(12, k201 , new TouchSensitiveSkin(12) , new Partner.BaseSoftware(new SecurityLevel1(),12));
		al.insert(s201);
		System.out.println(al);
		System.out.println(al.find(12));
		Android s202 = new Assistant(12, k201 , new TouchSensitiveSkin(12) , new Partner.BaseSoftware(new SecurityLevel1(),12));
		al.insert(s202);
		System.out.println(al);
		System.out.println(al.find(12));
		Iterator<Android> iti = al.iterator();
		while(iti.hasNext())
		{
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
