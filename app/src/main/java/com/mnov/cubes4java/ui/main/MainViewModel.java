package com.mnov.cubes4java.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mnov.cubes4java.data.models.Employee;
import com.mnov.cubes4java.data.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final EmployeeRepository repository;
    private final MutableLiveData<List<Employee>> employees;
    private final MutableLiveData<String> error;

    public MainViewModel() {
        repository = new EmployeeRepository();
        employees = new MutableLiveData<>(new ArrayList<>());
        error = new MutableLiveData<>();
    }

    public LiveData<List<Employee>> getEmployees() {
        return employees;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void fetchEmployees() {
        repository.getAllEmployees().enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call,
                                   Response<List<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    employees.setValue(response.body());
                } else {
                    error.setValue("Fetch error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                error.setValue("Network error: " + t.getMessage());
            }
        });
    }

    public void addEmployee(Employee newEmp) {
        repository.createEmployee(newEmp).enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call,
                                   Response<Employee> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Employee> current = employees.getValue();
                    current.add(response.body());
                    employees.setValue(current);
                } else {
                    error.setValue("Add error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                error.setValue("Network error: " + t.getMessage());
            }
        });
    }
}
