
public class JagArray {

	public static void main(String[] args)
	{
		int[][] jagArray = {{1,2,3},{4,5,6},{7,8,9},{10}};
		
		for (int i = 0; i < jagArray.length; i++)
		{
			for (int j = 0; j < jagArray[i].length; j++)
				System.out.println(jagArray[i][j]);
		}
	}
}
