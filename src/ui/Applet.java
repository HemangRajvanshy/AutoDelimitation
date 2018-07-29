package ui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;

import javax.swing.*;

import util.Gaussian;
import util.StaticFunctions;



public class Applet extends JApplet {
	public static MainFrame mainFrame = null;
	public static String open_project = null;
	public static  String[] args = null;

    public static void main( String[] _args )
	{
		args = _args;
    	new Applet();
	}
	public static void deleteRecursive(File f)  {
		System.out.println("deleting "+f.getAbsolutePath());
	  if (f.isDirectory()) {
	    for (File c : f.listFiles())
	      deleteRecursive(c);
	  }
	  f.delete();
	}

    public Applet() {
    	
    	String version = System.getProperty("java.version");
    	System.out.println("jre version: "+version);
    	if( versionCompare(version,"1.5") < 0) {
    		JOptionPane.showMessageDialog(null, ""
    				+"You are running an out-of-date version of Java."
    				+"\nWith this current installed version of Java, the program will not be able to allocate enough memory."
    				+"\n"
    				+"\nPlease upgrade your java version."
    				);
        	System.exit(0);
    	}
    	
    	StaticFunctions.binomial(1, 1);
    	System.out.println(""+Gaussian.binomial_as_normal(1001, 500, 0.51));
    	System.out.println(""+Gaussian.binomial_as_normal(1001, 500, 0.52));
    	System.out.println(""+Gaussian.binomial_as_normal(1001, 500, 0.55));


    	mainFrame = new MainFrame();
    	for( int i = 0; i < args.length-1; i++) {
	    	if( args[i].equals("run")) {
				mainFrame.ip.queueInstructionsFromFile(args[i+1]);
	    	}
    	}

    	mainFrame.show();
    }

    
    public int versionCompare(String str1, String str2) {
        String[] vals1 = str1.split("\\.");
        String[] vals2 = str2.split("\\.");
        int i = 0;
        while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i]))  {
          i++;
        }
        if (i < vals1.length && i < vals2.length)  {
            int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
            return Integer.signum(diff);
        } else  {
            return Integer.signum(vals1.length - vals2.length);
        }
    }

}
