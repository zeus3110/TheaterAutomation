package com.zeus3110.theater_automation.Equipment;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by super_000 on 13/06/02.
 */
public class GetParamAsyncTask extends AsyncTask<Void,Void,Void> {

	private ArrayList<IPCommand> MacroCommand;
	private String Err=null;
	private int i=0;
	private CallBackTask callbacktask=null;
	private ArrayList<byte[]> ResParam;

	public GetParamAsyncTask(IPCommand com){
		MacroCommand=new ArrayList<IPCommand>(1);
		MacroCommand.add(com);
		ResParam=new ArrayList<byte[]>();
	}

	public GetParamAsyncTask(ArrayList<IPCommand> mac){
		MacroCommand=new ArrayList<IPCommand>();
		MacroCommand.addAll(mac);
		ResParam=new ArrayList<byte[]>();
	}

	@Override
	public void onPreExecute() {

	}

	@Override
	protected Void doInBackground(Void... params) {
		try{
			byte[] res;
			for(i=0;i<MacroCommand.size();i++){
				res=MacroCommand.get(i).GetParam();
				Log.v("HALIB GET", MacroCommand.get(i).GetFuncName());
				Log.v("HALIB GET",ByteHexUtil.toHexString(res));
				ResParam.add(res);
			}
		}
		catch(Exception e){
			Err=e.toString();
		}
		return null;
	}

	@Override
	protected void onProgressUpdate(Void... v) {

	}

	@Override
	protected void onPostExecute(Void v) {

		if(callbacktask!=null)
			callbacktask.CallBack(ResParam);
	}

	public void setOnCallBack(CallBackTask _cbj) {
		callbacktask = _cbj;
	}

	/**
	 * コールバック用のstaticなclass
	 */
	public static class CallBackTask {
		public void CallBack(ArrayList<byte[]> res) {
		}
	}

}
