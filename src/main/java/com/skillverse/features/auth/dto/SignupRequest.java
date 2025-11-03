package com.skillverse.features.auth.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SignupRequest(String email, String password, String role, String name) {}

