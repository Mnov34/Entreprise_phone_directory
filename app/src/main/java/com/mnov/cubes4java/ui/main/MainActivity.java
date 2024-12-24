package com.mnov.cubes4java.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mnov.cubes4java.R;
import com.mnov.cubes4java.data.adapters.EmployeeAdapter;
import com.mnov.cubes4java.data.models.Employee;
import com.mnov.cubes4java.data.network.ApiClient;
import com.mnov.cubes4java.data.network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private List<Employee> employees = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new EmployeeAdapter(employees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fetchEmployees();
    }

    private void fetchEmployees() {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        apiService.getEmployees().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("MainActivity", "Got " + response.body().size() + " employees");
                    employees.clear();
                    employees.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Fetch error: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

}
