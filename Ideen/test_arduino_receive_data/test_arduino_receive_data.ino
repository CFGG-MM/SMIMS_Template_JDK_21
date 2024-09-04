const char DELIMITER_ARDUINO_TO_JAVA_START = '#';
const char DELIMITER_ARDUINO_TO_JAVA_END = '?';
const char DELIMITER_JAVA_TO_ARDUINO_START = '^';
const char DELIMITER_JAVA_TO_ARDUINO_END = '!';

void setup() {
  // put your setup code here, to run once:

  // Start the serial communication at a baud rate of 9600
  Serial.begin(9600);
  while (!Serial) {
    ; // Wait for the serial port to connect. Needed for native USB port only
  }
  
 sendData("Arduino_is_ready_to_receive_data.");

}

void loop() {
  // put your main code here, to run repeatedly:

  // Check if there is any data available to read
  if (Serial.available() > 0) {
    // Read the incoming string until the newline character '?''
    String incomingString = Serial.readStringUntil(DELIMITER_JAVA_TO_ARDUINO_END);
    
    // Print the received string to the serial monitor
    sendData("Arduino_got:");
    sendData(incomingString);
  }

  delay(20);

}

void sendData(String data) {
  Serial.println(DELIMITER_ARDUINO_TO_JAVA_START + data + DELIMITER_ARDUINO_TO_JAVA_END);
}