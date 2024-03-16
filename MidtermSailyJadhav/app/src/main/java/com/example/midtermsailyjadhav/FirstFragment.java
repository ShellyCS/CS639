package com.example.midtermsailyjadhav;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.midtermsailyjadhav.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private EditText litersInput;
    private TextView gallonsOutput;
    private static final String TAG = "TAG";

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        litersInput = binding.editTextLiters;
        gallonsOutput = binding.textViewForGallons;

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                String litersStr = litersInput.getText().toString().trim();

                if (litersStr.isEmpty()) {
                    gallonsOutput.setText("Please enter liters.");
                    Log.i(TAG,"Cant be empty");
                    return;
                }

                try {
                    double liters = Double.parseDouble(litersStr);
                    double gallons = liters * 0.219;
                    gallonsOutput.setText(String.format("%.2f gallons", gallons));
                } catch (NumberFormatException e) {
                    gallonsOutput.setText("Invalid input. Please enter a valid number.");
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}