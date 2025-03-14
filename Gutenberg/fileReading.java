import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class FileReading2 {
    public JFrame mainframe;
    public JPanel output;
    public JTextField toRead;
    public JButton readB;
    public JButton writeB;
    public JButton commonB;
    public JButton rareB;
    public JLabel readingT;
    public JTextArea resultT;
    public ArrayList<String> words;
    public ArrayList<String> allwords;
    public HashMap<String, Integer> wordfreq;
    public ArrayList<String> commonwords;
    public ArrayList<String> rarewords;

    public JButton analysB;

    public FileReading2() {

        words = new ArrayList<String>();
        allwords = new ArrayList<String>();
        wordfreq = new HashMap<String, Integer>();

        mainframe = new JFrame("File Reading example");
        mainframe.setSize(1000, 1000);

        mainframe.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

        toRead = new JTextField("sample.txt");
        toRead.setBounds(300, 50, 200, 40);
        mainframe.setLayout(null);
        mainframe.add(toRead);

        output = new JPanel();
        output.setBounds(200, 250, 100, 40);
        mainframe.add(output);

        readB = new JButton("Read the file");
        readB.setActionCommand("READ");
        readB.addActionListener(new ButtonClickListener());
        readB.setBounds(200, 150, 100, 100);
        mainframe.add(readB);

        analysB = new JButton("STATS");
        analysB.setActionCommand("ANALYZE");
        analysB.addActionListener(new ButtonClickListener());
        analysB.setBounds(340, 150, 100, 100);
        mainframe.add(analysB);

        writeB = new JButton("Write to the file");
        writeB.setActionCommand("WRITE");
        writeB.addActionListener(new ButtonClickListener());
        writeB.setBounds(480, 150, 100, 100);
        mainframe.add(writeB);


        commonB = new JButton("find most common words");
        commonB.setActionCommand("MOST");
        commonB.addActionListener(new ButtonClickListener());
        commonB.setBounds(620, 150, 100, 100);
        mainframe.add(commonB);

        rareB = new JButton("find rarest words");
        rareB.setActionCommand("LEAST");
        rareB.addActionListener(new ButtonClickListener());
        rareB.setBounds(760, 150, 100, 100);
        mainframe.add(rareB);







        readingT = new JLabel("");
        output.add(readingT);

        resultT = new JTextArea("");
        resultT.setBounds(200, 300, 400, 240);
        mainframe.add(resultT);

        mainframe.setVisible(true);
    }

    public static void main(String[] args) {
        FileReading2 fo = new FileReading2();
    }

    public static double round(double x, int places) {
        // multiply your number by the power of ten given
        // your desired decimal places
        int mult = (int)Math.pow(10, places);
        int y = (int)(x*mult);
        // divide with double
        return y / (double) mult;
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("WRITE")) {
                String fname = toRead.getText();
                String toWrite = resultT.getText();

                try {
                    // File Writing in a try catch
                    FileWriter w = new FileWriter(fname);
                    w.write(toWrite);
                    w.close();
                }
                catch (IOException er) {
                    System.out.println("Error message:");
                    er.printStackTrace();
                }
            }

            if (command.equals("READ")) {
                String fname = toRead.getText();

                words.clear();

                try {

                    File f = new File(fname);
                    Scanner s = new Scanner(f);
                    while (s.hasNext()) {
                        String data = s.next();
                        words.add(data);
                    }
                    s.close();

                }
                catch (FileNotFoundException err) {
                    System.out.println("An error occurred.");
                    err.printStackTrace();

                }

                String toDisplay = "";
                for (int i = 0; i < words.size(); i++) {
                    toDisplay = toDisplay + "\n" + words.get(i);
                }
                resultT.setText("File size is " + words.size() + " lines");
                readingT.setText("Reading...");
                resultT.setText(resultT.getText() + "\n" + toDisplay);
            }
            //STATS
            if (command.equals("ANALYZE")) {
                allwords.clear();
                for (int i = 0; i < words.size(); i++) {
                    String[] tempWords = words.get(i).split("[,\\.\\s]");
                    for (String s : tempWords) {
                        allwords.add(s);
                    }
                }
                
                double totLen = 0;
                for (String w : allwords) {
                    totLen = totLen + w.length();
                }
                double avgLen = totLen / allwords.size();
                avgLen = round(avgLen, 2);
                String res = "The average word length is:\n";
                res = res + avgLen + " characters";
                resultT.setText(res);
            }


            //most common word
            if (command.equals("MOST")) {
                wordfreq.clear();
                for (int i = 0; i < words.size(); i++) {
                    String[] tempWords = words.get(i).split("[,\\.\\s]");
                    for (String s : tempWords) {
                        if(wordfreq.containsKey(s) == false){
                            wordfreq.put(s, 1);
                        }

                        else {
                            int freq = wordfreq.get("s");
                            freq = freq + 1;
                            wordfreq.replace(s, freq);
                        }
                    }

                } 

                Set<String> words2 = myMap.valueSet();
                String [] wordsarray = words2.toArray();
                max = wordsarray[0];
                String commonword = " ";


                for (String s : wordsarray) {
                    if (wordfreq.get(s) > max){
                        commonword = s;
                    }
                }

                commonwords.add(commonword);
                for (String s : wordsarray) {
                    if (wordfreq.get(s) = wordfreq.get(commonword)){
                        commonwords.add(s);
                    }
                }

            }


            if (command.equals("LEAST")) {
                wordfreq.clear();
                for (int i = 0; i < words.size(); i++) {
                    String[] tempWords = words.get(i).split("[,\\.\\s]");
                    for (String s : tempWords) {
                        if(wordfreq.containsKey(s) == false){
                            wordfreq.put(s, 1);
                        }

                        else {
                            int freq = wordfreq.get("s");
                            freq = freq + 1;
                            wordfreq.replace(s, freq);
                        }
                    }

                } 

                Set<String> words2 = myMap.valueSet();
                String[] wordsarray = words2.toArray();
                min = wordsarray[0];
                String rarewordword = " ";


                for (String s : wordsarray) {
                    if (wordfreq.get(s) < min){
                        rareword = s;
                    }
                }

                commonwords.add(commonword);
                for (String s : wordsarray) {
                    if (wordfreq.get(s) = wordfreq.get(commonword)){
                        commonwords.add(s);
                    }
                }

            }
        }
    }
}