package ui;

import java.awt.Desktop;
import java.io.InputStream;
import java.net.URI;

import javax.swing.*;

import solutions.Gaussian;
import solutions.StaticFunctions;

		
/*
 * 
 * convert shapefile to geojson:
 * for %f in (*.shp) do ogr2ogr -f "GeoJSON" "%~dpnf.json" "%f"
 */


public class Applet extends JApplet {
	public static String open_project = null;
	
    public static void main( String[] args )
	{
		new Applet();
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


    	MainFrame mainFrame = new MainFrame();
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
