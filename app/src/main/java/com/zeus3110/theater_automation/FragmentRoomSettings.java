package com.zeus3110.theater_automation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.GetParamAsyncTask;
import com.zeus3110.theater_automation.Equipment.GetParamCallable;
import com.zeus3110.theater_automation.Equipment.GetParamsCallable;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.IRCommand;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSharpBD#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRoomSettings extends Fragment implements View.OnClickListener{
    private static final String ARG_SECTION_NUMBER = "section_number";

    private ArrayList<byte[]> EnvResParam;
    private ArrayList<IPCommand> EnvReqParam;
    private ArrayList<TextView> EnvDisplayParam;
    private TextView tmp1;
    private String[] EnvUnit={" ℃"," %"," hPa"," lux"," PPM"};

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRoomSettings newInstance(int sectionNumber) {
        FragmentRoomSettings fragment = new FragmentRoomSettings();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentRoomSettings() {
        EnvParamSet();
    }

    private void EnvParamSet(){
        // EnvResParam=new ArrayList<byte[]>();
        EnvReqParam=new ArrayList<IPCommand>();
        EnvDisplayParam=new ArrayList<TextView>();

        EnvReqParam.add(new IPCommand(TheaterRoom.IoTWeatherKit,"GetTemp"));
        EnvReqParam.add(new IPCommand(TheaterRoom.IoTWeatherKit,"GetHumid"));
        EnvReqParam.add(new IPCommand(TheaterRoom.IoTWeatherKit,"GetPress"));
        EnvReqParam.add(new IPCommand(TheaterRoom.IoTWeatherKit,"GetLux"));
        EnvReqParam.add(new IPCommand(TheaterRoom.IoTWeatherKit,"GetCO2"));
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

        View v = inflater.inflate(R.layout.fragment_room_settings, container, false);
        ((Button) v.findViewById(R.id.button_Light1)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light2)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light3)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light4)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light5)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light6)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light7)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_Light8)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_LightOff)).setOnClickListener((View.OnClickListener) this);
        ((Button) v.findViewById(R.id.button_EnvTestRead)).setOnClickListener((View.OnClickListener) this);

        EnvDisplayParam.add((TextView) v.findViewById(R.id.textView_Env_Temp));
        tmp1=(TextView)v.findViewById(R.id.textView_Env_Temp);
        EnvDisplayParam.add((TextView) v.findViewById(R.id.textView_Env_Humid));
        EnvDisplayParam.add((TextView) v.findViewById(R.id.textView_Env_Press));
        EnvDisplayParam.add((TextView) v.findViewById(R.id.textView_Env_Lux));
        EnvDisplayParam.add((TextView) v.findViewById(R.id.textView_Env_CO2));

        v.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {


                switch (keyCode) {
                    case KeyEvent.KEYCODE_VOLUME_UP:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"Vol+")).execute();
                        return true;
                    case KeyEvent.KEYCODE_VOLUME_DOWN:
                        new CommandAsyncTask(getActivity(), new IPCommand(TheaterRoom.AVAmp,"Vol-")).execute();
                        return true;
                    case KeyEvent.KEYCODE_DPAD_UP:
                        return true;
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        return true;
                    case KeyEvent.KEYCODE_DPAD_LEFT:
                        return true;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_A:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_B:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_X:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_Y:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_L1:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_L2:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_R1:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_R2:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_SELECT:
                        return true;
                    case KeyEvent.KEYCODE_BUTTON_START:
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

    public void SetEnvResult(ArrayList<byte[]> res){
        int i;
        try{
            for(i=0;i<res.size();i++){
                EnvDisplayParam.get(i).setText(new String(res.get(i), "US-ASCII")+EnvUnit[i]);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // �{�^���C�x���g
    public void onClick(View v) {
        try{
            switch (v.getId()) {
                // 10Key
                case R.id.button_Light1:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset1")).execute();
                    break;
                case R.id.button_Light2:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset2")).execute();
                    break;
                case R.id.button_Light3:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset3")).execute();
                    break;
                case R.id.button_Light4:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset4")).execute();
                    break;
                case R.id.button_Light5:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset5")).execute();
                    break;
                case R.id.button_Light6:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset6")).execute();
                    break;
                case R.id.button_Light7:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset7")).execute();
                    break;
                case R.id.button_Light8:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"Preset8")).execute();
                    break;
                case R.id.button_LightOff:
                    new CommandAsyncTask(getActivity(), new IRCommand(TheaterRoom.LightManager,"AllOff")).execute();
                    break;
                case R.id.button_EnvTestRead:
                    /*
                    ExecutorService service = Executors.newCachedThreadPool();
                    Future<ArrayList<byte[]>> future = service.submit(new GetParamsCallable(EnvReqParam));
                    EnvResParam= future.get();
                    int i;
                    for(i=0;i<EnvResParam.size();i++){
                        EnvDisplayParam.get(i).setText(new String(EnvResParam.get(i), "US-ASCII")+EnvUnit[i]);
                    }
                    */

                    GetParamAsyncTask EnvTask=new GetParamAsyncTask(EnvReqParam);
                    EnvTask.setOnCallBack(new GetParamAsyncTask.CallBackTask(){

                        @Override
                        public void CallBack(ArrayList<byte[]> res) {
                            super.CallBack(res);
                            SetEnvResult(res);
                        }
                    });
                    EnvTask.execute();

                    break;
                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}