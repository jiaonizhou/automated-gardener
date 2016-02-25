package garden;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogManager {
	
	public class GardenLogger {
		private Logger logger;
		private List<String> logs;
		
		public GardenLogger(String name) {
			this.logger = Logger.getLogger(name);
			this.logger.setLevel(Level.ALL);
			FileHandler fh;  

		    try {
		        // This block configure the logger with handler and formatter  
		    	Path currentRelativePath = Paths.get("");
		    	String dir = currentRelativePath.toAbsolutePath().toString();
		        fh = new FileHandler(dir + "/" + name + ".log", 10000000, 1);
		        this.logger.addHandler(fh);
		        SimpleFormatter formatter = new SimpleFormatter();  
		        fh.setFormatter(formatter);
		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
		    
		    logs = new ArrayList<String>();
		}
		
		public void info(String log) {
			logs.add(log);
			logger.info(log);
			
			if (vc != null) {
				vc.refresh();
			}
		}
		
		public String logMessages() {
			String msg = "";
			for (String log : logs) {
				msg += log + "\n";
			}
			return msg;
		}
	}
	
	private static LogManager manager;
	
	private GardenLogger regularLogger;
	private GardenLogger randomLogger;
	private GardenLogger humanLogger;
	
	private LogViewController vc;
		
	public static LogManager getLogManager() {
		if(manager == null) {
			manager = new LogManager();
		}
		return manager;
	}
	
	private LogManager() {
		regularLogger = new GardenLogger("regular");
		randomLogger = new GardenLogger("random");
		humanLogger = new GardenLogger("human"); 
	}
	
	public GardenLogger getRegularLogger() {
		return regularLogger;
	}
	
	public GardenLogger getRandomLogger() {
		return randomLogger;
	}
	
	public GardenLogger getHumanLogger() {
		return humanLogger;
	}
	
	public void setVc(LogViewController vc) {
		this.vc = vc;
	}
	
	public LogViewController getVc() {
		return vc;
	}

}
