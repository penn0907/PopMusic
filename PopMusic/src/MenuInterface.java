import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MenuInterface {

	public static final String[] MENU = { "1. xxx", "2. xxx" };

	public static final String MUSIC_FILEPATH = "Songs.txt";
	

	public static void main(String[] args) {
		System.out.println("Welcome to Pop Music!");
	}
	
	

	public Object readFile(String filePath) {

		Object o = null;

		FileInputStream fis = null;
		ObjectInputStream oi = null;

		try {
			fis = new FileInputStream(filePath);
			oi = new ObjectInputStream(fis);

			o = oi.readObject();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return o;

	}

	public void writeFile(Object o, String filePath) {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(o);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.flush();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}