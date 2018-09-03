import java.util.*;

class StringArrayTrick
{
	public static void main(String cla[])
	{
		Scanner input=new Scanner(System.in);
		String mystr="";
		for(int i=0;i<3;i++)
		{
			mystr+=input.next() +" ";
		}
		System.out.println("This is my entire string: " +mystr);
	}
}