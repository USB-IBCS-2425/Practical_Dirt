import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class ImageEditing {
	private JFrame startFrame;
	private JLabel welcomeText;
	public ImageIcon icon;
	public JLabel pixelCol;
	public BufferedImage im;
	public JButton posterButton;
	public JButton resetButton;
	public JButton change;
	public JButton contrastButton;
	public JButton highlightbButton;
	public JButton highlightgButton;
	public JButton highlightrButton;
	public JButton rotateButton;
	public JButton blurButton;
	public JButton edgeButton;
	public JFrame f;
	public JPanel p;
	public JLabel image;
	public JLabel image2;
	public ArrayList<Integer> pixels;
	public ArrayList<Integer> originalImage;
	


	public ImageEditing() {
		startFrame = new JFrame("Image Example");
		startFrame.setSize(400, 400);
		startFrame.setLayout(new BorderLayout());
		startFrame.setVisible(true);
		

		JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        startFrame.add(buttonPanel, BorderLayout.CENTER);


		welcomeText = new JLabel("Welcome to the Image Editor", JLabel.CENTER);
		startFrame.add(welcomeText, BorderLayout.NORTH);


		startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

        
        posterButton = new JButton("poster");
        posterButton.setActionCommand("POSTER");
        posterButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(posterButton);

        resetButton = new JButton("reset");
        resetButton.setActionCommand("RESET");
        resetButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(resetButton);



        change = new JButton("BRIGHTEN");
        change.setActionCommand("CHANGE");
        change.addActionListener(new ButtonClickListener());
        buttonPanel.add(change);

        contrastButton = new JButton("contrast");
        contrastButton.setActionCommand("CONTRAST");
        contrastButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(contrastButton);

        highlightbButton = new JButton("highlight blue");
        highlightbButton.setActionCommand("HIGHLIGHTBLUE");
        highlightbButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(highlightbButton);

        highlightgButton = new JButton("highlight green");
        highlightgButton.setActionCommand("HIGHLIGHTGREEN");
        highlightgButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(highlightgButton);

        highlightrButton = new JButton("highlight red");
        highlightrButton.setActionCommand("HIGHLIGHTRED");
        highlightrButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(highlightrButton);

 

        rotateButton = new JButton("rotate");
        rotateButton.setActionCommand("ROTATE");
        rotateButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(rotateButton);

        blurButton = new JButton("blur");
        blurButton.setActionCommand("BLUR");
        blurButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(blurButton);

        edgeButton = new JButton("edge");
        edgeButton.setActionCommand("EDGE");
        edgeButton.addActionListener(new ButtonClickListener());
        buttonPanel.add(edgeButton);





        icon = new ImageIcon("poster1.jpg");
        try {
        	im = ImageIO.read(new File("poster1.jpg"));
        	
        }
        catch(IOException e) {
        	System.out.println("Error reading image: " + e.getMessage());
        }


        f = new JFrame();
		p = new JPanel();
		image = new JLabel(icon);


		ArrayList<Integer> pixels = new ArrayList<Integer>();
        

	}

	public static void main(String[] args) {
		ImageEditing mWin = new ImageEditing();
	}

	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("POSTER"))  {
				f.add(p);
				p.add(image);
				f.pack();
				f.setVisible(true);

				originalImage = new ArrayList<Integer>();
         		int width = im.getWidth();
         		int height = im.getHeight();
   
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				originalImage.add(rgb);
  					}		
         		}
			}

			if(command.equals("RESET"))  {

				int width = im.getWidth();
         		int height = im.getHeight();
				int k = 0;
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb2 = originalImage.get(k);
         				k++;

         				im.setRGB(i, j, rgb2);
         			}
         		}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();
         	}    

         	if (command.equals("CHANGE")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;
         				r = r + 20;
         				g = g + 20;
         				b = b + 20;
         				if (r > 255) {
         					r = 255;
         				}
         				if (g > 255) {
         					g = 255;
         				}
         				if (b > 255) {
         					b = 255;
         				}
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);
         			}
         		}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();
         	}

         	if (command.equals("CONTRAST")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;

         				int total = r + g + b;
         				if (total / 3 > 127){
         					r = r + 10;
         					g = g + 10;
         					b = b + 10;
         					}

         				if (total / 3 <= 127){
         					r = r - 10;
         					g = g - 10;
         					b = b - 10;
         					}


         				if (r > 255) {
         					r = 255;
         				}
         				if (g > 255) {
         					g = 255;
         				}
         				if (b > 255) {
         					b = 255;
         				}



         				if (r < 0) {
         					r = 0;
         				}
         				if (g < 0) {
         					g = 0;
         				}
         				if (b < 0) {
         					b = 0;
         				}
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);
         			}
         		}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();
         	}

         	if (command.equals("HIGHLIGHTBLUE")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;

         	
         				if (r >= b || g >= b){
         					int total = r + g + b;
         					int average = total / 3;

         					r = average;
         					g = average;
         					b = average;
         				}

         				
       
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);


         			}
         		}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();
         	}

         	if (command.equals("HIGHLIGHTGREEN")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;

         	
         				if (b >= g || r >= g){
         					int total = r + g + b;
         					int average = total / 3;

         					r = average;
         					g = average;
         					b = average;
         				}

         				
       
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);


         			}
         		}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();
         	}

         	if (command.equals("HIGHLIGHTRED")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;

         	
         				if (b >= r || g >= r){
         					int total = r + g + b;
         					int average = total / 3;

         					r = average;
         					g = average;
         					b = average;
         				}

         				
       
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;

         				im.setRGB(i, j, col);


         			}
         		}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();
         	}

         	if (command.equals("ROTATE")) {
         		pixels = new ArrayList<Integer>();
         		int width = im.getWidth();
         		int height = im.getHeight();
         		pixels.clear();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				pixels.add(rgb);
  					}		
         		}

         		int k = 0;
         		for (int i = width - 1; i >= 0; i--) {
         			for (int j = height - 1; j >= 0; j--) {

         				int rgb2 = pixels.get(k);
         				k++;

         				im.setRGB(i, j, rgb2);
         			}
         		
         		icon = new ImageIcon(im);
         		image.setIcon(icon);
         		image.repaint();

         		}

      		} 

      		if (command.equals("BLUR")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         	
      
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int d = 8;

         				int r1 = 0;
	         			int g1 = 0;
	         			int b1 = 0;

	         			int r2 = 0;
	         			int g2 = 0;
	         			int b2 = 0;

         				int r3 = 0;
	         			int g3 = 0;
	         			int b3 = 0;

	         			int r4 = 0;
	         			int g4 = 0;
	         			int b4 = 0;

         				int r5 = 0;
	         			int g5 = 0;
	         			int b5 = 0;

	         			int r6 = 0;
	         			int g6 = 0;
	         			int b6 = 0;
	         			
         				int r7 = 0;
	         			int g7 = 0;
	       				int b7 = 0;

	         			int r8 = 0;
	         			int g8 = 0;
	         			int b8 = 0;


         				if ((i - 1 >= 0) && (j - 1 >= 0) && (i - 1 < width) && (j - 1 < height)){
	         				int rgb = im.getRGB(i - 1,j - 1);
	         				r1 = (rgb & 0x00ff0000) >> 16;
	         				g1 = (rgb & 0x0000ff00) >> 8;
	         				b1 = rgb & 0x000000ff;
	         			}

	         			else{
	         				r1 = 0;
	         				g1 = 0;
	         				b1 = 0;

	         				d = d - 1;
	         			}

	         			if ((i >= 0) && (j - 1 >= 0) && (i < width) && (j - 1 < height)){
	         				int rgb = im.getRGB(i,j - 1);
	         				r2 = (rgb & 0x00ff0000) >> 16;
	         				g2 = (rgb & 0x0000ff00) >> 8;
	         				b2 = rgb & 0x000000ff;
	         			}

	         			else{
	       	         		r2 = 0;
	         				g2 = 0;
	         				b2 = 0;
	         				d = d - 1;
	         			}

	         			if ((i + 1 >= 0) && (j - 1 >= 0) && (i + 1 < width) && (j - 1 < height)){
	         				int rgb = im.getRGB(i + 1,j - 1);
	         				r3 = (rgb & 0x00ff0000) >> 16;
	         				g3 = (rgb & 0x0000ff00) >> 8;
	         				b3 = rgb & 0x000000ff;
	         			}

	         			else{
	         				r3 = 0;
	         				g3 = 0;
	         				b3 = 0;
	         				d = d - 1;
	         			}

	         			if ((i - 1 >= 0) && (j >= 0) && (i - 1 < width) && (j < height)){
	         				int rgb = im.getRGB(i - 1,j);
	         				r4 = (rgb & 0x00ff0000) >> 16;
	         				g4 = (rgb & 0x0000ff00) >> 8;
	         				b4 = rgb & 0x000000ff;
	         			}

	         			else{
	         				d = d - 1;
	         				r4 = 0;
	         				g4 = 0;
	         				b4 = 0;
	         			}

	         			if ((i + 1 >= 0) && (j >= 0) && (i + 1 < width) && (j < height)){
	         				int rgb = im.getRGB(i + 1,j);
	         				r5 = (rgb & 0x00ff0000) >> 16;
	         				g5 = (rgb & 0x0000ff00) >> 8;
	         				b5 = rgb & 0x000000ff;
	         			}

	         			else{
	         				d = d - 1;
	   	         			r5 = 0;
	         				g5 = 0;
	         				b5 = 0;
	         			}


	         			if ((i - 1 >= 0) && (j + 1 >= 0) && (i - 1 < width) && (j + 1 < height)){
	         				int rgb = im.getRGB(i - 1,j + 1);
	         				r6 = (rgb & 0x00ff0000) >> 16;
	         				g6 = (rgb & 0x0000ff00) >> 8;
	         				b6 = rgb & 0x000000ff;
	         			}

	         			else{
	         				d = d - 1;
	         				r6 = 0;
	         				g6 = 0;
	         				b6 = 0;
	         			}

	         			if ((i >= 0) && (j + 1 >= 0) && (i < width) && (j + 1 < height)){
	         				int rgb = im.getRGB(i,j + 1);
	         				r7 = (rgb & 0x00ff0000) >> 16;
	         				g7 = (rgb & 0x0000ff00) >> 8;
	         				b7 = rgb & 0x000000ff;
	         			}

	         			else{
	         				d = d - 1;
	         				r7 = 0;
	         				g7 = 0;
	         				b7 = 0;
	         			}

	         			if ((i + 1 >= 0) && (j + 1 >= 0) && (i + 1 < width) && (j + 1 < height)){
	         				int rgb = im.getRGB(i + 1,j + 1);
	         				r8 = (rgb & 0x00ff0000) >> 16;
	         				g8 = (rgb & 0x0000ff00) >> 8;
	         				b8 = rgb & 0x000000ff;
	         			}


	         			else{
	         				d = d - 1;
	         			    r8 = 0;
	         				g8 = 0;
	         				b8 = 0;
	         			}

	         			int rtotal = (r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8);
	         			int gtotal = (g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8);
	         			int btotal = (b1 + b2 + b3 + b4 + b5 + b6 + b7 + b8); 

	         			int r =  rtotal / d;
	         			int g =  gtotal / d;
	         			int b =  btotal / d;


         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
         				im.setRGB(i, j, col);
       					

       					}

   						icon = new ImageIcon(im);
         				image.setIcon(icon);
         				image.repaint();	
         		


         		}

         	}
      		
      		if (command.equals("EDGE")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         	
      
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int d = 8;

         				int r1 = 0;
	         			int g1 = 0;
	         			int b1 = 0;
	         			int rgb1av = 0;

	         			int r2 = 0;
	         			int g2 = 0;
	         			int b2 = 0;
	         			int rgb2av = 0;


         				int r3 = 0;
	         			int g3 = 0;
	         			int b3 = 0;
	         			int rgb3av = 0;


	         			int r4 = 0;
	         			int g4 = 0;
	         			int b4 = 0;
	         			int rgb4av = 0;


         				int r5 = 0;
	         			int g5 = 0;
	         			int b5 = 0;
	         			int rgb5av = 0;


	         			int r6 = 0;
	         			int g6 = 0;
	         			int b6 = 0;
	         			int rgb6av = 0;

	         			
         				int r7 = 0;
	         			int g7 = 0;
	       				int b7 = 0;
	       				int rgb7av = 0;


	         			int r8 = 0;
	         			int g8 = 0;
	         			int b8 = 0;
	         			int rgb8av = 0;



         				if ((i - 1 >= 0) && (j - 1 >= 0) && (i - 1 < width) && (j - 1 < height)){
	         				int rgb = im.getRGB(i - 1,j - 1);
	         				r1 = (rgb & 0x00ff0000) >> 16;
	         				g1 = (rgb & 0x0000ff00) >> 8;
	         				b1 = rgb & 0x000000ff;

	         				rgb1av = (r1 + g1 + b1) / 3;


	         			}



	         			if ((i >= 0) && (j - 1 >= 0) && (i < width) && (j - 1 < height)){
	         				int rgb = im.getRGB(i,j - 1);
	         				r2 = (rgb & 0x00ff0000) >> 16;
	         				g2 = (rgb & 0x0000ff00) >> 8;
	         				b2 = rgb & 0x000000ff;

	         				rgb2av = (r2 + g2 + b2) / 3;
	         			}


	         			if ((i + 1 >= 0) && (j - 1 >= 0) && (i + 1 < width) && (j - 1 < height)){
	         				int rgb = im.getRGB(i + 1,j - 1);
	         				r3 = (rgb & 0x00ff0000) >> 16;
	         				g3 = (rgb & 0x0000ff00) >> 8;
	         				b3 = rgb & 0x000000ff;

	         				rgb3av = (r3 + g3 + b3) / 3;
	         			}



	         			if ((i - 1 >= 0) && (j >= 0) && (i - 1 < width) && (j < height)){
	         				int rgb = im.getRGB(i - 1,j);
	         				r4 = (rgb & 0x00ff0000) >> 16;
	         				g4 = (rgb & 0x0000ff00) >> 8;
	         				b4 = rgb & 0x000000ff;

	         				rgb4av = (r4 + g4 + b4) / 3;
	         			}

	         			if ((i + 1 >= 0) && (j >= 0) && (i + 1 < width) && (j < height)){
	         				int rgb = im.getRGB(i + 1,j);
	         				r5 = (rgb & 0x00ff0000) >> 16;
	         				g5 = (rgb & 0x0000ff00) >> 8;
	         				b5 = rgb & 0x000000ff;
	         				rgb5av = (r5 + g5 + b5) / 3;
	         			}



	         			if ((i - 1 >= 0) && (j + 1 >= 0) && (i - 1 < width) && (j + 1 < height)){
	         				int rgb = im.getRGB(i - 1,j + 1);
	         				r6 = (rgb & 0x00ff0000) >> 16;
	         				g6 = (rgb & 0x0000ff00) >> 8;
	         				b6 = rgb & 0x000000ff;
	         				rgb6av = (r6 + g6 + b6) / 3;
	         			}



	         			if ((i >= 0) && (j + 1 >= 0) && (i < width) && (j + 1 < height)){
	         				int rgb = im.getRGB(i,j + 1);
	         				r7 = (rgb & 0x00ff0000) >> 16;
	         				g7 = (rgb & 0x0000ff00) >> 8;
	         				b7 = rgb & 0x000000ff;

	         				rgb7av = (r7 + g7 + b7) / 3;
	         			}

	  
	         			if ((i + 1 >= 0) && (j + 1 >= 0) && (i + 1 < width) && (j + 1 < height)){
	         				int rgb = im.getRGB(i + 1,j + 1);
	         				r8 = (rgb & 0x00ff0000) >> 16;
	         				g8 = (rgb & 0x0000ff00) >> 8;
	         				b8 = rgb & 0x000000ff;

	         				rgb8av = (r8 + g8 + b8) / 3;
	         			}

						int rgb = im.getRGB(i,j);
         				int r = (rgb & 0x00ff0000) >> 16;
         				int g = (rgb & 0x0000ff00) >> 8;
         				int b = rgb & 0x000000ff;
         				int rgbav = (r + g + b) / 3;

         				int d1 = Math.abs(rgbav - rgb1av);
         				int d2 = Math.abs(rgbav - rgb2av);
         				int d3 = Math.abs(rgbav - rgb3av);
         				int d4 = Math.abs(rgbav - rgb4av);
         				int d5 = Math.abs(rgbav - rgb5av);
         				int d6 = Math.abs(rgbav - rgb6av);
         				int d7 = Math.abs(rgbav - rgb7av);
         				int d8 = Math.abs(rgbav - rgb8av);

         				

         				if (d1 > 200 || d2 > 200 || d3 > 200 || d4 > 200 || d5 > 200 || d6 > 200 || d7 > 200 || d8 > 200){
         					r = 0;
         					g = 0;
         					b = 0;
         				}

         				else{
                		    r = 255;
         					g = 255;
         					b = 255;

         				}


         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
         				im.setRGB(i, j, col);
       					


       					}

   						icon = new ImageIcon(im);
         				image.setIcon(icon);
         				image.repaint();	
         		


         		}

         	}

       




   		}
    }
}
