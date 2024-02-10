package feb2nd;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class student {
	private int id;
	private String name;
	private int marks;
	student(int id,String name,int marks) {
		this.id=id;
		this.name=name;
		this.marks=marks;
	}
	@Override
	public String toString() {
		return "[Student:"+id+" "+"name:"+name+" "+"marks:"+marks+"]";
		
	}
	public int getId() {
		return id;
}
	public String getName() {
		return name;
	}
	public int getmarks() {
		return marks;
}
}
public class StudentMangement {
	public static void main(String ...args) {
		ArrayList<student> l=new ArrayList<>();
		l.add(new student(1,"Jashwanth",95));
		l.add(new student(2,"anatha",90));
		l.add(new student(3,"krishna",85));
		l.add(new student(4,"ramesh",45));
		List<student> stream1=l.stream()
				.filter((student)->student.getmarks()>=90)
				//.map((student)->student.getmarks()*2)
				.collect(Collectors.toList());
			stream1.forEach((student)->System.out.println(student));	
				
		}
		
	}

