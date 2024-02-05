from django.urls import re_path
from invoices import views

urlpatterns = [
    re_path(r'^invoices/$', views.invoice_list),
    re_path(r'^invoices/(?P<pk>[0-9]+)/$', views.invoice_detail),
]