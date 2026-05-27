package com.scalesec.vulnado;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Cowsay {
public static validate (String input){
  if (input == null) return null;

  StringBuilder encoded = new StringBuilder();
  for (int i=0; i<input.length(); i++){
    char ch = input.charAt(i);
    encoded.append("&#').append((int) ch).append(";");
  }
  return encoded.toString();
}
  
  public static String run(String input) {
    ProcessBuilder processBuilder = new ProcessBuilder();
    String validatedInput = validate(input);
    String cmd = "/usr/games/cowsay '" + validatedInput + "'";
    System.out.println(cmd);
    processBuilder.command("bash", "-c", cmd);

    StringBuilder output = new StringBuilder();

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line + "\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return output.toString();
  }
}
