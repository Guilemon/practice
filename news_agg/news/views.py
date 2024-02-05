from django.shortcuts import render, redirect
from .models import Feed, Article
from .forms import FeedForm
import feedparser
import datetime


def article_list(request):
    articles = Article.objects.all()
    return render(request, 'news/articles_list.html', {'articles': articles})

def feeds_list(request):
    feeds = Feed.objects.all()
    return render(request, 'news/feeds_list.html', {'feeds': feeds})

def new_feed(request):
    if request.method == 'POST':
        form = FeedForm(request.POST)
        if form.is_valid():
            feed = form.save(commit=False)

            check_existing = Feed.objects.filter(url = feed.url)

            if len(check_existing) == 0:
                feedData = feedparser.parse(feed.url)
                # print(feedData)
                feed.title = feedData.feed.title
                feed.save()

                for entry in feedData.entries:
                    article = Article()
                    article.url = entry.link
                    article.title = entry.title
                    article.description = entry.description
                    article.feed = feed

                    # print(entry.published_parsed)

                    p_date = datetime.datetime(*(entry.published_parsed[0:6]))
                    date_str = p_date.strftime('%Y-%m-%d %H:%M:%S')
                    article.publication_date = date_str
                    article.save()

            return redirect('feeds_list')
    else:
        form = FeedForm()
    return render(request, 'news/new_feed.html', {'form':form})