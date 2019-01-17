package com.pchmn.sample.materialchipsinput;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pchmn.materialchips.ChipsInput;
import com.pchmn.materialchips.model.ChipInterface;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChipInputActivity extends AppCompatActivity {

    private static final String TAG = ChipInputActivity.class.toString();
    @BindView(R.id.chips_input) ChipsInput mChipsInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        // butter knife
        ButterKnife.bind(this);

        mChipsInput.addChipsListener(new ChipsInput.ChipsListener() {
            @Override
            public void onChipAdded(ChipInterface chip, int newSize) {

            }

            @Override
            public void onChipRemoved(ChipInterface chip, int newSize) {

            }

            @Override
            public void onTextChanged(CharSequence text) {
                List<Character> chipTerminators = Arrays.asList(' ', ',', ';');
                if(text.length() > 0) {
                    int terminatingIndex = text.length() - 1;
                    char lastCharacter = text.charAt(terminatingIndex);
                    if(chipTerminators.contains(lastCharacter) && terminatingIndex > 0) {
                        String textToChipify = text.subSequence(0, terminatingIndex).toString();
                        mChipsInput.addChip(textToChipify, textToChipify);
                    }
                }
            }
        });
        mChipsInput.setInputKeyInterceptor(text -> {
            if(!text.isEmpty()) {
                mChipsInput.addChip(text, text);
            }
        });
    }
}
