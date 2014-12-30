package org.jy.rpc.support;

import org.jy.rpc.protocal.Invocation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread {
	private ServerSocket socket;
	private Server server;

	public Listener(Server server) {
		this.server = server;
	}

	@Override
	public void run() {

		System.out.println("server port is :" + server.getPort());
		try {
			socket = new ServerSocket(server.getPort());
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		while (server.isRunning()) {
			try {
				System.out.println("ready to accpet");
				Socket client = socket.accept();
				System.out.println("accepted");
				ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				Invocation invo = (Invocation) ois.readObject();
				System.out.println("acc:" + invo);

				server.call(invo);
				
				ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
				oos.writeObject(invo);
				oos.flush();
				oos.close();
				ois.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		try {
			if (socket != null && !socket.isClosed())
				socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
