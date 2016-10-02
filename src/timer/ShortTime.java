package timer;

public class ShortTime {
	ShortTime() {
		short i = 0;
		setMin(i);
		setSec(i);
	}

	ShortTime(int min, int sec) {
		setMin(min);
		setSec(sec);
	}

	private int min;
	private int sec;

	public void increase() {
		sec++;
		if (sec == 60) {
			sec = 0;
			min++;
		}
	}

	public void decrease() {

		if (sec == 0) {
			sec = 59;
			min--;
		} else	sec--;
	}

	public String toString() {
		String minStr, secStr;

		if (min <= 9)
			minStr = "0" + String.valueOf(min);
		else
			minStr = String.valueOf(min);
		if (sec <= 9)
			secStr = "0" + String.valueOf(sec);
		else
			secStr = String.valueOf(sec);

		return minStr + ":" + secStr;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

}
