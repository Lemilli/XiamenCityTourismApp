package com.example.finalmobile;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private TextView terms, help, log_out, changePass, profile_username;
    private RelativeLayout delete_acc;
    private DatabaseHelper db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);

        db = new DatabaseHelper(getActivity());

        terms = v.findViewById(R.id.tv_terms_of_service);
        help = v.findViewById(R.id.tv_get_help);
        log_out = v.findViewById(R.id.textView11);
        delete_acc = v.findViewById(R.id.profile_delete_account);
        changePass = v.findViewById(R.id.tv_change_pass);
        profile_username = v.findViewById(R.id.profile_username);

        SharedPreferences prefs = getActivity().getSharedPreferences("PrefsFile", MODE_PRIVATE);
        String username = prefs.getString("username", "username");
        profile_username.setText(username);

        changePass.setOnClickListener(view -> {
            Intent i = new Intent(getActivity(), ChangePasswordActivity.class);
            startActivity(i);
        });

        terms.setOnClickListener(view -> {
            Intent i = new Intent(getActivity(), TermsOfServiceActivity.class);
            startActivity(i);
        });

        help.setOnClickListener(view ->{
            Intent i = new Intent(getActivity(), GetHelpActivity.class);
            startActivity(i);
        });

        log_out.setOnClickListener(view -> {
            Intent i = new Intent(getActivity(), StartActivity.class);
            startActivity(i);
            getActivity().finish();
        });

        delete_acc.setOnClickListener(view -> {
            ShowMessage("Warning", "Do you want to delete your account?");
        });



        return v;
    }

    public void ShowMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setNegativeButton("No", (dialogInterface, i) -> {});
        builder.setPositiveButton("Yes", (dialogInterface, i) -> {
            SharedPreferences prefs = getActivity().getSharedPreferences("PrefsFile", MODE_PRIVATE);
            String username = prefs.getString("username", "");

            boolean isDeleted = db.deleteAccount(username);

            if(isDeleted){
                Intent intent = new Intent(getActivity(), StartActivity.class);
                Toast.makeText(getActivity(), "Done!", Toast.LENGTH_LONG).show();
                startActivity(intent);
                getActivity().finish();
            } else{
                Toast.makeText(getActivity(), "Failed. Try again later.", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }
}