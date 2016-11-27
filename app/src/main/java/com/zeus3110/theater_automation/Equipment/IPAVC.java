package com.zeus3110.theater_automation.Equipment;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class IPAVC {

	protected String IP;			// IP Address
	protected int Port;			// Port
	protected int TimeOut;		// TimeOut(ms) 通信なし時タイムアウト時間
	protected int InitTimeOut;	// 接続時タイムアウト時

	// Timer
	private Timer OutTimer;

	// Socket
	protected Socket socketAVC;
	protected BufferedInputStream inAVC;
	protected OutputStream outAVC;

	// DB
	protected HashMap<String,byte[]> DB;

	// Add Command
	public void AddFunction(String Func, String Signal){
		DB.put(Func,Signal.getBytes());
	}
	public void AddFunction(String Func, byte[] Data){
		DB.put(Func,Data);
	}

	// constructor
	public IPAVC(String IPAddress, int PortNum)
	{
		IP=IPAddress;
		Port=PortNum;
		TimeOut=4000;
		InitTimeOut=2000;

		socketAVC=null;

		// Timer Initialize
		OutTimer=null;

		DB=new HashMap<String,byte[]>();
	}

	// constructor
	public IPAVC(String IPAddress, int PortNum, int CommunicationTimeOut, int ConnectionTimeOut)
	{

		IP=IPAddress;
		Port=PortNum;
		TimeOut=CommunicationTimeOut;
		InitTimeOut=ConnectionTimeOut;

		socketAVC=null;

		// Timer Initialize
		OutTimer=null;

		DB=new HashMap<String,byte[]>();
	}

	public boolean IsConnected()
	{
		return (socketAVC!=null);
	}

	private void ConnectToIPAVC() throws Exception {

		SetDisconnectTimer();

		if(!IsConnected())
		{	socketAVC=new Socket();
			socketAVC.connect(new InetSocketAddress(IP,Port),InitTimeOut);

			inAVC=new BufferedInputStream(socketAVC.getInputStream());
			outAVC=socketAVC.getOutputStream();
		}
	}

	// 値返してもらうコマンド投げ(Key)
	public byte[] RequestCommand(String KeyFunc) throws Exception {

		// DB Key使って参照 なければ例外
		byte[] command;
		command=DB.get(KeyFunc);
		if (command== null || command.length==0)
			throw new IllegalArgumentException();

		return RequestCommand(command);
	}

	// 値返してもらうコマンド投げ(byte列コマンド)
	public byte[] RequestCommand(byte[] command) throws Exception {

		byte[] buf=new byte[1024];
		byte[] val={'u','n'};
		int size = 0;
		Log.v("HALIB", "Before");


		CancelDisconnectTimer();
		ConnectToIPAVC();
		Log.v("HALIB", "Connected");


		if(inAVC.available()>0)
			inAVC.read(buf);

		outAVC.write(command);
		outAVC.flush();
		Log.v("HALIB", "Send Command:"+ByteHexUtil.toHexString(command));

		size=inAVC.read(buf);
		if(size<=0)
			throw new IOException("IPAVC didn't return value.");

		Log.v("HALIB", "Received Data:"+ ByteHexUtil.toHexString(buf));

		val=new byte[size];
		System.arraycopy(buf, 0, val, 0, size);

		return (byte [])val.clone();
	}

	// 値受け取らないコマンド投げ(Key)
	public void SendCommand(String KeyFunc) throws Exception {

		// DB Key使って参照 なければ例外
		byte[] command;
		command=DB.get(KeyFunc);
		if (command== null || command.length==0)
			throw new IllegalArgumentException();

		SendCommand(command);
	}

	public void SendCommand(byte[] command) throws Exception {

		byte[] buf=new byte[1024];

		CancelDisconnectTimer();
		ConnectToIPAVC();

		outAVC.write(command);
		outAVC.flush();

		if(inAVC.available()>0)
			inAVC.read(buf);

	}

	// クローズ
	public void CloseIPAVCSocket() throws Exception {
		if(socketAVC==null)
			return;

		inAVC.close();
		outAVC.close();
		socketAVC.close();
		socketAVC=null;
	}

	public void CancelDisconnectTimer(){
		if(OutTimer!=null)
		{	OutTimer.cancel();
			OutTimer=null;
		}
	}

	public void SetDisconnectTimer(){
		if(OutTimer==null)
		{	OutTimer=new Timer();
			OutTimer.schedule(new CloseConnectionTimerTask(),TimeOut);
		}
	}

    class CloseConnectionTimerTask extends TimerTask {

      	@Override
    	public void run() {
      			try{
      	           	Log.v("HALIB", "Closed AVCSocket");
      				CloseIPAVCSocket();
      			}
      			catch(Exception e){
      				// throw new Exception(e);
      				socketAVC=null;
    		}
      	}
    }
}