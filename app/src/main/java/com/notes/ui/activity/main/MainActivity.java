package com.notes.ui.activity.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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
        //get full screen
        /*requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        this.getWindow().setFlags(WindowManager.LayoutParams.F, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/

        super.onCreate(savedInstanceState);

        //View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        //decorView.setSystemUiVisibility(uiOptions);

        /*decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        // Note that system bars will only be "visible" if none of the
                        // LOW_PROFILE, HIDE_NAVIGATION, or FULLSCREEN flags are set.
                        //View.SYSTEM_UI_FLAG_FULLSCREEN
                        if ((visibility & View.SYSTEM_UI_FLAG_HIDE_NAVIGATION) == 0) {
                            // TODO: The system bars are visible. Make any desired
                            // adjustments to your UI, such as showing the action bar or
                            // other navigational controls.
                            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                        } else {
                            // TODO: The system bars are NOT visible. Make any desired
                            // adjustments to your UI, such as hiding the action bar or
                            // other navigational controls.
                        }
                    }
                });*/


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //this.deleteDatabase("pickpick");
        System.out.println("PARTHA : Database deleted");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Part to populate the DB
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
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
