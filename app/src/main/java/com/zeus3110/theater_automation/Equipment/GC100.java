package com.zeus3110.theater_automation.Equipment;

// GlobalCache GC100(ITach派生+リレー)制御クラス
public class GC100 extends ITach {

	public GC100(String IPAddress) {
		super(IPAddress);
		// TODO 自動生成されたコンストラクター・スタブ
		GenerateRelayCommand();
	}

	public GC100(String IPAddress, int CommunicationTimeOut, int ConnectionTimeOut) {
		super(IPAddress, CommunicationTimeOut, ConnectionTimeOut);
		// TODO 自動生成されたコンストラクター・スタブ
		GenerateRelayCommand();
	}
	
	//リピート回数0回で永続
	@Override
	public void SendIRParmanently(String port, char freq, char offset, String data) throws Exception
	{
		SendIRRepeat(port,freq,offset,data,0);
	}


	// Port3 リレーポート制御コマンド文字列生成
	private String SetRelayMode(int port, boolean state)
	{
		String cmd="setstate,3:";
		cmd=cmd+ Integer.valueOf(port).toString();
		if(state==true)
			cmd=cmd+",1\r";
		else
			cmd=cmd+",0\r";

		return cmd;

	}

	private void GenerateRelayCommand()
	{
		int i;
		for(i=1;i<4;i++){
			AddFunction("RY"+ String.valueOf(i)+"ON",SetRelayMode(i,true));
			AddFunction("RY"+ String.valueOf(i)+"OFF",SetRelayMode(i,false));
		}

	}
}
