import 'package:flutter/material.dart';
import 'package:to_do_app/phonpay.dart';
import 'ToDoApp.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return  MaterialApp(
     
      home:  FlutterDevs(),
      debugShowCheckedModeBanner: false,
    );
  }
}
