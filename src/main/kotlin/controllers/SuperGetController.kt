package controllers

import interfaces.RequestListener
import interfaces.RetroDataRequest
import models.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SuperGetController
{
    var apiKey: String = ""

    private val retrofit = Retrofit.Builder().baseUrl("https://api.superget.co.il")
        .addConverterFactory(GsonConverterFactory.create()).build()

    private val retroClient = retrofit.create(RetroDataRequest::class.java)

    fun getPrudectByBarcode(barcode: String, limit: Int, requestListener: RequestListener)
    {
        retroClient.getProductsByBarCode(apiKey,"GetProductsByBarCode" ,barcode,limit)
            .enqueue(object : Callback<Array<Product>>
            {
                override fun onResponse(call: Call<Array<Product>>, response: Response<Array<Product>>) {
                    val arrayList = ArrayList<Product>()


                    response.body().let {
                        if(it != null)
                        {
                            arrayList.add(it[0])
                            requestListener.onComplete(arrayList.toArray())
                        }
                    }
                }

                override fun onFailure(call: Call<Array<Product>>, t: Throwable)
                {
                    t.cause.toString()?.let { requestListener.onError(it) }

                }



            })


    }

}