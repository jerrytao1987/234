package bjava20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SplitFile {
	public static void main(String[] args) throws IOException {
//		splitFile();
		merge();
	}
	
	private static void merge() throws IOException {
		ArrayList<FileInputStream> list = new ArrayList<FileInputStream>();
		for (int i = 1; i <=3; i++) {
			list.add(new FileInputStream("D:\\Downloads\\"+i+".part"));
		}
		final Iterator<FileInputStream> it = list.iterator();
		Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {

			@Override
			public boolean hasMoreElements() {
				return it.hasNext();
			}

			@Override
			public FileInputStream nextElement() {
				return it.next();
			}
		};
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream("d:\\Downloads\\0.exe");
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=sis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}

	private static void splitFile() throws IOException {
		FileInputStream fis = new FileInputStream("d:\\PowerEnterABC32.exe");
		FileOutputStream fos = null;
		File f = new File("d:\\PowerEnterABC32.exe");
		int i =  (int) Math.ceil(f.length()/(1024.0*1024.0));
		for (int j = 1; j <= i; j++) {
			File file = new File("D:\\Downloads\\"+j+".part");
			if(file.exists()){
				file.delete();
			}
			file.createNewFile();
		}
		byte[] buf = new byte[1024];
		int len = 0;
		int count=1;
		while((len=fis.read(buf))!=-1){
			long length = new File("D:\\Downloads\\"+count+".part").length();
			System.out.println(length>=1024*1024);
			if(length>=1024*1024){
				count++;
			}
			fos = new FileOutputStream("D:\\Downloads\\"+count+".part",true);
			fos.write(buf,0,len);
			fos.close();
			
		}
		if(fos!=null){
			fos.close();
		}
		fis.close();
	}
}
