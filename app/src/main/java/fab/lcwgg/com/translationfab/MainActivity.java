package fab.lcwgg.com.translationfab;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageButton;
import android.widget.Toolbar;

import nl.codesoup.cubicbezier.CubicBezierInterpolator;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener{

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            final ImageButton fabButton = (ImageButton) rootView.findViewById(R.id.fab_button);

           fabButton.setOnClickListener(this);

            return rootView;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.fab_button) {

                final AnimatorSet set = new AnimatorSet();
                final ObjectAnimator slide = ObjectAnimator.ofFloat(v, View.TRANSLATION_X, 0, -570);
                slide.setDuration(1000);
                slide.setInterpolator(new CubicBezierInterpolator(1, 1, 1, 1));

                final ObjectAnimator slide2 = ObjectAnimator.ofFloat(v, View.TRANSLATION_Y, 0, -930);
                slide2.setDuration(1000);
                slide2.setInterpolator(new CubicBezierInterpolator(.1, .7, .5, 1));

                set.play(slide).with(slide2);
                set.start();
            }
        }
    }
}
