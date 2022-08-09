package livewall.basic.view_bind_data_bind_rv;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import livewall.basic.view_bind_data_bind_rv.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements RecyclerViewItemClick {

    ActivityMainBinding binding;

    List<VisionModel> mainModellist;
    MainAdapter mainAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainModellist = new ArrayList<>();

        setRecycleData();


    }

    private void setRecycleData() {

        mainAdapter = new MainAdapter(this, this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recyclerView.setAdapter(mainAdapter);

        fetchJSON();

    }


    private void fetchJSON() {

        mainModellist = new ArrayList<>();
        mainModellist.add(new VisionModel("model1", "Description1"));
        mainModellist.add(new VisionModel("model2", "Description2"));
        mainModellist.add(new VisionModel("model3", "Description3"));
        mainModellist.add(new VisionModel("model4", "Description4"));
        mainModellist.add(new VisionModel("model5", "Description5"));

        mainAdapter.setList(mainModellist);

        mainAdapter.notifyDataSetChanged();

        toggleData();


    }


    private void toggleData() {

        if (mainModellist.size() > 0) {

            binding.llRv.setVisibility(View.VISIBLE);
            binding.llNodata.setVisibility(View.GONE);

        } else {

            binding.llRv.setVisibility(View.GONE);
            binding.llNodata.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onItemClick(VisionModel str, int i) {

    }
}