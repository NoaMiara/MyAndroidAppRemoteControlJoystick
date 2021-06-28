# Android App Remote Control Joystick

Android application that implements a joystick that controls the FlightGear (Flight Simulator) software. 

## Architecture
This App based on MVVM software architectural pattern that has three main parts that run it, each part with its own designated responsibilities. </br>
The Model interacts with FlightGear via TCP connection, continuously send and read data request and notifies the relevant ViewModel when it's data changed. </br>
Next, the ViewModels process the changed data and notifies the Views about the changed data. </br>
The View then react to the changed data accordingly and shows them.
* Model: responsible for connect to flightGear and send requests to it.
* View:  responsible for showing the joystick and the seekBars to the screen.
* View Model: responsible to connect between the view and the model.

## Features

The main_activity window contains 2 fields for entering IP & Port, as well as a CONNECT butten that is responsible for connecting to the flight simulator. </br>


![app windows](https://user-images.githubusercontent.com/71879700/123542599-22246500-d753-11eb-988e-09e8c777c725.png)

This window displays also the Joystick which allows the user to change the aileron, elevator, rudder and throttle values using a joystick and two seek bars, and responsible for controlling the plane's flight.</br>

* The aileron movement in values [-1, 1]. </br>
* The elevator movement in values [-1, 1].</br>
* The rudder movement in values [-1, 1].</br>
* The throttle movement in values [0, 1].</br>

The joystick sends SET commands to the flight simulator via TCP/IP communication protocol when the app is the client while the simulator is the server.</br>
The connection to the server is created when the Activity is created and is closed when the Activity is destroyed.</br>

## Installation
1. Download & install FlightGear v2020.3.6. </br>
2. Use Android Studio

## UML

![Android_App_Remote_Control_Joystick Diagram (2)](https://user-images.githubusercontent.com/71879700/123549483-f2388a00-d771-11eb-8188-18d527a382d1.png)

## Video

https://www.youtube.com/watch?v=bjmH2tU3iXo

## Developer
* Noa Miara
