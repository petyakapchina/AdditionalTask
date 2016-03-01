import java.util.Calendar;

public class Record implements Comparable<Record> {
	private Calendar taken;
	private Calendar returned;

	public Record(Calendar t) {
		if (t != null)
			this.taken = t;
	}

	public void setReturnedDate(Calendar object) {
		if (object != null) {
			this.returned = object;
		}
	}

	public boolean isReturnedInTime() {
		Calendar now = Calendar.getInstance();
		if (now.after(this.returned)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int compareTo(Record o) {
		if (o.returned.before(this.taken)) {
			return -1;
		} else {
			return 1;
		}
	}

}
