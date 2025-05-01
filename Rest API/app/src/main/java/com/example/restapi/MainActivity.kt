package com.example.restapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.restapi.api.ApiClient
import com.example.restapi.api.adapter.ProductAdapter
import com.example.restapi.api.model.Product
import com.example.restapi.api.model.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var call: Call<ProductResponse>
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeRefresh = findViewById(R.id.refresh_layout)
        recyclerView = findViewById(R.id.recycler_view)

        productAdapter = ProductAdapter { product -> productOnClick(product) }
        recyclerView.adapter = productAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        swipeRefresh.setOnRefreshListener {
            getData()
        }
        getData()
    }

    private fun productOnClick(product: Product) {
        Toast.makeText(applicationContext, product.description, Toast.LENGTH_SHORT).show()
    }

    private fun getData() {
        swipeRefresh.isRefreshing = true

        call = ApiClient.productService.getAll()
        call.enqueue(object : Callback<ProductResponse>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<ProductResponse>, response: Response<ProductResponse>
            ) {
                swipeRefresh.isRefreshing = false
                if (response.isSuccessful) {
                    productAdapter.submitList(response.body()?.products)
                    productAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                swipeRefresh.isRefreshing = false
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
