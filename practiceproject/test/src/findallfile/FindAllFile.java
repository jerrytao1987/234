package findallfile;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;

import org.junit.Test;

public class FindAllFile {
	private String pathname="D:/demo";
	/**
	 * 遍历目录下的所有文件（不遍历子目录）
	 * @throws Exception
	 */
	@Test
	public void findAllFile() throws Exception {
		File file = new File(pathname);
		File[] list = file.listFiles();
		for(File f:list){
			System.out.println(f.getName());
		}
	}
	/**
	 * 遍历目录下的所有文件（包含子目录）
	 * @throws Exception
	 */
	@Test
	public void findAllFiles() throws Exception {
		File file = new File(pathname);
		recursionFindFile(file,0);
	}
	/**
	 * 遍历指定的文件对象，根据level打印制表位
	 * @param file
	 * @param level
	 */
	public void recursionFindFile(File file,int level){
		for(int j=0;j<level;j++){
			System.out.print("\t");
		}
		System.out.println(file.getName());
		File[] list = file.listFiles();
		for (File f : list) {
			if(f.isDirectory()){
				recursionFindFile(f,level+1);
			}else{
				for(int i=0;i<level+1;i++){
					System.out.print("\t");
				}
				System.out.println(f.getName());
				
			}
		}
	}
	/**
	 * 根据NIO遍历目录下的所有文件和目录
	 * @throws Exception
	 */
	@Test
	public void NIOFindAllFile() throws Exception {
		Path path = Paths.get(pathname);
		Files.walkFileTree(path,new SimpleFileVisitor<Path>(){

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				System.out.println(dir.getFileName());
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.getFileName());
				return FileVisitResult.CONTINUE;
			}
			
		});
	}
	
}
