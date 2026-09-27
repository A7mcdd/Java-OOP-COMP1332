package Labs.Lab04.Act2;

public class Point implements Cloneable,Comparable<Point> {
	private double x,y;

	Point(){
		x=0;
		y=0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Point) {
			if (x == ((Point)o).getX() && y==((Point)o).getY())
				return true;
		}
		return false;
	}

	@Override
	public int compareTo(Point o) {
		if (x>o.getX()||(x==o.getX()&&y>o.getY()))
			return 1;
		else if (x<o.getX()||(x==o.getX()&&y<o.getY()))
			return -1;
		else
			return 0;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "[x "+x+", y "+y+"]";
	}

}
