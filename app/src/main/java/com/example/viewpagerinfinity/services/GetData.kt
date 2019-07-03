package com.example.viewpagerinfinity.services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.Response.Listener

import com.android.volley.toolbox.JsonObjectRequest
import com.example.viewpagerinfinity.models.TabHeader
import org.json.JSONException

class GetData() {
    companion object {
//        fun getListTabHeader(url: String, context: Context) {
//            val listTab = arrayListOf<TabHeader>()
//            val TAG = "abc"
//            Log.d(TAG, "da vao day")
//            val oRequest = object : JsonObjectRequest(Request.Method.GET, url, null,
//                Listener { response ->
//                    try {
//                        Log.d(TAG, "da vao day22")
//                        val tabArray = response.getJSONArray("list_tab")
//                        Log.d(TAG, tabArray.length().toString())
//                        for (i in 0 until tabArray.length()) {
//                            val tab = tabArray.getJSONObject(i)
//                            listTab.add(
//                                TabHeader(
//                                    tab.getString("index"),
//                                    tab.getString("slug"),
//                                    tab.getString("type"),
//                                    tab.getString("url"),
//                                    tab.getString("title")
//                                )
//                            )
//                        }
//                        Log.d(TAG, "avc" + listTab.toString())
//
//                    } catch (e: JSONException) {
//                        Log.d(TAG, "co loi gif do " + e.message)
//                        e.printStackTrace()
//                    }
//                }, Response.ErrorListener { error ->
//                    Log.d("abc", "errrp")
//                }) {
//            }
//            VolleySingletion.getInstance(context).addToRequestQueue(oRequest)
//        }

    }
}