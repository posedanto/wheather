package sudden.rain.today.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;

import java.util.ArrayList;

import javax.inject.Inject;

import sudden.rain.today.R;
import sudden.rain.today.App;
import sudden.rain.today.data.model.Location;
import sudden.rain.today.presentation.contract.ContractSearchCity;
import sudden.rain.today.ui.adapter.AdapterLocations;

public class SearchCityActivity extends AppCompatActivity implements ContractSearchCity.View, SearchView.OnQueryTextListener {

    @Inject
    ContractSearchCity.Presenter presenter;

    private RecyclerView recyclerView;
    private AdapterLocations adapterLocations;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_city);

        App.getComponent().inject(this);

        initView();
    }

    private void initView() {
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapterLocations = new AdapterLocations();
        recyclerView.setAdapter(adapterLocations);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.detachView();
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        presenter.onSearchSubmit(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        presenter.onSearchTextChange(s);
        return false;
    }

    @Override
    public void updateLocations(ArrayList<Location> locations) {
        adapterLocations.setLocations(locations);
        adapterLocations.notifyDataSetChanged();
    }
}
