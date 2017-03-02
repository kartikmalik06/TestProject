package com.app.digitalfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.digitalfood.DataObject.Restaurent;
import com.app.digitalfood.component.RestaurentListAdapter;
import com.threededge.digitalfood.R;

import java.util.List;

public class ListRestaurentActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView restaurentListView;
    private List<Restaurent> restaurents;
    private RestaurentListAdapter restaurentListAdapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurent);
        restaurentListView = (ListView) findViewById(R.id.restaurent_list);
        // need to call webservice to fetch restaurent list according to postal code
        restaurentListAdapter = new RestaurentListAdapter(this, restaurents);

        restaurentListView.setAdapter(restaurentListAdapter);
        restaurentListView.setOnItemClickListener(this);
        super.setActionBarTitle("RESTAURENTS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //need to call webservice to get restaurent info
        intent=new Intent(getApplicationContext(),MyOrderPageActivity.class);
        //put restaurent info
        startActivity(intent);

    }
}
