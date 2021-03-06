package ct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

public final class bq
  extends PhoneStateListener
{
  volatile boolean a;
  private final bg b;
  private CellLocation c = null;
  private SignalStrength d = null;
  private ServiceState e = null;
  private long f;
  private HandlerThread g;
  private Handler h;
  
  public bq(bg parambg)
  {
    b = parambg;
  }
  
  private void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = b.a();
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException) {}
  }
  
  private boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    try
    {
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (localGsmCellLocation.getCid() == 0)
      {
        int i = localGsmCellLocation.getLac();
        if (i == 0) {
          return false;
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      if (cq.a(paramCellLocation) < 0) {
        return false;
      }
      if (cq.a(c, paramCellLocation)) {
        return false;
      }
      paramCellLocation = cd.a(b, paramCellLocation, null);
      if (paramCellLocation == null) {}
      for (boolean bool = true; bool; bool = cq.a(paramCellLocation)) {
        return true;
      }
    }
    return false;
  }
  
  private void c()
  {
    if (!a) {}
    for (;;)
    {
      return;
      if (c != null)
      {
        long l = System.currentTimeMillis();
        if (l - f > 2000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          f = l;
          cd localcd = cd.a(b, c, d);
          try
          {
            if ((h != null) && (localcd != null))
            {
              b localb = new b(b);
              localb.a(localcd);
              h.post(localb);
            }
            return;
          }
          finally {}
        }
      }
    }
  }
  
  public final void a()
  {
    if (a) {
      return;
    }
    a = true;
    g = new HandlerThread("worker");
    g.start();
    h = new a(g.getLooper(), (byte)0);
    h.sendEmptyMessageDelayed(0, 3000L);
    CellLocation localCellLocation = cq.b(b);
    if (a(localCellLocation))
    {
      cd localcd = cd.a(b, localCellLocation, null);
      if (localcd != null)
      {
        c = localCellLocation;
        b.c(localcd);
      }
    }
    a(273);
  }
  
  public final void b()
  {
    if (!a) {
      return;
    }
    a = false;
    a(0);
    try
    {
      if (h != null)
      {
        h.removeCallbacksAndMessages(null);
        h = null;
      }
      g.quit();
      g = null;
      c = null;
      d = null;
      e = null;
      f = 0L;
      return;
    }
    finally {}
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    if (a(paramCellLocation))
    {
      c = paramCellLocation;
      c();
      return;
    }
    new StringBuilder("onCellLocationChanged: illegal cell or same cell ").append(paramCellLocation);
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    do
    {
      ServiceState localServiceState;
      do
      {
        return;
        localServiceState = e;
      } while ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState()));
      e = paramServiceState;
    } while (!a);
    int i;
    boolean bool;
    if (e != null) {
      if (e.getState() == 0)
      {
        i = 1;
        paramServiceState = b.a();
        bool = cq.a(b.a);
        if (paramServiceState == null) {
          break label171;
        }
        if (paramServiceState.getSimState() != 5) {
          break label166;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (j == 0)) {
        i = 0;
      }
      paramServiceState = new Message();
      what = 12999;
      arg1 = 12003;
      arg2 = i;
      b.c(paramServiceState);
      return;
      if (e.getState() == 1)
      {
        i = 0;
        break;
      }
      i = -1;
      break;
      label166:
      j = 0;
      continue;
      label171:
      j = 0;
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    SignalStrength localSignalStrength;
    int i;
    do
    {
      return;
      localSignalStrength = d;
      i = b.g().b;
    } while ((localSignalStrength != null) && (!cq.a(i, localSignalStrength, paramSignalStrength)));
    d = paramSignalStrength;
    c();
  }
  
  final class a
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!a) {
        return;
      }
      sendEmptyMessageDelayed(0, 20000L);
      paramMessage = cq.b(bq.a(bq.this));
      bq.a(bq.this, paramMessage);
    }
  }
  
  static final class b
    implements Runnable
  {
    private bg a;
    private cd b;
    
    public b(bg parambg)
    {
      a = parambg;
    }
    
    public final void a(cd paramcd)
    {
      b = paramcd;
    }
    
    public final void run()
    {
      bg localbg = a;
      cd localcd = b;
      if (localcd != null)
      {
        localcd.a(cq.c(localbg));
        localbg.c(localcd);
      }
    }
  }
}

/* Location:
 * Qualified Name:     ct.bq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */