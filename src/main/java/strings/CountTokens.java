package strings;

import java.io.*;

public class CountTokens {

  public static void main(String[] args) throws IOException {
    CountTokens ct = new CountTokens();
    if (args.length == 0) {
      System.out.println("File not found");
    }
    /**
     *  This might cause change in GIT
     */
    if (args.length > 0) {
      System.out.println("Input file: " + args[0]);
      ct.countAll(args[0]);
    }

  }

  private void countAll(String inputFile) {

  }
}


/**
 * Another implementation of File
 */
/*import java.util.*;
import java.io.*;
import jpb.*;

public class word
{
	public static void main(String[] args)throws FileNotFoundException
	{
		String filename;
		String words;
		String line;
		String characters;
		int totalCharacters;
		String s;
		int count = 0;
		int countword = 0;
		int countCharacters = 0;
		int vowelCount = 0;

		try{
			Scanner in = new Scanner(System.in);
			System.out.print("Enter name of input file: ");
			Scanner input=new Scanner(new FileReader(in.nextLine()));


			if(!input.hasNext())
			{System.out.println("Aborting due to empty file");
			System.exit(0);}
			while (input.hasNextLine())
			{
				line = input.nextLine();  
				System.out.println(line);
				count++;
				Scanner inLine = new Scanner(line);
				while (inLine.hasNext())
				{
					words = inLine.next();
					System.out.print(words);
					countword++;
				}
				countCharacters += line.length();
				for(int i = 0; i < line.length(); i++) {
					char c = line.charAt(i);
					if ((c == 'a') || (c == 'e') || (c == 'i')|| (c == 'o') || (c == 'u'))
						vowelCount++;
				}	
			}
			System.out.println("Number of words: " + countword);
			System.out.println("Number of lines: " + count);
			System.out.println("Number of sentences: ");
			System.out.println("Number of vowels: " + vowelCount);
			System.out.println("Number of characters: " + countCharacters);
			System.out.println("Number of punctuations: ");


			PrintStream out=new PrintStream(new File("output.txt"));
			out.println("Number of words: " + countword);
			out.println("Number of lines: " + count);
			out.println("Number of sentences: ");
			out.println("Number of vowels: " + vowelCount);
			out.println("Number of characters: " + countCharacters);
			out.println("Number of punctuations: ");
			out.close();
			System.exit(0);}
		catch ( FileNotFoundException e)
		{System.out.println("C:\\ The file you entered either do not exist or the name is spelled wrong.");}

	}
}

*/

//--------------------------------------------------------------------------------------------------


/*
  System.out.println("Please enter the filename: ");
 
    Scanner input = new Scanner(System.in);
    
    String fileName = input.nextLine();
    
     FileReader fReader;
        try {
            fReader = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fReader);
            String cursor; // 
            String content = "";
            int lines = 0;
            int words = 0;
            int chars = 0;
            while((cursor = reader.readLine()) != null){
                // count lines
                lines += 1;
                content += cursor;
                
                // count words
                String []_words = cursor.split(" ");
                for( String w : _words)
                {
                  words++;        
                }
                
            }
            chars = content.length();
            
            System.out.println("File " + fileName + " has ");
            System.out.println(chars + " Characters,");
            System.out.println(words + " words and " + lines + " lines.");
            
            
        } catch (FileNotFoundException ex) {
           // Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File not found!");
        } catch (IOException ex) {
            //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("An error has occured: " + ex.getMessage());
        }
  */