package com.engine;


import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class FontRender {
	private ArrayList<Letter> Letters = new ArrayList<Letter>();
	private ArrayList<BuchstabenTileLoader> LettersMesh = new ArrayList<BuchstabenTileLoader>();
	private GameLoop mainGame;
	private float size;
	private int stopLength;
public ArrayList<Letter> getLetters() {
		return Letters;
	}

public FontRender(String font,float size,GameLoop mainGame) {
	BufferedReader in = null;
	stopLength =0;
	this.mainGame = mainGame;
	this.size = size;
	try {
		in = new BufferedReader(new FileReader("res/"+font+".fnt"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
	in.readLine();
	in.readLine();
	in.readLine();
	in.readLine();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	try {
		for (int i = 0; i < 96; i++) {
			System.out.println(i);
		String parts[] = in.readLine().split(" ");
		Letter l = new Letter(0, 0, 0, 0, 0, 0, 0, 0, 0);
		for (String string : parts) {
			if(string.length()>1) {
				String test = string.split("=")[0];
				if(test.equals("id")) {
					l.setId(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("x")) {
					l.setX(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("y")) {
					l.setY(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("xoffset")) {
					l.setXoffset(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("yoffset")) {
					l.setYoffset(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("xadvance")) {
					l.setXadvance(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("height")) {
					l.setHeight(Integer.parseInt(string.split("=")[1]));
				}
				if(test.equals("width")) {
					l.setWidth(Integer.parseInt(string.split("=")[1]));
				}
			}
		}
		Letters.add(l);
		}
		for (Letter letter : Letters) {
			LettersMesh.add(new BuchstabenTileLoader(0, 0, letter.getX(), letter.getY(), letter.getWidth(), letter.getHeight(), font,size, mainGame));
			
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void renderFont(String text, int x, int y) {
	char[] stringPart = text.toCharArray();
	int verschieben = 0;
	float xPos = x/1600f;
	float yPos = -(y/900f);
	for (char c : stringPart) {
		if (c == 'A') {
			LettersMesh.get(getIliterator(65)).render(xPos+verschieben/1600f+Letters.get(getIliterator(65)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(65)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(65)).getXadvance()*2*size;
		}
		else if (c == 'B') {
			LettersMesh.get(getIliterator(66)).render(xPos+verschieben/1600f+Letters.get(getIliterator(66)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(66)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(66)).getXadvance()*2*size;
		}
		else if (c == 'C') {
			LettersMesh.get(getIliterator(67)).render(xPos+verschieben/1600f+Letters.get(getIliterator(67)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(67)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(67)).getXadvance()*2*size;
		}
		else if (c == 'D') {
			LettersMesh.get(getIliterator(68)).render(xPos+verschieben/1600f+Letters.get(getIliterator(68)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(68)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(68)).getXadvance()*2*size;
		}
		else if (c == 'E') {
			LettersMesh.get(getIliterator(69)).render(xPos+verschieben/1600f+Letters.get(getIliterator(69)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(69)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(69)).getXadvance()*2*size;
		}
		else if (c == 'F') {
			LettersMesh.get(getIliterator(70)).render(xPos+verschieben/1600f+Letters.get(getIliterator(70)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(70)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(70)).getXadvance()*2*size;
		}
		else if (c == 'G') {
			LettersMesh.get(getIliterator(71)).render(xPos+verschieben/1600f+Letters.get(getIliterator(71)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(71)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(71)).getXadvance()*2*size;
		}
		else if (c == 'H') {
			LettersMesh.get(getIliterator(72)).render(xPos+verschieben/1600f+Letters.get(getIliterator(72)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(72)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(72)).getXadvance()*2*size;
		}
		else if (c == 'I') {
			LettersMesh.get(getIliterator(73)).render(xPos+verschieben/1600f+Letters.get(getIliterator(73)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(73)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(73)).getXadvance()*2*size;
		}
		else if (c == 'J') {
			LettersMesh.get(getIliterator(74)).render(xPos+verschieben/1600f+Letters.get(getIliterator(74)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(74)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(74)).getXadvance()*2*size;
		}
		else if (c == 'K') {
			LettersMesh.get(getIliterator(75)).render(xPos+verschieben/1600f+Letters.get(getIliterator(75)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(75)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(75)).getXadvance()*2*size;
		}
		else if (c == 'L') {
			LettersMesh.get(getIliterator(76)).render(xPos+verschieben/1600f+Letters.get(getIliterator(76)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(76)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(76)).getXadvance()*2*size;
		}
		else if (c == 'M') {
			LettersMesh.get(getIliterator(77)).render(xPos+verschieben/1600f+Letters.get(getIliterator(77)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(77)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(77)).getXadvance()*2*size;
		}
		else if (c == 'N') {
			LettersMesh.get(getIliterator(78)).render(xPos+verschieben/1600f+Letters.get(getIliterator(78)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(78)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(78)).getXadvance()*2*size;
		}
		else if (c == 'O') {
			LettersMesh.get(getIliterator(79)).render(xPos+verschieben/1600f+Letters.get(getIliterator(79)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(79)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(79)).getXadvance()*2*size;
		}
		else if (c == 'P') {
			LettersMesh.get(getIliterator(80)).render(xPos+verschieben/1600f+Letters.get(getIliterator(80)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(80)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(80)).getXadvance()*2*size;
		}
		else if (c == 'Q') {
			LettersMesh.get(getIliterator(81)).render(xPos+verschieben/1600f+Letters.get(getIliterator(81)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(81)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(81)).getXadvance()*2*size;
		}
		else if (c == 'R') {
			LettersMesh.get(getIliterator(82)).render(xPos+verschieben/1600f+Letters.get(getIliterator(82)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(82)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(82)).getXadvance()*2*size;
		}
		else if (c == 'S') {
			LettersMesh.get(getIliterator(83)).render(xPos+verschieben/1600f+Letters.get(getIliterator(83)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(83)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(83)).getXadvance()*2*size;
		}
		else if (c == 'T') {
			LettersMesh.get(getIliterator(84)).render(xPos+verschieben/1600f+Letters.get(getIliterator(84)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(84)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(84)).getXadvance()*2*size;
		}
		else if (c == 'U') {
			LettersMesh.get(getIliterator(85)).render(xPos+verschieben/1600f+Letters.get(getIliterator(85)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(85)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(85)).getXadvance()*2*size;
		}
		else if (c == 'V') {
			LettersMesh.get(getIliterator(86)).render(xPos+verschieben/1600f+Letters.get(getIliterator(86)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(86)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(86)).getXadvance()*2*size;
		}
		else if (c == 'W') {
			LettersMesh.get(getIliterator(87)).render(xPos+verschieben/1600f+Letters.get(getIliterator(87)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(87)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(87)).getXadvance()*2*size;
		}
		else if (c == 'X') {
			LettersMesh.get(getIliterator(88)).render(xPos+verschieben/1600f+Letters.get(getIliterator(88)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(88)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(88)).getXadvance()*2*size;
		}
		else if (c == 'Y') {
			LettersMesh.get(getIliterator(89)).render(xPos+verschieben/1600f+Letters.get(getIliterator(89)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(89)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(89)).getXadvance()*2*size;
		}
		else if (c == 'Z') {
			LettersMesh.get(getIliterator(90)).render(xPos+verschieben/1600f+Letters.get(getIliterator(90)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(90)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(90)).getXadvance()*2*size;
		}
		else if (c == ' ') {
			LettersMesh.get(getIliterator(32)).render(xPos+verschieben/1600f+Letters.get(getIliterator(32)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(32)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(32)).getXadvance()*2*size;
		}
		else if (c == 'a') {
			LettersMesh.get(getIliterator(97)).render(xPos+verschieben/1600f+Letters.get(getIliterator(97)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(97)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(97)).getXadvance()*2*size;
		}
		else if (c == 'b') {
			LettersMesh.get(getIliterator(98)).render(xPos+verschieben/1600f+Letters.get(getIliterator(98)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(98)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(98)).getXadvance()*2*size;
		}
		else if (c == 'c') {
			LettersMesh.get(getIliterator(99)).render(xPos+verschieben/1600f+Letters.get(getIliterator(99)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(99)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(99)).getXadvance()*2*size;
		}
		else if (c == 'd') {
			LettersMesh.get(getIliterator(100)).render(xPos+verschieben/1600f+Letters.get(getIliterator(100)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(100)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(100)).getXadvance()*2*size;
		}
		else if (c == 'e') {
			LettersMesh.get(getIliterator(101)).render(xPos+verschieben/1600f+Letters.get(getIliterator(101)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(101)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(101)).getXadvance()*2*size;
		}
		else if (c == 'f') {
			LettersMesh.get(getIliterator(102)).render(xPos+verschieben/1600f+Letters.get(getIliterator(102)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(102)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(102)).getXadvance()*2*size;
		}
		else if (c == 'g') {
			LettersMesh.get(getIliterator(103)).render(xPos+verschieben/1600f+Letters.get(getIliterator(103)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(103)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(103)).getXadvance()*2*size;
		}
		else if (c == 'h') {
			LettersMesh.get(getIliterator(104)).render(xPos+verschieben/1600f+Letters.get(getIliterator(104)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(104)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(104)).getXadvance()*2*size;
		}
		else if (c == 'i') {
			LettersMesh.get(getIliterator(105)).render(xPos+verschieben/1600f+Letters.get(getIliterator(105)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(105)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(105)).getXadvance()*2*size;
		}
		else if (c == 'j') {
			LettersMesh.get(getIliterator(106)).render(xPos+verschieben/1600f+Letters.get(getIliterator(106)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(106)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(106)).getXadvance()*2*size;
		}
		else if (c == 'k') {
			LettersMesh.get(getIliterator(107)).render(xPos+verschieben/1600f+Letters.get(getIliterator(107)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(107)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(107)).getXadvance()*2*size;
		}
		else if (c == 'l') {
			LettersMesh.get(getIliterator(108)).render(xPos+verschieben/1600f+Letters.get(getIliterator(108)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(108)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(108)).getXadvance()*2*size;
		}
		else if (c == 'm') {
			LettersMesh.get(getIliterator(109)).render(xPos+verschieben/1600f+Letters.get(getIliterator(109)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(109)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(109)).getXadvance()*2*size;
		}
		else if (c == 'n') {
			LettersMesh.get(getIliterator(110)).render(xPos+verschieben/1600f+Letters.get(getIliterator(110)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(110)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(110)).getXadvance()*2*size;
		}
		else if (c == 'o') {
			LettersMesh.get(getIliterator(111)).render(xPos+verschieben/1600f+Letters.get(getIliterator(111)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(111)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(111)).getXadvance()*2*size;
		}
		else if (c == 'p') {
			LettersMesh.get(getIliterator(112)).render(xPos+verschieben/1600f+Letters.get(getIliterator(112)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(112)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(112)).getXadvance()*2*size;
		}
		else if (c == 'q') {
			LettersMesh.get(getIliterator(113)).render(xPos+verschieben/1600f+Letters.get(getIliterator(113)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(113)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(113)).getXadvance()*2*size;
		}
		else if (c == 'r') {
			LettersMesh.get(getIliterator(114)).render(xPos+verschieben/1600f+Letters.get(getIliterator(114)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(114)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(114)).getXadvance()*2*size;
		}
		else if (c == 's') {
			LettersMesh.get(getIliterator(115)).render(xPos+verschieben/1600f+Letters.get(getIliterator(115)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(115)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(115)).getXadvance()*2*size;
		}
		else if (c == 't') {
			LettersMesh.get(getIliterator(116)).render(xPos+verschieben/1600f+Letters.get(getIliterator(116)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(116)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(116)).getXadvance()*2*size;
		}
		else if (c == 'u') {
			LettersMesh.get(getIliterator(117)).render(xPos+verschieben/1600f+Letters.get(getIliterator(117)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(117)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(117)).getXadvance()*2*size;
		}
		else if (c == 'v') {
			LettersMesh.get(getIliterator(118)).render(xPos+verschieben/1600f+Letters.get(getIliterator(118)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(118)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(118)).getXadvance()*2*size;
		}
		else if (c == 'w') {
			LettersMesh.get(getIliterator(119)).render(xPos+verschieben/1600f+Letters.get(getIliterator(119)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(119)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(119)).getXadvance()*2*size;
		}
		else if (c == 'x') {
			LettersMesh.get(getIliterator(120)).render(xPos+verschieben/1600f+Letters.get(getIliterator(120)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(120)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(120)).getXadvance()*2*size;
		}
		else if (c == 'y') {
			LettersMesh.get(getIliterator(121)).render(xPos+verschieben/1600f+Letters.get(getIliterator(121)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(121)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(121)).getXadvance()*2*size;
		}
		else if (c == 'z') {
			LettersMesh.get(getIliterator(122)).render(xPos+verschieben/1600f+Letters.get(getIliterator(122)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(122)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(122)).getXadvance()*2*size;
		}
		else if (c == '1') {
			LettersMesh.get(getIliterator(49)).render(xPos+verschieben/1600f+Letters.get(getIliterator(49)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(49)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(49)).getXadvance()*2*size;
		}
		else if (c == '2') {
			LettersMesh.get(getIliterator(50)).render(xPos+verschieben/1600f+Letters.get(getIliterator(50)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(50)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(50)).getXadvance()*2*size;
		}
		else if (c == '3') {
			LettersMesh.get(getIliterator(51)).render(xPos+verschieben/1600f+Letters.get(getIliterator(51)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(51)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(51)).getXadvance()*2*size;
		}
		else if (c == '4') {
			LettersMesh.get(getIliterator(52)).render(xPos+verschieben/1600f+Letters.get(getIliterator(52)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(52)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(52)).getXadvance()*2*size;
		}
		else if (c == '5') {
			LettersMesh.get(getIliterator(53)).render(xPos+verschieben/1600f+Letters.get(getIliterator(53)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(53)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(53)).getXadvance()*2*size;
		}
		else if (c == '6') {
			LettersMesh.get(getIliterator(54)).render(xPos+verschieben/1600f+Letters.get(getIliterator(54)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(54)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(54)).getXadvance()*2*size;
		}
		else if (c == '7') {
			LettersMesh.get(getIliterator(55)).render(xPos+verschieben/1600f+Letters.get(getIliterator(55)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(55)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(55)).getXadvance()*2*size;
		}
		else if (c == '8') {
			LettersMesh.get(getIliterator(56)).render(xPos+verschieben/1600f+Letters.get(getIliterator(56)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(56)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(56)).getXadvance()*2*size;
		}
		else if (c == '9') {
			LettersMesh.get(getIliterator(57)).render(xPos+verschieben/1600f+Letters.get(getIliterator(57)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(57)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(57)).getXadvance()*2*size;
		}
		else if (c == '0') {
			LettersMesh.get(getIliterator(48)).render(xPos+verschieben/1600f+Letters.get(getIliterator(48)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(48)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(48)).getXadvance()*2*size;
		}
		else if (c == ':') {
			LettersMesh.get(getIliterator(58)).render(xPos+verschieben/1600f+Letters.get(getIliterator(58)).getXoffset()/800f*size,yPos+-Letters.get(getIliterator(58)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(58)).getXadvance()*2*size;
		}
	}
}
public void renderFontTextBox(String text, int x, int y,int xStop,int yStop) {
	char[] stringPart = text.toCharArray();
	int verschieben = 0;
	float yVerschieben =0;
	float xPos = x*2/1600f;
	float yPos = -(y*2/900f);
	xStop -= 20;
	xStop *=4;
	int n = 0;
	stopLength = 0;
	for (char c : stringPart) {
		n++;
		if (c == 'A') {
			LettersMesh.get(getIliterator(65)).render(xPos+verschieben/1600f+Letters.get(getIliterator(65)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(65)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(65)).getXadvance()*2*size;
		}
		else if (c == 'B') {
			LettersMesh.get(getIliterator(66)).render(xPos+verschieben/1600f+Letters.get(getIliterator(66)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(66)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(66)).getXadvance()*2*size;
		}
		else if (c == 'C') {
			LettersMesh.get(getIliterator(67)).render(xPos+verschieben/1600f+Letters.get(getIliterator(67)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(67)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(67)).getXadvance()*2*size;
		}
		else if (c == 'D') {
			LettersMesh.get(getIliterator(68)).render(xPos+verschieben/1600f+Letters.get(getIliterator(68)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(68)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(68)).getXadvance()*2*size;
		}
		else if (c == 'E') {
			LettersMesh.get(getIliterator(69)).render(xPos+verschieben/1600f+Letters.get(getIliterator(69)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(69)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(69)).getXadvance()*2*size;
		}
		else if (c == 'F') {
			LettersMesh.get(getIliterator(70)).render(xPos+verschieben/1600f+Letters.get(getIliterator(70)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(70)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(70)).getXadvance()*2*size;
		}
		else if (c == 'G') {
			LettersMesh.get(getIliterator(71)).render(xPos+verschieben/1600f+Letters.get(getIliterator(71)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(71)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(71)).getXadvance()*2*size;
		}
		else if (c == 'H') {
			LettersMesh.get(getIliterator(72)).render(xPos+verschieben/1600f+Letters.get(getIliterator(72)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(72)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(72)).getXadvance()*2*size;
		}
		else if (c == 'I') {
			LettersMesh.get(getIliterator(73)).render(xPos+verschieben/1600f+Letters.get(getIliterator(73)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(73)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(73)).getXadvance()*2*size;
		}
		else if (c == 'J') {
			LettersMesh.get(getIliterator(74)).render(xPos+verschieben/1600f+Letters.get(getIliterator(74)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(74)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(74)).getXadvance()*2*size;
		}
		else if (c == 'K') {
			LettersMesh.get(getIliterator(75)).render(xPos+verschieben/1600f+Letters.get(getIliterator(75)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(75)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(75)).getXadvance()*2*size;
		}
		else if (c == 'L') {
			LettersMesh.get(getIliterator(76)).render(xPos+verschieben/1600f+Letters.get(getIliterator(76)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(76)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(76)).getXadvance()*2*size;
		}
		else if (c == 'M') {
			LettersMesh.get(getIliterator(77)).render(xPos+verschieben/1600f+Letters.get(getIliterator(77)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(77)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(77)).getXadvance()*2*size;
		}
		else if (c == 'N') {
			LettersMesh.get(getIliterator(78)).render(xPos+verschieben/1600f+Letters.get(getIliterator(78)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(78)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(78)).getXadvance()*2*size;
		}
		else if (c == 'O') {
			LettersMesh.get(getIliterator(79)).render(xPos+verschieben/1600f+Letters.get(getIliterator(79)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(79)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(79)).getXadvance()*2*size;
		}
		else if (c == 'P') {
			LettersMesh.get(getIliterator(80)).render(xPos+verschieben/1600f+Letters.get(getIliterator(80)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(80)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(80)).getXadvance()*2*size;
		}
		else if (c == 'Q') {
			LettersMesh.get(getIliterator(81)).render(xPos+verschieben/1600f+Letters.get(getIliterator(81)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(81)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(81)).getXadvance()*2*size;
		}
		else if (c == 'R') {
			LettersMesh.get(getIliterator(82)).render(xPos+verschieben/1600f+Letters.get(getIliterator(82)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(82)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(82)).getXadvance()*2*size;
		}
		else if (c == 'S') {
			LettersMesh.get(getIliterator(83)).render(xPos+verschieben/1600f+Letters.get(getIliterator(83)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(83)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(83)).getXadvance()*2*size;
		}
		else if (c == 'T') {
			LettersMesh.get(getIliterator(84)).render(xPos+verschieben/1600f+Letters.get(getIliterator(84)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(84)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(84)).getXadvance()*2*size;
		}
		else if (c == 'U') {
			LettersMesh.get(getIliterator(85)).render(xPos+verschieben/1600f+Letters.get(getIliterator(85)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(85)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(85)).getXadvance()*2*size;
		}
		else if (c == 'V') {
			LettersMesh.get(getIliterator(86)).render(xPos+verschieben/1600f+Letters.get(getIliterator(86)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(86)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(86)).getXadvance()*2*size;
		}
		else if (c == 'W') {
			LettersMesh.get(getIliterator(87)).render(xPos+verschieben/1600f+Letters.get(getIliterator(87)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(87)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(87)).getXadvance()*2*size;
		}
		else if (c == 'X') {
			LettersMesh.get(getIliterator(88)).render(xPos+verschieben/1600f+Letters.get(getIliterator(88)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(88)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(88)).getXadvance()*2*size;
		}
		else if (c == 'Y') {
			LettersMesh.get(getIliterator(89)).render(xPos+verschieben/1600f+Letters.get(getIliterator(89)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(89)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(89)).getXadvance()*2*size;
		}
		else if (c == 'Z') {
			LettersMesh.get(getIliterator(90)).render(xPos+verschieben/1600f+Letters.get(getIliterator(90)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(90)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(90)).getXadvance()*2*size;
		}
		else if (c == ' ') {
			LettersMesh.get(getIliterator(32)).render(xPos+verschieben/1600f+Letters.get(getIliterator(32)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(32)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(32)).getXadvance()*2*size;
		}
		else if (c == 'a') {
			LettersMesh.get(getIliterator(97)).render(xPos+verschieben/1600f+Letters.get(getIliterator(97)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(97)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(97)).getXadvance()*2*size;
		}
		else if (c == 'b') {
			LettersMesh.get(getIliterator(98)).render(xPos+verschieben/1600f+Letters.get(getIliterator(98)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(98)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(98)).getXadvance()*2*size;
		}
		else if (c == 'c') {
			LettersMesh.get(getIliterator(99)).render(xPos+verschieben/1600f+Letters.get(getIliterator(99)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(99)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(99)).getXadvance()*2*size;
		}
		else if (c == 'd') {
			LettersMesh.get(getIliterator(100)).render(xPos+verschieben/1600f+Letters.get(getIliterator(100)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(100)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(100)).getXadvance()*2*size;
		}
		else if (c == 'e') {
			LettersMesh.get(getIliterator(101)).render(xPos+verschieben/1600f+Letters.get(getIliterator(101)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(101)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(101)).getXadvance()*2*size;
		}
		else if (c == 'f') {
			LettersMesh.get(getIliterator(102)).render(xPos+verschieben/1600f+Letters.get(getIliterator(102)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(102)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(102)).getXadvance()*2*size;
		}
		else if (c == 'g') {
			LettersMesh.get(getIliterator(103)).render(xPos+verschieben/1600f+Letters.get(getIliterator(103)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(103)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(103)).getXadvance()*2*size;
		}
		else if (c == 'h') {
			LettersMesh.get(getIliterator(104)).render(xPos+verschieben/1600f+Letters.get(getIliterator(104)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(104)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(104)).getXadvance()*2*size;
		}
		else if (c == 'i') {
			LettersMesh.get(getIliterator(105)).render(xPos+verschieben/1600f+Letters.get(getIliterator(105)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(105)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(105)).getXadvance()*2*size;
		}
		else if (c == 'j') {
			LettersMesh.get(getIliterator(106)).render(xPos+verschieben/1600f+Letters.get(getIliterator(106)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(106)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(106)).getXadvance()*2*size;
		}
		else if (c == 'k') {
			LettersMesh.get(getIliterator(107)).render(xPos+verschieben/1600f+Letters.get(getIliterator(107)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(107)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(107)).getXadvance()*2*size;
		}
		else if (c == 'l') {
			LettersMesh.get(getIliterator(108)).render(xPos+verschieben/1600f+Letters.get(getIliterator(108)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(108)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(108)).getXadvance()*2*size;
		}
		else if (c == 'm') {
			LettersMesh.get(getIliterator(109)).render(xPos+verschieben/1600f+Letters.get(getIliterator(109)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(109)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(109)).getXadvance()*2*size;
		}
		else if (c == 'n') {
			LettersMesh.get(getIliterator(110)).render(xPos+verschieben/1600f+Letters.get(getIliterator(110)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(110)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(110)).getXadvance()*2*size;
		}
		else if (c == 'o') {
			LettersMesh.get(getIliterator(111)).render(xPos+verschieben/1600f+Letters.get(getIliterator(111)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(111)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(111)).getXadvance()*2*size;
		}
		else if (c == 'p') {
			LettersMesh.get(getIliterator(112)).render(xPos+verschieben/1600f+Letters.get(getIliterator(112)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(112)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(112)).getXadvance()*2*size;
		}
		else if (c == 'q') {
			LettersMesh.get(getIliterator(113)).render(xPos+verschieben/1600f+Letters.get(getIliterator(113)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(113)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(113)).getXadvance()*2*size;
		}
		else if (c == 'r') {
			LettersMesh.get(getIliterator(114)).render(xPos+verschieben/1600f+Letters.get(getIliterator(114)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(114)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(114)).getXadvance()*2*size;
		}
		else if (c == 's') {
			LettersMesh.get(getIliterator(115)).render(xPos+verschieben/1600f+Letters.get(getIliterator(115)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(115)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(115)).getXadvance()*2*size;
		}
		else if (c == 't') {
			LettersMesh.get(getIliterator(116)).render(xPos+verschieben/1600f+Letters.get(getIliterator(116)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(116)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(116)).getXadvance()*2*size;
		}
		else if (c == 'u') {
			LettersMesh.get(getIliterator(117)).render(xPos+verschieben/1600f+Letters.get(getIliterator(117)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(117)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(117)).getXadvance()*2*size;
		}
		else if (c == 'v') {
			LettersMesh.get(getIliterator(118)).render(xPos+verschieben/1600f+Letters.get(getIliterator(118)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(118)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(118)).getXadvance()*2*size;
		}
		else if (c == 'w') {
			LettersMesh.get(getIliterator(119)).render(xPos+verschieben/1600f+Letters.get(getIliterator(119)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(119)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(119)).getXadvance()*2*size;
		}
		else if (c == 'x') {
			LettersMesh.get(getIliterator(120)).render(xPos+verschieben/1600f+Letters.get(getIliterator(120)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(120)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(120)).getXadvance()*2*size;
		}
		else if (c == 'y') {
			LettersMesh.get(getIliterator(121)).render(xPos+verschieben/1600f+Letters.get(getIliterator(121)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(121)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(121)).getXadvance()*2*size;
		}
		else if (c == 'z') {
			LettersMesh.get(getIliterator(122)).render(xPos+verschieben/1600f+Letters.get(getIliterator(122)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(122)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(122)).getXadvance()*2*size;
		}
		else if (c == '1') {
			LettersMesh.get(getIliterator(49)).render(xPos+verschieben/1600f+Letters.get(getIliterator(49)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(49)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(49)).getXadvance()*2*size;
		}
		else if (c == '2') {
			LettersMesh.get(getIliterator(50)).render(xPos+verschieben/1600f+Letters.get(getIliterator(50)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(50)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(50)).getXadvance()*2*size;
		}
		else if (c == '3') {
			LettersMesh.get(getIliterator(51)).render(xPos+verschieben/1600f+Letters.get(getIliterator(51)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(51)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(51)).getXadvance()*2*size;
		}
		else if (c == '4') {
			LettersMesh.get(getIliterator(52)).render(xPos+verschieben/1600f+Letters.get(getIliterator(52)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(52)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(52)).getXadvance()*2*size;
		}
		else if (c == '5') {
			LettersMesh.get(getIliterator(53)).render(xPos+verschieben/1600f+Letters.get(getIliterator(53)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(53)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(53)).getXadvance()*2*size;
		}
		else if (c == '6') {
			LettersMesh.get(getIliterator(54)).render(xPos+verschieben/1600f+Letters.get(getIliterator(54)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(54)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(54)).getXadvance()*2*size;
		}
		else if (c == '7') {
			LettersMesh.get(getIliterator(55)).render(xPos+verschieben/1600f+Letters.get(getIliterator(55)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(55)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(55)).getXadvance()*2*size;
		}
		else if (c == '8') {
			LettersMesh.get(getIliterator(56)).render(xPos+verschieben/1600f+Letters.get(getIliterator(56)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(56)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(56)).getXadvance()*2*size;
		}
		else if (c == '9') {
			LettersMesh.get(getIliterator(57)).render(xPos+verschieben/1600f+Letters.get(getIliterator(57)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(57)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(57)).getXadvance()*2*size;
		}
		else if (c == '0') {
			LettersMesh.get(getIliterator(48)).render(xPos+verschieben/1600f+Letters.get(getIliterator(48)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(48)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(48)).getXadvance()*2*size;
		}
		else if (c == ':') {
			LettersMesh.get(getIliterator(58)).render(xPos+verschieben/1600f+Letters.get(getIliterator(58)).getXoffset()/800f*size,yPos+(yVerschieben/900f)+-Letters.get(getIliterator(58)).getYoffset()/450f*size);
			verschieben += Letters.get(getIliterator(58)).getXadvance()*2*size;
		}
		if (verschieben > xStop/2/size) {
			yVerschieben -= 45;
			verschieben =0;
		}
		if (yVerschieben < -yStop) {
			stopLength = n;
			break;
		}
	}
}

public int getStopLength() {
	return stopLength;
}

public int getIliterator(int ID) {
	int b = 0;
	for (Letter letter : Letters) {
		if(letter.getId() == ID) {
			return b;
		}
		b++;
	}
	return 0;
	
}
}
