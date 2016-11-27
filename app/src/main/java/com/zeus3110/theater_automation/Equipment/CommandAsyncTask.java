package com.zeus3110.theater_automation.Equipment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;

import com.zeus3110.theater_automation.R;

import java.util.ArrayList;

/**
 * Created by super_000 on 13/06/02.
 */
public class CommandAsyncTask extends AsyncTask<Void,Void,Void> {

	private Activity mActivity = null;
	private ArrayList<AVCommand> MacroCommand;
	private String Err=null;
	private ProgressDialog DialogMacro;
	private int i=0;
	private CallBackTask callbacktask=null;

	public CommandAsyncTask(Activity act, AVCommand com){
		mActivity=act;
		MacroCommand=new ArrayList<AVCommand>(1);
		MacroCommand.add(com);
	}

	public CommandAsyncTask(Activity act, ArrayList<AVCommand> mac){
		mActivity=act;
		MacroCommand=new ArrayList<AVCommand>(mac);
	}

	@Override
	public void onPreExecute() {
		DialogMacro = new ProgressDialog(mActivity);
		DialogMacro.setTitle(R.string.app_name);
		DialogMacro.setMessage(mActivity.getString(R.string.exec_macro));
		DialogMacro.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		DialogMacro.setCancelable(false);
		DialogMacro.setMax(MacroCommand.size());
		DialogMacro.setProgress(i);
		if(MacroCommand.size()>1){
			DialogMacro.show();
		}
	}

	@Override
	protected Void doInBackground(Void... params) {
		try{
			for(i=0;i<MacroCommand.size();){
				MacroCommand.get(i).Exec();
				i++;
				publishProgress();
			}
		}
		catch(Exception e){
			Err=e.toString();
		}
		return null;
	}

	@Override
	protected void onProgressUpdate(Void... v) {
		DialogMacro.setProgress(i);
	}

	@Override
	protected void onPostExecute(Void v) {

		DialogMacro.dismiss();

		// 例外ダイアログの表示
		if(Err!=null)
		{
			AlertDialog.Builder dlg;
			dlg = new AlertDialog.Builder(mActivity);
			dlg.setTitle(R.string.app_name);
			dlg.setMessage(Err);
			dlg.show();
		}

		if(callbacktask!=null)
			callbacktask.CallBack();
	}

	public void setOnCallBack(CallBackTask _cbj) {
		callbacktask = _cbj;
	}

	/**
	 * コールバック用のstaticなclass
	 */
	public static class CallBackTask {
		public void CallBack() {
		}
	}

}
