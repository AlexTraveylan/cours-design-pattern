class AudioSubsystem:
    def play_audio(self, filename: str) -> None:
        print(f"Playing audio file: {filename}")


class VideoSubsystem:
    def play_video(self, filename: str) -> None:
        print(f"Playing video file: {filename}")


class SubtitleSubsystem:
    def show_subtitle(self, filename: str) -> None:
        print(f"Showing subtitles from file: {filename}")


class MediaFacade:
    def __init__(self) -> None:
        self.audio_system = AudioSubsystem()
        self.video_system = VideoSubsystem()
        self.subtitle_system = SubtitleSubsystem()

    def play_media(self, media_file: str, subtitle_file: str) -> None:
        print("Initializing media playback...")
        self.audio_system.play_audio(media_file)
        self.video_system.play_video(media_file)
        if subtitle_file:
            self.subtitle_system.show_subtitle(subtitle_file)
        print("Media playback started.")


# Exemple d'utilisation du pattern Facade
if __name__ == "__main__":
    media_facade = MediaFacade()
    media_facade.play_media("example_movie.mp4", "example_subtitles.srt")
