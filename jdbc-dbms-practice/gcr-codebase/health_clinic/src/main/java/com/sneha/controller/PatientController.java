package com.sneha.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.sneha.model.Patient;
import com.sneha.service.PatientService;

public class PatientController {
  private static final Logger LOGGER = Logger.getLogger(PatientController.class.getName());
  private static final String DOB_FORMAT = "yyyy-MM-dd";
  
  private final PatientService service;
  private final Scanner scanner;

  public PatientController() {
    this.service = new PatientService();
    this.scanner = new Scanner(System.in);
  }

  public void registerPatient() {
    try {
      String name = getInput("Name: ");
      LocalDate dob = getDobInput("DOB (" + DOB_FORMAT + "): ");
      String phone = getInput("Phone: ");
      String email = getInput("Email: ");
      String address = getInput("Address: ");
      String blood = getInput("Blood Group: ");

      if (!validateInputs(name, phone, email, address, blood)) {
        LOGGER.warning("Invalid inputs provided");
        return;
      }

      Patient patient = new Patient(name, email, dob, phone, address, blood);
      service.registerPatient(patient);

      LOGGER.info("Patient registered successfully!");

    } catch (DateTimeParseException e) {
      LOGGER.severe("Invalid date format. Please use " + DOB_FORMAT);
    } catch (Exception e) {
      LOGGER.severe("Error during patient registration: " + e.getMessage());
    }
  }

  private String getInput(String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine().trim();
    if (input.isEmpty()) {
      throw new IllegalArgumentException("Input cannot be empty");
    }
    return input;
  }

  private LocalDate getDobInput(String prompt) throws DateTimeParseException {
    System.out.print(prompt);
    String dobString = scanner.nextLine().trim();
    if (dobString.isEmpty()) {
      throw new IllegalArgumentException("Date of birth cannot be empty");
    }
    return LocalDate.parse(dobString);
  }

  private boolean validateInputs(String name, String phone, String email, 
                                  String address, String blood) {
    if (name == null || name.isEmpty()) {
      LOGGER.warning("Name cannot be empty");
      return false;
    }
    if (phone == null || !phone.matches("\\d{10}")) {
      LOGGER.warning("Phone must be 10 digits");
      return false;
    }
    if (email == null || !email.contains("@")) {
      LOGGER.warning("Invalid email format");
      return false;
    }
    if (address == null || address.isEmpty()) {
      LOGGER.warning("Address cannot be empty");
      return false;
    }
    if (blood == null || blood.isEmpty()) {
      LOGGER.warning("Blood group cannot be empty");
      return false;
    }
    return true;
  }

  public void closeScanner() {
    if (scanner != null) {
      scanner.close();
    }
  }
}
