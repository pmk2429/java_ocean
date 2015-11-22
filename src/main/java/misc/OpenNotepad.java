package misc;

import java.io.IOException;

/**
 * <h1>getRunTime() method</h1> It is used to get reference of current RunTime
 * object, exec method can be used to execute commands.
 * 
 * <p>
 * You can also specify a file while opening notepad such as
 * exec("notepad programming.txt") where 'programming.txt' is the file you wish
 * to open, if the file doesn't exist in current working directory then a dialog
 * box will be displayed to create file. You can launch other applications using
 * exec method, for example <b>exec("calc")</b> will launch calculator
 * application. If an application is present in a directory which is not set in
 * environment variable PATH then you can specify complete path of application.
 * </p>
 * 
 * <h2>Eg</h2>
 * <p>
 * rs.exec("C:/Program Files/Microsoft Office/Office15/WINWORD.EXE");
 * </p>
 * 
 * @author Pavitra
 *
 */

public class OpenNotepad {
	public static void main(String[] args) {
		Runtime rs = Runtime.getRuntime();

		try {
			rs.exec("C:/Program Files/Microsoft Office/Office15/WINWORD.EXE");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
