from django.contrib import admin
from .models import Movie, Review  # Assurez-vous que le chemin est correct


class MovieAdmin(admin.ModelAdmin):
    list_display = ("title", "release_date", "created_at")
    search_fields = ("title", "description")


class ReviewAdmin(admin.ModelAdmin):
    list_display = ("movie", "reviewer", "rating", "created_at")
    search_fields = ("movie__title", "reviewer__username", "comment")
    list_filter = ("movie", "rating", "created_at")


admin.site.register(Movie, MovieAdmin)
admin.site.register(Review, ReviewAdmin)
