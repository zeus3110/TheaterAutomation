package com.zeus3110.theater_automation.Equipment;

// GlobalCache ITach制御クラス
public class ITach extends IPAVC {

	private char IrID=0;

	public ITach(String IPAddress) {
		super(IPAddress, 4998);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ITach(String IPAddress, int CommunicationTimeOut, int ConnectionTimeOut) {
		super(IPAddress, 4998, CommunicationTimeOut, ConnectionTimeOut);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	//単発送信用
	public void SendIROnce(String port, char freq, char offset, String data) throws Exception
	{
		SendIRRepeat(port,freq,offset,data,1);
	}

	protected void SendIRRepeat(String port, char freq, char offset, String data, int num) throws Exception
	{
		String cmd="sendir,";
		cmd=cmd+port+",";
		cmd=cmd+ String.valueOf((int)IrID);
		IrID++;
		cmd=cmd+","+ String.valueOf((int)freq);
		cmd=cmd+","+ String.valueOf(num); //repeat
		cmd=cmd+","+ String.valueOf((int)offset); //no offset
		cmd=cmd+","+data+"\r";

		SendCommand(cmd.getBytes("US-ASCII"));
	}

	//リピート回数最大50回
	public void SendIRParmanently(String port, char freq, char offset, String data) throws Exception
	{
		SendIRRepeat(port,freq,offset,data,50);
	}

	public void StopIR(String port) throws Exception
	{
		String cmd="sendir,"+port+"\r";
		SendCommand(cmd.getBytes("US-ASCII"));

	}

}
