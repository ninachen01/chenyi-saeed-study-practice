
public enum EnumTest {
	OFF("The power is off"),
	ON("The usage power is high"),
	SUSPEND("The power usage is low");
	private String description;
	private EnumTest(String d)
	{
		description =d;
	}
	public String getDescription()
	{
		return description;
	}
	public static void main(String args[])
	{
		EnumTest.OFF.getDescription();
		EnumTest enumTest = OFF;
	}
}
