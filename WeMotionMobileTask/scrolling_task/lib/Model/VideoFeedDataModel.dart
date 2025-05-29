class VideoFeedData {
  final String id;
  final String videoUrl;
  final String title;
  final String name;
  final String like;
  final String msg;
  final String share;
  final String image;

  VideoFeedData({
    required this.id,
    required this.videoUrl,
    required this.title,
    required this.name,
    required this.like,
    required this.msg,
    required this.share,
    required this.image,
  });

  factory VideoFeedData.fromJson(Map<String, dynamic> json) {
    return VideoFeedData(
      id: json['id'].toString(),
      name: "${json['first_name'].toString()} ${json['last_name'].toString()}",
      like: json['voting_count'].toString(),
      msg: json['comment_count'].toString(),
      share: json['share_count'].toString(),
      image: json['thumbnail_url'].toString(),
      videoUrl: json['video_link'] ?? '',
      title: json['title'] ?? '',
    );
  }
}
