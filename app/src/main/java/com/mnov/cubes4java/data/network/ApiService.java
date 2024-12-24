package com.mnov.cubes4java.data.network;

import com.mnov.cubes4java.data.models.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @GET("employees")
    Call<List<Employee>> getEmployees();

    @POST("employees")
    Call<Employee> addEmployee(@Body Employee employee);
}
