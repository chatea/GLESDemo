package idv.chatea.gldemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    private static final String TITLE = "title";

    private String[] mSampleTitle = {
            "GLES 1.0 Background Sample",
            "GLES 1.0 Triangle Sample",
            "GLES 1.0 Drawing Mode Sample",
            "GLES 1.0 Viewport Sample",
            "GLES 1.0 Color Triangle Sample",
            "GLES 1.0 Projection Sample",
            "GLES 1.0 Push/Pop Sample",
            "GLES 1.0 Transform Sample",
            "GLES 1.0 Depth Test Sample",
            "GLES 1.0 Blending Sample",
            "GLES 1.0 Texture Sample",
            "GLES 2.0 Ball Sample",
            "GLES 2.0 Block Ball Sample",
    };

    private Class[] mSampleActivity = {
            GLES1_Background_Activity.class,
            GLES1_Triangle_Activity.class,
            GLES1_DrawElements_Activity.class,
            GLES1_Viewport_Activity.class,
            GLES1_ColorTriangle_Activity.class,
            GLES1_Projection_Activity.class,
            GLES1_PushPop_Activity.class,
            GLES1_Transform_Activity.class,
            GLES1_DepthTest_Activity.class,
            GLES1_Blending_Activity.class,
            GLES1_Texture_Activity.class,
            GLES2_Ball_Activity.class,
            GLES2_BlockBall_Activity.class,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        List<Map<String, Object>> items = createListItems();
        ListAdapter adapter = new SimpleAdapter(this, items, android.R.layout.simple_list_item_1,
                new String[] {TITLE}, new int[] {android.R.id.text1});

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> createListItems() {
        List<Map<String, Object>> items = new ArrayList();
        for (int i = 0; i < mSampleTitle.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put(TITLE, mSampleTitle[i]);
            items.add(map);
        }
        return items;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, mSampleActivity[position]);
        startActivity(intent);
    }
}
