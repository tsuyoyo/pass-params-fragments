package yoshioka.test.fragmentbackstacktest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TestModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            model = new TestModel();
        } else {
            model = (TestModel) savedInstanceState.getSerializable("model");
        }

        if (getSupportFragmentManager().findFragmentByTag("FragmentA") == null) {
            Fragment fragmentA = new FragmentA();
            Bundle params = new Bundle();
            params.putSerializable("model", model);
            fragmentA.setArguments(params);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_area, fragmentA, "FragmentA");
            fragmentTransaction.commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                android.util.Log.d("TestTestTest", "Number of elements on back stack : "
                        + getSupportFragmentManager().getBackStackEntryCount());
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("model", model);
    }

    public void goToFragmentB(TestModel model) {

        Fragment fragmentB = new FragmentB();

        Bundle params = new Bundle();
        params.putSerializable("model", model);
        fragmentB.setArguments(params);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragment_area, fragmentB, "FragmentB");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack("FragmentB");

        transaction.commit();
    }

    public void goToFragmentC(TestModel model) {
        Fragment fragmentC = new FragmentC();

        Bundle params = new Bundle();
        params.putSerializable("model", model);
        fragmentC.setArguments(params);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_area, fragmentC, "FragmentC");
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack("FragmentC");

        transaction.commit();
    }
}
