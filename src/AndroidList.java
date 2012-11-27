import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Stellt eine Liste von Androiden dar.
 * 
 * @author Peter Pilgerstorfer
 */
public class AndroidList {
	// eine Map mit der Seriennummer als Schluessel
	private LinkedHashMap<Integer, Entry> map = new LinkedHashMap<Integer, Entry>();

	/**
	 * Fuegt den neuen Android in die Liste ein (sofern er gueltig ist).
	 * 
	 * Falls ein Android mit der selben id bereits enthalten ist, wird dieser
	 * durch den neuen ersetzt (sofern der neue gueltig ist und den alten
	 * ueberscheiben darf). Der alte Android bleibt jedoch in der Historie
	 * gespeichert.
	 */
	public ValidationCode insert(final Android newAndroid) {
		final int serialNum = newAndroid.getSerialNum();
		final Entry entry = map.get(serialNum);
		ValidationCode result;

		if (entry == null) {
			// es ist kein Android mit der Seriennummer in map enthalten

			result = newAndroid.validate();

			// fuege den Android ein, wenn er gueltig ist
			result.executeIfValid(new ValidationCode.Operation() {
				@Override
				public void execute() {
					Entry newEntry = new Entry(newAndroid);
					map.put(serialNum, newEntry);
				}
			});
		} else {
			// es ist bereits ein Android mit der Seriennummer in map enthalten

			Android oldAndroid = entry.history.getFirst();
			result = newAndroid.validate(oldAndroid);

			// ersetze den alten Android, wenn der neue gueltig ist und den
			// alten ersetzen darf
			result.executeIfValid(new ValidationCode.Operation() {
				@Override
				public void execute() {
					entry.update(newAndroid);
				}
			});
		}

		return result;
	}

	/**
	 * Liefert die toString-Darstellung des Androids mit der gegebenen
	 * Seriennummer oder null, falls der Android nicht in der Liste enthalten
	 * ist.
	 */
	public String find(int serialNum) {
		Entry entry = map.get(serialNum);

		if (entry == null) {
			return null;
		}

		return entry.getNewest().toString();
	}

	/**
	 * Liefert einen Iterator ueber den Aenderungsverlauf des ueber die
	 * Seriennummer bestimmten Androids. Der Iterator startet bei der
	 * urspruenglichen Version und endet bei der aktuellen.
	 * 
	 * Wenn der Android nicht existiert, wird ein Iterator zurueckgegeben der
	 * kein Element enthaelt.
	 */
	public Iterator<Android> history(int Id) {
		Entry en = map.get(Id);

		if (en == null) {
			return new LinkedList<Android>().iterator();
		}

		return en.iterator();
	}

	/**
	 * Liefert einen Iterator ueber alle aktuell in der Liste enthaltenen
	 * Androiden. Die Androiden werden in der Reihenfolge des ersten Einfuegens
	 * durchiteriert.
	 */
	public Iterator<Android> iterator() {
		return new Iterator<Android>() {
			Iterator<Entry> iter = map.values().iterator();

			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			@Override
			public Android next() {
				return iter.next().getNewest();
			}

			@Override
			public void remove() {
				iter.remove();
			}

		};
	}

	/**
	 * Speichert einen Android, sowie alle frueheren Versionen des Androiden.
	 * 
	 * @author Peter Pilgerstorfer
	 */
	private class Entry {
		// enthaelt den aktuellsten Android an erster Stelle
		private LinkedList<Android> history = new LinkedList<Android>();

		private Entry(Android newAndroid) {
			history.addFirst(newAndroid);
		}

		private void update(Android newAndroid) {
			history.addFirst(newAndroid);
		}

		private Android getNewest() {
			return history.getFirst();
		}

		/**
		 * Liefert einen Iterator von dem urspruenglichen Androiden bis zum
		 * aktuellen.
		 */
		private Iterator<Android> iterator() {
			return history.descendingIterator();
		}
	}
}
