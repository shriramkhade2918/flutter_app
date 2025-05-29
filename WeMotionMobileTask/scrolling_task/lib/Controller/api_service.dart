import 'dart:convert';
import 'dart:developer';

import 'package:http/http.dart' as http;
import '../Model/VideoFeedDataModel.dart';
import 'package:scrolling_task/Model/VideoResponceModel.dart';

class ApiService {
  static const baseUrl = 'https://api.wemotions.app';

  static Future<List<VideoFeedData>> fetchFeeds(int page) async {
    final response = await http.get(
      Uri.parse('https://api.wemotions.app/feed?page=$page'),
    );

    if (response.statusCode == 200) {
      final Map<String, dynamic> jsonMap = json.decode(response.body);

      // ✅ Fix: access the 'data' list from inside the map
      // log("message")l
      final List<dynamic> dataList = jsonMap['posts'];
      log("$dataList");

      return dataList.map((json) => VideoFeedData.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load Data');
    }
  }

  static Future<List<VideoResponce>> fetchReplies(String postId) async {
    final response = await http.get(
      Uri.parse('https://api.wemotions.app/posts/$postId/replies'),
    );

    if (response.statusCode == 200) {
      final Map<String, dynamic> jsonMap = json.decode(response.body);
      final List<dynamic> dataList = jsonMap['post'];

      return dataList.map((json) => VideoResponce.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load responce');
    }
  }
}
