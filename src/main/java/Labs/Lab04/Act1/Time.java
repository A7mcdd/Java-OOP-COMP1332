package Labs.Lab04.Act1;


public class Time implements Comparable<Time>,Cloneable{
	private long time;

	public Time() {
		time = System.currentTimeMillis()/1000;
	}

	public Time(int hour, int minute, int second) {
		time = hour*3600+minute*60+second;
	}

	public Time(long elapsedTime) {
		time = elapsedTime;
	}


	public int getHour() {
		return (int)((time/3600)%24);
	}

	public int getMinute() {
		return (int)((time/60)%60);
	}

	public int getSecond() {
		return (int)((time)%60);
	}

	public long getSeconds() {
		return time;
	}

	@Override
	public String toString() {
		return getHour()+" hours "+getMinute()+" minutes "+getSecond()+" seconds";
	}

	@Override
	public int compareTo(Time o) {
			return (int)(time-o.getSeconds());
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return (Time)super.clone();
	}

}
