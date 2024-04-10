package ro.pub.cs.systems.eim.practicaltest01var07;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PracticalTest01Var07Service extends Service {

    private ProcessingThread processingThread;
    public PracticalTest01Var07Service() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("PracticalTest01Service", "onStartCommand() callback method was invoked");
        processingThread = new ProcessingThread(PracticalTest01Var07Service.this);
        processingThread.start();
        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    public void onDestroy() {
        super.onDestroy();
        processingThread.stopThread();
    }
}