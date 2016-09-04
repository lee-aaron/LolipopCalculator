import java.io.*;

public class LolipopSave {
	
	static File file;
	static FileOutputStream outFile;
	static InputStream input;
	
	//Constructor
	public LolipopSave() {
		createSaveFile();
	}
	
	//Creates Save File using File and OutputStream; Saves in .txt file
	private void createSaveFile() {
		try {
			file = new File("C:/LolipopData.txt");		//Temporary save location
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
	
	//Closes save file so that program can exit
	public void closeSaveFile()
	{
		try {
			outFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Need to implement ability to read data from save file
	public double readData() throws IOException
	{
		int i = 0;
		double data = 0;
		try {
			input = new FileInputStream("C:/LolipopData.txt");		//Must match File file
			while((i=input.read()) != -1) {
				data = (double) i;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(input != null)
			{
				input.close();
			}
		}
		return data;
	}
	
}
