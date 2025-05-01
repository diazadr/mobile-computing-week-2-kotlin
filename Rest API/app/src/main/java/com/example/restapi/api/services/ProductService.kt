package com.example.restapi.api.services

import com.example.restapi.api.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    fun getAll(): Call<ProductResponse>
}