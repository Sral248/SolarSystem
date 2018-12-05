package com.engine;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class OBJLoader {
	public static OBJArray loadOBJFile(String name) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("res/" + name + ".obj"));
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht geöffnet");
			e.printStackTrace();
		}
		String line = null;
		List<String> vertecies = new ArrayList<String>();
		List<Vector2f> texCords = new ArrayList<Vector2f>();
		List<Vector3f> normVecs = new ArrayList<Vector3f>();
		List<String> faces = new ArrayList<String>();
		float[] vertecisArray;
		float[] texCordsArray;
		float[] normVecsArray;
		int[] indeciesArray;
		int[] indeciesNormArray;
		int[] indeciesTexArray;
		try {
			line = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while (line != null) {
			String[] parts = line.split(" ");

			if (parts[0].equals("v")) {
				// System.out.println(parts[1]);
				vertecies.add(parts[1]);
				vertecies.add(parts[2]);
				vertecies.add(parts[3]);
			}
			if (parts[0].equals("vt")) {
				texCords.add(new Vector2f(Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
			}
			if (parts[0].equals("vn")) {
				normVecs.add(new Vector3f(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]),Float.parseFloat(parts[3])));
			}
			if (parts[0].equals("f")) {
				faces.add(parts[1]);
				faces.add(parts[2]);
				faces.add(parts[3]);
			}
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		vertecisArray = new float[vertecies.size()];
		texCordsArray = new float[vertecies.size()];
		normVecsArray = new float[vertecies.size()];
		indeciesArray = new int[faces.size()];
		indeciesNormArray = new int[faces.size()];
		indeciesTexArray = new int[faces.size()];
		for (int i = 0; i < vertecies.size(); i++) {

			vertecisArray[i] = Float.parseFloat(vertecies.get(i));
		}
		System.out.print(faces.get(0));
		for (int i = 0; i < faces.size(); i++) {
			String[] parts = faces.get(i).split("/");
			indeciesArray[i] = Integer.parseInt(parts[0]) - 1;
			indeciesNormArray[i] = Integer.parseInt(parts[2]) - 1;
			indeciesTexArray[i] = Integer.parseInt(parts[1]) -1;
		}
		for (int i = 0; i < indeciesArray.length; i++) {

			texCordsArray[indeciesArray[i] *2] = texCords.get(indeciesTexArray[i]).x;

			texCordsArray[indeciesArray[i]  *2+ 1] = 1- (texCords.get(indeciesTexArray[i]).y);
		}
		System.out.println("Anzahl: "+normVecs.size());

		for (int i = 0; i < indeciesArray.length; i++) {
			normVecsArray[indeciesArray[i] *3] = normVecs.get(indeciesNormArray[i]).x;

			normVecsArray[indeciesArray[i]  *3+ 1] = (normVecs.get(indeciesNormArray[i]).y);
			
			normVecsArray[indeciesArray[i]  *3+ 2] = (normVecs.get(indeciesNormArray[i]).z);
		}
		return new OBJArray(vertecisArray, texCordsArray, normVecsArray, indeciesArray);

	}
}
