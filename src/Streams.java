import java.io.File;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		count the name start with letter "A" in arraylist & display it in console
//		Regular method
/*		ArrayList<String> names = new ArrayList<String>();
		names.add("Akshay");
		names.add("Akash");
		names.add("Messi");
		names.add("Ronaldo");
		names.add("Virat");
		int count =0;
		for (int i=0; i<names.size(); i++)
		{
			String a=names.get(i);
			if (a.startsWith("A"))
			{
				count++;
			}
		}
		System.out.println(count);*/
		
		
		
//		By using java streams
		ArrayList<String> names1 = new ArrayList<String>();
		names1.add("Akshay");
		names1.add("Akash");
		names1.add("Messi");
		names1.add("Ronaldo");
		names1.add("Virat");
//		converting the names1 array into stream & then applying the intermediate operation(filter) , this will
//		return another new stream & then will apply the terminal operation(count) on the final stream to get the result
		System.out.println(names1.stream().filter(b->b.startsWith("A")).count());
		
		Stream.of("Arjuna","Balarama","Krishna","Bheem").filter(s->s.endsWith("a")).forEach(s->System.out.println(s));
	}

}
