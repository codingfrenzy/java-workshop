import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by prasanthnair on 6/28/15.
 */
public class Process {

    public String folderPath;
    public StringBuilder log = new StringBuilder();

    Process() {
//        folderPath = path;
        folderPath = "files/";
    }

    public void process() throws IOException {
        File folder = new File(folderPath);
        ArrayList<HashSet<String>> contents = new ArrayList<HashSet<String>>();

        for (File fileEntry : folder.listFiles()) {
            HashSet<String> tempHash = new HashSet<String>();
            System.out.println("Loading: " + fileEntry.getName());
            log.append("Loading: " + fileEntry.getName() + "\n");

            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileEntry), "UTF8"));
            String str;

            // get each line in the file
            boolean first = true;
            while ((str = in.readLine()) != null) {
                if (!first)
                    tempHash.add(str.trim());
                first = false;
            }
            contents.add(tempHash);
            System.out.println("Number of entires found: " + tempHash.size());
            log.append("Number of entires found: " + tempHash.size() + "\n");
            in.close();
        }

        System.out.println("Finding common ones....");
        log.append("Finding common ones...." + "\n");

        Iterator<String> it = contents.get(0).iterator();
        ArrayList<String> searchResults = new ArrayList<String>();
        int commonCount = 0;
        while (it.hasNext()) {
            String currentLine = it.next();

            boolean contains = true;
            for (int i = 1; i < contents.size(); i++) {
                if (!contents.get(i).contains(currentLine)) {
                    contains = false;
                    break;
                }
            }

            if (contains) {
                searchResults.add(currentLine);
                commonCount++;
            }
        }

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("results.csv"), "UTF-8");
        BufferedWriter fbw = new BufferedWriter(writer);
        for (int i = 0; i < searchResults.size(); i++) {
            fbw.write(searchResults.get(i));
            fbw.newLine();
        }
        fbw.close();

        System.out.println(commonCount + " results found and written into results.csv");
        log.append(commonCount + " results found and written into results.csv" + "\n");
    }

    public void log() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("log.txt"), "UTF-8");
        BufferedWriter fbw = new BufferedWriter(writer);
        fbw.write(log.toString());
        fbw.newLine();
        fbw.close();
    }

    public static void main(String[] args) {

        Process j = new Process();
        try {
            j.process();
        } catch (IOException e) {
            System.out.println("Something related to files went wrong. Exiting.");
            j.log.append("Something related to files went wrong. Exiting.");
            //e.printStackTrace();
        }
        try {
            j.log();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
