import java.io.*;

public class LolipopSave {
	
	static File file;
	static FileOutputStream outFile;
	
	//Constructor
	public LolipopSave() {
		createSaveFile();
	}
	
	//Creates Save File using File and OutputStream; Saves in .txt file
	private void createSaveFile() {
		try {
			file = new File("C:/Data.txt");		//Temporary save location
			outFile = new FileOutputStream(file);
			if(!file.exists()) {		//Creates file if it doesn't exist
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	//Adds data to file; Must be in bytes and can convert from String to Byte
	public void addData(double money)
	{
		String s = String.valueOf(money);
		byte[] data = s.getBytes();
		try {
			outFile.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//Need to implement ability to read data from save file
	public void readData()
	{
		
	}
	
}
