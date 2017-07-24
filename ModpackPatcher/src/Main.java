import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Main
{

	public static final String name = "patch.zip";
	public static final int  BUFFER_SIZE = 4096;
	
	public static File root;
	public static File tmp_patchFolder;
	public static File patch;
	
	
	
	static
	{
		try
		{
			root = new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		tmp_patchFolder = new File(root, "patch_tmp");
		patch = new File(root, name);
	}
	
	
	public static void copyFile(ZipFile zip, ZipEntry e, String file) throws Exception
	{
		File f = new File(root, file);
		
		if(f.exists())
		{
			f.delete();
		}
		
		if(!f.getParentFile().exists())
		{
			f.getParentFile().mkdirs();
		}
		
		f.createNewFile();
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
		
		InputStream in = zip.getInputStream(e);
				
	    int count = -1;
	    while ((count = in.read(buffer)) != -1)
	      out.write(buffer, 0, count);
	    out.flush();
	    out.close();
		
	    in.close();
	
	    
	}
	
	public static void copyDir(ZipFile zip, String srcPath, String dstPath) throws Exception
	{
		Enumeration<? extends ZipEntry> entries = zip.entries();
		
		ZipEntry entry;
		
		File dir = new File(root, dstPath);
		
		if(!dir.exists()) dir.mkdirs();
		
		while(entries.hasMoreElements())
		{
			entry = entries.nextElement();
			
			if(!entry.isDirectory())
			{
				if(entry.getName().startsWith(srcPath))
				{
					copyFile(zip, entry, dstPath + new File(entry.getName()).getName());
				}
			}
		}
	}
	
	
	public static void deleteFile(String path)
	{
		File f = new File(root, path);
		
		if(f.exists())
		{
			f.delete();
		}
	}
	
	public static void deleteDir(String path)
	{
		File f = new File(root, path);
		
		if(f.exists())
		{
			File[] content = f.listFiles();
			
			for(File c : content)
			{
				c.delete();
			}
			
			f.delete();
		}
	}
	
	public static void main(String[] args)
	{
		try
		{
			ZipFile zip = new ZipFile(patch.getPath());
			
			InputStreamReader isr = new InputStreamReader(zip.getInputStream(zip.getEntry("patchfile.txt")));
			BufferedReader br = new BufferedReader(isr);
			
			String line = "";
			
			while((line = br.readLine()) != null)
			{				
				if(line.startsWith("delf: "))
				{
					String[] parts = line.split(": ");
					System.out.print("delete file " + "\"" + parts[1] + "\"....");
					deleteFile(parts[1]);
					System.out.println("finished");
				}
				else if(line.startsWith("deld: "))
				{
					String[] parts = line.split(": ");
					System.out.print("delete directory " + "\"" + parts[1] + "\"....");
					deleteDir(parts[1]);
					System.out.println("finished");
				}
				else if(line.startsWith("movf: "))
				{
					String[] parts = line.split(": ")[1].split(" ; ");
					System.out.print("move file \"" + parts[0] + "\" to \"" + parts[1] + "\"....");
					copyFile(zip, zip.getEntry(parts[0]), parts[1]);
					System.out.println("finished");
				}
				else if(line.startsWith("movd: "))
				{
					String[] parts = line.split(": ")[1].split(" ; ");
					System.out.print("move directory \"" + parts[0] + "\" to \"" + parts[1] + "\"....");
					copyFile(zip, zip.getEntry(parts[0]), parts[1]);
					System.out.println("finished");
				}
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
