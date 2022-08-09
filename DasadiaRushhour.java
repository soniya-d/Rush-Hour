//Name: Soniya Dasadia
//Date: november 19, 2021
//Purpose: Boat rush hour

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class DasadiaRushhour extends JPanel implements ActionListener
{

	Panel p_card;  //to hold all of the screens
	Panel card1, card2, card3, card4, card5;
	CardLayout cdLayout = new CardLayout ();

	//grid
	int row = 6;
	int col = 6;

	//current Car information
	JLabel currentPic;
	int whichCar = 0;
	int curX = 2;
	int curY = 1;
	JButton a[] = new JButton [row * col];
	int number = 1;

	//initial board
	char type[] [] = {{'c', 'c', 'c', 'n', 'n', 'n'},
			{'c', 'n', 'n', 'c', 'n', 'n'},
			{'c', 'c', 'c', 'c', 'n', 'x'},
			{'c', 'n', 'n', 'c', 'n', 'n'},
			{'c', 'c', 'c', 'n', 'n', 'c'},
			{'n', 'n', 'c', 'c', 'c', 'c'}};

	int car[] [] = {{8, 2, 2, 0, 0, 0},
			{8, 0, 0, 9, 0, 0},
			{8, 0, 0, 9, 0, 0},
			{6, 0, 0, 9, 0, 0},
			{6, 1, 1, 0, 0, 5},
			{0, 0, 4, 4, 4, 5}};

	char slice[] [] = {{'f', 'f', 'b', 'n', 'n', 'n'},
			{'m', 'n', 'n', 'f', 'n', 'n'},
			{'b', 'f', 'b', 'm', 'n', 'n'},
			{'f', 'n', 'n', 'b', 'n', 'n'},
			{'b', 'f', 'b', 'n', 'n', 'f'},
			{'n', 'n', 'f', 'm', 'b', 'b'}};

	//level 1 - a copy of the initial board set up
	char type1[] [] = {{'c', 'c', 'c', 'n', 'n', 'n'},
			{'c', 'n', 'n', 'c', 'n', 'n'},
			{'c', 'c', 'c', 'c', 'n', 'x'},
			{'c', 'n', 'n', 'c', 'n', 'n'},
			{'c', 'c', 'c', 'n', 'n', 'c'},
			{'n', 'n', 'c', 'c', 'c', 'c'}};

	int car1[] [] = {{8, 2, 2, 0, 0, 0},
			{8, 0, 0, 9, 0, 0},
			{8, 0, 0, 9, 0, 0},
			{6, 0, 0, 9, 0, 0},
			{6, 1, 1, 0, 0, 5},
			{0, 0, 4, 4, 4, 5}};

	char slice1[] [] = {{'f', 'f', 'b', 'n', 'n', 'n'},
			{'m', 'n', 'n', 'f', 'n', 'n'},
			{'b', 'f', 'b', 'm', 'n', 'n'},
			{'f', 'n', 'n', 'b', 'n', 'n'},
			{'b', 'f', 'b', 'n', 'n', 'f'},
			{'n', 'n', 'f', 'm', 'b', 'b'}};

	//level 2
	char type2[] [] = {{'c', 'c', 'c', 'n', 'n', 'n'},
			{'n', 'n', 'n', 'c', 'n', 'n'},
			{'c', 'c', 'n', 'c', 'n', 'x'},
			{'n', 'n', 'c', 'n', 'c', 'c'},
			{'c', 'n', 'c', 'c', 'c', 'c'},
			{'c', 'n', 'c', 'n', 'n', 'n'}};

	int car2[] [] = {{3, 3, 3, 0, 0, 0},
			{0, 0, 0, 5, 0, 0},
			{0, 0, 0, 5, 0, 0},
			{0, 0, 8, 0, 2, 2},
			{6, 0, 8, 4, 4, 4},
			{6, 0, 8, 0, 0, 0}};

	char slice2[] [] = {{'f', 'm', 'b', 'n', 'n', 'n'},
			{'n', 'n', 'n', 'f', 'n', 'n'},
			{'f', 'b', 'n', 'b', 'n', 'n'},
			{'n', 'n', 'f', 'n', 'f', 'b'},
			{'f', 'n', 'm', 'f', 'm', 'b'},
			{'b', 'n', 'b', 'n', 'n', 'n'}};

	//level 3
	char type3[] [] = {{'n', 'n', 'c', 'c', 'c', 'c'},
			{'n', 'n', 'c', 'c', 'n', 'n'},
			{'c', 'c', 'c', 'n', 'n', 'x'},
			{'n', 'n', 'c', 'c', 'c', 'n'},
			{'n', 'n', 'n', 'n', 'n', 'c'},
			{'n', 'n', 'n', 'n', 'n', 'c'}};

	int car3[] [] = {{0, 0, 9, 7, 0, 0},
			{0, 0, 9, 7, 0, 0},
			{0, 0, 9, 0, 0, 0},
			{0, 0, 3, 3, 3, 0},
			{0, 0, 0, 0, 0, 6},
			{0, 0, 0, 0, 0, 6}};

	char slice3[] [] = {{'n', 'n', 'f', 'f', 'f', 'b'},
			{'n', 'n', 'm', 'b', 'n', 'n'},
			{'f', 'b', 'b', 'n', 'n', 'n'},
			{'n', 'n', 'f', 'm', 'b', 'n'},
			{'n', 'n', 'n', 'n', 'n', 'f'},
			{'n', 'n', 'n', 'n', 'n', 'b'}};

	//level 4
	char type4[] [] = {{'n', 'n', 'c', 'c', 'c', 'n'},
			{'n', 'n', 'n', 'n', 'c', 'n'},
			{'n', 'n', 'c', 'c', 'c', 'x'},
			{'n', 'n', 'c', 'c', 'c', 'n'},
			{'n', 'n', 'c', 'n', 'n', 'n'},
			{'n', 'n', 'c', 'n', 'n', 'n'}};

	int car4[] [] = {{0, 0, 2, 2, 8, 0},
			{0, 0, 0, 0, 8, 0},
			{0, 0, 0, 0, 8, 0},
			{0, 0, 9, 1, 1, 0},
			{0, 0, 9, 0, 0, 0},
			{0, 0, 9, 0, 0, 0}};

	char slice4[] [] = {{'n', 'n', 'f', 'b', 'f', 'n'},
			{'n', 'n', 'n', 'n', 'm', 'n'},
			{'n', 'n', 'f', 'b', 'b', 'n'},
			{'n', 'n', 'f', 'f', 'b', 'n'},
			{'n', 'n', 'm', 'n', 'n', 'n'},
			{'n', 'n', 'b', 'n', 'n', 'n'}};

	//level 5
	char type5[] [] = {{'n', 'c', 'c', 'c', 'c', 'n'},
			{'n', 'n', 'n', 'n', 'c', 'n'},
			{'c', 'c', 'c', 'c', 'c', 'x'},
			{'c', 'n', 'c', 'c', 'c', 'c'},
			{'c', 'n', 'n', 'n', 'n', 'n'},
			{'c', 'c', 'c', 'c', 'n', 'n'}};

	int car5[] [] = {{0, 3, 3, 3, 9, 0},
			{0, 0, 0, 0, 9, 0},
			{0, 0, 5, 6, 9, 0},
			{8, 0, 5, 6, 1, 1},
			{8, 0, 0, 0, 0, 0},
			{8, 4, 4, 4, 0, 0}};

	char slice5[] [] = {{'n', 'f', 'm', 'b', 'f', 'n'},
			{'n', 'n', 'n', 'n', 'm', 'n'},
			{'f', 'b', 'f', 'f', 'b', 'n'},
			{'f', 'n', 'b', 'b', 'f', 'b'},
			{'m', 'n', 'n', 'n', 'n', 'n'},
			{'b', 'f', 'm', 'b', 'n', 'n'}};

	//display status on gamescreen
	JLabel status;

	//set up screen order
	public DasadiaRushhour ()
	{
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		//make the 4 screens
		initOpening ();
		initRules ();
		initGame ();
		screen4 ();
		screen5 ();
		setLayout (new BorderLayout ());
		initMenu (); 
		add ("Center", p_card);
	}

	//menu bar set up
	public void initMenu ()
	{
		JMenuBar menuBar = new JMenuBar ();
		JMenu menu;
		JMenuItem menuItem;

		menu = new JMenu ("File");
		menuBar.add (menu);

		menuItem = new JMenuItem ("Close");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("Close");
		menu.add (menuItem);

		menu = new JMenu ("Navigate");
		menuBar.add (menu);

		menuItem = new JMenuItem ("Opening");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("s1");
		menu.add (menuItem);

		menuItem = new JMenuItem ("Rules");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("s2");
		menu.add (menuItem);

		menuItem = new JMenuItem ("Play Game");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("s3");
		menu.add (menuItem);
		add ("North", menuBar);
	}

	//opening screen
	public void initOpening ()
	{ //Pre: p_card is a cdLayout, card1 is declared
		//Post: initializes opening screen's widgets.
		card1 = new Panel ();
		card1.setBackground(new Color(94, 224, 253));
		//title of game
		JLabel pic = new JLabel (createImageIcon("intro2.png"));
		add (pic);
		//move on to next screen
		JButton next = new JButton ("Next");
		next.setForeground (new Color(255, 222, 89));
		next.setPreferredSize (new Dimension (170, 50));
		next.setFont (new Font ("BUNGEE", Font.BOLD, 40));
		next.setActionCommand ("s2");
		next.addActionListener (this);
		card1.add (pic);
		card1.add (next);
		p_card.add ("1", card1);
	}

	//instruction screen
	public void initRules ()
	{ //Pre: p_card is a cdLayout, card1 is declared
		//Post: initializes opening screen's widgets.
		card2 = new Panel ();
		//background color
		card2.setBackground(new Color(94, 224, 253));
		//instructions picture
		JLabel pic = new JLabel (createImageIcon("howtoplay.png"));
		add (pic);
		//next button
		JButton next = new JButton ("Next");
		next.setForeground (new Color(255, 222, 89));		
		next.setPreferredSize (new Dimension (170, 50));
		next.setFont (new Font ("BUNGEE", Font.BOLD, 40));
		next.setActionCommand ("s3");
		next.addActionListener (this);
		card2.add (pic);
		card2.add (next);
		p_card.add ("2", card2);
	}

	//gamescreen
	public void initGame ()
	{ //Pre: p_card is a cdLayout, card1 is declared
		//Post: initializes opening screen's widgets.
		//screen 3 is set up.
		card3 = new Panel ();
		card3.setBackground(new Color(94, 224, 253));
		JLabel pic = new JLabel (createImageIcon("RUSH HOUR!.png"));
		add (pic);
		JButton next = new JButton ("Next");
		next.setActionCommand ("s4");
		next.addActionListener (this);
		//turn status
		currentPic = new JLabel (createImageIcon ("little0.png"));
		//movement buttons
		JButton up = new JButton ("Up");
		up.setActionCommand ("up");
		up.addActionListener (this);
		JButton down = new JButton ("Down");
		down.setActionCommand ("down");
		down.addActionListener (this);
		JButton right = new JButton ("Right");
		right.setActionCommand ("right");
		right.addActionListener (this);
		JButton left = new JButton ("Left");
		left.setActionCommand ("left");
		left.addActionListener (this);
		JButton nextLevel = new JButton ("Next Level");
		nextLevel.setActionCommand("nextLevel");
		nextLevel.addActionListener(this);
		JButton reset = new JButton ("Reset");
		reset.setActionCommand("Reset");
		reset.addActionListener(this);
		//Instructions button
		JButton Instructions = new JButton ("Instructions");
		Instructions.setActionCommand("instructions");
		Instructions.setFont (new Font ("BUNGEE", Font.BOLD, 15));
		Instructions.addActionListener(this);
		//save progress button
		JButton save = new JButton ("Save");
		save.setActionCommand("save");
		save.setFont (new Font ("BUNGEE", Font.BOLD, 15));
		save.addActionListener(this);
		//open progress button
		JButton open = new JButton ("open");
		open.setActionCommand("open");
		open.setFont (new Font ("BUNGEE", Font.BOLD, 15));
		open.addActionListener(this);
		//boat/movement status
		status = new JLabel ("Status: ");
		status.setFont (new Font ("BUNGEE", Font.BOLD, 15));
		status.setForeground (Color.white);

		//Set up grid
		Panel p = new Panel (new GridLayout (row, col));
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				//add in when you have pictures
				a [move] = new JButton (createImageIcon (type [i] [j] + "" + car [i] [j] + "" + slice [i] [j] + ".png"));
				//change to be your size
				a [move].setPreferredSize (new Dimension (77, 77));
				a [move].addActionListener (this);
				a [move].setActionCommand ("" + move);
				p.add (a [move]);
				move++;
			}
		}

		card3.add (pic);
		card3.add (next);
		card3.add (nextLevel);
		card3.add (reset);
		card3.add (status);
		card3.add (currentPic);
		card3.add (p);
		card3.add(Instructions);
		card3.add(save);
		card3.add(open);
//layout code
		Panel dir = new Panel (new GridLayout (2, 3));
		JLabel filler = new JLabel ("");
		JLabel filler2 = new JLabel ("");
		dir.add (filler);
		dir.add (up);
		dir.add (filler2);
		dir.add (left);
		dir.add (down);
		dir.add (right);
		card3.add (dir);
		p_card.add ("3", card3);
	}
	//game screen tour
	public void Instructions ()
	{
		JOptionPane.showMessageDialog (null, createImageIcon ("instructions.png"), "Game screen tour!", JOptionPane.INFORMATION_MESSAGE);
	}

	//win screen
	public void screen4 ()
	{ //screen 4 is set up.
		card4 = new Panel ();
		card4.setBackground(new Color(94, 224, 253));
		//winscreen picture
		JLabel pic = new JLabel (createImageIcon("WINSCREEN.png"));
		add (pic);
		//move on to next screen
		JButton next = new JButton ("Next");
		next.setForeground (new Color(255, 222, 89));
		next.setPreferredSize (new Dimension (170, 50));
		next.setFont (new Font ("BUNGEE", Font.BOLD, 40));
		next.setForeground(new Color(94, 224, 253));
		next.setActionCommand ("s5");
		next.addActionListener (this);
		card4.add (pic);
		card4.add (next);
		p_card.add ("4", card4);
	}

	//lose screen
	public void screen5 ()
	{ //screen 5 is set up.
		card5 = new Panel ();
		card5.setBackground(new Color(94, 224, 253));
		JLabel pic = new JLabel (createImageIcon("losescreen.png"));
		add (pic);
		// back to screen 1
		JButton next = new JButton ("Back to Introduction?");
		next.setPreferredSize (new Dimension (180, 40));
		next.setFont (new Font ("BUNGEE", Font.BOLD, 15));
		next.setActionCommand ("s1");
		next.addActionListener (this);
		//close game button
		JButton end = new JButton ("Quit?");
		end.setActionCommand ("s6");
		end.addActionListener (this);
		card5.add (pic);
		card5.add (next);
		card5.add (end);
		p_card.add ("5", card5);
	}

	protected static ImageIcon createImageIcon (String path)
	{ //change the red to your class name
		java.net.URL imgURL = DasadiaRushhour.class.getResource (path);
		if (imgURL != null)
		{
			return new ImageIcon (imgURL);
		}
		else
		{
			System.err.println ("Couldn't find file: " + path);
			return null;
		}

	}

	public static void main (String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated (true);
		//Create and set up the window.
		JFrame frame = new JFrame ("DasadiaRushhour");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//Create and set up the content pane.
		JComponent newContentPane = new DasadiaRushhour ();
		newContentPane.setOpaque (true);
		frame.setContentPane (newContentPane);
		frame.setSize (520, 720);
		frame.setVisible (true);
		Date now = new Date ();
		DateFormat df = DateFormat.getDateInstance ();
		String s = df.format (now);
		System.out.println ("Today is " + s);


	}

	//save code for gamescreen
	public void printOut () {
		PrintWriter out;
		try {
			out = new PrintWriter (new FileWriter ("rushhour.txt"));
			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{

					out.println(car[i][j]);
				}
			}
			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{

					out.println(slice[i][j]);
				}
			}
			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{

					out.println(type[i][j]);
				}
			}
			out.close ();
		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e);
		}
	}

	//open code for game screen
	public void readIn () {
		BufferedReader in;
		try {
			in = new BufferedReader (new FileReader ("rushhour.txt"));
			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{

					car[i][j] = Integer.parseInt(in.readLine());
				}
			}
			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{

					slice[i][j] = in.readLine().charAt(0);				
				}
			}

			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{

					type[i][j] = in.readLine().charAt(0);			
				}
			}

			in.close ();

		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e);
		}
	}

	//redraw grid
	public void redraw ()
	{
		if (type [2] [5] != 'c')
			type [2] [5] = 'x';
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [move].setIcon (createImageIcon (type [i] [j] + "" + car [i] [j] + "" + slice [i] [j] + ".png"));
				move++;
			}
		}
	}


	public void copyOver (int a[] [], int b [] [])
	{
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [i] [j] = b [i] [j];
			}
		}
	}

	public void copyOver (char a[] [], char b [] [])
	{
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [i] [j] = b [i] [j];
			}
		}
	}


	//next level
	public void next ()
	{
		number++;

		if (number == 2)
		{
			copyOver (type, type2);
			copyOver (car, car2);
			copyOver (slice, slice2);
		}
		else if (number == 3)
		{
			copyOver (type, type3);
			copyOver (car, car3);
			copyOver (slice, slice3);
		}
		else if (number == 4)
		{
			copyOver (type, type4);
			copyOver (car, car4);
			copyOver (slice, slice4);
		}
		else if (number == 5)
		{
			copyOver (type, type5);
			copyOver (car, car5);
			copyOver (slice, slice5);
		}
		else 
		{
			copyOver (type, type1);
			copyOver (car, car1);
			copyOver (slice, slice1);
		}
		redraw ();
		whichCar = 0;
		curX = 2;
		curY = 1;
		currentPic.setIcon(createImageIcon("little0.png"));
	}
	//resets grid 
	public void reset ()
	{

		if (number == 1)
		{
			copyOver (type, type1);
			copyOver (car, car1);
			copyOver (slice, slice1);
		}
		else if (number == 2)
		{
			copyOver (type, type2);
			copyOver (car, car2);
			copyOver (slice, slice2);
		}
		else if (number == 3)
		{
			copyOver (type, type3);
			copyOver (car, car3);
			copyOver (slice, slice3);
		}
		else if (number == 4)
		{
			copyOver (type, type4);
			copyOver (car, car4);
			copyOver (slice, slice4);
		}
		else if (number == 5)
		{
			copyOver (type, type5);
			copyOver (car, car5);
			copyOver (slice, slice5);
		}
		else 
		{
			copyOver (type, type1);
			copyOver (car, car1);
			copyOver (slice, slice1);
		}
		redraw ();
		whichCar = 0;
		curX = 2;
		curY = 1;
		currentPic.setIcon(createImageIcon("little0.png"));
	}

	//choose car
	public void findFront (int x, int y)
	{
		if (slice [x] [y] == 'f')
		{
			curX = x;
			curY = y;
		}
		//2 piece cars, go left-right
		else if (whichCar <= 2 && slice [x] [y] == 'b')
		{
			curX = x;
			curY = y - 1;
		}
		//3 piece trucks, go left-right
		else if (whichCar <= 4 && slice [x] [y] == 'm')
		{
			curX = x;
			curY = y - 1;
		}
		else if (whichCar <= 4 && slice [x] [y] == 'b')
		{
			curX = x;
			curY = y - 2;
		}
		//2 piece cars, go up-down
		else if (whichCar <= 7 && slice [x] [y] == 'b')
		{
			curX = x - 1;
			curY = y;
		}
		//3 piece trucks, go up-down
		else if (whichCar <= 9 && slice [x] [y] == 'm')
		{
			curX = x - 1;
			curY = y;
		}
		else if (whichCar <= 9 && slice [x] [y] == 'b')
		{
			curX = x - 2;
			curY = y;
		}
	}

	//move up button
	public void moveUp ()
	{
		if (whichCar <= 4)
			status.setText ("Can't move up or down");
		else if (curX - 1 >= 0 && slice [curX - 1] [curY] != 'n')
			status.setText ("There is a car there!");
		//2 piece cars, go up-down
		else if (whichCar <= 7 && curX - 1 >= 0)
		{
			type [curX - 1] [curY] = 'c';
			type [curX] [curY] = 'c';
			type [curX + 1] [curY] = 'n';

			slice [curX - 1] [curY] = 'f';
			slice [curX] [curY] = 'b';
			slice [curX + 1] [curY] = 'n';

			car [curX - 1] [curY] = whichCar;
			car [curX] [curY] = whichCar;
			car [curX + 1] [curY] = 0;
			curX--;

		}
		//3 piece trucks, go up
		else if (whichCar <= 9 && curX - 1 >= 0)
		{
			type [curX - 1] [curY] = 'c';
			type [curX] [curY] = 'c';
			type [curX + 1] [curY] = 'c';
			type [curX + 2] [curY] = 'n';

			slice [curX - 1] [curY] = 'f';
			slice [curX] [curY] = 'm';
			slice [curX + 1] [curY] = 'b';
			slice [curX + 2] [curY] = 'n';

			car [curX - 1] [curY] = whichCar;
			car [curX] [curY] = whichCar;
			car [curX + 1] [curY] = whichCar;
			car [curX + 2] [curY] = 0;
			curX--;

		}
	}
	//move down button
	public void moveDown ()
	{
		if (whichCar <= 4)
			status.setText ("Can't move up or down");
		else if (whichCar <= 7 && curX + 2 < row && slice [curX + 2] [curY] != 'n')
			status.setText ("There is a car there!");
		else if (whichCar > 7 && whichCar <= 9 && curX + 3 < row && slice [curX + 3] [curY] != 'n')
			status.setText ("There is a car there!");
		//2 piece cars, go down
		else if (whichCar <= 7 && curX + 2 < row)
		{
			type [curX] [curY] = 'n';
			type [curX + 1] [curY] = 'c';
			type [curX + 2] [curY] = 'c';

			slice [curX] [curY] = 'n';
			slice [curX + 1] [curY] = 'f';
			slice [curX + 2] [curY] = 'b';

			car [curX] [curY] = 0;
			car [curX + 1] [curY] = whichCar;
			car [curX + 2] [curY] = whichCar;
			curX++;

		}
		//3 piece trucks, go down
		else if (whichCar <= 9 && curX + 3 < row)
		{
			type [curX] [curY] = 'n';
			type [curX + 1] [curY] = 'c';
			type [curX + 2] [curY] = 'c';
			type [curX + 3] [curY] = 'c';

			slice [curX] [curY] = 'n';
			slice [curX + 1] [curY] = 'f';
			slice [curX + 2] [curY] = 'm';
			slice [curX + 3] [curY] = 'b';

			car [curX] [curY] = 0;
			car [curX + 1] [curY] = whichCar;
			car [curX + 2] [curY] = whichCar;
			car [curX + 3] [curY] = whichCar;
			curX++;

		}
	}
	//move left button
	public void moveLeft ()
	{
		if (whichCar >= 5)
			status.setText ("Can't move left or right");
		else if (curY - 1  >= 0 && slice [curX] [curY - 1] != 'n')
			status.setText ("There is a car there!");
		//2 piece cars, go left
		else if (whichCar <= 2 && curY - 1 >= 0)
		{
			type [curX] [curY - 1] = 'c';
			type [curX] [curY] = 'c';
			type [curX] [curY + 1] = 'n';

			slice [curX] [curY - 1] = 'f';
			slice [curX] [curY] = 'b';
			slice [curX] [curY + 1] = 'n';

			car [curX] [curY - 1] = whichCar;
			car [curX] [curY] = whichCar;
			car [curX] [curY + 1] = 0;
			curY--;
		}
		//3 piece trucks, go left
		else if (whichCar <= 4 && curY - 1 >= 0)
		{
			type [curX] [curY - 1] = 'c';
			type [curX] [curY] = 'c';
			type [curX] [curY + 1] = 'c';
			type [curX] [curY + 2] = 'n';

			slice [curX] [curY - 1] = 'f';
			slice [curX] [curY] = 'm';
			slice [curX] [curY + 1] = 'b';
			slice [curX] [curY + 2] = 'n';

			car [curX] [curY - 1] = whichCar;
			car [curX] [curY] = whichCar;
			car [curX] [curY + 1] = whichCar;
			car [curX] [curY + 2] = 0;
			curY--;
		}
	}
	//move right button
	public void moveRight ()
	{
		if (whichCar >= 5)
			status.setText ("Can't move left or right");
		else if (whichCar <= 2 && curY + 2 < col && slice [curX] [curY + 2] != 'n')
			status.setText ("There is a car there!");
		else if (whichCar > 2 && whichCar <= 4 && curY + 3 < col && slice [curX] [curY + 3] != 'n')
			status.setText ("There is a car there!");
		//2 piece cars, go up-down
		else if (whichCar <= 2 && curY + 2 < col)
		{
			type [curX] [curY] = 'n';
			type [curX] [curY + 1] = 'c';
			type [curX] [curY + 2] = 'c';

			slice [curX] [curY] = 'n';
			slice [curX] [curY + 1] = 'f';
			slice [curX] [curY + 2] = 'b';

			car [curX] [curY] = 0;
			car [curX] [curY + 1] = whichCar;
			car [curX] [curY + 2] = whichCar;
			curY++;
		}
		//3 piece trucks, go up-down
		else if (whichCar <= 4 && curY + 3 < col)
		{
			type [curX] [curY - 1] = 'n';
			type [curX] [curY] = 'c';
			type [curX] [curY + 1] = 'c';
			type [curX] [curY + 2] = 'c';

			slice [curX] [curY - 1] = 'n';
			slice [curX] [curY] = 'f';
			slice [curX] [curY + 1] = 'm';
			slice [curX] [curY + 2] = 'b';

			car [curX] [curY - 1] = 0;
			car [curX] [curY] = whichCar;
			car [curX] [curY + 1] = whichCar;
			car [curX] [curY + 2] = whichCar;
			curY++;
		}
	}
	//win method
	public void win ()
	{
		if (type [2] [5] == 'c' && car [2] [5] == 0)
			JOptionPane.showMessageDialog(null,  "You got the red boat out!", "GOOD JOB!", JOptionPane.INFORMATION_MESSAGE);
	}

	public void actionPerformed (ActionEvent e)
	{ //moves between the screens
		if (e.getActionCommand ().equals ("s1"))
			cdLayout.show (p_card, "1");
		else if (e.getActionCommand ().equals ("s2"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("s3"))
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("s4"))
			cdLayout.show (p_card, "4");
		else if (e.getActionCommand ().equals ("s5"))
			cdLayout.show (p_card, "5");
		else if (e.getActionCommand ().equals ("s6"))
			System.exit (0);
		else if (e.getActionCommand ().equals ("Close"))
			System.exit (0);
		else if (e.getActionCommand ().equals ("up"))
			moveUp ();
		else if (e.getActionCommand ().equals ("down"))
			moveDown ();
		else if (e.getActionCommand ().equals ("left"))
			moveLeft ();
		else if (e.getActionCommand ().equals ("right"))
			moveRight ();
		else if (e.getActionCommand ().equals ("nextLevel"))
			next ();
		else if (e.getActionCommand ().equals ("Reset"))
			reset ();
		else if (e.getActionCommand ().equals ("instructions"))
			Instructions ();
		else if (e.getActionCommand ().equals ("save"))
			printOut ();
		else if (e.getActionCommand ().equals ("open"))
			readIn ();
		else
		{ //code to handle the game
			int n = Integer.parseInt (e.getActionCommand ());
			int x = n / col;
			int y = n % col;
			if (type [x] [y] == 'c')
			{
				whichCar = car [x] [y];
				findFront (x, y);
				currentPic.setIcon (createImageIcon ("little" + whichCar + ".png"));
			}

		}
		redraw ();
		win();
	}
}



