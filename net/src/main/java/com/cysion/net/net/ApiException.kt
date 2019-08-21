package com.cysion.ktbox.net

data class ApiException(val errorCode: String, val errorMsg: String):RuntimeException()