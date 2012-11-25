import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class AndroidList {
	private LinkedHashMap<Integer, Entry> map = new LinkedHashMap<Integer, Entry>();

	public ValidationCode insert(final Android newAndroid) {
 		final int serialNum = newAndroid.getSerialNum();
		final Entry entry = map.get(serialNum);
		ValidationCode code;

		// is the given Android currently in the map?
		if (entry == null) {
			code = newAndroid.validate();

			code.executeIfValid(new ValidationCode.Operation() {

				@Override
				public void execute() {
					Entry newEntry = new Entry(newAndroid);
					map.put(serialNum, newEntry);
				}
			});
		} else {
			Android oldAndroid = entry.history.getFirst();
			code = newAndroid.validate(oldAndroid);

			code.executeIfValid(new ValidationCode.Operation() {

				@Override
				public void execute() {
					entry.update(newAndroid);
				}
			});
		}

		return code;
	}

	public String find(int serialNum) {
		Entry entry = map.get(serialNum);

		if (entry == null) {
			return null;
		}

		return entry.getNewest().toString();
	}

	//returns an Iterator over the configurations durring an Android's life
	public Iterator<Android> iterator(int Id)
	{
		Entry en = map.get(Id);
		if (en == null)
			return new Iterator<Android>() {
								
				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public Android next() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					
				}
			};
		return en.iterator();
	}

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

	private class Entry {
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

		//returns an Iterator over all configurations, starting with the last used
		public Iterator<Android> iterator() {

			return history.descendingIterator();
		}
	}
}
