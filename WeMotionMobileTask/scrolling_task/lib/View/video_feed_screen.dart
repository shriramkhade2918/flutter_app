import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:scrolling_task/Model/VideoFeedDataModel.dart';
import 'package:scrolling_task/Model/VideoResponceModel.dart';

import '../Controller/api_service.dart';
import '../Controller/video_player_widget.dart';

class VideoFeedScreen extends StatefulWidget {
  @override
  _VideoFeedScreenState createState() => _VideoFeedScreenState();
}

class _VideoFeedScreenState extends State<VideoFeedScreen> {
  int _page = 1;
  List<VideoFeedData> _feedsData = [];
  bool _isLoadingFeedsData = false;

  Map<String, List<VideoResponce>> _replies = {};

  final PageController _verticalPageController = PageController();

  @override
  void initState() {
    super.initState();
    _loadFeeds();

    _verticalPageController.addListener(() {
      // If near end vertically, load more feeds
      if (_verticalPageController.position.pixels >=
          _verticalPageController.position.maxScrollExtent - 300) {
        _loadFeeds();
      }
    });
  }

  Future<void> _loadFeeds() async {
    if (_isLoadingFeedsData) return;
    setState(() => _isLoadingFeedsData = true);

    try {
      List<VideoFeedData> newFeeds = await ApiService.fetchFeeds(_page);
      setState(() {
        _feedsData.addAll(newFeeds);
        _page++;
      });
    } catch (e) {
      print("Error loading feedsData: $e");
    }

    setState(() => _isLoadingFeedsData = false);
  }

  Future<void> _loadReplies(String postId) async {
    if (_replies.containsKey(postId)) return;

    try {
      List<VideoResponce> fetchedReplies = await ApiService.fetchReplies(
        postId,
      );
      setState(() {
        _replies[postId] = fetchedReplies;
      });
    } catch (e) {
      print("Error loading responce: $e");
    }
  }

  @override
  void dispose() {
    _verticalPageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    if (_feedsData.isEmpty) {
      return Scaffold(
        appBar: AppBar(
          // centerTitle: true,
          title: Text('Shorts', style: TextStyle(fontWeight: FontWeight.bold)),
        ),
        body: Center(child: CircularProgressIndicator()),
      );
    }

    return Scaffold(
      // appBar: AppBar(title: Text('Video App')),
      body: PageView.builder(
        scrollDirection: Axis.vertical,
        controller: _verticalPageController,
        itemCount: _feedsData.length + (_isLoadingFeedsData ? 1 : 0),
        itemBuilder: (context, index) {
          if (index == _feedsData.length) {
            return Center(child: CircularProgressIndicator());
          }

          final feed = _feedsData[index];

          // Load replies on first build of this page
          if (!_replies.containsKey(feed.id)) {
            log("Replay present");
            _loadReplies(feed.id);
          }

          final replies = _replies[feed.id] ?? [];

          return Stack(
            children: [
              // Horizontal PageView of replies inside this feed
              PageView.builder(
                scrollDirection: Axis.horizontal,
                itemCount: replies.isEmpty ? 1 : replies.length,
                itemBuilder: (context, replyIndex) {
                  if (replies.isEmpty) {
                    // Show main feed video if no replies
                    log("message1");
                    return CustomVideoPlayer(videoUrl: feed.videoUrl);
                  } else {
                    // Show reply video
                    log("message2");
                    return CustomVideoPlayer(
                      videoUrl: replies[replyIndex].videoUrl,
                    );
                  }
                },
              ),
              Positioned(
                bottom: MediaQuery.of(context).size.height * 0.9,
                left: MediaQuery.of(context).size.width * 0.06,
                right: 20,
                child: Text(
                  "Shorts",
                  style: TextStyle(
                    fontSize: 21,
                    fontWeight: FontWeight.bold,
                    color: Colors.black,
                  ),
                ),
              ),
              Positioned(
                bottom: MediaQuery.of(context).size.height / 3,
                left: MediaQuery.of(context).size.width - 50,
                right: 20,
                child: Column(
                  children: [
                    Icon(Icons.favorite_border, size: 31, color: Colors.white),
                    Text(
                      feed.like,
                      style: TextStyle(fontSize: 14, color: Colors.white),
                    ),
                  ],
                ),
              ),
              Positioned(
                bottom: MediaQuery.of(context).size.height / 3.9,
                left: MediaQuery.of(context).size.width - 50,
                right: 20,
                child: Column(
                  children: [
                    Icon(Icons.comment, size: 31, color: Colors.white),
                    Text(
                      feed.msg,
                      style: TextStyle(fontSize: 14, color: Colors.white),
                    ),
                  ],
                ),
              ),
              Positioned(
                bottom: MediaQuery.of(context).size.height / 5.3,
                left: MediaQuery.of(context).size.width - 50,
                right: 20,
                child: Column(
                  children: [
                    Icon(Icons.share, size: 31, color: Colors.white),
                    Text(
                      feed.share,
                      style: TextStyle(fontSize: 14, color: Colors.white),
                    ),
                  ],
                ),
              ),
              Positioned(
                bottom: MediaQuery.of(context).size.height / 7.2,
                left: MediaQuery.of(context).size.width - 50,
                right: 20,
                child: Column(
                  children: [
                    Icon(
                      Icons.bookmark_add_outlined,
                      size: 35,
                      color: Colors.white,
                    ),
                  ],
                ),
              ),
              // Overlay title at bottom
              Positioned(
                bottom: 40,
                left: 5,
                child: Row(
                  children: [
                    Container(
                      height: MediaQuery.of(context).size.width * 0.16,
                      width: MediaQuery.of(context).size.width * 0.16,
                      decoration: BoxDecoration(
                        shape: BoxShape.circle,
                        color: Colors.white,
                        image: DecorationImage(
                          fit: BoxFit.cover,
                          image: NetworkImage(feed.image),
                        ),
                      ),
                    ),
                    SizedBox(width: 15),
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        Text(
                          feed.name,
                          overflow: TextOverflow.fade,
                          // maxLines: 2,
                          softWrap: true,
                          style: TextStyle(
                            color: Colors.white,
                            fontSize: 16,

                            // overflow: TextOverflow.clip,
                          ),
                        ),
                        Container(
                          // color: Colors.black54,
                          // padding: EdgeInsets.all(4),
                          width: MediaQuery.of(context).size.width,
                          child: SizedBox(
                            // height: ,
                            child: Text(
                              feed.title,
                              overflow: TextOverflow.ellipsis,
                              // maxLines: 2,
                              softWrap: true,
                              style: TextStyle(
                                color: Colors.white,
                                fontSize: 16,

                                // overflow: TextOverflow.clip,
                              ),
                            ),
                          ),
                        ),
                      ],
                    ),
                  ],
                ),
              ),
            ],
          );
        },
      ),
    );
  }
}
