package com.engine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

public class OBJLoaderTex {
	private static List<Vector3f> vertecies;
	private static List<Vector2f> texCords;
	private static List<Vector3f> normVecs;
	private static List<String> faces;

	public static void processTriang(String face1, String face2, String face3, List<Vector3f> normVecsFinal,
			List<Vector2f> texCordsFinal, List<Vector3f> verteciesFinal) {
		String parts1[] = face1.split("/");
		String parts2[] = face2.split("/");
		String parts3[] = face3.split("/");
		verteciesFinal.add(vertecies.get(Integer.parseInt(parts1[0]) - 1));
		verteciesFinal.add(vertecies.get(Integer.parseInt(parts2[0]) - 1));
		verteciesFinal.add(vertecies.get(Integer.parseInt(parts3[0]) - 1));
		texCordsFinal.add(texCords.get(Integer.parseInt(parts1[1]) - 1));
		texCordsFinal.add(texCords.get(Integer.parseInt(parts2[1]) - 1));
		texCordsFinal.add(texCords.get(Integer.parseInt(parts3[1]) - 1));
		normVecsFinal.add(normVecs.get(Integer.parseInt(parts1[2]) - 1));
		normVecsFinal.add(normVecs.get(Integer.parseInt(parts2[2]) - 1));
		normVecsFinal.add(normVecs.get(Integer.parseInt(parts3[2]) - 1));
	}

	public static OBJArray loadOBJFile(String name) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("res/" + name + ".obj"));
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht geöffnet");
			e.printStackTrace();
		}
		String line = null;
		vertecies = new ArrayList<Vector3f>();
		texCords = new ArrayList<Vector2f>();
		normVecs = new ArrayList<Vector3f>();
		faces = new ArrayList<String>();
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
				vertecies.add(new Vector3f(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]),
						Float.parseFloat(parts[3])));
			}
			if (parts[0].equals("vt")) {
				texCords.add(new Vector2f(Float.parseFloat(parts[1]), Float.parseFloat(parts[2])));
			}
			if (parts[0].equals("vn")) {
				normVecs.add(new Vector3f(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]),
						Float.parseFloat(parts[3])));
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
		List<Vector3f> verteciesFinal = new ArrayList<Vector3f>();
		List<Vector2f> texCordsFinal = new ArrayList<Vector2f>();
		List<Vector3f> normVecsFinal = new ArrayList<Vector3f>();
		for (int i = 0; i < faces.size(); i += 3) {
			processTriang(faces.get(i), faces.get(i + 1), faces.get(i + 2), normVecsFinal, texCordsFinal,
					verteciesFinal);
		}
		float verteciesArray[] = new float[verteciesFinal.size() * 3];
		float texArray[] = new float[texCordsFinal.size() * 3];
		float normArray[] = new float[normVecsFinal.size() * 3];
		int indeciesArray[] = new int[faces.size()];
		for (int i = 0; i < verteciesFinal.size(); i++) {
			verteciesArray[i * 3] = verteciesFinal.get(i).x;
			verteciesArray[i * 3 + 1] = verteciesFinal.get(i).y;
			verteciesArray[i * 3 + 2] = verteciesFinal.get(i).z;
		}
		for (int i = 0; i < normVecsFinal.size(); i++) {
			normArray[i * 3] = normVecsFinal.get(i).x;
			normArray[i * 3 + 1] = normVecsFinal.get(i).y;
			normArray[i * 3 + 2] = normVecsFinal.get(i).z;
		}
		for (int i = 0; i < texCordsFinal.size(); i++) {
			texArray[i * 2] = texCordsFinal.get(i).x;
			texArray[i * 2 + 1] = 1-texCordsFinal.get(i).y;
		}
		for(int i = 0; i<indeciesArray.length;i++) {
			indeciesArray[i]=i;
		}
		return new OBJArray(verteciesArray, texArray, normArray, indeciesArray);
	}
}
