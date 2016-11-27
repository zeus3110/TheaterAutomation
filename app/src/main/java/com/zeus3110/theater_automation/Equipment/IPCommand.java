package com.zeus3110.theater_automation.Equipment;

/**
 * Created by super_000 on 13/06/02.
 */
public class IPCommand extends AVCommand {

	private String Func;
	private byte[] Data;
	private IPAVC Av;

	public IPCommand(IPAVC _Av,String _Fuc){
		super();
		Av=_Av;
		Func=_Fuc;
		Data=new byte[0];
	}

	public IPCommand(IPAVC _Av,byte[] _Data){
		Av=_Av;
		Func=null;
		Data=_Data.clone();
	}

	public void Exec() throws Exception {
		if(Func==null)
			Av.SendCommand(Data);
		else
			Av.SendCommand(Func);
	}

	public String GetFuncName(){ return Func; }

	public IPAVC GetAVData() { return Av; }

	public byte[] GetParam() throws Exception {
		if(Func==null)
			return (byte[])(Av.RequestCommand(Data).clone());
		else
			return (byte[])(Av.RequestCommand(Func).clone());
	}
}
