package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		writeObject();
		readObject();
	}

	private static void readObject() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = 
				new ObjectInputStream(new FileInputStream("d:\\person.txt"));
		Object readObject = ois.readObject();
		System.out.println(readObject);
		ois.close();
	}

	private static void writeObject() throws IOException {
		ObjectOutputStream oos = 
				new ObjectOutputStream(new FileOutputStream("d:\\person.txt"));
		oos.writeObject(new Person("lisi",28));
		oos.close();
	}

}
