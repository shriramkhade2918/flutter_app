import 'package:flutter/material.dart';
import 'Question3.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home:question(),
      debugShowCheckedModeBanner:false,
    );
  }
}
