package com.example.pvh_cenima.common.constant

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("payload")
    val data: T? = null,
    @SerializedName("requestedTime")
    val requestedTime: String? = null
)
