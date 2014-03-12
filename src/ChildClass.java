
public abstract class ChildClass extends AbstractClass implements Comparable<ChildClass>, AbstractJavaClass{

		private String name;
		private String GPA;
		
	public ChildClass()
	{
		super();
	}
	public String getName() {
		getShape();
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGPA() {
			return GPA;
		}

		public void setGPA(String gPA) {
			GPA = gPA;
		}

	public void use()
	{
		System.out.print("hey!Use");
	}

	@Override
	public int compareTo(ChildClass o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.getName());
	}






}
