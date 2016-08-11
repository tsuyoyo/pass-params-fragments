package yoshioka.test.fragmentbackstacktest;

import android.databinding.ObservableField;

import java.io.Serializable;

public class TestModel implements Serializable {

    private static final long serialVersionUID = -5736701002464920045L;

    public ObservableField<String> strA = new ObservableField<>();
    public ObservableField<String> strB = new ObservableField<>();
    public ObservableField<String> strC = new ObservableField<>();

}
