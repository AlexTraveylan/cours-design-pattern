from django.urls import path
from . import views

app_name = "movies"  # Namespace pour les URLs de l'application

urlpatterns = [
    # Page d'accueil (liste des films)
    path("", views.MovieListView.as_view(), name="movie_list"),
    # Page de détail d'un film
    # Le <int:pk> capture un nombre entier qui sera passé à la vue comme paramètre pk
    path("<int:pk>/", views.MovieDetailView.as_view(), name="movie_detail"),
    # Page pour créer une nouvelle critique
    path(
        "<int:movie_id>/review/", views.ReviewCreateView.as_view(), name="review_create"
    ),
    path(
        "recommended/", views.RecommendedMoviesView.as_view(), name="recommended_movies"
    ),
]
