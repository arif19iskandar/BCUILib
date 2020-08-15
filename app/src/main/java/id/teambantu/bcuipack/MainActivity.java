package id.teambantu.bcuipack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import id.teambantu.bcuilib.BCUI;
import id.teambantu.bcuipack.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    BCUI bcuiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        bcuiLayout = new BCUI(this, binding.getRoot());

        setContentView(bcuiLayout.getRoot());

    }


    public void cek(final View view) {
        bcuiLayout.showBottomSheet();
    }

    public void showAlert(View view) {
        bcuiLayout.showAlert("Ups, Alert Shown", BCUI.AlertType.PRIMARY, BCUI.Time.LONG);
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