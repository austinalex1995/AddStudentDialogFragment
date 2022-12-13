//
//
// TOP Development
// AddStudentDialogFragment.java
//
//

package com.topdev.jarvised.DialogFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.topdev.jarvised.Callbacks.DefaultDialogCallback;
import com.topdev.jarvised.R;

public class AddStudentDialogFragment extends BaseDialogFragment {

    /*
     *
     * Member Variables
     *
     */

    private DefaultDialogCallback mDialogCallback;



    /*
     *
     * Constructor
     *
     */

    public AddStudentDialogFragment(DefaultDialogCallback callback) {

        mDialogCallback = callback;

    }



    /*
     *
     * Lifecycle Methods
     *
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layoutView = inflater.inflate(R.layout.dialog_add_student_layout, container, false);

        final EditText et = layoutView.findViewById(R.id.edittext_student_name);
        Button b = layoutView.findViewById(R.id.button_confirm);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkStudentName(et.getText().toString());

            }
        });

        b = layoutView.findViewById(R.id.button_cancel);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();

            }
        });

        View v = layoutView.findViewById(R.id.view_background);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();

            }
        });

        return layoutView;

    }



    /*
     *
     * Class Methods
     *
     */

    private void checkStudentName(String name) {

        if (name.isEmpty()) {
            mMACallback.postToastMessage(getResources().getString(R.string.toast_message_student_name_invalid));
        } else {
            mDialogCallback.stringDialogResponse(name);
            dismiss();
        }

    }

}
