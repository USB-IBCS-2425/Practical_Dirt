import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

class LitAnalysisLab {
	public JFrame mainframe;
	public JPanel output;
    public JButton readB;
    public JButton avgB;
    public JButton mostcommonwordsB;
    public JButton leastcommonwordsB;
    public JButton longestwordsB;
    public JButton shortestwordsB;
    public JButton mostvowelwordsB;
    public JButton leastvowelwordsB;
    public JButton averagesentenceB;
    public JButton uniquesentenceB;

	public static JTextField toRead;
	public static JTextArea resultT;

    public static ArrayList<String> textTokensOG;
    public static ArrayList<Integer> asterickspos;
	public static ArrayList<String> textTokens;
    public static ArrayList<String> allwords;

    public static HashMap<String, Integer> wordFrequency;
    

	public LitAnalysisLab() {

        textTokensOG = new ArrayList<String>();
		textTokens = new ArrayList<String>();
        allwords = new ArrayList<String>();
        wordFrequency = new HashMap<String, Integer>();

		mainframe = new JFrame("Literature Analysis");
		mainframe.setSize(1700, 600);

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

        readB = new JButton("Read File");
        readB.setActionCommand("READ");
        readB.addActionListener(new ButtonClickListener());
        readB.setBounds(200, 150, 100, 100);
        mainframe.add(readB);

        avgB = new JButton("Average Word");
        avgB.setActionCommand("AVG");
        avgB.addActionListener(new ButtonClickListener());
        avgB.setBounds(300, 150, 100, 100);
        mainframe.add(avgB);

        mostcommonwordsB = new JButton("Find most common words");
        mostcommonwordsB.setActionCommand("MOSTCOMMON");
        mostcommonwordsB.addActionListener(new ButtonClickListener());
        mostcommonwordsB.setBounds(400, 150, 100, 100);
        mainframe.add(mostcommonwordsB);

        leastcommonwordsB = new JButton("Find least common words");
        leastcommonwordsB.setActionCommand("LEASTCOMMON");
        leastcommonwordsB.addActionListener(new ButtonClickListener());
        leastcommonwordsB.setBounds(500, 150, 100, 100);
        mainframe.add(leastcommonwordsB);

        longestwordsB = new JButton("Find longest words");
        longestwordsB.setActionCommand("LONGEST");
        longestwordsB.addActionListener(new ButtonClickListener());
        longestwordsB.setBounds(600, 150, 100, 100);
        mainframe.add(longestwordsB);

        shortestwordsB = new JButton("Find shortest words");
        shortestwordsB.setActionCommand("SHORTEST");
        shortestwordsB.addActionListener(new ButtonClickListener());
        shortestwordsB.setBounds(700, 150, 100, 100);
        mainframe.add(shortestwordsB);

        mostvowelwordsB = new JButton("Find words with most vowels");
        mostvowelwordsB.setActionCommand("MOSTVOWELS");
        mostvowelwordsB.addActionListener(new ButtonClickListener());
        mostvowelwordsB.setBounds(800, 150, 100, 100);
        mainframe.add(mostvowelwordsB);

        leastvowelwordsB = new JButton("Find words with least vowels");
        leastvowelwordsB.setActionCommand("LEASTVOWELS");
        leastvowelwordsB.addActionListener(new ButtonClickListener());
        leastvowelwordsB.setBounds(900, 150, 100, 100);
        mainframe.add(leastvowelwordsB);

        averagesentenceB = new JButton("Find average sentence length");
        averagesentenceB.setActionCommand("AVERAGESENTENCE");
        averagesentenceB.addActionListener(new ButtonClickListener());
        averagesentenceB.setBounds(1000, 150, 100, 100);
        mainframe.add(averagesentenceB);

        uniquesentenceB = new JButton("Find unique sentence");
        uniquesentenceB.setActionCommand("UNIQUE");
        uniquesentenceB.addActionListener(new ButtonClickListener());
        uniquesentenceB.setBounds(1100, 150, 100, 100);
        mainframe.add(uniquesentenceB);









        resultT = new JTextArea("");
        resultT.setBounds(200, 300, 400, 240);
        mainframe.add(resultT);

        mainframe.setVisible(true);
	}

	public static void main(String[] args) {
		LitAnalysisLab fo = new LitAnalysisLab();
        textTokensOG = new ArrayList<>();
        textTokens = new ArrayList<>();
        allwords = new ArrayList<>();
        asterickspos = new ArrayList<>();
        wordFrequency = new HashMap<>();
	}

    public static double round(double x, int places) {
        int mult = (int)Math.pow(10, places);
        int y = (int)(x*mult);
        double rounded = y / (double) mult;
        return rounded;
    }

    public static void readFile() {
        String fname = toRead.getText();
        textTokensOG.clear();

        try {
            File f = new File(fname);
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String data = s.next();
                textTokensOG.add(data);
            }
            s.close();
        }
        catch (FileNotFoundException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }

        

        textTokens.clear();
        System.out.println(textTokensOG);
        for (int i = 0; i < textTokensOG.size(); i++) {
            if (textTokensOG.get(i).contains("***")) {
                asterickspos.add(i);
            }

        }
        System.out.println(asterickspos);
        for (int i = asterickspos.get(1) + 1; i < asterickspos.get(2)  ; i++) {
            textTokens.add(textTokensOG.get(i));

        }


        resultT.setText("File Read\nFile has " + textTokens.size() + " tokens");
    }

    public static void parseWords() {
        allwords.clear();
        for (int i = 0; i < textTokens.size(); i++) {
            String[] tempWords = textTokens.get(i).split("\\s|-");
            // regex modified to split by single dash 

            for (String s : tempWords) {
                s = s.replaceAll("[\\p{P}_]", "");
                s = s.toLowerCase();
                allwords.add(s);
            }
        }

        wordFrequency.clear();
        for (String i : allwords){
            if (wordFrequency.containsKey(i) == false){
                wordFrequency.put(i, 1);
            }

            else{
                int freq = wordFrequency.get(i);
                wordFrequency.put(i, freq + 1);
            }

        }
    }

    public static void showAvg() {
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
    

    public static void mostCommonWords() {
        ArrayList<String> common = new ArrayList<String>();
        String commonword = "";
        int maxfreq = 0;  

        for (String word : wordFrequency.keySet()){
            if(wordFrequency.get(word) > maxfreq){
                commonword = word;
                maxfreq = wordFrequency.get(word);
            }
        }

        for (String word : wordFrequency.keySet()){
            if (wordFrequency.get(word) == wordFrequency.get(commonword)){
                common.add(word);
            }
        }

        String res = "The most common word or words are:\n";
        for (String word : common) {
            res += word + "\n";
        }
        resultT.setText(res);
    }

    public static void leastCommonWords() {
        ArrayList<String> rare = new ArrayList<String>();
        String rareword = "";
        int minfreq = Integer.MAX_VALUE;

        for (String word : wordFrequency.keySet()){
            if(wordFrequency.get(word) < minfreq){
                rareword = word;
                minfreq = wordFrequency.get(word);
            }
        }

        for (String word : wordFrequency.keySet()){
            if (wordFrequency.get(word) == wordFrequency.get(rareword)){
                rare.add(word);
            }
        }

        String res = "The least common word or words are:\n";
        for (String word : rare) {
            res += word + "\n";
        }
        resultT.setText(res);
    }

    public static void longestwords(){
        ArrayList<String> longwords = new ArrayList<String>();
        String longestword = "";
        int maxlength = 0;
        for (String word : wordFrequency.keySet()){
            if (word.length() > maxlength){
                longestword = word;
                maxlength = word.length();
            }

        }

        for (String word : wordFrequency.keySet()){
            if (word.length() == longestword.length()){
                longwords.add(word);
            }

        }

        String res = "The longest words or words are:\n";
        for (String word : longwords) {
            res += word + "\n";
        }
        resultT.setText(res);
    }

    public static void shortestwords(){
        ArrayList<String> shortwords = new ArrayList<String>();
        String shortestword = "";
        int minlength = Integer.MAX_VALUE;
        for (String word : wordFrequency.keySet()){
            if (word.length() < minlength && word.length() > 0){
                minlength = word.length();
                shortestword = word;
                System.out.println(minlength);
                System.out.println(shortestword);


            }

        }
        System.out.println(minlength);
        System.out.println(shortestword);

        for (String word : wordFrequency.keySet()){
            if (word.length() == shortestword.length()){
                shortwords.add(word);
            }

        }

        String res = "The shortest words or words are:\n";
        for (String word : shortwords) {
            res += word + "\n";
        }
        resultT.setText(res);
    }

    public static void mostVowels(){
        ArrayList<String> mostvowelwords = new ArrayList<String>();
        int max = 0;
    
        for (String word : wordFrequency.keySet()){
            int vowelcount = 0;
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || 
                    word.charAt(i) == 'o' || word.charAt(i) == 'u'){

                    vowelcount++;
                }
            }

            if (vowelcount > max){
                max = vowelcount;
            }
        }

        for (String word : wordFrequency.keySet()){
            int vowelcount = 0;
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || 
                    word.charAt(i) == 'o' || word.charAt(i) == 'u'){

                    vowelcount++;
                }
            }

            if (vowelcount == max){
                mostvowelwords.add(word);
                
            }
        }

        String res = "The words with the most vowels are:\n";
        for (String word : mostvowelwords) {
            res += word + "\n";
        }
        resultT.setText(res);
    }

    public static void leastVowels(){
        ArrayList<String> leastvowelwords = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
    
        for (String word : wordFrequency.keySet()){
            int vowelcount = 0;
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || 
                    word.charAt(i) == 'o' || word.charAt(i) == 'u'){

                    vowelcount++;
                }
            }

            if (vowelcount < min){
                min = vowelcount;
            }
        }

        for (String word : wordFrequency.keySet()){
            int vowelcount = 0;
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || 
                    word.charAt(i) == 'o' || word.charAt(i) == 'u'){

                    vowelcount++;
                }
            }

            if (vowelcount == min){
                leastvowelwords.add(word);
                
            }
        }

        String res = "The words with the least vowels are:\n";
        for (String word : leastvowelwords) {
            res += word + "\n";
        }
        resultT.setText(res);
    }    

    public static void averageSentence() {
        ArrayList<Integer> sentencelengths = new ArrayList<Integer>();
        int currentsenlength = 0;
        for (String word : textTokens){
          currentsenlength++;
          if(word.charAt(word.length() - 1) == '.' || word.charAt(word.length() - 1) == '?' || 
             word.charAt(word.length() - 1) == '!'){
            sentencelengths.add(currentsenlength);
            currentsenlength = 0;
          } 
        }
        int total = 0;
        int average = 0;
        for (int i : sentencelengths){
            total = total + i;
        }

        average = total / sentencelengths.size();
        String res = "The average sentence length is" + average + "words";
        resultT.setText(res);
    }
    public static void uniqueSentence() {
        ArrayList<ArrayList<String>> sentences = new ArrayList<>();
        ArrayList<String> currentSentence = new ArrayList<>();
        int minUniquenessScore = Integer.MAX_VALUE;
        ArrayList<String> mostUniqueSentence = new ArrayList<>();

        
        for (String word : textTokens) {
            currentSentence.add(word);
    
            if (word.endsWith(".") || word.endsWith("?") || word.endsWith("!")) {

                ArrayList<String> sentenceCopy = new ArrayList<>(currentSentence);

                if (sentenceCopy.size() > 8){
                    sentences.add(sentenceCopy);
                }
                
                currentSentence.clear();
            }
        }

        // Find the most unique sentence
        for (ArrayList<String> sentence : sentences) {
            int uniquenessScore = 0;

            for (String word : sentence) {


                String cleanWord = word.replaceAll("[\\p{P}_]", "").toLowerCase();
            
                uniquenessScore += wordFrequency.getOrDefault(cleanWord, 0);
            }

            
            if (uniquenessScore < minUniquenessScore) {
                minUniquenessScore = uniquenessScore;
                mostUniqueSentence = sentence;
            }
        }


        String res = "The most unique sentence is:\n";
        for (String word : mostUniqueSentence) {
            res += word + " ";
        }
        resultT.setText(res);
    }




	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("READ")) {
                readFile();
                parseWords();
            }

            if (command.equals("AVG")) {
                showAvg();
            }

            if (command.equals("MOSTCOMMON")) {

                mostCommonWords();
            }

            if (command.equals("LEASTCOMMON")) {

                leastCommonWords();
            }

            if (command.equals("LONGEST")) {

                longestwords();
            }

            if (command.equals("SHORTEST")) {

                shortestwords();
            }

            if (command.equals("MOSTVOWELS")) {

                mostVowels();
            }

            if (command.equals("LEASTVOWELS")) {

                leastVowels();
            }

            if (command.equals("AVERAGESENTENCE")) {

                averageSentence();
            }

            if (command.equals("UNIQUE")) {

                uniqueSentence();
            }



        }
    }
}