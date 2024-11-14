from django.contrib import admin
from django.urls import path, include
from django.views.generic import RedirectView
from app_movies.views import register

urlpatterns = [
    # Interface d'administration
    path("admin/", admin.site.urls),
    # Inclusion des URLs de l'application app_movies
    path("movies/", include("app_movies.urls")),
    # Redirection de la page d'accueil vers la liste des films
    path("", RedirectView.as_view(url="/movies/", permanent=True)),
    # URLs d'authentification (login, logout, etc.)
    path("accounts/", include("django.contrib.auth.urls")),
    path("register/", register, name="register"),
]
