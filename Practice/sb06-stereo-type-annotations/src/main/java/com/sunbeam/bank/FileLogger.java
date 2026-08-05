package com.sunbeam.bank;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("file:///D:/Java/java-development/Practice/logInfo.properties")
@Component
public class FileLogger implements Logger {

	//Takes value form "logInfo.properties"
	@Value("${logFile}")
	private String filepath;

	public FileLogger() {
		this.filepath = "app.log";
	}

	@Override
	public void log(String msg) {
		 System.out.println("filepath = [" + filepath + "]");
		try (FileOutputStream out = new FileOutputStream(filepath,true)){

			try (PrintStream prn= new PrintStream(out)){
				System.out.println("FILE => "+msg);
				prn.println(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}