package will.com.github.deeplink;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class DeepLinkActivityTwo extends AppCompatActivity {

    TextView tv_data;

    String scheme;
    String host;
    List<String> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);

        tv_data = (TextView) findViewById(R.id.tv_data);

        getDataFromBrowser();
    }

    /**
     * 从deep link中获取数据
     */
    private void getDataFromBrowser() {
        Uri data = getIntent().getData();
        try {
            scheme = data.getScheme(); // "will"
            host = data.getHost(); // "share"
            params = data.getPathSegments();
            String testId = params.get(0); // "uuid"
            tv_data.setText("DeepLinkActivityTwo Scheme: " + scheme + "\n" + "host: " + host + "\n" + "params: " + testId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
