package yoshioka.test.fragmentbackstacktest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yoshioka.test.fragmentbackstacktest.databinding.LayoutFragmentCBinding;

public class FragmentC extends Fragment {

    private LayoutFragmentCBinding binding;

    private TestModel model;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            model = (TestModel) getArguments().getSerializable("model");
        } else {
            model = (TestModel) savedInstanceState.getSerializable("model");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("model", model);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_fragment_c, container, false);
        binding.setModel(model);

        return binding.getRoot();
    }
}
