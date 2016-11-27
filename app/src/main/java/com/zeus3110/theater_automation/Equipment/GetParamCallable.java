package com.zeus3110.theater_automation.Equipment;

import java.util.concurrent.Callable;

/**
 * Created by super on 2016/06/05.
 */
public class GetParamCallable implements Callable<byte []> {

    private IPCommand Command;
    private String Err=null;
    private int i=0;

    // constructor
    public GetParamCallable(IPCommand com){
        Command=com;
    }

    @Override
    public byte[] call() throws Exception {
        byte[] res = {' ', ' ', ' '};

        try {
            res = Command.GetParam();
        } catch (Exception e) {
            Err = e.toString();
        }
        return res;
    }
}
