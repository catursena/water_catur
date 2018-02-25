package android.catursena.com.CATURSENA_1202152171_MODUL3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Toast.makeText(this, "CaturSena_1202152171_Modul3", Toast.LENGTH_SHORT).show(); //menampilkan pesan toast "RAZAIQBAL_1202152163_MODUL3"
        Thread thread = new Thread(){
            public void run() {
                try {
                    sleep(4000); //splashscreen akan muncul selama 4 detik
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashScreenActivity.this, LoginAcivity.class)); //setelah splash screen, lalu menuju ke login activity
                    finish();
                }
            }
        };
        thread.start();
    }
}
