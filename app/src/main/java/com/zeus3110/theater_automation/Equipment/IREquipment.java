package com.zeus3110.theater_automation.Equipment;

import java.util.HashMap;

// GlobalCache GC100 ITach経由で赤外線信号送るAV機器制御クラス
public class IREquipment {
	protected String IRPort;
	protected char Frequency;
	protected ITach It;

	// DB
	protected HashMap<String,String> DB;

	// Add Command
	public void AddFunction(String Func, String Signal){
		DB.put(Func,Signal);
	}

	//コンストラクタ
	public IREquipment(String pt, char freq, ITach i){
		IRPort=pt;
		Frequency=freq;
		It=i;

		DB=new HashMap<String,String>();
	}

	// Key参照して信号送信
	public void SendSignal(String Key) throws Exception {

		// DB Key使って参照 なければ例外
		String data=DB.get(Key);

		if (data== null || data.length()==0)
			throw new IllegalArgumentException();

		It.SendIROnce(IRPort,Frequency,(char)1,data);
	}
}
