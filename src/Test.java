
public class Test {
	public static void main(String[] args) {
		AndroidList al = new AndroidList();
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

		g8 = new Guardian(8) {};
		g8.setSkin(new SolidSkin());
		System.out.println(al.insert(g8));
		
		g8 = new Guardian(8) {};
		g8.setSkin(new TouchSensitiveSkin());
		System.out.println(al.insert(g8));
		
	}
}
