package com.zeus3110.theater_automation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zeus3110.theater_automation.Equipment.CommandAsyncTask;
import com.zeus3110.theater_automation.Equipment.GetParamCallable;
import com.zeus3110.theater_automation.Equipment.IPCommand;
import com.zeus3110.theater_automation.Equipment.IRKitCommand;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudyRoomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudyRoomFragment extends Fragment implements OnClickListener {
    private static final String ARG_SECTION_NUMBER = "section_number";

    TextView TempData;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StudyRoomFragment newInstance(int sectionNumber) {
        StudyRoomFragment fragment = new StudyRoomFragment();
        Bundle args = new Bundle();

        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public StudyRoomFragment() {
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

        View v = inflater.inflate(R.layout.fragment_study_room, container, false);
        ((Button) v.findViewById(R.id.ButtonSharpBDKey1)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.Button_Read)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonON1)).setOnClickListener((OnClickListener) this);
        ((Button) v.findViewById(R.id.ButtonOFF1)).setOnClickListener((OnClickListener) this);
        TempData= (TextView) v.findViewById(R.id.textView_SFCName);

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

    // �{�^���C�x���g
    public void onClick(View v) {
        try{
            switch (v.getId()) {

                //DMR-BZT910 Activity
                case R.id.ButtonSharpBDKey1:
                    new CommandAsyncTask(getActivity(), new IRKitCommand(StudyRoom.MaruzenLight, "OnOff")).execute();
                    break;

                case R.id.ButtonON1:
                    new CommandAsyncTask(getActivity(), new IPCommand(StudyRoom.IoTWeatherKit, "Out1On")).execute();
                    break;

                case R.id.ButtonOFF1:
                    new CommandAsyncTask(getActivity(), new IPCommand(StudyRoom.IoTWeatherKit, "Out1Off")).execute();
                    break;

                case R.id.Button_Read:
                    IPCommand Command = new IPCommand(StudyRoom.IoTWeatherKit, "GetInput1");
                    ExecutorService service = Executors.newCachedThreadPool();
                    Future<byte[]> future = service.submit(new GetParamCallable(Command));
                    byte[] res = future.get();
                    TempData.setText(new String(res, "US-ASCII"));
                    break;

                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}