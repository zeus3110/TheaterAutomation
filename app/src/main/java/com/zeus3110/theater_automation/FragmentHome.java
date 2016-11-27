package com.zeus3110.theater_automation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.zeus3110.theater_automation.Equipment.AVCommand;
import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.GetParamCallable;
import com.zeus3110.theater_automation.Equipment.IRCommand;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.WaitCommand;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSharpBD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment implements OnClickListener {
    private static final String ARG_SECTION_NUMBER = "section_number";

    CheckBox chkboxAOff;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(int sectionNumber) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Class.forName("android.os.AsyncTask");
        }catch(ClassNotFoundException e){}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ((Button) v.findViewById(R.id.buttonHomeBZT910)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.buttonHomeBXT870)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.buttonHomeW500)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.buttonHomeNexusPlayer)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.buttonHomeDLNA)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.buttonHomeDS)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.buttonHomePowerOff)).setOnClickListener((OnClickListener) this);
        chkboxAOff= (CheckBox)v.findViewById(R.id.checkBoxHomeAudioOff);

        v.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                switch (keyCode) {
                    case KeyEvent.KEYCODE_VOLUME_UP:
                        // new CommandAsyncTask(getActivity(), StudyRoom.).execute();
                        return true;
                    case KeyEvent.KEYCODE_VOLUME_DOWN:
                        // new CommandAsyncTask(getActivity(), Eq.Audio.VolMinus).execute();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // View#setFocusableInTouchMode
        v.setFocusableInTouchMode(true);
        v.requestFocus();

        return v;
    }

    public void onClick(View v) {
        Context context;
        context=getActivity();
        MainActivity mainActivity = (MainActivity)context;
        mainActivity.drawerLayout.closeDrawers();
        FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();

        try{
            switch (v.getId()) {
                case R.id.buttonHomeBZT910:
                    ArrayList<AVCommand> MacroActivityBZT910Active=new ArrayList<AVCommand>();
                    MacroActivityBZT910Active.addAll(TheaterRoomMacro.MacroActivityCoreVisualOn);
                    MacroActivityBZT910Active.addAll(TheaterRoomMacro.MacroActivityCoreAudioOn);
                    MacroActivityBZT910Active.add(new IRCommand(TheaterRoom.DIGA1,"power_on"));
                    MacroActivityBZT910Active.add(new WaitCommand(200));
                    MacroActivityBZT910Active.add(new IPCommand(TheaterRoom.AVAmp,"InputAV1"));
                    MacroActivityBZT910Active.add(new WaitCommand(200));
                    new CommandAsyncTask(getActivity(),MacroActivityBZT910Active).execute();
                    Fragment diga1Fragment = new FragmentDiga1();
                    fragmentTransaction.replace(R.id.containerView,diga1Fragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.buttonHomeBXT870:
                    ArrayList<AVCommand> MacroActivityBXT870Active=new ArrayList<AVCommand>();
                    MacroActivityBXT870Active.addAll(TheaterRoomMacro.MacroActivityCoreVisualOn);
                    MacroActivityBXT870Active.addAll(TheaterRoomMacro.MacroActivityCoreAudioOn);
                    MacroActivityBXT870Active.add(new IRCommand(TheaterRoom.DIGA2,"power_on"));
                    MacroActivityBXT870Active.add(new WaitCommand(200));
                    MacroActivityBXT870Active.add(new IPCommand(TheaterRoom.AVAmp,"InputAV2"));
                    MacroActivityBXT870Active.add(new WaitCommand(200));
                    new CommandAsyncTask(getActivity(),MacroActivityBXT870Active).execute();
                    Fragment diga2Fragment = new FragmentDiga2();
                    fragmentTransaction.replace(R.id.containerView,diga2Fragment);
                    fragmentTransaction.commit();
                    break;
                case R.id.buttonHomeW500:
                    ArrayList<AVCommand> MacroActivityW500Active=new ArrayList<AVCommand>();        // マクロ実行
                    MacroActivityW500Active.addAll(TheaterRoomMacro.MacroActivityCoreVisualOn);
                    MacroActivityW500Active.addAll(TheaterRoomMacro.MacroActivityCoreAudioOn);
                    MacroActivityW500Active.add(new IPCommand(TheaterRoom.AVAmp,"InputAV3"));
                    MacroActivityW500Active.add(new WaitCommand(200));
                    // BD-W500 電源検出
                    IPCommand Command = new IPCommand(TheaterRoom.IoTWeatherKit, "GetOptIn");
                    ExecutorService service = Executors.newCachedThreadPool();
                    Future<byte[]> future=service.submit(new GetParamCallable(Command));
                    byte[] res=future.get();
                    String strres=new String(res, "US-ASCII");
                    if(strres.equals("OFF")){   // OFFならコマンド追加
                        MacroActivityW500Active.add(new IRCommand(TheaterRoom.SharpBD,"power"));
                        MacroActivityW500Active.add(new WaitCommand(200));
                    }
                    // コマンド実行
                    new CommandAsyncTask(getActivity(),MacroActivityW500Active).execute();
                    Fragment FragmentSharpBD = new FragmentSharpBD();                               // フラグメント差し替え
                    fragmentTransaction.replace(R.id.containerView,FragmentSharpBD);
                    fragmentTransaction.commit();
                    break;
                case R.id.buttonHomeNexusPlayer:
                    ArrayList<AVCommand> MacroActivityNexusActive=new ArrayList<AVCommand>();
                    CommandAsyncTask NexusTask;
                    MacroActivityNexusActive.addAll(TheaterRoomMacro.MacroActivityCoreVisualOn);
                    MacroActivityNexusActive.addAll(TheaterRoomMacro.MacroActivityCoreAudioOn);
                    MacroActivityNexusActive.add(new IPCommand(TheaterRoom.AVAmp,"InputAV4"));
                    MacroActivityNexusActive.add(new WaitCommand(200));
                    NexusTask=new CommandAsyncTask(getActivity(),MacroActivityNexusActive);
                    NexusTask.setOnCallBack(new CommandAsyncTask.CallBackTask(){

                        @Override
                        public void CallBack() {
                            super.CallBack();
                            Intent intent = new Intent();
                            intent.setClassName("com.google.android.tv.remote", "com.google.android.tv.remote.RemoteActivity");
                            startActivity(intent);                    // アプリを起動
                        }

                    });
                    NexusTask.execute();
                    break;
                case R.id.buttonHomeDLNA: // 入力をDLNAに切り替えてBubbleUPNP起動
                    ArrayList<AVCommand> MacroActivityDLNAActive=new ArrayList<AVCommand>();
                    CommandAsyncTask DLNATask;
                    if(chkboxAOff.isChecked())
                        MacroActivityDLNAActive.addAll(TheaterRoomMacro.MacroActivityCoreVisualOff);
                    MacroActivityDLNAActive.addAll(TheaterRoomMacro.MacroActivityCoreAudioOn);
                    MacroActivityDLNAActive.add(new IPCommand(TheaterRoom.AVAmp,"InputDLNA"));
                    MacroActivityDLNAActive.add(new WaitCommand(200));
                    DLNATask=new CommandAsyncTask(getActivity(),MacroActivityDLNAActive);
                    DLNATask.setOnCallBack(new CommandAsyncTask.CallBackTask(){

                        @Override
                        public void CallBack() {
                            super.CallBack();
                            Intent intent = new Intent();
                            intent.setClassName("com.bubblesoft.android.bubbleupnp", "com.bubblesoft.android.bubbleupnp.MainActivity");
                            startActivity(intent);                    // アプリを起動
                        }

                    });
                    DLNATask.execute();
                    break;
                case R.id.buttonHomeDS: // 入力をDLNAに切り替えてBubbleUPNP起動
                    ArrayList<AVCommand> MacroActivityDSActive=new ArrayList<AVCommand>();
                    CommandAsyncTask DSTask;
                    if(chkboxAOff.isChecked())
                        MacroActivityDSActive.addAll(TheaterRoomMacro.MacroActivityCoreVisualOff);
                    MacroActivityDSActive.addAll(TheaterRoomMacro.MacroActivityCoreAudioOn);
                    MacroActivityDSActive.add(new IPCommand(TheaterRoom.AVAmp,"InputAudio3"));
                    MacroActivityDSActive.add(new WaitCommand(200));
                    DSTask=new CommandAsyncTask(getActivity(),MacroActivityDSActive);
                    DSTask.setOnCallBack(new CommandAsyncTask.CallBackTask(){

                        @Override
                        public void CallBack() {
                            super.CallBack();
                            Intent intent = new Intent();
                            intent.setClassName("com.bubblesoft.android.bubbleupnp", "com.bubblesoft.android.bubbleupnp.MainActivity");
                            startActivity(intent);                    // アプリを起動
                        }

                    });
                    DSTask.execute();
                    break;
                case R.id.buttonHomePowerOff:
                    ArrayList<AVCommand> MacroActivityAllOff=new ArrayList<AVCommand>();
                    MacroActivityAllOff.addAll(TheaterRoomMacro.MacroActivityCoreVisualOff);
                    MacroActivityAllOff.addAll(TheaterRoomMacro.MacroActivityCoreAudioOff);
                    MacroActivityAllOff.addAll(TheaterRoomMacro.MacroActivitySourceVisualOff);
                    // BD-W500 電源検出
                    IPCommand W500PowerOffCommand = new IPCommand(TheaterRoom.IoTWeatherKit, "GetOptIn");
                    ExecutorService service2 = Executors.newCachedThreadPool();
                    Future<byte[]> future2=service2.submit(new GetParamCallable(W500PowerOffCommand));
                    byte[] res2=future2.get();
                    String strres2=new String(res2, "US-ASCII");
                    if(strres2.equals("ON")){   // ONならコマンド追加
                        MacroActivityAllOff.add(new IRCommand(TheaterRoom.SharpBD,"power"));
                        MacroActivityAllOff.add(new WaitCommand(200));
                    }
                    new CommandAsyncTask(getActivity(),MacroActivityAllOff).execute();
                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}