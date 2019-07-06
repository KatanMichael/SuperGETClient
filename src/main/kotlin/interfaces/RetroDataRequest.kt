package interfaces

import models.Product
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetroDataRequest
{
    @POST ("/")
    fun getProductsByBarCode(@Query("api_key") api_key: String,
                             @Query("action") action: String = "GetProductsByBarCode",
                             @Query("product_barcode") barcode: String,
                             @Query("limit") limit: Int) :
            retrofit2.Call<Array<Product>>


}