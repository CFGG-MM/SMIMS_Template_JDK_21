const String DELIMITER_ARDUINO_TO_JAVA_START = "#";
const String DELIMITER_ARDUINO_TO_JAVA_END = "?";

int counter = 1;
String data = "";

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {

  // put your main code here, to run repeatedly:
  if(counter > 10) {
    counter = 1;
  }

  data = "Hallo! " + counter;
  sendData(data);

  delay(500); // 500 ms Pause

}

void sendData(String data) {
    Serial.println(DELIMITER_ARDUINO_TO_JAVA_START + data + DELIMITER_ARDUINO_TO_JAVA_END);
    Serial.flush();
}
