package org.florescu.android.rangeseekbar.sample;

import android.content.Context;
import android.util.AttributeSet;

import org.florescu.android.rangeseekbar.RangeSeekBar;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ItemPriceRangeSeekBar extends RangeSeekBar<Integer> {

    public static final int PRICE_RANGE[] = {
            0, 500, 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000,
            10000, 11000, 12000, 13000, 14000, 15000, 16000, 17000, 18000, 19000,
            20000, 21000, 22000, 23000, 24000, 25000, 26000, 27000, 28000, 29000,
            30000, 31000, 32000, 33000, 34000, 35000, 36000, 37000, 38000, 39000,
            40000, 41000, 42000, 43000, 44000, 45000, 46000, 47000, 48000, 49000,
            50000, 55000, 60000, 65000, 70000, 75000, 80000, 85000, 90000, 95000,
            100000, 110000, 120000, 130000, 140000, 150000, 999999
    };

    public static final Map<Integer, Integer> PRICE_JA_TEXT_MAP;

    static {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, R.string.min_label);
        map.put(999999, R.string.max_label);
        PRICE_JA_TEXT_MAP = Collections.unmodifiableMap(map);
    }

    public ItemPriceRangeSeekBar(Context context) {
        super(context);
    }

    public ItemPriceRangeSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemPriceRangeSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected String valueToString(Integer value) {
        Integer price = PRICE_RANGE[value];
        if (PRICE_JA_TEXT_MAP.containsKey(price)) {
            return getContext().getResources().getString(PRICE_JA_TEXT_MAP.get(price));
        }
        return formatPriceString(price);
    }

    @Override
    protected boolean valueIsJa(Integer value) {
        return PRICE_JA_TEXT_MAP.containsKey(PRICE_RANGE[value]);
    }

    private String formatPriceString(int price) {
        return "¥" + String.format(Locale.JAPAN, "%,d", price);
    }

}
