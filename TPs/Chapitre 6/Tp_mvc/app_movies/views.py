from django.views.generic import ListView, DetailView, CreateView
from django.contrib.auth.mixins import LoginRequiredMixin

from app_movies.models import Movie, Review
from django.contrib.auth import login
from django.shortcuts import render, redirect
from .forms import UserRegistrationForm
from django.db.models import Avg, Count, Q


def register(request):
    if request.method == "POST":
        form = UserRegistrationForm(request.POST)
        if form.is_valid():
            user = form.save()
            login(request, user)
            return redirect("movies:movie_list")
    else:
        form = UserRegistrationForm()
    return render(request, "registration/register.html", {"form": form})


class MovieListView(ListView):
    model = Movie
    template_name = "movies/movie_list.html"
    context_object_name = "movies"


class MovieDetailView(DetailView):
    model = Movie
    template_name = "movies/movie_detail.html"
    context_object_name = "movie"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["reviews"] = self.object.review_set.all().order_by("-created_at")
        return context


class ReviewCreateView(LoginRequiredMixin, CreateView):
    model = Review
    fields = ["rating", "comment"]
    template_name = "movies/review_form.html"

    def form_valid(self, form):
        form.instance.movie_id = self.kwargs["movie_id"]
        form.instance.reviewer = self.request.user
        return super().form_valid(form)


class RecommendedMoviesView(LoginRequiredMixin, ListView):
    model = Movie
    template_name = "movies/recommended_movies.html"
    context_object_name = "recommended_movies"

    def get_queryset(self):
        # Récupérer les films que l'utilisateur a bien notés (4 ou 5 étoiles)
        user_liked_movies = Review.objects.filter(
            reviewer=self.request.user, rating__gte=4
        ).values_list("movie", flat=True)

        # Trouver les films similaires basés sur les critiques des autres utilisateurs
        # qui ont aimé les mêmes films que l'utilisateur actuel
        similar_users = (
            Review.objects.filter(movie__in=user_liked_movies, rating__gte=4)
            .exclude(reviewer=self.request.user)
            .values_list("reviewer", flat=True)
        )

        # Obtenir les recommandations
        recommended = (
            Movie.objects.exclude(
                # Exclure les films déjà vus par l'utilisateur
                review__reviewer=self.request.user
            )
            .filter(
                # Inclure les films appréciés par des utilisateurs similaires
                Q(review__reviewer__in=similar_users) & Q(review__rating__gte=4)
            )
            .annotate(avg_rating=Avg("review__rating"), review_count=Count("review"))
            .filter(
                # Filtrer les films avec au moins 2 critiques
                review_count__gte=2
            )
            .order_by("-avg_rating", "-review_count")
            .distinct()
        )

        return recommended[:4]  # Retourner les 4 meilleures recommandations
