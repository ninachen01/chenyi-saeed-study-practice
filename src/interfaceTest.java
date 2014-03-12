
public class interfaceTest {
	
public interface Car
{
	public void drive();
}
public interface Motocycle
{
	public void drive();
}
public class Test implements Car, Motocycle
{
	int i=0;
	@Override
	public void drive() 
	{
		// TODO Auto-generated method stub
		i++;
		System.out.println(getData());
	}
	private int getData()
	{
		return i;
	}
}
public static void main(String[] args)
{
	interfaceTest inter = new interfaceTest();
	Motocycle motocycle = inter.new Test();
	motocycle.drive();
	Car car = inter.new Test();
	car.drive();
}
}
