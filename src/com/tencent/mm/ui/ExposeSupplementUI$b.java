package com.tencent.mm.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.u;

final class ExposeSupplementUI$b
  implements InputFilter
{
  private int qs = 50;
  
  public ExposeSupplementUI$b(ExposeSupplementUI paramExposeSupplementUI) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    u.d("!44@/B4Tb64lLpLtCwxbDnWL8eYXXy6IqmvtU/Fp3lqpqos=", paramCharSequence + " start:" + paramInt1 + " end:" + paramInt2 + " " + paramSpanned + " dstart:" + paramInt3 + " dend:" + paramInt4);
    float f = ExposeSupplementUI.A(paramSpanned);
    paramInt3 = qs - Math.round(f) - (paramInt4 - paramInt3);
    if (paramInt3 <= 0)
    {
      if ((Float.compare(f, (float)(qs - 0.5D)) == 0) && (paramCharSequence.length() > 0) && (!ay.e(paramCharSequence.charAt(0)))) {
        return paramCharSequence.subSequence(0, 1);
      }
      return "";
    }
    if (paramInt3 >= paramInt2 - paramInt1) {
      return null;
    }
    paramInt3 += paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1) {
        return "";
      }
    }
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.ExposeSupplementUI.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */