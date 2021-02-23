package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<BaseHolder> {

    public static final int POLITICS_TYPE = 1;
    public static final int BUSINESS_TYPE = 2;
    public static final int OPINION_TYPE = 3;
    public static final int UK_NEWS_TYPE = 4;
    public static final int OTHER_TYPE = 5;

    @NonNull
    private List<Article> articles;

    NewsAdapter() {
        articles = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        switch (articles.get(position).sectionName) {
            case "Politics":
                return POLITICS_TYPE;
            case "Business":
                return BUSINESS_TYPE;
            case "Opinion":
                return OPINION_TYPE;
            case "UK news":
                return UK_NEWS_TYPE;
            default:
                return OTHER_TYPE;
        }
    }

    @NonNull
    @Override
    public BaseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case POLITICS_TYPE:
            case BUSINESS_TYPE:
            case UK_NEWS_TYPE:
                View itemView = inflater.inflate(R.layout.recyclerview_news_item, parent, false);
                return new ArticleNewsHolder(itemView);
            case OPINION_TYPE:
                View opinionItemView = inflater.inflate(R.layout.recyclerview_opinion_item, parent, false);
                return new ArticleOpinionHolder(opinionItemView);
            default:
                View othersItemView = inflater.inflate(R.layout.recyclerview_other_item, parent, false);
                return new ArticleOthersHolder(othersItemView);
        }
    }

    //polimorfism tut'
    @Override
    public void onBindViewHolder(@NonNull BaseHolder holder, int position) {
        Article article = articles.get(position);
        holder.bind(article);
    }

    void setArticles(@NonNull List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}