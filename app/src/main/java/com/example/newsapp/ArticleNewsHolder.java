package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;

public class ArticleNewsHolder extends BaseHolder {

    private final TextView tvWebTitle;
    private final TextView tvWebPublicationDate;
    private final TextView tvSectionName;

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private Article article;

    public ArticleNewsHolder(@NonNull View itemView) {
        super(itemView);
        tvWebTitle = itemView.findViewById(R.id.web_title);
        tvWebPublicationDate = itemView.findViewById(R.id.publication_date);
        tvSectionName = itemView.findViewById(R.id.section_name);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(article.webUrl));
                v.getContext().startActivity(browserIntent);
            }
        });
    }

    @Override
    public void bind(@NotNull Article article) {
        this.article = article;
        this.tvWebTitle.setText(article.webTitle);
        this.tvWebPublicationDate.setText(formatter.format(article.webPublicationDate));
        this.tvSectionName.setText(article.sectionName);
    }
}
