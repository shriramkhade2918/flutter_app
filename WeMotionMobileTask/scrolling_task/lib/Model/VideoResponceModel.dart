class VideoResponce {
  final String id;
  final String videoUrl;

  VideoResponce({required this.id, required this.videoUrl});

  factory VideoResponce.fromJson(Map<String, dynamic> json) {
    return VideoResponce(
      id: json['id'].toString(),
      videoUrl: json['video_link'] ?? '',
    );
  }
}
