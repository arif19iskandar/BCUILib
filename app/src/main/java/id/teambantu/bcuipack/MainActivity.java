package id.teambantu.bcuipack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import id.teambantu.bcuilib.BCUILayout;
import id.teambantu.bcuilib.event.BCDialogButton;
import id.teambantu.bcuilib.utils.BCImage;
import id.teambantu.bcuipack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BCUILayout bcuiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        bcuiLayout = new BCUILayout(this, binding.getRoot());

        setContentView(bcuiLayout.getRoot());

    }


    public void cek(final View view) {
        bcuiLayout.showBottomSheet();
    }

    public void showAlert(View view) {
        bcuiLayout.showAlert("Ups, Alert Shown", BCUILayout.AlertType.PRIMARY, BCUILayout.Time.LONG);
    }

    public void showConfirmDialog1(View view) {
        bcuiLayout.showProgressDialog("Tungguuuu", "jangan tinggalin aku", true);
    }

    @Override
    public void onBackPressed() {
        if(bcuiLayout.onBackPressed())
            super.onBackPressed();
    }
}