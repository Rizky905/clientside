package com.example.clientside.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Loginresponse(
//    Json id name email email_verified_at created_at updated_at access_token

    @Json(name = "id")
    var id: Int?=0,
    @Json(name = "name")
    var name:String?="",
    @Json(name = "email")
    var email:String?="",
    @Json(name = "email_verified_at")
    var emailVerifiedAt:String?="",
    @Json(name = "created_at")
    var createdAt:String?="",
    @Json(name = "updated_at")
    var updatedAt:String?="",
    @Json(name = "access_token")
    var accessToken:String?=""

)