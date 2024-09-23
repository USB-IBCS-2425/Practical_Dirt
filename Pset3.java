class wallet {
	private double money;
	private int IDnumber;

	public wallet(int IDnumber, double money){

		this.money = money;
		this.IDnumber = IDnumber;
	}

	public void SetIDnumber(int newid) {
		this.IDnumber = newid;
	}

	public int GetIDnumber() {
		return this.IDnumber;
	}

	public void Setmoney(int money) {
		this.money = money;
	}

	public double Getmoney() {
		return this.money;
	}

	public void payday(int amount){
		this.money += amount;
	}

	public void pay(int amount){
			if (amount < this.money){
			this.money -= amount;

		}
	}

}

class Shape {
	public Shape() {}
	public double area(){ 
		return 0;
	}

}

class Rectangle extends Shape {

	public double length;
	public double width;

	public Rectangle(double length, double width) {
        this.length = length;
        this.width = width; 
    }

    public double area() {
    	return length * width;
    }

}


class Circle extends Shape {
	public double radius;

	public Circle(double Radius){
		this.radius = Radius;
	}

	public double area() {
		return (radius * radius * 3.1415);
	}


}

class Pset3{


public static void main(String[] args) {

	wallet AndrewWallet = new wallet(0523, 6700);
	AndrewWallet.SetIDnumber(0524);
	AndrewWallet.Setmoney(500);
	System.out.println(AndrewWallet.Getmoney());
	AndrewWallet.payday(200);
	AndrewWallet.pay(100);
	System.out.println(AndrewWallet.Getmoney());
	AndrewWallet.pay(1000);

	Shape shape1 = new Shape();
	Circle circle = new Circle(10);
	Rectangle rectangle = new Rectangle(5, 4);

	System.out.println(rectangle.area());
	System.out.println(circle.area());

	
	}
}


