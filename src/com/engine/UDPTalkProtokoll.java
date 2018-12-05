package com.engine;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPTalkProtokoll {
private InetAddress clientSelf;
private InetAddress clientPartner;
public UDPTalkProtokoll(InetAddress client1, InetAddress client2) {
	this.clientSelf = client1;
	this.clientPartner = client2; 
}
public boolean TestConnection() {
	byte[] testMes = new String("ECHO").getBytes();
	DatagramPacket testPack = new DatagramPacket(testMes, testMes.length,clientPartner,7778);
	try {
		DatagramSocket testCon = new DatagramSocket();
		testCon.send(testPack);
		DatagramSocket testRec = new DatagramSocket(7778);
		testMes = new byte[1024];
		testPack = new DatagramPacket(testMes, testMes.length);
		testRec.setSoTimeout(1000);
		testRec.receive(testPack);
		testCon.close();
		testRec.close();
		return true;
	} catch (Exception e) {
		e.printStackTrace();
		testMes = new String("ECHO").getBytes();
		testPack = new DatagramPacket(testMes, testMes.length,clientPartner,7778);
		try {
			DatagramSocket testCon = new DatagramSocket();
			testCon.send(testPack);
			DatagramSocket testRec = new DatagramSocket(7777);
			testMes = new byte[1024];
			testPack = new DatagramPacket(testMes, testMes.length);
			testRec.setSoTimeout(1000);
			testRec.receive(testPack);
			testCon.close();
			testRec.close();
			return true;
		} catch (Exception d) {
			d.printStackTrace();
			return false;
		}
	}
}
}
