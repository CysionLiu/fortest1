package com.cysion.forTest.testnet

import com.cysion.net.net.enqueue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun emitAllRequestByKotlin() {
    Caller.api.test_get_path("helloPath").enqueue(object : Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
        }
    })
    Caller.api.test_get_query("value1-1", "value-2").enqueue(object : Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
        }
    })

    Caller.api.test_get_query_map(mutableMapOf("key1" to "value1"))
        .enqueue {
        onSuccess { call, body ->

        }
        onFail { call, t ->

        }
    }

    Caller.api.test_post_form("value1", "value2").enqueue {
        onSuccess { call, body ->

        }
        onFail { call, t ->

        }
    }

    Caller.api.test_post_form_map(mutableMapOf("key1" to "value1")).enqueue { }

    Caller.api.test_post_json(
        mutableMapOf(
            "user" to "cysion",
            "age" to 12,
            "phone" to "185110.。。"
        )
    ).enqueue {

    }

    Caller.api.test_fixed_header().enqueue { }

    Caller.api.test_header_dynamic("the header3").enqueue {  }

    Caller.api.test_post_json_body(AskEntity().apply {
        code=20000
        query="my query"
    }).enqueue {
        onSuccess { call, body ->  }
    }
}

fun emitAllRequestByKotlin2() {
    Caller2.api.test_get_path("helloPath").enqueue(object : Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
        }
    })
    Caller2.api.test_get_query("value1-1", "value-2").enqueue(object : Callback<String> {
        override fun onResponse(call: Call<String>, response: Response<String>) {
        }

        override fun onFailure(call: Call<String>, t: Throwable) {
        }
    })

    Caller2.api.test_get_query_map(mutableMapOf("key1" to "value1")).enqueue {
        onSuccess { call, body ->
        }
        onFail { call, t -> }
    }

    Caller2.api.test_post_form("value1", "value2").enqueue { }

    Caller2.api.test_post_form_map(mutableMapOf("key1" to "value1")).enqueue { }

    Caller2.api.test_post_json(
        mutableMapOf(
            "user" to "cysion",
            "age" to 12,
            "phone" to "185110.。。"
        )
    ).enqueue {
    }

    Caller2.api.test_fixed_header().enqueue { }

    Caller2.api.test_header_dynamic("the header3").enqueue {  }

    Caller2.api.test_post_json_body(
        AskEntity().apply {
            code=3000
            query="my query caller2"
        }
    ).enqueue {
        onSuccess { call, body ->

        }
        onFail { call, t ->

        }
    }
}