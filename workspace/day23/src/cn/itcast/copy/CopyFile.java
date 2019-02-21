package cn.itcast.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

	public static void main(String[] args) {
		File fileSource = new File("D:\\SublimeText_XP85\\Sublime Text");
		File fileDestination = new File("e:\\demo");
		copyFiles(fileSource,fileDestination);
		
	}

	public static void copyFiles(File fileSource,File fileDestination) {
		if(fileSource.exists()){
			if(fileSource.isDirectory()){
				if(fileDestination.exists()){
					fileDestination = new File(fileDestination,fileSource.getName());
					fileDestination.mkdir();
				}else{
					fileDestination.mkdirs();
					fileDestination = new File(fileDestination,fileSource.getName());
					fileDestination.mkdir();
				}
				File[] listFiles = fileSource.listFiles();
				for (File file : listFiles) {
					if(file.isFile()){
						File fileDestination1 = new File(fileDestination,file.getName());
						FileInputStream fis = null;
						FileOutputStream fos = null;
						byte[] b = new byte[1024*10];
						int len = 0;
						try {
							fis = new FileInputStream(file);
							fos = new FileOutputStream(fileDestination1);
							while((len = fis.read(b))!=-1){
								fos.write(b, 0, len);
							}
						} catch (Exception e) {
							throw new RuntimeException("文件复制失败");
						} finally {
							try {
								if(fos != null){
									fos.close();
								}
							} catch (IOException e) {
								throw new RuntimeException("释放资源失败");
							} finally {
								try {
									if(fis != null)
										fis.close();
								} catch (Exception e2) {
									throw new RuntimeException("释放资源失败");
								}
							}
						}
					}
				}
				for (File file : listFiles) {
					if(file.isDirectory()){
						copyFiles(file,fileDestination);
					}
				}
			} else {
				File fileDestination1 = new File(fileDestination,fileSource.getName());
				FileInputStream fis = null;
				FileOutputStream fos = null;
				byte[] b = new byte[1024*10];
				int len = 0;
				try {
					fis = new FileInputStream(fileSource);
					fos = new FileOutputStream(fileDestination1);
					while((len = fis.read(b))!=-1){
						fos.write(b, 0, len);
					}
				} catch (Exception e) {
					throw new RuntimeException("文件复制失败");
				} finally {
					try {
						if(fos != null){
							fos.close();
						}
					} catch (IOException e) {
						throw new RuntimeException("释放资源失败");
					} finally {
						try {
							if(fis != null)
								fis.close();
						} catch (Exception e2) {
							throw new RuntimeException("释放资源失败");
						}
					}
				}
			}
		}else{
			System.out.println("文件目录不存在");
		}
	}

}
