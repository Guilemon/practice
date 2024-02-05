from django.urls import re_path
from news import views

urlpatterns = [
    re_path(r'^$', views.article_list, name='article_list'),
    re_path(r'^feeds/$',views.feeds_list, name='feeds_list'),
    re_path(r'^feeds/new', views.new_feed, name='new_feed')
]