//Sina Kamali 610394126
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
public class Phonebook{
	
	public static boolean prompt(Scanner in, PhonebookOps phbook){
		Scanner scan = in;
		String ans = scan.nextLine();
		if(ans.toLowerCase().equals("show"))
			phbook.show();
		else if(ans.toLowerCase().equals("add"))
			phbook.add(scan);
		else if(ans.toLowerCase().equals("remove"))
			phbook.remove(scan.nextLine());
		else if(ans.toLowerCase().equals("search"))
			phbook.search(scan.nextLine());
		else
			return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
//		Scanner filename = new Scanner(System.in);
//		File file = new File(filename.nextLine());
		Scanner scan = new Scanner(System.in);
		PhonebookOps phbook = new PhonebookOps(scan);
		
		boolean cont=true;
		while(cont){
				System.out.println("----------------------\nShow\tAdd\tRemove\tSearch\n----------------------");
				cont=prompt(scan,phbook);
				System.out.println("----------------------");
		}
		
	}
	
}

class Sorting{
	
	void swap(PhoneLibrary[] lib, int i, int j) {
		String temp = lib[i].name;
		lib[i].name = lib[j].name;
		lib[j].name = temp;
		temp = lib[i].addrs;
		lib[i].addrs = lib[j].addrs;
		lib[j].addrs = temp;
		temp = lib[i].num1;
		lib[i].num1 = lib[j].num1;
		lib[j].num1 = temp;
		temp = lib[i].num2;
		lib[i].num2 = lib[j].num2;
		lib[j].num2 = temp;
	}

	StringBuffer sort(PhoneLibrary[] lib) {
		int i, j;
		int n = lib.length;
		for (i = n - 1; i >= 0; i--)
			for (j = 0; j < i; j++)
				if (lib[j].name.toLowerCase().compareTo(lib[j + 1].name.toLowerCase())>0)
					swap(lib, j, j + 1); 
		StringBuffer out = new StringBuffer();
		for(PhoneLibrary val:lib)
			out.append(val.name+"|"+val.num1+"|"+val.num2+"|"+val.addrs+"|");
		return out;
	}
	
}

class PhonebookOps{
	Scanner scan;
	StringBuffer storage;
	PhoneLibrary[] lib;
	Sorting sort;
	PhonebookOps(Scanner in){
		scan=in;
		storage = new StringBuffer();
		sort = new Sorting();
	}
	
	void show(){
		for(PhoneLibrary val:lib)
			val.print();
		System.out.println(storage);
	}
	
	void add(Scanner scan){
		String name = scan.nextLine();
		String num1 = scan.nextLine();
		String num2 ="-";
		if(scan.nextLine().toLowerCase().charAt(0)=='y')
			num2 = scan.nextLine();
		String addrs = scan.nextLine();
		storage.append(name+"|"+num1+"|"+num2+"|"+addrs+"|");
		lib = toObject(storage);
		storage=sort.sort(lib);
	}
	
	void remove(String str){
		int at=-1;
		for(int i=0;i<lib.length;i++)
			if(lib[i].name.toLowerCase().equals(str))
				at=i*4;
		if(at==-1){
			System.out.println("not found");
			return;
		}
		else{
			int start=0;
			for(;at>0;start++)
				if(storage.charAt(start)=='|')
					at--;
			int end=start;
			int counter=3;
			for(;counter>=0 && end<storage.length();end++)
				if(storage.charAt(end)=='|')
					counter--;
			storage.delete(start, end);
		}
		lib = toObject(storage);
	}
	
	void search(String str){
		StringTokenizer token = new StringTokenizer(storage.toString(),"|");
		int tempi=-4;
		for(int i=0;token.hasMoreTokens();i++){
			String temp = token.nextToken();
			if(str.equals(temp))
				if(i/4!=tempi/4){
					lib[i/4].print();
					tempi=i;
				}
		}
		if(tempi==-4)
			System.out.println("not found");
	}
	
	PhoneLibrary[] toObject(StringBuffer store){
		StringTokenizer token = new StringTokenizer(store.toString(),"|");
		PhoneLibrary[] out = new PhoneLibrary[token.countTokens()/4];
		for(int i=0;i<out.length;i++)
			out[i] = new PhoneLibrary(token.nextToken(),token.nextToken(),token.nextToken(),token.nextToken());
		return out;
	}
	
}

class PhoneLibrary{
	
	String name, num1, num2, addrs;
	PhoneLibrary(String namein, String num1in, String num2in, String addrsin){
		name=namein;
		addrs=addrsin;
		num1=num1in;
		num2=num2in;
	}
	
	void print(){
		System.out.println("----------------------"
						+ "\nName:\t\t" + name
						+ "\nPhone1:\t\t" + num1
						+ "\nPhone2:\t\t" + num2
						+ "\nAddress:\t" + addrs
						+ "\n----------------------");
	}
	
}