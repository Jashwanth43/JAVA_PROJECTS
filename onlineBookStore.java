package feb2nd;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
class book {
	private int id;
	private String name;
	private String author;
	private int price;
	public book(int id, String name, String author, int price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String toString() {
		return "[Student:"+id+" "+"name:"+name+" "+"author:"+author+"Price:"+price+"]";
	}
	
}
public class onlineBookStore {
	private List<book> books;
	onlineBookStore(){
		this.books=new ArrayList<>();
	}
	public void addBooks(book addBook) {
		books.add(addBook);
	}
	public void removeBooks(int id) {
		books.removeIf(book->book.getId()==id);
	}
	public double getTotalPriceByAuthor(String authorName) {
		return books.stream()
		.filter(book->book.getAuthor()==authorName)
		.sorted((book1,book2)->book1.getName().compareTo(book2.getName()))
		.mapToDouble(book::getPrice)
        .reduce(0, Double::sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onlineBookStore b=new onlineBookStore();
		b.addBooks(new book(1,"wings of fire","abdul kalam",200));
		b.addBooks(new book(2,"Folli Hair","abdul",280));
		b.addBooks(new book(3,"redensol","varun",500));
		b.addBooks(new book(4,"cerave","jj",750));
		double d=b.getTotalPriceByAuthor("varun");
		System.out.println(d);
		
		
	}

}
