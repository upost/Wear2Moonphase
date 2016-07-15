package de.ludetis.android.wear2moonphase;

import android.graphics.drawable.Icon;
import android.support.wearable.complications.ComplicationData;
import android.support.wearable.complications.ComplicationManager;
import android.support.wearable.complications.ComplicationProviderService;

import java.util.Calendar;

/**
 * Created by uwe on 30.06.16.
 */
public class MoonphaseProviderService extends ComplicationProviderService {

    private int[] MOONPHASE_ICONS = {R.drawable.phase0,R.drawable.phase1,R.drawable.phase2,
            R.drawable.phase3,R.drawable.phase4,R.drawable.phase5,
            R.drawable.phase6,R.drawable.phase7};

    @Override
    public void onComplicationUpdate(int complicationId, int dataType, ComplicationManager complicationManager) {

        if(dataType== ComplicationData.TYPE_SMALL_IMAGE) {
            MoonPhase moonPhase = new MoonPhase(Calendar.getInstance());
            Icon icon = Icon.createWithResource(getApplicationContext(), MOONPHASE_ICONS[moonPhase.getPhaseIndex()]);
            ComplicationData complicationData = new ComplicationData.Builder(ComplicationData.TYPE_SMALL_IMAGE).setSmallImage(icon).build();
            complicationManager.updateComplicationData(complicationId,complicationData);
        }

    }
}
