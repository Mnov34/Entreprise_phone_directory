package com.mnov.cubes4java.data.repositories;

import com.mnov.cubes4java.data.models.Employee;
import com.mnov.cubes4java.data.network.ApiClient;
import com.mnov.cubes4java.data.network.ApiService;

import java.util.List;

import retrofit2.Call;

public class EmployeeRepository {
    private ApiService apiService;

    public EmployeeRepository() {
        apiService = ApiClient.getClient().create(ApiService.class);
    }

    public Call<List<Employee>> getAllEmployees() {
        return apiService.getEmployees();
    }

    public Call<Employee> createEmployee(Employee newEmp) {
        return apiService.addEmployee(newEmp);
    }
}
