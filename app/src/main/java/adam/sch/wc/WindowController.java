package adam.sch.wc;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.view.View;
import android.widget.Button;

/**
 * Created by edems on 2015.09.01..
 */
public class WindowController implements View.OnClickListener {

    private static final int sCarrierFrequency = 0;
    private static final int[] sOpenPattern = {0};
    private static final int[] sClosePattern = {0};

    private ConsumerIrManager mIR;
    private Button btnOpen, btnClose;

    public WindowController(Context context) {
        mIR = (ConsumerIrManager)context.getSystemService(Context.CONSUMER_IR_SERVICE);
    }

    public boolean isAvailable() {
        return mIR != null && mIR.hasIrEmitter();
    }

    public void setButtons(Button open, Button close) {
        btnOpen = open;
        btnClose = close;

        open.setOnClickListener(this);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if( !isAvailable() )
            return;

        if( v.equals(btnOpen) )
            Open();
        else
            Close();
    }

    private void Open() {
        mIR.transmit(sCarrierFrequency, sOpenPattern);
    }

    private void Close() {
        mIR.transmit(sCarrierFrequency, sClosePattern);
    }
}
