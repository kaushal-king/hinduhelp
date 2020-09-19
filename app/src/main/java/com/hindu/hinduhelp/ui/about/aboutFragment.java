package com.hindu.hinduhelp.ui.about;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.hindu.hinduhelp.R;
import com.hindu.hinduhelp.cmpdetail;

public class aboutFragment extends Fragment {
TextView t,cmp;
ImageView copy;
    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
t=root.findViewById(R.id.gourl);
copy=(ImageView) root.findViewById(R.id.copyimage);
copy.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ClipboardManager cm = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText("kaushaljethava12@gmail.com");
        Toast.makeText(getContext(), "Email is Copyed", Toast.LENGTH_SHORT).show();
    }
});
        cmp=root.findViewById(R.id.samratshop);
        cmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i=new Intent(getContext(), cmpdetail.class);
            startActivity(i);
            }
        });
t.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(t.getText().toString()));
        startActivity(browserIntent);
    }
});
        return root;
    }


}