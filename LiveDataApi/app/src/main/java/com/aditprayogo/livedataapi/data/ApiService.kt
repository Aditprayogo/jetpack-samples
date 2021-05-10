package com.aditprayogo.livedataapi.data

import com.aditprayogo.livedataapi.data.response.PostReviewResponse
import com.aditprayogo.livedataapi.data.response.RestaurantResponse
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Aditiya Prayogo.
 */
interface ApiService {
    @GET("detail/{id}")
    fun getRestaurant(
        @Path("id") id: String
    ): Call<RestaurantResponse>

    @FormUrlEncoded
    @Headers("Authorization: token 12345")
    @POST("review")
    fun postReview(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("review") review: String
    ): Call<PostReviewResponse>
}