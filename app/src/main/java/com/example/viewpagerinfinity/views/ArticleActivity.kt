package com.example.viewpagerinfinity.views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.viewpagerinfinity.R
import com.example.viewpagerinfinity.models.ResponseContentArticle
import com.example.viewpagerinfinity.views.MainActivity.Companion.api
import kotlinx.android.synthetic.main.activity_article.*
import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter
import retrofit2.Call
import retrofit2.Response

class ArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val htmlHttpImageGetter = HtmlHttpImageGetter(tvHtmlContent).apply {
            enableCompressImage(true)
        }

        val id = intent.getIntExtra("id", 990)

        api.getContentAritcle(id).enqueue(object : retrofit2.Callback<ResponseContentArticle> {
            override fun onFailure(call: Call<ResponseContentArticle>, t: Throwable) {
            }

            override fun onResponse(call: Call<ResponseContentArticle>, response: Response<ResponseContentArticle>) {

                val string = response.body()?.article?.content ?: ""

                tvHtmlContent.setHtml(string, htmlHttpImageGetter)
            }
        })
    }
}
