package com.notes.ui.activity.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.notes.activity.R;
import com.notes.db.models.core.Module;
import com.notes.db.services.core.ModuleService;
import com.notes.rest.RestClient;
import com.notes.rest.service.callbacks.CoreFactorySetingsCallback;
import com.notes.rest.service.callbacks.QuestionAnswerCallback;
import com.notes.rest.service.dto.CoreFactoryDto;
import com.notes.rest.service.dto.QuestionAnswerDto;

import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        //get full screen
        //requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this.deleteDatabase("pickpick");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Part to populate the DB
                Snackbar.make(view, "Downloading Content. Sit back and relax.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                RestClient client = new RestClient();
                Call<CoreFactoryDto> factoryData = client.getCoreServices().coreFactorySettings();
                factoryData.enqueue(new CoreFactorySetingsCallback());

                List<Module> allModules = ModuleService.allModules();
                System.out.println("PARTHA Module Size:" + allModules.size());
                for(Module module : allModules) {
                    System.out.println("PARTHA" + module.getModuleId());
                    Call<QuestionAnswerDto> questionAnswers = client.getCoreServices().questionAnswers(module.getModuleId());
                    questionAnswers.enqueue(new QuestionAnswerCallback());
                }

                /*Call<QuestionAnswerDto> questionAnswers = client.getCoreServices().questionAnswers(8L);
                questionAnswers.enqueue(new QuestionAnswerCallback());*/

                /*ImageStorer imageStorer = SubjectService.findAImageStorer("SOMETWO1");
                if(imageStorer != null) {
                    ImageView imageView = (ImageView) findViewById(R.id.imageView);
                    Bitmap bm = BitmapFactory.decodeByteArray(imageStorer.imageBlob, 0, imageStorer.imageBlob.length);
                    imageView.setImageBitmap(bm);
                } else {
                    System.out.println("No Such Image to display");
                }*/


            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Remove the Navigation Bar
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
