package com.bank;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("file:///D://Java/java-development/Day-03/logInfo.properties")
@Component
public class FileLoggerImpl implements Logger{

	@Value("${logFile}")
	private String filePath;

	public FileLoggerImpl() {
		this.filePath="app.log";
	}

	@Override
	public void log(String message) {

		try (FileOutputStream out = new FileOutputStream(filePath, true))
		{
			try(PrintStream prn = new PrintStream(out)){
				System.out.println("FILE => "+message);
				prn.append(message+"\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
