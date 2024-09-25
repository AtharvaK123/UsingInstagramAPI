package com.example;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String accessToken = "0e6d22373e3964263dfab5b760410868";

        InstagramAPI instagramAPI = new InstagramAPI(accessToken);
        try {
            // Fetch user profile
            JsonNode userProfile = instagramAPI.getUserProfile();
            System.out.println("User Profile: " + userProfile);

            // Fetch media and extract usernames
            JsonNode media = instagramAPI.getUserMedia();
            List<String> mediaUsernames = new ArrayList<>();
            media.forEach(item -> mediaUsernames.add(item.get("username").asText()));

            // Simulate another list of usernames (this would typically come from another source)
            List<String> otherUsernames = List.of("user1", "user2", "user3", "username_from_media"); // Replace with actual data

            // Find mutual usernames
            List<String> mutuals = MutualFinder.findMutuals(otherUsernames, mediaUsernames);
            System.out.println("Mutual Users: " + mutuals);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
